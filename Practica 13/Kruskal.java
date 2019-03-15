import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/**
 * Clase Kruskal
 */
public class Kruskal {

	static final int MAX = 1005;  //maximo numero de vertices

	///UNION-FIND
	static int padre[] = new int[ MAX ];  //Este arreglo contiene el padre del i-esimo nodo

	//Metodo de inicializacion
	static void MakeSet( int n ){
	    for( int i = 1 ; i <= n ; ++i ) padre[ i ] = i;
	}

	//Metodo para encontrar la raiz del vertice actual X
	static int Find( int x ){
	    return ( x == padre[ x ] ) ? x : ( padre[ x ] = Find( padre[ x ] ) );
	}

	//Metodo para unir 2 componentes conexas
	static void Union( int x , int y ){
	    padre[ Find( x ) ] = Find( y );
	}

	//Metodo que me determina si 2 vertices estan o no en la misma componente conexa
	static boolean sameComponent( int x , int y ){
		if( Find( x ) == Find( y ) ) return true;
		return false;
	}
	///FIN UNION-FIND

	static int V , E;      //numero de vertices y aristas
	//Estructura arista( edge )
	static class Edge implements Comparator<Edge>{
	    int origen;     //Vertice origen
	    int destino;    //Vertice destino
	    int peso;       //Peso entre el vertice origen y destino
	    Edge(){}
	    //Comparador por peso, me servira al momento de ordenar lo realizara en orden ascendente
	    //Ordenar de forma descendente para obtener el arbol de expansion maxima
		@Override
		public int compare(Edge e1 , Edge e2 ) {
			//return e2.peso - e1.peso; //Arbol de expansion maxima
			return e1.peso - e2.peso;   //Arbol de expansion minima
		}
	};
	
	static Edge arista[] = new Edge[ MAX ];      //Arreglo de aristas para el uso en kruskal
	static Edge MST[] = new Edge[ MAX ];     //Arreglo de aristas del MST encontrado

	static void KruskalMST(){
	    int origen , destino , peso;
	    int total = 0;          //Peso total del MST
	    int numAristas = 0;     //Numero de Aristas del MST
	    
	    MakeSet( V );           //Inicializamos cada componente
	    Arrays.sort( arista , 0 , E , new Edge() );    //Ordenamos las aristas por su comparador

	    for( int i = 0 ; i < E ; ++i ){     //Recorremos las aristas ya ordenadas por peso
	        origen = arista[ i ].origen;    //Vertice origen de la arista actual
	        destino = arista[ i ].destino;  //Vertice destino de la arista actual
	        peso = arista[ i ].peso;        //Peso de la arista actual

	        //Verificamos si estan o no en la misma componente conexa
	        if( !sameComponent( origen , destino ) ){  //Evito ciclos
	            total += peso;              //Incremento el peso total del MST
	            MST[ numAristas++ ] = arista[ i ];  //Agrego al MST la arista actual
	            Union( origen , destino );  //Union de ambas componentes en una sola
	        }
	    }

	    //Para saber si contiene o no todos los vertices basta con que el numero
	    //de aristas sea igual al numero de vertices - 1
	    if( V - 1 != numAristas ){
	        System.out.println("el grafo debe ser conexo!!");
	        return;
	    }
	    System.out.printf( "El Arbol recubridor minimo es\n" );
	    for( int i = 0 ; i < numAristas ; ++i )
	        System.out.printf("( %d , %d ) : %d\n" , MST[ i ].origen , MST[ i ].destino , MST[ i ].peso ); //( vertice u , vertice v ) : peso

	    System.out.printf( "El Costo del arbol es : %d\n" , total );
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner( System.in );
		System.out.print("Hola Carro");
		System.out.print( "Total De Vertices :");
		V = sc.nextInt();
		System.out.print( "Total De Aristas :");
		E = sc.nextInt();

	    for( int i = 0 ; i < E ; ++i ){
	        arista[ i ] = new Edge();
	        System.out.print( "Vertice origen :");
	    	arista[ i ].origen = sc.nextInt();
	    	System.out.print( "Vertice Destino :");
	        arista[ i ].destino = sc.nextInt();
	        System.out.print( "Peso :");
	        arista[ i ].peso = sc.nextInt();
	        System.out.println( " ");
	        //arista[ i ] = new Arista( sc.nextInt() , );
	    }
	    KruskalMST();
	}
}
