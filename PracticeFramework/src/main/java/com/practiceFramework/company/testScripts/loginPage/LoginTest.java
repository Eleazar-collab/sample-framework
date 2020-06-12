package com.practiceFramework.company.testScripts.loginPage;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.practiceFramework.company.helper.assertion.AssertionHelper;
import com.practiceFramework.company.helper.browserConfiguration.config.ObjectReader;
import com.practiceFramework.company.helper.logger.LoggerHelper;
import com.practiceFramework.company.pageObject.LoginPage;
import com.practiceFramework.company.testbase.TestBase;

public class LoginTest extends TestBase{
	private final Logger log = LoggerHelper.getLogger(LoginTest.class);
	
	@Test(description="Login test with valid credentials")
	public void testLoginToApplication(){
		getApplicationUrl(ObjectReader.reader.getUrl());
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
		
		boolean status = loginPage.verifySuccessLoginMsg();
		
		log.info("Verifying Login...");
		
		AssertionHelper.updateTestStatus(status);
	}
}
