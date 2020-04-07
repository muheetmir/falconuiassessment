package com.qa.automation.mystoreapplication.pages;

import java.util.Properties;

import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.qa.automation.mystoreapplication.config.MyStoreAppConstants;

import com.qa.automation.mystoreapplication.utilities.MyStoreUtility;


/**
 * It contains methods which are use to add the item into cart and it extends MyStoreUtility class.
 * @author mir.ali
 *
 */
public class AddToCartPage extends MyStoreUtility {
	Browser browser;
	
	private ReportLogService report=new ReportLogServiceImpl(AddToCartPage.class);

	static Properties addtocartprop=loadProperties(MyStoreAppConstants.ADDTOCARTPROP);
	
	public AddToCartPage(Browser browser)
	{
		this.browser=browser;
	}
	
	
	// clicking on the add to cart button
	public void clickAddToCartBtn()
	{
		report.info("click on add to cart button");
		String btnaddtocart=addtocartprop.getProperty("btnaddtocart");
		browser.getClick().performClick(LocatorType.NAME, btnaddtocart);
		
	}
	
	// updating the quantity of the product selected on add to cart page
	public void updateQuantity(int quantity)
	{
		report.info("updating the item quantity");
		String qty=addtocartprop.getProperty("txtquantity");
		browser.getTextField().enterTextField(LocatorType.XPATH,qty,"2");
	}
	
	// updating the size of selected product at add to cart page.
	public void updateSize()
	{	
		report.info("updating the item size");
		//String drpsize=addtocartprop.getProperty("drpitemsize");
		browser.getWait().HardPause(2000);
		browser.getSelectDropDown().selectByVisibleText(LocatorType.ID, "group_1", "M");
	}
	
}
