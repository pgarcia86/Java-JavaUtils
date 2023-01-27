package s1_05_n1_ex4_pablogarciabarros;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Ingrese la ubicacion de la carpeta que quiere mostar el contenido");
		String ubicacionCarpeta = entrada.nextLine();
		
		System.out.println("Ingrese la ubicacion del archivo y nombre que quiere crear(formato TXT)");
		String ubicacionArchivo = entrada.nextLine();
		
		System.out.println("Ingrse la ubicacion del archivo que quiere mostrar por consola (formato TXT)");
		String archivoLectura = entrada.nextLine();
		
		ClaseDirectorio claseDirectorio = new ClaseDirectorio(ubicacionCarpeta);
		claseDirectorio.mostrarContenido(claseDirectorio.getFile(), ubicacionArchivo);
		claseDirectorio.contenidoConsola(archivoLectura);		
	}

}
