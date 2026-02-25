package DemoPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class NewTest {
	WebDriver driver;

	@Test
	public void f() throws InterruptedException {

		// Click Mobiles
		System.out.println("Click on mobiles");
		driver.findElement(By.linkText("Mobiles")).click();
		Thread.sleep(3000);

		// Select 4th mobile
		System.out.println("select 4th mobile");
		driver.findElements(By.xpath("//div[@data-component-type='s-search-result']")).get(3).click();
		Thread.sleep(3000);

		// Switch window
		//System.out.println("open new window");
			//String win = null;
			//driver.switchTo().window(win);
			//Thread.sleep(3000);
		
		// Add to cart
		System.out.println("click add to cart");
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(3000);

		// Go to cart
		System.out.println("verify cart");
		driver.findElement(By.id("nav-cart")).click();
		Thread.sleep(3000);

		Assert.assertTrue(driver.getTitle().contains("Shopping Cart"));

		// Proceed to buy
		System.out.println("click on buy to proceed ");
		driver.findElement(By.name("proceedToRetailCheckout")).click();
		Thread.sleep(3000);

		// Enter email
		System.out.println("Enter email Id");
		driver.findElement(By.id("ap_email")).sendKeys("test@gmail.com");
		Thread.sleep(3000);

		System.out.println("Test completed successfully");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before method execution start");
	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeClass
	public void beforeClass() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);
	}

	@AfterClass
	public void afterClass() throws InterruptedException {

		driver.quit();
		System.out.println("Browser closed");
	    Thread.sleep(3000);
	}

}
