package ejercicio13_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainEjercicio13_1 {

	public static void main(String[] args) {
		
		try {
			//1.- Crear conexion
			Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##ALEX", "oracle");
			//3.- Ejecutar SQL
			BaseDatos miBaseDatos = new BaseDatos();
			//miBaseDatos.CreaTablaCoches(conexion, "coches");
			
			miBaseDatos.listarDatos(conexion);
			
			//miBaseDatos.borrarDatos(conexion, "COCHES", "ABC123");
			
			miBaseDatos.insertarDatos(conexion, "COCHES", "123ABC", "MERCEDES", "PRIMERA", "BLANCO", 2019, 12000);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			printSQLException(e);
		}
		
	
		
		
	}
	public static void printSQLException(SQLException ex){
		 ex.printStackTrace(System.err);
		 System.err.println("SQLState: " + ex.getSQLState());
		 System.err.println("Error Code: " + ex.getErrorCode());
		 System.err.println("Message: " + ex.getMessage());
		 Throwable t = ex.getCause();
		while(t != null)
		 {
		 System.out.println("Cause: " + t);
		 t = t.getCause();
		 }
	}
}
