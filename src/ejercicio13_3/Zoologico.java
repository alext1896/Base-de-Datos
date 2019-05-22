package ejercicio13_3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Zoologico {

	private int id;
	private static int idSiguiente = 1;
	
	public void listarDatosUbicacion (Connection con, String v_ubicacion) throws SQLException {
		Statement operacion = null;
		String listar = "SELECT * FROM ZOOLOGICO WHERE UBICACION = '" + v_ubicacion + "'" ;
		
		try {
			operacion = con.createStatement ();
			ResultSet rs = operacion.executeQuery(listar);
			
			while (rs.next()) {
				String nombre = rs.getString("NOMBRE");
				System.out.println("Nombre: " + nombre);
				String edad = rs.getString("EDAD");
				System.out.println("Edad: " + edad);
				String color = rs.getString("COLOR");
				System.out.println("Color: " + color);
				String tipoComida = rs.getString("TIPOCOMIDA");
				System.out.println("Tipo de Comida: " + tipoComida);
				String cantidadComida = rs.getString("Cantidad_Comida");
				System.out.println("Cantidad de Comida: "+ cantidadComida + "Kg/día");
				String cuidador = rs.getString("CUIDADOR");
				System.out.println("Precio: " + cuidador);
				String caractEspeciales = rs.getString("CARACTERISTICA_ESPECIALES");
				System.out.println("Caracteristicas especiales: " + caractEspeciales);
				String ubicacion = rs.getString("UBICACION");
				System.out.println("Ubicacion: "+ ubicacion);
				String id = rs.getString("CUIDADOR");
				System.out.println("Precio: " + id);
				
				System.out.println("*************************************************");
			}
		}catch (SQLException e) {
			printSQLException (e);
		}finally {
			operacion.close();
		}
	}
	
	public void contarDatosUbicacion (Connection con, String v_ubicacion) throws SQLException {
		Statement operacion = null;
		String listar = "SELECT COUNT(ID) FROM ZOOLOGICO WHERE UBICACION = '" + v_ubicacion + "'" ;
		
		try {
			operacion = con.createStatement ();
			ResultSet rs = operacion.executeQuery(listar);
			
			while (rs.next()) {
				String cuenta = rs.getString("COUNT(ID)");
				System.out.println("NUM DE ANIMALES: " + cuenta);
				
				System.out.println("*************************************************");
			}
		}catch (SQLException e) {
			printSQLException (e);
		}finally {
			operacion.close();
		}
	}
	
	public void tipoComidaCantidad (Connection con) throws SQLException {
		Statement operacion = null;
		String listar = "SELECT TIPOCOMIDA, CANTIDAD_COMIDA FROM ZOOLOGICO" ;
		
		try {
			operacion = con.createStatement ();
			ResultSet rs = operacion.executeQuery(listar);
			
			while (rs.next()) {
				String comida = rs.getString("TIPOCOMIDA");
				System.out.println("TIPO DE COMIDA: " + comida);
				String cantidad = rs.getString("CANTIDAD_COMIDA");
				System.out.println("CANTIDAD: " + cantidad + " Kg/dia");
				
				System.out.println("*************************************************");
			}
		}catch (SQLException e) {
			printSQLException (e);
		}finally {
			operacion.close();
		}
	}
	
	public void listarDatosCuidador (Connection con, String v_cuidador) throws SQLException {
		Statement operacion = null;
		String listar = "SELECT * FROM ZOOLOGICO WHERE CUIDADOR = '" + v_cuidador + "'" ;
		
		try {
			operacion = con.createStatement ();
			ResultSet rs = operacion.executeQuery(listar);
			
			
			if (rs.next() == false) {
				System.out.println("No hay animales con el cuidador " + v_cuidador);
			}
			else {
				while (rs.next()) {
					String nombre = rs.getString("NOMBRE");
					System.out.println("Nombre: " + nombre);
					String edad = rs.getString("EDAD");
					System.out.println("Edad: " + edad);
					String color = rs.getString("COLOR");
					System.out.println("Color: " + color);
					String tipoComida = rs.getString("TIPOCOMIDA");
					System.out.println("Tipo de Comida: " + tipoComida);
					String cantidadComida = rs.getString("Cantidad_Comida");
					System.out.println("Cantidad de Comida: "+ cantidadComida + "Kg/día");
					String cuidador = rs.getString("CUIDADOR");
					System.out.println("Precio: " + cuidador);
					String caractEspeciales = rs.getString("CARACTERISTICA_ESPECIALES");
					System.out.println("Caracteristicas especiales: " + caractEspeciales);
					String ubicacion = rs.getString("UBICACION");
					System.out.println("Ubicacion: "+ ubicacion);
					String id = rs.getString("CUIDADOR");
					System.out.println("Precio: " + id);
					
					System.out.println("*************************************************");
				}
				
			}
		}catch (SQLException e) {
			printSQLException (e);
		}finally {
			operacion.close();
		}
	}
	
	public void contarVeterinarios (Connection con, String v_ubicacion) throws SQLException {
		Statement operacion = null;
		String listar = "SELECT COUNT(VETERINARIO) FROM ZOOLOGICO WHERE UBICACION = '" + v_ubicacion + "' AND VETERINARIO = 1" ;
		
		try {
			operacion = con.createStatement ();
			ResultSet rs = operacion.executeQuery(listar);
			

				while (rs.next()) {
					String cuenta = rs.getString("COUNT(VETERINARIO)");
					
					if (cuenta.equals("0") == true) {
						System.out.println("No hay veterinarios en " + v_ubicacion);
					}else {
						System.out.println("NUMERO DE VETERINARIOS EN " + v_ubicacion + ": " + cuenta);
						
						System.out.println("*************************************************");
					}
				}
			
			
			
		}catch (SQLException e) {
			printSQLException (e);
		}finally {
			operacion.close();
		}
	}
	
	public void borrarDatos (Connection conexion, String nombreTabla, int id) {
		String delete = "DELETE FROM " + nombreTabla + " WHERE ID = '"+ id+"'";
		
		Statement operacion = null;
		
		try {
			operacion = conexion.createStatement();
			operacion.executeUpdate(delete);
			
			System.out.println("Se ha eliminado el animal con id: " + id);
		}catch (SQLException e) {
			printSQLException (e);
		}
		
	}
	
	public void insertarDatos (Connection conexion, String nombreTabla, String nombre, int edad, String color, String tipoComida, int cantidadComida, String cuidador, String caractEspeciales, String ubicacion) {
		id = idSiguiente;
		Statement operacion = null;
		
		String insert = "INSERT INTO "+ nombreTabla + " (NOMBRE, EDAD, COLOR, TIPOCOMIDA, CANTIDAD_COMIDA, CUIDADOR, CARACTERISTICA_ESPECIALES, UBICACION, ID ) VALUES "
				+ "(" + "'"+nombre + "'"+  ", " +  "'"+edad + "'"+ ", " +  "'" + color +  "'" +", " +  "'"+ tipoComida +  "'" + ", " +  "'" + cantidadComida + "'" + ", " +  "'" + cuidador +  "'"+ 
				", " +  "'" + caractEspeciales +  "'"+ ", " +  "'" + ubicacion +  "'"+ ", " +  "'" + id +  "'" +")";
		
		try {
			operacion = conexion.createStatement();			
			operacion.executeUpdate(insert);
			
		}catch (SQLException e) {
			printSQLException (e);
		}
		idSiguiente++;
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
