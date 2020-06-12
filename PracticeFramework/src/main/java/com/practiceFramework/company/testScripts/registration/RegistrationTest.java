package com.practiceFramework.company.testScripts.registration;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.practiceFramework.company.helper.assertion.AssertionHelper;
import com.practiceFramework.company.helper.browserConfiguration.config.ObjectReader;
import com.practiceFramework.company.helper.logger.LoggerHelper;
import com.practiceFramework.company.pageObject.LoginPage;
import com.practiceFramework.company.pageObject.MyAccountPage;
import com.practiceFramework.company.pageObject.RegistrationPage;
import com.practiceFramework.company.testbase.TestBase;

public class RegistrationTest extends TestBase{
	
	private final Logger log = LoggerHelper.getLogger(RegistrationTest.class);
	LoginPage loginPage;
	RegistrationPage register;
	MyAccountPage myAccountPage;
	
	@Test
	public void testRegistration(){
		// go to application
		getApplicationUrl(ObjectReader.reader.getUrl());
		
		loginPage = new LoginPage(driver);
		loginPage.clickOnSignInLink();
		loginPage.enterRegistrationEmail();
		
		register = loginPage.clickOnCreateAnAccount();
		
		// enter registration data
		register.setMrRadioButton();
		register.setFirstName("firstName");
		register.setLastname("lastname");
		register.setPassword("password");
		register.setAddress("address");
		register.setDay("5");
		register.setMonth("June");
		register.setYear("2017");
		register.setYourAddressFirstName("yourAddressFirstName");
		register.setYourAddressLastName("yourAddressLastName");
		register.setYourAddressCompany("yourAddressCompany");
		register.setYourAddressCity("yourAddressCity");
		register.setYourAddressState("Alaska");
		register.setYourAddressPostCode("99501");
		register.setMobilePhone("9999999999");
		register.setAddressAlias("addressAlias");
		register.clickRegistration();
		
		myAccountPage = new MyAccountPage(driver);
		boolean status = myAccountPage.isYourAccountPageMessage();
		log.info("Verifying TestRegistration...");
		AssertionHelper.updateTestStatus(status);
	}
}
