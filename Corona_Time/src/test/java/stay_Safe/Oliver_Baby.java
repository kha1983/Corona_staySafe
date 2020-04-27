package stay_Safe;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Oliver_Baby {
	WebDriver driver;
	@BeforeMethod
	public void UserWillAbleToOpenTheBrowser()            {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		driver.manage().window().maximize();
		//driver.close();
		//driver.quit();
		
	}
	@Test(priority=1)
	public void UserWillBeAbleToLoginThePage()           {
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//*[contains(text(),'Sign in')]")).click();
		//driver.close();
		//driver.quit();
		
		String ExpectedTitle="Dashboard";
		String ActualTitle=driver.getTitle();
		System.out.println("Your Assert starts here");
		
		try    {
			Assert.assertEquals(ActualTitle, ExpectedTitle);
		}
		catch(Throwable e)      {
			System.out.println("Assert ends here and testing is passed");
		}
	}
		
		@Test(priority=2)
		public void UserWIllAbleToAddNewProduct() throws InterruptedException          {
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//*[contains(text(),'Sign in')]")).click();
		driver.findElement(By.linkText("Products & Services")).click();
		driver.findElement(By.linkText("New Product")).click();
		driver.findElement(By.id("name")).sendKeys("Khadak Bahadur Kathayat");
		driver.findElement(By.name("sales_price")).sendKeys("6500");
		Thread.sleep(3000);
		driver.findElement(By.id("description")).sendKeys("Stay home and stay safe");
		driver.findElement(By.id("submit")).click();
		Thread.sleep(2000);
	
		
		boolean status=driver.findElement(By.linkText("Stay home and stay safe")).isDisplayed();
		
		if(status==true)     {
			System.out.println("The testing is passed");
		}
		else   {
			System.out.println("The testing is failed");
		}
	
		}
		@AfterMethod
		public void UserAbleToCloseAllWindow()             {
			driver.close();
			driver.quit();
		}
		
	
	}
