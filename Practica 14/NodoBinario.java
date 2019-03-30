public class NodoBinario{
	private int dato;
	private NodoBinario left;
	private NodoBinario right;
	/**
	 * Constructores
	 */
	 
	public NodoBinario(){
		dato = 0;
		left = null;
		right = null;
	}
	public NodoBinario(int dato){
		this.dato = dato;
		left = new NodoBinario();
		right = new NodoBinario();
	}

	/**
	 * Gets
	 */
	public int getDato(){
		return dato;
	}

	public NodoBinario getLeft(){
		return left;
	}

	public NodoBinario getRight(){
		return right;
	}

	public void setLeft(NodoBinario left){
		this.left = left;
	}

	public void setRight(NodoBinario right){
		this.right = right;
	}

	/**
	 * Mostrar en Pre Orden
	 */
	public void mostrarPreOrden(){
		System.out.println(getDato());

		if (left != null) left.mostrarPreOrden();
		if (right != null) right.mostrarPreOrden();
	}

	/**
	 * Mostrar en Orden
	 */
	public void mostrarEnOrden(){
		if (left != null) left.mostrarEnOrden();

		System.out.println(getDato());
		if (right != null) right.mostrarEnOrden();
	}

	/**
	 * Mostrar en Pos Orden
	 */
	public void mostrarPosOrden(){
		if (left != null) left.mostrarPosOrden();
		if (right != null) right.mostrarPosOrden();
		System.out.println(getDato());
	}
}
