package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class formularioLifemilles2 {
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='firstname']")
	WebElement inputFisrtname;
	
	@FindBy(xpath="//input[@id='secondName']")
	WebElement inputSecondname;
	
	@FindBy(xpath="//input[@id='lastname']")
	WebElement inputLastname;
	
	@FindBy(xpath="//input[@id='secondLastName']")
	WebElement inputSecondlastname;
			
	@FindBy(xpath="//select[@id='country']")
	WebElement selectPais;
	
	@FindBy(xpath="//select[@placeholder='Mes']")
	WebElement selectMes;
	
	@FindBy(xpath="//select[@placeholder='Día']")
	WebElement selectDia;
	
	@FindBy(xpath="//select[@placeholder='Año']")
	WebElement selectAño;
	
	
	@FindBy(xpath="//input[@id='documentNumber']")
	WebElement inputCedula;
	
	@FindBy(xpath="//select[@placeholder='']")
	WebElement selectPais2;
	
	  
	@FindBy(xpath="//label[@for='normal_term0']")
	WebElement checkBoton1;
	
	@FindBy(xpath="//label[@for='normal_term1']")
	WebElement checkBoton2;
	
	@FindBy(xpath="//button[@type='button']")
	WebElement botonSiguiente;
	
	@FindBy(xpath="//a[@href='/account/overview']")
	WebElement labelNombre;
	
	@FindBy (xpath="//div/p[1]")
	WebElement mensajeError;
	
	public formularioLifemilles2(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickInputFirtsname(String name, int retrasoEnSegundos) throws InterruptedException {
		Thread.sleep(retrasoEnSegundos*1000);
		inputFisrtname.click();
		inputFisrtname.sendKeys(name);		
	}
	
	public void clickInputSecondname(String secondname) {
		inputSecondname.click();
		inputSecondname.sendKeys(secondname);
	}
	
	public void clickInputLastname(String lastname) {
		inputLastname.click();
		inputLastname.sendKeys(lastname);
	}
	
	public void clickInputSecondlastname(String secondlastname) {
		inputSecondlastname.click();
		inputSecondlastname.sendKeys(secondlastname);
	}
	
	public void llenandoPais(String pais) {
		 Select country = new Select(selectPais);
		 country.selectByVisibleText(pais);
	}
	
	public void llenandoMes(String mont) {
		 Select mes = new Select(selectMes);
		 mes.selectByVisibleText(mont);
	}
	
	public void llenandoDia(String day) {
         Select dia = new Select(selectDia);
		 dia.selectByVisibleText(day);
	}
	
	public void llenandoYear(String año) {
		 Select year = new Select(selectAño);
		 year.selectByVisibleText(año);
	}
	
	public void clickInputCedula(String cedula) {
		inputCedula.click();
		inputCedula.sendKeys(cedula);
	}
	
	public void llenandoPais2(String pais) {
		 Select country2 = new Select(selectPais2);
		 country2.selectByVisibleText(pais);
	}
	
	public void clickCheckButton1() {
		checkBoton1.click();
	}
	
	public void clickCheckButton2() {
		checkBoton2.click();
	}
	
	public void clickBotonSiguiente() {
		
		botonSiguiente.click();
	}
	
	public String obtenerNombre(int retrasoEnSegundos) throws InterruptedException {
		Thread.sleep(retrasoEnSegundos*1000);
		return labelNombre.getText();
	}
	
	public String obtenerError(int retrasoEnSegundos) throws InterruptedException {
		Thread.sleep(retrasoEnSegundos*1000);
		return mensajeError.getText();
	}
	
}
