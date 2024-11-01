package swaglabs;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Problemuser {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*
		 Test scripts are
		 ** for full page screenshot which displays no images 
		 for products.
		 ** for missing product(item not found)
		 ** for wrong product :when user selects a product, 
		 but displays another product
		 **all the screenshots are saved in "screenshot1" folder
		 */
		System.out.println("This is my first script");
		WebDriverManager.firefoxdriver().setup();
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.saucedemo.com/v1/index.html");
		
		driver.findElement(By.id("user-name")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("user-name")).sendKeys("problem_user");

		driver.findElement(By.id("password")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("password")).sendKeys("secret_sauce");

		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		
	
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshot1\\fullpage.png");
		sourcefile.renameTo(targetfile);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//wrong product for "Sauce Labs Backpack"
		
		String str1 =driver.findElement(By.xpath("(//*[@class=\"inventory_item_name\"])[1]")).getText();
		
		driver.findElement(By.xpath("(//*[@class=\"inventory_item_name\"])[1]")).click();
          Thread.sleep(2000);
		String str2 =driver.findElement(By.xpath("//*[@class=\"inventory_details_name\"]")).getText();
	
	if(str1 !=str2)
	{
		WebElement wrgproduct =driver.findElement(By.xpath("//*[@class=\"inventory_details_container\"]"));
	    
		File src1=wrgproduct.getScreenshotAs(OutputType.FILE);
		File trg1=new File(System.getProperty("user.dir")+"\\screenshot1\\wrgpdt.png");
	
	    src1.renameTo(trg1);
	}
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@class=\"inventory_details_back_button\"]")).click();
	
	
	//missing product for "Sauce Labs Fleece Jacket"
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[text()=\"Sauce Labs Fleece Jacket\"]")).click();
	
	WebElement msgproduct =driver.findElement(By.xpath("//*[@class=\"inventory_details_container\"]"));
    
	File src2=msgproduct.getScreenshotAs(OutputType.FILE);
	File trg2=new File(System.getProperty("user.dir")+"\\screenshot1\\msgpdt.png");

    src2.renameTo(trg2);
    
    Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@class=\"inventory_details_back_button\"]")).click();
	
	//"Add to cart" in Disabled one for product "Sauce Labs Bolt T-Shirt"
	Thread.sleep(2000);
	
	WebElement product3 =driver.findElement(By.xpath("(//*[text()=\"ADD TO CART\"])[3]"));
	
	boolean addcartbtn3 = product3.isEnabled();
	System.out.println(addcartbtn3);
	
	if(addcartbtn3 == false)
	{
		WebElement btn3 =driver.findElement(By.xpath("(//*[@class=\"inventory_item\"])[3]"));
	    
		File src3=btn3.getScreenshotAs(OutputType.FILE);
		File trg3=new File(System.getProperty("user.dir")+"\\screenshot1\\AddtoCart.png");

	    src3.renameTo(trg3);
	    
	    Thread.sleep(2000);
		
	}
	
	Thread.sleep(4000);

	driver.close();
	}

}
