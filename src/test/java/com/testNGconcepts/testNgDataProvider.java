package com.testNGconcepts;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class testNgDataProvider {

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class executed");
	}

	@Test(dataProvider = "dp")
	public void add(String user, String pwd) {
		System.out.println("inside test case add");
		System.out.println("user: " + user);
		System.out.println("pwd: " + pwd);

	}
	
	@Test 
	public void test2 (){
		System.out.println("inside test2");
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { "user1", "pwd1" }, new Object[] { "user2", "pwd2" }, 
			 new Object[] { "user3", "pwd3" }, new Object[] { "user4", "pwd4" },};
	}
	
	@BeforeMethod
	public void BeforeMethod(){
		System.out.println("inside BeforeMethod");
	}
	
	@AfterMethod
	public void AfterMethod(){
		System.out.println("inside AfterMethod");
	}
}
