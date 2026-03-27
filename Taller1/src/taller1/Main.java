package taller1;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

	private static Scanner scan;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		leerUsuarios();
		leerRegistros();
		desplegarMenu();
		

	}

	private static void desplegarMenu() {
		// TODO Auto-generated method stub
		System.out.println("1) Menu de Usuarios");
		System.out.println("2) Menu de Analisis");
		System.out.println("3) Salir");
	}

	private static void leerRegistros() throws FileNotFoundException{
		
		File txtRegistros = new File("Registros.txt");
		scan = new Scanner(txtRegistros);
		
		while(scan.hasNextLine()) {
			
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
			
			String nombre = partes[0];
			String fecha = partes[1];
			int horas = Integer.parseInt(partes[2]);
			String actividad = partes[3];
		}
		
	}

	private static void leerUsuarios() throws FileNotFoundException{
		// TODO Auto-generated method stub
		File txtUsuarios = new File("Usuarios.txt");
		scan = new Scanner(txtUsuarios);
		
		while(scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
			
			String ID = partes[0];
			String contraseña = partes[1];
		}
	}

}
