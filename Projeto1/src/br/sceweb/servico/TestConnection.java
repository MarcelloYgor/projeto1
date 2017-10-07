package br.sceweb.servico;

import com.mysql.jdbc.Connection;

public class TestConnection {
	
	public static void main(String[] args) {
		System.out.println("Teste de conecção e singleton");
		try {
			Connection conn = (Connection) new FabricaDeConexoes()
					.getConnection();
			System.out.println("Conecção: " + conn.getClientInfo());
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
