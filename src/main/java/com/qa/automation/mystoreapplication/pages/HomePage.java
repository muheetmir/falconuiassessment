package com.qa.automation.mystoreapplication.pages;

import java.util.Properties;


import org.openqa.selenium.JavascriptExecutor;



import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.falcon.automation.verifyresult.VerificationManager;
import com.qa.automation.mystoreapplication.config.MyStoreAppConstants;
import com.qa.automation.mystoreapplication.utilities.MyStoreUtility;

/**
 * it contains methods which are used to perform actions on home page elements.
 * @author mir.ali
 *
 */
public class HomePage extends MyStoreUtility{
	 Browser browser;
	JavascriptExecutor js;
	
	private ReportLogService report=new ReportLogServiceImpl(CheckoutPage.class);
	
	static Properties homepgpro=loadProperties(MyStoreAppConstants.HOMEPAGEPROP);
	
	public HomePage(Browser browser)
	{
		
		this.browser=browser;
	}
	
	public void clickSignInLink()
	{	
		report.info("clicking on sign in link");
		String signinlink=homepgpro.getProperty("signinLink");
		browser.getClick().performClick(LocatorType.XPATH, signinlink);	
	}
	//verifying the user authentication after login 
	public void isLoginSuccessfull()
	{
		String uname=homepgpro.getProperty("user_first_last_name");
		String fn_ln=browser.getFindFromBrowser().findElementByXpath(uname).getText();
		VerificationManager.verifyString(fn_ln, "test automation", "verifying user first and last name");
	}
			
	//click on sign out
	public void clickSignOut()
	{	
		report.info("click on sign out");
		String signout=homepgpro.getProperty("btnsignout");
		browser.getClick().performClick(LocatorType.XPATH, signout);
	}
	
	public void clickUserNameLink(){
		report.info("click on user name link");
	String lnkusername=homepgpro.getProperty("linkusername");
	browser.getClick().performClick(LocatorType.XPATH, lnkusername);
		
	}
	
}
