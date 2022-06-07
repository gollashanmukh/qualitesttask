package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
    WebDriver driver;

    @FindBy(className = "header-search-input")
    public WebElement searchProduct;

    @FindBy(className = "header-search-button")
    public  WebElement searchBtn;



    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void searchproduct(String product)                       //Actions
    {
        searchProduct.sendKeys(product);
        searchBtn.click();
    }

}
