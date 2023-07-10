package br.ce.wcaquino.page;

import br.ce.wcaquino.core.BasePage;

public class CampoTreinamentoPage extends BasePage{
	
	public void setNome(String nome) {
		dsl.escreve("elementosForm:nome", nome);
	}
	
	public void setSobrenome(String sobrenome) {
		dsl.escreve("elementosForm:sobrenome", sobrenome);
	}
	
	public void setSexoMasculino() {
		dsl.clicarRadio("elementosForm:sexo:0");
	}
	
	public void setSexoFeminino() {
		dsl.clicarRadio("elementosForm:sexo:1");
	}
	
	public void setCamidaPizza() {
		dsl.clicarRadio("elementosForm:comidaFavorita:2");
	}
	
	public void setCamidaVegetariano() {
		dsl.clicarRadio("elementosForm:comidaFavorita:3");
	}
	
	public void setEscolaridade(String valor) {
		dsl.selecionarCombo("elementForm:escolaridade", valor);
	}
	
	public void setEsportes(String... valores) {
		for(String valor: valores)
			dsl.selecionarCombo("elementosForm:esportes", valor);
	}
	
	public void setCadastrar() {
		dsl.clicarBotao("elementosForm:cadastrar");
	}

	public String setObterResultadoCadastrado() {
		return 	dsl.obterTexto("resultado");
	}
	
	public String setObterResultadoNome() {
		return dsl.obterTexto("descNome");
	}
	
	public String setObterResultadoSobrenome() {
		return dsl.obterTexto("descSobrenome");
	}
	
	public String setObterResultadoSexo() {
		return dsl.obterTexto("descSexo");
	}
	
	public String setObterResultadoComida() {
		return dsl.obterTexto("descComida");
	}
	
	public String setObterResultadoEscolaridade() {
		return dsl.obterTexto("descEscolaridade");
	}
	
	public String setObterResultadoEsportes() {
		return dsl.obterTexto("descEsportes");
	}	
	
	public String setObterMensagem() {
		return dsl.alertaObterTextoAceito();
	}	
}
