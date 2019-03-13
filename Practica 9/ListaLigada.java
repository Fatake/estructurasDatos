public class ListaLigada{
	
	//
	//Clase Nodo
	//
	private class Nodo{
		//Datos
		private float dato;
		private Nodo sig;
		/**
		 * Constructor
		 */
		public Nodo(float dato){
			this.dato = dato;
			sig = null;
		}
		/**
		 * Retorna el siguiente
		 */
		public float getDato(){
			return dato;
		}
	}
	
	private Nodo inicio;
	private Nodo ultimo;
	/**
	 * Constructor
	 */
	public ListaLigada(){
		inicio = null;
		ultimo = null;
	}
	/**
	 * Inserta
	 */
	public void inserta(float dato){
		Nodo nuevo = new Nodo(dato);
		nuevo.sig = null;
		
		if (inicio == null) inicio = nuevo;
		else{
			if(inicio.getDato() > dato){
				nuevo.sig = inicio;
				inicio = nuevo;
			}else{
				Nodo aux = inicio;
				Nodo aux1 = inicio.sig;
				while(aux1 != null && aux1.getDato() < dato){
					aux = aux1;
					aux1 = aux1.sig;
				}
				aux.sig = nuevo;
				nuevo.sig = aux1;
			}
		}
	}
	/**
	 * Eliminar
	 */
	public boolean eliminar(float dato){
		Nodo aux;
		Nodo aux1;
		if(inicio == null) return false;
		else{
			if(inicio.getDato() == dato){
				inicio = inicio.sig;
			}else{
				aux = inicio;
				aux1 = inicio.sig;
				while(aux1 != null && aux1.getDato() != dato){
					aux = aux1;
					aux1 = aux1.sig;
				}
				if(aux1 != null) aux.sig = aux1.sig;
				else
					return false;
			}
		}
		return true;
	}
	/**
	 * Mostrar
	 */
	public void mostrar(){
		Nodo temp = inicio;
		
		while (temp != null){
			System.out.println(temp.getDato());
			temp = temp.sig;
		}
	}
	

}

		

