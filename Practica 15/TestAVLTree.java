import java.util.Scanner;

public class TestAVLTree {
  public static void main (String args[]) {
    AVLTree tree = new AVLTree();

    Scanner sc = new Scanner(System.in);
    String op;
    Integer c;
    do{
        System.out.print("~ ");
        op = sc.next().toUpperCase();
        switch(op){
            case "ADD":
                try{
                    c = new Integer(sc.next());
                    if(!tree.add(c)) System.out.println("\n" + c + " is already in the tree.");;
                }catch(IllegalArgumentException ex){
                    System.err.println(ex);
                }finally{
                    sc.nextLine();
               }
                break;
            case "CONTAINS":
                try{
                    c = new Integer(sc.next());
                    if(tree.contains(c))
                        System.out.println("\nThe list contains: " + c);
                    else
                        System.out.println("\nThe list doesn't contain: " + c);
                }catch(IllegalArgumentException ex){
                    System.err.println(ex);
                }finally{
                    sc.nextLine();
               }
                break;
            case "DELETE":
                try{
                    if(tree.delete(new Integer(sc.next())))
                        System.out.println("Element successfully removed");
                    else
                        System.out.println("The element is not in the tree");
                }catch(IllegalArgumentException ex){
                    System.err.println(ex);
                }finally{
                    sc.nextLine();
                }
                break;
            case "LISTINORDER":
                System.out.println(tree.listTreeInOrder());
                break;
            case "LISTPREORDER":
                System.out.println(tree.listTreePreOrder());
                break;
            case "LISTPOSTORDER":
                System.out.println(tree.listTreePostOrder());
                break;
            case "EXIT":
                break;
            default:
                System.err.println("Comando NO reconocido: " + op);
                System.out.println("Comandos reconocidos: ADD, CONTAINS, DELETE, LISTINORDER, LISTPREORDER, LISTPOSTORDER, EXIT");
                break;
        }
    }while(!op.equals("EXIT"));
  }
}
