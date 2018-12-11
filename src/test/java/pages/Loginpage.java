package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Loginpage 
{
	WebDriver driver;
	
	//WebDriverWait mywait;
	
	By userName_txt=By.id("txtUsername");
	
	By password_txt=By.id("txtPassword");
	
	By loginbtn=By.id("btnLogin");
	
	
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		//mywait=new WebDriverWait(driver, 30);
	}
	
	public void login(String username,String password)
	{
		driver.findElement(userName_txt).sendKeys(username);
		driver.findElement(password_txt).sendKeys(password);
		driver.findElement(loginbtn).click();		
	}

}
