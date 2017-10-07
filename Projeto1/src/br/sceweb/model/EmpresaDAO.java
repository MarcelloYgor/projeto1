package br.sceweb.model;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.sceweb.servico.FabricaDeConexoes;

public class EmpresaDAO {

	public int adiciona(Empresa empresa) {
		PreparedStatement ps;
		int codigoRetorno = 0;
		try (Connection conn = (Connection) FabricaDeConexoes.getFabrica().getConnection()) {
			ps = (PreparedStatement) conn.prepareStatement(
					"insert into empresa (cnpj, nomeDaEmpresa, nomeFantasia, endereco, telefone) values(?,?,?,?,?)");
			ps.setString(1, empresa.getCnpj());
			ps.setString(2, empresa.getNomeDaEmpresa());
			ps.setString(3, empresa.getNomeFantasia());
			ps.setString(4, empresa.getEndereco());
			ps.setString(5, empresa.getTelefone());
			codigoRetorno = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return codigoRetorno;
	}

	public int remove(String cnpj) {
		PreparedStatement ps = null;
		int codigoRetorno = 0;
		try {
			Connection conn = (Connection) FabricaDeConexoes.getFabrica().getConnection();
			String sql = "delete from empresa where cnpj = ?";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(0, cnpj);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return codigoRetorno;
	}
}
