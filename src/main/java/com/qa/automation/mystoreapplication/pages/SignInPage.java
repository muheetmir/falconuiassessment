package com.qa.automation.mystoreapplication.pages;

import java.util.Properties;
import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.qa.automation.mystoreapplication.config.MyStoreAppConstants;
import com.qa.automation.mystoreapplication.utilities.MyStoreUtility;


/**
 * this class contains the methods to perform the actions on Sign in page of MyStore application
 * @author mir.ali
 *
 */
public class SignInPage extends MyStoreUtility {
		
	 Browser browser;
		
		
private ReportLogService report=new ReportLogServiceImpl(SignInPage.class);

static Properties page=loadProperties(MyStoreAppConstants.SIGNINPROP);

	public SignInPage(Browser browser)
	{
			this.browser=browser;
	}
	
	public void enterUserName()
	{
		report.info("enter the user name");
		String username=page.getProperty("txtusername");
		browser.getTextField().enterTextField(LocatorType.ID, username,"testautomation99@gmail.com");
	}
	public void enterPassword()
	{	
		report.info("enter the password");
		String password=page.getProperty("txtpassword");
		browser.getTextField().enterTextField(LocatorType.ID, password, "Password99!");
	}
	
	public void clickSignInBtn()
	{
		report.info("click on sign in button");
		String signbtn=page.getProperty("btnsignin");
		browser.getClick().performClick(LocatorType.XPATH, signbtn);
		report.info("sign  in button is clicked");
	}
	
	
	
}
