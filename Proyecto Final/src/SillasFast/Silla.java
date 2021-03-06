package SillasFast;
/**
 *
 * @author pace_
 */
public class Silla{
	//Atributos
	static  int contador = 1;
	private final  int ID;
	private String tipo;
	private String material;
	private String resistencia;
	private String marca;
	private String opinion;

	/**
	 * Constructor
	 * @param tipo
	 * @param material
	 * @param resistencia
	 * @param marca
	 * @param opinion 
	 */
	public Silla(String tipo, String material, String resistencia, String marca, String opinion){
		String aux;
		aux = "9"+ material.length()+tipo.length()+contador;
		this.ID = Integer.parseInt(aux);
		this.tipo = tipo;
		this.material = material;
		this.marca = marca;
		this.resistencia = resistencia;
		this.opinion = opinion;
		contador = contador +1;
	}

	public Silla(){
		this.ID = contador + 44;
		contador = contador + 1;
	}

	public Silla(int i){
		this.ID = contador + i + 3;
		contador = contador + 1;
		this.tipo = "nombre"+ID;
	}

	/**
	 * Gets
     * @return 
	 */
    public int getID(){
		return this.ID;
	}
	public String getTipo(){
		return this.tipo;
	}
	public String getMarca(){
		return this.marca;
	}
	public String getMaterial(){
		return this.material;
	}
	public String getResistencia(){
		return this.resistencia;
	}
	public String getOpinion(){
		return this.opinion;
	}
}
