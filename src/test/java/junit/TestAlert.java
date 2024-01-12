package junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestAlert {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void tearyup(){
        driver.quit();
    }

    @Test
    public void test01() {

    // 1. get url
    String url = "https://the-internet.herokuapp.com/javascript_alerts";
    driver.get(url);

    // 2. allertButton1 click
    WebElement alertButton1 = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));

    click(alertButton1);

    // 3. Accept the alert
    driver.switchTo().alert().accept();

    // 4. Text check
    WebElement resultElement = driver.findElement(By.id("result"));
    String expectedResult = "You successfully clicked an alert";
    String actualResult = resultElement.getText();

    Assert.assertEquals(expectedResult,actualResult);

}

@Test
public  void test02(){
    // 1. get url
    String url = "https://the-internet.herokuapp.com/javascript_alerts";
    driver.get(url);

    //2. click allertbutton2
    WebElement allertButton2Element= driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
    click(allertButton2Element);

    // 3. click the cancel
    driver.switchTo().alert().dismiss();

    //4. Check text result
    WebElement resultTextElement= driver.findElement(By.xpath("//p[@id='result']"));
    String expectedText= "You clicked: Cancel";
    String actualResultText = resultTextElement.getText();
    Assert.assertEquals(expectedText, actualResultText);
    }

    @Test
    public void test03() throws InterruptedException {
        // 1. get url
        String url = "https://the-internet.herokuapp.com/javascript_alerts";
        driver.get(url);

        //2. click allertbutton3
        WebElement allertButton3Element= driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        click(allertButton3Element);

        //3. send keys to allert
        driver.switchTo().alert().accept();

        //4. check the result text
        WebElement resultTextElement= driver.findElement(By.xpath("//p[@id='result']"));
        String expectedTextResult = "You entered:";
        String actualTextResult = resultTextElement.getText();
        Assert.assertEquals(expectedTextResult, actualTextResult);
    }

    public  void sendKeys(WebElement element, String value) {
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(value);
    }
    public void click(WebElement element){
                new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(element));
                element.click();
    }

}
