/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package avl;

import java.util.Iterator;

/**
 *
 * @author beto
 */
public class Noticias {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        //ArbolABB Arbol = new ArbolABB();
        int [] lista = {100,29,71,82,48,39,101,22,46,17,3,20,25,10};
        String [] lista1 = {"mario","carlos","alberto","Tulio","Senia","Charley mario","Humberto","Fredy","Alfaro","Karen","Carolina","Jimena","Carmela","Natalie"};
        //int [] lista = {1,2,3,4,5,6,7,15,14,13};
        for(int i=0;i<lista.length;i++){
           
           arbol.insertar(lista[i],lista1[i],"",null);
        }
        Iterator it = arbol.graficar().iterator();
        while(it.hasNext()){
            String h = (String)it.next();
            System.out.println(h);
        }
        
        
         
        if(arbol.RetornarRaiz()!=null){
        Nodo dato =arbol.RetornarRaiz();
        System.out.println(dato.llave);
        System.out.println(dato.balance);
        
        
        }
        
        
        
    }
}
