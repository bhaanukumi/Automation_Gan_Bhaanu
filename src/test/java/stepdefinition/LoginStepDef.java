package stepdefinition;

import constants.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import page_objects.LoginPage;
import utilities.TestdataUtil;
import webdriver_manager.DriverManager;

public class LoginStepDef {


	private static final Logger LOGGER = LogManager.getLogger(LoginStepDef.class);
	public static String strAppVersion;


	@Given("the url hit in successfully")
	public void the_url_hit_in_successfully() {
		try {
			//DriverManager.getDriver().get(Constants.APP_URL);

			System.out.println("----> get URL Value is : "+TestdataUtil.getValue("&URL&"));

			DriverManager.getDriver().get(TestdataUtil.getValue("&URL&"));

			DriverManager.getDriver().manage().window().maximize();
			LOGGER.info("the url hit in successfully");
		}catch (Exception e) {
			LOGGER.error(e);
			Assert.fail(e.getMessage());
		}
	}

	@And("login button clicked successfully")
	public void login_button_clicked_successfully() throws InterruptedException {
		try {
			LoginPage.getInstance().clickLoginButton();
			Thread.sleep(3000);
			LOGGER.info("login button clicked successfully");
		}catch (Exception e) {
			LOGGER.error(e);
			Assert.fail(e.getMessage());
		}
	}

	@And("Enter the Email as {string}")
	public void enter_the_email_as(String string) throws InterruptedException {
		try {
			LoginPage.getInstance().enterEmail(Constants.EMAIL);
			Thread.sleep(3000);
			LOGGER.info("Enter the Email as {string}");
		}catch (Exception e) {
			LOGGER.error(e);
			Assert.fail(e.getMessage());
		}

	}

	@And("Enter the Password as {string}")
	public void enter_the_password_as(String string) throws InterruptedException {
		try {
			LoginPage.getInstance().enterPassword(Constants.PASSWORD);;
			Thread.sleep(3000);
			LOGGER.info("Enter the Password as {string}");
		} catch (Exception e) {
			LOGGER.error(e);
			Assert.fail(e.getMessage());
		}

	}

	@When("Click the Login button")
	public void click_the_login_button() throws InterruptedException {

		try {
			LoginPage.getInstance().clickSigninButton();
			Thread.sleep(6000);
			strAppVersion = LoginPage.getInstance().txtAppVersion.getText();
			System.out.println("strAppVersion is: "+strAppVersion);
			LOGGER.info("Click the Login button");
		} catch (Exception e) {
			LOGGER.error(e);
			Assert.fail(e.getMessage());
		}
	}

	@Then("User logged in successfully")
	public void user_logged_in_successfully() {
		//boolean loggedin = false;
		try {
			Thread.sleep(6000);
			String url = DriverManager.getDriver().getCurrentUrl();		
			if(url.contains("dashboard")){
				LOGGER.info("User logged in successfully");
				System.out.println("User logged in successfully");
				//loggedin= true;

			}			
		} catch (Exception e) {
			LOGGER.error(e);
			Assert.fail(e.getMessage());
		}
		//System.out.println("user_logged_in_successfully return value is : "+loggedin);
		//return loggedin;
	}


	@And("Click signout button")
	public void click_signout_button() throws InterruptedException {
		//boolean loggedout = false;
		try {
			System.out.println("wait 6 secs");
			Thread.sleep(6000);
			LoginPage.getInstance().clickSignoutButton();
			System.out.println("Signout button Clicked Successfully");
			//Thread.sleep(6000);
			//DriverManager.getDriver().close();
		} catch (Exception e) {
			LOGGER.error(e);
			Assert.fail(e.getMessage());
		}
		//System.out.println("click_signout_button return value is : "+loggedout);
		//return loggedout;

	}


	@And("I click MMH Logo")
	public void iClickMMHLogo() throws InterruptedException {

			try {
				LoginPage.getInstance().click_MMH_logo();
			} catch (Exception e) {
				LOGGER.error(e);
				Assert.fail(e.getMessage());
			}

	}
}
