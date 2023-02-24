package GenricLib;

import java.awt.Window;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Webdriverutilies {
	public void mousehover(WebDriver driver, WebElement ele)
	{
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
	}
	public void dropdown(WebElement ele,String txt)
	{
		Select s=new Select(ele);
		s.selectByVisibleText(txt);
		
		
	}
	public void draganddrop(WebDriver driver, WebElement ele1, WebElement  ele2)
	{
		Actions a=new Actions(driver);
		a.dragAndDrop(ele1, ele2);
	}
	public void switchtabs(WebDriver driver)
	{
		Set<String> child = driver.getWindowHandles();
		for(String b:child)
		{
			driver.switchTo().window(b);
		}
	}
	public void scrollbar(WebDriver driver, int x, int y)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("Windows.scrollBy("+x+","+y+")");
		
	}
	public void alertpopup(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void switchframes(WebDriver driver)
	{
		driver.switchTo().frame(0);
		
	}
}
