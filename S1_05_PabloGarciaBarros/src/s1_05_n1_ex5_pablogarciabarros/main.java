package s1_05_n1_ex5_pablogarciabarros;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ObjetoSerializado objeto = new ObjetoSerializado(65, "Pablo");
		objeto.serializar(objeto);
		objeto.deserializar();		
	}

}
