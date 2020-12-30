package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import MiHCM.HomePage;
import MiHCM.LoginPage;
import Utility.ReadExcel;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginData {

		WebDriver driver;

	    LoginPage objLogin;
	    HomePage objHomePage;
	    ReadExcel excel = new ReadExcel();
	
	

	@Given("^I have user name and password$")
	public void i_have_user_name_and_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver","C:\\seldrv\\chromedriver.exe");
		
	    driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://demo.guru99.com/V4/");
	 
	}
	
	@When("^I successfully login$")
	public void i_successfully_login() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		objLogin = new LoginPage(driver);
		
		String loginPageTitle = objLogin.getLoginTitle();
	    objLogin.loginToGuru99(excel.readExcel(1,1, ".\\Data\\data.xlsx","Sheet1"), excel.readExcel(1,2, ".\\Data\\data.xlsx","Sheet1"));
		   
	}
	
	@Then("^I should navigate to the home page$")
	public void i_should_navigate_to_the_home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		objHomePage = new HomePage(driver);

		   //Verify home page

		    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
		    driver.close();
	   
}
	
	
}
