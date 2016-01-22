package com.appium.ios;



import java.util.List;

import io.appium.java_client.MobileElement;

import org.openqa.selenium.By;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * 对UI 元素的操作
 * 
 * */

public class iOS_UI extends iOS_DriverStart {

	// 获取映射某个元素
	public static WebElement getWebEle(By by) {

		WebElement ele;
		ele = driver.findElement(by);
		return ele;
	}
	
	//获取多个元素，返回一个list
	public static List<WebElement> getWebEleList (By by) {

		List<WebElement> listname = driver.findElements(by);
	
		return listname;
	}
	

	// 获取映射手机元素
	public static MobileElement getMobileEle(By by) {
		MobileElement ele;
		ele = (MobileElement) driver.findElement(by);
		return ele;
	}

	// 获取映射手机元素
	public static RemoteWebElement getRemoteEle(By by) {
		RemoteWebElement ele;
		ele = (RemoteWebElement) driver.findElement(by);
		return ele;
	}

	// 判断某个元素是否存在
	public static boolean isExist(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	// 等待某元素被找到
	public static WebElement waitEle(int s, By by) {
		WebElement ele;
		ele = new WebDriverWait(driver, s).until(ExpectedConditions
				.presenceOfElementLocated(by));
		return ele;
	}
	


	// 获取当前方法名
	public static String runName() {
		String s = new Throwable().getStackTrace()[1].getMethodName();
		return s;
	}

	// 输出自己的方法名
	public static void runOUt() {
		System.out.println(new Throwable().getStackTrace()[1].getMethodName()
				+ "已经运行");

	}

	// 在文本框直接输入文本
	public static void Input(By by, String value) {
		driver.findElement(by).sendKeys(value);
	}

	public static void UIInput(WebElement ele, String value) {
		ele.sendKeys(value);
	}

	// 在文本框清空后，输入新的字符
	public static void Inputclean(By by, String value) {
		WebElement ele = driver.findElement(by);
		ele.clear();
		ele.sendKeys(value);
		

	}

	public static void Inputclean(WebElement ele, String value) {
		ele.clear();
		ele.sendKeys(value);
	}

	// 清空文本框
	public static void clearEditBox(By by) {
		driver.findElement(by).clear();
	}

	// 复选框的选择判断
	// 选中复选框
	public static void checkBoxSelect(By by) {
		WebElement checkbox = driver.findElement(by);
		while (checkbox.isSelected()) {
			checkbox.click();
		}
	}

	public static void checkBoxSelect(WebElement ele) {
		while (ele.isSelected()) {
			ele.click();
		}

	}

	// 取消复选框
	public static void checkBoxCancel(By by) {
		WebElement checkbox = driver.findElement(by);
		while (checkbox.isEnabled()) {
			checkbox.click();
		}
	}

	public static void checkBoxCancel(WebElement ele) {
		while (ele.isEnabled()) {
			ele.click();
		}
	}

	// 点击选择
	public static void click(By by) {
		driver.findElement(by).click();
	}

	/*
	 * 根据坐标进行滑动模拟的操作
	 */
	
	
	/*
	public static void UIswipe(Double startX, Double startY, Double endX,
			Double endY, Double duration) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, Double> swipeObj = new HashMap<String, Double>();
		swipeObj.put("startX", startX);
		swipeObj.put("startY", startY);
		swipeObj.put("endX", endX);
		swipeObj.put("endY", endY);
		swipeObj.put("duration", duration);
		// 拖动
		js.executeScript("mobile: swipe", swipeObj);
		
		
	}
*/



	/*
	 * 根据方向进行滑动模拟的操作 
	 */
	
	/*
	public static void UIscroll(String direction) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", direction);
		js.executeScript("mobile: scroll", scrollObject);
	}

	public static void UIscroll(By by, String direction){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ele = driver.findElement(by);
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("element", ((RemoteWebElement) ele).getId());
		js.executeScript("mobile: scroll", scrollObject);
		
	}
*/
	
	
	// 获取组件文本
	public static String lableString(By by) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s = driver.findElement(by).getText();
		return s;
	}

	public static String lableString(WebElement ele) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s = ele.getText();
		return s;
	}

	// 比较获取的文本是否包含指定文本 或者是否和指定文本相等
	public static boolean stringEquals(By by, String s1) {
		String s2 = driver.findElement(by).getText();
		if (s2.indexOf(s1) >= 0) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean stringEquals(String s2, String s1) {

		// s2包含s1,或者相等
		if (s2.indexOf(s1) >= 0) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean stringEquals(WebElement ele, String s1) {

		String s2 = ele.getText();
		if (s2.indexOf(s1) >= 0) {
			return true;
		} else {
			return false;
		}
	}

	// 上传文件的操作
	public static void uploadFile(By by, String path) {
		WebElement ele = driver.findElement(by);
		ele.sendKeys(path);
	}

}
