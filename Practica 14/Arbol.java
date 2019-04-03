public class Arbol{
	/* Atributos */
	private NodoBinario raiz;

	/* Contructories */
	public Arbol() {
		raiz = null;
	}

	public Arbol(int valor){
		this.raiz = new NodoBinario( valor );
	}

	public Arbol(NodoBinario raiz){
		this.raiz = raiz;
	}

	/* Setters y Getters */
	public NodoBinario getRaiz(){
		return raiz;
	}

	public void setRaiz(NodoBinario raiz) {
		this.raiz = raiz;
	}

	/**
	 * Funciones
	 */
	 //Agregar
	private void addNodo(NodoBinario nodo, NodoBinario raiz ){
		/* 2.- Partiendo de la raíz preguntamos: nodo == null ( o no existe ) ? */
		if (raiz == null)
			raiz = nodo;
		else
			if (nodo.getValor() <= raiz.getValor())
				addNodo(nodo, raiz.getLeft());
			else 
				addNodoBinario(nodo, raiz.getRight());
	}

	public void addNodoBinario( NodoBinario NodoBinario ) {
		this.addNodoBinario( NodoBinario , this.raiz );
	}

	public boolean removeNodoBinario( NodoBinario NodoBinario ) {

		/* Creamos variables para saber si tiene hijos izquierdo y derecho */
		boolean tieneNodoBinarioDerecha = NodoBinario.getHojaDerecha() != null ? true : false;
		boolean tieneNodoBinarioIzquierda = NodoBinario.getHojaIzquierda() != null ? true : false;

		/* Verificamos los 3 casos diferentes y llamamos a la función correspondiente */

		/* Caso 1: No tiene hijos */
		if (!tieneNodoBinarioDerecha && !tieneNodoBinarioIzquierda) {
			return removeNodoBinarioCaso1( NodoBinario );
		}

		/* Caso 2: Tiene un hijo y el otro no */
		if ( tieneNodoBinarioDerecha && !tieneNodoBinarioIzquierda ) {
			return removeNodoBinarioCaso2( NodoBinario );
		}

		/* Caso 2: Tiene un hijo y el otro no */
		if ( !tieneNodoBinarioDerecha && tieneNodoBinarioIzquierda ) {
			return removeNodoBinarioCaso2( NodoBinario );
		}

		/* Caso 3: Tiene ambos hijos */
		if ( tieneNodoBinarioDerecha && tieneNodoBinarioIzquierda ) {
			return removeNodoBinarioCaso3( NodoBinario );
		}

		return false;
	}

	private boolean removeNodoBinarioCaso1( NodoBinario NodoBinario ) {
		/* lo único que hay que hacer es borrar el NodoBinario y establecer el apuntador de su padre a nulo */

		/*
		 * Guardemos los hijos del padre temporalmente para saber cuál de sus hijos hay que 
		 * eliminar
		 */
		NodoBinario hijoIzquierdo = NodoBinario.getPadre().getHojaIzquierda();
		NodoBinario hijoDerecho = NodoBinario.getPadre().getHojaDerecha();

		if ( hijoIzquierdo == NodoBinario ) {
			NodoBinario.getPadre().setHojaIzquierda( null );
			return true;
		}

		if ( hijoDerecho == NodoBinario) {
			NodoBinario.getPadre().setHojaDerecha( null );
			return true;
		}

		return false;
	}

	private boolean removeNodoBinarioCaso2( NodoBinario NodoBinario ) {
		/* Borrar el NodoBinario y el subárbol que tenía pasa a ocupar su lugar */

		/*
		 * Guardemos los hijos del padre temporalmente para saber cuál de sus hijos hay que 
		 * eliminar
		 */
		NodoBinario hijoIzquierdo = NodoBinario.getPadre().getHojaIzquierda();
		NodoBinario hijoDerecho = NodoBinario.getPadre().getHojaDerecha();

		/*
		 * Buscamos el hijo existente del NodoBinario que queremos eliminar
		 */
		NodoBinario hijoActual = NodoBinario.getHojaIzquierda() != null ? 
				NodoBinario.getHojaIzquierda() : NodoBinario.getHojaDerecha();

		if ( hijoIzquierdo == NodoBinario ) {
			NodoBinario.getPadre().setHojaIzquierda( hijoActual );

			/* Eliminando todas las referencias hacia el NodoBinario */
			hijoActual.setPadre(NodoBinario.getPadre());
			NodoBinario.setHojaDerecha(null);
			NodoBinario.setHojaIzquierda(null);

			return true;
		}

		if ( hijoDerecho == NodoBinario) {
			NodoBinario.getPadre().setHojaDerecha( hijoActual );

			/* Eliminando todas las referencias hacia el NodoBinario */
			hijoActual.setPadre(NodoBinario.getPadre());
			NodoBinario.setHojaDerecha(null);
			NodoBinario.setHojaIzquierda(null);

			return true;
		} 

		return false;
	}

	private boolean removeNodoBinarioCaso3( NodoBinario NodoBinario ) {
		/* Tomar el hijo derecho del NodoBinario que queremos eliminar */
		NodoBinario NodoBinarioMasALaIzquierda = recorrerIzquierda( NodoBinario.getHojaDerecha() );
		if ( NodoBinarioMasALaIzquierda != null ) {
			/*
			 * Reemplazamos el valor del NodoBinario que queremos eliminar por el NodoBinario que encontramos 
			 */
			NodoBinario.setValor( NodoBinarioMasALaIzquierda.getValor() );
			/* 
			 * Eliminar este NodoBinario de las formas que conocemos ( caso 1, caso 2 ) 
			 */
			removeNodoBinario( NodoBinarioMasALaIzquierda );
			return true;
		}
		return false;
	}

	/* Recorrer de forma recursiva hasta encontrar el NodoBinario más a la izquierda */
	private NodoBinario recorrerIzquierda(NodoBinario NodoBinario) {
		if (NodoBinario.getHojaIzquierda() != null) {
			return recorrerIzquierda( NodoBinario.getHojaIzquierda() );
		}
		return NodoBinario;
	}

}