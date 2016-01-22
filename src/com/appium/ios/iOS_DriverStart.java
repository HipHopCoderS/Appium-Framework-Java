package com.appium.ios;


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
import io.appium.java_client.ios.IOSDriver;

/* 
 * appiumDriver 驱动，加载参数
 * */

public class iOS_DriverStart{

	public static AppiumDriver driver;
	public static Map<String, List<String>> mapTest = new HashMap<String, List<String>>();


	public static void LoadRealDevice(String FileName, String SheetName) {
		
		mapTest = Excel.reExcel(FileName, SheetName);
		
		// 初始化参数
		String platformName = ReadExcel.getSingleRowData(mapTest, "platformName");;
		String deviceName = ReadExcel.getSingleRowData(mapTest, "deviceName");
		String platformVersion = ReadExcel.getSingleRowData(mapTest, "platformVersion");;
		String bundleId = ReadExcel.getSingleRowData(mapTest, "bundleId");;
		String udid = ReadExcel.getSingleRowData(mapTest, "udid");;
		String Url = ReadExcel.getSingleRowData(mapTest, "Url");;

		// 如果启动真机不需要制定这个路径，但是前提需要真机上面已经安装 App

		// 设置设备的属性
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");

		// 设置平台是iOS 平台
		capabilities.setCapability("platformName", platformName);


		// deviceName 用于启动iOS模拟器的时候所用参数
				capabilities.setCapability("deviceName", deviceName);
		
		
		// 启动设备的系统版本号
		capabilities.setCapability("platformVersion", platformVersion);


		// udid 用于真机设备的识别
		capabilities.setCapability("udid", udid);

		// 需要测试app的bundleId,也就是包名
		capabilities.setCapability("bundleId", bundleId);

		// 默认同意接受 发送通知请求（appium 1.3.5 的一个bug，在app启动的时候总是提示是否接受发送通知请求）
		capabilities.setCapability("autoAcceptAlerts", true);

		try {
			// 加载驱动配置
			driver = new IOSDriver(new URL("http://"+Url + "/wd/hub"), capabilities);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

	public static void LoadSimulatorDevice(String FileName, String SheetName) {
		
		mapTest = Excel.reExcel(FileName, SheetName);
		// 初始化参数
		String appPath = ReadExcel.getSingleRowData(mapTest, "appPath");
		String appName = ReadExcel.getSingleRowData(mapTest, "appName");
		String platformName = ReadExcel.getSingleRowData(mapTest, "platformName");
		String deviceName = ReadExcel.getSingleRowData(mapTest, "deviceName");
		String platformVersion = ReadExcel.getSingleRowData(mapTest, "platformVersion");
		String bundleId = ReadExcel.getSingleRowData(mapTest, "bundleId");
		String Url = ReadExcel.getSingleRowData(mapTest, "Url");

		// 设置启动的程序位置和程序的名字(如果在模拟器里面运行的话，需要制定编译后的包名，和路径)
		// 如果启动真机不需要制定这个路径，但是前提需要真机上面已经安装 App

		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, appPath);
		File app = new File(appDir, appName);

		// 设置设备的属性
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");

		// 设置平台是iOS 平台
		capabilities.setCapability("platformName", platformName);

		// deviceName 用于启动iOS模拟器的时候所用参数
		capabilities.setCapability("deviceName", deviceName);

		// 启动设备的系统版本号
		capabilities.setCapability("platformVersion", platformVersion);

		// 获取app的路径
		capabilities.setCapability("app", app.getAbsolutePath());
 

		// 需要测试app的bundleId,也就是包名
		capabilities.setCapability("bundleId", bundleId);

		// 默认同意接受 发送通知请求（appium 1.3.5 的一个bug，在app启动的时候总是提示是否接受发送通知请求）
		capabilities.setCapability("autoAcceptAlerts", true);

		
		try {
			// 加载驱动配置
			driver = new IOSDriver(new URL("http://"+Url + "/wd/hub"), capabilities);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
