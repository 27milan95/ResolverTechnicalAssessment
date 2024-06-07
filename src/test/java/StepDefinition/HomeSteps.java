package StepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestUtilities.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.HomePage;

public class HomeSteps extends BaseClass {
	
	WebDriver browser;
	HomePage homepage;
	
	@Given("User opens browser {string} and navigate to the Home Page")
	public void user_opens_browser_and_navigate_to_the_home_page(String Browser) {	
		OpenBrowser(Browser);
		NavigateToHomePage();
		homepage = new HomePage();
	}

	@When("User navigate to {string} div")
	public void user_navigate_to_div(String text) {
		homepage.ScrollToElement(text);
	    Assert.assertTrue(homepage.getByText(text).isDisplayed());
	}

	@Then("User should see input field for Email address, Password and SignIn button")
	public void user_should_see_input_field_for_email_address_password_and_sign_in_button() {
		Assert.assertTrue(homepage.EmailID.isDisplayed());
		Assert.assertTrue(homepage.Password.isDisplayed());
		Assert.assertTrue(homepage.SignInButton.isDisplayed());
	}

	@Then("User enters EmailId {string} and Password {string} in respective fields")
	public void user_enters_email_id_and_password_in_respective_fields(String username, String password) {
		homepage.EmailID.sendKeys(username);
		homepage.Password.sendKeys(password);    
	}
	
	@Then("User should see {int} values in the list group")
	public void user_should_see_values_in_the_list_group(int ExpectedListItemCount) {
		Assert.assertEquals(homepage.Test2_ListItem.size(), ExpectedListItemCount);

	}

	@And("the second list item text should be {string}")
	public void the_second_list_item_text_should_be(String ExpectedListItem) {
		Assert.assertEquals(homepage.ActualListItem(1), ExpectedListItem);
	  
	}

	@And("its badge value should be {string}")
	public void its_badge_value_should_be(String ExpectedBagdeValue) {
		Assert.assertEquals(homepage.Test2_BadgeList.get(1).getText(), ExpectedBagdeValue);
	}

	@Then("{string} should be the selected value")
	public void should_be_the_selected_value(String SelectedOption) {
		Assert.assertEquals(homepage.Test3_dropdown.getText(), SelectedOption);	
	}

	@When("User select {string} from the dropdown")
	public void user_select_from_the_dropdown(String text) {
		homepage.Test3_dropdown.click();
		homepage.getByText(text).click();  
	}


	@Then("the first button should be enabled")
	public void the_first_button_should_be_enabled() {
		Assert.assertTrue(homepage.Test4_PrimaryButton.isEnabled());	    
	}

	@And("the second button should be disabled")
	public void the_second_button_should_be_disabled() {
		Assert.assertFalse(homepage.Test4_SecondaryButton.isEnabled());
	}

	@And("User wait for the button to be displayed")
	public void user_wait_for_the_button_to_be_displayed() {
		homepage.waitForElement(homepage.Test5_button);	 
	}

	@And("user click the button")
	public void user_click_the_button() {	 
		homepage.Test5_button.click();   
	}

	@Then("User should see a success message")
	public void user_should_see_a_success_message() {
	 Assert.assertTrue(homepage.Test5_ActualSuccessMessage.isDisplayed());
	}

	@And("the button should be disabled")
	public void the_button_should_be_disabled() {
		Assert.assertFalse(homepage.Test5_button.isEnabled());
	
	}

	@Then("the value of the cell \\({int}, {int}) should be {string}")
	public void the_value_of_the_cell_should_be(int CellRow, int CellColumn, String ExectedCellValue) {
		Assert.assertEquals(homepage.CellValue(CellRow,CellColumn), ExectedCellValue);
	}

	@After
	public void TearDownBrowser() {
		CloseBrowser();
	}
	
}
