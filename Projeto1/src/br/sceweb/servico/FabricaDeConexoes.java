package br.sceweb.servico;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaDeConexoes {
	
	private static FabricaDeConexoes fabrica = null;
	private Connection connection = null;
	
	
	private FabricaDeConexoes() {}
	
	public static FabricaDeConexoes getFabrica() {
		if (fabrica == null) {
			fabrica = new FabricaDeConexoes();
		}
		return fabrica;
	}
	
	public Connection getConnection() {
		if (connection == null) connection = connect();
		return connection;
	}
	
	private Connection connect() {
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