package junit;

import com.github.javafaker.Faker;
import junit.utilities.TestBase;
import org.checkerframework.checker.units.qual.Acceleration;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FakerFileTest extends TestBase {

    @Test
    public void facebookTesti() {
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

        //2- Cookies kabul edin
        driver.findElement(By.xpath("//*[@data-testid='cookie-policy-manage-dialog-accept-button']")).click();

        //3- Yeni hesap olustur butonuna basalim
        WebElement createAccountElement = driver.findElement(By.xpath("//*[@data-testid='open-registration-form-button']"));
        createAccountElement.click();

        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement firstName= driver.findElement(By.xpath("//*[@name='firstname']"));
        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        actions.click(firstName).sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Mar")
                .sendKeys(Keys.TAB)
                .sendKeys("10")
                .sendKeys(Keys.TAB)
                .sendKeys("1990")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();



    }
}