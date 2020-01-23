package navigation;

import base.BaseTests;
import org.testng.annotations.Test;

public class NavigationTests extends BaseTests {

    @Test
    public void testNavigation(){
        homePage.clickFrames().clickLink("iFrame");
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://google.com");

    }

    @Test
    public void testSwitchTab(){
        homePage.clickMutipleWindows().clickHereLink();
        getWindowManager().switchToTab("New Window");
    }

}
