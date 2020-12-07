package datadriventesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class DataDriven 
{
	WebDriver driver;
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\nov20\\chromedriver.exe");
		driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@Test(dataProvider="loginData")
	public void loginTest(String un,String pw,String re)
	{
		driver.get("https://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys(un);
		driver.findElement(By.name("pass")).sendKeys(pw);
		driver.findElement(By.name("login")).click();
		
		String exptitle="Facebook";
		String acttittle=driver.getTitle();
		
		if(exptitle.equals("pass"))
		{
			if(exptitle.equals(acttittle))
			{
				driver.findElement(By.xpath("//div[@aria-label='Account']")).click();
				driver.findElement(By.xpath("//span[text()='Log Out']")).click();
				Assert.assertTrue(true);
			}
			else 
			{
				Assert.assertTrue(false);
			}
		}
		else if(exptitle.equals("fail"))
		{
			if(exptitle.equals(acttittle))
			{
				driver.findElement(By.xpath("//div[@aria-label='Account']")).click();
				driver.findElement(By.xpath("//span[text()='Log Out']")).click();
				Assert.assertTrue(false);
			}
			else 
			{
				Assert.assertTrue(true);
			}
		}
	}
	@DataProvider(name="loginData")
	public String[][] getData()
	{
		String loginData[][]= {
				{"sureshhande28@gmail.com","	loveuaai","	pass"},
				{"sureshhande28@gmail.com","	aai","	fail"},
				{"sureshhande@gmail.com	","loveuaai","	fail"},
				{"suresh@gmail.com	","love"	,"fail"}

		};
		return loginData;
	}
	@AfterClass
	void tearDown()
	{
		driver.close();
	}
}
