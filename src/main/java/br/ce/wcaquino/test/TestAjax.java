package br.ce.wcaquino.test;
import static br.ce.wcaquino.core.DriverFactory.getDriver;
import static br.ce.wcaquino.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.wcaquino.core.DSL;


public class TestAjax {
	
	private DSL dsl;
	
	@Before
	public void inicializando() {
		getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml");
		dsl = new DSL();
	}
	
	@After
	public void finalizando() {
		killDriver();
	}
	
	@Test
	public void testAjax() {
		dsl.escreve("j_idt85:name", "testando");
		dsl.clicarBotao("j_idt85:j_idt88");
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("J_idt98")));
		Assert.assertEquals("testando", dsl.obterTexto("j_idt85:display"));
	}
}
