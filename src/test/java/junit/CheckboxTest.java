package junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
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
        WebDriverManager.chromedriver().setup();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
    @After
    public void tearDown(){
    driver.quit();

    }
// Test1
//  https://testotomasyonu.com/form
// b. Sirt Agrisi ve Carpinti checkbox’larini secin
// c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
// d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin

    @Test
    public void  checkbowText() {
        //1. visit web site
        driver.get("https://testotomasyonu.com/form");

        // 2. Choose 'Sirt Agrisi' from checkbox'

        WebElement sirtAgrisiTextElement = driver.findElement(By.xpath("//*[@for='gridCheck5']"));
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, 400).perform();
        sirtAgrisiTextElement.click();

        //Check 'sirt agrisi' is selected
        WebElement sirtAgrisiBoxElement = driver.findElement(By.id("gridCheck5"));
        Assert.assertTrue(sirtAgrisiBoxElement.isSelected());

        //Check 'seker' is not selected
        WebElement sekeBoxElement = driver.findElement(By.id("hastalikCheck2"));
        Assert.assertFalse(sekeBoxElement.isSelected());
    }

        // Test2
    // Go to given web page
    // https://the-internet.herokuapp.com/checkboxes
    //Locate the checkbox1 and checbox2 elements
    // click the checkbox1  if is not selected
    // click the checkbox2 if is not selected
        @Test
        public void test02(){
        String url ="https://the-internet.herokuapp.com/checkboxes";
        driver.get(url);
        WebElement checbox1Element= driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checbox2Element= driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        if (!checbox1Element.isSelected()){
            checbox1Element.click();
        }
            if (!checbox2Element.isSelected()){
                checbox2Element.click();
            }
            Assert.assertTrue(checbox1Element.isSelected() && checbox2Element.isSelected());
        }



    }

