package testcases.signInPageTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import com.flightBooking.base.TestBase;
import com.flightBooking.searchPage.SearchForFlightsPage;
import com.flightBooking.signInPage.SiginInPage;

public class SignInPageTest extends TestBase {
	SiginInPage signInPage;
	SearchForFlightsPage searchForFlightsPage;

	public SignInPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		signInPage = new SiginInPage();
	}

	@Test
	public void loginTest() {
		searchForFlightsPage = signInPage.login(prop.getProperty("email"), prop.getProperty("password"));
		System.out.print("Login Successfull");
	}

	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}

}
