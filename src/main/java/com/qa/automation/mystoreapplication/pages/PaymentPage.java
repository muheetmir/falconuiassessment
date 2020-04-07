package com.qa.automation.mystoreapplication.pages;

import java.util.Properties;
import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.enums.LocatorType;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.falcon.automation.verifyresult.VerificationManager;
import com.qa.automation.mystoreapplication.config.MyStoreAppConstants;
import com.qa.automation.mystoreapplication.utilities.MyStoreUtility;


/**
 * this class contains the methods which are used to perform actions on payment page of My store application
 * @author mir.ali
 *
 */
public class PaymentPage extends MyStoreUtility{
	Browser browser;
	
	private ReportLogService report=new ReportLogServiceImpl(PaymentPage.class);

	static Properties paymentprop=loadProperties(MyStoreAppConstants.PAYMENTPROP);
	
	public PaymentPage(Browser browser)
	{
		this.browser=browser;
	}
	
	//clicking on the paybycheck link
	public void clickPayByCheck()
	{
		report.info("clicking on the pay by check link");
		String chequepay=paymentprop.getProperty("lnkchequepay");
		browser.getClick().performClick(LocatorType.XPATH, chequepay);
	}

	// clicking on the confirm order button
	public void clickConfirmOrder()
	{
		report.info("clicking on the confirm order button");
		String confirmorder=paymentprop.getProperty("btnconfirmorder");
		browser.getClick().performClick(LocatorType.XPATH, confirmorder);
	}
	
	// verifying the order successfully placed statement.
	public void verifyOrderPlaced()
	{
		String confirmordertext=paymentprop.getProperty("orderplacedmessage");
		String ordermesssage= browser.getFindFromBrowser().findElementByXpath(confirmordertext).getText();
		VerificationManager.verifyString(ordermesssage, "Your order on My Store is complete.", "verify order confirmaiton");
	}
	
	

	
	
	
	
	
}
