package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComputerDatabasePage extends basePage{

 @FindBy(xpath = "//a[@id='add']")
 public WebElement  addNewComputer;

 @FindBy(xpath = "//input[@id='searchbox']")
 public WebElement  searchBox;

 @FindBy(xpath = "//input[@id='searchsubmit']")
 public WebElement  filterButton;

 @FindBy(xpath = "//input[@id='name']")
 public  WebElement  computernameLocator;

@FindBy(xpath = "//input[@id='introduced']")
public   WebElement  introducedLocator;

@FindBy(xpath = "//select[@id='company']")
public  WebElement  companyLocator;


@FindBy(xpath = "//input[@class='btn primary']")
public  WebElement  createComputerbtn;

@FindBy(xpath = "//*[@class='alert-message warning']")
public WebElement  createmessage;


@FindBy(xpath = "//input[@class='btn danger']")
public  WebElement  deleteBtn;
    public ComputerDatabasePage(WebDriver driver) {
        super(driver);
    }

    public void AddaNewComputer(String computername, String introduced, String company) {
        computernameLocator.sendKeys(computername);
        introducedLocator.sendKeys(introduced);
        companyLocator.sendKeys(company);
        createComputerbtn.click();
        createmessage.isDisplayed();
            }




}
