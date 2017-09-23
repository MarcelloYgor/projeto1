package br.sceweb.model;

public class Empresa {
	
	private String cnpj;
	private String nomeDaEmpresa;
	private String nomeFantasia;
	private String endereco;
	private String telefone;
	
	public void setNomeDaEmpresa(String nomeDaEmpresa) {
		if (nomeDaEmpresa.equals("")) {
			throw new IllegalArgumentException("Nome da empresa inválido!");
		} else {
			this.nomeDaEmpresa = nomeDaEmpresa;
		}
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNomeDaEmpresa() {
		return nomeDaEmpresa;
	}
	
	
}
