package frames;

import base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FrameTests extends BaseTests {

    @Test
    public void testWysiwygEditor(){
        var wysiwygPage = homePage.clickWysiwygEditor();
        wysiwygPage.clearTextArea();

        String text1 = "Hello ";
        String text2 = "World!!!";

        wysiwygPage.setTextArea(text1);
        wysiwygPage.decreaseIndention();
        wysiwygPage.setTextArea(text2);
        assertEquals(wysiwygPage.getTextFromEditor(),text1+text2, "Message is not correct!");
    }
}
