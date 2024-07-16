package AppiumBasics.IOS;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class IOSBaseTest {

	public IOSDriver driver;
	public AppiumDriverLocalService service;
	
	

	@BeforeClass
	public void IOSConfiguration() throws MalformedURLException {
		
		new AppiumServiceBuilder().withAppiumJS(new File("C://Users//shree//Local//AppData//npm//npm-build//main.js"))
		.withIPAddress("127.0.0.1").usingPort(4723).build();

		service.start();
		
		XCUITestOptions options =new XCUITestOptions();
		options.setDeviceName("iphone 13 pro");
		options.setApp("/users/govind/desktop/UIKitCatalog.app");
		options.setPlatformVersion("15.5");
		
		//Appium---> WebDriver Agent --> IOS Apps
		
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));
		
		driver=new IOSDriver(new URL("http://127.0.0.1:4723"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	
		
		// xpath, classname, IOS, IosClassChain, IOSPredicateString, accessibility id, id
		
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		service.stop();
	}
}
