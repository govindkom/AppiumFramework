package Utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AppiumUtils_And_IOS  {
	AppiumDriver driver;
	// for intitializing driver create constructoer
	
	public AppiumUtils_And_IOS(AppiumDriver driver) {
		this.driver=driver;
	}
	
	// we cna store both classes common method here(Android and IOS)
	
	public Double getFormattedAmount(String amount) {

		Double price=Double.parseDouble(amount.substring(1));
		return null;
	}

	
	public void waitForWebElementToAppear(WebElement ele, AndroidDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(ele, "text", "cart"));
	}
	
	
	public List<HashMap<String, String>> getJsonData(String jsonfilepath) throws Exception{
		
		// convert json file content to json String
		
		 String  jsonContent=FileUtils.readFileToString(new File(jsonfilepath), StandardCharsets.UTF_8);
	
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String, String>> data= mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
		});
		
		
		
		return data;
		
				
	}
	
	
	public String getScreenshot(String testCaseName, AppiumDriver driver) throws IOException {
		File src=driver.getScreenshotAs(OutputType.FILE);
		String destinationFile= System.getProperty("user.dir")+"//reports"+testCaseName+".png";
		//FileUtils.copyFile(src, trg);
		
		FileUtils.copyFile(src, new File(destinationFile));
		
		return destinationFile;
	}
}
