package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;


public class Shop_Page_Steps {
    private WebDriver driver;

@Before ("@tc3")
    public void setup(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }
@After ("@tc3")
    public void close(){
        driver.quit();
    }

    @Given("I access the Jupiter Toys Shop page thru Start Shopping button")
    public void i_access_the_jupiter_toys_shop_page_thru_start_shopping_button() {
        driver.get("https://jupiter.cloud.planittesting.com/#/home");
        driver.findElement(By.cssSelector("[class=\"btn btn-success btn-large\"]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @When("I click {int} times the buy button of Stuffed Frog")
    public void i_click_times_the_buy_button_of_stuffed_frog(Integer count) {
        WebElement buy_Button = driver.findElement(By.cssSelector("li:nth-of-type(2) .btn.btn-success"));
        int clickCount = count;
        for(int i = 1; i <= clickCount; i++){
            buy_Button.click();
        }

    }

    @And("I click {int} times the buy button of Fluffy Bunny")
    public void i_click_times_the_buy_button_of_fluffy_bunny(Integer count) {
        WebElement buy_Button = driver.findElement(By.cssSelector("li:nth-of-type(4) .btn.btn-success"));
        int clickCount = count;
        for(int i = 1; i <= clickCount; i++){
            buy_Button.click();
        }
    }

    @And("I click {int} times the buy button of Valentine Bear")
    public void i_click_times_the_buy_button_of_valentine_bear(Integer count) {
        WebElement buy_Button = driver.findElement(By.cssSelector("li:nth-of-type(7) .btn.btn-success"));
        int clickCount = count;
        for(int i = 1; i <= clickCount; i++){
            buy_Button.click();
        }
    }

    @When("I go to Cart Page")
    public void i_go_to_cart_page() {
        driver.findElement(By.cssSelector("li#nav-cart > a")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @Then("I verify the subtotal for Stuffed Frog is correct")
    public void i_verify_the_subtotal_for_stuffed_frog_is_correct() {
        WebElement ele1 = driver.findElement(By.cssSelector("tr:nth-of-type(1) > td:nth-of-type(2)"));
        String price = ele1.getText().trim(); //getting text value and trimming the $
        double price2 = Double.parseDouble(price.replaceAll("[^0-9.]","")); //parsing the string value to double

        WebElement ele2 = driver.findElement(By.cssSelector("tr:nth-of-type(1) > td:nth-of-type(3) > input[name='quantity']"));
        String quantity = ele2.getAttribute("value");
        int quantity2 = Integer.parseInt(quantity);

        WebElement ele3 = driver.findElement(By.cssSelector("tr:nth-of-type(1) > td:nth-of-type(4)"));
        String subtotal = ele3.getText().trim();
        double subtotal2 = Double.parseDouble(subtotal.replaceAll("[^0-9.]",""));

        double answer = price2 * quantity2;
        Assert.assertEquals(answer,subtotal2);

    }

    @And("I verify the subtotal for Fluffy Bunny is correct")
    public void i_verify_the_subtotal_for_fluffy_bunny_is_correct() {
        WebElement ele1 = driver.findElement(By.cssSelector("tr:nth-of-type(2) > td:nth-of-type(2)"));
        String price = ele1.getText().trim(); //getting text value and trimming the $
        double price2 = Double.parseDouble(price.replaceAll("[^0-9.]","")); //parsing the string value to double

        WebElement ele2 = driver.findElement(By.cssSelector("tr:nth-of-type(2) > td:nth-of-type(3) > input[name='quantity']"));
        String quantity = ele2.getAttribute("value");
        int quantity2 = Integer.parseInt(quantity);

        WebElement ele3 = driver.findElement(By.cssSelector("tr:nth-of-type(2) > td:nth-of-type(4)"));
        String subtotal = ele3.getText().trim();
        double subtotal2 = Double.parseDouble(subtotal.replaceAll("[^0-9.]",""));

        double answer = price2 * quantity2;
        Assert.assertEquals(answer,subtotal2);

    }

    @And("I verify the subtotal for Valentine Bear is correct")
    public void i_verify_the_subtotal_for_valentine_bear_is_correct() {
        WebElement ele1 = driver.findElement(By.cssSelector("tr:nth-of-type(3) > td:nth-of-type(2)"));
        String price = ele1.getText().trim(); //getting text value and trimming the $
        double price2 = Double.parseDouble(price.replaceAll("[^0-9.]","")); //parsing the string value to double

        WebElement ele2 = driver.findElement(By.cssSelector("tr:nth-of-type(3) > td:nth-of-type(3) > input[name='quantity']"));
        String quantity = ele2.getAttribute("value");
        int quantity2 = Integer.parseInt(quantity);

        WebElement ele3 = driver.findElement(By.cssSelector("tr:nth-of-type(3) > td:nth-of-type(4)"));
        String subtotal = ele3.getText().trim();
        double subtotal2 = Double.parseDouble(subtotal.replaceAll("[^0-9.]",""));

        double answer = price2 * quantity2;
        Assert.assertEquals(answer,subtotal2);

    }

    @Then("I verify the price for Stuffed Frog")
    public void i_verify_the_price_for_stuffed_frog() {
        WebElement price = driver.findElement(By.cssSelector("tr:nth-of-type(1) > td:nth-of-type(2)"));
        Assert.assertEquals(price.getText(),"$10.99");
    }

    @And("I verify the price for Fluffy Bunny")
    public void i_verify_the_price_for_fluffy_bunny() {
        WebElement price = driver.findElement(By.cssSelector("tr:nth-of-type(2) > td:nth-of-type(2)"));
        Assert.assertEquals(price.getText(),"$9.99");
    }

    @And("I verify the price for Valentine Bear")
    public void i_verify_the_price_for_valentine_bear() {
        WebElement price = driver.findElement(By.cssSelector("tr:nth-of-type(3) > td:nth-of-type(2)"));
        Assert.assertEquals(price.getText(),"$14.99");
    }

    @Then("I verify the total")
    public void i_verify_the_total() {
        WebElement sf = driver.findElement(By.cssSelector("tr:nth-of-type(1) > td:nth-of-type(4)"));
        String subtotal1 = sf.getText().trim();
        double sfsubtotal = Double.parseDouble(subtotal1.replaceAll("[^0-9.]",""));

        WebElement fb= driver.findElement(By.cssSelector("tr:nth-of-type(2) > td:nth-of-type(4)"));
        String subtotal2 = fb.getText().trim();
        double fbsubtotal = Double.parseDouble(subtotal2.replaceAll("[^0-9.]",""));

        WebElement vb = driver.findElement(By.cssSelector("tr:nth-of-type(3) > td:nth-of-type(4)"));
        String subtotal3 = vb.getText().trim();
        double vbsubtotal = Double.parseDouble(subtotal3.replaceAll("[^0-9.]",""));

        WebElement total = driver.findElement(By.cssSelector(".ng-binding.total"));
        String total2 = total.getText().trim();
        double anstotal = Double.parseDouble(total2.replaceAll("[^0-9.]",""));

        double answer = sfsubtotal + fbsubtotal + vbsubtotal;
        Assert.assertEquals(answer,anstotal);
    }
}
