package testScenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class DatePicker {

	//06/19/2026
	@Test
	public void selDate()
	{
		Integer yr=2026;
		WebDriver driver = new EdgeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		driver.findElement(By.id("datepicker")).click();
		while(true) {
			String month=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]")).getText();
			String year=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[2]")).getText();
			if(year.equals(String.valueOf(yr)) && month.equals("June"))
			{
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[6]/a")).click();
				break;
			}
			if(yr<=2025)
			{
				//click on previous 
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click();
				
				
			}
			else
			{
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
			}
			
		}
		driver.quit();
		
	}
	
}
