package SillasFast;
/**
 * Clase TablaHash
 * @author Fatake
 */
public class TablaHash{
	//Atributos
	//private final int TAM = 98;//Numero primo
	//Arreglo de sillas
	private Lista[] arreglo = new Lista[98];
	/**
	 * Constructor
	 */
	public TablaHash(){ }

        /**
         * Metodo Generado de Hash
         * @param ID
         * @return 
         */
	private int hash(int ID){
		int llave;
		//Metodo de difivision
		llave = (ID & 0x7fffffff) % 98;
		/* 
		 * Dara residuos hasta antes del 97 osea 96
		 * 0x7fffffff en mascaramiento con el numero 0111 1111 en binario para que 
		 * el numero K siempre sea positivo
		 * Se puede usar math.abd()
		 */
		return llave;
	}

        /**
         * Metodo Insertar
         * @param elemento 
         */
	public void insertar(Silla elemento){
                 int llave = hash(elemento.getID());
                 Lista aux = new Lista();
                 aux.inserta(elemento);
                 arreglo[llave] = aux;
	}

        /**
         * Metodo Buscar
         * @param ID
         * @return 
         */
        public Silla buscar(int ID){
            int llave = hash(ID);
            Silla aux = arreglo[llave].buscar(ID);
            if (aux != null)
                return aux;
            return null;
        }
}
