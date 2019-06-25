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
	
	@FindBy(xpath="//input[@id='lifeMilesNumber']")
	WebElement inputLifemilles;
	
	@FindBy(xpath="//input[@id='lifeMilesPassword']")
	WebElement inputPassword;

	@FindBy(xpath="//input[@title='Inicia sesión']")
	WebElement botonIniciarSecion;
	
	@FindBy(xpath="//span[@class='message-pre']")
	WebElement mensajeError;
	
	public aviancaPage(WebDriver driver){		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickBotonMyAvanca(){
		botonMyAvianca.click();		
	}
	
	public void clickBotonRegistrate(int retrasoEnSegundos) throws InterruptedException {
		Thread.sleep(retrasoEnSegundos*1000);
		botonRegistrate.click();
	}
	
	public void clickInpuntLiemilles(String cedula) {
		inputLifemilles.click();
		inputLifemilles.sendKeys(cedula);		
	}
	
	public void clickInputPassword(String password) {
		inputPassword.click();
		inputPassword.sendKeys(password);
	}
	
	public void clickBotonIniciarSecion() {
		botonIniciarSecion.click();
	}
	
	public String obtenerError() {
		return mensajeError.getText();
	}
}
