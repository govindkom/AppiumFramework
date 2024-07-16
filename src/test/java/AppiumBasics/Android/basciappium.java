package AppiumBasics.Android;

import java.net.URI;
import java.net.URL;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class basciappium {

	
	@Test
	public void AppiumTest() throws Exception {
		
		
		//code
		// what kind of apps automationg that object create class===> AndroidDriver, IosDriver
		// Appium code--> appium server --> mobile
		
		UiAutomator2Options options= new UiAutomator2Options();
		options.setDeviceName("govindemulator");
		
		
		
		AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
	}
}
