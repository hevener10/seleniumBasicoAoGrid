package cursoselenium;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {
	
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver","C:\\dev\\repositorio\\automacao_sig\\drivers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\dev\\repositorio\\automacao_sig\\drivers\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver","C:\\dev\\repositorio\\automacao_sig\\drivers\\IEDriverServer.exe");
		
		
		dsl = new DSL(driver);
		
		
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test
	public void testeTextField() {
		dsl.escreveTesta("elementosForm:nome","Hevener");
	}
	
	@Test
	public void testeTextArea() {
		dsl.escreveTesta("elementosForm:sugestoes","Hevener");
	}
	
	@Test
	public void deveInteragirComRadioButton() {
		Assert.assertEquals("Campo de Treinamento",driver.getTitle());
				
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:1")).isSelected());
	}
	
	@Test
	public void deveInteragirComCheckButton() {
				Assert.assertEquals("Campo de Treinamento",driver.getTitle());	
				dsl.clicaRadio("elementosForm:comidaFavorita:0");
				Assert.assertTrue(dsl.isRadioMarcado("elementosForm:comidaFavorita:0"));			
	}
	
	@Test
	public void deveInteragirComCombo() {
		
		dsl.selecionaCombo("elementosForm:escolaridade", "2o grau completo");
		Assert.assertEquals("2o grau completo", dsl.obterValorCombo("elementosForm:escolaridade"));
	}
	@Test
	public void deveVerificarValoresCombo() {
		
		Assert.assertEquals("Campo de Treinamento",driver.getTitle());
		
		WebElement elemento = driver.findElement(By.id("elementosForm:escolaridade"));
		
		Select combo = new Select(elemento);
		//combo.selectByIndex(3);
		List<WebElement> options =  combo.getOptions();
		boolean encontrou = false;
		for(WebElement option: options) {
			if(option.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}
		}
		Assert.assertTrue(encontrou);
	}
	
	@Test
	public void deveVerificarValoresComboMultiplo() {
		dsl.selecionaCombo("elementosForm:esportes", "Natacao");
		dsl.selecionaCombo("elementosForm:esportes", "Corrida");
		dsl.selecionaCombo("elementosForm:esportes", "O que eh esporte?");
		
		
		
		//System.out.println(driver.getTitle());
		Assert.assertEquals("Campo de Treinamento",driver.getTitle());
		
		WebElement elemento = driver.findElement(By.id("elementosForm:esportes"));
		
		Select combo = new Select(elemento);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");
		
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		
		Assert.assertEquals(3, allSelectedOptions.size());
		
		
		combo.deselectByVisibleText("Corrida");
		
		allSelectedOptions = combo.getAllSelectedOptions();
		
		Assert.assertEquals(2, allSelectedOptions.size());
	}

	@Test
	public void deveInteragirComBotoes() {
		dsl.clicarBotao("buttonSimple");
		Assert.assertEquals("Obrigado!", driver.findElement(By.id("buttonSimple")).getAttribute("Value"));
	}
	
	@Test
	public void deveInteragirComOLink() throws InterruptedException {
		dsl.clicarLinks("Voltar");
		
		
		Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));
		Thread.currentThread();
		Thread.sleep(5000); // 1 segundo
		
		driver.quit();
	}
	
	@Test
	public void deveProcurarTextosNaPaginak(){
		Assert.assertEquals("Campo de Treinamento",driver.getTitle());
		
		
		//Assert.assertTrue(driver.findElement(By.tagName("body"))
		//		.getText().contains("Campo de Treinamento"));
		Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("H3")));
		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", dsl.obterTexto(By.className("facilAchar")));
	}

	public void deveProcurarAlert() {
		Assert.assertEquals("Campo de Treinamento",driver.getTitle());
	}

}

