package com.flightBooking.signInPage;

import java.util.Scanner;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flightBooking.base.TestBase;
import com.flightBooking.base.testUtil.TestUtil;
import com.flightBooking.searchPage.SearchForFlightsPage;


public class SiginInPage extends TestBase{
	@FindBy(css="div.user-icon")
	WebElement signInButton;
	
	@FindBy(xpath="//span[contains(text(), 'Email')]")
	WebElement loginThruEmail;
	
//	@FindBy(xpath="//ul[@class ='login-input-items']/li[2]/button")
//	WebElement ContinueBtnAfterMailEntry;
	
	@FindBy(id="login-modal-account-login-email")
	WebElement email;
	
	@FindBy(id="login-modal-account-login-password")
	WebElement password;
	//verification code is sent to email 
	@FindBy(xpath="//input[@id ='login-modal-account-login-totp']")
	WebElement verificationCode;
	
	@FindBy(xpath="(//button[contains(text(),'Continue')])[2]")
	WebElement continueBtnAfterPwdEntry;
	
	
	@FindBy (xpath="//button[contains(text(),'Sign in') and @class='login-modal-submit-btn is-main-button regular login-modal-button']")
	WebElement signbtnAfterEntry;
	public SiginInPage() {
		PageFactory.initElements(driver, this);
	}
	
	public SearchForFlightsPage login(String un, String pwd){
		signInButton.click();
		loginThruEmail.click();
		
		email.sendKeys(un);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementsByClassName('login-modal-submit-btn is-main-button regular login-modal-button').click();");
		
//		TestUtil.waitForElementsToBeClickable(ContinueBtnAfterMailEntry);
	//ContinueBtnAfterMailEntry.click();

		password.sendKeys(pwd);
		//Manually entering Verification code through console
		
	try (
		Scanner scanner = new Scanner(System.in)) {
			System.out.print("Please enter the verification code: ");
			String Code = scanner.nextLine();
			verificationCode.sendKeys(Code);
		}
        signbtnAfterEntry.click();
		
		return new SearchForFlightsPage();
	}
	
}
