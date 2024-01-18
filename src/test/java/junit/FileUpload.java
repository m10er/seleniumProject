package junit;

import junit.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FileUpload extends TestBase {
    @Test
    public void dosyaYuklemeTesti(){


        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        WebElement chooseFileElement= driver.findElement(By.id("file-upload"));

        //Yuklemek istediginiz dosyayi secelim.
        String filePath= "C:\\Users\\User\\Downloads\\spectrum-logo.png";
        String dynamicFilePath= System.getProperty("user.home")+"\\Downloads\\spectrum-logo.png";

        // logo.png'yi yukleyelim  //C:\Users\User\Downloads\spectrum-logo.png

        chooseFileElement.sendKeys(dynamicFilePath);

        //Upload butonuna basalim.

        driver.findElement(By.id("file-submit")).click();

        //“File Uploaded!” textinin goruntulendigini test edelim.

        WebElement uplodedYaziElementi = driver.findElement(By.tagName("h3"));

        String expectedYazi = "File Uploaded!";
        String actualYazi = uplodedYaziElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);

    }
}
