package sl.boardroom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BaseDao {
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String url = "jdbc:sqlserver://192.168.1.218:1433;databasename=boardroom";
	private String user = "sa";
	private String pwd = "123";
	
	private Connection conn = null;
	
	public Connection getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	

	public void closeAll(Connection conn,Statement pst,ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public int exceuteUpdate(String sql ,Object[] params) {
		int result = 0;
		conn = getConnection();
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pst.setObject(i + 1, params[i]);
				}
			}
			result = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pst, null);
		}
		return result;
	}
	
	
	public ResultSet exceuteQuery(String sql ,Object[] params) {
		ResultSet rs = null;
		conn = getConnection();
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					pst.setObject(i + 1, params[i]);
				}
			}
			rs = pst.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return rs;
	}
}
