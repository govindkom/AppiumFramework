package PageObject.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utils.AndoidActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndoidActions {
	
	AndroidDriver driver;
	
	public CartPage(AppiumDriver driver2) {
		super(driver2);
		this.driver=(AndroidDriver) driver2;
		PageFactory.initElements(new AppiumFieldDecorator(driver2),this);
	}

	
	
	@AndroidFindBy(id="com,androidsample.generalstore:id/productPrice")
	public List<WebElement> productList;
	
	@AndroidFindBy(id="com,androidsample.generalstore:id/totalAmountLbl")
	public WebElement totalamount;

	
	@AndroidFindBy(id="com,androidsample.generalstore:id/termsButton")
	public WebElement terms;
	
	@AndroidFindBy(id="android:id/button1")
	public WebElement acceptButton;
	
	@AndroidFindBy(id="com,androidsample.generalstore:id/btnProceed")
	public WebElement proceed;
	
	@AndroidFindBy(className="android.widget.CheckBox")
	public WebElement checkBox;
	
	
	public List<WebElement> getProductList(){
		return productList;
	}
	
	public double getProductSum() {
		int count=productList.size();
		
		double totalsum=0;
		for(int i=0;i<count;i++) {
			String amountstring=productList.get(i).getText();
			
			Double price= getFormattedAmount(amountstring);
			totalsum=totalsum+price;
		}
		return totalsum;
	}
	
	public Double getTotalAmountDisplayed() {
		return getFormattedAmount(totalamount.getText());
	}
	
	public Double getFormattedAmount(String amount) {

		Double price=Double.parseDouble(amount.substring(1));
		return null;
	}

	public void acceptTermsConditions() {
		longPressAction(terms);
		acceptButton.click();
	}
	
	public void submitOrder() {
	checkBox.click();
	proceed.click();
	}
}
