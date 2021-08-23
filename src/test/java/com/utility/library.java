package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class library {
	public static WebDriver driver;
	public static Properties propObj = new Properties();

	public static void ReadPropertyFile() throws Exception {
		System.out.println(System.getProperty("user.dir"));
		FileInputStream ObjInputStream;
		try {
			ObjInputStream = new FileInputStream(
					new File(System.getProperty("user.dir") + "//src//test//resources//config.feature"));
			propObj.load(ObjInputStream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void LaunchBrowser(){
		String browser = propObj.getProperty("browser");
		System.out.println("browser: "+browser);
		if(browser.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browser.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(browser.equals("ie")){
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}else if(browser.equals("edge")){
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}else if(browser.equals("opera")){
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		}
		driver.get(propObj.getProperty("GmoOnloneURL_SIT"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

}
