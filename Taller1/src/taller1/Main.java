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
	
	private static String[] usuarios = new String[100];
	private static String[] contras = new String[100];
	private static int usuariosTotales = 0;
	
	private static String[] regUsuario = new String[300];
	private static String[] regFecha = new String[300];
	private static int[] regHora = new int[300];
	private static String[] regActividad = new String[300];
	private static int totalRegistros = 0;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		leerUsuarios();
		leerRegistros();
		desplegarMenu();
		

	}

	private static void desplegarMenu() {
		
		scan = new Scanner(System.in);
		int opcion = 0;
		
		do {
		
		System.out.println("1) Menu de Usuarios");
		System.out.println("2) Menu de Analisis");
		System.out.println("3) Salir");
		System.out.print("Ingrese una opcion:");
		
		opcion = scan.nextInt();
		scan.nextLine();
		
		switch(opcion) {
		
		case 1:
			
			System.out.print("\nUsuario: ");
			String user = scan.nextLine();
			System.out.print("Contraseña: ");
			String contra = scan.nextLine();
			
			int pos = -1;
			for(int i = 0; i < usuariosTotales; i++) {
				if(usuarios[i].equals(user) && contras[i].equals(contra)) {
					pos = i;
					break;
				}
			}
			
			if(pos == -1) {
				System.out.println("\nUsuario o Contrasena incorrecto(s)");
				break;
			}
			
			int opcion2;
			do {
				System.out.println("\nBienvenido "+ user);
				System.out.println("1) Registrar actividad");
				System.out.println("2) Modificar actividad");
				System.out.println("3) Eliminar actividad");
				System.out.println("4) Cambiar contrasena");
				System.out.println("5) Salir");
				System.out.print("Ingrese una opcion: ");
				
				opcion2 = scan.nextInt();
				scan.nextLine();
						
				switch(opcion2) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5: System.out.println("\nSaliendo..."); break;
				
				default: System.out.println("\nOpcion invalida...");
				}
				
			}while(opcion2!=5);
			
			
			break;
		case 2:
			int opcion1 = 0;
			do {
			
			System.out.println("\nBienvenido al menu de analisis!");
			System.out.println("1) Actividad mas realizada");
			System.out.println("2) Actividad mas realizada por cada usuario");
			System.out.println("3) Usuario con mayor procastinacion");
			System.out.println("4) Ver todas las actividades");
			System.out.println("5) Salir");
			System.out.print("Ingrese una opcion:");
			
			opcion1 = scan.nextInt();
			scan.nextLine();
			switch(opcion1) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5: System.out.println("\nSaliendo..."); break;
			
			default: System.out.println("\nOpcion invalida...");
			}
			}while(opcion1!=5);
			break;
			
		case 3: System.out.println("\nSaliendo..."); break;
			
		default: System.out.println("\nOpcion invalida...");
		}
	}while(opcion!=3); 
		
	}
	
	private static void leerRegistros() throws FileNotFoundException{
		
		try {
			File txtRegistros = new File("Registros.txt");
			scan = new Scanner(txtRegistros);
			
			while(scan.hasNextLine()) {
				
				String linea = scan.nextLine();
				String[] partes = linea.split(";");
				
				regUsuario[totalRegistros] = partes[0];
				regFecha[totalRegistros] = partes[1];
				regHora[totalRegistros] = Integer.parseInt(partes[2]);
				regActividad[totalRegistros] = partes[3];
				totalRegistros++;
				
			}
		}catch (Exception e) {
			System.out.println("\nNo se ha podido leer el archivo "+ e.getMessage());
		}
		
	}

	private static void leerUsuarios() throws FileNotFoundException{
		
		try {
			File txtUsuarios = new File("Usuarios.txt");
			scan = new Scanner(txtUsuarios);
			
			while(scan.hasNextLine()) {
				
				String linea = scan.nextLine();
				String[] partes = linea.split(";");
				
				usuarios[usuariosTotales] = partes[0];
				contras[usuariosTotales] = partes[1];
				usuariosTotales++;
			}
			
		}catch (Exception e) {
			System.out.println("\nError leyendo txt "+ e.getMessage());
		}
	}
}
