package plexus.test;


import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PromotionForm extends PlexusSharedFunctions {
  @Test
  public void TestPromotionForm() throws InterruptedException {
	  
	  PlexusSharedFunctions.Login();
	  PlexusSharedFunctions.ImplicitWait(30);
	  CheckPromotionForm();
	  CheckPromoterInformation();
	  AdvertisingMethods();
	  EntrantGroups();
	  WhoCanEnter();
	  HowtoEnter();
	  HowtoAddPrize();
	  NotificationandDelivery();
	  PermitsandPrivacy();
	 // Confirmation(); 
	//  PromotionsCompletionConfirmation();
	  
  }
  
  public void CheckPromotionForm()
  {
	 
	  PlexusSharedFunctions.ClickablebyXpath(".//*[@id='root']/div/div[2]/div[2]/div/div/div[1]/div/ul[1]/li[1]/a/span[1]");
	  PlexusSharedFunctions.verifyTextPresent("LET'S GET STARTED");
	  driver.findElement(By.name("title")).sendKeys(PromotionName);
	  PlexusSharedFunctions.ClickablebyXpath(".//*[@id='root']/div/div[2]/div/div/section/form/footer/button[2]");
	 
	 
	  
  }
 
  public void CheckPromoterInformation()
  {
	 
	 
	  PlexusSharedFunctions.verifyTextPresent("PROMOTER INFORMATION");
	  PlexusSharedFunctions.CheckEmpty("companyName","Promoter Pvt Limited");
	  PlexusSharedFunctions.CheckEmpty("streetLine1","Level 1");
	  PlexusSharedFunctions.CheckEmpty("streetLine2","23 Main St");
	  PlexusSharedFunctions.CheckEmpty("suburb","Smithfield");
	  PlexusSharedFunctions.CheckEmpty("postcode","1111");
	  Select oSelect = new Select(driver.findElement(By.name("country")));
      oSelect.selectByVisibleText("Australia");
      Select oSelect1 = new Select(driver.findElement(By.name("state")));
      oSelect1.selectByVisibleText("Victoria");
	  PlexusSharedFunctions.CheckEmpty("phoneNumber","(03) 9908 3784");
	  PlexusSharedFunctions.CheckEmpty("businessNumber","123 456 789 10");
	  PlexusSharedFunctions.ClickablebyXpath(".//*[@id='promoter-form']/footer/button[2]");
	
	
}
 
  public void AdvertisingMethods()
  {
	 
	 
	  PlexusSharedFunctions.verifyTextPresent("ADVERTISING METHODS");
	  PlexusSharedFunctions.ClickablebyXpath(".//*[@id='methods']/div/div[1]/div[1]/div/div[1]/div/div/div/label/div/div[2]");
	  PlexusSharedFunctions.ClickablebyXpath(".//*[@id='methods']/div/div[1]/div[2]/div/div[1]/div/div/div/label/div/div[2]");
	  Select oSelect = new Select(driver.findElement(By.name("socialMedia__site__0")));
      oSelect.selectByVisibleText("Facebook");
	  PlexusSharedFunctions.ClickablebyXpath(".//*[@id='methods']/div/div[1]/div[5]/div/div[1]/div/div/div/label/div/div[2]");
	  driver.findElement(By.name("period__startDate")).sendKeys("01/01/17");
	  PlexusSharedFunctions.ClickablebyXpath(".//*[@id='period']/div/div[1]/span[1]");
	  PlexusSharedFunctions.ImplicitWait(10);
	     
	  	boolean element=driver.findElement(By.xpath("//span[contains(text(),'Start date must be after today')]")).isDisplayed();
	  		
	  		if(element==true)
	  		{
	  			 driver.findElement(By.name("period__startDate")).clear();
	  			driver.findElement(By.name("period__startDate")).sendKeys(start_date);
	  			driver.findElement(By.xpath("//span[contains(text(),'When will you advertise your promotion?')]")).click();
	  		}
	  		else
	  		{
	  			System.out.println("The element is not visible");
	  		}
	  		
	 
	  driver.findElement(By.name("period__endDate")).clear();
	  driver.findElement(By.name("period__endDate")).sendKeys("01/04/18");
	 PlexusSharedFunctions.ClickablebyXpath(".//*[@id='extra-services']/div/div[1]/div[3]/div/div[1]/div/div/div/label/div/div[2]");
	 PlexusSharedFunctions.ClickablebyXpath(".//*[@id='root']/div/div[2]/div[2]/div/div[1]/div/div/section/form/footer/button");
	
  
  }
  
  public void EntrantGroups()
  {
	 
	  
	  PlexusSharedFunctions.verifyTextPresent("ENTRANT GROUPS");
	  PlexusSharedFunctions.ClickablebyXpath(".//*[@id='entrant-group-form']/main/div/div[1]/div[1]/div/div/div/div/label/div/div[2]");
	  driver.findElement(By.linkText("AU 18+"));
	  driver.findElement(By.xpath(".//*[@id='entrant-group-form']/main/span/div[1]/div[1]/div[1]/div/div/div/div/label/div/div[2]")).click();
	  driver.findElement(By.xpath(".//*[@id='entrant-group-form']/main/span/div[2]/div[1]/div[1]/div/div/div/div/label/div/div[2]")).click();
	  PlexusSharedFunctions.ClickablebyXpath(".//*[@id='entrant-group-form']/main/span/section/div/div[1]/div[1]/div/div/div/div/div/label/div/div[2]");
	  PlexusSharedFunctions.ClickablebyXpath(".//*[@id='entrant-group-form']/footer/button[2]");
	 
  
  }
  
  public void WhoCanEnter()
  {
	 PlexusSharedFunctions.verifyTextPresent("HOW TO ENTER");
	 PlexusSharedFunctions.ClickablebyXpath(".//*[@id='entry-method-form']/main/div[4]/div[1]/div[1]/div/div/div/div/label/div/div[2]");
	 driver.findElement(By.name("entryLimits__number__0")).sendKeys("1");
	 Select oSelect = new Select(driver.findElement(By.name("entryLimits__type__0")));
     oSelect.selectByVisibleText("per day");
	 PlexusSharedFunctions.ClickablebyXpath(".//*[@id='entry-method-form']/footer/button");
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 driver.findElement(By.linkText("Last")).click();
	  
  
  }
  
  public void HowtoEnter() throws InterruptedException
  {
	 
	  PlexusSharedFunctions.verifyTextPresent("HOW TO ENTER");
	  PlexusSharedFunctions.ClickablebyXpath(".//*[@id='entry-step-form']/main/div[2]/div[1]/div[1]/div/div/div/label/div[2]/span");
	  PlexusSharedFunctions.ClickablebyXpath(".//*[@id='entry-step-form']/main/section/div[1]/div[1]/div[1]/div/div/div/div/label/div[1]/div[2]");
	  Select oSelect = new Select(driver.findElement(By.name("purchaseRequirement")));
      oSelect.selectByVisibleText("Buy a certain number of these products or services");
	  driver.findElement(By.name("products__name__0")).sendKeys("Chocolate");
	  Select oSelect1 = new Select(driver.findElement(By.name("purchaseTransactionType")));
      oSelect1.selectByVisibleText("One transaction");
	  Select oSelect2 = new Select(driver.findElement(By.name("purchaseLocations")));
      oSelect2.selectByVisibleText("Any stores displaying promotional material");
      Select oSelect3 = new Select(driver.findElement(By.name("purchaseAlcohol")));
      oSelect3.selectByVisibleText("No, it does not involve the purchase of alcohol");
      PlexusSharedFunctions.ClickablebyXpath(".//*[@id='entry-step-form']/footer/button[1]");
      PlexusSharedFunctions.ClickablebyXpath(".//*[@id='entry-step-form']/main/div[2]/div[1]/div[3]/div/div/div/label/div[2]/span");
      Select oSelect4 = new Select(driver.findElement(By.name("goPath")));
      oSelect4.selectByVisibleText("At a specific URL");
      driver.findElement(By.name("goUrl")).sendKeys("www.kitkat.au.com/promotion");
      PlexusSharedFunctions.ClickablebyXpath(".//*[@id='entry-step-form']/main/section/div[3]/div[1]/div[2]/div/div/div/div/label/div/div[2]");
      PlexusSharedFunctions.ClickablebyXpath(".//*[@id='entry-step-form']/main/section/div[4]/div[1]/div[1]/div/div/div/div/div/label/div/div[2]");
      PlexusSharedFunctions.ClickablebyXpath(".//*[@id='entry-step-form']/main/section/div[4]/div[1]/div[1]/div/div[2]/div[1]/div[2]/div/div/div/label/div/div[2]");
      PlexusSharedFunctions.ClickablebyXpath(".//*[@id='entry-step-form']/main/section/div[4]/div[1]/div[1]/div/div[2]/div[1]/div[3]/div/div/div/label/div/div[2]");
      PlexusSharedFunctions.ClickablebyXpath(".//*[@id='entry-step-form']/main/section/div[4]/div[1]/div[1]/div/div[2]/div[1]/div[5]/div/div/div/label/div/div[2]");
      PlexusSharedFunctions.ClickablebyXpath(".//*[@id='entry-step-form']/main/section/div[4]/div[1]/div[1]/div/div[2]/div[1]/div[6]/div/div/div/label/div/div[2]");
      PlexusSharedFunctions.ClickablebyXpath(".//*[@id='entry-step-form']/footer/button[1]");
      PlexusSharedFunctions.ClickablebyXpath(".//*[@id='entry-step-form']/main/div[3]/div[1]/div[2]/div/div/div/label/div[2]/span");
      Select oSelect5 = new Select(driver.findElement(By.name("platform")));
      oSelect5.selectByVisibleText("Facebook");
      driver.findElement(By.name("socialUrl")).clear();
      driver.findElement(By.name("socialUrl")).sendKeys("www.facebook.com/kitkatpromotion");
      PlexusSharedFunctions.ClickablebyXpath(".//*[@id='entry-step-form']/main/section/div[4]/div[1]/div[2]/div/div/div/div/label/div/div[2]");
      PlexusSharedFunctions.ClickablebyXpath(".//*[@id='entry-step-form']/main/section/div[5]/div[1]/div[1]/div/div[1]/div/div/div/label/div/div[2]");
      PlexusSharedFunctions.ClickablebyXpath(".//*[@id='entry-step-form']/footer/button[2]");
      PlexusSharedFunctions.verifyTextPresent("Purchase Product");
      PlexusSharedFunctions.verifyTextPresent("Chocolate");
      PlexusSharedFunctions.verifyTextPresent("Go Online");
      PlexusSharedFunctions.verifyTextPresent("Complete the online entry form");
      PlexusSharedFunctions.verifyTextPresent("Connect on Social Media");
      PlexusSharedFunctions.verifyTextPresent("on Facebook");
     
      PlexusSharedFunctions.ClickablebyXpath("//span[contains(text(),'Next step')]");
      driver.findElement(By.linkText("Skip")).click();
      PlexusSharedFunctions.verifyTextPresent("Add Winning Method");
    
      PlexusSharedFunctions.ClickablebyXpath(".//*[@id='winning-method-form']/main/div[3]/div[1]/div[1]/div/div/div/label/div[2]/span");
      
      PlexusSharedFunctions.ClickablebyXpath(".//*[@id='winning-method-form']/main/div[8]/div[1]/div[1]/div[1]/div/div/div/div/label/div/div[2]");
      driver.findElement(By.name("drawDate")).clear();
      driver.findElement(By.name("drawDate")).sendKeys("05/01/18");
      PlexusSharedFunctions.ClickablebyXpath(".//*[@id='draw-date']");
      PlexusSharedFunctions.ImplicitWait(10);
     
  	boolean element=driver.findElement(By.xpath("//span[contains(text(),'The draw date has to be on or after the earliest entry date ("+start_date+" 09:00 am).')]")).isDisplayed();
  		
  		if(element==true)
  		{
  			 driver.findElement(By.name("drawDate")).clear();
  			driver.findElement(By.name("drawDate")).sendKeys("14/04/18");
  			 PlexusSharedFunctions.ClickablebyXpath(".//*[@id='draw-date']");
  			
  		}
  		else
  		{
  			System.out.println("The element is not visible");
  		}
  		PlexusSharedFunctions.ClickablebyXpath(".//*[@id='winning-method-form']/footer/button");
  		PlexusSharedFunctions.ClickablebyXpath(".//*[@id='winning-method-1']/div/div[2]/button");
  	
        driver.findElement(By.linkText("Skip")).click();
  		
  	
		 
		System.out.println("Works upto this part");
     
      
  }
  
  public void HowtoAddPrize() throws InterruptedException
  {
	 
	  PlexusSharedFunctions.verifyTextPresent("Add Prize");
	  PlexusSharedFunctions.ClickablebyXpath(".//*[@id='prize-item-form']/main/div[15]/div[1]/div[1]/div/div/div/label/div[2]/span");
	  driver.findElement(By.xpath(".//*[@id='prize-item-form']/main/div[16]/span[1]/div/div/span[1]/input")).sendKeys("20");
	  driver.findElement(By.xpath(".//*[@id='prize-item-form']/main/div[16]/span[2]/div/div/span[1]/div/input")).sendKeys("50");
	  PlexusSharedFunctions.ClickablebyXpath(".//*[@id='prize-item-form']/main/div[16]/div/div[1]/div[1]/div/div/div/div/label/div/div[2]");
	  driver.findElement(By.xpath(".//*[@id='prize-item-form']/main/div[16]/fieldset/section/div[1]/div/span[1]/textarea")).sendKeys("Chocolate Bars");
	  System.out.println("Works upto this part");
	  PlexusSharedFunctions.ClickablebyXpath(".//*[@id='prize-item-form']/main/div[16]/fieldset/section/div[2]/div[1]/div[3]/div/div[1]/div/div/div/label/div[1]/div[2]");
	  PlexusSharedFunctions.ClickablebyXpath(".//*[@id='add-another-prize']");
	  driver.findElement(By.xpath(".//*[@id='prize-item-form']/main/div[15]/div[1]/div[3]/div/div/div/label/div[2]/span")).click();
	  driver.findElement(By.xpath(".//*[@id='prize-item-form']/main/div[17]/span[1]/div/div/span[1]/input")).sendKeys("15");
	  driver.findElement(By.xpath(".//*[@id='prize-item-form']/main/div[17]/span[2]/div/div/span[1]/div/input")).sendKeys("100");
	  PlexusSharedFunctions.ClickablebyXpath(".//*[@id='prize-item-form']/main/div[17]/div/div[1]/div[1]/div/div/div/div/label/div/div[2]");
	  Select oSelect5 = new Select(driver.findElement(By.name("paymentMethod")));
	  oSelect5.selectByVisibleText("Direct deposit to winner's bank account");
	  PlexusSharedFunctions.ClickablebyXpath(".//*[@id='add-another-prize']");
	  PlexusSharedFunctions.ClickablebyXpath(".//*[@id='prize-item-form']/main/div[15]/div[1]/div[4]/div/div/div/label/div[2]/span");
	  driver.findElement(By.xpath(".//*[@id='prize-item-form']/main/div[16]/span[1]/div/div/span[1]/input")).sendKeys("16");
	  driver.findElement(By.xpath(".//*[@id='prize-item-form']/main/div[16]/span[2]/div/div/span[1]/div/input")).sendKeys("200");
	  PlexusSharedFunctions.ClickablebyXpath(".//*[@id='prize-item-form']/main/div[16]/div/div[1]/div[1]/div/div/div/div/label/div/div[2]");
	  driver.findElement(By.xpath(".//*[@id='prize-item-form']/main/div[16]/fieldset/section/div[1]/div/span[1]/input")).sendKeys("2");
	  driver.findElement(By.xpath(".//*[@id='prize-item-form']/main/div[16]/fieldset/section/div[2]/div/span[1]/input")).sendKeys("0");
	  driver.findElement(By.xpath(".//*[@id='prize-item-form']/main/div[16]/fieldset/section/div[3]/div/span[1]/input")).sendKeys("Kitkat Premiere");
	  driver.findElement(By.xpath(".//*[@id='prize-item-form']/main/div[16]/fieldset/section/div[4]/div/span[1]/input")).sendKeys("Kitkat Stones in Melbourne, VIC");
	  driver.findElement(By.name("tickConditions")).sendKeys("No Comment");
	  PlexusSharedFunctions.ClickablebyXpath(".//*[@id='prize-item-form']/main/div[16]/fieldset/section/div[5]/div[2]/div[1]/div/div[1]/div[2]/div/div/div/div/label/div/div[2]");
      driver.findElement(By.name("tickTimePeriod__startEvent")).sendKeys("14/04/18");
	  PlexusSharedFunctions.ClickablebyXpath(".//*[@id='prize-item-form']/main/div[16]/fieldset/section/div[5]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div/label/div/div[2]");
	  PlexusSharedFunctions.ClickablebyXpath(".//*[@id='prize-item-form']/footer/button[2]");
	  PlexusSharedFunctions.verifyTextPresent("Chocolate Bars");
	  PlexusSharedFunctions.verifyTextPresent("$100 direct deposit");
	  PlexusSharedFunctions.verifyTextPresent("2 adult tickets to Kitkat Premiere at Kitkat Stones in Melbourne");
	  PlexusSharedFunctions.ClickablebyXpath("//span[contains(text(),'Next step')]");
  
  }
  
  public void NotificationandDelivery() 
  {
	 PlexusSharedFunctions.verifyTextPresent("Notification and Delivery");
	 PlexusSharedFunctions.ClickablebyXpath(".//*[@id='root']/div/div[2]/div[2]/div/div[1]/div/div/section/form/main/div/div[1]/div[1]/div/div/div/div/label/div/div[2]");
	 PlexusSharedFunctions.ClickablebyXpath(".//*[@id='notifications']/div/div[1]/div[1]/div/div[1]/div/div/div/label/div/div[2]");
	 PlexusSharedFunctions.ClickablebyXpath(".//*[@id='notifications']/div/div[1]/div[2]/div/div[1]/div/div/div/label/div/div[2]");
	 PlexusSharedFunctions.ClickablebyXpath(".//*[@id='notifications']/div/div[1]/div[3]/div/div[1]/div/div/div/label/div/div[2]");
	 PlexusSharedFunctions.ClickablebyXpath(".//*[@id='publications']/div/div[1]/div[1]/div/div[1]/div/div/div/label/div/div[2]");
	 PlexusSharedFunctions.ClickablebyXpath(".//*[@id='publications']/div/div[1]/div[2]/div/div[1]/div/div/div/label/div/div[2]");
	  driver.findElement(By.name("pubUrl")).clear();
	  driver.findElement(By.name("pubUrl")).sendKeys("www.kitkat.au.com/prootion");
	  driver.findElement(By.name("daysTilPublication")).clear();
	  driver.findElement(By.name("daysTilPublication")).sendKeys("7");
	  driver.findElement(By.xpath(".//*[@id='publications']/span/div[2]/div[1]/div[2]/div/div/div/div/label/div/div[2]")).click();
	  driver.findElement(By.xpath(".//*[@id='delivery-methods']/div[1]/div[1]/div[1]/div/div/div/div/label/div/div[2]")).click();
      Select oSelect = new Select(driver.findElement(By.name("deliveryMethods__type__0")));
      oSelect.selectByVisibleText("Delivered by mail");
      driver.findElement(By.xpath(".//*[@id='delivery-methods']/div[2]/div[1]/div/div/div[3]/div[1]/div[1]/div/span[1]/select")).click();
      PlexusSharedFunctions.ClickablebyXpath(".//*[@id='delivery-methods']/div[2]/div[1]/div/div/div[3]/div[1]/div[2]/div/div/div[4]/div/div/div/div/div/label/div/div[2]");
      Select oSelect2 = new Select(driver.findElement(By.name("deliveryMethods__dateType__0")));
      oSelect2.selectByVisibleText("No");
      PlexusSharedFunctions.ClickablebyXpath(".//*[@id='delivery-methods']/div[2]/div[3]/button");
      Select oSelect1 = new Select(driver.findElement(By.name("deliveryMethods__type__1")));
      oSelect1.selectByVisibleText("Delivered in-person");
      driver.findElement(By.xpath(".//*[@id='delivery-methods']/div[2]/div[1]/div[2]/div/div[3]/div[1]/div[1]/div/span[1]/select")).click();
      PlexusSharedFunctions.ClickablebyXpath(".//*[@id='delivery-methods']/div[2]/div[1]/div[2]/div/div[3]/div[1]/div[2]/div/div/div[3]/div/div/div/div/div/label/div/div[2]");
      Select oSelect3 = new Select(driver.findElement(By.name("deliveryMethods__dateType__1")));
      oSelect3.selectByVisibleText("Yes, specific date (please specify)");
      driver.findElement(By.name("deliveryMethods__dateSpecific__1")).sendKeys("22/04/18");
      PlexusSharedFunctions.ClickablebyXpath(".//*[@id='root']/div/div[2]/div[2]/div/div[1]/div/div/section/form/footer/button");
      PlexusSharedFunctions.verifyTextPresent("Publication of Results");
      PlexusSharedFunctions.verifyTextPresent("Draw Date");
      PlexusSharedFunctions.verifyTextPresent("14/04/18");
      PlexusSharedFunctions.verifyTextPresent("Publication Date");
      PlexusSharedFunctions.verifyTextPresent("21/04/18");
    
      PlexusSharedFunctions.ClickablebyXpath("//span[contains(text(),'Next step')]");
      
      
      
      
	  
}
  
  public void PermitsandPrivacy() 
  {
	 PlexusSharedFunctions.verifyTextPresent("Permits and Privacy");
	 
	  Select oSelect = new Select(driver.findElement(By.name("nswBlanketPermit__type")));
      oSelect.selectByVisibleText("No, thank you");
      Select oSelect2 = new Select(driver.findElement(By.name("actBlanketPermit__type")));
      oSelect2.selectByVisibleText("No, thank you");
      driver.findElement(By.name("saDateRequired")).sendKeys("04/06/18");
      PlexusSharedFunctions.ClickablebyXpath("//span[text()='We note that you wish to start advertising your promotion on "+start_date+". When do you need to receive the permit licence numbers in order to go to print?']");
      driver.findElement(By.xpath(".//*[@id='permits']/span/span[1]/div[2]/div[1]/div[2]/div/div/div/div/label/span[1]")).click();
      PlexusSharedFunctions.ClickablebyXpath(".//*[@id='permits']/span/span[3]/div[1]/div[1]/div[1]/div/div/div/div/label/div/div[2]");
      Select oSelect1 = new Select(driver.findElement(By.name("contactPerson__title")));
      oSelect1.selectByVisibleText("Ms");
      driver.findElement(By.name("contactPerson__firstName")).clear();
	  driver.findElement(By.name("contactPerson__firstName")).sendKeys("Tasnuva");
	  driver.findElement(By.name("contactPerson__lastName")).clear();
	  driver.findElement(By.name("contactPerson__lastName")).sendKeys("Disha");
	  driver.findElement(By.name("contactPerson__email")).clear();
	  driver.findElement(By.name("contactPerson__email")).sendKeys("tasnuvadisha@gmail.com");
	  driver.findElement(By.name("contactPerson__phone")).clear();
	  driver.findElement(By.name("contactPerson__phone")).sendKeys("0491 570 156");
	  PlexusSharedFunctions.ClickablebyXpath(".//*[@id='permits']/span/div[3]/div[1]/div[3]/div/div[1]/div/div/div/label/div/div[2]");
	  driver.findElement(By.xpath(".//*[@id='permits']/span/div[4]/div[1]/div[2]/div/div/div/div/label/span[1]")).click();
	  driver.findElement(By.xpath(".//*[@id='privacy-declarations']/div[3]/div[1]/div[2]/div/div/div/div/label/span[1]")).click();
	  driver.findElement(By.xpath(".//*[@id='privacy-declarations']/span/div/div[1]/div[2]/div/div/div/div/label/span[1]")).click();
	  driver.findElement(By.xpath(".//*[@id='privacy-declarations']/div[4]/div[1]/div[2]/div/div/div/div/label/span[1]")).click();
	  PlexusSharedFunctions.ClickablebyXpath(".//*[@id='root']/div/div[2]/div[2]/div/div[1]/div/div/section/form/footer/button[1]");
	  PlexusSharedFunctions.ClickablebyXpath("//span[contains(text(),'Next step')]");
	  PlexusSharedFunctions.ClickablebyXpath(".//*[@id='root']/div/div[2]/div[2]/div/div/div/div[3]/div[6]/button");
	  PlexusSharedFunctions.ClickablebyXpath("html/body/div[2]/div/div[2]/div/div/span/div[2]/button[1]");
      System.out.println("The Promotion has been created sucessfully");
      
	  
}
  
  public static void Confirmation()
  {
	  
	 
	  PlexusSharedFunctions.ImplicitWait(30);
	  /*WebElement element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div/div/div[2]/div/form/div[1]/table/tbody/tr[1]/td[10]/div/div/div[1]/div/div/div/div/label/div/div[2]"));
      Actions actions = new Actions(driver);
      actions.moveToElement(element).click().perform();
      WebElement element1 = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div/div/div[2]/div/form/div[3]/table/tbody/tr/td[5]/div/div/div[1]/div/div/div/div/label/div/div[2]"));
      Actions actions1 = new Actions(driver);
      actions1.moveToElement(element1).click().perform();*/
      
	  
	  /* For Demo */
	  /* driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div/div/div[2]/div/form/div[1]/table/tbody/tr[1]/td[10]/div/div/div[1]/div/div/div/div/label/div/div[2]")).click();
	     driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div/div/div[2]/div/form/div[3]/table/tbody/tr/td[5]/div/div/div[1]/div/div/div/div/label/div/div[2]")).click();
	     PlexusSharedFunctions.ClickablebyXpath("html/body/div[2]/div/div[2]/div/div/div[2]/div/form/div[6]/button");*/
	  
	  
	  /*For Dev*/
	 driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div/div/div[2]/div/form/div[1]/table/tbody/tr[1]/td[10]/div/div/div[1]/div/div/div/div/label/div/div[2]")).click();
	   driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div/div/div[2]/div/form/div[3]/table/tbody/tr/td[5]/div/div/div[1]/div/div/div/div/label/div/div[2]")).click();
	   PlexusSharedFunctions.ClickablebyXpath("html/body/div[2]/div/div[2]/div/div/div[2]/div/form/div[6]/button");
	  
	  
	  /* For External*/
	  /*  driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div/div/div[2]/div/form/div[1]/table/tbody/tr[1]/td[10]/div/div/div[1]/div/div/div/div/label/div/div[2]")).click();
	    driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div/div/div[2]/div/form/div[3]/table/tbody/tr/td[5]/div/div/div[1]/div/div/div/div/label/div/div[2]")).click();
	    PlexusSharedFunctions.ClickablebyXpath("html/body/div[2]/div/div[2]/div/div/div[2]/div/form/div[6]/button");*/
	 
	
	
	  driver.findElement(By.linkText("Promotions Wizard")).click();
    
	
	  
	 
  }
  public static boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
 
  public static void PromotionsCompletionConfirmation()
  {
	Assert.assertEquals(driver.findElement(By.linkText(PromotionName)).getText(),PromotionName);
		 Assert.assertTrue(isElementPresent(By.linkText(PromotionName)));
	     System.out.println(PromotionName +" is visible");
		 System.out.println("Promotion Creation is done Sucessfully");
	  
  }

  
  
  
  
  
  
 
  
}
