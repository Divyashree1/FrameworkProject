package com.tyss.projectframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.projectframework.lib.GenericLib;

public class Homepage {

	WebDriver driver;
	
	@FindBy(xpath="//a[contains(.,'MyAccount')]")
	private WebElement myAccountBtn;
	
	@FindBy(name="product")
	private WebElement searchBox;
	
	@FindBy(xpath="//button[@name='search']")
	private WebElement searchBtn;
	
	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void myAccountBtnClick() {
		GenericLib.clickElement(driver, myAccountBtn, "Account Button");
	}
public void searchBoxEnterTextAndClick(String searchText)throws InterruptedException{
	GenericLib.enterText(driver, searchBox, searchText, "searchBox");
	Thread.sleep(2000);
	GenericLib.clickElement(driver, searchBtn, "search Btn");
}
}
