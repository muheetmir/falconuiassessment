package com.qa.automation.mystoreapplication.testscript;



import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.qa.automation.mystoreapplication.pages.AddToCartPage;
import com.qa.automation.mystoreapplication.pages.CheckoutPage;
import com.qa.automation.mystoreapplication.pages.HomePage;
import com.qa.automation.mystoreapplication.pages.OrderDetailsPage;
import com.qa.automation.mystoreapplication.pages.PaymentPage;
import com.qa.automation.mystoreapplication.pages.ShoppingPage;
import com.qa.automation.mystoreapplication.pages.SignInPage;
import com.qa.automation.mystoreapplication.testsuite.TestSuiteBase;


/*
 * this class perform the actions for placing the order from signing into the application with the known user details 
 * and adding then selecting the product from home page and adding it into the cart and placing the order.
 */
public class MyStoreOrder extends TestSuiteBase{
	
	private ReportLogService report = new ReportLogServiceImpl(MyStoreOrder.class);
	SignInPage signpg;	//declaring the ref for SinginPage class and instantiating in respective methods below
	HomePage homepg;  	//declaring the ref for HomePage class and instantiating in respective methods below
	AddToCartPage addcartpg;	//declaring the ref for AddToCartPage class and instantiating in respective methods below
	CheckoutPage chkoutpg;	//declaring the ref for CheckoutPage class and instantiating in respective methods below
	PaymentPage paypage;	//declaring the ref for PaymentPage class and instantiating in respective methods below
	ShoppingPage shoppage; 	// declaring the reference for ShoppingPage class and instantiating below
	OrderDetailsPage orddetailpg; 	// declaring the reference for OrderDetailsPage class and instantiating below
	
	
// Launching the website and performing sign in with known credentials
	@Test(priority=1)
	@Parameters({"os", "osVersion", "browser", "browserVersion"})
	public void signIntoMyStore(String os, String osVersion, String br, String browserVersion) {
		report.info("Opening browser: "+ br);
		browser.openURL("http://automationpractice.com/index.php", os, osVersion, br, browserVersion);
		browser.getWait().HardPause(2000);
		report.info("Maximizing browser window");
		browser.maximizeWindow();
		String mystoretitle=browser.getCurrentPageTitle();
		Verify.verifyString(mystoretitle,"My Store", "Verifying the login page title");
		homepg=new HomePage(browser);
		browser.getWait().implicitWait(2000);
		homepg.clickSignInLink();
		browser.getWait().HardPause(2000);
		signpg=new SignInPage(browser);
		signpg.enterUserName();
		signpg.enterPassword();
		signpg.clickSignInBtn();
		homepg=new HomePage(browser);
		browser.getWait().HardPause(3000);
		homepg.isLoginSuccessfull();
		
}
	
// adding the item into cart
	
	@Test(priority=2)
	public void addToCart()
	{
		browser.getWait().implicitWait(4000);
		report.info("Adding item into cart");
		shoppage=new ShoppingPage(browser);
		//shoppage.clickDresses();
		shoppage.addCasualDress();
		addcartpg=new AddToCartPage(browser);
		addcartpg.updateSize();
		addcartpg.clickAddToCartBtn();
		chkoutpg=new CheckoutPage(browser);
		chkoutpg.clickContinueShoppingbutton();
		//shoppage.clickDresses();
		shoppage.addEveningDress();
		addcartpg.updateSize();
		addcartpg.clickAddToCartBtn();
		chkoutpg.clickContinueShoppingbutton();
		//shoppage.clickDresses();
		shoppage.addSummerDress();
		addcartpg.updateSize();
		addcartpg.clickAddToCartBtn();
	}
	
// checking out the selected product
	@Test(priority=3)
	public void performCheckout()
	{	
		browser.getWait().implicitWait(2000);
		chkoutpg=new CheckoutPage(browser);
		chkoutpg.clickProceedToCheckOut();
		chkoutpg.clickChkOutOnSummaryPage();
		chkoutpg.checkOutAddress();
		//browser.getWait().HardPause(3000);
		chkoutpg.checkoutShipping();
		
	}
	
// paying the order by check and confirming the order
	@Test(priority=4)
	public void confirmOrder()
	{
		browser.getWait().implicitWait(2000);
		paypage=new PaymentPage(browser);
		paypage.clickPayByCheck();
		paypage.clickConfirmOrder();
		paypage.verifyOrderPlaced();	
	}


	@Test(priority=5)
	public void verifyOrderDetails()
	{
		homepg.clickUserNameLink();
		orddetailpg=new OrderDetailsPage(browser);
		orddetailpg.clickOrderDetails();
		orddetailpg.clickOrderrefLink();
		orddetailpg.verifyProductReference();
	}
	
	@AfterTest
	public void signout()
	{
		homepg.clickSignOut();
	}
}
