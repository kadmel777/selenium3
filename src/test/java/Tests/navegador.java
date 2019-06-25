package Tests;

import org.testng.annotations.Test;


import Pages.aviancaPage;
import Pages.formularioLifemilles1;
import Pages.formularioLifemilles2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class navegador {	
	
	private ChromeDriver driver;
	public String password = "Tcs123456";
	public String correo = "correodeeeprueba"+(Math.round((Math.random()*100)))+"@gmail.com";
	public String name = "camilo";
	public String usuarioNoExiste ="1234567890";
	public String correoRegistrado= "correodeeeprueba99@gmail.com";
	public String secondname = "aveanca";
	public String lastname = "prueba";
	public String secondlastname = "aveanca";
	public String mes = "Mayo";
	public String año = "1992";
	public String cedula = ""+Math.round((Math.random()*Math.pow(10, 10)));
	public String dia = "19";
	public String pais = "Colombia";
	public String nombreLabel="";
	
	aviancaPage objetosPage;
	formularioLifemilles1 objetosFormulario1;
	formularioLifemilles2 objetosFormulario2;
	
  @BeforeTest
  public void beforeTest() {
	        
	  System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
	  String URL = "https://www.avianca.com/co/es/descubre-y-compra/destinos/";
	  driver.get(URL);
	  
	  objetosPage = new aviancaPage(driver);
	  objetosFormulario1 = new formularioLifemilles1(driver);
	  objetosFormulario2 = new formularioLifemilles2(driver);
  }
  @Test
  public void registrandoUsuarios() throws InterruptedException {
	  
	  objetosPage.clickBotonMyAvanca();
	  objetosPage.clickBotonRegistrate(2);
	  
	  cambiarPestaña(65);
	  
	  objetosFormulario1.clickBotonAceptar(3);
	  objetosFormulario1.clickInputEmail(correo);
	  objetosFormulario1.clickInputPassword(password);
	  objetosFormulario1.clickInputConfrirmPassword(password);
	  objetosFormulario1.clickBotonSiguiente();
	  
	  objetosFormulario2.clickInputFirtsname(name, 1);
	  objetosFormulario2.clickInputSecondname(secondname);
	  objetosFormulario2.clickInputLastname(lastname);
	  objetosFormulario2.clickInputSecondlastname(secondlastname);
	  objetosFormulario2.llenandoPais(pais);
	  objetosFormulario2.llenandoMes(mes);
	  objetosFormulario2.llenandoDia(dia);
	  objetosFormulario2.llenandoYear(año);
	  objetosFormulario2.clickInputCedula(cedula);
	  objetosFormulario2.llenandoPais2(pais);
	  objetosFormulario2.clickCheckButton1();
	  objetosFormulario2.clickCheckButton2();
	  objetosFormulario2.clickBotonSiguiente();
	  compararNombres();	  	  
	  
  }
  
  @Test
  public void registrandoUsuarioRegistrado() throws InterruptedException {
	  
	  objetosPage.clickBotonMyAvanca();
	  objetosPage.clickBotonRegistrate(2);
	  
	  cambiarPestaña(65);
	  
	  objetosFormulario1.clickBotonAceptar(3);
	  objetosFormulario1.clickInputEmail(correoRegistrado);
	  objetosFormulario1.clickInputPassword(password);
	  objetosFormulario1.clickInputConfrirmPassword(password);
	  objetosFormulario1.clickBotonSiguiente();
	  
	  objetosFormulario2.clickInputFirtsname(name, 1);
	  objetosFormulario2.clickInputSecondname(secondname);
	  objetosFormulario2.clickInputLastname(lastname);
	  objetosFormulario2.clickInputSecondlastname(secondlastname);
	  objetosFormulario2.llenandoPais(pais);
	  objetosFormulario2.llenandoMes(mes);
	  objetosFormulario2.llenandoDia(dia);
	  objetosFormulario2.llenandoYear(año);
	  objetosFormulario2.clickInputCedula(cedula);
	  objetosFormulario2.llenandoPais2(pais);
	  objetosFormulario2.clickCheckButton1();
	  objetosFormulario2.clickCheckButton2();
	  objetosFormulario2.clickBotonSiguiente();
	  
	  comparandoMensajeError();
  }  
  
  @Test
  public void iniciandoSencionConUsuarioIncorrecto() throws InterruptedException {
	  objetosPage.clickBotonMyAvanca();
	  objetosPage.clickInpuntLiemilles(usuarioNoExiste);
	  objetosPage.clickInputPassword(password);
	  objetosPage.clickBotonIniciarSecion();
	 
	  comparandoMensajeUsuarioInvalido(10);
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
  
  
  public void cambiarPestaña(int retrasoEnSegundos) throws InterruptedException {
	  Thread.sleep(retrasoEnSegundos*1000);	 
	  ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	  driver.switchTo().window(tabs2.get(0));
	  driver.close();
	  driver.switchTo().window(tabs2.get(1));
  }
  
  public void compararNombres() throws InterruptedException {
	  nombreLabel = objetosFormulario2.obtenerNombre(10);
	  String nombre = (name.substring(0, 1).toUpperCase() + name.substring(1));
	  Assert.assertEquals(nombreLabel, nombre);
  }
  
  public void comparandoMensajeError() throws InterruptedException {
	  String error= objetosFormulario2.obtenerError(20);
	  boolean resultadoComparacion= false;
	  if(error.contains("code: 2175")) {
		  resultadoComparacion=true;
	  }
	  Assert.assertEquals(resultadoComparacion, true);
  }
  
  public void comparandoMensajeUsuarioInvalido(int retrasoEnSegundos) throws InterruptedException {
	  Thread.sleep(retrasoEnSegundos*1000);
	  String error = objetosPage.obtenerError();
	  boolean resultado = false;
	  if(error.contains("Número de cuenta LifeMiles inválido")) {
		  resultado = true;
	  }
	  Assert.assertEquals(resultado, true);
  }

}
