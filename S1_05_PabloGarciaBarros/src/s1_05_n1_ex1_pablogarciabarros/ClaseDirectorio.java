package s1_05_n1_ex1_pablogarciabarros;

import java.io.File;

public class ClaseDirectorio {
	
	private File carpeta;
	
	public ClaseDirectorio(String ubicacionCarpeta) {
		this.carpeta = new File(ubicacionCarpeta);
	}
	
	public File getFile() {
		return this.carpeta;
	}
	
	public void mostrarContenido() {
		File[] carpetas = carpeta.listFiles();
		for(int i = 0; i < carpetas.length; i++) {
			System.out.println(carpetas[i].getPath());
		}
	}

}
