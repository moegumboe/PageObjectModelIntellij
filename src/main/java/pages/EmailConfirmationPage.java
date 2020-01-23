package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailConfirmationPage {
    private WebDriver driver;
    private By emailSentMessage = By.id("content");

    public EmailConfirmationPage(WebDriver driver) { this.driver = driver;}

    public String getEmailSentMessage(){
        return driver.findElement(emailSentMessage).getText();

    }
}
