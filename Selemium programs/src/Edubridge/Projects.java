package Edubridge;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Projects {
	ChromeDriver driver;

	@BeforeSuite
	public void start() {
		System.out.println("Program starts here...");
	}
	@BeforeMethod
	public void before() {
		driver =new ChromeDriver();
		driver.get("https://www.dermstore.com/");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
	}

	SoftAssert soft = new SoftAssert();
//Getting data from DataUtils class using data provider
	@Test(dataProvider = "getData",dataProviderClass = DataUtils.class)
		public void pro(String data[]) throws InterruptedException, IOException  {
		   System.err.println("Email:"+data[0]);
		   System.err.println("Password:"+data[1]);
			
//clicking signin button
		WebElement signInClick = driver.findElement(By.className("responsiveAccountHeader_openAccountPanelText")); 
		signInClick.click();
		//Soft Assert
		String titles = driver.getTitle();
		soft.assertEquals(titles, "Login");
		soft.assertAll();
		System.out.println(driver.getTitle());
//signup 
			 WebElement signupMail = driver.findElement(By.xpath("/html/body/div[1]/div[5]/main/div/div[1]/section/div/div[1]/div/form/div[2]/div/div/div[1]/input"));
			 signupMail.sendKeys(data[0]);
				  
//sinin password 
			  WebElement signupPass = driver.findElement(By.xpath("/html/body/div[1]/div[5]/main/div/div[1]/section/div/div[1]/div/form/div[3]/div/div/div[1]/input"));
			  signupPass.sendKeys(data[1]);
			  Thread.sleep(2000);
				  
//clicking signin button
			 WebElement signBtn = driver.findElement(By.xpath("/html/body/div[1]/div[5]/main/div/div[1]/section/div/div[1]/div/form/div[5]/div/button"));
		     signBtn.click(); 
			 driver.manage().deleteAllCookies();
			 
	       

//Taking Screensshot of whole page
				File src = driver.getScreenshotAs(OutputType.FILE);
				File des = new File("./Snaps/img.png");
				FileHandler.copy(src, des);
				Thread.sleep(2000);
	        

 //Searching the product
			 WebElement search = driver.findElement(By.xpath("//*[@id=\"header-search-input\"]"));
			 search.sendKeys("facewash",Keys.ENTER);
			 System.out.println(driver.getTitle());
			 Thread.sleep(2000);
	
//Taking screenshot of Section
			WebElement section = driver.findElement(By.xpath("/html/body/div[1]/header/div[4]/div[1]"));
			File src1 = section.getScreenshotAs(OutputType.FILE);
			File des1 = new File("./Snaps/img2.png");
		    FileHandler.copy(src1, des1);

//dropdown
		   Select se1 = new Select(driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[2]/div[1]/div/select")));
		   se1.selectByIndex(1);
		   Thread.sleep(2000);
			 
//checkbox
		   WebElement check= driver.findElement(By.xpath("/html/body/div[4]/div[2]/aside/div/div/div[2]/div/div[2]/div[2]/fieldset/label[3]/input"));
		   boolean isSelected = check.isSelected();
		   System.out.println(isSelected);
		    if(isSelected == false) {
			check.click();
			}
		    Thread.sleep(2000);
//product clicking
			WebElement element = driver.findElement(By.xpath("//*[@id=\"productBlock_productName-11523630\"]"));
			element.click();
            System.out.println(driver.getTitle());
			Thread.sleep(4000);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,500)");
			Thread.sleep(2000);
			driver.manage().deleteAllCookies();
			Thread.sleep(2000);
					 
//Taking screenshot of add to cart button
			WebElement btn = driver.findElement(By.xpath("/html/body/main/div[4]/div[2]/div/div[5]/div[2]/div[2]/span/span/button"));
			File src2 = btn.getScreenshotAs(OutputType.FILE);
			File des2 = new File("./Snaps/img3.png");
			FileHandler.copy(src2, des2);
			Thread.sleep(2000);
					 
//add to cart
			WebElement addToCartBtn = driver.findElement(By.xpath("/html/body/main/div[4]/div[2]/div/div[5]/div[2]/div[2]/span/span/button"));
			addToCartBtn.click();
		    Thread.sleep(2000);
					 
//clicking view cart
			WebElement viewCart = driver.findElement(By.xpath("/html/body/main/div[1]/div/div[5]/div[2]/div[3]/div[1]/a"));
			viewCart.click();
			Thread.sleep(3000);
			System.out.println(driver.getTitle());
	
//checkout
			WebElement checkout = driver.findElement(By.xpath("/html/body/main/div[1]/form/button"));
		    checkout.click();
			Thread.sleep(2000);
			System.out.println(driver.getTitle());
				
//scrolling the payment page till end
		   JavascriptExecutor js1 = (JavascriptExecutor)driver;
		    js1.executeScript("window.scroll(0,document.body.scrollHeight)");
			Thread.sleep(2000);
					 
//navigating back to home page
			driver.navigate().to("https://www.dermstore.com/");
			;
					  
					 
//navigating header 
	 //brand navbar
			WebElement mouseOver1 = driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[2]/div[5]/nav/div[1]/div[2]/ul/li[1]/a"));
			Actions act1 = new Actions(driver);
			act1.moveToElement(mouseOver1).perform();
			Thread.sleep(2000);
					 
       //browser
			WebElement mouseOver2 = driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[2]/div[5]/nav/div[1]/div[2]/ul/li[3]/a"));
			Actions act2 = new Actions(driver);
			act2.moveToElement(mouseOver2).perform();
			Thread.sleep(2000);
					 
		//skincare
			WebElement mouseOver4 = driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[2]/div[5]/nav/div[1]/div[2]/ul/li[5]/a"));
			Actions act4 = new Actions(driver);
			act4.moveToElement(mouseOver4).perform();
			Thread.sleep(2000);
					 
		//haircare
			WebElement mouseOver5 = driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[2]/div[5]/nav/div[1]/div[2]/ul/li[6]/a"));
			Actions act5 = new Actions(driver);
			act5.moveToElement(mouseOver5).perform();
			Thread.sleep(2000);
					 
		 //makeup
			WebElement mouseOver6 = driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[2]/div[5]/nav/div[1]/div[2]/ul/li[7]/a"));
			Actions act6 = new Actions(driver);
			act6.moveToElement(mouseOver6).perform();
			Thread.sleep(2000);
					 
		//tools and devices
			WebElement mouseOver7 = driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[2]/div[5]/nav/div[1]/div[2]/ul/li[8]/a"));
			Actions act7 = new Actions(driver);
			act7.moveToElement(mouseOver7).perform();
			Thread.sleep(2000);
					 
		//bath and body
			WebElement mouseOver8 = driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[2]/div[5]/nav/div[1]/div[2]/ul/li[9]/a"));
		    Actions act8 = new Actions(driver);
			act8.moveToElement(mouseOver8).perform();
			Thread.sleep(2000);
					 
		//fragrance
			WebElement mouseOver9 = driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[2]/div[5]/nav/div[1]/div[2]/ul/li[10]/a"));
			Actions act9 = new Actions(driver);
			act9.moveToElement(mouseOver9).perform();
			 Thread.sleep(2000);
					 
		//gifts
			WebElement mouseOver10 = driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[2]/div[5]/nav/div[1]/div[2]/ul/li[11]/a"));
			Actions act10 = new Actions(driver);
			act10.moveToElement(mouseOver10).perform();
			Thread.sleep(4000);
					 
		//referral
			 WebElement mouseOver11 =driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[2]/div[3]/div/div[1]/a/span")); 
			 Actions acts3 = new Actions(driver);
			 acts3.moveToElement(mouseOver11).perform();
			 Thread.sleep(3000);
										 
			WebElement myReferral =driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[2]/div[3]/div/div[1]/div/nav/ul/li[6]"));
			myReferral.click(); 
			String titlee = driver.getTitle();
			Assert.assertEquals(titlee, "Dermstore Referrals");
			System.out.println(driver.getTitle());
			Thread.sleep(2000);
			driver.navigate().back();
	
		//move overing towards country
			WebElement mouseOver12 =driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[1]/div/div/div/button/span[1]/span")); 
			Actions acts5 = new Actions(driver);
			acts5.moveToElement(mouseOver12).perform();
			Thread.sleep(3000);
									
			WebElement myCountry =driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[1]/div/div/div/button/span[1]/span"));
			myCountry .click();
											
	//selecting country
			//select by selectByVisibleText
			Select se2 = new Select(driver.findElement(By.xpath("//*[@id=\"popup\"]/div/div/div[1]/div[1]/select")));
			se2.selectByVisibleText("Canada");
			Thread.sleep(2000);
												
	//clicking save button
			WebElement saveBtn =driver.findElement(By.cssSelector("#popup > div > div > div.sessionSettings.show > button"));
			saveBtn.click();
			Thread.sleep(3000);
	//Refreshing the page
			driver.navigate().refresh();
			 Thread.sleep(2000);
						 
	//Customer care
		//Scrolling main page till down to view Customer services
			JavascriptExecutor js10 = (JavascriptExecutor)driver;
			js10.executeScript("window.scroll(0,document.body.scrollHeight)");
			Thread.sleep(2000);
	//Clicking help center
			WebElement helpCentre =driver.findElement(By.xpath("/html/body/footer/div[2]/div/div/div[1]/div/ul/li[1]/a"));
		    helpCentre.click();
			
		    //Hard Assert
		  String title = driver.getTitle();
			Assert.assertEquals(title, "Help Center - Dermstore");
			System.out.println(driver.getTitle());
			Thread.sleep(5000);
						
	 //getting back to home page
			 driver.navigate().back();
			Thread.sleep(3000);
			JavascriptExecutor js11 = (JavascriptExecutor)driver;
			js11.executeScript("window.scroll(0,-4900)");
			Thread.sleep(2000);		
}
	
	@AfterMethod
	public void after() {
		driver.quit();
	}
	@AfterSuite
	public void end() {
		System.out.println("Program ends here...");
	}
}