package page_objects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Test;
import webdriver_manager.DriverManager;

public class LoginPage {

	//webelement find
	
	private static LoginPage loginInstance;
	
	private LoginPage() {
		
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

	@FindBy(xpath="//button/span/span[text()='MMHLOGO']")
	private WebElement MMHLOGO;

	@FindBy(how = How.XPATH, using = "//div[@class='appVersion']")
	public WebElement txtAppVersion;

    @Test
	public void enterEmail(String email) {
		EMAIL.sendKeys(email);
	}
	@Test
	public void enterPassword(String password) {
		PASSWORD.sendKeys(password);		
	}
	@Test
	public void clickLoginButton() {
		LOGIN.click();		
	}
	@Test
	public void clickSigninButton() {
		SIGNIN.click();

	}
	@Test
	public void clickSignoutButton() {
       //boolean isClicked = false;

	//SIGNOUT.click();

	JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
	executor.executeScript("arguments[0].click();", SIGNOUT);
	//isClicked = true;

		//System.out.println("clickSignoutButton return value is :"+isClicked);
       //return isClicked;
	}
	@Test
	public void click_MMH_logo(){
		JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
		executor.executeScript("arguments[0].click();", MMHLOGO);
	}
}
