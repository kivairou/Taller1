/*
 Kevin Matías Mauricio Zamora Riquelme | 21578521-1 | ICCI
 Tomás Ignacio Zepeda Velasquez | 21789061-6 | ICCI


*/

package taller1;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class Main {

	private static Scanner scan;
	
	private static String[] usuarios = new String[3];
	private static String[] contras = new String[3];
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
					registrarActividad(user);
					break;
				case 2:
					modificarActividad(user);
					break;
				case 3:
					eliminarActividad(user);
					break;
				case 4:
					cambiarContrasena(pos);
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
				actividadMasRealizada();
				break;
			case 2:
				actividadMasRealizadaXUsuario();
				break;
			case 3:
				usuarioMayorProcastinacion();
				break;
			case 4:
				verActividades();
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
	
	//--------------Menu Usuarios---------------------
	private static void cambiarContrasena(int pos) {
		System.out.print("Nueva Contrasena: ");
		contras[pos] = scan.nextLine();
		guardarUsuarios("Usuarios.txt");
		System.out.println("\nContrasena cambiada correctamente!!");
		
	}

	
	private static void eliminarActividad(String user) {
		int[] indices = new int[300];
		int contador = 0;
		
		for(int i = 0; i < totalRegistros; i++) {
			if(regUsuario[i].equals(user)) {
				System.out.println((contador + 1) + ") "+ regUsuario[i] + ";" + regFecha[i] + ";" + regHora[i] + ";" + regActividad[i]);
				indices[contador] = i;
				contador++;
			}
		}
		if (contador == 0) {
			System.out.println("El usuario no tiene actividades...");
			return;
		}
		System.out.print("Seleccione actividad: ");
		int sel = scan.nextInt();
		scan.nextLine();
        if (sel < 1 || sel > contador) return;
        int idx = indices[sel-1];

        for (int i = idx; i < totalRegistros-1; i++) {
            regUsuario[i] = regUsuario[i+1];
            regFecha[i] = regFecha[i+1];
            regHora[i] = regHora[i+1];
            regActividad[i] = regActividad[i+1];
        }
        totalRegistros--;
        guardarRegistros("Registros.txt");
        System.out.println("\nActividad eliminada!!");
    }


	private static void modificarActividad(String user) {
		int[] indices = new int[300];
		int contador = 0;
		for(int i = 0; i < totalRegistros; i++) {
			if(regUsuario[i].equals(user)) {
				System.out.println((contador+1)+ ") " + regUsuario[i] + ";" + regFecha[i] + ";" + regHora[i] + ";" + regActividad[i]);
				indices[contador] = i;
				contador++;	
			}
		}
		if(contador == 0) {
			System.out.println("El usuarios no tiene actividades...");
			return;
		}
		 System.out.print("Seleccione actividad: ");
	        int sel = scan.nextInt();
	        scan.nextLine();
	        if (sel < 1 || sel > contador) return;
	        int idx = indices[sel-1];

	        System.out.println("1) Fecha\n2) Duracion\n3) Actividad");
	        System.out.print("Ingrese campo a modificar: ");
	        int campo = scan.nextInt(); scan.nextLine();
	        switch(campo) {
	            case 1: 
	            	System.out.print("Nueva fecha: ");
	            	regFecha[idx] = scan.nextLine();
	            	break;
	            case 2:
	            	System.out.print("Nueva duracion: ");
	            	regHora[idx] = scan.nextInt();
	            	scan.nextLine();
	            	break;
	            case 3:
	            	System.out.print("Nueva actividad: ");
	            	regActividad[idx] = scan.nextLine();
	            	break;
	        }
	        guardarRegistros("Registros.txt");
	        System.out.println("\nActividad modificada!!");

		
	}

	private static void registrarActividad(String user) {
		if(totalRegistros >= 300) {
			System.out.println("No se pueden seguir registrando actividades...");
			return;
		}
		System.out.print("Fecha (dd/mm/aaaa): ");
		regFecha[totalRegistros] = scan.nextLine();
		System.out.print("Hora: ");
		regHora[totalRegistros] = scan.nextInt();
		scan.nextLine();
		System.out.println("Actividad: ");
		regActividad[totalRegistros] = scan.nextLine();
		regUsuario[totalRegistros] = user;
		totalRegistros++;
		guardarRegistros("Registros.txt");
		System.out.println("\nActividad registrada!!");
		
		
	}

	//--------------Escritores de texto--------------------
	private static void guardarUsuarios(String archivo) {
		try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo))) {
            for (int i = 0; i < usuariosTotales; i++) {
                escritor.write(usuarios[i] + ";" + contras[i]);
                escritor.newLine();
            }
        } catch (Exception e) {
            System.out.println("Error guardando usuario: " + e.getMessage());
        }

		
	}
	private static void guardarRegistros(String archivo) {
		try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo))){
			for(int i = 0; i < totalRegistros; i++) {
				escritor.write(regUsuario[i] + ";" + regFecha[i] + ";" + regHora[i] + ";" + regActividad[i]);
				escritor.newLine();
			}
		} catch (Exception e) {
			System.out.println("Error guardando registro: "+ e.getMessage());
		}
		
	}
	//---------------------Menu de analisis----------------------------
	private static void usuarioMayorProcastinacion() {
		 int[] horasXUsuario = new int[usuariosTotales];
		 for (int i=0;i<totalRegistros;i++) {
			 for(int j=0;j<usuariosTotales;j++) {
				 if (regUsuario[i].equals(usuarios[j])) {
					 horasXUsuario[j] += regHora[i];
				 }
			 }
		 }
		 int mayor = 0;
		 int indice = 0;
		 for (int i = 0;i<usuariosTotales;i++) {
			 if (horasXUsuario[i] > mayor ) {
				 mayor = horasXUsuario[i];
				 indice = i;
				 
			 }
		 }
		 System.out.println("Usuario con mayor procastinacion: "+ usuarios[indice] + " con "+ mayor + " horas");
	}

	private static void actividadMasRealizadaXUsuario() {
		for (int i = 0; i<usuariosTotales;i++) {
			String user = usuarios[i];
			String[] actividades = new String[300];
			int[] contador = new int[300];
			int totalAct = 0;
			
			for (int j = 0; j<totalRegistros;j++) {
				if (regUsuario[j].equals(user)) {
					String actividad = regActividad[j];
					int pos = -1;
					
					for (int k = 0;k<totalAct;k++) {
						if (actividades[k].equals(actividad)) {
							pos = k;
							break;
						}
					}
					if (pos == -1) {
						actividades[totalAct] = actividad;
						contador[totalAct] = regHora[j];
						totalAct++;
					}else {
						contador[pos] += regHora[j];
					}
				}
			}
			if (totalAct > 0);
			int mayor = 0;
			int indice = 0;
			for (int j = 0; j<totalAct;j++) {
				if (contador[j] > mayor) {
					mayor = contador[j];
					indice = j;
				}
			}
			System.out.println("- "+ user +" " + actividades[indice] + " con " + mayor + " horas registadas");
		}
		
	}

	private static void actividadMasRealizada() {
		String[] actividades = new String[300];
		int[] contador = new int[300];
		int totalActividades = 0;
		for (int i = 0; i<totalRegistros;i++) {
			String actividad = regActividad[i];
			int pos = -1;
			for (int j = 0; j<totalActividades;j++) {
				if (actividades[j].equals(actividad)){
					pos = j;
					break;
				}
			}
			if (pos == -1) {
				actividades[totalActividades] = actividad;
				contador[totalActividades] = regHora[i];
				totalActividades++;
 			}else {
 				contador[pos] += regHora[i];
 			}
				
		}
		int mayor = 0;
		int indice = 0;
		for (int i = 0; i<totalActividades;i++) {
			if (contador[i] > mayor) {
				mayor = contador[i];
				indice = i;
			}
		}
		System.out.println("La actividad mas realizada es: " + actividades[indice] + " con " + mayor + " horas");
		
	}

	private static void verActividades() {
		

			for (int j=0;j<300;j++) {
				if (regActividad[j] != null) {
					System.out.println(regUsuario[j]+" | "+regFecha[j]+" | "+regHora[j]+" | "+regActividad[j]);
					}
				}
			}
			
			
				
		
		
		
	

	//-------------------Lectores de archivos------------------------
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
