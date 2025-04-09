package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BaskeballstepDefinitions {

     WebDriver driver;
    public String uniqueEmail1() {
        String email = "joakim+" + System.currentTimeMillis() + "@gmail.com";
        return email;
    }

    @Given("I am at the basketball registration page")
    public void i_am_on_the_basketball_registration_page(){

        driver = new ChromeDriver();
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");

    }

    @When("I enter valid registration details")
    public void i_enter_valid_registration_details(){

        try { Thread.sleep(2000); } catch (Exception e) {}

        String uniqueEmail = uniqueEmail1();
        String confirmEmail = uniqueEmail;

        driver.findElement(By.id("dp")).sendKeys("19/06/1992");
        driver.findElement(By.id("member_firstname")).sendKeys("Joakim");
        driver.findElement(By.id("member_lastname")).sendKeys("Andersson");
        driver.findElement(By.id("member_emailaddress")).sendKeys(uniqueEmail);
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys(confirmEmail);
        driver.findElement(By.id("signupunlicenced_password")).sendKeys("joakim123");
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("joakim123");


        //Jag hade problem med att få checkboxes att fungera så jag använde javascript direkt från min webdriver session
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement terms = driver.findElement(By.id("sign_up_25"));
        js.executeScript("arguments[0].click();", terms);

        WebElement age = driver.findElement(By.id("sign_up_26"));
        js.executeScript("arguments[0].click();", age);

        WebElement ethics  = driver.findElement(By.id("fanmembersignup_agreetocodeofethicsandconduct"));
        js.executeScript("arguments[0].click();", ethics);

    }

    @And("Click the confirm and join button")
    public void Click_the_confirm_and_join_button(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ConfirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("join")));
        ConfirmButton.click();

    }

    @Then("I should be registered succesfully")
    public void i_should_be_registered_succesfully(){

        boolean success = driver.getPageSource().contains("THANK YOU") || driver.getCurrentUrl().contains("SignUpConfirmation");
        if(success) {
            System.out.println("Test passed: Registration successful!");
        } else {
            System.out.println("Test failed: Registration failed.");
        }

        assert success : "Registrering misslyckades";

        // Här vill jag vänta så jag hinner se meedelandet.
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    }

