package capaDatos;

import java.sql.*;

public class FactoryConexion {

	
	String dbDriver="com.mysql.jdbc.Driver";
	String host="localhost";
	String port="3306";
	String user="Damian";
	String password="HyperdimensionNoire";
	String database="java";
	
	private Connection conn;
	private int cantCon;
	
	private FactoryConexion(){
		try {
			Class.forName(dbDriver);
			conn=null;
			cantCon=0;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static FactoryConexion instancia;
	
	public static FactoryConexion getInstancia(){
		if (instancia==null){
			instancia = new FactoryConexion();
		}
		return instancia;
	}
	
	
	
	public Connection getConn(){
		try {
			if(conn==null || conn.isClosed()){
				conn = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+database+"?user="+user+"&password="+password);
				cantCon++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public void releaseConn(){
		try {
			cantCon--;
			if(cantCon==0){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
