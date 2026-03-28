/*
 Kevin Matías Mauricio Zamora Riquelme | 21578521-1 | ICCI
 Tomás Ignacio Zepeda Velasquez | 21789061-6 | ICCI


*/
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
		scan = new Scanner(System.in);
		int opcion = 0;
		
		do {
		System.out.println();
		System.out.println("1) Menu de Usuarios");
		System.out.println("2) Menu de Analisis");
		System.out.println("3) Salir");
		System.out.print("Ingrese una opcion:");
		
		opcion = scan.nextInt();
		scan.nextLine();
		
		switch(opcion) {
		
		case 1:
			
			System.out.print("Usuario: ");
			String user = scan.nextLine();
			System.out.print("Contraseña: ");
			String contra = scan.nextLine();
			break;
		case 2:
			int opcion1 = 0;
			do {
			System.out.println();
			System.out.println("Bienvenido al menu de analisis!");
			System.out.println("1) Actividad mas realizada");
			System.out.println("2) Actividad mas realizada por cada usuario");
			System.out.println("3) Usuario con mayor procastinacion");
			System.out.println("4) Ver todas las actividades");
			System.out.println("5) Salir");
			System.out.print("Ingrese una opcion:");
			
			opcion1 = scan.nextInt();
			scan.nextLine();
			switch(opcion1) {
			
			}
			break;
			}while(opcion1 !=5);
		}
	}while(opcion!=3); 
		
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
