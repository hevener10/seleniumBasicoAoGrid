package cursoselenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAlert {
	
	private WebDriver driver;
	
	@Before
	public void inicializa() {
		
		System.setProperty("webdriver.gecko.driver",	"C:\\dev\\repositorio\\automacao_sig\\drivers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver",	"C:\\dev\\repositorio\\automacao_sig\\drivers\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver",		"C:\\dev\\repositorio\\automacao_sig\\drivers\\IEDriverServer.exe");
		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 762));
		driver.get("http://127.0.0.1:8090/componentes.html");
	}
	
	@After
	public void finaliza() {
		//driver.quit();
	}
	
	@Test
	public void deveInteragirComAlertSimples() {
		//System.out.println(driver.getTitle());
		Assert.assertEquals("Campo de Treinamento",driver.getTitle());
		
		driver.findElement(By.id("alert")).click();
		
		Alert alerta = driver.switchTo().alert();
		
		String temp = alerta.getText();
		alerta.accept();
		
		Assert.assertEquals("Alert Simples", temp);
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys(temp);
		
		Assert.assertEquals("Alert Simples", driver.findElement(By.id("elementosForm:nome")).getAttribute("Value"));
	}

	@Test
	public void deveInteragirComAlertConfirma(){
		//System.out.println(driver.getTitle());
		Assert.assertEquals("Campo de Treinamento",driver.getTitle());
		
		WebElement confirma =  driver.findElement(By.id("confirm"));
		
		confirma.click();
		
		Alert alerta = driver.switchTo().alert();
		
		String texto = alerta.getText();
		
		Assert.assertEquals("Confirm Simples", texto);
		
		alerta.accept();
		
		texto = alerta.getText();
		Assert.assertEquals("Confirmado", texto);
		alerta.accept();	
		
	}
	
	@Test
	public void deveInteragirComAlertNegado(){

		Assert.assertEquals("Campo de Treinamento",driver.getTitle());
		
		WebElement confirma =  driver.findElement(By.id("confirm"));
		
		confirma.click();
		
		Alert alerta = driver.switchTo().alert();
		
		String texto = alerta.getText();
		
		Assert.assertEquals("Confirm Simples", texto);
		
		alerta.dismiss();
		
		texto = alerta.getText();
		Assert.assertEquals("Negado", texto);
		alerta.accept();

		
	}

	@Test
	public void deveInteragirComAlertPronport(){

		
		//System.out.println(driver.getTitle());
		Assert.assertEquals("Campo de Treinamento",driver.getTitle());
		
		WebElement confirma =  driver.findElement(By.id("prompt"));
		
		confirma.click();
		
		Alert alerta = driver.switchTo().alert();
		
		String texto = alerta.getText();
		
		Assert.assertEquals("Digite um numero", texto);
		alerta.sendKeys("31");
		alerta.accept();
		
		
		texto = alerta.getText();
		Assert.assertEquals("Era 31?", texto);
		alerta.accept();
		
		texto = alerta.getText();
		Assert.assertEquals(":D", texto);
		alerta.accept();
		
		
		
		confirma.click();
		
		alerta = driver.switchTo().alert();
		
		texto = alerta.getText();
		
		Assert.assertEquals("Digite um numero", texto);
		alerta.sendKeys("31");
		alerta.accept();
		
		
		texto = alerta.getText();
		Assert.assertEquals("Era 31?", texto);
		alerta.dismiss();
		
		texto = alerta.getText();
		Assert.assertEquals(":(", texto);
		alerta.accept();

		
	}

}
