import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ComputerDatabasePage;
import pages.HomePage;
import pages.ProductPage;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

public class MyStepdefs {

    WebDriver driver;
       ComputerDatabasePage  computerDatabasePage;
       ProductPage   productPage;

       HomePage   homePage;
    @Before
    public void start(){
        driver = TestRunner.driver;
        computerDatabasePage = new ComputerDatabasePage(driver);
        productPage = new ProductPage(driver);
        homePage  = new HomePage(driver);

    }

    @Given("^Admin is in landing page$")
    public void adminIsInLandingPage() {
        Assert.assertTrue(driver.findElement((By.name("username"))).isDisplayed());
    }



    @Then("he should logout")
    public void heShouldLogout() {
        driver.navigate().to("https://computer-database.gatling.io/computers");
           }

    @Given("admin is in create computer page")
    public void adminIsInCreateComputerPage() {
        computerDatabasePage.addNewComputer.click();
    }

    @When("he creates the computer with fields {string},{string},{string}")
    public void heCreatesTheComputerWithFields(String computername, String introduced, String company) {

       computerDatabasePage.AddaNewComputer(computername,introduced,company);


    }

    @Then("the computer created is displayed")
    public void theComputerCreatedIsDisplayed() {
        computerDatabasePage.searchBox.sendKeys("");
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Acer Iconia')]")).isDisplayed());
    }

    @Then("the computer created is displayed {string}")
    public void theComputerCreatedIsDisplayed(String computername) {

        computerDatabasePage.searchBox.sendKeys(computername);
        computerDatabasePage.filterButton.click();
        Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Acer Iconia')]")).isDisplayed());
    }

    @When("he searches and edit {string}")
    public void heSearchesAndEdit(String computername) {
        computerDatabasePage.searchBox.sendKeys(computername);
        computerDatabasePage.filterButton.click();
        driver.findElement(By.xpath("//a[contains(text(),'Acer Iconia')]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Edit computer')]")).isDisplayed());
        computerDatabasePage.computernameLocator.sendKeys("ABC");
        computerDatabasePage.createComputerbtn.click();

    }

    @Then("the computer details are updated")
    public void theComputerDetailsAreUpdated() {
        Assert.assertTrue((computerDatabasePage.createmessage).isDisplayed());
        Assert.assertEquals((computerDatabasePage.createmessage).getText(),"Done ! Computer Acer IconiaABC has been updated");
    }

    @Given("admin is in computer landing page")
    public void adminIsInComputerLandingPage() {
        driver.get(Constants.URL);
    }

    @When("user searches and delete {string}")
    public void userSearchesAndDelete(String computername) {
        computerDatabasePage.searchBox.sendKeys(computername);
        computerDatabasePage.filterButton.click();
        driver.findElement(By.xpath("//a[contains(text(),'Acer Iconia')]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Edit computer')]")).isDisplayed());
        computerDatabasePage.deleteBtn.click();
            }

    @Then("user deletes the data")
    public void userDeletesTheData() {
        Assert.assertTrue((computerDatabasePage.createmessage).isDisplayed());
        Assert.assertEquals((computerDatabasePage.createmessage).getText(),"Done ! Computer Acer Iconia has been deleted");
    }



    @Given("I add four different {string} to my wishlist")
    public void iAddFourDifferentToMyWishlist(String product) throws InterruptedException {

        homePage.searchproduct(product);
        productPage.addToWishlist();
    }

    @When("I view my wishlist table")
    public void iViewMyWishlistTable() {
        driver.navigate().to("https://testscriptdemo.com/?page_id=233&wishlist-action");
    }

    @Then("I find total four selected items in my wishlist")
    public void iFindTotalFourSelectedItemsInMyWishlist() {
        List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"yith-wcwl-form\"]/table/tbody/tr/td[1]"));
        int size = 4;
        System.out.println(rows.size());
        Assert.assertEquals(size,rows.size());
    }

    @Given("I add four different products to my wishlist")
    public void iAddFourDifferentProductsToMyWishlist() throws InterruptedException {
        homePage.searchproduct("Modern");
        productPage.addToWishlist();

        homePage.searchproduct("Black pants");
        productPage.addToWishlist();

        homePage.searchproduct("Hard Top");
        productPage.addToWishlist();

        homePage.searchproduct("Women dress");
        productPage.addToWishlist();


    }

    @And("I am able to add the lowest price item to my cart")
    public void iAmAbleToAddTheLowestPriceItemToMyCart() throws ParseException {

        productPage.addToCart.click();

//        String min;
//        double m=0,r=0;
//        List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"yith-wcwl-form\"]/table/tbody/tr/td[1]"));
//        for (int i =0;i<rows.size();i++)
//        {
//            min= driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/div[1]/article[1]/div[1]/div[1]/div[1]/form[1]/table[1]/tbody[1]/tr[" + (i+1)+ "]/td[4]")).getText();
//            NumberFormat f =NumberFormat.getNumberInstance();
//            Number num = f.parse(min);
//            min = num.toString();
//            m = Double.parseDouble(min);
//            if(m<r)
//            {
//                r=m;
//            }
//        }
//        System.out.println("Minimum value is : "+ r);


    }

    @Then("I am to verify the item in my cart")
    public void iAmToVerifyTheItemInMyCart() {

        driver.navigate().to("https://testscriptdemo.com/?page_id=299");
       // productPage.modernProd.isDisplayed();

        Assert.assertTrue(productPage.modernProd.isDisplayed());


    }
}
