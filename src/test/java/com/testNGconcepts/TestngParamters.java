package com.testNGconcepts;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class TestngParamters {

	@Parameters({ "BrowserName" })
	@Test
	public void OpenBrowser(String BrowserName) {
		System.out.println("inside test method");
		System.out.println("browser passed as :- " + BrowserName);
		WebDriver driver= null;
	
		
		if(BrowserName.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(BrowserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("inside firefox");
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Parameters({ "UserName", "Passcode" })
	@Test
	public void FillLoginForm(String UserName, String Passcode) {
		System.out.println("Parameter for User Name passed as :- " + UserName);
		System.out.println("Parameter for Passcode passed as :- " + Passcode);
	}
	@BeforeSuite
	@Parameters({ "BrowserName" })
	public void beforeSuite(String BrowserName) {
		System.out.println("inside beforeSuite");
		System.out.println("browser passed as :- " + BrowserName);
	}
}
