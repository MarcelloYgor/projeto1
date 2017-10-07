package br.sceweb.servico;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaDeConexoes {

	public Connection getConnection() {
		String url = "jdbc:mysql://localhost/sceweb";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// TODO: tem que mudar o usuário de acesso do mysql local
			return (Connection) DriverManager.getConnection(url, "teste", "teste");
		} catch (Exception e){
			throw new RuntimeException(e);
		}
	}
}