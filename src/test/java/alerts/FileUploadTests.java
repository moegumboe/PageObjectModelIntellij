package alerts;

import base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.*;


public class FileUploadTests extends BaseTests {

    @Test
    public void testFileUpload(){
        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadfile("C:\\Users\\moekh\\Desktop\\Automation\\IntellijProjects\\resources\\chromedriver.exe");
        assertEquals(uploadPage.getUploadedFiles(),"chromedriver.exe","File is not correct");
    }
}
