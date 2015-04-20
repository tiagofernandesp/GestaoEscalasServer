package pt.gnr.gestaoescalas.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataService {

	private static Connection con;
	private static final String Driver = "com.mysql.jdbc.Driver";
	private static final String ConnectionString = "jdbc:mysql://localhost/gestaoescalas?";
	private static final String user = "tiago";
	private static final String pwd = "tiago";

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
	public static Connection loadDriver() throws SQLException {
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
	public static void close(Connection con) throws SQLException {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				throw e;
			}
		}
	}
}
