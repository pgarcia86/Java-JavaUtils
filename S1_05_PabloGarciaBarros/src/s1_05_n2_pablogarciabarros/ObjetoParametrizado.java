package s1_05_n2_pablogarciabarros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class ObjetoParametrizado {
	
	private File carpeta;
	private String fichetoTxt;
	private Properties config = new Properties();
	
	public ObjetoParametrizado() {
		try {
			FileInputStream archivoConfiguracion = new FileInputStream("C:/Users/pgarc/eclipse-workspace/S1_05_PabloGarciaBarros/src/s1_05_n2_pablogarciabarros/configuracion.properties");
			this.config.load(archivoConfiguracion);
			this.carpeta = new File(this.config.getProperty("ubicacionCarpeta"));
			this.fichetoTxt = this.config.getProperty("ficheroSalida");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}	
	
	public File getFile() {
		return this.carpeta;
	}

	public void abrirArchivo(File carpeta) {
		File[] carpetas = carpeta.listFiles();
		for(int i = 0; i < carpetas.length; i++) {
			if(carpetas[i].isDirectory()) {
				escribirArchivo(carpetas[i].getPath());
				abrirArchivo(carpetas[i]);
			}
			else {
				escribirArchivo(carpetas[i].getPath());
			}
		}
	}
	
	public void escribirArchivo(String escritura) {
		File ficheroEscritura = new File(this.fichetoTxt);
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(ficheroEscritura, true);
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
