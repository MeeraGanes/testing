package com.flightBooking.searchPage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flightBooking.base.TestBase;
import com.flightBooking.base.testUtil.TestUtil;
import com.flightBooking.selectFlightPage.SelectFlightPage;

public class SearchForFlightsPage extends TestBase {
	TestUtil testUtil;
	@FindBy(xpath = "//a[contains(text(),'One Way')]")
	WebElement oneWayLabel;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchbtn;

	@FindBy(xpath = "//input[@class='airport-related' and @name='seg0_from']")
	WebElement leavingFrom;

	@FindBy(xpath = "//input[@class='airport-related' and @name='seg0_to']")
	WebElement goingTo;

	@FindBy(xpath = "//div[@class='form-field-wrap form-field-from-date']/input[@id='date-picker-1']")
	WebElement calender;

	public SearchForFlightsPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickonOneWay() {
		TestUtil.waitForElementsToBeClickable(oneWayLabel);
		oneWayLabel.click();

	}

	public void selectLeavingFrom(String fromPlace) {

		leavingFrom.sendKeys(fromPlace);
	}

	public void selectGoingTo(String toPlace) {

		goingTo.sendKeys(toPlace);

	}

	// 2024-04-30
	public void selectDate() {

		LocalDate currentDate = LocalDate.now();
		LocalDate after30DaysDate = currentDate.plusDays(30);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = after30DaysDate.format(formatter);
		calender.click();
		WebElement dateElement = driver.findElement(By.xpath("//a[@data-cal-selector-formated= '" + formattedDate + "']"));
		dateElement.click();


	}

	public SelectFlightPage clickOnSearch() {
		searchbtn.click();
		return new SelectFlightPage();
	}

}
