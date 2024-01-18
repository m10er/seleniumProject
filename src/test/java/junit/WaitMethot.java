package junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitMethot {



        @Test
        public void implicitlyWaitTest(){
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            //1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
            driver.get("https://the-internet.herokuapp.com/dynamic_controls");

            //4. Remove butonuna basin.  //*[.='Remove']  //*[text()='Remove']
            driver.findElement(By.xpath("//*[.='Remove'] ")).click();

            //5. “It’s gone!” mesajinin goruntulendigini dogrulayin. id= message  //*[text()="It's gone!"]
            WebElement itsGoneTextElement = driver.findElement(By.id("message"));
            Assert.assertTrue(itsGoneTextElement.isDisplayed());
            //6. Add buttonuna basin
            driver.findElement(By.xpath("//*[.='Add']")).click();
            //7. It’s back mesajinin gorundugunu test edin
            WebElement itsBackElementi = driver.findElement(By.xpath("//*[.=\"It's back!\"]"));
            Assert.assertTrue(itsBackElementi.isDisplayed());
            driver.quit();

        }

        @Test
        public void explicitlyWaitTest(){
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
            driver.get("https://the-internet.herokuapp.com/dynamic_controls");

            //4. Remove butonuna basin.
            driver.findElement(By.xpath("//*[text()='Remove']")).click();

            //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.

            /*

            // 1.adim : bir wait objesi olusturun
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
            // 2.adim : bekleyecegimiz webelement'i locate edin
        WebElement itsGoneyaziElementi = driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));
            // 3.adim : wait objesini kullanarak istediginiz webelement uzerinde islem yapin
        wait.until(ExpectedConditions.visibilityOf(itsGoneyaziElementi));

             */

            // 1.adim : bir wait objesi olusturun
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
            // 2. adim : bekleme icin olusturdugumuz wait objesini kullanarak
            //           beklenecek webElementin locate'ini ve beklemeyi birlikte yapariz

            WebElement itsGoneyaziElementi =
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));

            //6. Add buttonuna basin
            driver.findElement(By.xpath("//*[text()=\"Add\"]")).click();

            //7. It’s back mesajinin gorundugunu test edin
            WebElement itsBackElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's back!\"]")));
            driver.quit();


        }
    @Test
    public void explicitlyWaitTest02(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textboxElementi = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textboxElementi.isEnabled());

        //5. Enable butonuna tıklayın
        driver.findElement(By.xpath("//*[text()='Enable']")).click();

        //ve textbox etkin oluncaya kadar bekleyin
        // 1.adim : wait objesi olustur
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // 2.adim : mumkunse kullanilacak webelementi locate et
        //          biz textbox'in kullanilabilir olmasini bekleyecegiz, textbox locate edildi

        // 3.adim : wait objesi ile istenen webelement uzerinde expected condition bekle
        wait.until(ExpectedConditions.elementToBeClickable(textboxElementi));

        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itsEnabledElementi = driver.findElement(By.xpath("//*[text()=\"It's enabled!\"]"));

        //7. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assert.assertTrue(itsEnabledElementi.isEnabled());

        driver.quit();
    }
}
