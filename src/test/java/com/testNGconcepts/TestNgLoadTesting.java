package com.testNGconcepts;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgLoadTesting {
	@Test(invocationCount = 3)
	public void test1() {
		System.out.println(" test 1 is executed");
	}

	@Test(invocationCount = 3, threadPoolSize = 3)
	public void test2() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
		String timstamp = sdf.format(date);
		System.out.println(timstamp + " [Thread-" + Thread.currentThread().getId() + " test 2 is executed");
	}

	@Test(invocationCount = 10, threadPoolSize = 5)
	public void testGoogleSearch() {
		System.out.printf("[+] Thread Id : %s is started!\n", Thread.currentThread().getId());
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Date date = null;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://www.google.com");

		String search_text = "Google Search";
		WebElement search_button = driver.findElement(By.name("btnK"));
		String text = search_button.getAttribute("value");

		date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
		String timstamp = sdf.format(date);
		System.out.println(timstamp + " [Thread-" + Thread.currentThread().getId() + "]- Search button text is "
				+ driver.getTitle());

		Assert.assertEquals(text, search_text, "Text not found!");

		System.out.printf("%n[-] Thread Id : %s Ended.\n", Thread.currentThread().getId());
		driver.quit();
	}
}
