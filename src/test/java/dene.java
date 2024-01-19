import com.github.javafaker.Faker;
import junit.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class dene extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://testotomasyonu.com/search-product?search=dress&search_category=0");
        List<WebElement> elements= driver.findElements(By.xpath("//*[@class='prod-title mb-3 ']"));
        Thread.sleep(1000);

        for (WebElement each: elements){
            if (each.getText().equals("Women Black Fancy Dress")){
                each.click();
            }
        }
    }

    @Test
    public void test02() throws InterruptedException {

        driver.get("https://testotomasyonu.com/form");


        driver.findElement(By.id("name")).click();

        Actions actions = new Actions(driver);
        actions.sendKeys("muammer")
                .sendKeys(Keys.TAB)
                .sendKeys("oner").perform();
        WebElement birthDay =driver.findElement(By.xpath("//select[@class='form-control']"));
        Select selectDay = new Select(birthDay);
        selectDay.selectByIndex(9);
        WebElement birthMonth= driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        Select selectMonth = new Select(birthMonth);
        selectMonth.selectByValue("nisan");
        WebElement birthYear = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
        Select selectYear= new Select(birthYear);
        selectYear.selectByVisibleText("1990");

        driver.findElement(By.id("inlineRadio2")).click();
        actions.sendKeys(Keys.TAB);


    }
    @Test
    public void test03(){
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//*[@*='cookie-policy-manage-dialog-accept-button']")).click();
    driver.findElement(By.xpath("//*[@*='open-registration-form-button']")).click();

    driver.findElement(By.xpath("//*[@name='firstname']")).click();
    Actions actions =new Actions(driver);
        Faker faker= new Faker();
    actions.sendKeys(faker.name().firstName())
            .sendKeys(Keys.TAB)
            .sendKeys(faker.name().lastName())
            .sendKeys(Keys.TAB)
            .sendKeys(faker.internet().password())
            .sendKeys(Keys.TAB)
            .sendKeys(Keys.TAB)
            .sendKeys("apr")
            .sendKeys(Keys.TAB)
            .sendKeys("09")
            .sendKeys(Keys.TAB)
            .sendKeys("1990")
            .sendKeys(Keys.TAB)
            .sendKeys(Keys.TAB)
            .sendKeys(Keys.ARROW_RIGHT)
            .sendKeys(Keys.ENTER)
            .sendKeys(Keys.TAB)
            .sendKeys(Keys.TAB)
            .sendKeys(Keys.TAB)
            .sendKeys(Keys.TAB)
            .sendKeys(Keys.TAB)
            .sendKeys(Keys.TAB)
            .sendKeys(Keys.ENTER).perform();




    }
}
