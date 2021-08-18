package com.testNg;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNg3 {
	WebDriver driver;

	@Test(priority = 1)
	public void ValidateGmoOnlineLoadedSuccessfully() {
		System.out.println("inside testCase1");
		String ActualTitle = driver.getTitle();
		System.out.println(ActualTitle);
		String ExpectedTitle = "OnLine Catalog";
		String str = new String("hai");
		Assert.assertEquals(ActualTitle, ExpectedTitle);

	}

	@Test(priority = 1)
	public void ValidateEnterGMOOnline() {
		System.out.println("inside testCase2");
		driver.findElement(By.name("bSubmit")).click();
		String ActualTitleText = driver.findElement(By.xpath("//h1[contains(text(),'OnLine Catalog')]")).getText();
		System.out.println("TitleText: " + ActualTitleText);
		String ExpectedTitle = "OnLine Catalog";
		Assert.assertEquals(ActualTitleText, ExpectedTitle);

	}

	@Test(priority = 2)
	public void ValidateOrderQty() {
		driver.findElement(By.xpath("//strong[contains(text(),'Frame Backpack')]/../../following-sibling::td/h1/input"))
				.sendKeys("4");
		String UnitPrice = driver
				.findElement(By
						.xpath("(//strong[contains(text(),'Frame Backpack')]/../../following-sibling::td/h1/input/../../preceding-sibling::td)[3]"))
				.getText();
		System.out.println("UnitPrice: " + UnitPrice);
		driver.findElement(By.xpath("//input[@value='Place An Order']")).click();
		String PlaceOrderUnitPrice = driver.findElement(By.xpath("//tbody/tr[2]/td[4]")).getText();
		System.out.println("PlaceOrderUnitPrice: " + PlaceOrderUnitPrice);
		Assert.assertEquals(UnitPrice, PlaceOrderUnitPrice);

	}

	@Test(priority = 3)
	public void ValidateTotalPriceCalculation() {
		System.out.println("inside ValidateTotalPrice");
		String QtyTotalPrice = driver.findElement(By.xpath("//tbody/tr[2]/td[5]")).getText();
		System.out.println("QtyTotalPrice: " + QtyTotalPrice);
		QtyTotalPrice = QtyTotalPrice.substring(2).trim();
		System.out.println("QtyTotalPrice: " + QtyTotalPrice);
		String PlaceOrderUnitPrice = driver.findElement(By.xpath("//tbody/tr[2]/td[4]")).getText();
		PlaceOrderUnitPrice = PlaceOrderUnitPrice.substring(2).trim();
		System.out.println("PlaceOrderUnitPrice: " + PlaceOrderUnitPrice);
		Float CalCulatedTotalQtyPrice = Float.parseFloat(PlaceOrderUnitPrice) * 4;
		SoftAssert SoftAssertobj = new SoftAssert();
		System.out.println("CalCulatedTotalQtyPrice: " + CalCulatedTotalQtyPrice);
		SoftAssertobj.assertEquals(CalCulatedTotalQtyPrice, QtyTotalPrice);
		String SalesTax = driver.findElement(By.xpath("//tbody/tr[4]/td[2]")).getText();
		SalesTax = SalesTax.substring(2).trim();
		String Shipping_Handling = driver.findElement(By.xpath("//tbody/tr[5]/td[2]")).getText();
		Shipping_Handling = Shipping_Handling.substring(2).trim();
		CalCulatedTotalQtyPrice = CalCulatedTotalQtyPrice + Float.parseFloat(SalesTax)
				+ Float.parseFloat(Shipping_Handling);
		String GrandTotal = driver.findElement(By.xpath("//tbody/tr[6]/td[2]")).getText();
		System.out.println("GrandTotal: " + GrandTotal);
		System.out.println("CalCulatedTotalQtyPrice: " + CalCulatedTotalQtyPrice);
		GrandTotal = GrandTotal.substring(2);
		System.out.println("GrandTotal: " + GrandTotal);
		Float Grand_Total=Float.parseFloat(GrandTotal);
		Assert.assertEquals(CalCulatedTotalQtyPrice ,Grand_Total);
		SoftAssertobj.assertAll();
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("inside beforeMethod");
		// System.out.println(ActualTitle);

	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("inside afterMethod");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("inside beforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("inside afterClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("inside beforeTest");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("inside afterTest");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("inside beforeSuite");

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("http://demo.borland.com/gmopost/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("inside afterSuite");
	}

}
