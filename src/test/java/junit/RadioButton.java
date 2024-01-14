package junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RadioButton {
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

@Test
    public void test01(){
        // visit site https://testotomasyonu.com/form
    // locate Radio Button elements
    // choose elements which one is suit for you
    // check elements which one is already selected, or not selected
    String url = "https://testotomasyonu.com/form";
    driver.get(url);
    WebElement radioManElement= driver.findElement(By.id("inlineRadio2"));
    WebElement radioWomanElement= driver.findElement(By.id("inlineRadio1"));
    WebElement radioOtherElement= driver.findElement(By.id("inlineRadio3"));
    radioManElement.click();

    Assert.assertTrue(radioManElement.isSelected());
    Assert.assertFalse(radioWomanElement.isSelected());
    Assert.assertFalse(radioOtherElement.isSelected());
}
@Test
    public void test02(){
        // visit web page https://facebook.com
    //Accept cookie
    // Click create an account button
    // Locate Radio button and choose one of them
    //Check is selected which one is already selected and not select

    String url = "https://facebook.com";
    driver.get(url);
    WebElement cookieElement = driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']"));
    cookieElement.click();

    driver.findElement(By.xpath("//*[text()='Create new account']")).click();

    WebElement femaleRadioElement= driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
    WebElement maleRadioElement= driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
    WebElement customRadioElement= driver.findElement(By.xpath("(//input[@type='radio'])[3]"));

    maleRadioElement.click();

    Assert.assertTrue(maleRadioElement.isSelected());
    Assert.assertFalse(femaleRadioElement.isSelected()&& customRadioElement.isSelected());




}

}
