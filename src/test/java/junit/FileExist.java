package junit;

import junit.utilities.ReusableMethods;
import junit.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

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
}
