public class NodoBinario{

	private int valor;
	private NodoBinario padre;
	private NodoBinario left;
	private NodoBinario right;

	/**
	 * Constructor
	 */
	public NodoBinario(int valor) {
		this.valor = valor;
	}

	/**
	 * Gets
	 */
	public int getValor(){
		return valor;
	}

	public NodoBinario getPadre(){
		return padre;
	}

	public NodoBinario getLeft(){
		return left;
	}

	public NodoBinario getRight(){
		return right;
	}

	/**
	 * Sets
	 */
	public void setValor(int valor){
		this.valor = valor;
	}

	public void setPadre(NodoBinario padre){
		this.padre = padre;
	}

	public void setLeft(NodoBinario left){
		this.left = left;
	}

	public void setRight(NodoBinario right){
		this.right = right;
	}

	/**
	 * Funciones
	 */
	public void mostrarPreOrden(){
		System.out.println (getValor());
		if (left != null)
			left.mostrarPreOrden();
		if(right != null)
			right.mostrarPreOrden();
	}

	public void mostrarEnOrden(){
		if(left != null)
			left.mostrarEnOrden();
		System.out.println (getValor());
		if(right != null)
			right.mostrarEnOrden();
	}

	public void mostrarPosOrden(){
		if(left != null)
			left.mostrarPosOrden();
		if(right != null)
			right.mostrarPosOrden();
		System.out.println (getValor());
	}
}
