package test;

import java.awt.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import page.TechFiosPage;
import util.BrowserFactory;

public class TechFiosTest {
	
	WebDriver driver;
	
	@Test
	public void userShouldBeAbleGoToTechios() throws InterruptedException {
		
		driver = BrowserFactory.startBrowser();
		driver.get("http://techfios.com/test/102/");
		
		TechFiosPage techfiosPage = PageFactory.initElements(driver, TechFiosPage.class);
		//variable to check if the check box is selected or not			
		boolean outcome = techfiosPage.isToggleAllCheckboxSelected();
		
		
		if(outcome == false ) {
			techfiosPage.checkToggleAllCheckBox();
			Assert.assertTrue("CheckBox is not selected!!", techfiosPage.isToggleAllCheckboxSelected());
		}
		else {
			//unselect it
			techfiosPage.checkToggleAllCheckBox();
			//then select it
			techfiosPage.checkToggleAllCheckBox();
			Assert.assertTrue("CheckBox is not selected!!", techfiosPage.isToggleAllCheckboxSelected());
		}
		

	
		//validating if all the elements in the list are checked when the toggle all button is selected
		
		Assert.assertTrue("All the items in the list are not selected ", techfiosPage.checkAllCheckBoxSelected());
		
		//test 2
		//unchecking toggle all 
		techfiosPage.checkToggleAllCheckBox();
		
		//method to check if an Element is selected
		//techfiosPage.isAnElementSelectedToRemove();
		//Validating the selection using assert
		Assert.assertTrue("Element is not selected!!",techfiosPage.isAnElementSelectedToRemove() );
		
		//Method to remove element from list
		techfiosPage.removeElementFromList();
		
		//test 3
		//select ToggleAll to remove the list
		techfiosPage.checkToggleAllCheckBox();
		
		//remove the list
		techfiosPage.removeElementFromList();
		
		Assert.assertTrue("Warning Message is not displayed!!", techfiosPage.isWarningMessageElementDisplayed());
		
	}

}
