package com.qa.automation.mystoreapplication.pages;

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
 * it contains methods which are used to perform actions on shopping page of dresses page
 * @author mir.ali
 *
 */
public class ShoppingPage extends MyStoreUtility{
	 Browser browser;
	
	private ReportLogService report=new ReportLogServiceImpl(ShoppingPage.class);
	
	static Properties shoppg=loadProperties(MyStoreAppConstants.SHOPPINGPROP);
	
	public ShoppingPage(Browser browser)
	{
		
		this.browser=browser;
	}
	
	

	public void clickDresses()
	{
		
		String lnkdresses=shoppg.getProperty("lnkdresses");
		browser.getClick().performClick(LocatorType.XPATH, lnkdresses);
	}
	
	// selecting product from casual dresses category
	public void addCasualDress()
	{	
		browser.getWait().implicitWait(3000);
		report.info("Click on dresses");
		clickDresses();
		browser.getWait().HardPause(2000);
		report.info("click on casual dresses category");
		String lnkcasualdress=shoppg.getProperty("lnkcasualdresses");
		browser.getClick().performClick(LocatorType.XPATH, lnkcasualdress);
		browser.getWait().HardPause(2000);
		WebElement casualdressitem=browser.getDriver().findElement(By.xpath("//h5[@itemprop='name']//a[contains(text(),'Printed Dress')]"));
		browser.getPageScroll().down(600);
		browser.getWait().HardPause(2000);
		browser.getMouse().mouseHover(casualdressitem);
		report.info("selecting the product from casual dress category");
		browser.getWait().HardPause(2000);
		String casualdress=shoppg.getProperty("btnmore_casualdress");
		browser.getClick().performClick(LocatorType.XPATH, casualdress);
	}
	
//  selecting product from evening dresses category	
	public void addEveningDress()
	{	
		browser.getWait().HardPause(2000);
		report.info("click on dresses");
		clickDresses();
		browser.getWait().HardPause(2000);
		report.info("click on everning dresses category");
		String lnkevngdress=shoppg.getProperty("lnkeveningdresses");
		browser.getClick().performClick(LocatorType.XPATH, lnkevngdress);
		browser.getWait().HardPause(2000);
		WebElement evngdressimg=browser.getDriver().findElement(By.xpath("//h5[@itemprop='name']//a[contains(text(),'Printed Dress')]"));
		browser.getPageScroll().down(600);
		browser.getWait().HardPause(2000);
		browser.getMouse().mouseHover(evngdressimg);
		report.info("selecting the product from everning dress category");
		browser.getWait().HardPause(2000);
		String evngdress=shoppg.getProperty("btnmore_evngdress");
		browser.getClick().performClick(LocatorType.XPATH, evngdress);
	}
	
// selecting product from summer dresses category	
	public void addSummerDress()
	{	
		browser.getWait().HardPause(2000);
		report.info("click on dresses");
		clickDresses();
		browser.getWait().HardPause(2000);
		String lnksummerdress=shoppg.getProperty("lnkSummerDresses");
		report.info("click on summer dresses category");
		browser.getClick().performClick(LocatorType.XPATH, lnksummerdress);
		browser.getWait().HardPause(2000);
		WebElement summerdressimg=browser.getDriver().findElement(By.xpath("//h5[@itemprop='name']//a[contains(text(),'Printed Chiffon')]//ancestor::div[@class='product-container']"));
		browser.getPageScroll().down(600);
		browser.getWait().HardPause(2000);
		browser.getMouse().mouseHover(summerdressimg);
		report.info("selecting the product from summary dresses category ");
		browser.getWait().HardPause(2000);
		String summerdress=shoppg.getProperty("btnmore_summerdress");
		browser.getClick().performClick(LocatorType.XPATH, summerdress);
	}
		
	
}
