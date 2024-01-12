package junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class CheckboxTest {
    WebDriver driver ;
    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

//  https://testotomasyonu.com/form
// b. Sirt Agrisi ve Carpinti checkbox’larini secin
// c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
// d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin

    @Test
    public void  checkbowText(){
        //1. visit web site
        driver.get("https://testotomasyonu.com/form");

        // 2. Choose 'Sirt Agrisi' from checkbox'

        WebElement sirtAgrisiTextElement= driver.findElement(By.xpath("//*[@for='gridCheck5']"));
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,400).perform();
        sirtAgrisiTextElement.click();

        //Check 'sirt agrisi' is selected
        WebElement sirtAgrisiBoxElement= driver.findElement(By.id("gridCheck5"));
        Assert.assertTrue(sirtAgrisiBoxElement.isSelected());

        //Check 'seker' is not selected
        WebElement sekeBoxElement= driver.findElement(By.id("hastalikCheck2"));
        Assert.assertFalse(sekeBoxElement.isSelected());


    }
}
