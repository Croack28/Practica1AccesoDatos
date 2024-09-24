package unidad1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializacion {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		String[] arraySerializable = new String[2];
		
		arraySerializable[0] = "Prueba";
		arraySerializable[1] = " de Serializacion";
		
		//Escritura
		
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("ficheroSerizalizacion"))){
			out.writeObject(arraySerializable);
		}catch(IOException ex) {
			ex.getMessage();
		}
		
		//Lectura
		
		String[] obj = null;
		
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("ficheroSerizalizacion"))){
			obj = (String[]) in.readObject();
		}catch(IOException ex) {
			ex.getMessage();
		}
		
		String[] recuperado = obj;
		
		System.out.println(recuperado[0] + recuperado[1]);
	}

}
