package SillasFast;
/**
 * Clase TablaHash
 * @author Fatake
 */
public class TablaHash{
	//Atributos
	private final Integer SIZE = 97;//Numero primo
	
	/**
	 * Constructor
	 */
	public TablaHash(){ }

	private Integer hash(Integer k){
		Integer llave = 0;
		
		//Metodo de difivision
		llave = (k & 0x7fffffff) % SIZE;
		/* 
		 * Dara residuos hasta antes del 97 osea 96
		 * 0x7fffffff en mascaramiento con el numero 0111 1111 en binario para que 
		 * el numero K siempre sea positivo
		 * Se puede usar math.abd()
		 */

		return llave;
	}

	/*public Silla buscar(){
		
		return null;
	}*/

	public void insertar(Silla elemento){
		Integer k = elemento.getID();
		System.out.println("El elemento "+elemento.getTipo()+" Tiene el Hash: "+hash(k));
	}

	public void borrar(Integer k){
		
	}
}
