package s1_05_n3_pablogarciabarros;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese la ubicacion de la carpeta");
		
		String ubicacionCarpeta = entrada.nextLine();
		
		System.out.println("Ingrese el nombre del archivo encriptado (formato TXT)");
		String ubicacionArchivoEncriptado = entrada.nextLine();
		
		System.out.println("Ingrese el nombre del archivo desencriptado (formato TXT)");
		String ubicacionArchivoDesencriptado = entrada.nextLine();
		
		ClaseDirectorio claseDirectorio = new ClaseDirectorio(ubicacionCarpeta);
		claseDirectorio.abrirCarpeta(claseDirectorio.getFile(), ubicacionArchivoEncriptado, ubicacionArchivoDesencriptado);

	}

}
