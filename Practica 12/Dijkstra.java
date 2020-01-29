import java.util.*;
 
public class Dijkstra {
    char[]  nodos;  // Letras de identificación de nodo
    int[][] dijkstra;  // Matriz de distancias entre nodos
    String  rutaMasCorta;                           // distancia más corta
    int     longitudMasCorta = Integer.MAX_VALUE;   // ruta más corta
    List<Nodo>  listos = null;                        // nodos revisados dijkstra
 
    // construye el dijkstra con la serie de identificadores de nodo en una cadena
    Dijkstra(String serieNodos) {
        nodos = serieNodos.toCharArray();
        dijkstra = new int[nodos.length][nodos.length];
    }
 
    // asigna el tamaño de la arista entre dos nodos
    public void agregarRuta(char origen, char destino, int distancia) {
        int n1 = posicionNodo(origen);
        int n2 = posicionNodo(destino);        
        dijkstra[n1][n2]=distancia;
        dijkstra[n2][n1]=distancia;
    }
 
    // retorna la posición en el arreglo de un nodo específico
    private int posicionNodo(char nodo) {
        for(int i=0; i<nodos.length; i++) {
            if(nodos[i]==nodo) return i;
        }
        return -1;
    }
     
    // encuentra la ruta más corta desde un nodo origen a un nodo destino
    public String encontrarRutaMinimadijkstra(char inicio, char fin) {
        // calcula la ruta más corta del inicio a los demás
        encontrarRutaMinimadijkstra(inicio);
        // recupera el nodo final de la lista de terminados
        Nodo tmp = new Nodo(fin);
        if(!listos.contains(tmp)) {
            System.out.println("Error, nodo no alcanzable");
            return "Bye";
        }
        tmp = listos.get(listos.indexOf(tmp));
        int distancia = tmp.distancia;  
        // crea una pila para almacenar la ruta desde el nodo final al origen
        Stack<Nodo> pila = new Stack<Nodo>();
        while(tmp != null) {
            pila.add(tmp);
            tmp = tmp.procedencia;
        }
        String ruta = "";
        // recorre la pila para armar la ruta en el orden correcto
        while(!pila.isEmpty()) ruta+=(pila.pop().id + " ");
        return distancia + ": " + ruta;
    }
 
    // encuentra la ruta más corta desde el nodo inicial a todos los demás
    public void encontrarRutaMinimadijkstra(char inicio) {
        Queue<Nodo>   cola = new PriorityQueue<Nodo>(); // cola de prioridad
        Nodo            ni = new Nodo(inicio);          // nodo inicial
         
        listos = new LinkedList<Nodo>();// lista de nodos ya revisados
        cola.add(ni);                   // Agregar nodo inicial a la cola de prioridad
        while(!cola.isEmpty()) {        // mientras que la cola no esta vacia
            Nodo tmp = cola.poll();     // saca el primer elemento
            listos.add(tmp);            // lo manda a la lista de terminados
            int p = posicionNodo(tmp.id);   
            for(int j=0; j<dijkstra[p].length; j++) {  // revisa los nodos hijos del nodo tmp
                if(dijkstra[p][j]==0) continue;        // si no hay conexión no lo evalua
                if(estaTerminado(j)) continue;      // si ya fue agregado a la lista de terminados
                Nodo nod = new Nodo(nodos[j],tmp.distancia+dijkstra[p][j],tmp);
                // si no está en la cola de prioridad, lo agrega
                if(!cola.contains(nod)) {
                    cola.add(nod);
                    continue;
                }
                // si ya está en la cola de prioridad actualiza la distancia menor
                for(Nodo x: cola) {
                    // si la distancia en la cola es mayor que la distancia calculada
                    if(x.id==nod.id && x.distancia > nod.distancia) {
                        cola.remove(x); // remueve el nodo de la cola
                        cola.add(nod);  // agrega el nodo con la nueva distancia
                        break;          // no sigue revisando
                    }
                }
            }
        }
    }
 
    // verifica si un nodo ya está en lista de terminados
    public boolean estaTerminado(int j) {
        Nodo tmp = new Nodo(nodos[j]);
        return listos.contains(tmp);
    }
 
    // encontrar la ruta mínima por fuerza bruta
    public void encontrarRutaMinimaFuerzaBruta(char inicio, char fin) {
        int p1 = posicionNodo(inicio);
        int p2 = posicionNodo(fin);
        // cola para almacenar cada ruta que está siendo evaluada
        Stack<Integer> resultado = new Stack<Integer>();
        resultado.push(p1);
        recorrerRutas(p1, p2, resultado);
    }
 
    // recorre recursivamente las rutas entre un nodo inicial y un nodo final
    // almacenando en una cola cada nodo visitado
    private void recorrerRutas(int nodoI, int nodoF, Stack<Integer> resultado) {
        // si el nodo inicial es igual al final se evalúa la ruta en revisión
        if(nodoI==nodoF) {
            int respuesta = evaluar(resultado);
            if(respuesta < longitudMasCorta) {
                longitudMasCorta = respuesta;
                rutaMasCorta     = "";
                for(int x: resultado) rutaMasCorta+=(nodos[x]+" ");
            }
            return;
        }
        // Si el nodoInicial no es igual al final se crea una lista con todos los nodos
        // adyacentes al nodo inicial que no estén en la ruta en evaluación
        List<Integer> lista = new Vector<Integer>();
        for(int i=0; i<dijkstra.length;i++) {
            if(dijkstra[nodoI][i]!=0 && !resultado.contains(i))lista.add(i);
        }
        // se recorren todas las rutas formadas con los nodos adyacentes al inicial
        for(int nodo: lista) {
            resultado.push(nodo);
            recorrerRutas(nodo, nodoF, resultado);
            resultado.pop();
        }
    }
 
    // evaluar la longitud de una ruta
    public int evaluar(Stack<Integer> resultado) {
        int  resp = 0;
        int[]   r = new int[resultado.size()];
        int     i = 0;
        for(int x: resultado) r[i++]=x;
        for(i=1; i<r.length; i++) resp+=dijkstra[r[i]][r[i-1]];
        return resp;
    }
 
    public static void main(String[] args) {        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("    ~~~ DIJKSTRA ~~~");
        System.out.print(" Número de vertices: ");                
        int nV = sc.nextInt();
        
        String vertices = "";
        
        for (int i = 0; i < nV; i++){            
            vertices = vertices + (i+1);
        }
               
        Dijkstra g = new Dijkstra(vertices);
        
        System.out.print(" Número de aristas: ");
        int nA = sc.nextInt();
        
        for (int a = 0; a<nA; a++){
            System.out.println(" ~~~~~~~~~~~~~~ ");
            System.out.print(" Nodo inicial: ");
            char inicio = sc.next().charAt(0);
            System.out.print(" Nodo final: ");
            char fin = sc.next().charAt(0);
            System.out.print(" Peso: ");
            int peso = sc.nextInt();
            g.agregarRuta(inicio, fin, peso);
        }
        
        char[] dd = vertices.toCharArray();
        
        for (int k=0; k<nV-1; k++) {
            String respuesta = g.encontrarRutaMinimadijkstra(dd[k], dd[k+1]);
            System.out.println(respuesta);
        }                
    }
}