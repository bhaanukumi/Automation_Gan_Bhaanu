package runner;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.service.ExtentService;
import constants.Constants;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;

import static stepdefinition.CommonStepDef.*;
import static stepdefinition.LoginStepDef.strAppVersion;


@CucumberOptions(features = {"@target/failed_scenarios.txt"},
        monochrome = true,
        glue = {"stepdefinition"},
        plugin = {
                "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "html:reports/WEB/index.html",
                "json:reports/WEB/cucumber.json"
        })



    public class RerunnerTestng  extends AbstractTestNGCucumberTests {

    @AfterClass
    public void teardown() {

        /*
        ExtentService.getInstance().setSystemInfo("Application Name", "V2 Feature Development");
        ExtentService.getInstance().setSystemInfo("Application URL", Constants.APP_URL);
        ExtentService.getInstance().setSystemInfo("Execution Build", strAppVersion);
        ExtentService.getInstance().setSystemInfo("Operating System", System.getProperty("os.name"));
        ExtentService.getInstance().setSystemInfo("Operating System Version", System.getProperty("os.version"));
        ExtentService.getInstance().setSystemInfo("Execution Browser", browsername);
        ExtentService.getInstance().setSystemInfo("Browser Version", browserversion);
        ExtentService.getInstance().setSystemInfo("Execution Machine", strSystemName);
        ExtentService.getInstance().setSystemInfo("Automation QA", System.getProperty("user.name"));
        */
        System.out.println("This is a RerunnerTestng teardown method");

        ExtentReports extentReports = ExtentService.getInstance();
        extentReports.setSystemInfo("Application Name", "MMH-NZ V2 Feature Development");
        extentReports.setSystemInfo("Application URL", Constants.APP_URL);
        ExtentService.getInstance().setSystemInfo("Execution Build", strAppVersion);
        extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
        extentReports.setSystemInfo("Operating System Version", System.getProperty("os.version"));
        extentReports.setSystemInfo("Execution Browser", browsername);
        extentReports.setSystemInfo("Browser Version", browserversion);
        extentReports.setSystemInfo("Execution Machine", strSystemName);
        extentReports.setSystemInfo("Automation QA", System.getProperty("user.name"));


    }
}
