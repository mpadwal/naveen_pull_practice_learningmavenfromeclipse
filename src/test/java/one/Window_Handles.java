
package one;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Window_Handles
{
	public static WebDriver  driver ;
public static void  main(String[] args) throws InterruptedException
{
	
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
   
    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    driver.findElement(By.xpath("//div[@class='orangehrm-login-footer-sm']//a[1]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@class='orangehrm-login-footer-sm']//a[2]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@class='orangehrm-login-footer-sm']//a[3]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@class='orangehrm-login-footer-sm']//a[4]")).click();
	
	
	Set<String> handles = driver.getWindowHandles();
	List<String> hlist = new ArrayList<String>(handles);
	if(switchToRightWindow("Facebook",hlist))
	{
		System.out.println(driver.getCurrentUrl() + ":" + driver.getTitle());
	}
}
	public static boolean switchToRightWindow(String windowtitle,List<String> hlist1)
	{
		for (String e: hlist1)
		{
			String title = driver.switchTo().window(e).getTitle();
			if(title.contains(windowtitle))
			{
				System.out.println("found the right window.....");
			    return true;
			}
		}
		return false;
	}
	
}






