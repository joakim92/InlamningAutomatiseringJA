package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import io.cucumber.java.After;
import static org.junit.jupiter.api.Assertions.*;


public class BaskeballstepDefinitions {

    private WebDriver driver;
    private String email;

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

        String uniqueEmail = uniqueEmail1();
        String confirmEmail = uniqueEmail;

        driver.findElement(By.id("dp")).sendKeys("19/06/1992");
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        driver.findElement(By.id("member_firstname")).sendKeys("Joakim");
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        driver.findElement(By.id("member_lastname")).sendKeys("Andersson");
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        driver.findElement(By.id("member_emailaddress")).sendKeys(uniqueEmail);
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        driver.findElement(By.id("member_confirmemailaddress")).sendKeys(confirmEmail);
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        driver.findElement(By.id("signupunlicenced_password")).sendKeys("joakim123");
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("joakim123");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement terms = driver.findElement(By.id("sign_up_25"));
        js.executeScript("arguments[0].scrollIntoView(true);", terms);
        js.executeScript("arguments[0].click();", terms);

        WebElement age = driver.findElement(By.id("sign_up_26"));
        js.executeScript("arguments[0].scrollIntoView(true);", age);
        js.executeScript("arguments[0].click();", age);

        WebElement ethics  = driver.findElement(By.id("fanmembersignup_agreetocodeofethicsandconduct"));
        js.executeScript("arguments[0].scrollIntoView(true);", ethics);
        js.executeScript("arguments[0].click();", ethics);

    }

    @When ("I fill registration details and leave last name blanked")
    public void I_fill_registration_details_and_leave_last_name_blanked(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String uniqueEmail = uniqueEmail1();
        String confirmEmail = uniqueEmail;

        driver.findElement(By.id("dp")).sendKeys("19/06/1992");
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        driver.findElement(By.id("member_firstname")).sendKeys("Joakim");
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        driver.findElement(By.id("member_lastname")).clear();
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        driver.findElement(By.id("member_emailaddress")).sendKeys(uniqueEmail);
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        driver.findElement(By.id("member_confirmemailaddress")).sendKeys(confirmEmail);
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        driver.findElement(By.id("signupunlicenced_password")).sendKeys("joakim123");
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("joakim123");
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement terms = driver.findElement(By.id("sign_up_25"));
        js.executeScript("arguments[0].scrollIntoView(true);", terms);
        js.executeScript("arguments[0].click();", terms);

        WebElement age = driver.findElement(By.id("sign_up_26"));
        js.executeScript("arguments[0].scrollIntoView(true);", age);
        js.executeScript("arguments[0].click();", age);

        WebElement ethics  = driver.findElement(By.id("fanmembersignup_agreetocodeofethicsandconduct"));
        js.executeScript("arguments[0].scrollIntoView(true);", ethics);
        js.executeScript("arguments[0].click();", ethics);

    }

    @When ("I fill registration details but passwords doesnt match")
    public void i_fill_registration_details_with_non_matching_passwords(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String uniqueEmail = uniqueEmail1();
        String confirmEmail = uniqueEmail;

        driver.findElement(By.id("dp")).sendKeys("19/06/1992");
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        driver.findElement(By.id("member_firstname")).sendKeys("Joakim");
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        driver.findElement(By.id("member_lastname")).sendKeys("Andersson");
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        driver.findElement(By.id("member_emailaddress")).sendKeys(uniqueEmail);
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        driver.findElement(By.id("member_confirmemailaddress")).sendKeys(confirmEmail);
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }


        driver.findElement(By.id("signupunlicenced_password")).sendKeys("joakim123");
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("hejsan456");
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement terms = driver.findElement(By.id("sign_up_25"));
        js.executeScript("arguments[0].scrollIntoView(true);", terms);
        js.executeScript("arguments[0].click();", terms);

        WebElement age = driver.findElement(By.id("sign_up_26"));
        js.executeScript("arguments[0].scrollIntoView(true);", age);
        js.executeScript("arguments[0].click();", age);

        WebElement ethics = driver.findElement(By.id("fanmembersignup_agreetocodeofethicsandconduct"));
        js.executeScript("arguments[0].scrollIntoView(true);", ethics);
        js.executeScript("arguments[0].click();", ethics);

    }

    @When("I fill registration details but doesnt accept the terms and conditions")
    public void i_fill_registration_details_but_dont_accept_terms_and_conditions(){
        String uniqueEmail = uniqueEmail1();
        String confirmEmail = uniqueEmail;

        driver.findElement(By.id("dp")).sendKeys("19/06/1992");
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        driver.findElement(By.id("member_firstname")).sendKeys("Joakim");
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        driver.findElement(By.id("member_lastname")).sendKeys("Andersson");
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        driver.findElement(By.id("member_emailaddress")).sendKeys(uniqueEmail);
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        driver.findElement(By.id("member_confirmemailaddress")).sendKeys(confirmEmail);
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        driver.findElement(By.id("signupunlicenced_password")).sendKeys("joakim123");
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("joakim123");
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement age = driver.findElement(By.id("sign_up_26"));
        js.executeScript("arguments[0].scrollIntoView(true);", age);
        js.executeScript("arguments[0].click();", age);

        WebElement ethics  = driver.findElement(By.id("fanmembersignup_agreetocodeofethicsandconduct"));
        js.executeScript("arguments[0].scrollIntoView(true);", ethics);
        js.executeScript("arguments[0].click();", ethics);
    }

    @And("I Click the confirm and join button")
    public void Click_the_confirm_and_join_button(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ConfirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("join")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", ConfirmButton);
        js.executeScript("arguments[0].click();", ConfirmButton);
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

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @Then("I should get an error message telling me that last name is missing")
    public void i_should_get_error_message_for_missing_last_name(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement lastNameError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".field-validation-error[data-valmsg-for='Surname']")));

        String errorMessage = lastNameError.getText();
        System.out.println("Error for Last Name: " + errorMessage);

        assertTrue(errorMessage.contains("Last Name is required"), "Förväntat felmeddelande saknas eller är fel: " + errorMessage);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @Then ("I should get an error message telling me that passwords doesnt match")
    public void i_should_get_an_error_for_non_matching_passwords(){
        System.out.println("Testet startar...");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement passwordError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@for='signupunlicenced_confirmpassword' and text()='Password did not match']")));

        String errorMessage = passwordError.getText();
        System.out.println("Password error message: " + errorMessage);

        assertTrue(errorMessage.toLowerCase().contains("match") || !errorMessage.isEmpty(), "Förväntat felmeddelande saknas för icke-matchande lösenord");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Then("I should get an error message telling me that terms and conditions are not accepted")
    public void i_should_get_an_error_message_telling_me_that_terms_and_conditions_are_not_accepted(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement termsError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@for='TermsAccept' and text()='You must confirm that you have read and accepted our Terms and Conditions']")));

        String errorMessage = termsError.getText();
        System.out.println("Terms error message: " + errorMessage);

        assertTrue(errorMessage.contains("You must confirm that you have read and accepted our Terms and Conditions"), "Förväntat felmeddelande saknas eller är fel: " + errorMessage);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After //Hade problem med att instanser forf låg på datorn och körde
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}

