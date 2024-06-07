package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestUtilities.BaseClass;

public class HomePage extends BaseClass {
		
		@FindBy(id = "inputEmail")
		public WebElement EmailID;
		
		@FindBy(id = "inputPassword")
		public WebElement Password;
		
		@FindBy(xpath = "//button[@class='btn btn-lg btn-primary btn-block']")
		public WebElement SignInButton;
				
		@FindBy(xpath = "//li[@class='list-group-item justify-content-between']")
		public List<WebElement> Test2_ListItem;
		
		@FindBy(xpath = "//span[@class='badge badge-pill badge-primary']")
		public List<WebElement> Test2_BadgeList;
				
		@FindBy(id = "dropdownMenuButton")
		public WebElement Test3_dropdown;
				
		@FindBy(xpath = "(//button[@class='btn btn-lg btn-primary'])[1]")
		public WebElement Test4_PrimaryButton;
		
		@FindBy(xpath = "//button[@class='btn btn-lg btn-secondary']")
		public WebElement Test4_SecondaryButton;
				
		@FindBy(id = "test5-button")
		public WebElement Test5_button;
		
		@FindBy(id = "test5-alert")
		public WebElement Test5_ActualSuccessMessage;
		
		public HomePage() {
			PageFactory.initElements(browser, this);	
		}
		
		public WebElement getByText(String text) {
			return browser.findElement(By.xpath("//*[text()='"+text+"']"));
		}
		
		public void ScrollToElement(String text) {
			JavascriptExecutor jse = (JavascriptExecutor) browser;
		    jse.executeScript("arguments[0].scrollIntoView(true);", this.getByText(text));
		}
		
		public void waitForElement(WebElement Element) {
			 WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
			  wait.until(ExpectedConditions.elementToBeClickable(Element));
		}
		
		public String CellValue(int row, int column) {
			String actualCellValue = browser.findElement(By.xpath("//table/tbody/tr["+(row+1)+"]/td["+(column+1)+"]")).getText();
			return actualCellValue;
		}
		
		public String ActualListItem(int n) {
			String ListItemAndBadgeValue = Test2_ListItem.get(n).getText();
			String ListItem = ListItemAndBadgeValue.substring(0,ListItemAndBadgeValue.length()-2);
			return ListItem;
		}
}
