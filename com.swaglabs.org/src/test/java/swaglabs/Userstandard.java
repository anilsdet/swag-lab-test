package swaglabs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Userstandard {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		

		System.out.println("This is my standard user script");
		WebDriverManager.firefoxdriver().setup();
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.saucedemo.com/v1/index.html");

		Thread.sleep(7000);

		driver.findElement(By.id("user-name")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("user-name")).sendKeys("standard_user");

		driver.findElement(By.id("password")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("password")).sendKeys("secret_sauce");

		driver.findElement(By.id("login-button")).click();
		driver.findElement(By.className("product_sort_container")).click();

		WebElement category = driver.findElement(By.className("product_sort_container"));
				Select selection = new Select(category);
				List<WebElement> alloptions = selection.getOptions();
				for(int i=0;i<=alloptions.size()-1;i++)
				{
				System.out.println(alloptions.get(i).getText());
				}

		selection.selectByVisibleText("Name (Z to A)");
		Thread.sleep(5000);
		selection.selectByVisibleText("Price (low to high)");
		Thread.sleep(5000);
		selection.selectByVisibleText("Price (high to low)");
		Thread.sleep(4000);
		selection.selectByVisibleText("Name (A to Z)");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[text()=\"Sauce Labs Backpack\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()=\"ADD TO CART\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class=\"inventory_details_back_button\"]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//*[@class=\"inventory_item_img\"])[8]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()=\"ADD TO CART\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class=\"inventory_details_back_button\"]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[text()=\"Sauce Labs Onesie\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()=\"ADD TO CART\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class=\"inventory_details_back_button\"]")).click();
		Thread.sleep(3000);
		
		String str = driver.findElement(By.xpath("//*[@class=\"fa-layers-counter shopping_cart_badge\"]")).getText();
		
		System.out.println("Number of products added to the cart :  " +str);
		
		driver.findElement(By.xpath("//*[@class=\"shopping_cart_container\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[text()=\"REMOVE\"])[3]")).click();
		Thread.sleep(2000);
		
		String str1 = driver.findElement(By.xpath("//*[@class=\"fa-layers-counter shopping_cart_badge\"]")).getText();
		System.out.println("Number of products added to the cart after removed item :  " +str1);
		
		driver.findElement(By.xpath("//*[text()=\"CHECKOUT\"]")).click();
		
		String str3 = driver.getTitle();
		System.out.println(str3);
		
		String str4 =driver.findElement(By.xpath("//*[text()=\"Checkout: Your Information\"]")).getText();
		System.out.println(str4);
		
		driver.findElement(By.xpath("//*[@id='first-name']")).clear();
		driver.findElement(By.xpath("//*[@id='first-name']")).sendKeys("anil");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='last-name']")).clear();
		driver.findElement(By.xpath("//*[@id='last-name']")).sendKeys("SDET");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='postal-code']")).clear();
		driver.findElement(By.xpath("//*[@id='postal-code']")).sendKeys("BL9 6NE");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@class='btn_primary cart_button']")).click();
		
		driver.findElement(By.xpath("//*[text()=\"FINISH\"]")).click();
		
		Thread.sleep(3000);
		
		//String str5 = driver.findElement(By.xpath("//*[text()=\"THANK YOU FOR YOUR ORDER\"]")).getText();                                                        ")).click();
		
		String str5 = driver.findElement(By.xpath("//*[text()=\"THANK YOU FOR YOUR ORDER\"]")).getText();
		System.out.println(str5);
        Thread.sleep(4000);

		driver.close();
	}

}
