package cursoselenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle2 {

	@Test
	public void teste() {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Hevener\\Downloads\\Compressed\\drivers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Hevener\\Downloads\\Compressed\\drivers\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver","C:\\Users\\Hevener\\Downloads\\Compressed\\drivers\\IEDriverServer.exe");
		
		
		WebDriver driver = new FirefoxDriver();
		
		
		//WebDriver driver = new ChromeDriver();
		
		
		//WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().setPosition(new Point(100, 100));
		driver.get("http://www.google.com.br");
		//System.out.println(driver.getTitle());
		Assert.assertEquals("Google",driver.getTitle());
		//driver.close();
	}
}
