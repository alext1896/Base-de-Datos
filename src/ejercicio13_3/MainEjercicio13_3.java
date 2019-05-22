package ejercicio13_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class MainEjercicio13_3 {

	public static void main(String[] args) {

		//String cadena;
		Scanner sc = new Scanner (System.in);
		Zoologico zoo = new Zoologico ();
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/eclipse", "root", "oracle");
			int op;
			//zoo.listarDatosUbicacion(conexion, "MADRID");
			//zoo.contarDatosUbicacion(conexion, "MADRID");
			//zoo.tipoComidaCantidad(conexion);
			//zoo.listarDatosCuidador(conexion, "FERNANDO");
			//zoo.contarVeterinarios(conexion, "MADRID");
			
			do {
				
				System.out.println("1.- INSERTAR FILA");
				System.out.println("2.- BORRAR");
				System.out.println("3.- MODIFICAR");
				System.out.println("4.- LISTAR");
				System.out.println("5.- LISTAR ANIMALES POR UBICACION");
				System.out.println("6.- NUMERO DE ANIMALES POR UBICACION");
				System.out.println("7.- TIPO DE COMIDA Y CANTIDAD POR ANIMAL");
				System.out.println("8.- LISTAR ANIMALES SEGUN EL CUIDADOR");
				System.out.println("9.- NUMERO DE VETERINARIOS POR UBICACION");
				System.out.println("10.- FINALIZAR PROGRAMA");
				op = sc.nextInt();
				
				switch (op) {
				case 1:	
					sc.nextLine();
					System.out.println("INTRODUCE EL NOMBRE");
					String nombre = sc.nextLine();
					System.out.println("INTRODUCE LA EDAD");
					int edad = sc.nextInt();
					System.out.println("INTRODUCE EL COLOR");
					String color = sc.nextLine();
					System.out.println("INTRODUCE EL TIPO DE COMIDA");
					String tipo = sc.nextLine();
					System.out.println("INTRODUCE LA CANTIDAD DE COMIDA");
					int cant = sc.nextInt();
					System.out.println("INTRODUCE EL NOMBRE DEL CUIDADOR");
					String cuidador = sc.nextLine();
					System.out.println("SI EL CUIDADOR TIENE TITULO DE VETERINARIO INSERTE UN 1, EN CASO CONTRARIO UN 0");
					byte veterinario = sc.nextByte();
					System.out.println("INSERTE CARACTERISTICAS ESPECIALES");
					String caracteEspec = sc.nextLine();
					System.out.println("INSERTE LA UBICACION");
					String ubicacion = sc.nextLine();
					
					zoo.insertarDatos(conexion, nombre, edad, color, tipo, cant, cuidador, veterinario, caracteEspec, ubicacion);
				}
			}while (op != 10);
			
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
