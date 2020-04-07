package com.qa.automation.mystoreapplication.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.qa.automation.mystoreapplication.config.MyStoreAppConstants;
import com.qa.automation.mystoreapplication.utilities.MyStoreUtility;


/**
 * this class contains the elements of checkout page and methods to perform checkout for placing the order
 * and it extends the MyStoreUtility class
 * @author mir.ali
 *
 */
public class CheckoutPage extends MyStoreUtility{
	Browser browser;
	JavascriptExecutor executor;
	
	private ReportLogService report=new ReportLogServiceImpl(CheckoutPage.class);

	static Properties checkoutprop=loadProperties(MyStoreAppConstants.CHECKOUTPROP);
	
	public CheckoutPage(Browser browser)
	{
		this.browser=browser;
	}
	
//	 clicking ont he proceed to checkout after adding item into cart	
	public void clickProceedToCheckOut()
	{	
		browser.getWait().HardPause(3000);
		report.info("click on proceed to checkout button");
		WebElement proceedtochkoutbtn=browser.getDriver().findElement(By.xpath("//a[contains(@class,'button-medium')]"));
		executor=(JavascriptExecutor)browser.getDriver();
		executor.executeScript("arguments[0].click();",proceedtochkoutbtn);
	}
	
// 	clicking on the continue to shopping button	
	public void clickContinueShoppingbutton()
	{
		browser.getWait().HardPause(3000);
		report.info("click on continue shopping button");
		WebElement continueshoppingbtn=browser.getDriver().findElement(By.xpath("//div[@class='button-container']//span[contains(@class,'continue')]"));
		executor=(JavascriptExecutor)browser.getDriver();
		executor.executeScript("arguments[0].click();", continueshoppingbtn);
	}

// 	click on the proceed to checkout on summar page
	public void clickChkOutOnSummaryPage()
	{	
		browser.getWait().HardPause(2000);
		report.info("clicking on proceed to checkout button on summary page");
		String chkoutsummarybtn=checkoutprop.getProperty("chkoutsummary");
		browser.getClick().performClick(LocatorType.XPATH, chkoutsummarybtn);	
	}

// 	checkout on the address page
	public void checkOutAddress()
	{	
		browser.getWait().HardPause(2000);
		report.info("click on proceed to checkout button on address page");
		String chkoutaddress=checkoutprop.getProperty("chkoutaddress");
		browser.getClick().performClick(LocatorType.NAME, chkoutaddress);
	}

//	 checkout on shipping page	
	public void checkoutShipping()
	{	
		String termsofservice=checkoutprop.getProperty("chkboxTermsofservice");
		browser.getWait().HardPause(2000);
		report.info("Accept the terms and conditions");
		browser.getClick().performClick(LocatorType.XPATH, termsofservice);
		report.info("click on checkout button");
		String chkoutshipping=checkoutprop.getProperty("chkoutshipping");
		browser.getClick().performClick(LocatorType.NAME, chkoutshipping);
	}	
	
	
}
