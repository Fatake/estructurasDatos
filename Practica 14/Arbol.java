public class Arbol{
	//Atributos
	private NodoBinario raiz;

	/**
	 * Constructores
	 */
	public Arbol(){
		raiz = null;
	}
	public Arbol(int dato){
		this.raiz = new NodoBinario(dato);
	}

	public Arbol(NodoBinario raiz ){
		this.raiz = raiz;
	}


	//Metodos
	public void imprimirEnOrden(){
		if (raiz != null)
			raiz.mostrarEnOrden();
		else
			System.out.println("No a Creado un arbol :(");
	}

	public void imprimirPosOrden(){
		if (raiz != null)
			raiz.mostrarPosOrden();
		else
			System.out.println("No a Creado un arbol :(");
	}

	public void imprimirPreOrden(){
		if (raiz != null)
			raiz.mostrarPreOrden();
		else
			System.out.println("No a Creado un arbol :(");
	}

	public void insertar(int dato){
		insertarRec(dato,this.raiz);
	}

	public void eliminar(int dato){
		eliminarRec(dato,this.raiz);
	}

	/*
	 * Metodos Recursivo
	 */
	private NodoBinario insertarRec(int dato, NodoBinario raiz){
		//Compara con Sub arboles
		if (raiz == null){ //No existe el arbol
			raiz = new NodoBinario(dato);
			raiz.mostrarEnOrden();
		}

		//Para Arboles Ordenados
		else if (dato < raiz.getDato())
			raiz = insertarRec(dato,raiz.getLeft());
		else if (dato > raiz.getDato())
			raiz = insertarRec(dato,raiz.getRight());
		
		return raiz;
	}

	private void eliminarRec(int dato, NodoBinario raiz){
		/**
		Caso 1
			No existe el dato
		Caso 2
			Dato a eliminar no tiene hijos
				eliminar(dato)
				Liberar Memoria
				Padre de ese Hijo apuntara a nulo
			Caso Particular si la raiz no tiene Hijos
				Raiz = Nulo
		Caso 3
			Dato a eliminar tiene un Hijo
				eliminar (Dato)
				Nieto pasa a ser Hijo
				Liberar Memoria
		Caso 4
			Dato a Eliminar tiene 2 Hijos
			eliminar (Dato)
			Buscar el menor de los mayores
			Buscar e mayor de los menore
			Dependiendo de la eleccion el nodo pasa a ser el padre
			Liberar Memoria
		*/
	}
}
