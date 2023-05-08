package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	public static WebDriver driver;
	
	@FindBy (id="user-name")
	WebElement UserName;
	@FindBy (id="password")
	WebElement password;
	@FindBy (id="login-button")
	WebElement loginbutton;
	
	
	
	public Loginpage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Logintest (String Name, String passval) {
		UserName.sendKeys(Name);
		password.sendKeys(passval);
		
		}
	public void loginclick () {
		
		loginbutton.click();
	}

}
