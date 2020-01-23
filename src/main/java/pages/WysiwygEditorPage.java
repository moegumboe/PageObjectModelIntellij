package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage {
    private WebDriver driver;
    private String edirorIframsId = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By decreaseIndentButton = By.cssSelector("#mceu_12 button");

    public WysiwygEditorPage(WebDriver driver) { this.driver = driver; }

    public void clearTextArea(){
        switchtoEditArea();
        driver.findElement(textArea).clear();
        switchToMainArea();
    }

    public void setTextArea(String text){
        switchtoEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }

    public String getTextFromEditor(){
        switchtoEditArea();
        String text = driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }

    public void decreaseIndention(){
        driver.findElement(decreaseIndentButton).click();
    }


    private void switchtoEditArea(){
        driver.switchTo().frame(edirorIframsId);
    }

    private void switchToMainArea(){
        driver.switchTo().parentFrame();
    }

}
