package cursoselenium;

import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



public class DSL {
	
	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializar() {
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
	}
	
	public DSL(WebDriver driver) {
		this.driver = driver;
	}



	public void escreve(String id_campo,String texto) {
		driver.findElement(By.id(id_campo)).sendKeys(texto);
	}
	
	public String obterValorCampo(String id_campo) {
		return driver.findElement(By.id(id_campo)).getAttribute("value");
	}
	
	public void escreveTesta(String id_campo,String texto) {
		escreve(id_campo,texto);
		Assert.assertEquals(texto, obterValorCampo(id_campo));
	}
	
	public void clicaRadio(String id) {
		driver.findElement(By.id(id)).click();
	}
	public boolean isRadioMarcado(String id) {
		return driver.findElement(By.id(id)).isSelected();	
	}
	public void selecionaCombo(String id,String valor) {
		//System.out.println(driver.getTitle());
			
		WebElement elemento = driver.findElement(By.id(id));
				
		Select combo = new Select(elemento);
		//combo.selectByIndex(3);
		combo.selectByVisibleText(valor);
	}
	public String obterValorCombo(String id) {
		//System.out.println(driver.getTitle());
			
		WebElement elemento = driver.findElement(By.id(id));
				
		Select combo = new Select(elemento);
		//combo.selectByIndex(3);
		//combo.selectByVisibleText(valor);
		return combo.getFirstSelectedOption().getText();
	}
	
	public void clicarBotao(String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void clicarLink(String link) {
		driver.findElement(By.linkText(link)).click();
	}
	public String obterTexto(By by) {
		return driver.findElement(by).getText();
		
	}
	public String obterTexto(String id) {
		return obterTexto(By.id(id));
		
	}
}