package br.ce.wcaquino.test;
import static br.ce.wcaquino.core.DriverFactory.getDriver;
import static br.ce.wcaquino.core.DriverFactory.killDriver;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import br.ce.wcaquino.core.DSL;


public class TesteCampodeTreinamento{
	
	private DSL dsl;
	
	@Before
	public void inicializando() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
	}
	
	@After
	public void finalizando() {
		killDriver();
	}
	
	@Test
	public void testeField() {
		dsl.escreve("elementosForm:nome", "Escrevendo algo");
		Assert.assertEquals("Escrevendo algo", dsl.obterValorEscrito("elementosForm:nome"));
	}
	
	@Test
	public void testeAreaText() {
		dsl.escreve("elementosForm:sugestoes", "teste");
		Assert.assertEquals("teste", dsl.obterValorEscrito("elementosForm:sugestoes"));
	}
	
	@Test
	public void testeRadio() {
		dsl.clicarRadio("elementosForm:sexo:0");
		Assert.assertTrue(dsl.isRadioMarcado("elementosForm:sexo:0"));
	}
	
	@Test
	public void testeCheckbox() {
		dsl.clicarCheckBox("elementosForm:sexo:0");
		Assert.assertTrue(dsl.isCkeckBoxMarcado("elementosForm:sexo:0"));
	}
	
	@Test
	public void testeComboSelect() {
		dsl.selecionarCombo("elementosForm:escolaridade", "2o grau incompleto");
		Assert.assertEquals("2o grau incompleto", dsl.obterValorCombo("elementosForm:escolaridade"));
	}
	
	@Test
	public void testeVerificarValorComboSelect() {
		WebElement element = getDriver().findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		List <WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());

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
	public void testeVerificarValorComboSelectMultiplo() {
		dsl.selecionarCombo("elementosForm:esportes", "Natacao");
		dsl.selecionarCombo("elementosForm:esportes", "Corrida");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");

		WebElement element = getDriver().findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);		
		List <WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());	
		combo.deselectByValue("Corrida");
		allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());
	}
	
	@Test
	public void testeDeveInteragirComBotoes() {
		dsl.clicarBotao("buttonSimple");
		Assert.assertEquals("Obrigado!", dsl.obterValor("buttonSimple"));
	}
	
	@Test
	public void testeDeveInteragirComLink() {
		getDriver().findElement(By.linkText("Voltar")).click();
		Assert.assertEquals("Voltou!", getDriver().findElement(By.id("resultado")).getText());
	}
	
	@Test
	public void testeDeveBuscarTexto() {		
		Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", dsl.obterTexto(By.className("facilAchar")));
	}
	
	@Test
	public void testeJavaScript() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		//js.executeScript("alert('Testando execultar JS com selenium');");
		js.executeScript("document.getElementById('elementosForm:nome').value = 'Ola bb!'");
		
		WebElement element = getDriver().findElement(By.id("elementosForm:nome"));
		js.executeScript("arguments[0].style.border = arguments[1]", element, "solid 4px red");
	}
	
	@Test
	public void deveClicarBotaoTabela() {
		dsl.clicarBotaoTabela("Nome", "Maria", "Botao", "elementosForm:tableUsuarios");
	}
	
	
}

