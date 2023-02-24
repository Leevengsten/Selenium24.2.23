package GenricLib;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public ExtentHtmlReporter htmlreport;
	public ExtentReports reports;
	public Connection con;
	FileUtilies fu=new FileUtilies();
	@BeforeSuite
	public void configbs() throws SQLException
	{
		fu.getdatadb();
		htmlreport=new ExtentHtmlReporter(AutoConstant.reportspath+"Skillrary.html");
		htmlreport.config().setDocumentTitle("Skillrary Reports");
		htmlreport.config().setTheme(Theme.DARK);
		 reports=new ExtentReports();
		reports.attachReporter(htmlreport);
		
		
		
		
		
	}
	@BeforeMethod
	public void openapp()
	{
		WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("url");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	
	}
	@AfterMethod
	public void closeapp(ITestResult res) throws IOException
	{
		int status=res.getStatus();
		String name=res.getName();
		if(status==2)
		{
			Photo p=new Photo();
			p.getphoto(name);
		}
		
	}
	@AfterSuite
	public void configas() throws SQLException
	{
		fu.closedb();
		reports.flush();
	}

}
