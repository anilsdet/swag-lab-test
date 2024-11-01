package swaglabs;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lockeduser {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		/*
		 * The following Test script produces screeenshots for locked user and saved in 
		 * "Lockeduser_screenshot" folder
		 */
		System.out.println("This is my first script");
		WebDriverManager.firefoxdriver().setup();
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.saucedemo.com/v1/index.html");

		Thread.sleep(7000);

		driver.findElement(By.id("user-name")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("user-name")).sendKeys("locked_out_user");

		driver.findElement(By.id("password")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("password")).sendKeys("secret_sauce");

		driver.findElement(By.id("login-button")).click();
		
		Thread.sleep(2000);
		
		String str3 =driver.findElement(By.xpath("//*[@class=\"error-button\"]")).getText();
		System.out.println(str3);
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		////*[@class="error-button"]
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		
		File targetfile=new File(System.getProperty("user.dir")+"\\Lockeduser_screenshot\\fullpage1.png");
		sourcefile.renameTo(targetfile);
	}

}
