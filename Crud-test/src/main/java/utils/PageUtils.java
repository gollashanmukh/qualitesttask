package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageUtils {

    public static void createNewRecord(WebDriver driver){
        driver.findElement(By.xpath("//span[contains(text(),'New')]")).click();
    }
}
