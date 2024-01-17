package junit;

import junit.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class KeyboardAction extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //2- https://www.testotomasyonu.com sayfasina gidelim
        driver.get("https://www.testotomasyonu.com");

        //3- Arama kutusuna actions method’larini kullanarak “DELL Core I3” yazdirin
        //   ve Enter’a basarak arama yaptirin
        Actions actions = new Actions(driver);
        WebElement searchBox = driver.findElement(By.id("global-search"));
        actions.click(searchBox).keyDown(Keys.SHIFT)
                                    .sendKeys("dell c")
                                    .keyUp(Keys.SHIFT)
                                    .sendKeys("ore ")
                                    .keyUp(Keys.SHIFT)
                                    .sendKeys("i")
                                    .keyUp(Keys.SHIFT)
                                    .sendKeys("3").sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);

        //4- Bulunan urun isminde “DELL Core I3” bulundugunu test edin
        String actualDellText= driver.findElement(By.xpath("//*[@class='prod-title mb-3 ']")).getText();
        String expectedDellText= "DELL Core I3";
        Assert.assertTrue(actualDellText.contains(expectedDellText));

    }
}
