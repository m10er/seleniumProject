package junit.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {
    public static void wait(int second) throws InterruptedException {
        Thread.sleep(5);
    }

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

    public static String getNewWindowHandle(WebDriver driver, String... handles) {
        ArrayList<String> handleArr = new ArrayList<>(driver.getWindowHandles());
        String newHandle = "";
        for (int i = 0; i < handles.length; i++) {
            if (handleArr.contains(handles[i])) {
                newHandle = handles[i];
            }
        }
        return newHandle;
    }
}