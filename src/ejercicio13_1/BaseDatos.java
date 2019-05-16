package ejercicio13_1;

import java.sql.*;

public class BaseDatos {
	private String nombreTabla;
	
	public void CreaTablaCoches(Connection con, String nombreTabla) throws SQLException {
		this.nombreTabla = nombreTabla;
			
		String sql = "CREATE TABLE "+ nombreTabla + " " +
				"(MATRICULA VARCHAR (8),"
				+ "MARCA VARCHAR (40) NOT NULL,"
				+ "MODELO VARCHAR (40) NOT NULL,"
				+ "COLOR VARCHAR (40) NOT NULL,"
				+ "ANNO NUMBER (4),"
				+ "PRECIO NUMBER (6),"
				+ "PRIMARY KEY (MATRICULA))";
		
		Statement operacion = null;
		
		try {
			operacion = con.createStatement();
			operacion.executeUpdate(sql);
		}catch (SQLException e) {
		printSQLException(e);
		}finally {
			operacion.close();
		}
	}
	
	public void listarDatos (Connection con) throws SQLException {
		Statement operacion = null;
		String listar = "SELECT * FROM COCHES";
		
		try {
			operacion = con.createStatement ();
			ResultSet rs = operacion.executeQuery(listar);
			
			while (rs.next()) {
				String matricula = rs.getString("MATRICULA");
				System.out.println("Matricula: " + matricula);
				String marca = rs.getString("MARCA");
				System.out.println("Marca: " + marca);
				String modelo = rs.getString("MODELO");
				System.out.println("Modelo: " + modelo);
				String color = rs.getString("COLOR");
				System.out.println("Color: " + color);
				String anno = rs.getString("ANNO");
				System.out.println("Año: "+ anno);
				String precio = rs.getString("precio");
				System.out.println("Precio: " + precio);
				
				System.out.println("*************************************************");
			}
		}catch (SQLException e) {
			printSQLException (e);
		}finally {
			operacion.close();
		}
		
	}
	public void borrarDatos (Connection conexion, String nombreTabla, String matricula) {
		this.nombreTabla = nombreTabla;
		
		String delete = "DELETE FROM " + nombreTabla + " WHERE MATRICULA = '"+ matricula+"'";
		
		Statement operacion = null;
		
		try {
			operacion = conexion.createStatement();
			operacion.executeUpdate(delete);
			
			System.out.println("Se ha eliminado el coche con matricula " + matricula);
		}catch (SQLException e) {
			printSQLException (e);
		}
		
	}
	
	public void insertarDatos (Connection conexion, String nombreTabla, String matricula, String marca, String modelo, String color, int año, int precio) {
		this.nombreTabla = nombreTabla;
		Statement operacion = null;
		String comprobar = "SELECT MATRICULA FROM COCHES WHERE MATRICULA = " + "'"+matricula+"'" ;
		
		String insert = "INSERT INTO "+ nombreTabla + " (MATRICULA, MARCA, MODELO, COLOR, ANNO, PRECIO) VALUES "
				+ "(" + "'"+matricula + "'"+  ", " +  "'"+marca + "'"+ ", " +  "'" + modelo +  "'" +", " +  "'"+ color +  "'" + ", " +  "'" + año + "'" + ", " +  "'" + precio +  "'"+")";
		
		try {
			operacion = conexion.createStatement();
			ResultSet rs = operacion.executeQuery(comprobar);
			
			if (rs.next()) {
				System.out.println("El coche que desea introducir ya existe");
			}else {
				operacion.executeUpdate(insert);
			}
		}catch (SQLException e) {
			printSQLException (e);
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
