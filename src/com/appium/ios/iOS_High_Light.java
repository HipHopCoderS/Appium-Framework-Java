package com.appium.ios;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


/*
 * 高亮显示
 * 
 * */

public class iOS_High_Light extends iOS_DriverStart {
	
	//通过某个By高亮显示
	public static void highlightElement(By by) {
		JavascriptExecutor js = (JavascriptExecutor) iOS_DriverStart.driver;
		js.executeScript("element = arguments[0];" +
		"original_style = element.getAttribute('style');" +
		"element.setAttribute('style', original_style + \";" +
		"background: yellow; border: 4px solid red;\");" +
		"setTimeout(function(){element.setAttribute('style', original_style);}, 5000);", driver.findElement(by));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	//通过某个Element高亮显示
	public static void highlightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) iOS_DriverStart.driver;
		js.executeScript("element = arguments[0];" +
		"original_style = element.getAttribute('style');" +
		"element.setAttribute('style', original_style + \";" +
		"background: yellow; border: 4px solid red;\");" +
		"setTimeout(function(){element.setAttribute('style', original_style);}, 5000);", element);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}
