package s1_05_n1_ex5_pablogarciabarros;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjetoSerializado implements Serializable{
	
	private int dato1;
	private String dato2;
	
	public ObjetoSerializado(int dato1, String dato2) {
		this.dato1 = dato1;
		this.dato2 = dato2;
	}
	
	public String toString() {
		return "Dato 1 = " + this.dato1 + " - Dato 2 = " + this.dato2;
	}
	
	public void serializar(ObjetoSerializado objeto) {
		try {
			FileOutputStream archivoSerializado = new FileOutputStream("fichero.ser");
			ObjectOutputStream objetoSerializado = new ObjectOutputStream(archivoSerializado);
			objetoSerializado.writeObject(objeto);
			objetoSerializado.close();
			System.out.println("Se ha creado el archivo 'fichero.ser'");
		}
		catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}
	
	public void deserializar() {
		try {
			FileInputStream archivoDeserializado = new FileInputStream("fichero.ser");
			ObjectInputStream objetoDeserializado = new ObjectInputStream(archivoDeserializado);
			System.out.println("\nDatos del objeto deserializado");
			System.out.println(objetoDeserializado.readObject().toString());
		}
		catch(IOException | ClassNotFoundException ioe) {
			System.out.println("Linea 39");
			System.out.println(ioe.getMessage());
		}
	}

}
