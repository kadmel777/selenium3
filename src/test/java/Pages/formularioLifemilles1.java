package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class formularioLifemilles1 {
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='my-account-tooltip']/a[@role='link']/span[.='MyAvianca']")
	WebElement botonMyAvianca;
	
	public formularioLifemilles1(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
