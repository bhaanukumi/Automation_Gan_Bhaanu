package stepdefinition;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.CommonUtils;
import webdriver_manager.DriverManager;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

public class CommonStepDef {
	
	private static String scenarioName=null;
	
	public static String getScenarioName() {
		return scenarioName;
	}
	
	private static final Logger LOGGER = LogManager.getLogger(CommonStepDef.class);
    //launch browser

    public static WebDriver driver = DriverManager.getDriver();
	public static String browsername;
	public static String browserversion;
	public static String strSystemName;
    

    @Before
    public void beforeScenario(Scenario scenario){
    	LOGGER.info("Execution Started");
        try {
        	scenarioName=scenario.getName();
        	LOGGER.info("Instantiation the CommonUtils");
        	LOGGER.info("Loading the Property");
        	CommonUtils.getInstance().loadProperties();
        	LOGGER.info("Checking the Driver is Null");
        	if(DriverManager.getDriver()==null) {
        		LOGGER.info("Driver is NULL,Instating");

				List<String> obj=DriverManager.launchbrowser(browsername,browserversion);
				browsername = (String) obj.get(0);
				System.out.println("Browser Name value is: "+browsername);
				browserversion = (String) obj.get(1);
				System.out.println("Browser Version value is: "+browserversion);
        		CommonUtils.getInstance().initWebElements();

				try {
					strSystemName= InetAddress.getLocalHost().getHostName();
					System.out.println("strSystemName value is: "+strSystemName);

				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
        	}
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @AfterStep
    public void attachScreenshot(Scenario scenario) {
    	
    	if(scenario.isFailed()) {
    		byte[]screenshotTaken = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    		scenario.attach(screenshotTaken, "image/png", "errorscreen");
    	}
    }
   

}
