package com.tyss.projectframework.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
 
import com.tyss.projectframework.init.IConstants;
import com.tyss.projectframework.lib.BaseLib;
import com.tyss.projectframework.lib.ExcelLib;
import com.tyss.projectframework.lib.GenericLib;
import com.tyss.projectframework.pages.Homepage;
import com.tyss.projectframework.pages.MyCartPage;
import com.tyss.projectframework.pages.Signinpage;

public class LoginTest extends BaseLib{
static {
	System.setProperty("webdriver.chrome.driver", "./softwares/chromedriver.exe");
}
	@Test
	public void tc_01() throws InterruptedException{
		Homepage hp=new Homepage(driver);
		Assert.assertEquals(hp.getHomepageTitle(), ExcelLib.getdata("sheet1", 1, 1, IConstants.expectedExcelPath));
		hp.myAccountBtnClick();
		Signinpage sip=new Signinpage(driver);
		Assert.assertEquals(sip.getSigninpageTitle(), ExcelLib.getdata("sheet2", 1, 2, IConstants.expectedExcelPath));
		String  un= ExcelLib.getdata("sheet1", 1, 1, IConstants.expectedExcelPath);
		String pw= ExcelLib.getdata("sheet2", 1, 2, IConstants.expectedExcelPath);
		sip.dologin(un, pw);
		MyCartPage mcp=new MyCartPage(driver);
		Assert.assertTrue(mcp.getWelcomeName().contains(ExcelLib.getdata("sheet1", 1, 3, IConstants.expectedExcelPath)));
		Thread.sleep(2000);
		
		//public void tc_01() throws EncryptedDocumentException, InvalidFormatException,IOException,InterruptedException{
		//WebDriver driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		//driver.get("http://localhost/shopping/");
		//driver.findElement(By.xpath("//a[contains(.,'My Account')]")).click();
		
		//reading the username and password from excel
		//FileInputStream fin=new  FileInputStream(IConstants.dataExcelPath);
		//Workbook workbook =WorkbookFactory.create(fin);
		//Sheet sheet=workbook.getSheet("Sheet1");
		//String username=sheet.getRow(1).getCell(1).getStringCellValue();
		//String password=sheet.getRow(1).getCell(2).getStringCellValue();
		
		//driver.findElement(By.id("exampleInputEmail1")).sendKeys(username);
		//driver.findElement(By.id("exampleInputpassword1")).sendKeys(password);
		//Thread.sleep(2000);
		//driver.findElement(By.name("login")).click();
		//Thread.sleep(2000);
	//}
	//@Test
	//public void tc_02() throws InterruptedException{
		//Homepage hp=new Homepage(driver);
		//Signinpage sip=new Signinpage(driver);
		//String un=ExcelLib.getdata("sheet1",1,1,IConstants.dataExcelPath);
		//String pw=ExcelLib.getdata("sheet1",1,2,IConstants.dataExcelPath);
		//sip.dologin(un,pw);
	//}
	//@Test(enabled=false)
	//public void tc_03() throws InterruptedException{
		//Homepage hp=new Homepage(driver);
		//hp.searchBoxEnterTextAndClick("TV");
		
	}
}
