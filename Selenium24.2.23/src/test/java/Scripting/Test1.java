package Scripting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {
	public WebDriver driver;
	@Test
	public void tc1()
	{
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.skillrary.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void tc2()
	{
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		/*SoftAssert s=new SoftAssert();
		driver.get("https://www.amazon.in");
		String title=driver.getTitle();
        s.assertEquals(title,title);*/

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//s.assertAll();
		//Assert.assertEquals("a", "a");
		
	}
	

}
