import java.util.*;

public class DijkstraAlgorithm {
    
    public static void main(String[] args) {

        int E , origen, destino , peso , inicial, V,opc;

        Scanner sc = new Scanner( System.in );      
        do {
            
            System.out.print("Ingrese el numero de vertices: ");

            V = sc.nextInt();

            System.out.print("Ingrese el numero de aristas: ");

            E = sc.nextInt();

            Dijkstra dijkstraAlgorithm = new Dijkstra(V);
            origen = destino = peso = 0;
            for( int i = 0 ; i < E ; ++i ){

                System.out.print("  Nodo de origen: ");
                origen = sc.nextInt();
                System.out.print("  Nodo de destino: ");
                destino = sc.nextInt();
                System.out.print("  Valor: ");
                peso = sc.nextInt();                       

                dijkstraAlgorithm.addEdge(origen, destino, peso, true);                                
            }                     
            System.out.print("Ingrese el vertice inicial: ");

            inicial = sc.nextInt();

            dijkstraAlgorithm.dijkstra(inicial);

            dijkstraAlgorithm.printShortestPath();
            System.out.print("\n\n    Nuevo Grafo\n 1 <- Si\n 0 <- No\n > ");
            opc = sc.nextInt();
        }while (opc!=0);
    }

}



class Dijkstra{

    

    //similar a los defines de C++

    private final int MAX = 100;  //maximo numero de vértices

    private final int INF = 1<<30;  //definimos un valor grande que represente la distancia infinita inicial, basta conque sea superior al maximo valor del peso en alguna de las aristas

    

    private List< List< Node > > ady = new ArrayList< List< Node > >(); //lista de adyacencia

    private int distancia[ ] = new int[ MAX ];          //distancia[ u ] distancia de vértice inicial a vértice con ID = u

    private boolean visitado[ ] = new boolean[ MAX ];   //para vértices visitados

    private PriorityQueue< Node > Q = new PriorityQueue<Node>(); //priority queue propia de Java, usamos el comparador definido para que el de menor valor este en el tope

    private int V;                                      //numero de vertices

    private int previo[] = new int[ MAX ];              //para la impresion de caminos

    private boolean dijkstraEjecutado;

    

    Dijkstra(int V){

        this.V = V;

        for( int i = 0 ; i <= V ; ++i ) 

            ady.add(new ArrayList<Node>()) ; //inicializamos lista de adyacencia

        dijkstraEjecutado = false;

    }

    

    //En el caso de java usamos una clase que representara el pair de C++

    class Node implements Comparable<Node>{

        int first, second;

        Node( int d , int p ){                          //constructor

            this.first = d;

            this.second = p;

        }

        public int compareTo( Node other){              //es necesario definir un comparador para el correcto funcionamiento del PriorityQueue

            if( second > other.second ) return 1;

            if( second == other.second ) return 0;

            return -1;

        }

    };

    

    //función de inicialización

    private void init(){

        for( int i = 0 ; i <= V ; ++i ){

            distancia[ i ] = INF;  //inicializamos todas las distancias con valor infinito

            visitado[ i ] = false; //inicializamos todos los vértices como no visitados

            previo[ i ] = -1;      //inicializamos el previo del vertice i con -1

        }

    }



    //Paso de relajacion

    private void relajacion( int actual , int adyacente , int peso ){

        //Si la distancia del origen al vertice actual + peso de su arista es menor a la distancia del origen al vertice adyacente

        if( distancia[ actual ] + peso < distancia[ adyacente ] ){

            distancia[ adyacente ] = distancia[ actual ] + peso;  //relajamos el vertice actualizando la distancia

            previo[ adyacente ] = actual;                         //a su vez actualizamos el vertice previo

            Q.add( new Node( adyacente , distancia[ adyacente ] ) ); //agregamos adyacente a la cola de prioridad

        }

    }



    void dijkstra( int inicial ){

        init(); //inicializamos nuestros arreglos

        Q.add( new Node( inicial , 0 ) ); //Insertamos el vértice inicial en la Cola de Prioridad

        distancia[ inicial ] = 0;      //Este paso es importante, inicializamos la distancia del inicial como 0

        int actual , adyacente , peso;

        while( !Q.isEmpty() ){                   //Mientras cola no este vacia

            actual = Q.element().first;            //Obtengo de la cola el nodo con menor peso, en un comienzo será el inicial

            Q.remove();                           //Sacamos el elemento de la cola

            if( visitado[ actual ] ) continue; //Si el vértice actual ya fue visitado entonces sigo sacando elementos de la cola

            visitado[ actual ] = true;         //Marco como visitado el vértice actual



            for( int i = 0 ; i < ady.get( actual ).size() ; ++i ){ //reviso sus adyacentes del vertice actual

                adyacente = ady.get( actual ).get( i ).first;   //id del vertice adyacente

                peso = ady.get( actual ).get( i ).second;        //peso de la arista que une actual con adyacente ( actual , adyacente )

                if( !visitado[ adyacente ] ){        //si el vertice adyacente no fue visitado

                    relajacion( actual , adyacente , peso ); //realizamos el paso de relajacion

                }

            }

        }



        System.out.printf( "Distancias mas cortas iniciando en vertice %d\n" , inicial );

        for( int i = 1 ; i <= V ; ++i ){

            System.out.printf("Vertice %d , distancia mas corta = %d\n" , i , distancia[ i ] );

        }

        dijkstraEjecutado = true;

    }

    

    void addEdge( int origen , int destino , int peso , boolean dirigido ){

        ady.get( origen ).add( new Node( destino , peso ) );    //grafo diridigo

        if( !dirigido )

            ady.get( destino ).add( new Node( origen , peso ) ); //no dirigido

    }

    

    void printShortestPath(){

        if( !dijkstraEjecutado ){

            System.out.println("Es necesario ejecutar el algorithmo de Dijkstra antes de poder imprimir el camino mas corto");

            return;

        }

        Scanner sc = new Scanner( System.in );      //para lectura de datos

        System.out.println("\n**************Impresion de camino mas corto**************");

        System.out.printf("Ingrese vertice destino: ");

        int destino;

        destino = sc.nextInt();

        print( destino );

        System.out.printf("\n");

    }

    

    //Impresion del camino mas corto desde el vertice inicial y final ingresados

    void print( int destino ){

        if( previo[ destino ] != -1 )    //si aun poseo un vertice previo

            print( previo[ destino ] );  //recursivamente sigo explorando

        System.out.printf("%d " , destino );        //terminada la recursion imprimo los vertices recorridos

    }



    public int getNumberOfVertices() {

        return V;

    }



    public void setNumberOfVertices(int numeroDeVertices) {

        V = numeroDeVertices;

    }

}