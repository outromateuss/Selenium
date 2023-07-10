package br.ce.wcaquino.test;
import static br.ce.wcaquino.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.page.CampoTreinamentoPage;

public class CadastroFormulario extends BaseTest{
	
	private CampoTreinamentoPage page;
	
	@Before
	public void inicializando() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage();
	}
	
	@Test
	public void cadastrarFormulario() {
		page.setNome("Mateus");
		page.setSobrenome("Ribeiro");
		page.setSexoMasculino();
		page.setCamidaPizza();
		page.setEsportes("Natacao");
		page.setCadastrar();
		
		Assert.assertTrue(page.setObterResultadoCadastrado().startsWith("Cadastrado!"));
		Assert.assertTrue(page.setObterResultadoNome().endsWith("Mateus"));
		Assert.assertEquals("Sobrenome: Ribeiro", page.setObterResultadoSobrenome());
		Assert.assertEquals("Sexo: Masculino", page.setObterResultadoSexo());
		Assert.assertEquals("Comida: Pizza", page.setObterResultadoComida());
		Assert.assertEquals("Esportes: Natacao", page.setObterResultadoEsportes());			
	}
	
	@Test
	public void cadastrar1() {
		page.setCadastrar();
		Assert.assertEquals("Nome eh obrigatorio", page.setObterMensagem());
	}
	
	@Test
	public void cadastrar2() {
		page.setNome("Vanderli");
		page.setCadastrar();
		Assert.assertEquals("Sobrenome eh obrigatorio", page.setObterMensagem());
	}

	@Test
	public void cadastrar3() {
		page.setNome("Vanderli");
		page.setSobrenome("Ribeiro");
		page.setCadastrar();
		Assert.assertEquals("Sexo eh obrigatorio", page.setObterMensagem());
	}
	
	@Test
	@Ignore
	public void cadastrar4() {
		page.setNome("Vanderli");
		page.setSobrenome("Ribeiro");
		page.setSexoMasculino();
		page.setCamidaPizza();
		page.setCamidaVegetariano();
		page.setCadastrar();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", page.setObterMensagem());
	}
	
	@Test
	public void cadastrar5() {
		page.setNome("Vanderli");
		page.setSobrenome("Ribeiro");
		page.setSexoMasculino();
		page.setCamidaPizza();
		page.setEsportes("Natacao", "O que eh esporte?");
		page.setCadastrar();
		Assert.assertEquals("Voce faz esporte ou nao?", page.setObterMensagem());
	}
		
}
