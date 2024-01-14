package junit;

import junit.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JsAlerts extends TestBase {


    @Test
    public void test01() {
        //1. Test
        //	-  https://testotomasyonu.com/javascriptAlert adresine gidin
        String url = "https://testotomasyonu.com/javascriptAlert ";
        driver.get(url);

        //	- 1.alert'e tiklayin
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();


        //	-  Alert'deki yazinin "I am a JS Alert" oldugunu test edin

        String expextedAlertText = "I am a JS Alert";
        String actualAlertText = driver.switchTo().alert().getText();

        Assert.assertEquals(expextedAlertText, actualAlertText);

        //	-  OK tusuna basip alert'i kapatin

        driver.switchTo().alert().accept();

    }

    @Test
    public void test02() throws InterruptedException {

        //2.Test
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin
        String url = "https://testotomasyonu.com/javascriptAlert";
        driver.get(url);

        //	- 2.alert'e tiklayalim jsConfirm()
        Thread.sleep(5);
        WebElement jsalert2ButtonElement =driver.findElement(By.xpath("//*[@onclick='jsConfirm()']"));
        click(jsalert2ButtonElement);

        //	- Cancel'a basip,
        driver.switchTo().alert().dismiss();

        //	cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin

        String expectedResultText = "You clicked: Cancel";
        String actualResultText = driver.findElement(By.xpath("//*[@id='result']")).getText();

        Assert.assertEquals(expectedResultText, actualResultText);


    }
    @Test
    public void test03() {

        //3.Test
        //	- https://testotomasyonu.com/javascriptAlert adresine gidin
        String url = "https://testotomasyonu.com/javascriptAlert ";
        driver.get(url);

        //	- 3.alert'e tiklayalim
        WebElement jsalert3Element = driver.findElement(By.xpath("//*[@onclick='jsPrompt()']"));
        click(jsalert3Element);

        //	- Cikan prompt ekranina "Test" yazdiralim
        driver.switchTo().alert().sendKeys("Test");

        //	- OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();

        //	- Cikan sonuc yazisinin "Test" icerdigini test edelim
        String expectedResultContainsText = "Test";
        String actualResultText = driver.findElement(By.xpath("//*[@id='result']")).getText();

        Assert.assertTrue(actualResultText.contains(expectedResultContainsText));

    }  public void click(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(element));
        element.click();
    }
}