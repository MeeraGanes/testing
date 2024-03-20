package com.flightBooking.selectFlightPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.flightBooking.base.TestBase;
import com.flightBooking.base.testUtil.TestUtil;
import com.flightBooking.signInPage.SiginInPage;

public class SelectFlightPage extends TestBase {
	
	@FindBy(xpath="(//a[@class='package-select'])[1]")
	WebElement select;
}
