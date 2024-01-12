package junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Assertions {
    static WebDriver driver;

    @BeforeClass
    public  static void setup(){
        driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().fullscreen();

        //1. visit bestbuy.com
        driver.get("https://bestbuy.com");
    }

    @AfterClass
    public static void teardown(){
            driver.quit();
    }

    @Test
    public void urlTest(){

        String expectedUrl= "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Test
    public void titleTest(){
        String expectedContainsTitle = "Rest";
        String actualTitle= driver.getTitle();
        Assert.assertFalse(actualTitle.contains(expectedContainsTitle));
    }
    @Test
    public void logoTest(){
        WebElement logoWebElement= driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoWebElement.isDisplayed());
    }
    @Test
    public void francaisLinkTest(){
        WebElement francaisLink= driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(francaisLink.isEnabled());
    }

}
