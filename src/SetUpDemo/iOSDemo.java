package SetUpDemo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.ios.iOS_DriverStart;


public class iOSDemo {


@BeforeMethod(groups = "iOS")
public void beforeMethod() {
	String FileName = null;
	String SheetName = null;
	iOS_DriverStart.LoadSimulatorDevice(FileName,SheetName);
}
	
	
	@Test(groups = "groupName")
	public void test(){
		
	}

	
	@AfterMethod(groups = "groupName")
	public void afterMethod() {
		iOS_DriverStart.driver.quit(); 
	}
	
}
