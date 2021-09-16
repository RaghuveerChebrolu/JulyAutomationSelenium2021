package com.testNg;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.utility.ORep;
import com.utility.ObjectRepository;
import com.utility.constants;
import com.utility.library;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNg5 extends library {
	HashMap<String, String> TestData = new HashMap<String, String>();

	@Test(priority = 0,groups = { "sanity" })
	public void ValidateGmoOnlineLoadedSuccessfully() {
		System.out.println("inside testCase1");
		ExtTest = ExtReport.createTest(new Object() {
		}.getClass().getEnclosingMethod().getName());
		waitForPageToLoad();
		String ActualTitle = driver.getTitle();
		System.out.println(ActualTitle);
		String ExpectedTitle = "OnLine Catalog";
		String str = new String("hai");
		Assert.assertEquals(ActualTitle, ExpectedTitle);

	}

	@Test(priority = 1,groups = { "sanity" })
	public void ValidateEnterGMOOnline() {
		System.out.println("inside testCase2");
		ExtTest = ExtReport.createTest(new Object() {
		}.getClass().getEnclosingMethod().getName());
		driver.findElement(By.name(ObjectRepository.EnterGMOOnlineSubmitbutton)).click();
		waitForPageToLoad();
		String ActualTitleText = driver.findElement(By.xpath(ObjectRepository.EnterGMOOnlineText)).getText();
		System.out.println("TitleText: " + ActualTitleText);
		String ExpectedTitle = "OnLine Catalog";
		Assert.assertEquals(ActualTitleText, ExpectedTitle);

	}

	@Test(priority = 2,groups = { "sanity" })
	public void ValidateOrderQty() {
		ExtTest = ExtReport.createTest(new Object() {
		}.getClass().getEnclosingMethod().getName());
		waitForPageToLoad();
		driver.findElement(By.xpath(ObjectRepository.QtyFrameBackpack)).sendKeys("4");
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
		ExtTest = ExtReport.createTest(new Object() {
		}.getClass().getEnclosingMethod().getName());
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
		Float Grand_Total = Float.parseFloat(GrandTotal);
		Assert.assertEquals(CalCulatedTotalQtyPrice, Grand_Total);
		SoftAssertobj.assertAll();
	}

	@Test(priority = 4,groups = { "sanity" })
	public void ValidateAlerts() {
		System.out.println("inside ValidateAlerts");
		ExtTest = ExtReport.createTest(new Object() {
		}.getClass().getEnclosingMethod().getName());
		driver.navigate().to(propObj.getProperty("AlertURL"));
		waitForPageToLoad();
		driver.findElement(By.xpath("//button[@id='alertButton']")).click();
		Alert Obj = driver.switchTo().alert();// NoAlertPresentException - If
												// the dialog cannot be found
		Obj.accept();
		// WebElement element = driver.findElement(By.id("confirmButton"));
		// element.click();
		// driver.findElement(By.id("confirmButton")).click();
		library.findElementByLocator(ORep.AlertconfirmButton).click();
		driver.switchTo().alert();
		String AlerBoxText = Obj.getText();
		System.out.println("AlerBoxText: " + AlerBoxText);
		Obj.dismiss();
		String ActualMessage = driver.findElement(By.xpath("//*[@id='confirmResult']")).getText();
		System.out.println("ActualMessage: " + ActualMessage);
		// String ExpectedMessage ="You selected Ok";
		SoftAssert SoftAssertobj = new SoftAssert();
		SoftAssertobj.assertEquals(ActualMessage, "You selected OK");
		library.findElementByLocator(ORep.AlertpromtButton).click();
		// driver.findElement(By.id("promtButton")).click();
		Obj.sendKeys("Hi How Are You Doing!");
		Obj.accept();
		String ActuaAlertboxEnteredText = driver.findElement(By.xpath("//*[@id='promptResult']")).getText();
		Assert.assertEquals(ActuaAlertboxEnteredText, "You entered Hi How Are You Doing!");

		try {
			takescreeshot(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SoftAssertobj.assertAll();
	}

	@Test(priority = 5)
	public void HandlingFrames() {
		System.out.println("inside HandlingFrames");
		ExtTest = ExtReport.createTest(new Object() {
		}.getClass().getEnclosingMethod().getName());
		driver.navigate().to(propObj.getProperty("FramesURL"));
		waitForPageToLoad();
		library.SwithToFrameUsingIdOrName("SingleFrame");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hi Inside Single Frame");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();
		// WebElement
		// parentFrameElement=driver.findElement(By.xpath("//*[@id='Multiple']/iframe"));
		library.SwithToFrameUsingWebElement(driver.findElement(By.xpath("//*[@id='Multiple']/iframe")));
		WebElement childFrameElement = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
		library.SwithToFrameUsingWebElement(childFrameElement);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hi Inside frame with in Frame");
		driver.switchTo().defaultContent();
	}

	@Test(priority = 6)
	public void HandlingWindows() {
		System.out.println("inside HandlingWindows");
		ExtTest = ExtReport.createTest(new Object() {
		}.getClass().getEnclosingMethod().getName());
		driver.navigate().to(propObj.getProperty("WindowsURL"));
		waitForPageToLoad();
		String parentWindow = driver.getWindowHandle();
		Set<String> Allwindows = driver.getWindowHandles();

		for (String SingleWindow : Allwindows) {
			driver.switchTo().window(SingleWindow);
			String title = driver.getTitle();
			System.out.println(title);
			if (title.equals("Tech Mahindra")) {
				driver.manage().window().maximize();
				driver.close();// closing the current browser
			} else if (title.equals("Jio")) {
				driver.manage().window().maximize();
				driver.close();
			} else if (title.equals("Jobs - Recruitment - Job Search - Employment -Job Vacancies - Naukri.com")) {
				// action
			}
		}
		driver.switchTo().window(parentWindow);

		// driver.quit();
	}

	@Test(priority = 7)
	public void HandlingWebTable() {
		System.out.println("inside HandlingWebTable");
		ExtTest = ExtReport.createTest(new Object() {
		}.getClass().getEnclosingMethod().getName());
		driver.navigate().to(propObj.getProperty("WebTableURL"));
		waitForPageToLoad();

		List<WebElement> AllLastNames = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));

		int size = AllLastNames.size();
		for (int i = 1; i <= size; i++) {
			String LastName = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + i + "]/td[3]"))
					.getText();
			System.out.println(LastName);
			// if(LastName.equals("Wagner")){
			String Salary = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + i + "]/td[7]")).getText();
			String StartDate = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + i + "]/td[6]"))
					.getText();
			String Office = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + i + "]/td[5]")).getText();
			String Position = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + i + "]/td[4]"))
					.getText();
			System.out.println("Salary of " + LastName + " is : " + Salary);
			System.out.println("Details of employee when last name is provided : LastName :" + LastName + " Salary : "
					+ Salary + " StartDate :" + StartDate + " Position :" + Position + " Office:" + Office);

			// }

		}
	}

	@Test(priority = 8)
	public void MouseOperationRightClick() {
		System.out.println("inside MouseOperationRightClick");
		ExtTest = ExtReport.createTest(new Object() {
		}.getClass().getEnclosingMethod().getName());
		driver.navigate().to(propObj.getProperty("mouseOpeartionRightClick"));
		waitForPageToLoad();
		WebElement rightCLick = library.findElementByLocator(ORep.RightClick);
		Actions obj = new Actions(driver);
		// obj.contextClick(rightCLick).build().perform();
		library.javascriptExecutorScroolIntoViewAndContextClick(rightCLick, obj);
		library.findElementByLocator(ORep.copy_right_click).click();
		String AlertText1 = library.SwithToAlertAndReturnText();
		if (AlertText1.contains("copy")) {
			library.AcceptAlert();
		}

	}

	@Test(priority = 9)
	public void MouseOperationDoubleCLick() {
		System.out.println("inside MouseOperationDoubleCLick");
		ExtTest = ExtReport.createTest(new Object() {
		}.getClass().getEnclosingMethod().getName());
		driver.navigate().to(propObj.getProperty("mouseOpeartionDoubleClick"));
		waitForPageToLoad();
		// JavascriptExecutor js = (JavascriptExecutor)driver;
		// js.executeScript("window.scrollBy(0,500)");

		// js.executeScript("window.scrollBy(0,500)"); //for scrolling
		// vertically down
		// js.executeScript("window.scrollBy(0,-500)");//for scrolling
		// vertically up
		// js.executeScript("window.scrollBy(1000,0)");////for scrolling
		// horizontally right side
		// js.executeScript("window.scrollBy(-400,0)");////for scrolling
		// horizontally left side
		// js.executeScript("window.scrollTo(document.body.scrollHeight,0)");//to
		// scroll vertically up completely
		// js.executeScript("0,window.scrollTo(document.body.scrollHeight)");//to
		// scroll vertically down completely
		// js.executeScript("document.querySelector(scroll).scrollLeft=1000");

		WebElement Element = library.findElementByLocator(ORep.DoubleClick_frame);
		library.SwithToFrameUsingWebElement(Element);

		WebElement Ele = library.findElementByLocator(ORep.Double_Click);
		Actions obj = new Actions(driver);
		library.javascriptExecutorScroolIntoViewAndDoubleClick(Ele, obj);

	}

	@Test(priority = 10)
	public void MouseOperationDragAndDrop() {
		System.out.println("inside MouseOperationDragAndDrop");
		ExtTest = ExtReport.createTest(new Object() {
		}.getClass().getEnclosingMethod().getName());
		driver.navigate().to(propObj.getProperty("mouseOperationDragAndDrop"));
		waitForPageToLoad();

		WebElement frame = library.findElementByLocator(ORep.DragAndDropFrame);
		library.SwithToFrameUsingWebElement(frame);

		WebElement source = library.findElementByLocator(ORep.draggable);
		WebElement target = library.findElementByLocator(ORep.droppable);
		library.DragAndDrop(source, target);
		String droppedText = library.findElementByLocator(ORep.TextDrop).getText();
		Assert.assertEquals(droppedText, "Dropped!");

	}

	@Test(priority = 11)
	public void validateFileUpload() throws AWTException, InterruptedException {
		System.out.println("inside FileUpload");
		ExtTest = ExtReport.createTest(new Object() {
		}.getClass().getEnclosingMethod().getName());
		driver.navigate().to(propObj.getProperty("FileUpload"));
		waitForPageToLoad();
		WebElement element = library.findElementByLocator(ORep.FileUpload);
		library.javascriptExecutorScroolIntoViewAndClick(element);
		// File Obj=new
		// File(System.getProperty("user.dir"+"//src/test//resources/Sample.jpg"));

		StringSelection objStringSelection = new StringSelection(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Sample.jpg");
		Clipboard objClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		objClipboard.setContents(objStringSelection, null);
		try {
			Transferable objTransferable = objClipboard.getContents(null);
			if (objTransferable.isDataFlavorSupported(DataFlavor.stringFlavor))
				System.out.println(objTransferable.getTransferData(DataFlavor.stringFlavor));
		} catch (Exception e) {
			e.printStackTrace();
		}

		Robot objRobot = new Robot();
		objRobot.delay(250);
		objRobot.keyPress(KeyEvent.VK_ENTER);
		objRobot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		objRobot.keyPress(KeyEvent.VK_CONTROL);
		objRobot.keyPress(KeyEvent.VK_V);
		Thread.sleep(2000);
		objRobot.keyRelease(KeyEvent.VK_V);
		objRobot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		objRobot.keyPress(KeyEvent.VK_ENTER);
		objRobot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);

	}

	@Test(priority = 12)
	public void ValidateFileDownload() throws InterruptedException {
		System.out.println("inside ValidateFileDownload");
		ExtTest = ExtReport.createTest(new Object() {
		}.getClass().getEnclosingMethod().getName());
		driver.navigate().to(propObj.getProperty("FileDownload"));
		waitForPageToLoad();
		library.findElementByLocator(ORep.FileDownload).click();
		Thread.sleep(8000);
		File objFile = new File(System.getProperty("user.dir"));
		File[] listOfFiles = objFile.listFiles();
		boolean fileFound = false;
		File obj_File = null;
		for (File IndividualFile : listOfFiles) {
			String FileName = IndividualFile.getName();
			System.out.println(FileName);
			if (FileName.contains("file-sample")) {
				fileFound = true;
				obj_File = new File(FileName);
			}
		}
		Assert.assertTrue(fileFound, "File Downloaded Not Found");
		obj_File.deleteOnExit();

	}

	@Test(priority = 13)
	public void ValidateBrokenLinks() {
		System.out.println("inside ValidateFileDownload");
		ExtTest = ExtReport.createTest(new Object() {
		}.getClass().getEnclosingMethod().getName());
		driver.navigate().to(propObj.getProperty("BrokenLinks"));
		waitForPageToLoad();
		List<WebElement> AllLinks = library.findElementsByLocator(ORep.Links);
		for (int i = 1; i < AllLinks.size(); i++) {
			WebElement IndividualLink = AllLinks.get(i);
			String IndividualLinkUrl = IndividualLink.getAttribute("href");
			try {
				library.verifyinglinks(IndividualLinkUrl);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Test(priority = 14)
	public void ValidateDataDriven() throws IOException {
		System.out.println("inside ValidateFileDownload");
		ExtTest = ExtReport.createTest(new Object() {
		}.getClass().getEnclosingMethod().getName());
		driver.navigate().to(propObj.getProperty("AutomationRegister"));
		waitForPageToLoad();
		try {
			FileInputStream ObjFileInputStream = new FileInputStream(
					new File(System.getProperty("user.dir") + "//src/test/resources//AutomationDemoSIte.xlsx"));
			XSSFWorkbook objXSSFWorkbook = new XSSFWorkbook(ObjFileInputStream);
			XSSFSheet objXSSFSheet = objXSSFWorkbook.getSheet("TestData");
			int AllRows = objXSSFSheet.getLastRowNum();
			for (int rowNumber = 1; rowNumber <= AllRows; rowNumber++) {

				TestData = readExcelFile(objXSSFSheet, rowNumber);
				if (TestData.get("RunMode").equals("Yes")) {
					/*
					 * System.out.println(TestData.get("FirstName"));
					 * System.out.println(TestData.get("LastName"));
					 * System.out.println(TestData.get("Address"));
					 */
					library.findElementByLocator(ORep.RegisterFirstName).clear();
					library.findElementByLocator(ORep.RegisterFirstName).sendKeys(TestData.get("FirstName"));

					library.findElementByLocator(ORep.RegisterLastName).clear();
					library.findElementByLocator(ORep.RegisterLastName).sendKeys(TestData.get("LastName"));

					library.findElementByLocator(ORep.RegisterAddress).clear();
					library.findElementByLocator(ORep.RegisterAddress).sendKeys(TestData.get("Address"));

					library.findElementByLocator(ORep.RegisterPhone).clear();
					library.findElementByLocator(ORep.RegisterPhone).sendKeys(TestData.get("PhoneNumber"));

					library.findElementByLocator(ORep.RegisterEmailAddress).clear();
					library.findElementByLocator(ORep.RegisterEmailAddress).sendKeys(TestData.get("EmailAddress"));

					if (TestData.get("Gender").equals("Male")) {
						library.findElementByLocator(ORep.RegisterGenderMale).click();
					} else {
						library.findElementByLocator(ORep.RegisterGenderFemale).click();
					}

					if (TestData.get("Hobbies").equals("Cricket")) {
						library.findElementByLocator(ORep.RegisterHobbiesCricket).click();
					} else if (TestData.get("Hobbies").equals("Hockey")) {
						library.findElementByLocator(ORep.RegisterHobbiesHockey).click();
					} else if (TestData.get("Hobbies").equals("Movies")) {
						library.findElementByLocator(ORep.RegisterHobbiesMovies).click();
					}

					if (rowNumber > 1) {
						driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-close']")).click();
					}

					WebElement Languageele = library.findElementByLocator(ORep.RegisterLaunguages);
					Languageele.click();

					List<WebElement> AllLanguages = library
							.findElementsByLocator(ORep.Register_LaungauaesDropDownItems);
					library.SelectValueFromDropDown(AllLanguages, TestData.get("Languages"));

					library.findElementByLocator(ORep.Register_Skills_Label).click();

					WebElement Skills = library.findElementByLocator(ORep.RegisterSkills);
					Skills.click();

					List<WebElement> AllSkills = library.findElementsByLocator(ORep.Register_SkillsDropDownItems);
					library.SelectValueFromDropDown(AllSkills, TestData.get("Skills"));

					WebElement country = library.findElementByLocator(ORep.RegisterCountry);
					country.click();

					List<WebElement> Allcountries = library.findElementsByLocator(ORep.Register_CountryDropDownItems);
					library.SelectValueFromDropDown(Allcountries, TestData.get("Country"));

					WebElement select_country = library.findElementByLocator(ORep.RegisterSelect_Country);
					select_country.click();

					library.findElementByLocator(ORep.Register_SelectCountry_TextBox)
							.sendKeys(TestData.get("SelectCountry"));
					try {
						Robot obj = new Robot();
						obj.keyPress(KeyEvent.VK_ENTER);
						obj.keyRelease(KeyEvent.VK_ENTER);
					} catch (AWTException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					WebElement DOByy = library.findElementByLocator(ORep.RegisterDOBYY);
					DOByy.click();

					List<WebElement> Allyears = library.findElementsByLocator(ORep.Register_DOBYY_DropDownItems);
					library.SelectValueFromDropDown(Allyears, TestData.get("DOB_YY"));

					WebElement DOBMM = library.findElementByLocator(ORep.RegisterDOBMM);
					DOBMM.click();

					List<WebElement> AllMonths = library.findElementsByLocator(ORep.Register_DOBMM_DropDownItems);
					library.SelectValueFromDropDown(AllMonths, TestData.get("DOB_MM"));

					WebElement DOBDD = library.findElementByLocator(ORep.RegisterDOBDD);
					DOBDD.click();

					List<WebElement> AllDays = library.findElementsByLocator(ORep.Register_DOBDD_DropDownItems);
					library.SelectValueFromDropDown(AllDays, TestData.get("DOB_DD"));

					library.findElementByLocator(ORep.RegisterPWD).clear();
					library.findElementByLocator(ORep.RegisterPWD).sendKeys(TestData.get("Password"));

					library.findElementByLocator(ORep.RegisterConfirmPWD).clear();
					library.findElementByLocator(ORep.RegisterConfirmPWD).sendKeys(TestData.get("confirmPassword"));

					// validation will take place like assert condition
					FileOutputStream ObjeFileOut = new FileOutputStream(new File(
							System.getProperty("user.dir") + "//src//test//resources//AutomationDemoSite.xlsx"));

					WriteTheResultToExcel(objXSSFWorkbook, rowNumber);
					objXSSFWorkbook.write(ObjeFileOut);
					ObjeFileOut.close();
				} else {
					System.out.println("RunMode is not marked as Yes . Hence Skipiing this Row/TestCase");
				}
			}

			objXSSFWorkbook.close();
			ObjFileInputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	@Test(priority=15)
	public void ValidateCalender(){
		System.out.println("inside ValidateFileDownload");
		ExtTest = ExtReport.createTest(new Object() {
		}.getClass().getEnclosingMethod().getName());
		driver.navigate().to(propObj.getProperty("Calender"));
		waitForPageToLoad();
		WebElement ele =library.findElementByLocator(ORep.Calender);
		library.SwithToFrameUsingWebElement(ele);
		library.findElementByLocator(ORep.Cal_From).click();
		library.findElementByLocator(ORep.Cal_fromDate).click();
		library.findElementByLocator(ORep.Cal_to).click();
		library.findElementByLocator(ORep.Cal_toDate).click();
	}
	
	public void WriteTheResultToExcel(XSSFWorkbook objworkbook, int rowNumber) {

		XSSFSheet objSheet = objworkbook.getSheet("TestData");
		XSSFCellStyle CellStyle = objworkbook.createCellStyle();
		// CellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		System.out.println("Row Number in excel is :" + rowNumber);

		objSheet.getRow(rowNumber).createCell(18).setCellValue("PASS");
		objSheet.getRow(rowNumber).getCell(18).setCellStyle(CellStyle);

	}

	public HashMap<String, String> readExcelFile(XSSFSheet objXSSFSheet, int rowNumber) {
		DataFormatter Format = new DataFormatter();
		TestData.put("RunMode", objXSSFSheet.getRow(rowNumber).getCell(0).getStringCellValue());
		TestData.put("TestCaseName", objXSSFSheet.getRow(rowNumber).getCell(1).getStringCellValue());
		TestData.put("FirstName", objXSSFSheet.getRow(rowNumber).getCell(2).getStringCellValue());
		TestData.put("LastName", objXSSFSheet.getRow(rowNumber).getCell(3).getStringCellValue());
		TestData.put("Address", objXSSFSheet.getRow(rowNumber).getCell(4).getStringCellValue());
		TestData.put("EmailAddress", objXSSFSheet.getRow(rowNumber).getCell(5).getStringCellValue());

		String PhoneNumber = Format.formatCellValue(objXSSFSheet.getRow(rowNumber).getCell(6));
		TestData.put("PhoneNumber", PhoneNumber);

		TestData.put("Gender", objXSSFSheet.getRow(rowNumber).getCell(7).getStringCellValue());
		TestData.put("Hobbies", objXSSFSheet.getRow(rowNumber).getCell(8).getStringCellValue());
		TestData.put("Languages", objXSSFSheet.getRow(rowNumber).getCell(9).getStringCellValue());
		TestData.put("Skills", objXSSFSheet.getRow(rowNumber).getCell(10).getStringCellValue());
		TestData.put("Country", objXSSFSheet.getRow(rowNumber).getCell(11).getStringCellValue());
		TestData.put("SelectCountry", objXSSFSheet.getRow(rowNumber).getCell(12).getStringCellValue());

		String Year = Format.formatCellValue(objXSSFSheet.getRow(rowNumber).getCell(13));
		TestData.put("DOB_YY", Year);

		TestData.put("DOB_MM", objXSSFSheet.getRow(rowNumber).getCell(14).getStringCellValue());

		String Day = Format.formatCellValue(objXSSFSheet.getRow(rowNumber).getCell(15));
		TestData.put("DOB_DD", Day);

		TestData.put("Password", objXSSFSheet.getRow(rowNumber).getCell(16).getStringCellValue());
		TestData.put("confirmPassword", objXSSFSheet.getRow(rowNumber).getCell(17).getStringCellValue());
		return TestData;
	}

	@BeforeMethod(groups = { "sanity" })
	public void beforeMethod() {
		System.out.println("inside beforeMethod");
		// System.out.println(ActualTitle);

	}

	@AfterMethod
	public void afterMethod(ITestResult Result) {
		System.out.println("inside afterMethod");
		if (Result.getStatus() == ITestResult.FAILURE) {
			ExtTest.log(Status.FAIL, "TestCase failed is :" + Result.getName());
			ExtTest.log(Status.FAIL, "TestCase failed is :" + Result.getThrowable());
			try {
				String screencastPath = library.takescreeshot(driver, Result.getName());
				ExtTest.addScreenCaptureFromPath(screencastPath);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (Result.getStatus() == ITestResult.SUCCESS) {
			ExtTest.log(Status.PASS, "TestCase Pass is :" + Result.getName());
		} else if (Result.getStatus() == ITestResult.SKIP) {
			ExtTest.log(Status.SKIP, "TestCase Skipp is :" + Result.getName());
		}

	}

	@BeforeClass(groups = { "sanity" })
	public void beforeClass() {
		System.out.println("inside beforeClass");
		library.StartExtentReport();
	}

	@AfterClass
	public void afterClass() {
		System.out.println("inside afterClass");
	}

	@BeforeTest(groups = { "sanity" })
	public void beforeTest() {
		System.out.println("inside beforeTest");
		library.LaunchBrowser();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("inside afterTest");
		ExtReport.flush();// don't forget to give this in order to generate
							// report
	}

	@BeforeSuite(groups = { "sanity" })
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
