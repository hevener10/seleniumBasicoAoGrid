package cursoselenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteFrame {
	
private WebDriver driver;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Hevener\\Downloads\\Compressed\\drivers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Hevener\\Downloads\\Compressed\\drivers\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver","C:\\Users\\Hevener\\Downloads\\Compressed\\drivers\\IEDriverServer.exe");
		
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 762));
		driver.get("http://127.0.0.1:8090/componentes.html");
	}
	
	@After
	public void finaliza() {
		driver.quit();
	}

	@Test
	public void deveInteragirComFrames(){
		//System.out.println(driver.getTitle());
		Assert.assertEquals("Campo de Treinamento",driver.getTitle());
		
		//WebElement frame = driver.findElement(By.id("frame1"));
		driver.switchTo().frame("frame1");
		
		driver.findElement(By.id("frameButton")).click();
		
		Alert alerta = driver.switchTo().alert();
		String texto = alerta.getText();
		Assert.assertEquals("Frame OK!",texto);	
		alerta.accept();
		
		driver.switchTo().defaultContent();
		
		WebElement sugestoes = driver.findElement(By.id("elementosForm:sugestoes"));
		sugestoes.sendKeys(texto);
		Assert.assertEquals(texto, sugestoes.getAttribute("Value"));
		driver.close();
	}
	
	@Test
	public void deveInteragirComJanelas(){
		
		//System.out.println(driver.getTitle());
		Assert.assertEquals("Campo de Treinamento",driver.getTitle());
		
		driver.findElement(By.id("buttonPopUpEasy")).click();
		
		String idWindow = driver.getWindowHandle();
		
		driver.switchTo().window("Popup");
		
		
		driver.findElement(By.tagName("textarea")).sendKeys("Texto na popUP");
		
		driver.close();
		
		driver.switchTo().window(idWindow);
		
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Texto no principal");
	
	}

	@Test
	public void deveInteragirComJanelasDoMal(){

		//System.out.println(driver.getTitle());
		Assert.assertEquals("Campo de Treinamento",driver.getTitle());
		
		driver.findElement(By.id("buttonPopUpHard")).click();
		
		
		
		String idWindow = driver.getWindowHandle();
		System.out.println(driver.getWindowHandles());
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
		
		driver.manage().window().setPosition(new Point(1200, 0));
		driver.findElement(By.tagName("textarea")).sendKeys("Texto na popUP");
		
		//driver.close();
		
		driver.switchTo().window(idWindow);
		
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Texto no principal");
		
	}

}
