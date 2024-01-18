package junit;

import junit.utilities.ReusableMethods;
import junit.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileExist extends TestBase {

    @Test
    public void dosyaIndirmeTesti(){
        System.out.println(System.getProperty("user.dir"));

        System.out.println(System.getProperty("user.home"));

        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. logo.png dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='spectrum-logo.png']"))
                .click();
        ReusableMethods.waitfor(5);
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim

        String dosyaYolu = "C:\\Users\\User\\Downloads\\spectrum-logo.png";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
    @Test
    public void test02(){
        driver.get("https://demoqa.com/upload-download");
        driver.findElement(By.id("downloadButton")).click();
        String imgPath = "C:\\Users\\User\\Downloads\\sampleFile.jpeg";
        WebElement chooseFileElement= driver.findElement(By.id("uploadFile"));

        chooseFileElement.sendKeys(imgPath);

        WebElement uploadFileTExtElement= driver.findElement(By.id("uploadedFilePath"));

        Assert.assertTrue(uploadFileTExtElement.isDisplayed());
    }
    @Test
    public void test03(){
        System.out.println(System.getProperty("user.dir")); //C:\Users\User\Desktop\selenium\Selenium
        System.out.println(System.getProperty("user.home")); //C:\Users\User
        //C:\Users\User\Desktop\test\test.txt
        String filePath= System.getProperty("user.home")+"\\Desktop\\test\\test.txt";
        boolean result =Files.exists(Paths.get(filePath));
        Assert.assertTrue(result);

    }
    @Test
    public void  test04(){
        System.out.println(System.getProperty("user.dir")); //C:\Users\User\Desktop\selenium\Selenium
        //pom.xml - C:\Users\User\Desktop\selenium\Selenium\pom.xml
        String filePath= System.getProperty("user.dir")+"\\pom.xml";
        Boolean result = Files.exists(Paths.get(filePath));
        Assert.assertTrue(result);
    }
}
