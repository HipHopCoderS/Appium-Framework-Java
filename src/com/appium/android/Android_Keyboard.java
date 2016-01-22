package com.appium.android;


import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.AndroidKeyMetastate;

public class Android_Keyboard extends Android_DriverStart implements AndroidKeyCode,AndroidKeyMetastate {
	
	//返回键
	public static void BACK(){
		driver.sendKeyEvent(4);
	}
	
	//清除键
	public static void BACKSPACE (){
		driver.sendKeyEvent(67);
	}
	
	//删除键
	public static void DEL (){
		driver.sendKeyEvent(67);
	}
	
	//确定键
	public static void ENTER (){
		driver.sendKeyEvent(66);
	}
	
	//Home键
	public static void HOME (){
		driver.sendKeyEvent(3);
	}
	
	//菜单键
	public static void MENU (){
		driver.sendKeyEvent(82);
	}
	
	//设置键
	public static void SETTINGS (){
		driver.sendKeyEvent(176);
	}
	
	//空格键
	public static void SPACE (){
		driver.sendKeyEvent(62);
	}
	
	
	
}
