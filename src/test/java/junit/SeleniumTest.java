package junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumTest {
   static WebDriver driver= new ChromeDriver();


    public static void main(String[] args) {


        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

       String url = "https://the-internet.herokuapp.com/checkboxes";
        //1. https://the-internet.herokuapp.com/checkboxes go the web site
        driver.get(url);

        //2. Checkbox1 ve checkbox2 locate the webelements
        WebElement checkBox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));


        //3.  if Checkbox1 dont selected, select that
        if(!checkBox1.isSelected()){
            checkBox1.click();
        }

        //4. Checkbox2 dont selected, select that

        if(!checkBox2.isSelected()){
            checkBox2.click();
        }


        driver.quit();

    }public  void sendKeys(WebElement element, String value){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);

    }public  void click(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(element));
        element.submit();
    }
}
