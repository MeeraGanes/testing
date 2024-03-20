package searchForFlightsTest;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import com.flightBooking.base.TestBase;
import com.flightBooking.base.testUtil.TestUtil;
import com.flightBooking.searchPage.SearchForFlightsPage;
import com.flightBooking.selectFlightPage.SelectFlightPage;
import com.flightBooking.signInPage.SiginInPage;

public class SearchForFlightsTest extends TestBase {

	SiginInPage signInPage;
	SearchForFlightsPage searchforFlights;
	SelectFlightPage selectFlightPage;
	TestUtil testUtil;

	public SearchForFlightsTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		// signInPage = new SiginInPage();
		searchforFlights = new SearchForFlightsPage();

	}

	@Test(priority = 1)
	public void fillFlightSearchDetails() {
		searchforFlights.clickonOneWay();
		searchforFlights.selectLeavingFrom("LHR");
		searchforFlights.selectGoingTo("MAA");
		searchforFlights.selectDate();
		selectFlightPage = searchforFlights.clickOnSearch();
		

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.isSuccess()) {
			try {
				TestUtil.takeScreenshotAtEndOfTest();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		//driver.quit();
	}
}
