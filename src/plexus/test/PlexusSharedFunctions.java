package plexus.test;


import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class PlexusSharedFunctions {
	public static WebDriver driver=null;
    public static String PromotionName="Nachos Promotion";
	public static String start_date = "01/02/18";
	public static String ActualText= null;
	@BeforeClass(alwaysRun=true)
	public static void LaunchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "..//Plexus//Externals//driver//chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "D://ECLIPSE//eclipse workplace//geckodriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver( options );
		//driver= new FirefoxDriver();
		driver.get("https://external.plexuspromotions.com.au");
	
	    
	}

	@SuppressWarnings("deprecation")
	public static void Login()
	{
		driver.findElement(By.name("username")).sendKeys("tasnuvatehrin@gmail.com");
		driver.findElement(By.name("password")).sendKeys("123456@");
		driver.findElement(By.xpath(".//*[@id='root']/div/div[2]/div[2]/form/footer/button")).click();
		ImplicitWait(30);
		PlexusSharedFunctions.ClickablebyXpath(".//*[@id='root']/div/div[1]/div/div[2]/a");
		ImplicitWait(60);
		verifyTextPresent("Promotions Wizard");
		
		System.out.println("Logged in successfully");
		
	}

	public static void ImplicitWait(int sec)
	{
		 driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		
	}



	
	



	public static void ClickablebyXpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
		
	}
	
	public static void verifyTextPresent(String value)
	{
		 WebElement element = driver.findElement(By.cssSelector("body"));
		    boolean feedBack = driver.findElement(By.cssSelector("body")).getText().contains(value);
		    boolean feedbackVisible = element.isDisplayed();
		    if(feedBack==true){
		        System.out.println(value+ " is present");
		        if(feedbackVisible==true){
		            System.out.println(value+ " is visible");
		        }
		        else{
		            System.out.println(value+ " is not visible");
		        }

		    }
		    else{
		        System.out.println(value+ " is not present");

		    } 
	}
	
	public static boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	public static void CheckEmpty(String attributename, String texts) {
		WebElement inputBox = driver.findElement(By.name(attributename));
		String textInsideInputBox = inputBox.getAttribute("value");

		// Check whether input field is blank
		if(textInsideInputBox.isEmpty())
		{
		   System.out.println("Input field is empty");
		   inputBox.sendKeys(texts);
		}
		
	}

	/*@AfterClass(alwaysRun=true)
	public void tearDown(){
		driver.close();
		
	}*/

	
}


