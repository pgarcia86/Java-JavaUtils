package s1_05_n1_ex3_pablogarciabarros;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Ingrese la ubicacion de la carpeta que quiere mostar el contenido");
		String ubicacionCarpeta = entrada.nextLine();
		
		System.out.println("Ingrese la ubicacion del archivo que desea crear(formato TXT)");
		String ubicacionArchivo = entrada.nextLine();
		
		ClaseDirectorio claseDirectorio = new ClaseDirectorio(ubicacionCarpeta);
		claseDirectorio.mostrarContenido(claseDirectorio.getFile(), ubicacionArchivo);
	}
}
