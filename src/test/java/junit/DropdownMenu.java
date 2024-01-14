package junit;

import junit.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownMenu extends TestBase {
    @Test
    public void test1() throws InterruptedException {
        // visit https://testotomasyonu.com/form
        // choose as a birthaday with index 5
        // choose as a birthMonth with value "april"
        //chose as a birthYear with visibletext 1990
        // write the birthday in console
        // write all months values
        //check as a month dropdown size "13"

        String url = "https://testotomasyonu.com/form";
        driver.get(url);
        Thread.sleep(5);
        WebElement dayDropdownElement= driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
        WebElement monthDropdownElement= driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        WebElement yearDropdownElement= driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));

        Select selectDay = new Select(dayDropdownElement);
        selectDay.selectByIndex(5);

        Select selectMonth= new Select(monthDropdownElement);
        selectMonth.selectByValue("nisan");

        Select selectYear= new Select(yearDropdownElement);
        selectYear.selectByVisibleText("1990");

        System.out.println("Secilen gun :"+selectDay.getFirstSelectedOption().getText()+"\n" +
                "secilen ay "+ selectMonth.getFirstSelectedOption().getText()+" \n" +
                "secilen yil "+ selectYear.getFirstSelectedOption().getText());

        List<WebElement> selectMonthOptionElements =selectMonth.getOptions();

        for (WebElement each: selectMonthOptionElements){
            System.out.println(each.getText());
        }

        Assert.assertEquals(13, selectMonthOptionElements.size());





    }
}
