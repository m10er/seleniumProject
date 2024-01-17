package junit.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static List<String> stringList(List<WebElement> webElementList) {
        List<String> stringList = new ArrayList<>();
        for (WebElement each : webElementList) {
            stringList.add(each.getText());
        }
        return stringList;
    }

    public static WebDriver getPageWithTitle(WebDriver driver, String title) {
        Set<String> windowhandles = driver.getWindowHandles();
        for (String each : windowhandles) {
            if (driver.switchTo().window(each).getTitle().equals(title)) {
                return driver;
            }
        }
        return driver;
    }

}