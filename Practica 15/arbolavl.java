import java.util.Comparator;

/**
 * Clase para trabajar con  binarios de busqueda balanceados, llamados AVL
 * @author Amparo Lopez Gaona
 * @version 1a. ed.
 */   
public class ArbolAvl implements ArbolBuscable {
    private NodoAvl raiz;            // Nodo raiz del arbol
    private Comparator cmp;          // Comparador 
    private int nNodos;              //
    /**
     * Constructor a partir de un comparador
     * @param Comparator para establecer relacion de orden entre nodos
     */
    public ArbolAvl(Comparator c) {
	raiz = null;
	cmp = c;
	nNodos = 0;
    }

    /**
     * Metodo para dejar vacio un arbol 
     */
    public void vaciar() {
	raiz = null;
    }

    /**
     * Metodo para determinar si un arbol esta vacio.
     * @return true -- si el arbol esta vacio y false en otro caso.
     */
    public boolean estaVacio() {
	return raiz == null;
    }

    /**
     * Metodo para conocer el tamano de un arbol
     * @return int -- cantidad de elementos en el arbol
     */
    public int tamanio() {
	return nNodos;
    }

    /**
     * Metodo para imprimir el contenido del arbol en inOrden.
     */
    public void imprimir() {
        if(estaVacio())
            System.out.println("Arbol vacio");
        else
            imprimir(raiz);
		System.out.println();

    }

    /*
     * Metodo auxiliar para la implementacion del algoritmo de inOrden.
     * @param nodo -- la raiz del arbol.
     */
    private void imprimir(NodoAvl nodo) {
        if(nodo != null) {
            imprimir(nodo.izquierda);
	    System.out.print(nodo.valor +":"+nodo.altura+"\t");
            imprimir(nodo.derecha);
        }
    }

    /**
     * Metodo para insertar un nodo en el arbol, ignorando los duplicados y 
     * balanceando  si es necesario.
     * @param dato -- el elemento a insertar.
     */
    public void agregar(Object dato) {
	raiz = agregar(dato, raiz);
    }
    
    /*
     * Metodo interno, auxiliar, para agregar en un arbol.
     * @param dato -- elemento a agregar.
     * @param n -- nodo raiz del arbol.
     * @return NodoAvl -- la nueva raiz.
     */
    private NodoAvl agregar(Object dato, NodoAvl n) {
	if(n == null) {
	    n = new NodoAvl(dato);
	    nNodos ++;
	}
	else if(cmp.compare(dato, n.valor) < 0) {
	    n.izquierda = agregar(dato, n.izquierda);
	    if(altura(n.izquierda) - altura(n.derecha) == 2)
		if(cmp.compare(dato, n.izquierda.valor) < 0)
		    n = rotarIzq(n);
		else {
		    n.izquierda = rotarDer(n.izquierda);
		    n = rotarIzq(n);
		}
	} else if(cmp.compare(dato, n.valor) > 0) {
	    n.derecha = agregar(dato, n.derecha);
	    if(altura(n.derecha) - altura(n.izquierda) == 2)
		if(cmp.compare(dato, n.derecha.valor) > 0)
		    n = rotarDer(n);
		else {
		    n.derecha = rotarIzq(n.derecha);
		    n = rotarDer(n);
		}
	}  else ;  // Encontro un duplicado y no hace nada.

	n.altura = max(altura(n.izquierda), altura(n.derecha)) + 1;
	return n;
    }

    /*
     * Metodo privado para conocer la altura de un nodo
     * @param n -- Nodo del que se desea conocer la altura
     * @return int -- altura del nodo
     */
    private int altura (NodoAvl n) {
	return (n == null) ? -1 : n.altura;
    }


    /**
     * Metodo para rotar a la izquierda
     * @param n -- nodo raiz del subarbol que se va a rotar
     * @return NodoAvl -- Nodo raiz del subarbol despues de la rotacion
     */
    private NodoAvl rotarIzq(NodoAvl n) {
	NodoAvl nraiz = n.izquierda;
	n.izquierda = nraiz.derecha;
	nraiz.derecha = n;
	n.altura = max(altura(n.izquierda), altura(n.derecha)) + 1;
	nraiz.altura = max(altura(nraiz.izquierda), n.altura) + 1;
	return nraiz;
    }

    /**
     * Metodo para rotar a la izquierda
     * @param n -- nodo raiz del subarbol que se va a rotar
     * @return NodoAvl -- Nodo raiz del subarbol despues de la rotacion
     */
    private NodoAvl rotarDer(NodoAvl n) {
	NodoAvl nraiz = n.derecha;
	n.derecha = nraiz.izquierda;
	nraiz.izquierda = n;
	n.altura = max(altura(n.izquierda), altura(n.derecha)) + 1;
	nraiz.altura = max(altura(nraiz.derecha), n.altura) + 1;
	return nraiz;
    }

    /**
     * Metodo para eliminar un elemento del arbol, en caso de no encontrarlo 
     + no hace nada.
     * @param dato el dato a eliminar
     */
    public void eliminar(Object dato) {
    }
    /*
     * Metodo interno para encontrar el menor elemento en un subarbol.
     * @param n -- nodo raiz del arbol.
     * @return NodoAVl - el nodo que contiene el elemento menor.
     */
    public NodoAvl encuentraMin(NodoAvl n) {
        if(n == null)
            return null;
        else if(n.izquierda == null)
            return n;
        return encuentraMin(n.izquierda);
    }

    /**
     * Metodo para encontrar un elemento en el arbol.
     * @param dato -- el dato a buscar.
     * @return boolean -- true si el elemento se encontro o false si no esta.
     */
    public boolean contiene(Object dato) {
	return encontrar(dato, raiz) != null;
    }

    /*
     * Metodo interno para encontrar un elemento en un subarbol
     * @param dato -- elemento buscado.
     * @param n -- raiz del arbol.
     * @return NodoAVL que contiene el elemento encontrado o null si no lo encontro.
      */
    private NodoAvl encontrar(Object dato, NodoAvl n) {
	while(n != null)
	    if(cmp.compare(dato, n.valor) < 0)
		n = n.izquierda;
	    else if(cmp.compare(dato, n.valor) > 0)
		n = n.derecha;
	    else
		return n;    // Lo encontro

	return null;   // No lo encontro.
    } 
}