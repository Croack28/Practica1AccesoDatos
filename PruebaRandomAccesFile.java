package unidad1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class PruebaRandomAccesFile {

	public static void main(String[] args) {
		
		ArrayList<Integer> arrayList = new ArrayList<>(20);
		
		 File archivo = new File("datos.bin");
	        
		 if (archivo.exists()) {
	            System.out.println("El fichero existe. Leyendo datos...");
	            try (DataInputStream in = new DataInputStream(new FileInputStream(archivo))) {
	                // Leer hasta llenar el ArrayList o hasta que no haya más datos
	                while (arrayList.size() < 20 && in.available() > 0) {
	                    arrayList.add(in.readInt());
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        } else {
	            System.out.println("El fichero no existe. Creando fichero con 20 ceros...");

	            // Rellenar el ArrayList con 20 ceros
	            for (int i = 0; i < 20; i++) {
	                arrayList.add(0);
	            }

	            // Escribir los 20 ceros en el fichero
	            try (DataOutputStream out = new DataOutputStream(new FileOutputStream(archivo))) {
	                for (int i = 0; i < arrayList.size(); i++) {
	                	out.writeInt(0); // Escribir un cero
	                }
	                System.out.println("Fichero creado y rellenado con 20 ceros.");
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
		 
	     // Abrir el fichero con RandomAccessFile en modo rwd
		 try (RandomAccessFile raf = new RandomAccessFile(archivo, "rwd");
	             Scanner scanner = new Scanner(System.in)) {

	            boolean salir = false;

	            while (!salir) {
	                // Mostrar el contenido actual del ArrayList
	                System.out.println("\nContenido del ArrayList:");
	                for (int i = 0; i < arrayList.size(); i++) {
	                    System.out.println("Posición " + i + ": " + arrayList.get(i));
	                }

	                // Pedir la posición a modificar
	                System.out.print("\nIngrese la posición a modificar (negativo para salir): ");
	                int posicion = scanner.nextInt();

	                if (posicion < 0) {
	                    salir = true; // Salir del bucle si la posición es negativa
	                } else if (posicion >= 0 && posicion < arrayList.size()) {
	                    // Pedir el nuevo valor
	                    System.out.print("Ingrese el nuevo valor para la posición " + posicion + ": ");
	                    int nuevoValor = scanner.nextInt();

	                    // Actualizar la estructura en memoria (ArrayList)
	                    arrayList.set(posicion, nuevoValor);

	                    // Actualizar el fichero en la posición correspondiente
	                    raf.seek(posicion * 4); // Cada entero ocupa 4 bytes
	                    raf.writeInt(nuevoValor);

	                    System.out.println("Posición " + posicion + " actualizada con valor " + nuevoValor + ".");
	                } else {
	                    System.out.println("Posición inválida, ingrese un número entre 0 y 19.");
	                }
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	}

}
