package junit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DropdownTest {
    static WebDriver driver= new ChromeDriver();

    public static void main(String[] args) {
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String url= "https://www.amazon.com/";

        driver.get(url);
        // 1. Locate 'All'
        WebElement dropdownElement = driver.findElement(By.id("searchDropdownBox"));

        // 2 From Select class a new object
        Select select = new Select(dropdownElement);

        // option 1
        select.selectByIndex(3);
        System.out.println("Element, index of 3 : " + select.getFirstSelectedOption().getText()); // Baby


        //option 2
        select.selectByValue("search-alias=stripbooks-intl-ship");
        System.out.println("Value : " + select.getFirstSelectedOption().getText()); // Books


        //option 3
        select.selectByVisibleText("Digital Music");
        System.out.println("VisibleText : " + select.getFirstSelectedOption().getText());//Digital Music


        // All of option
        List<WebElement> optionList = select.getOptions();
        int sayac = 0;
        System.out.println("\nAll list\n");

        for(WebElement w : optionList){
            System.out.println(sayac+" : " + w.getText());
            sayac++;
        }

        driver.close();





    }public  static  void sendKeys(WebElement element, String value){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);

    }public  static  void click(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(element));
        element.submit();
    }
}
