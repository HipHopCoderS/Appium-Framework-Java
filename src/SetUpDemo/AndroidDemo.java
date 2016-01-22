package SetUpDemo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.appium.android.Android_DriverStart;


public class AndroidDemo extends  Android_DriverStart{

	@BeforeClass(groups = { "groupsName" })
	public void setUP(){
		String FileName = null;
		String SheetName = null;
		Android_DriverStart.LoadDevice(FileName, SheetName);
	}
	
	
	@Test (groups = { "groupsName" })
	public void test(){
		
	}

	
	
	@AfterMethod(groups = { "groupsName" })
	public void tearDown(){
		driver.quit(); 
	 }

}
