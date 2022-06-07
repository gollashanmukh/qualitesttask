

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/Destination.html"}
       // features = "Feature"
       // ,glue={"stepDefinition"}
)
public class TestRunner {

    public static WebDriver driver;

    @BeforeClass
    public static void StartBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(Constants.URL);
    }

    @AfterClass
    public static void StopBrowser(){

       driver.quit();
    }

}