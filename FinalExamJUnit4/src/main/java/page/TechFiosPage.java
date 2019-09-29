/*Test 1: Validate when the toggle all check box is CHECKED,
	all check boxes for list items are also CHECKED ON.*/
/*Test 2: Validate that a single list item could be removed 
 * using the remove button when a single checkbox is selected.
 */
/*Test 3: Validate that all list item could be removed using the 
 * remove button and when "Toggle All" functionality is on.
 */

package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

public class TechFiosPage extends BasePage {
	WebDriver driver;
	
	public TechFiosPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Element library
	@FindBy(how = How.NAME, using = "allbox")WebElement ToggleAllCheckBox;
	//XPath for the list of elements that are checked when the toggle all check box is checked
	@FindBys(@FindBy(how = How.XPATH,using = "//input[@type='checkbox']"))List<WebElement> ToggleList;
	@FindBy(how = How.XPATH, using = "//input[@value='Remove']")WebElement RemoveButton;
	//warning Message
	@FindBy(how = How.XPATH, using = "//b[contains(text(),'Warning')]")WebElement WarningMessage;
	
	//Methods for test 1
	//Method to check or click the  toggle all check box
    public void checkToggleAllCheckBox() {
    	
    	ToggleAllCheckBox.click();
    	
    }
    
    //Method to check the toggle all box is selected
    public boolean isToggleAllCheckboxSelected() {
    	
    	return ToggleAllCheckBox.isSelected();
    	
    }
    
    //Method to check if all the check boxes in the list are selected
    public boolean checkAllCheckBoxSelected() {
    	int uncheckedCount = 0;
    	for(int i = 0; i<ToggleList.size();i++) {
    		if(ToggleList.get(i).isSelected() == false) {
    		    uncheckedCount++;
    			
    		}
    		
    	}
    	
    	if(uncheckedCount > 0) {
    		return false;
    	} else {
    		return true;
    	}
    	
    }
    
    //Methods for test 2
    public boolean isAnElementSelectedToRemove() {
    	boolean outcomeChecked = false;
    	for(int i = 0; i<ToggleList.size();i++) {
    		if(i==5) {
    		  ToggleList.get(i).click();
    		  outcomeChecked = ToggleList.get(i).isSelected();
       	      System.out.println("Is Element selected : " + outcomeChecked);
      		  break; 
    		}
    		
    	}
    	
    	return outcomeChecked;	
    }
    
    //method to remove element from list
    public void removeElementFromList() {
		RemoveButton.click();
	}   
    
//Test 3
    public boolean isWarningMessageElementDisplayed() {
    	
    	return WarningMessage.isDisplayed();
    }
    
    
}
