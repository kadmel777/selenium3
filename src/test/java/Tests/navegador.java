package Tests;

import org.testng.annotations.Test;


import Pages.aviancaPage;
import Pages.formularioLifemilles1;

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
	public String correo = "correodeprueba"+(Math.round((Math.random()*100)))+"@gmail.com";
	public String name = "camilo";
	public String secondName = "aveanca";
	public String lastname = "prueba";
	public String secondLastname = "aveanca";
	public String mesS = "Mayo";
	public String añoS = "1992";
	public String cedula = ""+Math.round((Math.random()*Math.pow(10, 10)));
	public String diaS = "19";
	public String paisS = "Colombia";
	public String nombreLabel="";
	
	aviancaPage objetosPage;
	formularioLifemilles1 objetosFormulario1;
	
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
			
  }
  @Test
  public void registrandoUsuarios() throws InterruptedException {
	  
	  objetosPage.clickBotonMyAvanca();
	  objetosPage.clickBotonRegistrate(2);
	  
	  cambiarPestaña(60);
	  
	  
	  
	  
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
  
  
  public void cambiarPestaña(int retrasoEnSegundos) throws InterruptedException {
	  Thread.sleep(retrasoEnSegundos*1000);	 
	  System.out.println("Cambiando de pestaña");
	  ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	  driver.switchTo().window(tabs2.get(0));
	  driver.close();
	  driver.switchTo().window(tabs2.get(1));
  }

}
