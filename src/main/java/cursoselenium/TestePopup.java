package cursoselenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestePopup {
//buttonPopUpEasy
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
	public void cadastroSucesso(){
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Hevener\\Downloads\\Compressed\\drivers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Hevener\\Downloads\\Compressed\\drivers\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver","C:\\Users\\Hevener\\Downloads\\Compressed\\drivers\\IEDriverServer.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		
		
		driver.manage().window().setSize(new Dimension(1200, 762));
		driver.get("http://127.0.0.1:8090/componentes.html");
		
		//System.out.println(driver.getTitle());
		Assert.assertEquals("Campo de Treinamento",driver.getTitle());
		driver.findElement(By.id("buttonPopUpEasy")).click();
		//WebElement popup = driver.findElement(By.id("buttonPopUpEasy")).click();
	}
}
