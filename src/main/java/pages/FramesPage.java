package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {
    private WebDriver driver;
    private String topFrame = "frame-top";
    private String leftFrame = "frame-left";
    private String bottomFrame = "frame-bottom";
    private By body = By.cssSelector("body");

    public FramesPage(WebDriver driver) { this.driver = driver; }

    public void clickLink(String LinkText){
        driver.findElement(By.linkText(LinkText)).click();
    }

    public String getLeftFrameText(){
        driver.switchTo().frame(topFrame);
        driver.switchTo().frame(leftFrame);
        String text = driver.findElement(body).getText();
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        return text;
    }

    public String getBottomFrameText(){
        driver.switchTo().frame(bottomFrame);
        String text = getFrameText();
        driver.switchTo().parentFrame();
        return text;
    }

    private String getFrameText(){
        return driver.findElement(body).getText();
    }


}
