package forgotPassword;

import base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ForgotPasswordTests extends BaseTests {

    @Test
    public void forgotPassword(){
        var forgotpassword = homePage.clickforgotPassword();
        forgotpassword.enterEmail("forgot@password.com");
        var emailConfirmationPage = forgotpassword.clickRetrievePassword();
        String emailConfirmationMessage = emailConfirmationPage.getEmailSentMessage();
        assertTrue(emailConfirmationMessage.contains("Your e-mail's been sent!"));
    }

}
