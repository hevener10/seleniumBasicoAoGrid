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
import org.openqa.selenium.support.ui.Select;

public class TesteCadastro {
	
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Hevener\\Downloads\\Compressed\\drivers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Hevener\\Downloads\\Compressed\\drivers\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver","C:\\Users\\Hevener\\Downloads\\Compressed\\drivers\\IEDriverServer.exe");
		
		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 762));
		driver.get("http://127.0.0.1:8090/componentes.html");
		dsl = new DSL(driver);
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test
	public void cadastroSucesso(){
		
		
		//System.out.println(driver.getTitle());
		Assert.assertEquals("Campo de Treinamento",driver.getTitle());
				
		
		WebElement btnCadastrar = driver.findElement(By.id("elementosForm:cadastrar"));
	
		
		btnCadastrar.click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Nome eh obrigatorio",alerta.getText());
		alerta.accept();
		
		dsl.escreveTesta("elementosForm:nome", "Hevener");
	
		
		btnCadastrar.click();
		alerta = driver.switchTo().alert();
		Assert.assertEquals("Sobrenome eh obrigatorio",alerta.getText());
		alerta.accept();
		
		dsl.escreveTesta("elementosForm:sobrenome", "Ancelmo");
		
		btnCadastrar.click();
		alerta = driver.switchTo().alert();
		Assert.assertEquals("Sexo eh obrigatorio",alerta.getText());
		alerta.accept();
		
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		
		
		
		
		Select escolaridade = new Select(driver.findElement(By.id("elementosForm:escolaridade"))); 
		
		escolaridade.selectByVisibleText("Especializacao");
		
		WebElement elemento = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(elemento);
		
		combo.selectByVisibleText("O que eh esporte?");
		
		
		//
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Melhorar Validações\n\n\n;)");
		btnCadastrar.click();
		
		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().contains("Cadastrado!"));
	
	}
	
	
}
