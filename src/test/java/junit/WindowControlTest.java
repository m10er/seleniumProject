package junit;

import junit.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class WindowControlTest extends TestBase {
    @Test
    public void  test01(){
        // Testotomasyonu anasayfaya gidin

        driver.get("https://www.testotomasyonu.com");
        String mainPageWHD = driver.getWindowHandle();

        // url'in testotomasyonu icerdigini test edin
        Assert.assertTrue(driver.getCurrentUrl().contains("testotomasyonu"));


        // yeni bir tab olarak elctronics linkini acin
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.testotomasyonu.com");
        driver.findElement(By.xpath("(//a[text()='Electronics'])[3]")).click();
        String electronicsWHD= driver.getWindowHandle();


        // acilan sayfanin electronics sayfasi oldugunu test edin
        // Title'da Electronics oldugunu test edelim

        Assert.assertTrue(driver.getTitle().contains("Electronics"));


        // yeni bir window'da acilacak sekilde menfashion linkini tiklayin

        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.testotomasyonu.com");
        driver.findElement(By.xpath("(//a[text()='Men Fashion'])[3]")).click();
        String manFashionWHD = driver.getWindowHandle();


        // menfashion sayfasinin acildigini test edin
        Assert.assertTrue(driver.getTitle().contains("Men"));

        // EGER bir test'de acilan windowlar farkli tab veya window'larda aciliyorsa
        // ve testimizde bu sayfalar arasinda gecis isteniyorsa
        // gectigimiz her sayfanin WindowHandleDegerini kaydetmeliyiz

        // test otomasyon anasayfada oldugumuzu test edin
        driver.switchTo().window(mainPageWHD);

        // url ile test edelim https://testotomasyonu.com/
        Assert.assertTrue(driver.getCurrentUrl().contains("testotomasyonu.com"));

        // tekrar electronics acik olan tab'a gecin
        driver.switchTo().window(electronicsWHD);


        // electronics bolumunde oldugunuzu test edin

        Assert.assertTrue(driver.getTitle().contains("Electronic"));

        // tekrar men fashion acik olan tab'a gecin
        driver.switchTo().window(manFashionWHD);


        // men fashion bolumunde oldugunuzu test edin
        Assert.assertTrue(driver.getTitle().contains("Men"));

    }
}
