package pt.gnr.gestaoescalas.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataService {

	private static Connection con;
	private static final String Driver = "com.mysql.jdbc.Driver";
	private static final String ConnectionString = "jdbc:mysql://mysql23950-escalas.jelastic.lunacloud.com/user";
	private static final String user = "user";
	private static final String pwd = "yz6yHGUvtRAwKftC";

	public DataService() {
	}

	/**
	 * to load the database base driver
	 *
	 * @return a database conexão
	 * @throws SQLException
	 *             envia sql exception em caso de erro
	 *
	 */
	// @Bean
	public Connection loadDriver() throws SQLException {
		try {
			Class.forName(Driver);
		} catch (ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
		con = DriverManager.getConnection(ConnectionString, user, pwd);
		return con;
	}

	/**
	 *
	 * @param con
	 *            connection
	 * @throws SQLException
	 *             envia sql exception em caso de erro
	 * */
	public void close(Connection con) throws SQLException {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				throw e;
			}
		}
	}
}
