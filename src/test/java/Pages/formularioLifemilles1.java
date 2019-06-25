package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class formularioLifemilles1 {
	WebDriver driver;
	
	@FindBy(xpath="//button[.='Aceptar']")
	WebElement botonAceptar;
		
	@FindBy(xpath="//input[@id='email']")
	WebElement inputEmail;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement inputPassword; 
	
	@FindBy(xpath="//input[@id='confirmPassword']")
	WebElement inputConfirmPassword;
	
	@FindBy(xpath="//button[.='Siguiente']")
	WebElement botonSiguiente;
	
	public formularioLifemilles1(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickBotonAceptar(int retrasoEnSegundos) throws InterruptedException {
		Thread.sleep(retrasoEnSegundos*1000);
		botonAceptar.click();
	}
	
	public void clickInputEmail(String email) {
		inputEmail.click();
		inputEmail.sendKeys(email);
	}
	
	public void clickInputPassword(String password) {
		inputPassword.click();
		inputPassword.sendKeys(password);
	}
	
	public void clickInputConfrirmPassword( String password) {
		inputConfirmPassword.click();
		inputConfirmPassword.sendKeys(password);
	}
	
	public void clickBotonSiguiente() {
		inputEmail.click();
		botonSiguiente.click();
	}

}
