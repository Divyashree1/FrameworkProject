package com.tyss.projectframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.projectframework.lib.GenericLib;

public class Signinpage {
WebDriver driver;
	
	@FindBy(id="exampleInputEmail1")
	private WebElement unTxtBox;
	
	@FindBy(id="exampleInputpassword1")
	private WebElement pwdTxtBox;
	
	@FindBy(name="login")
	private WebElement loginBtn;
	
	public Signinpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void dologin(String username,String password) {
		GenericLib.enterText(driver, unTxtBox, username, "username Textbox");
		GenericLib.enterText(driver, pwdTxtBox, password, "password Textbox");
		GenericLib.clickElement(driver, loginBtn, "Login Btn");
	}
	
}
