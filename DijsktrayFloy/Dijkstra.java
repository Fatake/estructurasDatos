import java.util.ArrayList;
/**
 * Solucion por matriz de Costos
 */
public class Dijkstra {
    private final static Integer INF = 99999;
    private Integer matrizCostos[][];
    private Integer numeroNodos;
    private Integer nOrigen;

    //
    // Constructor
    //
    public Dijkstra(Integer newMatriz[][], int nodoOrigen){
        System.out.println("Entra Constructor");
        this.matrizCostos  = newMatriz;
        this.numeroNodos   = newMatriz.length;
        this.nOrigen = nodoOrigen;
    }

    public Integer[] dijkstra(){
        System.out.println("Entra a dijksta");
        // S = Cojuto de vertices visitados S inicialmente tiene al origen
        ArrayList<Integer> S = new ArrayList<Integer>();
        S.add(nOrigen);// inicia en Nodo Origen
        
        // Arreglo de las Distancias
        Integer distancia[] = new Integer[numeroNodos];
        //Se obtiene el costo de la distancia del nodo Origen a cada Nodo
        for (int i = 0; i < numeroNodos; i++) {
            distancia[i] = matrizCostos[nOrigen][i];
        }

        // Arreglo del Camino o path
        Integer path[] = new Integer[numeroNodos];
        for (int i = 0; i < path.length; i++) {
            path[i] = nOrigen;//Inicializa todos los caminos con el nodoOrigen
        }

        // Conjunto de los Vertices menos el conjunto de los Visitados
        ArrayList<Integer> VmenosS = new ArrayList<Integer>();
        for (int i = 1; i <= numeroNodos; i++) {
            VmenosS.add(i);
        }
        

        //
        // Inicio de Dijkstra
        //
        for (int i = 0; i < (numeroNodos-1); i++) {
            //Se hace V-S
            VmenosS.removeAll(S);
            // Se elige W en V-S tal que D[W] es minimo
            Integer w = getDistanciaMin(distancia,VmenosS);
           
            //Se Agrega a Los visitados
            S.add(w);

            //Por cada vertice v en V-S
            for (Integer v: VmenosS) {
                //Si la distancia de w mas el costo de v con w es menor 
                //a la distancia de v
                int DmasC = distancia[w] + matrizCostos[w][v-1];
                if (DmasC < distancia[v-1]) {
                    path[v-1] = w;//El camino de v es w
                    distancia[v-1] = DmasC; //La distancia del vertice v es
                    //la distancia de w mas el costo
                }
            }
        }

        return path;
    }

    private Integer getDistanciaMin(Integer[] distancia,ArrayList<Integer> VmenosS ) {
        int menor = INF;
        for (Integer i: VmenosS) {
            if (distancia[i-1] < menor) {
                menor = distancia[i-1];
            }
        }
        return menor;
    }
}