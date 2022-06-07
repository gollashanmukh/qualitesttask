package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.PageUtils;

public class basePage {
    WebDriver driver;
    public basePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void createNewRecord(){
        PageUtils.createNewRecord(driver);
    }

    public void submit(){
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
    }
}
