package AppiumBasics.Android;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AndroidBaseTest {

	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	
	public void configureAppium() throws Exception {
		
		Properties prop= new Properties();
		FileInputStream fi= new FileInputStream(System.getProperty("user.dir")+"//src//main//java//data.properties");
		
		prop.load(fi);
		
		String ipAddress= prop.getProperty("ipAddress");
		String port= prop.getProperty("port");
		
	//	service=startAppiumServer(ipAddress, Integer.parseInt(port));
		
		
		service= new AppiumServiceBuilder().withAppiumJS(new File("C://Users//shree//Local//AppData//npm//npm-build//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		
		service.start();
		
		
		UiAutomator2Options options= new UiAutomator2Options();
		
		
		// if you want to work on emulator
		options.setDeviceName("rahulphone");
		
		// if you want to work on real time /device
		options.setDeviceName("Android Device");
		
		//path of chromedrivcer exe
		options.setChromedriverExecutable("//users//rahul//documents//chromedriver.exe");
		
		// set app which we are going to test
		options.setApp("//users//govind//wprkingcode//appium//src/test//java/resources//ApiDemos-debug.apk");
		
		
		
		driver=new AndroidDriver(new URL("http://127.0.01:4723"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
			
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		service.stop();
	}
	
	
}
