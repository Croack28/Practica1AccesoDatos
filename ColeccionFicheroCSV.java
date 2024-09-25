package repasoYAmpliacionFicheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ColeccionFicheroCSV {

	
	public static void main(String[]args) {
		
		
		ArrayList<Coche> coches=new ArrayList<Coche>();
		coches.add(new Coche("audi","1"));
		coches.add(new Coche("meñércedes","2"));
		coches.add(new Coche("Renault","3"));
		
		
		ArrayList<Coche> coches2 = recuperarDeCSV();
		for(Coche coche:coches2) {
			System.out.println(coche.toCSV());
		}
		

		
		guardarEnCSV(coches);
		
	}
	
	public static void guardarEnCSV(ArrayList<Coche> coches) {
		
		try (PrintWriter entrada = new PrintWriter("archivoCSV.csv");){

			for(Coche cocheAux: coches) {
				entrada.println(cocheAux.toCSV());
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Coche> recuperarDeCSV() {
		ArrayList<Coche> coches=new ArrayList<Coche>();
		try(BufferedReader salida= new BufferedReader(new FileReader("pruebaFicherosCSV.txt"));
				){
			String linea = "";
			String[] splitLinea=null;
			while ((linea=salida.readLine())!=null) {
				splitLinea = linea.split(",");
				coches.add(new Coche(splitLinea[0],splitLinea[1]));
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return coches;
	}
	
}