package AppiumBasics.Android;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.android.CartPage;
import PageObject.android.FormPage;
import PageObject.android.ProductCatalogue;
import Utils.AppiumUtils_And_IOS;
import io.appium.java_client.AppiumDriver;

public class eCommerec_tc_4_Hybrid extends AppiumUtils_And_IOS {
	public AppiumDriver driver;
	
	public eCommerec_tc_4_Hybrid(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	
	@Test(dataProvider= "getData" )
	//public void fillForm(String name, String gender, String country) throws Exception {
		
	public void fillForm(HashMap<String, String> input) throws Exception{
	FormPage formpage= new FormPage(driver);// this also we can ignore if we add in base class as global bvariblae
		
		// set name login
		//formpage.setNameField(name);
	formpage.setNameField(input.get("name"));
		
		// set gender
		//formpage.setGender(gender);
	formpage.setGender(input.get("gender"));
		// sekect country
		
		//formpage.setCountry(country);
	formpage.setCountry(input.get("country"));
		// submit form 
		formpage.submitForm();
		
		
		// creatr object for Productcatalogue page to access methods and element
//		
//	ProductCatalogue productcatlog=new ProductCatalogue( AppiumDriver driver);
//		productcatlog.addItemToCartByIndex(0);
//		productcatlog.addItemToCartByIndex(0);
//		
//	// goto cart page
//		productcatlog.goToCartPage();
		
		
		//if we are returning into same method then we can writre code below ==> if we are not creating object
		
	//	CartPage cartpage=productcatlog.goToCartPage();
		
		// if we are creating object then use code lioke below
		
		CartPage cartpage= new CartPage(driver);
		double totalsum=cartpage.getProductSum();
	Double displayFormattedSum=	cartpage.getTotalAmountDisplayed();
	
		//Assert.assertEquals(totalsum, displayFormattedSum);
		cartpage.acceptTermsConditions();
		cartpage.submitOrder();
		
		
		
	}
	// when going to send data through dataprovider methos
//	@DataProvider
//	public Object[][] getData() {
//	
//		return new Object[][] {{"govind","female","argentina"}};
//	}

	
	// when data sending through JSon file
	@DataProvider
	public Object[][] getData() throws Exception {
		List<HashMap<String, String>> data= getJsonData(System.getProperty("user.dir")+"//src//test//java//TestData//eCommerce.json");
	return new Object[][] { {data.get(0)}, {data.get(1)}};
	}
}
