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
    @Test
    public void test02(){


        //  https://the-internet.herokuapp.com/windows URL gidin
        driver.get("https://the-internet.herokuapp.com/windows");
        String firstPageWHD= driver.getWindowHandle();

        //  Click Here butonuna basın.
        driver.findElement(By.partialLinkText("Click Here")).click();

        // Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        Set<String> windowHandleSet= driver.getWindowHandles();
        String newPageHandle="";
        for (String each: windowHandleSet){
            if (!each.equals(firstPageWHD)){
                newPageHandle=each;
            }
        }
        driver.switchTo().window(newPageHandle);

        String expectedTitle= "New Window";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);


        //  Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(firstPageWHD);


        // Elemental Selenium butonuna tıklayın
        driver.findElement(By.partialLinkText("Elemental Selenium")).click();

        //  Acilan yeni pencerenin sayfa başlığının (title) “Elemental Selenium” icerdigini dogrulayin.
        Set<String> windowHandlSet= driver.getWindowHandles();
        String thirdWHD ="";
        for (String each: windowHandlSet){
            if (!each.equals(firstPageWHD)&& !each.equals(newPageHandle)){
                thirdWHD= each;
            }
                    }
        driver.switchTo().window(thirdWHD);
        String expextedTitlee = "Elemental Selenium";
        String actualTitlee = driver.getTitle();
        Assert.assertTrue(actualTitlee.contains(expextedTitlee));
        // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.,


    }
}
