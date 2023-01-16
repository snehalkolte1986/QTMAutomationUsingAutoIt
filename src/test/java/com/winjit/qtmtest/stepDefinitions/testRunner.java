package com.winjit.qtmtest.stepDefinitions;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import com.cucumber.listener.Reporter;



@CucumberOptions(

        features = {"classpath:Features"},
        glue = {"com.winjit.qtmtest.stepDefinitions"},
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
             //  "com.cucumber.listener.ExtentCucumberFormatter:"
        }
)


public class testRunner extends AbstractTestNGCucumberTests {

}

