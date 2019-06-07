from NodoBinario import *

class ArbolAVL():
	"""
	Clase Arbol AVL
	AVL es un arbol binario ordenado balanceado y Equilibrado
	"""

	def ArbolAVL(self, dato):
		self.__root = NodoBinario(dato)

	//Añadir un nodo al árbol, de forma ordenada
	 boolean add(int inf) {
	if ((root = add(inf, root)) != null) return true;
	return false;
	}

	//Añadir un nodo al árbol (recursividad)
	private Node add(int inf, Node root) {
	if (root == null) return (root = new Node(inf));
	else if (inf < root.getInf()) root.setLeft(add(inf, root.getLeft()));
	else if (inf > root.getInf()) root.setRight(add(inf, root.getRight()));
	else if (inf == root.getInf()) {root.addCant(); return root;}
	root.updateFB(inf); //Actualiza Factor de Equilibrio

	//Equiilibrio
	if (root.getFB() == -2) {
	if (root.getLeft().getFB() == 1) root.setLeft(LeftSimpleRotation(root.getLeft()));
	root = RightSimpleRotation(root);
	}
	else if (root.getFB() == 2) {
	if (root.getRight().getFB() == -1) root.setRight(RightSimpleRotation(root.getRight()));
	root = LeftSimpleRotation(root);
	}
	return root;
	}

	//Rotación Derecha Simple
	private Node RightSimpleRotation(Node root) {
	Node aux = root.getLeft();
	root.setLeft(aux.getRight());
	aux.setRight(root);
	root.updateFB();
	aux.updateFB();
	//System.out.println("Rotacion Derecha");
	return aux;
	}

	//Rotación Izquierda Simple
	private Node LeftSimpleRotation(Node root) {
	Node aux = root.getRight();
	root.setRight(aux.getLeft());
	aux.setLeft(root);
	root.updateFB();
	aux.updateFB();
	//System.out.println("Rotacion Izquierda");
	return aux;
	}

	//Eliminar un nodo del árbol
	 boolean delete(int inf) {
	if (!contains(inf)) return false;

	root = delete(inf, root);
	return true;
	}

	//Eliminar (recursividad)
	private Node delete(int inf, Node root) {
	if (inf < root.getInf() && root.getLeft() != null) root.setLeft(delete(inf, root.getLeft()));
	else if (inf > root.getInf() && root.getRight() != null) root.setRight(delete(inf, root.getRight()));
	else if (inf == root.getInf()) {
	if (root.getLeft() == null && root.getRight() == null) root = null; //Sin hijos
	else if (root.getLeft() != null && root.getRight() != null) { //Dos hijos
	//Búsqueda del menor de los mayores
	Node aux = root.getRight();
	while (aux.getLeft() != null) aux = aux.getLeft();

	//Elimina el ciclo creado
	Node aux2 = root.getRight();
	do {
	  if (aux2.getLeft() == aux) aux2.setLeft(aux.getRight());
	  aux2 = aux2.getLeft();
	} while (aux2 != null);

	aux.setLeft(root.getLeft());
	if (aux != root.getRight()) aux.setRight(root.getRight());
	root = aux;
	}
	else { //Un hijo
	if (root.getLeft() != null) root = root.getLeft();
	else root = root.getRight();
	}
	}
	return root;
	}

	//Existencia de un nodo (retorna verdader o falso)
	 boolean contains(int inf) {
	return (binarySearch(inf) != null);
	}

	//Búsqueda Binaria (retorna nodo)
	 Node binarySearch(int inf) {
	return binarySearch(inf, root);
	}

	//Búsqueda Binaria (recursividad)
	private Node binarySearch(int inf, Node root) {
	if (root == null) return null;
	else if (inf < root.getInf()) return binarySearch(inf, root.getLeft());
	else if (inf > root.getInf()) return binarySearch(inf, root.getRight());
	return root;
	}

	//Imprime todos los nodos del árbol
	 String listTreePreOrder() {
	if (root == null) return "\nEmpty tree.";
	return (root.listPreOrder().toString() + "\n");
	}

	 String listTreeInOrder() {
	if (root == null) return "\nEmpty tree.";
	return (root.listInOrder().toString() + "\n");
	}

	 String listTreePostOrder() {
	if (root == null) return "\nEmpty tree.";
	return (root.listPostOrder().toString() + "\n");
	}

