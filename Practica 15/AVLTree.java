//Arbol AVL
public class AVLTree {
  //Nodo del Arbol Binario
  private class Node {
    private int inf;
    private int cant;
    private int FB; //Factor de Equilibrio
    private Node left; //Nodo izquierdo
    private Node right; //Nodo derecho

    //Constructor
    public Node(int inf) {
      this.inf = inf;
      cant = 1;
      left = right = null;
      FB = 0;
    }

    //Actualiza con las alturas de los subárboles (?)
    public void updateFB() {
      int leftHeight = -1;
      int rightHeight = -1;

      if (left != null) leftHeight = left.height();
      if (right != null) rightHeight = right.height();
      FB = rightHeight - leftHeight;
    }

    //Actualiza con referencia a los FB de los subárboles y el valor introducido
    public void updateFB(int inf) {
      if (inf < this.inf) {
        if ((left.getInf() == inf && left.getRight() == null && left.getLeft() == null) || left.getFB() != 0) FB--;
      }
      else if (inf > this.inf) {
        if ((right.getInf() == inf && right.getRight() == null && right.getLeft() == null) || right.getFB() != 0) FB++;
      }
      //System.out.println("\nNodo: " + this.inf + " (FB: " + FB + ")");
    }

    //Calcula la altura desde el nivel 0
    private int height() {
      return height(0);
    }

    //Calcula la altura (recursivo)
    private int height(int level) {
      int levelL = level;
      int levelR = level;
      if (left != null) levelL = left.height(level + 1);
      if (right != null) levelR = right.height(level + 1);

      return (levelL > levelR ? levelL : levelR);
    }

    //Muestra en PreOrden
    public StringBuffer listPreOrder() {
      StringBuffer list = new StringBuffer();
      list.append("\n" + inf + " (FB : " + FB + ")");
      if (left != null) list.append(left.listPreOrder());
      if (right != null) list.append(right.listPreOrder());
      return list;
    }

    //Muestra en Orden
    public StringBuffer listInOrder() {
      StringBuffer list = new StringBuffer();
      if (left != null) list.append(left.listInOrder());
      //list.append("\n" + inf + " (FB : " + FB + ")");
      for (int i = 0; i < cant; i++) list.append("\n" + inf);
      if (right != null) list.append(right.listInOrder());
      return list;
    }

    //Muestra en PostOrden
    public StringBuffer listPostOrder() {
      StringBuffer list = new StringBuffer();
      if (left != null) list.append(left.listPostOrder());
      if (right != null) list.append(right.listPostOrder());
      list.append("\n" + inf + " (FB : " + FB + ")");
      return list;
    }

    public void setLeft(Node node) {
      left = node;
    }

    public void setRight(Node node) {
      right = node;
    }

    public void setFB(int value) {
      FB = value;
    }

    public void addCant() {
      cant++;
    }

    public int getInf() {
      return inf;
    }

    public Node getLeft() {
      return left;
    }

    public Node getRight() {
      return right;
    }

    public int getFB() {
      return FB;
    }
  }

  private Node root; //Raíz del árbol

  //Constructor sin datos
  public AVLTree() {
    root = null;
  }

  //Constructor con información en la raíz
  public AVLTree(int inf) {
    root = new Node(inf);
  }

  //Añadir un nodo al árbol, de forma ordenada
  public boolean add(int inf) {
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
  public boolean delete(int inf) {
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
  public boolean contains(int inf) {
    return (binarySearch(inf) != null);
  }

  //Búsqueda Binaria (retorna nodo)
  public Node binarySearch(int inf) {
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
  public String listTreePreOrder() {
    if (root == null) return "\nEmpty tree.";
    return (root.listPreOrder().toString() + "\n");
  }

  public String listTreeInOrder() {
    if (root == null) return "\nEmpty tree.";
    return (root.listInOrder().toString() + "\n");
  }

  public String listTreePostOrder() {
    if (root == null) return "\nEmpty tree.";
    return (root.listPostOrder().toString() + "\n");
  }
}
