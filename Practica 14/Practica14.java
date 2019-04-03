import java.util.Scanner;
public class Practica14{
	public static void main(String[] args) {
		int opcion,dato;
		Practica14 m = new Practica14();
		Scanner sc = new Scanner(System.in);
		Arbol arbol = new Arbol();
		do{
			System.out.println ("\tPrograma de Arboles\n");
			System.out.println ("<---------------------------->");
			System.out.println ("1) Agregar Datos");
			System.out.println ("2) Eliminar Datos");
			System.out.println ("3) Mostrar por Orden");
			System.out.println ("4) Mostrar Pos Orden");
			System.out.println ("5) Mostrar Pre Orden");
			System.out.println ("<---------------------------->");
			System.out.print ("0) Salir\n->");
			opcion = sc.nextInt();
			if (opcion == 1){
				System.out.println("Ingrese Un Dato");
				dato = sc.nextInt();
				arbol.insertar(dato);
			}else if (opcion == 2) m.eliminar(arbol);
				else if(opcion == 3) arbol.imprimirEnOrden();
				else if (opcion == 4)arbol.imprimirPosOrden();
				else if (opcion == 5) arbol.imprimirPreOrden();
				else if (opcion == 0) break;
				else if (opcion >5)
					System.out.println("Opcion Incorreta\n Intente de Nuevo");
		}while(opcion != 0);
	}

	public void eliminar(Arbol arbol){
		Scanner sc = new Scanner(System.in);
		int dato ;
		arbol.imprimirEnOrden();
		System.out.println("Ingrese Un Dato a Eliminar");
		dato = sc.nextInt();
		if(arbol.eliminar(dato))
			System.out.println("Dato Eliminado");
		else
			System.out.println("No existe ese dato");
	}
}
