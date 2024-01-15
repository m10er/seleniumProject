package junit;

import junit.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Iframe extends TestBase {

    @Test
    public void test01() {


        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        String url = "https://the-internet.herokuapp.com/iframe";
        driver.get(url);

        // 2 ) Bir metod olusturun: iframeTest
        //	- “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        WebElement actualTextElement = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(actualTextElement.isDisplayed());
        System.out.println(actualTextElement.getText());

        //	- Text Box’a “Merhaba Dunya!” yazin.

        WebElement iframeElement= driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframeElement);

        WebElement textBoxElement= driver.findElement(By.tagName("p"));
        textBoxElement.sendKeys("Hello World");

        /*
            Text box bir iframe'in icinde
            iframe'in icinde olan elementlere ulasabilmek icin
            once iframe'e gecis yapmalisiniz

            iframe'e gecis yapabilmek icin
            - once iframe'i bir webelement olarak locate edin
            - switchTo() ile iframe'e gecin

            iframe'e gecis yaparsaniz
            driver orada kalir
            yeniden anasayfa ile ilgili bir islem yapmak isterseniz
            driver'i yeniden anasayfaya gecirmelisiniz

            driver.switchTo().parentFrame(); eger ic ice birden fazla iframe varsa
                                             bir ustteki iframe'e gecis yapar
            driver.switchTo().defaultContent(); direk anasayfaya gecer

         */


        //	- TextBox’in altinda bulunan “Elemental Selenium”
        //    linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.
        driver.switchTo().parentFrame();

        WebElement textBoxSeElement= driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(textBoxSeElement.isDisplayed());

        System.out.println(textBoxSeElement.getText());

    }
    @Test
    public  void test02() throws InterruptedException {
        //http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        String url = "http://demo.guru99.com/test/guru99home/";
        driver.get(url);

        //Cookies kabul edin
        // cookies de iframe icinde oldugundan
        // once o iframe'e gecis yapalim


        //3) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframeListElements= driver.findElements(By.tagName("iframe"));
        System.out.println(iframeListElements.size());


        //4) ilk iframe'deki (Youtube) play butonuna tıklayınız.

        WebElement iframe1 = driver.findElement(By.xpath("//*[@wmode='transparent']"));
        driver.switchTo().frame(iframe1);

        driver.findElement(By.xpath("//*[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();

        //5) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();


    }






}