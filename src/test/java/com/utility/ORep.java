package com.utility;

public class ORep {
	public static final String EnterGMOOnlineSubmitbutton = constants.Name+"&"+"bSubmit";
	public static final String EnterGMOOnlineText = constants.xpath+"&"+"//h1[contains(text(),'OnLine Catalog')]";
	public static final String QtyFrameBackpack = constants.xpath+"&"+"//strong[contains(text(),'Frame Backpack')]/../../following-sibling::td/h1/input";

	public static final String AlertconfirmButton = constants.ID+"&"+"confirmButton";
	public static final String AlertpromtButton = constants.ID+"&"+"promtButton";
	
	public static final String RightClick = constants.xpath+"&"+"//span[@class='context-menu-one btn btn-neutral']";
	
	public static final String copy_right_click = constants.xpath+"&"+"//span[text()='Copy']";
	public static final String DoubleClick_frame=constants.xpath+"&"+"//iframe";
	public static final String Double_Click=constants.xpath+"&"+"//span[text()='Double click the block']/preceding-sibling::div";
	
	public static final String DragAndDropFrame=constants.xpath+"&"+"//iframe[@class='demo-frame']";
	public static final String draggable=constants.ID+"&"+"draggable";
	public static final String droppable=constants.ID+"&"+"droppable";
	public static final String TextDrop=constants.xpath+"&"+"//div[@id='droppable']/p";
	
	public static final String FileUpload=constants.xpath+"&"+"//input[@id='input-4']/preceding-sibling::span";
	
	public static final String FileDownload=constants.xpath+"&"+"//a[@download='file-sample_500kB.doc']";
	
	public static final String Links=constants.tagName+"&"+"a";
	
	public static final String RegisterFirstName = constants.xpath+"&"+"//input[@placeholder='First Name']";
	public static final String RegisterLastName = constants.xpath+"&"+"//input[@placeholder='Last Name']";
	public static final String RegisterAddress = constants.xpath+"&"+"//textarea[@ng-model='Adress']";
	public static final String RegisterEmailAddress = constants.xpath+"&"+"//input[@type='email']";
	public static final String RegisterPhone = constants.xpath+"&"+"//input[@type='tel']";
	public static final String RegisterGenderMale = constants.xpath+"&"+"//input[@value='Male']";
	public static final String RegisterGenderFemale = constants.xpath+"&"+"//input[@value='FeMale']";
	public static final String RegisterHobbiesCricket = constants.ID+"&"+"checkbox1";
	public static final String RegisterHobbiesMovies = constants.ID+"&"+"checkbox2";
	public static final String RegisterHobbiesHockey = constants.ID+"&"+"checkbox3";
	public static final String RegisterLaunguages = constants.ID+"&"+"msdd";
	public static final String RegisterSkills = constants.xpath+"&"+"//select[@type='text' and @id='Skills']";
	public static final String Register_Skills_Label = constants.xpath+"&"+"//*[@id='Skills']/../../label";
	
	public static final String RegisterCountry = constants.ID+"&"+"countries";
	public static final String RegisterSelect_Country = constants.xpath+"&"+"//span[@role='combobox']";
	public static final String RegisterDOBYY = constants.ID+"&"+"yearbox";
	public static final String Register_DOBYY_DropDownItems = constants.xpath+"&"+"//*[@id='yearbox']/option";
	
	public static final String RegisterDOBMM = constants.xpath+"&"+"//select[@placeholder='Month']";
	public static final String Register_DOBMM_DropDownItems = constants.xpath+"&"+"//*[@placeholder='Month']/option";
	
	
	public static final String RegisterDOBDD = constants.ID+"&"+"daybox";
	public static final String Register_DOBDD_DropDownItems = constants.xpath+"&"+"//*[@placeholder='Day']/option";
	
	public static final String RegisterPWD = constants.ID+"&"+"firstpassword";
	public static final String RegisterConfirmPWD = constants.ID+"&"+"secondpassword";
	public static final String Register_LaungauaesDropDownItems =  constants.xpath+"&"+"//div[@id='msdd']/following-sibling::div/ul/li";
	public static final String Register_SkillsDropDownItems =  constants.xpath+"&"+"//select[@id='Skills']/option";
	public static final String Register_CountryDropDownItems =  constants.xpath+"&"+"//select[@id='countries']/option";
	public static final String Register_SelectCountry_TextBox =  constants.xpath+"&"+"//*[@type='search']";
	
	public static final String Calender =  constants.xpath+"&"+"//iframe[@class='demo-frame']";
	public static final String Cal_From =  constants.ID+"&"+"from";
	public static final String Cal_to =  constants.ID+"&"+"to";
	
	public static final String Cal_fromDate =  constants.xpath+"&"+"//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[4]";
	public static final String Cal_toDate =  constants.xpath+"&"+"//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[4]/td[4]/a";
			
}
