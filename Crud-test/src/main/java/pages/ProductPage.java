package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductPage {

    WebDriver driver;

    @FindBy(xpath = "(//span[contains(text(),'Add to wishlist')])[1]")
    public WebElement wishlist;

    @FindBy(xpath = "//a[contains(text(),'Browse wishlist')]")
    public  WebElement addedTowishlist;

    @FindBy(xpath = "//*[@id=\"yith-wcwl-form\"]/table/tbody/tr/td[1]")
    public  WebElement tableRowInfo;

    @FindBy(xpath = "(//a[contains(text(),'Add to cart')])[3]")
    public  WebElement addToCart;

    @FindBy(xpath = "//a[contains(text(),'Modern')]")
    public WebElement modernProd;

    public void addToWishlist() throws InterruptedException {
        wishlist.click();
        Thread.sleep(30000);
       // WebDriverWait w = new WebDriverWait(driver, 8);

        //w.until(ExpectedConditions.presenceOfElementLocated((By) addedTowishlist));
       // String message = addedTowishlist.getText();
      //  Assert.assertEquals(DriverFactory.prop.getProperty("expectedWishListText"),message);



    }

    public ProductPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
