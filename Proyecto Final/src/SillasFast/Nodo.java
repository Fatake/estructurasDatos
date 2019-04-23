package SillasFast;
/**
 * Clase TablaHash
 * @author Fatake
 */
//Clase Provada Nodo
public class Nodo{
	//Atributos
	protected Silla info;
	protected Nodo sig;

	/**
	 * Constructor
         * @param dato
	 */
	public Nodo (Silla dato){
		info = dato;
		sig = null;
	}

	public Silla getDato(){
		return info;
	}
}
