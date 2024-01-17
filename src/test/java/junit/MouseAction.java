package junit;

import junit.utilities.ReusableMethods;
import junit.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseAction extends TestBase {
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
        @Test
        public void test03(){

            // amazon ana sayfa ya gidin
            driver.get("https://www.amazon.com.tr");

                // sag ustte :Merhaba giris yapin elementinin uzerinde mouse'u bekletin
            WebElement signInElement = driver.findElement(By.xpath("//*[@data-csa-c-slot-id='nav-link-accountList']"));

            Actions actions = new Actions(driver);
            actions.moveToElement(signInElement);

            // acilan menu de Create a list linkine tiklayin
            WebElement listElement = driver.findElement(By.xpath("(//*[@class='nav-text'])[1]"));

            actions.click(listElement).perform();


            // ve Create a list sayfasini acildigini test edin
            driver= ReusableMethods.getPageWithTitle(driver,"Liste");

            String expextedTitle = "Liste";
            String actalTitle = driver.getTitle();

            Assert.assertEquals(expextedTitle,actalTitle);

        }
        @Test
        public void test04() throws InterruptedException {


            // https://html.com/tags/iframe/ sayfasina gidelim
            String url = "https://html.com/tags/iframe/";
            driver.get(url);
            Thread.sleep(1000);
            // video’yu gorecek kadar asagi inin
            Actions actions = new Actions(driver);
            actions.scrollByAmount(0,1000).perform();
            Thread.sleep(1000);
            // videoyu izlemek icin Play tusuna basin


           WebElement iframeElement= driver.findElement(By.xpath("//iframe[1]"));
          driver.switchTo().frame(iframeElement);
           Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@id='player']")).click();

            //driver.switchTo().frame(playelement);
          //  playelement.click();

            // videoyu calistirdiginizi test edin
            WebElement youtubeTextElement= driver.findElement(By.className("ytp-impression-link-text"));
            Assert.assertFalse(youtubeTextElement.isDisplayed());

            // video durdurun
            driver.findElement(By.xpath("//*[@controlslist='nodownload']")).click();

        }
    @Test
    public void test05() throws InterruptedException {

        // Go to https://demoqa.com/buttons
        driver.get("https://demoqa.com/buttons ");

        // Double click to doubleclick button

        WebElement doubleClickElement= driver.findElement(By.id("doubleClickBtn"));
        Thread.sleep(2000);

        Actions actions = new Actions(driver);

        actions.doubleClick(doubleClickElement).perform();
        Thread.sleep(2000);

        // Check the text "You have done a double click" is displayed?

        WebElement  doubleClickMessage= driver.findElement(By.id("doubleClickMessage"));

        Assert.assertTrue(doubleClickMessage.isDisplayed());

        // Right click to rightclickbutton
        WebElement rightclickElement= driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightclickElement).perform();


        //Check the text "" is displayed

        WebElement rightClickText = driver.findElement(By.id("rightClickMessage"));
        Assert.assertTrue(rightClickText.isDisplayed());

    }

}
