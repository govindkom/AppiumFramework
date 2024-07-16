package AppiumBasics.IOS;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.IOS.AlertViews;
import PageObjects.IOS.HomePage;

public class eCommerceIOS_TC_5_Hybrid  extends IOSBaseTest{
	
	// to call any method we need to craete test metyhod and then need to call any object class
	
	@Test
	public void IOSTC() {
		HomePage homepage= new HomePage(driver);
		
		homepage.selectAlertViews();
		
		
		
		AlertViews alertview= new AlertViews(driver);
		alertview.fillTextLabel("hello");
		
		String actualmsg=alertview.getConfirmMessage();
		
		Assert.assertEquals(actualmsg, "A message should be a short, complete sentenece");

	}
}
