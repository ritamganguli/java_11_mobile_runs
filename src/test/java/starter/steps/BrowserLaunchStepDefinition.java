package starter.steps;

import io.cucumber.java.en.When;
import starter.pages.DiscoverHomePage;
import io.cucumber.java.en.Then;

public class BrowserLaunchStepDefinition {
	DiscoverHomePage dfsHome;
	
	@When("user navigates to the appUrl")
	public void goToAppUrl() {
		dfsHome.go();
	}
	
	@When("user clicks on Retirement Accounts Tab")
	public void userClicksOnRetirementAccountsTab() {
		dfsHome.clickRetirementAccountsTab();
	}

	@When("user clicks on Home page icon")
	public void userClicksOnHomePageIcon() {
		dfsHome.navigateToHomePage();
	}

	@When("user clicks on Checking Account Tab")
	public void userClicksOnCheckingAccountTab() {
		dfsHome.clickCheckingAccountTab();
	}
	
	@When("user clicks on Online Savings Account Tab")
	public void userClicksOnOnlineSavingsAccountTab() {
		dfsHome.clickOnlineSavingsAccountTab();
	}
	
	@When("user clicks on Money Market Account Tab")
	public void userClicksOnMoneyMarketAccountTab() {
		dfsHome.clickMoneyMarketAccountTab();
	}
	
	@When("user clicks on Certificate of Deposit Tab")
	public void userCertificateOfDepositTab() {
		dfsHome.clickCertificateOfDepositTab();
	}
	
	@When("user clicks on log in button") 
	 public void click_Login() {
		 dfsHome.clickLogin(); 
	 }
	 
	 @When("user inputs id and password") 
	 public void enter_Credentials() {
		 dfsHome.enterCredentials(); 
	 }

	@Then("landing page should be displayed")
	public void landingPageShouldBeDisplayed() {
		dfsHome.verifyDiscoverHomePage();
	}

	@Then("Individual Retirement Accounts page should be displayed")
	public void individualRetirementAccountsPageShouldBeDisplayed() {
		dfsHome.verifyRetirementsAccountPage();
	}

	@Then("Checking Account page should be displayed")
	public void checkingAccountPageShouldBeDisplayed() {
		dfsHome.verifyCheckingAccountPage();
	}
	
	@Then("Online Savings Account page should be displayed")
	public void onlineSavingsAccountsPageShouldBeDisplayed() {
		dfsHome.verifyOnlineSavingsAccountPage();
	}
	
	@Then("Money Market Account page should be displayed")
	public void moneyMarketAccountPageShouldBeDisplayed() {
		dfsHome.verifyMoneyMarketAccountPage();
	}
	
	@Then("Certificate of Deposit page should be displayed")
	public void certificateOfDepositPageShouldBeDisplayed() {
		dfsHome.verifyCertificateOfDepositPage();
	}
	
	 @Then("all tabs should be closed") 
	 public void close_tabs() {
		 dfsHome.closeTabs(); 
	 }
}
