package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AlertTests extends BaseTests {

    @Test
    public void testAcceptAlert(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getAlertMessage(),"You successfuly clicked an alert","Message is not correct!");
    }

    @Test
    public void testGetTextFromAlert(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerConfirm();
        String alertMessage = alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();
        assertEquals(alertMessage,"I am a JS Confirm","Alert message is not correct!");
    }

    @Test
    public void testSetInputInAlert(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerPrompt();

        String myMessage = "TA Rocks!!!";
        alertsPage.alert_setInput(myMessage);
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getAlertMessage(),"You entered: " + myMessage,"Message is not correct!!!");

    }


}
