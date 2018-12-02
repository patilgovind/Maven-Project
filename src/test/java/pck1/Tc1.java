package pck1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Tc1 
{
	
	public static  WebDriver driver=null;
	public static WebDriverWait mywait=null;
	public static final String project_path=System.getProperty("user.dir");
	
	
	
	@BeforeClass
	
	public void initialize()
	{
		System.out.println("Before class method is calling");
		System.setProperty("webdriver.gecko.driver", project_path+"\\Drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@Test
	
	public void step1() throws InterruptedException
	{
		System.out.println("Step1 is calling");
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		Thread.sleep((long) 30.0);
		String page_Title=driver.getTitle();
		Assert.assertEquals(page_Title, "OrangeHRM");
		System.out.println(page_Title);
	}
	
	@Test (dependsOnMethods="step1")
	
	public void step2() throws InterruptedException 
	{
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		String page_Title=driver.getTitle();
		Assert.assertEquals(page_Title, "OrangeHRM");
		System.out.println(page_Title);
		Thread.sleep((long) 30.0);
	}
	
	
	
	@AfterClass
	public void tearDown() throws InterruptedException
	{
		System.out.println("after class method is calling");
		mywait=new WebDriverWait(driver, 100);
		mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='welcome']")));
		driver.findElement(By.xpath("//*[@id='welcome']")).click();
		mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("/*[@id='welcome-menu']/ul/li[2]/a")));
		driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")).click();
		Thread.sleep((long) 30.0);
		String page_Title=driver.getTitle();
		Assert.assertEquals(page_Title, "OrangeHRM");
		driver.close();
		//driver.quit();
	}

}
