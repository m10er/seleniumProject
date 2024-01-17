package junit;

import junit.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        //1- https://testotomasyonu.com/droppable adresine gidelim

        driver.get("    https://testotomasyonu.com/droppable");

        //2- Accept bolumunde “Acceptable” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement acceptableElement = driver.findElement(By.id("draggable2"));
        WebElement dropHereElement= driver.findElement(By.id("droppable2"));

        Actions actions = new Actions(driver);
        Thread.sleep(4000);
        actions.dragAndDrop(acceptableElement, dropHereElement).perform();
        Thread.sleep(4000);
        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String actualDroppedTExt= dropHereElement.getText();
        String expectedDroppedTExt= "Dropped!";
        Assert.assertEquals(expectedDroppedTExt,actualDroppedTExt);


        //4- Sayfayi yenileyin
        driver.navigate().refresh();

        //5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        WebElement notAcceptableElement = driver.findElement(By.id("draggable-nonvalid2"));
        WebElement drophereBoxElement= driver.findElement(By.id("droppable2"));

        actions.dragAndDrop(notAcceptableElement,drophereBoxElement).perform();

        //6- “Drop here” yazisinin degismedigini test edin
        String expectedDrophereTExt= "Drop Here";
        String actualDropHereTExt = drophereBoxElement.getText();
        Assert.assertEquals(expectedDrophereTExt,actualDropHereTExt);

    }
}
