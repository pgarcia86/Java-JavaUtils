package s1_05_n1_ex2_pablogarciabarros;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Ingrese la ubicacion de la carpeta de la que quiere mostar el contenido");
		String ubicacionCarpeta = entrada.nextLine();
		
		ClaseDirectorio claseDirectorio = new ClaseDirectorio(ubicacionCarpeta);
		claseDirectorio.mostrarContenido(claseDirectorio.getFile());
	}
}
