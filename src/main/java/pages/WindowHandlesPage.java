package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowHandlesPage {
    private WebDriver driver;
    private By clickHere = By.linkText("Click Here");

    public WindowHandlesPage(WebDriver driver) { this.driver = driver; }

    public void clickHereLink(){
        driver.findElement(clickHere).click();
    }


}
