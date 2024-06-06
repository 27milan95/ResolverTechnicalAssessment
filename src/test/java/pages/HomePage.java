package pages;

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
	
		@FindBy(xpath = "//*[text()='Test 1']")
		public WebElement Test1;
		
		@FindBy(id = "inputEmail")
		public WebElement EmailID;
		
		@FindBy(id = "inputPassword")
		public WebElement Password;
		
		@FindBy(xpath = "//button[@class='btn btn-lg btn-primary btn-block']")
		public WebElement SignInButton;
		
		
		
		@FindBy(xpath = "//*[text()='Test 2']")
		public WebElement Test2;
		
		@FindBy(xpath = "//li[@class='list-group-item justify-content-between']")
		public List<WebElement> Test2_ListItem;
		
		@FindBy(xpath = "//span[@class='badge badge-pill badge-primary']")
		public List<WebElement> Test2_BadgeList;
		
		
		
		@FindBy(xpath = "//*[text()='Test 3']")
		public WebElement Test3;
		
		@FindBy(xpath = "//button[@class='btn btn-secondary dropdown-toggle']")
		public WebElement Test3_dropdown;
		
		@FindBy(xpath = "//a[text() ='Option 3']")
		public WebElement dropdown_Option3;
		
		
		
		@FindBy(xpath = "//*[text()='Test 4']")
		public WebElement Test4;
		
		@FindBy(xpath = "(//button[@class='btn btn-lg btn-primary'])[1]")
		public WebElement Test4_PrimaryButton;
		
		@FindBy(xpath = "//button[@class='btn btn-lg btn-secondary']")
		public WebElement Test4_SecondaryButton;
		
		
		
		@FindBy(xpath = "//*[text()='Test 5']")
		public WebElement Test5;
		
		@FindBy(id = "test5-button")
		public WebElement Test5_button;
		
		@FindBy(id = "test5-alert")
		public WebElement Test5_ActualSuccessMessage;
		
		
		
		@FindBy(xpath = "//*[text()='Test 6']")
		public WebElement Test6;

		
		public HomePage() {
			PageFactory.initElements(browser, this);
		
		}
		
		public void ScrollToElement(WebElement Element) {
			JavascriptExecutor jse = (JavascriptExecutor) browser;
		    jse.executeScript("arguments[0].scrollIntoView(true);", Element);
		}
		
		public void waitForElement(WebElement Element) {
			 WebDriverWait wait = new WebDriverWait(browser, 10);
			  wait.until(ExpectedConditions.elementToBeClickable(Element));
		}
		
		public String CellValue(int row, int column) {
			String actualCellValue = browser.findElement(By.xpath("//*[@id=\"test-6-div\"]/div/table/tbody/tr["+(row+1)+"]/td["+(column+1)+"]")).getText();
			return actualCellValue;
		}
		
		public String ActualListItem(int n) {
			String ListItemAndBadgeValue = Test2_ListItem.get(n).getText();
			String ListItem = ListItemAndBadgeValue.substring(0,ListItemAndBadgeValue.length()-2);
			return ListItem;
		}
}
