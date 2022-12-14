package webdriver_manager;

import constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import utilities.RandomGeneratorUtil;
import utilities.TestdataUtil;

import java.util.Arrays;
import java.util.List;

public class DriverManager {

	/*public DriverManager(WebDriver driver) {
		super(driver);
	}
	*/
	private static final Logger LOGGER = LogManager.getLogger(DriverManager.class);

	private static WebDriver driver = null;
	public static String browsername;
	public static String browserversion;
	public static String strExecutionID;

	public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
	
	 public static List<String> launchbrowser(String browsername,String browserversion){

		 //Load testdata file
		 strExecutionID = RandomGeneratorUtil.getRandomString();
		 System.out.println("\n >> Execution String 3: " + strExecutionID);
		 System.out.println("\n >> TESTDATA_PATH is 4: " + Constants.TESTDATA_PATH);
		 System.out.println("Sheetname/Sheetname in Config File/App mentioned in Maven Goals is 5: "+Constants.ENV_VARIABLE_APPLICATION);

		 TestdataUtil.loadData(Constants.TESTDATA_PATH, Constants.ENV_VARIABLE_APPLICATION );

		 //String strExecutionType = System.getProperty(Constants.ENV_VARIABLE_EXECUTION_TYPE, "");


	        try{
	            switch (Constants.BROWSER){
	                case"chrome":
	                    WebDriverManager.chromedriver().setup();
	                    LOGGER.info("Launching"+Constants.BROWSER);
	                    driver = new ChromeDriver();
						browsername = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
						System.out.println("browserName is:"+browsername);
						browserversion = ((RemoteWebDriver) driver).getCapabilities().getVersion();
						System.out.println("browserVersion is:"+browserversion);
	                    break;

	                case "firefox":
	                    WebDriverManager.firefoxdriver().setup();
	                    LOGGER.info("Launching"+Constants.BROWSER);
	                    driver = new FirefoxDriver();
						browsername = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
						System.out.println("browserName is:"+browsername);
						browserversion = ((RemoteWebDriver) driver).getCapabilities().getVersion();
						System.out.println("browserVersion is:"+browserversion);
	                    break;

	                case "Edge":
	                    WebDriverManager.edgedriver().setup();
	                    LOGGER.info("Launching"+Constants.BROWSER);
	                    driver = new EdgeDriver();
						browsername = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
						System.out.println("browserName is:"+browsername);
						browserversion = ((RemoteWebDriver) driver).getCapabilities().getVersion();
						System.out.println("browserVersion is:"+browserversion);
	                    break;

	                case "IE":
	                    WebDriverManager.iedriver().setup();
	                    LOGGER.info("Launching"+Constants.BROWSER);
	                    driver = new InternetExplorerDriver();
						browsername = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
						System.out.println("browserName is:"+browsername);
						browserversion = ((RemoteWebDriver) driver).getCapabilities().getVersion();
						System.out.println("browserVersion is:"+browserversion);
	                    break;

	                case "Opera":
	                    WebDriverManager.operadriver().setup();
	                    LOGGER.info("Launching"+Constants.BROWSER);
	                    driver = new OperaDriver();
						browsername = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
						System.out.println("browserName is:"+browsername);
						browserversion = ((RemoteWebDriver) driver).getCapabilities().getVersion();
						System.out.println("browserVersion is:"+browserversion);
	                    break;

	                case "safari":
	                    WebDriverManager.safaridriver().setup();
	                    LOGGER.info("Launching"+Constants.BROWSER);
	                    driver = new SafariDriver();
						browsername = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
						System.out.println("browserName is:"+browsername);
						browserversion = ((RemoteWebDriver) driver).getCapabilities().getVersion();
						System.out.println("browserVersion is:"+browserversion);
	                    break;
	                    
	                default:
	                	WebDriverManager.chromedriver().setup();
	                    LOGGER.info("Launching"+Constants.BROWSER);
	                    driver = new ChromeDriver();
						browsername = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
						System.out.println("browserName is:"+browsername);
						browserversion = ((RemoteWebDriver) driver).getCapabilities().getVersion();
						System.out.println("browserVersion is:"+browserversion);
	                    break;
	            }
	        }catch (Exception e){
	            e.printStackTrace();
	        }
		 System.out.println("launchbrowser browserName is:"+browsername);
		 System.out.println("launchbrowser browserVersion is:"+browserversion);

		 return Arrays.asList(browsername,browserversion);
	    }

	public static WebDriver getDriver() {
		return driver;
	}


}
