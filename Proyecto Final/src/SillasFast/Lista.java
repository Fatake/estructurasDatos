package SillasFast;
/**
 * Clase TablaHash
 * @author Fatake
 */
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
        
        public Silla buscar(int ID){
		Nodo temp = inicio;
		while (temp != null){
			if(temp.getDato().getID() == ID)
                            return temp.getDato();
			temp = temp.sig;
		}
             return null;
	}
        
        public boolean getVacio(){
            if (inicio == null)
                return true;
            return false;
        }
}
