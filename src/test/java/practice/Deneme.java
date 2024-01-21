package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Deneme {
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

    }
    @AfterClass
    public static void tearDown(){
       driver.quit();
    }

//2- https://www.testotomasyonu.com/ adresine gidin
//3- arama kutusuna phone yazip aratin
//4- Category bolumunde 8 element oldugunu test edin
//5- Category isimlerini yazdirin
//6- Sayfayi kapatin

    @Test
    public  void test01(){
        //2- https://www.testotomasyonu.com/ adresine gidin
    String url = "https://www.testotomasyonu.com/";
    driver.get(url);

        //3- arama kutusuna phone yazip aratin
        WebElement aramaKutusuElement = driver.findElement(By.id("global-search"));
        aramaKutusuElement.sendKeys("phone"+ Keys.ENTER);

        //4- Category bolumunde 8 element oldugunu test edin
        List<WebElement> categoriElementList= driver.findElements(By.className("panel-list"));
        int expectedCategorisSAyisi= 8;
        int actualCategoriSAyisi=categoriElementList.size();

        Assert.assertEquals(expectedCategorisSAyisi,actualCategoriSAyisi);

        //5- Category isimlerini yazdirin

        for (WebElement eachElement: categoriElementList){
            System.out.println(eachElement.getText());
        }


    }

    @Test
    public void test03(){


//2- https://www.automationexercise.com/ adresine gidin

        String url = "https://www.automationexercise.com/";
        driver.get(url);

//3- Category bolumundeki elementleri locate edin
        List<WebElement> categoriElementList = driver.findElements(By.className("panel-title"));

//4- Category bolumunde 3 element oldugunu test edin
        int expectedCategoriSayisi= 3;
        int actualCAtegoriSayisi = categoriElementList.size();

        Assert.assertEquals(expectedCategoriSayisi, actualCAtegoriSayisi);

//5- Category isimlerini yazdirin
        for (WebElement eachElement : categoriElementList){
            System.out.println(eachElement.getText());
        }

    }

    @Test
    public void test04() throws InterruptedException {
//1- https://www.testotomasyonu.com/ sayfasına gidin.
        String url = "https://www.testotomasyonu.com/";
        driver.get(url);

//2- Arama kutusuna “dress” yazip aratin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("dress"+Keys.ENTER);

//3- Görüntülenen sonuçların sayısını yazdırın
        WebElement sonucTExtElemnet= driver.findElement(By.xpath("//*[contains(text(),'10 Prod')]"));

//4- Listeden ilk urunun resmine tıklayın.
//        WebElement ilkUrunElement = driver.findElement(By.xpath("//*[.='Women Black Fancy Dress']"));
//        ilkUrunElement.click();

        List<WebElement> elementList = driver.findElements(By.className("lazy"));
       elementList.get(0).click();

//5- Urun detayinda dress kelimesi geçtiğini test edin.
        Thread.sleep(3000);
    WebElement ilkUrunDetayElement = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));
    String expectedTExt= "Dress";
    String actualTExt = ilkUrunDetayElement.getText();
    Assert.assertTrue(actualTExt.contains(expectedTExt));


    }



}
