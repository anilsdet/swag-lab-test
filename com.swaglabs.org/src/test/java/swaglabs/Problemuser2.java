package swaglabs;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Problemuser2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*
		 The following Test script produces screeenshots :
		 (All the screenshots are saved in "screenshot" folder)
		 *** when user landed /navigated to home page(inventory page)  displaying
		 *products with no images.(saved as "productspage.png")
		 *** when user clicks burger icon and selected "About" link , the web page is unable to load
		 *shows "404 NOT FOUND".(saved as "aboutpage.png")
		 *** when user selected products by using "Add to cart" buttton and the add to cart icon is updated
		 *but when the user cliks on "Reset app state" cart is cleared but the "Remove" buttons wouldnot changes to "Add to cart"
		 *(image saved as resetpage.png)
		 ***screenshot is taken when user enters firstname (saved as checkout.png)
		 ***screenshot is taken when the user enters lastname then 
		 *firstname also gets duplicated as lastname(saved as duplicatename.png)
		 ***screenshot showing emptydelivery(emptydelivery.png)
		 
		 */
		System.out.println("This is problem_user script");
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
		
		WebElement burgericon =driver.findElement(By.className("bm-burger-button"));
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOf(burgericon));
		
		burgericon.click();
		
		driver.findElement(By.xpath("//a[@id='about_sidebar_link']")).click();
		
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		
       TakesScreenshot ts=(TakesScreenshot)driver;
		
		File src6=ts.getScreenshotAs(OutputType.FILE);
		
		File trg6=new File(System.getProperty("user.dir")+"\\screenshot\\aboutpage.png");
		src6.renameTo(trg6);
		driver.navigate().back();
		driver.findElement(By.xpath("(//*[text()=\"ADD TO CART\"])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text()=\"ADD TO CART\"])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[text()=\"ADD TO CART\"])[3]")).click();
		Thread.sleep(2000);
		
		
        File src7=ts.getScreenshotAs(OutputType.FILE);
		
		File trg7=new File(System.getProperty("user.dir")+"\\screenshot\\productspage.png");
		src7.renameTo(trg7);
		
		
		//wait.until(ExpectedConditions.visibilityOf(burgericon));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class=\"bm-burger-button\"]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='reset_sidebar_link']")).click();
		
		TakesScreenshot ts1=(TakesScreenshot)driver;
        File src8=ts1.getScreenshotAs(OutputType.FILE);
		
		File trg8=new File(System.getProperty("user.dir")+"\\screenshot\\resetpage.png");
		src8.renameTo(trg8);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='bm-cross-button']")).click();
		
WebElement addtocarticon =driver.findElement(By.className("shopping_cart_container"));
		
		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait1.until(ExpectedConditions.visibilityOf(addtocarticon));
		
		addtocarticon.click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()=\"CHECKOUT\"]")).click();

	System.out.println(driver.findElement(By.xpath("//*[text()=\"Checkout: Your Information\"]")).getText());
		
	driver.findElement(By.xpath("//*[@id='first-name']")).clear();
	driver.findElement(By.xpath("//*[@id='first-name']")).sendKeys("anil");
	driver.findElement(By.xpath("//*[@id='first-name']")).getText();
	
	TakesScreenshot ts2=(TakesScreenshot)driver;
    File src9=ts2.getScreenshotAs(OutputType.FILE);
	
	File trg9=new File(System.getProperty("user.dir")+"\\screenshot\\checkoutpage.png");
	src9.renameTo(trg9);
	
	driver.findElement(By.xpath("//*[@id='last-name']")).clear();
	driver.findElement(By.xpath("//*[@id='last-name']")).sendKeys("SDET");
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//*[@id='postal-code']")).clear();
	driver.findElement(By.xpath("//*[@id='postal-code']")).sendKeys("BL9 6NE");
	Thread.sleep(2000);
	
	TakesScreenshot ts3=(TakesScreenshot)driver;
    File src10=ts3.getScreenshotAs(OutputType.FILE);
	
	File trg10=new File(System.getProperty("user.dir")+"\\screenshot\\duplicatename.png");
	src10.renameTo(trg10);
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@class='btn_primary cart_button']")).click();
	
	TakesScreenshot ts4=(TakesScreenshot)driver;
    File src11=ts4.getScreenshotAs(OutputType.FILE);
	
	File trg11=new File(System.getProperty("user.dir")+"\\screenshot\\emptydelivery.png");
	src11.renameTo(trg11);
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[text()=\"FINISH\"]")).click();
	
	
	driver.findElement(By.xpath("//*[text()=\"THANK YOU FOR YOUR ORDER\"]")).getText();

	}

}
