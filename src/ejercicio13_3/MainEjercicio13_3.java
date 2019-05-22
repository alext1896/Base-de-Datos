package ejercicio13_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class MainEjercicio13_3 {

	public static void main(String[] args) {
		//int op;
		//String cadena;
		Scanner sc = new Scanner (System.in);
		Zoologico zoo = new Zoologico ();
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/eclipse", "root", "oracle");

			//zoo.listarDatosUbicacion(conexion, "MADRID");
			//zoo.contarDatosUbicacion(conexion, "MADRID");
			//zoo.tipoComidaCantidad(conexion);
			//zoo.listarDatosCuidador(conexion, "FERNANDO");
			zoo.contarVeterinarios(conexion, "MADRID");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			printSQLException (e);
		}
		
		sc.close();
		
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
