package PageObject.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utils.AndoidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalogue extends AndoidActions{
	
	AndroidDriver driver;
	
	
	
	// create constructor
	
	public ProductCatalogue(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	//WebElement
	@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	public List<WebElement> addtocart;
	
	
	@AndroidFindBy(id="com,androidsample.generalstore:id/appbar_btn_cart")
	public WebElement cart;
	
	public void addItemToCartByIndex(int index) {
		addtocart.get(index).click();
	}
	
	public void goToCartPage() throws Exception {
		cart.click();
		Thread.sleep(2000);
	}
	
	// the baove ,method we can write like below as well
	/*
	 * public CartPage goToCartPage() throws Exception { cart.click();
	 * Thread.sleep(2000); return new CartPage(driver); }
	 */
}
