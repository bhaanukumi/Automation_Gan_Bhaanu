package page_objects;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import stepdefinition.LoginStepDef;
import webdriver_manager.DriverManager;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static stepdefinition.CommonStepDef.driver;

public class LoginPage {

	//webelement find
	private static LoginPage loginInstance;
	private static final Logger LOGGER = LogManager.getLogger(LoginStepDef.class);
	
	private LoginPage() {
		//LoginPage1
	}
	public static LoginPage getInstance() {
		if(loginInstance==null) {
			loginInstance = new LoginPage();
		}
		return loginInstance;
	}
	
	@FindBy(xpath="//span[text()='Login']")
	private WebElement LOGIN;
	
	@FindBy(xpath="//input[@data-placeholder='Email address']")
	private WebElement EMAIL;
	
	@FindBy(xpath="//input[@data-placeholder='Password']")
	private WebElement PASSWORD;
	
	@FindBy(xpath="//button/span[text()=' Sign in ']")
	private WebElement SIGNIN;
	
	@FindBy(xpath="//button/span/span[text()='SIGN OUT']")
	private WebElement SIGNOUT;

	//@FindBy(xpath="//img[@src='assets/images/MMH-logo.svg']")
	//private WebElement MMHLOGO;

	@FindBy(xpath="//button/span/span[text()='MMHLOGO1']")
	private WebElement MMHLOGO;

	@FindBy(how = How.XPATH, using = "//div[@class='appVersion']")
	public WebElement txtAppVersion;


	public void enterEmail(String email) {
		EMAIL.sendKeys(email);
	}

	public void enterPassword(String password) {
		PASSWORD.sendKeys(password);		
	}

	public void clickLoginButton() {
		LOGIN.click();		
	}

	public void clickSigninButton() {
		SIGNIN.click();

	}

	public void clickSignoutButton() {
       //boolean isClicked = false;
	//SIGNOUT.click();
	JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
	executor.executeScript("arguments[0].click();", SIGNOUT);
	//isClicked = true;
		//System.out.println("clickSignoutButton return value is :"+isClicked);
       //return isClicked;
	}

	public void click_MMH_logo(){
		JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
		executor.executeScript("arguments[0].click();", MMHLOGO);
	}

	public void openNewTab(){


		try{
		System.out.println("Inside openNewTab");

		//Store the ID of the original window
		String originalWindow = driver.getWindowHandle();

		System.out.println("originalWindow value is: "+originalWindow);

		//Check we don't have other windows open already
		assert driver.getWindowHandles().size() == 1;

		System.out.println("No Of Windows are: "+driver.getWindowHandles().size());

		//Click the link which opens in a new window
		//driver.findElement(By.linkText("new window")).click();

		//Wait for the new window or tab
		//wait.until(numberOfWindowsToBe(2));

		String n = Keys.chord(Keys.CONTROL,Keys.ENTER);
		driver.findElement(By.id("open-tab")).sendKeys(n);

		System.out.println("New Tab Opened Successfully");

		//Loop through until we find a new window handle
		for (String windowHandle : driver.getWindowHandles()) {
			if(!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		}catch (Exception e) {
			LOGGER.error(e);
			Assert.fail(e.getMessage());
		}
		//Wait for the new tab to finish loading content
		//wait.until(titleIs("Selenium documentation"));
	}


}
