package br.ce.wcaquino.test;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testeAlert {
	
	@Test
	public void deveInteragirAlertSimples() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/bryan.almeida/Downloads/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("alert")).click(); // clicar no Alerta
		Alert alert = driver.switchTo().alert(); // o swichTo vai mudar o foco da tela para a tela do alert
		String texto = alert.getText(); // transformar o texto que estár no alert em variavel para utilizar posteriormente
		Assert.assertEquals("Alert Simples", texto); // verificando se o texto bate
		alert.accept(); // fechando o foco aberto pelo switchTo clicando no OK
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
	}
	
	@Test
	public void deveInteragirConfirm() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/bryan.almeida/Downloads/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("confirm")).click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alerta.getText());
		alerta.accept();
		Assert.assertEquals("Confirmado", alerta.getText());
		alerta.accept();
		
		driver.findElement(By.id("confirm")).click();
		alerta = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alerta.getText());
		alerta.dismiss();
		Assert.assertEquals("Negado", alerta.getText());
		alerta.accept();
		
		driver.quit();
	}
	
	@Test
	public void deveInteragirPrompt() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/bryan.almeida/Downloads/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("prompt")).click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Digite um numero", alerta.getText());
		alerta.sendKeys("20");
		alerta.accept();
		
		alerta = driver.switchTo().alert();
		Assert.assertEquals("Era 20?", alerta.getText());
		alerta.accept();
		
		alerta = driver.switchTo().alert();
		Assert.assertEquals(":D", alerta.getText());
		alerta.accept();
		
		driver.quit();
		}
}