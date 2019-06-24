package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class aviancaPage {
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='my-account-tooltip']/a[@role='link']/span[.='MyAvianca']")
	WebElement botonMyAvianca;

	
	@FindBy(xpath="//a[@role='button' and .='Regístrate']")
	WebElement botonRegistrate;

	public aviancaPage(WebDriver driver){		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickBotonMyAvanca(){
		System.out.println("click myavianca");
		botonMyAvianca.click();		
	}
	
	public void clickBotonRegistrate(int retrasoEnSegundos) throws InterruptedException {
		Thread.sleep(retrasoEnSegundos*1000);
		System.out.println("click registrate");
		botonRegistrate.click();
	}
}
