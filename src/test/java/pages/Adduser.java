package pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Adduser 
{
	WebDriver driver;
	
	By userRole_lov=By.id("systemUser_userType");
	By employeename_txt=By.id("systemUser_employeeName_empName");
	By username_txt=By.id("systemUser_userName");
	By staus_lov=By.id("systemUser_status");
	By password_txt=By.id("systemUser_password");
	By confirmpassword_txt=By.id("systemUser_confirmPassword");
	By save_btn=By.id("btnSave");
	By cancel_btn=By.id("btnCancel");

	public Adduser(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void addNewUser(HashMap<String, String>input)
	{
		if(input.containsKey("userrole"))
		{
			Select userrole=new Select(driver.findElement(userRole_lov));
			userrole.selectByValue(input.get("userrole"));
		}
		
		if(input.containsKey("employeename"))
		{
			driver.findElement(employeename_txt).sendKeys(input.get("employeename"));
		}
		
		if(input.containsKey("username"))
		{
			driver.findElement(username_txt).sendKeys(input.get("username"));
		}
		
		if(input.containsKey("status"))
		{
			Select status=new Select(driver.findElement(staus_lov));
			status.selectByValue(input.get("status"));
		}
		
		if(input.containsKey("password"))
		{
			driver.findElement(password_txt).sendKeys(input.get("pasword"));
		}
		if(input.containsKey("confirmpassword"))
		{
			driver.findElement(confirmpassword_txt).sendKeys(input.get("confirmpassword"));
		}
		
		driver.findElement(cancel_btn).click();
		
		
	}
	
	
	
	
	
	
}
