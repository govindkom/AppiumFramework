package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AndoidActions extends AppiumUtils_And_IOS {
	AndroidDriver driver;
	
	// creating constructor
	
	public AndoidActions(AppiumDriver driver2) {
		super(driver2);
		this.driver=(AndroidDriver) driver2;
	}
	
	public void scrooltoText(String text) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))"));
	}
	
	
	
	public void longPressAction(WebElement ele) 
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClcikGesture", 
				ImmutableMap.of("elementId",((RemoteWebElement) ele).getId(),
		"duration",2000));
	}
	
	
	public void scrollToEndAction() {
		boolean canScrollMore;
		do
		{
			canScrollMore= (Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", 
					ImmutableMap.of(
							"left",100, "top",100, "width",200, "height",200,
							
							"direction","down",
							"percent", 3.0
							));
			
		}while(canScrollMore);
	}
	
	public void swipeAction(WebElement ele, String direction) 
	{
		((JavascriptExecutor) driver).executeScript("mobile:swipeGesture", ImmutableMap.of(
				"elementId",((RemoteWebElement)ele).getId(),
		
		"direction", direction,
		"percent",0.75
		
		));
	}
}
