package avl;
	public class Nodo {
	int llave;
	int balance;
	int rotacion;
	Nodo izquierda;
	Nodo derecha;
	Nodo AsociacionABB;
	String Titulo,Descripcion,Path;

	/**
	 * Constructor
	 */
	public Nodo(){
		llave = 0;
		balance = 0;
		rotacion = 0;
		izquierda = null;
		derecha = null;
		AsociacionABB = null;
		Titulo = "";
		Descripcion = "";
		Path = "";
	}

	/**
	 * Metodos
	 */
	public void Cambiar_Balance(int balance){
		this.balance = balance;
	}
	public void Cambiar_llave(int llave){
		this.llave = llave;
	}
	public void Cambiar_izquierda(Nodo izquierda){
		this.izquierda = izquierda;
	}
	public void Cambiar_derecha(Nodo derecha){
		this.derecha = derecha;
	}
	 public void Cambiar_Titulo(String Titulo){
		this.Titulo = Titulo;
	}
	  public void Cambiar_Descripcion(String Descripcion){
		this.Descripcion = Descripcion;
	}
	   public void Cambiar_Path(String Path){
		this.Path = Path;
	}
		public void Cambiar_AsociacionABB(Nodo AsociacionABB){
		this.AsociacionABB = AsociacionABB;
	}
}
