import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Principal {
	private WebDriver driver;
	
	@Before
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "C:/Users/Arthur Henrique/Documents/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://virtual.unipe.br/ead/acessar/");
	}
		
	@Test
	public void logarNoVirtual(){
		WebElement matricula = driver.findElement(By.name("username"));
		WebElement senha = driver.findElement(By.name("password"));
		matricula.sendKeys("Sua Matricula");
		senha.sendKeys("Sua Senha");
		WebElement button = driver.findElement(By.className("button"));
		button.click();
		
		driver.findElement(By.linkText("SALA COORDENAÇÃO UBTECH TI**")).click();
		boolean abriu = driver.getPageSource().contains("https://virtual.unipe.br/ead/course/view.php?id=16370");
		assertTrue(abriu);
	}
	@After
	public void tearDown(){
		driver.quit();
	}
}

