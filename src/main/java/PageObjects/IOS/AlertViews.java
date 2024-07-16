package PageObjects.IOS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utils.IOSActions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AlertViews extends IOSActions{

	IOSDriver driver;
	
	
	public AlertViews(IOSDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	// creating WebElemenet
	@iOSXCUITFindBy(accessibility="Alert Views")
	private WebElement alertViews;
	
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeStaticText[`label=='Text Entry'`]")
	private WebElement textEntryMenu;
	
	
	@iOSXCUITFindBy(iOSNsPredicate="type=='XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")
			private WebElement confirmMenuItemp;
	
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeCell")
	private WebElement textbox;
	
	@iOSXCUITFindBy(accessibility="OK")
	private WebElement acceptPopUp;
	
	@iOSXCUITFindBy(iOSNsPredicate="name BEGINSWITH[c] 'A message'")
	private WebElement confirmmessage;
	
	@iOSXCUITFindBy(iOSNsPredicate="label=='Confirm'")
	private WebElement submit;
	
	
	public void selectAlertViews() {
		alertViews.click();
	}
	
	public void fillTextLabel(String name) {
		textEntryMenu.click();
		textbox.sendKeys(name);
		acceptPopUp.click();
	}
	
	public String getConfirmMessage() {
		confirmMenuItemp.click();
		return confirmmessage.getText();
	}

}
