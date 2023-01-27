package s1_05_n1_ex3_pablogarciabarros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ClaseDirectorio {

	private File carpeta;
	private String ubicacionCarpeta;
	
	public ClaseDirectorio(String ubicacionCarpeta) {
		this.ubicacionCarpeta = ubicacionCarpeta;
		this.carpeta = new File(this.ubicacionCarpeta);
	}
	
	public File getFile() {
		return this.carpeta;
	}
	
	public void mostrarContenido(File carpeta, String ubicacionArchivo) {
		File[] carpetas = carpeta.listFiles();
		for(int i = 0; i < carpetas.length; i++) {
			if(carpetas[i].isDirectory() == true) {
				escribirArchivo(ubicacionArchivo, carpetas[i].getPath());
				mostrarContenido(carpetas[i], ubicacionArchivo);
			}
			else {
				escribirArchivo(ubicacionArchivo, carpetas[i].getPath());
			}
		}		
	}
	
	public void escribirArchivo(String ubicacionArchivo, String escritura) {
		File archivoEscritura = new File(ubicacionArchivo);
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter(archivoEscritura, true);
			bw = new BufferedWriter(fw);
			bw.write(escritura);
			bw.newLine();
			bw.flush();			
		}
		catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		finally {
			try {
				bw.close();
			}
			catch(IOException ioe) {
				System.out.println(ioe.getMessage());
			}
		}
	}
}
