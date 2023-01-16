package com.winjit.qtmtest.stepDefinitions;

        import com.winjit.qtmtest.module.base;
        import com.winjit.qtmtest.module.loginLogout;
        import io.cucumber.java.en.Given;


public class loginQTMStepDef extends base {
    loginLogout loginModule = new loginLogout ();

    @Given("Login to QTM")
    public void login_to_qtm() throws InterruptedException {
        loginModule.loginAndAcceptPopUp();
    }
}
