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
		
	}

}
