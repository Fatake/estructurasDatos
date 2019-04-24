package SillasFast;
/**
 * Clase TablaHash
 * @author Fatake
 /**
 * Clase Nodo
 * @author pace_
 */
public class Nodo{
	//Atributos
	protected Silla info;
	protected Nodo sig;

	/**
	 * Constructor
         * @param elemento
	 */
	public Nodo (Silla elemento){
		info = elemento;
		sig = null;
	}

	public Silla getDato(){
		return info;
	}
}
