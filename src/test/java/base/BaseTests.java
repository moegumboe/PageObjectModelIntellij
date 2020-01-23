package base;

import com.google.common.io.Files;
import com.sun.source.tree.IfTree;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;

public class BaseTests {
//    regular WebDriver
//    private Webdriver driver;

    private EventFiringWebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
        goHome();
        setCookie();
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown(){
        //close entire session
        driver.quit();
    }

    @AfterMethod
    public void recordFailure(ITestResult result){

        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/"+ result.getTestName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("disable-infobars");
//        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        return options;
    }

    private void setCookie(){
        Cookie cookie = new Cookie.Builder("tau", "123")
                .domain("the-internet.herokuapp.com").build();

        driver.manage().addCookie(cookie);
    }

}
