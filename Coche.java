package repasoYAmpliacionFicheros;

public class Coche {

	private String nombre;
	private String numero;
	
	public Coche(String nombre,String splitLinea) {
		this.numero=splitLinea;
		this.nombre=nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String toCSV() {
        return nombre + "," + numero ;
    }
	
	
}