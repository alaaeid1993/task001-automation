package Login;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import TestBase.Inisial;
import Utils.Java_utils;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class Login extends Inisial
{
	public Login() throws IOException
	{
		super();
	}

	@BeforeMethod
	public void setup(Method method) throws ATUTestRecorderException 
	{
		recorder = new ATUTestRecorder("C:\\Users\\UnKnown\\eclipse-workspace\\Alaa\\test-output\\Videos", method.getName(), false);
		recorder.start();
		Initialization(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	@AfterMethod 
	public void tear() throws ATUTestRecorderException 
	{
		recorder.stop();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}
	
	@Test(priority = 3)
	public void Log_vu_vp(Method method) throws IOException 
	{
		WebElement user = driver.findElement(By.name("email"));
		WebElement pass = driver.findElement(By.name("passwd"));
		user.sendKeys(prop.getProperty("user1"));
		pass.sendKeys(prop.getProperty("pass1")); 
		WebElement logbut = driver.findElement(By.name("SubmitLogin"));
		logbut.click();
		String acurl = driver.getCurrentUrl();
		String exurl = "http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(acurl, exurl, "Url Test not Passed");
		System.out.println("Test success, an acceptable username and password");
		Java_utils.sreen(method.getName());

	}
	
	@Test(priority = 4)
	public void Log_ivu_vp(Method method) throws IOException 
	{
		WebElement user = driver.findElement(By.name("email"));
		WebElement pass = driver.findElement(By.name("passwd"));
		user.sendKeys(prop.getProperty("user2"));
		pass.sendKeys(prop.getProperty("pass1")); 
		WebElement logbut = driver.findElement(By.name("SubmitLogin"));
		logbut.click();
		String acurl = driver.getCurrentUrl();
		String exurl = "http://automationpractice.com/index.php?controller=authentication";
		Assert.assertEquals(acurl, exurl, "Url Test not Passed");
		System.out.println("no access to the account Incorrect username ");
		Java_utils.sreen(method.getName());

	}
	
	@Test(priority = 5)
	public void Log_vu_ivp(Method method) throws IOException 
	{
		WebElement user = driver.findElement(By.name("email"));
		WebElement pass = driver.findElement(By.name("passwd"));
		user.sendKeys(prop.getProperty("user1"));
		pass.sendKeys(prop.getProperty("pass2")); 
		WebElement logbut = driver.findElement(By.name("SubmitLogin"));
		logbut.click();
		String acurl = driver.getCurrentUrl();
		String exurl = "http://automationpractice.com/index.php?controller=authentication";
		Assert.assertEquals(acurl, exurl, "Url Test not Passed");
		System.out.println("no access to the account Incorrect password ");
		Java_utils.sreen(method.getName());

	}
	
	@Test(priority = 6)
	public void Log_ivu_ivp(Method method) throws IOException 
	{
		WebElement user = driver.findElement(By.name("email"));
		WebElement pass = driver.findElement(By.name("passwd"));
		user.sendKeys(prop.getProperty("user2"));
		pass.sendKeys(prop.getProperty("pass2")); 
		WebElement logbut = driver.findElement(By.name("SubmitLogin"));
		logbut.click();
		String acurl = driver.getCurrentUrl();
		String exurl = "http://automationpractice.com/index.php?controller=authentication";
		Assert.assertEquals(acurl, exurl, "Url Test not Passed");
		System.out.println("no access to the account Incorrect username and password ");
		Java_utils.sreen(method.getName());
	}
	
	@Test(priority = 7)
	public void Log_eu_ep(Method method) throws IOException 
	{
		WebElement user = driver.findElement(By.name("email"));
		WebElement pass = driver.findElement(By.name("passwd"));
		user.sendKeys(prop.getProperty("user3"));
		pass.sendKeys(prop.getProperty("pass3")); 
		WebElement logbut = driver.findElement(By.name("SubmitLogin"));
		logbut.click();
		String acurl = driver.getCurrentUrl();
		String exurl = "http://automationpractice.com/index.php?controller=authentication";
		Assert.assertEquals(acurl, exurl, "Url Test not Passed");
		System.out.println("no access to the account Empty username and password ");
		Java_utils.sreen(method.getName());
	}
	
	@Test(priority = 8)
	public void Log_nonu_nonp(Method method) throws IOException 
	{
		WebElement user = driver.findElement(By.name("email"));
		WebElement pass = driver.findElement(By.name("passwd"));
		user.sendKeys(prop.getProperty("c2"));
		pass.sendKeys(prop.getProperty("pass4")); 
		WebElement logbut = driver.findElement(By.name("SubmitLogin"));
		logbut.click();
		String acurl = driver.getCurrentUrl();
		String exurl = "http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(acurl, exurl, "Url Test not Passed");
		System.out.println("Test success, an acceptable numrical username and password");
		Java_utils.sreen(method.getName());
	}
	
	@Test(priority = 9)
	public void Log_forget(Method method) throws IOException 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
		WebElement for_but = driver.findElement(By.xpath("//*[text() = 'Forgot your password?']"));
		for_but.click();
		WebElement re_email_acount = driver.findElement(By.id("email"));
		WebElement re_email_but = driver.findElement(By.xpath("//*[text() = 'Retrieve Password']"));
		re_email_acount.sendKeys(prop.getProperty("user1"));
		re_email_but.click();
		
		String acurl = driver.getCurrentUrl();
		String exurl = "http://automationpractice.com/index.php?controller=password";
		Assert.assertEquals(acurl, exurl, "Url Test not Passed");
		System.out.println("A confirmation email has been sent to your address : " + prop.getProperty("user1"));
		Java_utils.sreen(method.getName());

	}
	
	
	
}

