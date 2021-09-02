package com.testNg;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utility.ObjectRepository;
import com.utility.constants;
import com.utility.library;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNg4 extends library{
	

	@Test(priority = 0)
	public void ValidateGmoOnlineLoadedSuccessfully() {
		System.out.println("inside testCase1");
		waitForPageToLoad();
		String ActualTitle = driver.getTitle();
		System.out.println(ActualTitle);
		String ExpectedTitle = "OnLine Catalog";
		String str = new String("hai");
		Assert.assertEquals(ActualTitle, ExpectedTitle);

	}

	@Test(priority = 1)
	public void ValidateEnterGMOOnline() {
		System.out.println("inside testCase2");
		
		driver.findElement(By.name(ObjectRepository.EnterGMOOnlineSubmitbutton)).click();
		waitForPageToLoad();
		String ActualTitleText = driver.findElement(By.xpath(ObjectRepository.EnterGMOOnlineText)).getText();
		System.out.println("TitleText: " + ActualTitleText);
		String ExpectedTitle = "OnLine Catalog";
		Assert.assertEquals(ActualTitleText, ExpectedTitle);

	}

	@Test(priority = 2)
	public void ValidateOrderQty() {
		waitForPageToLoad();
		driver.findElement(By.xpath(ObjectRepository.QtyFrameBackpack))
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
		waitForPageToLoad();
		String QtyTotalPrice = driver.findElement(By.xpath("//tbody/tr[2]/td[5]")).getText();
		System.out.println("QtyTotalPrice: " + QtyTotalPrice);
		QtyTotalPrice = QtyTotalPrice.substring(2).trim();
		System.out.println("QtyTotalPrice: " + QtyTotalPrice);
		String PlaceOrderUnitPrice = driver.findElement(By.xpath("//tbody/tr[2]/td[4]")).getText();
		PlaceOrderUnitPrice = PlaceOrderUnitPrice.substring(2).trim();
		System.out.println("PlaceOrderUnitPrice: " + PlaceOrderUnitPrice);
		Float CalCulatedTotalQtyPrice = Float.parseFloat(PlaceOrderUnitPrice) * constants.FrameBackpackQty;
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
	
	@Test(priority=4)
	public void ValidateAlerts(){
		System.out.println("inside ValidateAlerts");
		driver.navigate().to(propObj.getProperty("AlertURL"));
		waitForPageToLoad();
		driver.findElement(By.xpath("//button[@id='alertButton']")).click();
		Alert Obj =driver.switchTo().alert();//NoAlertPresentException - If the dialog cannot be found
		Obj.accept();
		//WebElement element = driver.findElement(By.id("confirmButton"));
		//element.click();
		driver.findElement(By.id("confirmButton")).click();
		driver.switchTo().alert();
		String AlerBoxText = Obj.getText();
		System.out.println("AlerBoxText: "+AlerBoxText);
		Obj.dismiss();
		String ActualMessage= driver.findElement(By.xpath("//*[@id='confirmResult']")).getText();
		System.out.println("ActualMessage: "+ActualMessage);
		//String ExpectedMessage ="You selected Ok";
		SoftAssert SoftAssertobj = new SoftAssert();
		SoftAssertobj.assertEquals(ActualMessage, "You selected OK");
		
		driver.findElement(By.id("promtButton")).click();
		Obj.sendKeys("Hi How Are You Doing!");
		Obj.accept();
		String ActuaAlertboxEnteredText=driver.findElement(By.xpath("//*[@id='promptResult']")).getText();
		Assert.assertEquals(ActuaAlertboxEnteredText,"You entered Hi How Are You Doing!" );
		
		try {
			takescreeshot(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SoftAssertobj.assertAll();
	}
	
	@Test(priority=5)
	public void HandlingFrames(){
		System.out.println("inside HandlingFrames");
		driver.navigate().to(propObj.getProperty("FramesURL"));
		waitForPageToLoad();
		library.SwithToFrameUsingIdOrName("SingleFrame");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hi Inside Single Frame");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();
		//WebElement parentFrameElement=driver.findElement(By.xpath("//*[@id='Multiple']/iframe"));
		library.SwithToFrameUsingWebElement(driver.findElement(By.xpath("//*[@id='Multiple']/iframe")));
		WebElement childFrameElement=driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
		library.SwithToFrameUsingWebElement(childFrameElement);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hi Inside frame with in Frame");
		driver.switchTo().defaultContent();
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
		library.LaunchBrowser();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("inside afterTest");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("inside beforeSuite");
		try {
			library.ReadPropertyFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("inside afterSuite");
	}
	
	

}
