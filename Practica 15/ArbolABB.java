/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package avl;

import java.util.LinkedList;

/**
 *
 * @author beto
 */
public class ArbolABB {
   private Nodo raiz;
   private Nodo Aux;
   private Nodo Busqueda,Aux2;private boolean apuntado=false,apuntado2=false;
   private LinkedList<Nodo> Lista = new LinkedList<Nodo>();
   private LinkedList<String> grafica = new LinkedList<String>();
   private int UltimaPosicionCadenaInterna=0;//para la comparacion de cadenas
   private boolean CadenaAceptada=false; // para la comparacion de cadenas
    public void insertar(int llave,String Titulo,String Descripcion,String Path){
        insertar(llave,Titulo,Descripcion,Path,raiz);
    }
    private Nodo insertar(int llave,String Titulo,String Descripcion,String Path,Nodo A){
        if(A==null){
            A = new Nodo();
            if(raiz==null){
            raiz = A;
            raiz.Cambiar_llave(llave);
            raiz.Cambiar_Titulo(Titulo);
            raiz.Cambiar_Descripcion(Descripcion);
            raiz.Cambiar_Path(Path);
            }
            A.Cambiar_llave(llave);
            A.Cambiar_Titulo(Titulo);
            A.Cambiar_Descripcion(Descripcion);
            A.Cambiar_Path(Path);
            return A;
        }
        else{
            if(llave<A.llave){
               if(A.izquierda==null){
                   A.izquierda=insertar(llave,Titulo,Descripcion,Path,A.izquierda);
               }
               else{
                   insertar(llave,Titulo,Descripcion,Path,A.izquierda);
               }
            }
            else{
                if(llave>A.llave){
                    if(A.derecha==null){
                        A.derecha=insertar(llave,Titulo,Descripcion,Path,A.derecha);
                    }
                    else{
                        insertar(llave,Titulo,Descripcion,Path,A.derecha);
                    }
                }
            }
        }
        return null;
    }
    public Nodo Buscar(int llave){//llamada al metodos para buscar por clave
        return Buscar(llave,raiz);
    }
    private Nodo Buscar(int llave, Nodo A){//metodo buscar por clave
      if(A!=null){
      if(llave<A.llave){
          Buscar(llave,A.izquierda);
         
      }
      else{
          if(llave>A.llave){
            Buscar(llave,A.derecha);
          }
          else{
              this.Busqueda=A;
              }
      }
      }else{Busqueda=null;}
      return Busqueda;
    }
    public LinkedList<Nodo> Buscar(String Titulo){
        Lista.clear();
         return Buscar(Titulo,raiz);
    }
    private LinkedList<Nodo> Buscar(String Titulo,Nodo A){
        if(A!=null){
        if(ComparacionCadenas(Titulo,A.Titulo,0,0)==true){
            Lista.add(A);
            this.CadenaAceptada=false;
            this.UltimaPosicionCadenaInterna=0;
        }
        Buscar(Titulo,A.izquierda);
        Buscar(Titulo,A.derecha);
        }
        return Lista;
        
    }
    private boolean ComparacionCadenas(String CadenaIngresada,String CadenaInterna,int Ingresada,int Interna ){
        String posicion = CadenaIngresada.substring(Ingresada, Ingresada+1);
        if(posicion.equalsIgnoreCase(CadenaInterna.substring(Interna, Interna+1))){
            if(Ingresada==0)UltimaPosicionCadenaInterna=Interna;
            if(Ingresada<CadenaIngresada.length()-1){
                if(Interna<CadenaInterna.length()-1){
                    ComparacionCadenas(CadenaIngresada,CadenaInterna,Ingresada+1,Interna+1);
                }
            }else CadenaAceptada=true;
        }else{
            if(Ingresada==0){
              if(Interna<CadenaInterna.length()-1)
                ComparacionCadenas(CadenaIngresada,CadenaInterna,0,Interna+1); 
            }
            else{
            if(UltimaPosicionCadenaInterna<CadenaInterna.length()-1)
            ComparacionCadenas(CadenaIngresada,CadenaInterna,0,this.UltimaPosicionCadenaInterna+1);
            }
        }
        return CadenaAceptada;
    }
    
    public void eliminar(int llave){
        eliminar(llave,raiz);
    }
    private void eliminar(int llave,Nodo A){
      if(raiz.izquierda!=null || raiz.derecha!=null){
        if(A!=null){
            if(A.llave<llave){
                eliminar(llave,A.derecha);
                if(apuntado==true){
                    A.derecha=Aux;
                    apuntado=false;
                }
            }else{
                if(A.llave>llave){
                    eliminar(llave,A.izquierda);
                    if(apuntado==true){
                        A.izquierda=Aux;
                        apuntado=false;
                    }
                }else{
                    if(A.llave==llave){
                        apuntado=true;
                        if(A.izquierda == null){
                            Aux = A.derecha;
                        }else{
                            if(A.derecha == null){
                                Aux = A.izquierda;
                            }else{
                                Aux=Reemplazar(A,A,true);                   
                            }
                        }  
                    }
                }
           }
       }
      }else{
          raiz=null;}
    }
    private Nodo Reemplazar(Nodo A,Nodo buscado,boolean estado){
     if(estado==true){
         Reemplazar(A.izquierda,buscado,false);
         if(buscado.hashCode()==raiz.hashCode()){
              raiz=Aux2;
         }
         if(Aux2.hashCode()!=buscado.izquierda.hashCode()){
            Aux2.izquierda=buscado.izquierda; buscado.izquierda=null;
         }else{Aux2.izquierda=null;buscado.izquierda=null;}
         Aux2.derecha = buscado.derecha;   buscado.derecha=null;
        }else{
        if(A.derecha==null){
            Aux2=A;
            apuntado2=true;
        }else{ 
            Reemplazar(A.derecha,buscado,estado);
            if(apuntado2==true){
                A.derecha=Aux2.izquierda;
                apuntado2=false;
            }
         }
     }
      //if(A.derecha!=null)Aux2=null;
      return Aux2;
     }
    public Nodo RetornarRaiz(){
        return raiz;
    }
    public LinkedList<String> graficar(){
        grafica.clear();
        return graficar(raiz);
    }
    private LinkedList<String> graficar(Nodo A){
        if(A!=null){
            if(A.izquierda!=null){
                grafica.add(A.llave+" izquierda "+A.izquierda.llave);
            }
            if(A.derecha!=null){
                grafica.add(A.llave+" derecha "+A.derecha.llave);
            }
            graficar(A.izquierda);
            graficar(A.derecha);
        }
        return grafica;
    }
}
