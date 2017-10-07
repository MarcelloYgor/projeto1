package br.sceweb.teste_unitario;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.model.Empresa;
import br.sceweb.model.EmpresaDAO;

public class UC01CadastrarEmpresa {
	
	public static Empresa empresa;
	public static EmpresaDAO empresaDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDAO = new EmpresaDAO();
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
	}
	
	/*
	 * Pós teste, limpa banco de dados
	 * Limpa banco de dados
	 */
	@After
	public void tearDownAfterClass() throws Exception {
		empresaDAO.remove(empresa.getCnpj());
	}

	/*
	 * CT01 Cadastra empresa com sucesso
	 * Cadastro de empresas com sucesso
	 */
	@Test
	public void CT01UC01FBCadastrarEmpresaComSucesso() {
		assertEquals(1, empresaDAO.adiciona(empresa));
	}
	
	/*
	 * CT02 Set nome empresa inválido
	 * Cadastra empresa com nome inválido
	 */
	@Test(expected=IllegalArgumentException.class)
	public void CT02UC01A1CadastrarEmpresa_nome_invalido() {
		empresa.setNomeDaEmpresa("");
	}

	/*
	 * CT03 Cadastro CNPJ inválido
	 * Cadastra empresa com cnpj inválido
	 */
	@Test
	public void CT03UC01A2CadastrarEmpresa_cnpj_invalido() {
		assertEquals("CNPJ invalido.", empresa.setCnpj(""));
	}
	
	/*
	 * CT04 Cadastra empresa duplicada
	 * Cadastra empresa já cadastrada
	 */
	@Test
	public void CT04UC01A3CadastrarEmpresa_emresa_ja_cadastrada() {
		empresaDAO.adiciona(empresa);
		assertEquals(0, empresaDAO.adiciona(empresa));
	}
}
