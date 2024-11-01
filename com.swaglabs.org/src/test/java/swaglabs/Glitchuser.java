package swaglabs;

import java.time.Duration;
import java.time.Instant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Glitchuser {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		/* the test script describes the load time for web page 
		 * problem_glitchuser
		 */
		System.out.println("This is my performance_glitch_user script");
		WebDriverManager.firefoxdriver().setup();
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.saucedemo.com/v1/index.html");

		Thread.sleep(7000);

		driver.findElement(By.id("user-name")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");

		driver.findElement(By.id("password")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
        
		Instant startTime = Instant.now();
		System.out.println(startTime.toString());
		driver.findElement(By.id("login-button")).click();
		
		Instant endTime = Instant.now();
		System.out.println(endTime.toString());
		Duration object = Duration.between(startTime, endTime);
		System.out.println(object);
		System.out.println(driver.getTitle());
		
		
		
		
		
		
		
	}

}
