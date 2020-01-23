package frames;

import base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class NestedFramesTests extends BaseTests {

    @Test
    public void clickNestedFramesTest(){
        var framesPage = homePage.clickFrames();
        framesPage.clickLink("Nested Frames");

        String left = "LEFT";
        String bottom = "BOTTOM";


        String leftFrameText = framesPage.getLeftFrameText();
        String bottomFrameText = framesPage.getBottomFrameText();

        assertEquals(leftFrameText,left,"Left frame text doesn't match");
        assertEquals(bottomFrameText,bottom,"Bottom frame text doesn't match");

    }
}
