package PageObject.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utils.AndoidActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndoidActions {
	AppiumDriver driver;
	
	public FormPage(AppiumDriver driver2) {
		super(driver2);
		this.driver=driver2;
		PageFactory.initElements(new AppiumFieldDecorator(driver2), this);
	}
	
	// create Page obhect element===> Locatrors
	@AndroidFindBy(id="com,androidsample.generalstore:id/namefield")
	private WebElement namefield;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement femaleoption;
	
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
	private WebElement Maleoption;
	// create acction Methods
	
	@AndroidFindBy(id="android:id/text1")
	private WebElement countryselection;
	
	@AndroidFindBy(id="com,androidsample.generalstore:id/btnLetsShop")
	public WebElement shopButton;
	
	
	
	public void setNameField(String name) {
		namefield.sendKeys(name);
		((HidesKeyboard) driver).hideKeyboard();
	}
	
	
	public void setCountry(String countryName) {
		countryselection.click();
		scrooltoText(countryName);
		//countryselection.sendKeys(countryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
	}
	
	
	public void setGender(String gender) {
		if(gender.contains("female")) {
			femaleoption.click();
		}
		else
		{
			Maleoption.click();
		}
		
	}
		public void submitForm() {
			shopButton.click();
		}
		
		
		
		
		
		
	}

