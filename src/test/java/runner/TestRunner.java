/*package runner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.service.ExtentService;
import constants.Constants;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;

import static stepdefinition.CommonStepDef.browsername;
import static stepdefinition.CommonStepDef.browserversion;


@RunWith(Cucumber.class)

@CucumberOptions(
		features = "src/test/resources/features",
		glue = "stepdefinition",
		dryRun = false,
		monochrome = true,
		plugin = {
				"rerun:target/failed_scenarios.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		       }
		)

public class TestRunner extends AbstractTestNGCucumberTests{

	private static TestRunner runnerInstance;

	private TestRunner() {

	}
	public static TestRunner getInstance(WebDriver driver) {
		if(runnerInstance==null) {
			runnerInstance = new TestRunner();
			//this.driver = driver;
		}
		return runnerInstance;
	}

	@BeforeClass
	public static void prepareEnvironment() {

		TestRunner.generateReportMetadata();
		System.out.println("@BeforeClass method call");

	}

	@AfterClass
	public static void generateReportMetadata() {

		Properties properties =new Properties();
		try {
			properties.load(TestRunner.class.getResourceAsStream("/config.properties"));
			Constants.APP_URL = properties.getProperty("APP_URL");
			System.out.println("URL inside generateReportMetadata: "+Constants.APP_URL);

		}catch(IOException e) {
			e.printStackTrace();
		}
		//DriverManager manager = new DriverManager();
		//WebDriver driver = manager.getDriver();

/*String browsername = ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities().getBrowserName();
		System.out.println("browserName is:"+browsername);
		String browserversion = ((RemoteWebDriver) DriverManager.getDriver()).getCapabilities().getVersion();
		System.out.println("browserVersion is:"+browserversion);*//*



		//String browsername = null;
		//String browserversion = null;

		//List<String> obj=  launchbrowser(browsername,browserversion);
		//System.out.println("List Objects: "+obj);
		//for (int i = 0; i < obj.size(); i++) {
		//System.out.println(obj.toString());
			//System.out.println((String) obj.get(0));
		//System.out.println((String) obj.get(1));
			//browsername = (String) obj.get(0);
			//browserVersion = (String) obj.get(1);

			//System.out.println("inside for" +browsername);
			//System.out.println("inside for" +browserVersion);
		//}

		try {
			System.out.println("generateReportMetadata first success");
			System.out.println("Browser Name value is: "+browsername);
			System.out.println("Browser Version value is: "+browserversion);

			*/
/*ExtentService.getInstance().setSystemInfo("App Name", "https://v2webfeature.mmh-demo.com");
			ExtentService.getInstance().setSystemInfo("Os Name", System.getProperty("os.name"));
			ExtentService.getInstance().setSystemInfo("Os Version", "10");
			ExtentService.getInstance().setSystemInfo("Browser Name", "CHROME");
			ExtentService.getInstance().setSystemInfo("Browser Version", "106");
			ExtentService.getInstance().setSystemInfo("User Name", "Bhaanureaka");*//*



			ExtentReports extentReports = ExtentService.getInstance();
			extentReports.setSystemInfo("App Name", Constants.APP_URL);
			extentReports.setSystemInfo("Os Name", System.getProperty("os.name"));
			extentReports.setSystemInfo("Os Version", System.getProperty("os.version"));
			extentReports.setSystemInfo("Browser Name", browsername);
			extentReports.setSystemInfo("Browser Version", browserversion);
			extentReports.setSystemInfo("User Name", System.getProperty("user.name"));
			System.out.println("generateReportMetadata second success");
		}
		catch(Exception ex){
			System.out.println("generateReportMetadata exception: "+ex.getMessage());
		}


	}
}
*/
