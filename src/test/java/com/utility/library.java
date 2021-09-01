package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class library {
	public static WebDriver driver;
	public static Properties propObj = new Properties();

	/*
	 * ExtentHtmlReporter : responsible for look and feel of the report ,we can
	 * specify the report name , document title , theme of the report
	 * 
	 * ExtentReports : used to create entries in your report , create test cases
	 * in report , who executed the test case, environment name , browser
	 * 
	 * ExtentTest : update pass fail and skips and logs the test cases results
	 */
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports ExtReport;
	public static ExtentTest ExtTest;
	
	public static void StartExtentReport() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReportV4.html");
		htmlReporter.config().setDocumentTitle("AutomationReport");
		htmlReporter.config().setReportName("Selenium");
		htmlReporter.config().setTheme(Theme.STANDARD);
		ExtReport = new ExtentReports();
		ExtReport.attachReporter(htmlReporter);
		ExtReport.setSystemInfo("Host Name", "LocalHost");
		ExtReport.setSystemInfo("user", "Trainer:");
		ExtReport.setSystemInfo("Environemnet", (String) propObj.get("environment"));
		ExtReport.setSystemInfo("Browser", (String) propObj.get("browser"));
	}
	
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
	
	public static void waitForPageToLoad() {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		// explicit wait -> Applicable for one webEllement
		WebDriverWait wait = new WebDriverWait(driver, 60);//60 seconds 
		wait.until(pageLoadCondition);
	}

	public static void LaunchBrowser() {
		String browser = propObj.getProperty("browser");
		System.out.println("browser: " + browser);
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions objChromeOptions = new ChromeOptions();
			objChromeOptions.setAcceptInsecureCerts(true);//accept ssl certificates
			Map<String,Object> chromePrefs = new HashMap<String,Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.prompt_for_download", false);
			chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
			objChromeOptions.setExperimentalOption("prefs", chromePrefs);
			driver = new ChromeDriver(objChromeOptions);
			DesiredCapabilities ObjDesiredCap = DesiredCapabilities.chrome();
			ObjDesiredCap.setCapability(ChromeOptions.CAPABILITY, objChromeOptions);
			ObjDesiredCap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equals("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		}
		driver.get(propObj.getProperty("GmoOnloneURL_SIT"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public static void SwithToFrameUsingIdOrName(String name_id) {
		driver.switchTo().frame(name_id);
	}

	public static void SwithToFrameUsingWebElement(WebElement element) {
		driver.switchTo().frame(element);
	}

	public static void SwithToAlert() {
		driver.switchTo().alert();
	}

	public static String SwithToAlertAndReturnText() {
		Alert obj = driver.switchTo().alert();
		String TextFromAlertBox = obj.getText();
		return TextFromAlertBox;
	}
	
	public static void AcceptAlert() {
		Alert obj1 = driver.switchTo().alert();
		obj1.accept();
	}

	public static WebElement findElementByLocator(String ObjRepLocator) {

		//System.out.println(ObjRepLocator);
		String locator = ObjRepLocator.split("&")[0];
		String value = ObjRepLocator.split("&")[1];
		//System.out.println("locator: " + locator);
		//System.out.println("value: " + value);
		WebElement element = null;
		By search = null;
		if (locator.equals("id")) {
			search = By.id(value);
		} else if (locator.equals("name")) {
			search = By.name(value);
		} else if (locator.equals("className")) {
			search = By.className(value);
		} else if (locator.equals("xpath")) {
			search = By.xpath(value);
		} else if (locator.equals("cssSelector")) {
			search = By.cssSelector(value);
		} else if (locator.equals("linkText")) {
			search = By.linkText(value);
		} else if (locator.equals("partialLinkText")) {
			search = By.partialLinkText(value);
		} else if (locator.equals("tagName")) {
			search = By.tagName(value);
		}
		return driver.findElement(search);
	}
	
	public static void javascriptExecutorScroolIntoView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	public static void javascriptExecutorScroolIntoViewAndClick(WebElement element) {
		Actions obj = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
		obj.click(element).build().perform();
	}

	public static void javascriptExecutorScroolIntoViewAndDoubleClick(WebElement element, Actions obj) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
		obj.doubleClick(element).build().perform();
	}
	
	public static void javascriptExecutorScroolIntoViewAndContextClick(WebElement element, Actions obj) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
		obj.contextClick(element).build().perform();
	}
	public static void DragAndDrop(WebElement source, WebElement target) {
		Actions obj = new Actions(driver);
		obj.dragAndDrop(source, target).build().perform();
		//obj.clickAndHold(source).build().perform();
		//obj.moveToElement(target).build().perform();
				
	}

	public static String takescreeshot(WebDriver driver) throws Exception {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		System.out.println(dateName);
		String destination = System.getProperty("user.dir") + "//src//test//resources//screenshots//" + dateName
				+ "captured.png";
		FileUtils.copyFile(source, new File(destination));
		return destination;
	}

	public static String takescreeshot(WebDriver driver, String name) throws Exception {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		System.out.println(dateName);
		String destination = System.getProperty("user.dir") + "//src//test//resources//ScreenShots//" + dateName + name
				+ "captured.png";
		FileUtils.copyFile(source, new File(destination));
		return destination;
	}
	
}
