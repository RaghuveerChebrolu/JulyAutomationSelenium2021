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
	
}
