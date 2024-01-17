package junit;

import junit.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FormTest extends TestBase {

    @Test
    public void kullaniciOlusturmaTesti() {

        //1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com");

        //2- Account linkine tiklayin
        // driver.findElement(By.xpath("(//span[text()='Account'])[1]")).click();
        driver.findElement(By.xpath("(//div[@class='cart-bar'])[1]")).click();

        //3- Sign Up linkine basalim
        driver.findElement(By.xpath("//*[@class='sign-up ']")).click();
        // driver.findElement(By.xpath("//*[text()=' Sign Up']")).click();

        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim
        driver.findElement(By.id("firstName")).click();
        Actions actions = new Actions(driver);

        actions.sendKeys("muammer").sendKeys(Keys.TAB)
                .sendKeys("oner").sendKeys(Keys.TAB)
                .sendKeys("muammer@gmail.com").sendKeys(Keys.TAB)
                .sendKeys("123456").sendKeys(Keys.TAB)
                .sendKeys("123456").sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        //5- Kaydin olusturuldugunu test edin

    WebElement emailElement= driver.findElement(By.xpath("//*[@id='email']"));
    emailElement.click();
    actions = new Actions(driver);
    actions.sendKeys("muammer@gmail.com").sendKeys(Keys.TAB)
            .sendKeys("123456").sendKeys(Keys.TAB)
            .sendKeys(Keys.ENTER).perform();

   String expectedloginMailElement ="muammer@gmail.com";
        String actualLoginElement = driver.findElement(By.xpath("//*[@class='profile']")).getText();

        Assert.assertTrue(actualLoginElement.contains(expectedloginMailElement));





    }
}