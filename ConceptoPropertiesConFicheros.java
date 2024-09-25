package repasoYAmpliacionFicheros;

import java.util.Properties;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;


public class ConceptoPropertiesConFicheros {
	
	final static String FICHERO_TXT = "repaso.txt";
	final static String FICHERO_XML = "repaso.xml";
	
	public static void main(String[]args) {
		
		guardarDatos();
		
		Properties[] propiedades = cargarDatos();
		
		for(Properties p : propiedades) {
			System.out.println(p);
		}
		
		
	}
	
	public static void guardarDatos(){
		Properties propiedades = new Properties();
		
		propiedades.setProperty("hola","quetal");
		propiedades.setProperty("jefe","adios");
		propiedades.setProperty("papa","ayuda");
		
		
		
		try (
				FileOutputStream ficheroRepaso =  new FileOutputStream(FICHERO_TXT);
				FileOutputStream ficheroRepasoXml =  new FileOutputStream(FICHERO_XML);
				)
		
		{
			propiedades.store(ficheroRepaso, "PROPIEDADES GUARDADAS EN FICHERO TEXTO");
			propiedades.storeToXML(ficheroRepasoXml, "PROPIEDADES GUARDADAS EN FICHERO XML");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Properties[] cargarDatos() {
		
		Properties p1 = new Properties();
		Properties p2 = new Properties();
		
		try (
				FileInputStream ficheroRepaso =  new FileInputStream(FICHERO_TXT);
				FileInputStream ficheroRepasoXml =  new FileInputStream(FICHERO_XML);	
				
				)
		{

			p1.load(ficheroRepaso);
			p2.loadFromXML(ficheroRepasoXml);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Properties[] propiedades = new Properties[2];
		propiedades[0]=p1;
		propiedades[1]=p2;
		
		return propiedades;
		
	}

}
