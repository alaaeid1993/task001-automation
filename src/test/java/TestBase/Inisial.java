package TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import atu.testrecorder.ATUTestRecorder;

public class Inisial 
{	
	public static WebDriver driver;	
	public static Properties prop;
	public static ATUTestRecorder recorder;
	
	
	public Inisial() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\UnKnown\\eclipse-workspace\\Alaa\\src\\test\\java\\Propreties\\config\\config.propreties");
		prop.load(fis);	
		
	}
	public void Initialization(String URL) 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Work\\Eclips\\chromedriver_win32_2\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(URL);
	}
	
	
}
