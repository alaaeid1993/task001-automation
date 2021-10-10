package Reg;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import TestBase.Inisial;
import Utils.Java_utils;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class Reg  extends Inisial
{
	
	public Reg() throws IOException {
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
		driver.quit();
	}

	@Test(priority = 0)
	public void Create_Acount_NLet_Nnum(Method method) throws IOException 
	{
		WebElement create = driver.findElement(By.name("email_create"));
		WebElement createbut = driver.findElement(By.name("SubmitCreate"));
		create.sendKeys(prop.getProperty("c1"));
		createbut.click();
		// Creation Page Code//
		WebElement gender = driver.findElement(By.name("id_gender"));
		WebElement fn = driver.findElement(By.name("customer_firstname"));
		WebElement ln = driver.findElement(By.name("customer_lastname"));
		WebElement pa = driver.findElement(By.name("passwd"));
		WebElement day = driver.findElement(By.name("days"));
		WebElement months = driver.findElement(By.name("months"));
		WebElement years = driver.findElement(By.name("years"));
		WebElement chick = driver.findElement(By.xpath("//*[text() = 'Sign up for our newsletter!']"));
		WebElement company = driver.findElement(By.name("company"));
		WebElement address1 = driver.findElement(By.name("address1"));
		WebElement city = driver.findElement(By.name("city"));
		WebElement state = driver.findElement(By.id("id_state"));
		WebElement postcode = driver.findElement(By.name("postcode"));
		WebElement country = driver.findElement(By.name("id_country"));
		WebElement phone_mobile = driver.findElement(By.name("phone_mobile"));
		WebElement alias = driver.findElement(By.name("alias"));
		WebElement reg = driver.findElement(By.name("submitAccount"));
//TECHNICAL ERROR: unable to load form. Details: Error thrown: [object Object] Text status: error

		
		gender.click();
		fn.sendKeys("Alaa");
		ln.sendKeys("Eid");
		pa.sendKeys(prop.getProperty("pass1"));
		day.sendKeys("20");
		months.sendKeys("January ");
		years.sendKeys("1994");
		chick.click();
		company.sendKeys("Test g");
		address1.sendKeys("11 st shz");
		city.sendKeys("Giza");
		state.sendKeys("Arizona");
		postcode.sendKeys("12345");
		country.sendKeys("United States");
		phone_mobile.sendKeys("0123456789");
		alias.sendKeys("alaa@gmail.com");
		reg.click();
		String acutit = driver.getTitle();
		String extit = "My account - My Store";
		Assert.assertEquals(acutit, extit, "title Test not Passed");
		System.out.println("Account Created : " + prop.getProperty("c1"));
		Java_utils.sreen(method.getName());
	}
	
	@Test(priority = 1)
	public void Create_Acount_NonLet_Nonnum(Method method) throws IOException 
	{
		WebElement create = driver.findElement(By.name("email_create"));
		WebElement createbut = driver.findElement(By.name("SubmitCreate"));
		create.sendKeys(prop.getProperty("c2"));
		createbut.click();
		// Creation Page Code//
		WebElement gender = driver.findElement(By.name("id_gender"));
		WebElement fn = driver.findElement(By.name("customer_firstname"));
		WebElement ln = driver.findElement(By.name("customer_lastname"));
		WebElement pa = driver.findElement(By.name("passwd"));
		WebElement day = driver.findElement(By.name("days"));
		WebElement months = driver.findElement(By.name("months"));
		WebElement years = driver.findElement(By.name("years"));
		WebElement chick = driver.findElement(By.xpath("//*[text() = 'Sign up for our newsletter!']"));
		WebElement company = driver.findElement(By.name("company"));
		WebElement address1 = driver.findElement(By.name("address1"));
		WebElement city = driver.findElement(By.name("city"));
		WebElement state = driver.findElement(By.id("id_state"));
		WebElement postcode = driver.findElement(By.name("postcode"));
		WebElement country = driver.findElement(By.name("id_country"));
		WebElement phone_mobile = driver.findElement(By.name("phone_mobile"));
		WebElement alias = driver.findElement(By.name("alias"));
		WebElement reg = driver.findElement(By.name("submitAccount"));
//TECHNICAL ERROR: unable to load form. Details: Error thrown: [object Object] Text status: error

		
		gender.click();
		fn.sendKeys("Alaa");
		ln.sendKeys("Eid");
		pa.sendKeys(prop.getProperty("pass4"));
		day.sendKeys("20");
		months.sendKeys("January ");
		years.sendKeys("1994");
		chick.click();
		company.sendKeys("Test g");
		address1.sendKeys("11 st shz");
		city.sendKeys("Giza");
		state.sendKeys("Arizona");
		postcode.sendKeys("12345");
		country.sendKeys("United States");
		phone_mobile.sendKeys("0123456789");
		alias.sendKeys("alaa@gmail.com");
		reg.click();
		String acutit = driver.getTitle();
		String extit = "My account - My Store";
		Assert.assertEquals(acutit, extit, "title Test not Passed");
		System.out.println("Account Created : " + prop.getProperty("c2"));
		Java_utils.sreen(method.getName());
	}
	
	@Test(priority = 2)
	public void Ex_Acount(Method method) throws IOException 
	{
		WebElement create = driver.findElement(By.name("email_create"));
		WebElement createbut = driver.findElement(By.name("SubmitCreate"));
		create.sendKeys(prop.getProperty("c1"));
		createbut.click();
		String acurl = driver.getCurrentUrl();
		String exurl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
		Assert.assertEquals(acurl, exurl, "an account using this email address has already been registered. Please enter a valid password or request a new one");
		System.out.println("no access to this account [exciting account] : " + prop.getProperty("c1"));
		Java_utils.sreen(method.getName());	
	}
}


