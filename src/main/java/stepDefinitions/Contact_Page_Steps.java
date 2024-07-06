package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;



import java.util.List;

public class Contact_Page_Steps {
    private WebDriver driver;


    @Before ("@tc1and2")
    public void setup(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

    }
    @After ("@tc1and2")
    public void close(){
        driver.quit();
    }

    @Given("I access the Jupiter Toys Contact page")
    public void i_access_the_jupiter_toys_contact_page() throws InterruptedException  {
        driver.get("https://jupiter.cloud.planittesting.com/#/home");
        driver.findElement(By.cssSelector("[href=\"#/contact\"]")).click();
        Thread.sleep(2000);
    }

    @When("I click submit button")
    public void i_click_submit_button() throws InterruptedException {
        driver.findElement(By.cssSelector("[class=\"btn-contact btn btn-primary\"]")).click();
        Thread.sleep(2000);
    }

    @Then("I see error messages")
    public void i_see_error_messages() {
        boolean header_Error_Message = driver.findElement(By.xpath("//div[@class='alert alert-error ng-scope']")).isDisplayed();
        System.out.println("header error message:" + header_Error_Message);
        boolean forename_Error_Message = driver.findElement(By.id("forename-err")).isDisplayed();
        System.out.println("forename error message:" + forename_Error_Message);
        boolean email_Error_Message = driver.findElement(By.id("email-err")).isDisplayed();
        System.out.println("email error message:" + email_Error_Message);
        boolean message_Error_Message = driver.findElement(By.id("message-err")).isDisplayed();
        System.out.println("message error message:" + message_Error_Message);
    }

    @And("I enter {string} in the Forename field")
    public void i_enter_value_in_the_forename_field(String fnvalue)  {
        driver.findElement(By.id("forename")).sendKeys(fnvalue);
    }

    @And("I enter {string} in the Email field")
    public void i_enter_value_in_the_email_field(String evalue) {
        driver.findElement(By.id("email")).sendKeys(evalue);
    }

    @And("I enter {string} in the Message field")
    public void i_enter_value_the_message_field(String mvalue) throws InterruptedException {
        driver.findElement(By.id("message")).sendKeys(mvalue);
        Thread.sleep(2000);
    }

    @Then("I should not see error messages")
    public void i_should_not_see_error_messages() {
        //Define Element Locators
        By header_Error_Message = By.xpath("//div[@class='alert alert-error ng-scope']");
        By forename_Error_Message = By.id("forename-err");
        By email_Error_Message = By.id("email-err");
        By message_Error_Message = By.id("message-err");
        //Find WebElements
        List<WebElement> headerErrorLocator = driver.findElements(header_Error_Message);
        List<WebElement> forenameErrorLocator = driver.findElements(forename_Error_Message);
        List<WebElement> emailErrorLocator = driver.findElements(email_Error_Message);
        List<WebElement> messageErrorLocator = driver.findElements(message_Error_Message);

        if(headerErrorLocator.isEmpty() && forenameErrorLocator.isEmpty() && emailErrorLocator.isEmpty() && messageErrorLocator.isEmpty()){
            System.out.println("No error messages are displayed");
        } else{
            System.out.println("Atleast one error message is displayed");
        }

    }

    @Then("I should see successful message for {string}")
    public void i_should_see_successful_message_for(String fnvalue) throws InterruptedException {
        Thread.sleep(20000);
        WebElement success_Message = driver.findElement(By.cssSelector("[class=\"alert alert-success\"]"));
        Assert.assertEquals(success_Message.getText(),"Thanks " + fnvalue +", we appreciate your feedback.");
    }

}
