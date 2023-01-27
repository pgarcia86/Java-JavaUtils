package s1_05_n1_ex2_pablogarciabarros;

import java.io.File;

public class ClaseDirectorio {
	
	private File carpeta;
	
	public ClaseDirectorio(String ubicacionCarpeta) {
		this.carpeta = new File(ubicacionCarpeta);
	}
	
	public File getFile() {
		return this.carpeta;
	}
	
	public void mostrarContenido(File carpeta) {
		File[] carpetas = carpeta.listFiles();
		for(int i = 0; i < carpetas.length; i++) {
			if(carpetas[i].isDirectory() == true) {
				System.out.println(carpetas[i].getPath() + "(D)");
				mostrarContenido(carpetas[i]);
			}
			else {
				System.out.println(carpetas[i].getPath() + "(F)");
			}
		}
	}
}
