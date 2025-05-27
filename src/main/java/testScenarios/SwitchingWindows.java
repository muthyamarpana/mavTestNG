package testScenarios;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwitchingWindows {

@Test	
public void switchWin()
{
	
	WebDriver driver = new EdgeDriver();
	driver.get("https://www.w3schools.com/Jsref/tryit.asp?filename=tryjsref_win_open");
	driver.manage().window().maximize();
	driver.switchTo().frame("iframeResult");
	driver.findElement(By.xpath("/html/body/button")).click();
	Set<String> allWinIds=driver.getWindowHandles();
	String win1=null;
	String win2=null;
	Iterator<String> itr=allWinIds.iterator();
	if(itr.hasNext())
	{
		win1=itr.next();
		win2=itr.next();
	}
	
	System.out.println(win1);
	System.out.println(win2);
	System.out.println("Window1 title="+driver.getTitle());
	driver.switchTo().window(win2);
	System.out.println("Window2 title="+driver.getTitle());
	boolean chkLogIn=driver.findElement(By.xpath("//*[@id=\"tnb-login-btn\"]/span[1]")).isEnabled();
	System.out.println(chkLogIn);
	Assert.assertEquals(chkLogIn, true);
	
	System.out.println("total Windows opened="+allWinIds.size());
	driver.quit();
	
}
}
