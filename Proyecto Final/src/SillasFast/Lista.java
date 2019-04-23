public class Lista{
	private Nodo inicio;

	public Lista(){
		inicio = null;
	}

	public void inserta(Silla dato){
		Nodo aux = new Nodo(dato);
		aux.sig = null;

		if (inicio == null)
			inicio = aux;
		else{
			Nodo temp = inicio;
			while (temp.sig != null)
				temp = temp.sig;
			temp.sig = aux;
		}
	}

	public void mostrar(){
		Nodo temp = inicio;
		
		while (temp != null){
			System.out.println(temp.getDato().getMarca());
			temp = temp.sig;
		}
	}
}

//Clase Provada Nodo
private class Nodo{
	//Atributos
	protected Silla info;
	protected Nodo sig;

	/**
	 * Constructor
	 */
	public Nodo (Silla dato){
		info = dato;
		sig = null;
	}

	public Silla getDato(){
		return info;
	}
}

