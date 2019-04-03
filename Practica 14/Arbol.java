public class Arbol{
	/**
	 * Atributos
	 */
	private NodoBinario raiz;

	/**
	 * Constructores
	 */
	public Arbol() {
		raiz = null;
	}

	public Arbol(int valor){
		this.raiz = new NodoBinario( valor );
	}

	public Arbol(NodoBinario raiz){
		this.raiz = raiz;
	}

	/**
	 * Gets and Sets
	 */
	public NodoBinario getRaiz(){
		return raiz;
	}

	public void setRaiz(NodoBinario raiz) {
		this.raiz = raiz;
	}

	/**
	 * Funciones
	 */

	public void imprimirEnOrden(){
		if (raiz != null){
			raiz.mostrarEnOrden();
		}else
			System.out.println ("No a Creado un arbol");
	}

	public void imprimirPosOrden(){
		if (raiz != null){
			raiz.mostrarPosOrden();
		}else
			System.out.println ("No a Creado un arbol");
	}

	public void imprimirPreOrden(){
		if (raiz != null){
			raiz.mostrarPreOrden();
		}else
			System.out.println ("No a Creado un arbol");
	}

	//Agregar
	private void addNodo(NodoBinario nodo, NodoBinario raiz ){
		if (raiz == null)
			raiz = nodo;
		else
			if (nodo.getValor() <= raiz.getValor())
				addNodo(nodo, raiz.getLeft());
			else 
				addNodo(nodo, raiz.getRight());
	}

	public void insertar(int dato){
		NodoBinario nodo = new NodoBinario(dato);
		addNodo(nodo, this.raiz);
	}

	public boolean removeNodo(NodoBinario nodo){
		boolean tieneNodoDerecha = nodo.getRight() != null ? true : false;
		boolean tieneNodoIzquierda = nodo.getLeft() != null ? true : false;

		/* Caso 1: No tiene hijos */
		if (!tieneNodoDerecha && !tieneNodoIzquierda)
			return removeNodoCaso1(nodo);

		/* Caso 2: Tiene un hijo y el otro no */
		if (tieneNodoDerecha && !tieneNodoIzquierda )
			return removeNodoCaso2(nodo);

		/* Caso 2: Tiene un hijo y el otro no */
		if (!tieneNodoDerecha && tieneNodoIzquierda)
			return removeNodoCaso2(nodo);

		/* Caso 3: Tiene ambos hijos */
		if (tieneNodoDerecha && tieneNodoIzquierda )
			return removeNodoCaso3(nodo);

		return false;
	}

	/**
	 * Caso 1
	 */
	private boolean removeNodoCaso1(NodoBinario nodo){
		NodoBinario hijoIzquierdo = nodo.getPadre().getLeft();
		NodoBinario hijoDerecho = nodo.getPadre().getRight();

		if (hijoIzquierdo == nodo){
			nodo.getPadre().setLeft(null);
			return true;
		}

		if (hijoDerecho == nodo){
			nodo.getPadre().setRight(null);
			return true;
		}

		return false;
	}

	/**
	 * Caso 2
	 */
	private boolean removeNodoCaso2(NodoBinario nodo){
		NodoBinario hijoIzquierdo = nodo.getPadre().getLeft();
		NodoBinario hijoDerecho = nodo.getPadre().getRight();

		NodoBinario hijoActual = nodo.getLeft() != null ? 
				nodo.getLeft() : nodo.getRight();

		if (hijoIzquierdo == nodo){
			nodo.getPadre().setLeft(hijoActual);

			hijoActual.setPadre(nodo.getPadre());
			nodo.setRight(null);
			nodo.setLeft(null);

			return true;
		}

		if (hijoDerecho == nodo) {
			nodo.getPadre().setRight(hijoActual);

			hijoActual.setPadre(nodo.getPadre());
			nodo.setRight(null);
			nodo.setLeft(null);

			return true;
		} 

		return false;
	}

	/**
	 * Caso 3
	 */
	private boolean removeNodoCaso3(NodoBinario nodo){
		/* Tomar el hijo derecho del NodoBinario que queremos eliminar */
		NodoBinario NodoBinarioMasALaIzquierda = recorrerIzquierda(nodo.getRight());
		if ( NodoBinarioMasALaIzquierda != null ){
			/*
			 * Reemplazamos el valor del NodoBinario que queremos eliminar por el NodoBinario que encontramos 
			 */
			nodo.setValor( NodoBinarioMasALaIzquierda.getValor() );
			/* 
			 * Eliminar este NodoBinario de las formas que conocemos ( caso 1, caso 2 ) 
			 */
			removeNodo( NodoBinarioMasALaIzquierda );
			return true;
		}
		return false;
	}

	private NodoBinario recorrerIzquierda(NodoBinario nodo) {
		if (nodo.getLeft() != null) {
			return recorrerIzquierda( nodo.getLeft() );
		}
		return nodo;
	}

	private NodoBinario buscar(int numero){
		return  this.buscar(raiz,numero);
	}

	private NodoBinario buscar(NodoBinario raiz, int numero){
		if (raiz.getValor() == numero)
			return raiz;
		else{
			if(raiz.getValor() < numero)
				if(raiz.getRight() != null)
					return this.buscar(raiz.getRight(),numero);
			if(raiz.getValor() > numero)
				if(raiz.getLeft() != null)
					return this.buscar(raiz.getLeft(),numero);
		}
		return null;
	}

	public boolean eliminar(int dato){
		if(this.buscar(dato) != null)
			return removeNodo(this.buscar(dato));
		return false;
	}
}
