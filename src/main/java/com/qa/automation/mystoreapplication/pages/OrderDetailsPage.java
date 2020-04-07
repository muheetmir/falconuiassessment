package com.qa.automation.mystoreapplication.pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;


import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

import com.qa.automation.mystoreapplication.config.MyStoreAppConstants;
import com.qa.automation.mystoreapplication.utilities.MyStoreUtility;

/**
 * it contains methods which are used to perform actions on Order details page.
 * @author mir.ali
 *
 */
public class OrderDetailsPage extends MyStoreUtility{
	 Browser browser;
	
	private ReportLogService report=new ReportLogServiceImpl(OrderDetailsPage.class);
	
	static Properties orderdet=loadProperties(MyStoreAppConstants.ORDERDETAILSPROP);
	
// 	constructor	
	public OrderDetailsPage(Browser browser)
	{
		
		this.browser=browser;
	}
	
// 	clicking on the order details button
	public void clickOrderDetails()
	{	
		report.info("clicking on sign in link");
		String btnorderdetails=orderdet.getProperty("btnorderdetails");
		browser.getClick().performClick(LocatorType.XPATH, btnorderdetails);	
	}
	
	
// 	clicking on the order reference link	
	public void clickOrderrefLink()
	{
		List<WebElement> reflink=browser.getDriver().findElements(By.xpath("//a[@class='color-myaccount']"));
		reflink.get(0).click();
		report.info("clicked on reference link");
	}
		
// 	verifying the products details in order details page.
	public void verifyProductReference()
	{
		browser.getWait().implicitWait(2000);
		String firstprodref=orderdet.getProperty("firstprdref");
		browser.getFindFromBrowser().findElementByXpath(firstprodref).isDisplayed();
		
		String secondprodref=orderdet.getProperty("secondprdtref");
		browser.getFindFromBrowser().findElementByXpath(secondprodref).isDisplayed();
		
		String thirdprodref=orderdet.getProperty("thirdprdref");
		browser.getFindFromBrowser().findElementByXpath(thirdprodref).isDisplayed();
		report.info("Product details of order has been verified");
	}
	
}
