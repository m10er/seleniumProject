package junit;

import junit.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class LocateElemetn extends TestBase {
    @Test
    public void test01(){

        // https://www.amazon.com.tr/ URL git
            driver.get("https://www.amazon.com.tr/");


        // Arama butonuna iphone 11 yaz ve arama işlemini yap
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 11"+ Keys.ENTER);


        // Cerezleri kabul et
        driver.findElement(By.id("sp-cc-accept")).click();


        // Arama sonucunun iphone 11 icerip icermedigini kontrol edin
        WebElement textREsultElement= driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        System.out.println(textREsultElement.getText());

        // İlk urunun fiyatını console yazdirin
        System.out.println(driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText());



    }

}
