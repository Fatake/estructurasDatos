import java.util.Scanner;

public class Inserccion{
	/**
	 * Main
	 */
	public static void main(String[] args){
		Scanner dato = new Scanner(System.in);
		int opc = 1;
		Inserccion aux = new Inserccion();
		ListaLigada lista = new ListaLigada();
		float d;
		do{
			System.out.println("Programa de inserccion ordenada");
			System.out.println("<-------------------->");
			System.out.println("1.Insertar");
			System.out.println("2.Borrar");
			System.out.println("3.Mostrar");
			System.out.println("<-------------------->");
			System.out.println("0.Salir");
			System.out.print("\n->");
			opc = dato.nextInt();
			switch(opc){
				case 1:
					aux.clear();
					System.out.print("\nIngrese un dato\n->");
					d = dato.nextFloat();
					lista.inserta(d);
					break;
				case 2:
					aux.clear();
					lista.mostrar();
					System.out.println("\n<-------------------->");
					System.out.print("\nIngrese un dato\n->");
					d = dato.nextFloat();
					if(lista.eliminar(d)){
						System.out.println("\nSe a eliminado n.n");
					}else System.out.println("\nNo existe -.-");
					break;
				case 3:
					aux.clear();
					lista.mostrar();
				break;
			}
		} while (opc!=0);
		dato.close();
	}
	/**
	 * Limpia
	 */
	private void clear(){
		System.out.print("\u001b[2J");
		System.out.flush();
	}
}
