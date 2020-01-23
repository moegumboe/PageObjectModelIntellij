package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;
    private By emailField = By.id("email");
    private By retrievePassword = By.id("form_submit");

    public ForgotPasswordPage(WebDriver driver){ this.driver = driver;}

    public void enterEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public EmailConfirmationPage clickRetrievePassword(){
        driver.findElement(retrievePassword).click();
        return new EmailConfirmationPage(driver);
    }

}
