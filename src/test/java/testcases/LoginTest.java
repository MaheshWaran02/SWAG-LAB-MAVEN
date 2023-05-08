package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import page.Loginpage;

public class LoginTest extends Base {
	
	@Test
	public void test1() throws FilloException {
		
		Recordset recordset = connection.executeQuery("Select * from data where TestName='test1'");
		recordset.next();
		
		String UserName = recordset.getField("UserName");
		String Password = recordset.getField("Password");
		
		Loginpage login = new Loginpage(driver);
		login.Logintest(UserName, Password);
		 System.out.println("the use name " + UserName + " and password is "  + Password);
	}

	
	@Test
	public void test2() throws FilloException {
		Recordset recordset = connection.executeQuery("Select * from data where TestName='test2'");
		recordset.next();
		
		String  UserName2 = recordset.getField("UserName");
		String  password2 = recordset.getField("Password");
		
		Loginpage login = new Loginpage(driver);
		login.Logintest(UserName2, password2);
		
		Loginpage loginclick = new Loginpage(driver);
		
		loginclick.loginclick();
		
		
        WebElement error = driver.findElement(By.xpath("//h3[@data-test='error']"));
      
		
		String ActError = error.getText();
		String ExpError = "Epic sadface: Sorry, this user has been locked out.";
		
		Assert.assertEquals(ActError, ExpError);
		
		
 System.out.println("the use name " + UserName2 + " and password is "  + password2);

		
	}
}
