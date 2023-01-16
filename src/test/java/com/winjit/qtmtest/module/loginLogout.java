package com.winjit.qtmtest.module;

                import org.openqa.selenium.*;
                import org.openqa.selenium.support.ui.ExpectedConditions;
                import org.openqa.selenium.support.ui.WebDriverWait;

                import java.util.ArrayList;
                import java.util.List;

public class loginLogout extends base {

    //Accept the windows pop up before login
   public void acceptLoginPopup() throws InterruptedException {
       //pop up -Are you want to open it through Connecta YES or NO
       setUpDriver();
       new WebDriverWait(driver, 500).until(ExpectedConditions.elementToBeClickable(By.name("&No"))).click();

       Thread.sleep(20000);
       // Server is not operation pop up with OK button
       List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
       driver.switchTo().window(windowHandles.get(0));

       driver.findElementByName("&OK").click();
       Thread.sleep(2000);

   }

   //login to QTM
    public void loginToQTM() throws InterruptedException {

        //Add Credentials and database to login to QTM
        List<String> windowHandles1 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles1.get(0));

        driver.findElementByAccessibilityId("txtUserName").sendKeys(getElementFromConfig("username"));
        driver.findElementByAccessibilityId("txtPassword").sendKeys(getElementFromConfig("password"));

        driver.findElementByName(getElementFromConfig("databaseName")).click();
        driver.findElementByName("OK").click();

        Thread.sleep(20000);
    }

    //First Accept the pop up then login
    public void loginAndAcceptPopUp() throws InterruptedException {
        acceptLoginPopup();
        loginToQTM();
    }

    //log out the QTM and close the driver
    public void logout(){
       cleanUpDriver();
    }
}