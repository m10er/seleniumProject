package junit;

import junit.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MovetoElement extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //1- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");

        //2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        WebElement kidsWearElement = driver.findElement(By.xpath("(//*[@class='has-sub'])[7]"));
        Thread.sleep(1000);
        Actions actions = new Actions(driver);

        actions.moveToElement(kidsWearElement).perform();
        Thread.sleep(1000);
        WebElement boyElement= driver.findElement(By.partialLinkText("Boys"));
        Thread.sleep(1000);
        //3- “Boys” linkine basin
        actions.moveToElement(boyElement).click().perform();
        Thread.sleep(1000);
        //4- Acilan sayfadaki ilk urunu tiklayin
        driver.findElement(By.xpath("(//div[@class='product-box mb-2 pb-1'])[1]")).click();

        //4- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin
        String actualTextElemenet = driver.findElement(By.xpath("//*[.='Boys Shirt White Color']")).getText();
        String expectedTexElement ="Boys Shirt White Color";

        Assert.assertEquals(expectedTexElement,actualTextElemenet);
    }
    @Test
    public void test02(){


            String url = "https://selenium08.blogspot.com/2020/01/click-and-hold.html";
        driver.get(url);

        // Locate the element C ve Element D.
        WebElement titleC = driver.findElement(By.xpath("//li[@name='C']"));
        WebElement titleD = driver.findElement(By.xpath("//li[@name='D']"));

        // C elementini D elementinin uzerinde bekletin
        Actions actions = new Actions(driver);
        actions.clickAndHold(titleC).moveToElement(titleD).perform();

        driver.close();

    }


}
