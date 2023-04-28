package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.LoginPage;
import page.TestBase;

public class LoginTest {
	
	private WebDriver driver;
	
	private LoginPage loginPage;
	
	@Test
	public void UserShouldAbleToLogin() throws Exception {
		driver=TestBase.init();
		loginPage = PageFactory.initElements(driver,LoginPage.class);
		loginPage.clickSignin();
		loginPage.enterUsername("dipak23b@yahoo.com");
		loginPage.enterPassword("Aayush@2022");
		loginPage.clickSignInButton();
		String expectedErrorMessage = "Something went wrong. Please try again.";
		String actualErrorMessage = loginPage.errMessage();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	    TestBase.tearDown(driver);	
	}
	
}
