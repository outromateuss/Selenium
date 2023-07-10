package br.ce.wcaquino.test;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class testeGoogle {
	
	@Test
	public void teste() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/bryan.almeida/Downloads/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://177.136.73.33:85/content/login/");
		Assert.assertEquals("GSHPRO | Login", driver.getTitle());
		driver.quit(); //serve para fechar todas as abas e mantar todas as instancias.
	}
}