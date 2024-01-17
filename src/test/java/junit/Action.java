package junit;

import junit.utilities.ReusableMethods;
import junit.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Action extends TestBase {
    @Test
    public void Test01() throws InterruptedException {
        driver.get("https://testotomasyonu.com/click");
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        WebElement dronesElement =driver.findElement(By.id("hot-spot"));
        action.contextClick(dronesElement).perform();

        String alertrightClickTExt= driver.switchTo().alert().getText();
        Assert.assertEquals("Tebrikler!... Sağ click yaptınız.", alertrightClickTExt);

        driver.switchTo().alert().accept();

    }
    @Test
    public void sagClicktesti() throws InterruptedException {
        //1- https://testotomasyonu.com/click sitesine gidin
        driver.get("https://testotomasyonu.com/click");


        //2- “DGI Drones” uzerinde sag click yapin
        Actions actions = new Actions(driver);
        WebElement dgiDronesElementi = driver.findElement(By.id("hot-spot"));
        Thread.sleep(4);
        actions.contextClick(dgiDronesElementi).perform();
        //3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.

        String expectedAlertYazisi = "Tebrikler!... Sağ click yaptınız.";
        String actualAlertYazisi = driver.switchTo().alert().getText();

        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        //4- Tamam diyerek alert’i kapatalim

        driver.switchTo().alert().accept();

    }
    @Test
    public void test02(){

            //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
            driver.get("https://the-internet.herokuapp.com/context_menu");

            //3- Cizili alan uzerinde sag click yapin
            WebElement clikcElement= driver.findElement(By.id("hot-spot"));
            Actions actions = new Actions(driver);
            actions.contextClick(clikcElement).perform();

            //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
            String actualAlertText = driver.switchTo().alert().getText();
            String expectedAlerText = "You selected a context menu";

            Assert.assertEquals(expectedAlerText,actualAlertText);
            //5- Tamam diyerek alert’i kapatalim
            driver.switchTo().alert().accept();

            //6- Elemental Selenium linkine tiklayalim
            driver.findElement(By.partialLinkText("Elemental Selenium")).click();
           driver= ReusableMethods.getPageWithTitle(driver, "Elemental Selenium | Elemental Selenium");

            //7- Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test edelim
            String actualTagElement= driver.findElement(By.tagName("h1")).getText();
            String expectedTagElement = "Make sure your code lands";

            Assert.assertEquals(expectedTagElement,actualTagElement);
        }


}
