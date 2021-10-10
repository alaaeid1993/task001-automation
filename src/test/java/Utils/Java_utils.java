package Utils;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import TestBase.Inisial;

public class Java_utils extends Inisial
{

	public Java_utils() throws IOException
	{
		super();
	}
	
	public static void sreen(String name) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs((OutputType.FILE));
		FileUtils.copyFile(src, new File("C:\\Users\\UnKnown\\eclipse-workspace\\Alaa\\test-output\\SnapShotes\\" + name + ".png"));
	}	
	
}
