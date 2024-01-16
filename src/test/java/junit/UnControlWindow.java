package junit;

import junit.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import java.util.Set;

public class UnControlWindow extends TestBase {

    @Test
    public void test01(){
        //● https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");

        //● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
        WebElement removeTextElement = driver.findElement(By.tagName("h2"));
        Assert.assertTrue(removeTextElement.getText().contains("Add/Remove"));


        //● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("Test Otomasyonu"));

        //● ’Please click for Electronics Products’ linkine tiklayin.
        driver.findElement(By.xpath("//*[text()='Please click for ']")).click();

        /*
            Driver bir webelement'e click yapildiginda
            ayni sayfada acilacagini varsayar

            eger tiklanan element yeni bir tab veya window aciyorsa
            bu durumda driver'i yeni acilan tab/window'a bizim gondermemiz gerekir

            bizim driver'i baska bir tab/window'a yollamak icin 2 yolumuz var
            1- ya kontrollu yeni bir tab/window acarak
            2- kontrolsuz acilan tab/window'un Window handle degerini kullanarak

         */

        //● Electronics sayfasinin acildigini test edin
            String firstPageWHD= driver.getWindowHandle();
        Set<String> windowHandles= driver.getWindowHandles();
        String electronicsPageWindowHandle="";

        for (String each: windowHandles){
            if (!each.equals(firstPageWHD)){
                electronicsPageWindowHandle= each;
            }
        }
        driver.switchTo().window(electronicsPageWindowHandle);
        Assert.assertTrue(driver.getTitle().contains("Electronic"));


        //● Bulunan urun sayisinin 16 olduğunu test edin
    WebElement resultTextElementi = driver.findElement(By.className("product-count-text"));
    String resultText= resultTextElementi.getText().replaceAll("\\D","");
    int totalResult = Integer.parseInt(resultText);

    Assert.assertEquals(16,totalResult);



        //● Ilk actiginiz addremove sayfasina donun
        driver.switchTo().window(firstPageWHD);


        //● Url’in addremove icerdigini test edin
        Assert.assertTrue(driver.getCurrentUrl().contains("addremove"));

    }
}
