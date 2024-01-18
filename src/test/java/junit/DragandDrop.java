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
    @Test
    public void test02(){
        String url ="http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html";
        driver.get(url);
        WebElement oslo = driver.findElement(By.id("box1"));
        WebElement stockholm = driver.findElement(By.id("box2"));
        WebElement washington = driver.findElement(By.id("box3"));
        WebElement copenhagen = driver.findElement(By.id("box4"));
        WebElement seoul= driver.findElement(By.id("box5"));
        WebElement rome = driver.findElement(By.id("box6"));
        WebElement madrid = driver.findElement(By.id("box7"));

        WebElement italyBoxElement= driver.findElement(By.id("box106"));
        WebElement spainBoxElement= driver.findElement(By.id("box107"));
        WebElement norwayBoxElement= driver.findElement(By.id("box101"));
        WebElement denmarkBoxElement= driver.findElement(By.id("box104"));
        WebElement southkoreaBoxElement= driver.findElement(By.id("box105"));
        WebElement swedeenBoxElement= driver.findElement(By.id("box102"));
        WebElement usaBoxElement= driver.findElement(By.id("box103"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(oslo).moveToElement(norwayBoxElement).release().build().perform();
       // actions.dragAndDrop(oslo,norwayBoxElement).perform();
        actions.dragAndDrop(stockholm,swedeenBoxElement).perform();
        actions.dragAndDrop(washington,usaBoxElement).perform();
        actions.dragAndDrop(copenhagen,denmarkBoxElement).perform();
        actions.dragAndDrop(seoul,southkoreaBoxElement).perform();
        actions.dragAndDrop(rome,italyBoxElement).perform();
        actions.dragAndDrop(madrid,spainBoxElement).perform();
    }
    @Test
    public void test03(){
        driver.get("https://rangeslider.js.org/");
        WebElement slider = driver.findElement(By.xpath("//*[@class='rangeslider__handle']"));

        Actions actions= new Actions(driver);
        actions.clickAndHold(slider).moveToElement(slider,100,0).release().perform();
        actions.clickAndHold(slider).moveToElement(slider,-300,0).release().perform();
        actions.dragAndDropBy(slider, -40,0).perform();
    }
}
