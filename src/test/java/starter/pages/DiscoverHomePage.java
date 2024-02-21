package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import starter.setup.Init;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.JavascriptExecutor;


import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class DiscoverHomePage extends PageObject {
	static Logger log = LogManager.getLogger();

	@FindBy(xpath = "//span[text()=' Checking account']/parent::a")
	WebElementFacade checkingAccountTab;

	@FindBy(xpath = "//span[text()=' Retirement accounts']/parent::a")
	WebElementFacade retirementAccountsTab;
	
	@FindBy(xpath = "(//span[text()=\" Online savings account\"])[1]")
	WebElementFacade onlineSavingsAccountTab;
	
	@FindBy(xpath = "//span[text()=\" Money market account\"]")
	WebElementFacade moneyMarketAccountTab;
	
	@FindBy(xpath = "//span[text()=\" Certificate of deposit\"]")
	WebElementFacade certificateOfDepositTab;

	@FindBy(xpath = "//i[@class='reskin-icon hm-hut']")
	WebElementFacade homeIcon;

	@FindBy(xpath = "//i[@class='reskin-icon ham-menu']")
	WebElementFacade hamIcon;

	@FindBy(xpath = "//span[text()=' Online Banking Home ']")
	WebElementFacade onlineBankingHome;

	@FindBy(xpath = "//button[@id=\"login\"]")
	WebElementFacade loginButtonDesktop;
	
	@FindBy(xpath = "//a[@id=\"mobile-login\"]")
	WebElementFacade loginButtonMobile;

	@FindBy(xpath = "//input[@id=\"login-account\"]")
	WebElementFacade userIdDesktop;
	
	@FindBy(xpath = "//input[@id=\"userId\"]")
	WebElementFacade userIdMobile;

	@FindBy(xpath = "//input[@id=\"login-password\"]")
	WebElementFacade passwordDesktop;
	
	@FindBy(xpath = "//input[@id=\"password\"]")
	WebElementFacade passwordMobile;

	public void go() {
		goToUrl(Init.getAppUrl());
		log.info("Launching browser-->");
	}

	@Step
	public void goToUrl(String url) {
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		getDriver().get(url);
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		log.info("Starting execution");
		log.info("Application url::" + url);
	}
	
	public void clickRetirementAccountsTab() {
		log.info("Clicking RetirementAccounts Tab-->");
		retirementAccountsTab.waitUntilClickable();
		retirementAccountsTab.click();
	}
	
	public void clickCheckingAccountTab() {
		log.info("Clicking CheckingAccount Tab-->");
		checkingAccountTab.waitUntilClickable();
		checkingAccountTab.click();
	}

	public void clickOnlineSavingsAccountTab() {
		log.info("Clicking OnlineSavingsAccount Tab-->");
		onlineSavingsAccountTab.waitUntilClickable();
		onlineSavingsAccountTab.click();
	}
	
	public void clickMoneyMarketAccountTab() {
		log.info("Clicking MoneyMarketAccount Tab-->");
		moneyMarketAccountTab.waitUntilClickable();
		moneyMarketAccountTab.click();
	}
	
	public void clickCertificateOfDepositTab() {
		log.info("Clicking CertificateOfDeposit Tab-->");
		certificateOfDepositTab.waitUntilClickable();
		certificateOfDepositTab.click();
	}	

	public void navigateToHomePage() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(50))
                .ignoring(NoSuchElementException.class);

        WebElement hamMenu = wait.until(driver -> driver.findElement(By.xpath("//i[@class='reskin-icon ham-menu']")));

		  if(hamIcon.isCurrentlyVisible()) { 
			  log.info("Clicking Ham Icon-->");
			  hamIcon.waitUntilClickable(); 
			  hamIcon.click();
			  log.info("Clicking Online Banking Home option-->");
			  onlineBankingHome.waitUntilClickable(); 
			  onlineBankingHome.click(); 
		  } else {
		 
			log.info("Clicking Home Icon-->");
			homeIcon.waitUntilClickable();
			homeIcon.click();
		}
	}

	public void verifyDiscoverHomePage() {
		log.info("Verifying Discover Home Page-->");
		waitFor(checkingAccountTab);
		Assert.assertEquals("Online Banking | Open an Online Bank Account | Discover", getTitle());
	}

	public void verifyRetirementsAccountPage() {
		log.info("Verifying RetirementsAccount Page-->");
		Assert.assertEquals("Individual Retirement Accounts - Online IRAs | Discover", getTitle());
	}

	public void verifyCheckingAccountPage() {
		log.info("Verifying CheckingAccount Page-->");
		Assert.assertEquals("Checking Account - No Fees with Cashback Debit | Discover", getTitle());
	}
	
	public void verifyOnlineSavingsAccountPage() {
		log.info("Verifying OnlineSavingsAccount Page-->");
		Assert.assertEquals("High Yield Savings Account - No Monthly Fees | Discover", getTitle());
	}
	
	public void verifyMoneyMarketAccountPage() {
		log.info("Verifying MoneyMarketAccount Page-->");
		Assert.assertEquals("Money Market Account with High Interest Rates | Discover", getTitle());
	}
	
	public void verifyCertificateOfDepositPage() {
		log.info("Verifying CertificateOfDeposit Page-->");
		Assert.assertEquals("Certificate of Deposit | High Yield CD | Discover", getTitle());
	}

	@Step
	public void clickLogin() {
		log.info("Clicking Log In button-->");
		if(loginButtonDesktop.isCurrentlyVisible()) {
			loginButtonDesktop.waitUntilClickable();
			loginButtonDesktop.click();
		} else {
			loginButtonMobile.waitUntilClickable();
			loginButtonMobile.click();
		}
	}
	

	@Step
	public void enterCredentials() {
		log.info("Entering credentials-->");
		if(userIdDesktop.isCurrentlyVisible()) {
			userIdDesktop.sendKeys("admin");
			passwordDesktop.sendKeys("admin123");
		} else {
			userIdMobile.sendKeys("admin");
			passwordMobile.sendKeys("admin123");
		}
	}

	@Step
	public void closeTabs() {
		log.info("Closing tabs-->");
		String lambdaTestCloud = System.getProperty("lambdaTestCloud");	
		if(lambdaTestCloud != null && lambdaTestCloud.equalsIgnoreCase("true")) {
			log.info("Execution performed on LambdaTest");
			//((JavascriptExecutor)getDriver()).executeScript("lambda-status=passed");
		} 
		getDriver().quit();
	}
}
