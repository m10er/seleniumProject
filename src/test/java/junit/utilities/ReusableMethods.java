package junit.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ReusableMethods {
    public static void wait(int second) throws InterruptedException {
        Thread.sleep(5);
    }
    public static List<String> stringList(List<WebElement> webElementList){
        List<String> stringList= new ArrayList<>();
        for (WebElement each: webElementList){
            stringList.add(each.getText());
        }
        return stringList;
    }
}
