import java.util.Scanner;

public class AplicaLista
{
	public static void main(String[] args)
	{
		Scanner dato = new Scanner(System.in);
		int opc;
		Lista uno = new Lista();
		
		do
		{
			System.out.println("1.Insertar\n2.Mostrar\n3.Salir");
			System.out.print("\nOpcion...");
			opc = dato.nextInt();
			switch(opc)
			{
				case 1: System.out.println("\nDato: ");
					    int d = dato.nextInt();
					    uno.inserta(d);
					    break;
				case 2: uno.mostrar();
					    break;
			}
		} while (opc!=3);
		dato.close();
	}
}
