package s1_05_n3_pablogarciabarros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class ClaseDirectorio {
	
	private File carpeta;
	private final String CLAVE_ENCRIPTAR;
	
	public ClaseDirectorio(String ubicacionCarpeta) {
		this.carpeta = new File(ubicacionCarpeta);
		this.CLAVE_ENCRIPTAR = "0123456789abcdef";
	}
	
	public File getFile() {
		return this.carpeta;
	}
	
	public void abrirCarpeta(File carpeta, String ubicacionArchivoEncriptado, String ubicacionArchivoDesencriptado) {
		String textoEncriptado = "";
		File[] carpetas = carpeta.listFiles();
		for(int i = 0; i < carpetas.length; i++) {
			if(carpetas[i].isDirectory() == true) {
				try {
					textoEncriptado = encriptar(carpetas[i].getPath());
				} 
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
				escribirArchivo(ubicacionArchivoEncriptado, textoEncriptado);
				abrirCarpeta(carpetas[i], ubicacionArchivoEncriptado, ubicacionArchivoDesencriptado);
				try {
					escribirArchivo(ubicacionArchivoDesencriptado, desencriptar(textoEncriptado));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			else {
				try {
					textoEncriptado = encriptar(carpetas[i].getPath());
				} 
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
				escribirArchivo(ubicacionArchivoEncriptado, textoEncriptado);
				try {
					escribirArchivo(ubicacionArchivoDesencriptado, desencriptar(textoEncriptado));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
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
	
	public String encriptar(String texto) throws Exception{
				
		SecretKeySpec llave = new SecretKeySpec(this.CLAVE_ENCRIPTAR.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, llave);
		
		byte[] encriptado = cipher.doFinal(texto.getBytes());
		String textoEncriptado = Base64.getEncoder().encodeToString(encriptado);
		return textoEncriptado;
			
	}
	
	public String desencriptar(String texto) throws Exception {

		byte[] encriptado = Base64.getDecoder().decode(texto);
		
		SecretKeySpec llave = new SecretKeySpec(this.CLAVE_ENCRIPTAR.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, llave);
		
		String desencriptado = new String(cipher.doFinal(encriptado));
		
		return desencriptado;
	}

}
