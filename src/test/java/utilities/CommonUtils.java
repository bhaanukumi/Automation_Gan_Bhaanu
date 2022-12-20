package utilities;

import constants.Constants;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import page_objects.LoginPage;
import stepdefinition.CommonStepDef;
import webdriver_manager.DriverManager;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class CommonUtils {

	private static CommonUtils commonUtilsInstance = null;

	//public static CommonUtils commonUtilsInstance;

	private CommonUtils() {
		
	}
	public static CommonUtils getInstance() {
		
		if(commonUtilsInstance==null) {
			commonUtilsInstance =new CommonUtils();
		}
		return commonUtilsInstance;
	}
	
	//config file loader

	public void loadProperties(String strBrowsernameJenkinsParameter) {


		System.out.println("Inside loadProperties");
		System.out.println("URL is: "+Constants.APP_URL);
		Properties properties =new Properties();
		try {
			properties.load(getClass().getResourceAsStream("/config.properties"));
		}catch(IOException e) {
			e.printStackTrace();
		}

		Constants.APP_URL = properties.getProperty("APP_URL");
		System.out.println("URL is: "+Constants.APP_URL);
		Constants.BROWSER = properties.getProperty("BROWSER");
		Constants.EMAIL = properties.getProperty("EMAIL");
		Constants.PASSWORD = properties.getProperty("PASSWORD");
		Constants.CHROME_DRIVER_LOCATION = properties.getProperty("CHROME_DRIVER_LOCATION");

		Constants.ENV_VARIABLE_APPLICATION = properties.getProperty("ENV_VARIABLE_APPLICATION");
		System.out.println("Sheetname/Sheetname in Config File/App mentioned in Maven Goals is 1: "+Constants.ENV_VARIABLE_APPLICATION);
		Constants.ENV_VARIABLE_ENVIRONMENT = properties.getProperty("ENV_VARIABLE_ENVIRONMENT");
		System.out.println("Environment 2: "+Constants.ENV_VARIABLE_ENVIRONMENT);

	}
	
	public void initWebElements() {

		PageFactory.initElements(DriverManager.getDriver(), LoginPage.getInstance());
			}
	
	public void takeScreenshot() {

		File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(CommonStepDef.getScenarioName()+".png"));
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
