package com.appium.android;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;



import Excel.Excel;
import Excel.ReadExcel;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;




/* 
 * appiumDriver 驱动，加载参数
 * */

public class Android_DriverStart {

	public static AppiumDriver driver;
	public static Map<String, List<String>>  mapTest = new HashMap<String, List<String>>();
	
/*
	public  String appPath = null;
	public  String appName = null;
	public  String platformName = null;
	public  String deviceName = null;
	public  String platformVersion = null;
	public  String appPackage = null;
	public  String appActivity = null;
	public  String appWaitActivity = null;
	public  String URL  = null;
*/

	//初始化参数
	public static void LoadDevice(String FileName,String SheetName) {
			
		//从Excel读取相应的数据
		mapTest = Excel.reExcel(FileName, SheetName);
		String appPath = ReadExcel.getSingleRowData(mapTest, "appPath");
		String appName = ReadExcel.getSingleRowData(mapTest, "appName");
		String platformName = ReadExcel.getSingleRowData(mapTest, "platformName");
		String deviceName = ReadExcel.getSingleRowData(mapTest, "deviceName");
		String platformVersion = ReadExcel.getSingleRowData(mapTest, "platformVersion");
		String appPackage = ReadExcel.getSingleRowData(mapTest, "appPackage");
		String appActivity = ReadExcel.getSingleRowData(mapTest, "appActivity");
//		String appWaitActivity = ReadExcel.getSingleRowData(mapTest, "appWaitActivity");
		String URL = ReadExcel.getSingleRowData(mapTest, "URL");
		
		 
		// 设置启动的程序位置和程序的名字，安装的apk文件
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, appPath);
		File app = new File(appDir, appName);
	

		// 设置设备的属性
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");

		// 设置平台 Android
		capabilities.setCapability("platformName", platformName);

		// 设置设备的名称，真机或者模拟器的
		capabilities.setCapability("deviceName", deviceName);

		// 设置Android系统的版本号
		capabilities.setCapability("platformVersion", platformVersion);

		// 设置apk文件的路径
		capabilities.setCapability("app", app.getAbsolutePath());

		// 设置apk的包名
		capabilities.setCapability("appPackage", appPackage);

		// 设置main Activity
		capabilities.setCapability("appActivity", appActivity);
//		capabilities.setCapability("appWaitActivity", appWaitActivity);

		// 设置UNicode键盘支持中文输入，会默认的代替内置的键盘
		capabilities.setCapability("unicodeKeyboard", "True");
		capabilities.setCapability("resetKeyboard", "True");

		try {

			// 加载驱动
			driver = new AndroidDriver(new URL("http://"+ URL+ "/wd/hub"), capabilities);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
