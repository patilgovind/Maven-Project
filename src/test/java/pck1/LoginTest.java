package pck1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pages.Loginpage;

public class LoginTest 
{
	WebDriver driver=null;
	Loginpage login;
	ExtentHtmlReporter htmlreporter;
	ExtentReports report;
	ExtentTest test;
	public static final String project_path=System.getProperty("user.dir");
	
	@BeforeClass
	@Parameters("browserName")
	public void initialize(String browserName)
	{
		htmlreporter =new ExtentHtmlReporter(project_path+"\\Reports\\BasicReport.html");
		report=new ExtentReports();
		report.attachReporter(htmlreporter);
		test=report.createTest("Orange HRM","Orange HRM Login flow");
		if(browserName.equalsIgnoreCase("firefox"));
		{
			//System.setProperty("webdriver.gecko.driver", project_path+"\\Drivers\\geckdriver.exe");
			System.setProperty("webdriver.gecko.driver", project_path+"\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		if(browserName.equalsIgnoreCase("chrome"))
		{	driver=new ChromeDriver();
		
		}
		login=new Loginpage(driver);
		driver.manage().window().maximize();
		test.log(Status.PASS, "browser launched sucessfully");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);		
	}
	
	@Test
	
	public void valid_Login()
	{
		try
		{
			driver.get("https://opensource-demo.orangehrmlive.com/");
			String login_Title=driver.getTitle();
			Assert.assertEquals(login_Title, "OrangeHRM");
			test.log(Status.PASS, "sucessfully navigated to login page");
			Thread.sleep(600);
			login.login("admin", "admin123");
			Thread.sleep(600);
			String page_Title=driver.getTitle();
			Assert.assertEquals(page_Title, "OrangeHRM");
			//test.log(Status.PASS, "login was suceessfull");
			test.log(Status.PASS, "Home page displayed sucessfully");
		}
		catch (Exception e) {
			e.printStackTrace();
			teardown();
			
		}
		
	}
	
	@AfterClass
	
	public void teardown()
	{
		driver.close();
		//driver.close();
		report.flush();
	}

}
