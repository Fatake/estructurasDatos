package avl;
import java.util.LinkedList;

public class Arbol {
    private Nodo raiz;
    private Nodo Aux;
    private boolean rotacion=false;
    private boolean aumento=false;
    private boolean borrado=false;
    private boolean apuntado=false;
    private boolean apuntado2=false;
    private boolean buscar=false;
    private int UltimaPosicionCadenaInterna=0;//para la comparacion de cadenas
    private boolean CadenaAceptada=false; // para la comparacion de cadenas
    private LinkedList<Nodo> Lista = new LinkedList<Nodo>();
     private LinkedList<String> grafica = new LinkedList<String>();
    private Nodo Busqueda;
    private Nodo nuevaRaiz;
    public void insertar(int llave,String Titulo,String Descripcion,Nodo AsociacionABB){
        insertar(llave,Titulo,Descripcion,AsociacionABB,raiz);
    }
    private Nodo insertar(int n,String Titulo,String Descripcion,Nodo AsociacionABB,Nodo A){
        if(A==null){
            A = new Nodo();
            if(raiz==null){
            raiz = A;
            }
            A.Cambiar_llave(n);
            A.Cambiar_Balance(0);
            A.Cambiar_Titulo(Titulo);
            A.Cambiar_Descripcion(Descripcion);
            A.Cambiar_AsociacionABB(AsociacionABB);
            return A;
        }
        else{
            if(n<A.llave)
            {
                if(A.izquierda==null){
                    A.balance--;
                    aumento = (A.balance!=0);
                     A.izquierda=insertar(n,Titulo,Descripcion,AsociacionABB,A.izquierda);
                }
                else
                {
                    insertar(n,Titulo,Descripcion,AsociacionABB,A.izquierda);
                    if(aumento){
                        if(rotacion!=true){  
                            A.balance--;
                            aumento=(A.balance!=0);
                        }
                    }
                    if(nuevaRaiz!=null && nuevaRaiz.hashCode()!=raiz.hashCode())
                    {
                        A.izquierda=nuevaRaiz;
                        nuevaRaiz=null;
                        rotacion=false;
                    } 
                    if(A.balance<-1)
                    {
                      if(A.izquierda.balance>0)
                      {
                          if(raiz.hashCode()!=A.hashCode()){ID(A);aumento=false;return null;}
                          else{raiz=ID(A);aumento=false;rotacion=false;return null;}
                          
                      }
                      else
                      {
                          if(raiz.hashCode()!=A.hashCode()){II(A);aumento=false;return null;}
                          else{raiz=II(A);aumento=false;rotacion=false;return null;}
                          
                      }
                  }
               }
            }
            else
            {
                if(A.derecha==null)
                {
                    A.balance++;
                    aumento = (A.balance!=0);
                    A.derecha=insertar(n,Titulo,Descripcion,AsociacionABB,A.derecha);
                }
                else
                {
                    insertar(n,Titulo,Descripcion,AsociacionABB,A.derecha);
                    if(aumento){
                        if(rotacion!=true){
                            A.balance++;
                            aumento=(A.balance!=0);
                        }
                    }
                    if(nuevaRaiz!=null && nuevaRaiz.hashCode()!=raiz.hashCode())
                    {
                        A.derecha=nuevaRaiz;
                        nuevaRaiz=null;
                        rotacion=false;
                    }
                   if(A.balance>1)
                   {
                       if(A.derecha.balance<0)
                       {
                           if(raiz.hashCode()!=A.hashCode()){DI(A);aumento=false;return null;}
                           else{raiz=DI(A);aumento=false;rotacion=false;return null;}
                       }
                       else
                       {
                           if(raiz.hashCode()!=A.hashCode()){DD(A);aumento=false;return null;}
                                else{raiz=DD(A);aumento=false;rotacion=false;return null;}
                       }
                   }
                }
            }
        }
        return null;
    }
    public Nodo RetornarRaiz(){
        return raiz;
    }
    // rotaciones
    //rotacion izquierda izquierda
    private Nodo II(Nodo A){
        rotacion=true;
        Nodo aux = A.izquierda.derecha;
        A.izquierda.derecha=A;
        if(aux==null){
           if(A.derecha!=null)A.izquierda.balance++;
           if(A.derecha==null)A.izquierda.balance=0;
        }
        else{
           if(A.derecha!=null)A.izquierda.balance=0;
           if(A.derecha==null)A.izquierda.balance++;
               }
       
        Nodo aux2 = A.izquierda;
        A.izquierda=aux;
        if(aux==null){
            if(A.derecha!=null)A.balance++;
            if(A.derecha==null)A.balance=0;
        }
        else{
            if(A.derecha!=null)A.balance=0;
            if(A.derecha==null)A.balance--;
           }
         nuevaRaiz=aux2;
         aux2.rotacion=10;
        return aux2;
    }
    //rotacion derecha derecha
    private Nodo DD(Nodo A){
        rotacion=true;
        Nodo aux = A.derecha.izquierda;
        A.derecha.izquierda = A;
        if(aux==null){
            if(A.izquierda!=null)A.derecha.balance--;
            if(A.izquierda==null)A.derecha.balance=0;}
        else{
            if(A.izquierda!=null)A.derecha.balance=0;
            if(A.izquierda==null)A.derecha.balance--;
            
        }
      
        Nodo aux2 = A.derecha;
        A.derecha = aux;
        if(aux==null){
            if(A.izquierda!=null)A.balance--;
            if(A.izquierda==null)A.balance=0;
        }
        else{
          if(A.izquierda!=null)A.balance=0; 
          if(A.izquierda==null)A.balance++;
            
            /*else{
                A.balance=1;
            }*/
        }
        
        nuevaRaiz=aux2;
        aux2.rotacion=11;
        return aux2;
        
        
    }
    //rotacion izquierda derecha
    private Nodo ID(Nodo A){
      A.izquierda=DD(A.izquierda);
        return II(A);
    }
    //rotacion derecha izquierda
    private Nodo DI(Nodo A){
        A.derecha=II(A.derecha);
        return DD(A);
    }
    //buscar
    public Nodo Buscar(int llave){//buscar por llave
        return Buscar(llave,raiz);
    } //busqueda por llave
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
    private Nodo Buscar(int llave,Nodo A){//busqueda interna por llave
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
        }else{
            Busqueda=null;}
      return Busqueda;
       
    }//busque interna por llave
    public void eliminar(int llave){
        eliminar(llave,raiz);
    }
    private void eliminar(int llave,Nodo A){
        if(raiz.izquierda!=null || raiz.derecha!=null){
        if(A!=null){
            if(A.llave<llave){
                eliminar(llave,A.derecha);
                if(nuevaRaiz!=null && nuevaRaiz.hashCode()!=raiz.hashCode())
                {
                    A.izquierda=nuevaRaiz;
                    nuevaRaiz=null;
                }
                if(borrado==true){
                    A.balance--;
                    rotarBorrado(A);
                    borrado=(A.balance==0);
                }
                if(apuntado==true){
                    A.derecha=Aux;
                    apuntado=false;
                }
            }else{
                if(A.llave>llave){
                    eliminar(llave,A.izquierda);
                    if(nuevaRaiz!=null && nuevaRaiz.hashCode()!=raiz.hashCode())
                    {
                        A.izquierda=nuevaRaiz;
                        nuevaRaiz=null;
                    }
                    if(borrado==true){
                        A.balance++;
                        rotarBorrado(A);
                        borrado=(A.balance==0);
                    }
                    if(apuntado==true){
                        A.izquierda=Aux;
                        apuntado=false;
                    }
                }else{
                    if(A.llave==llave){
                        borrado=true;
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
        }
        else{
           raiz=null; 
        }
    }
    private Nodo Aux2;
    private Nodo Reemplazar(Nodo A,Nodo buscado,boolean estado){
     if(estado==true){
         Reemplazar(A.izquierda,buscado,false);
         if(nuevaRaiz!=null && nuevaRaiz.hashCode()!=raiz.hashCode())
         {
           A.izquierda=nuevaRaiz;
           nuevaRaiz=null;
         }
         if(buscado.hashCode()==raiz.hashCode()){
              raiz=Aux2;
         }
         if(Aux2.hashCode()!=buscado.izquierda.hashCode()){
            Aux2.izquierda=buscado.izquierda; buscado.izquierda=null;
         }else{buscado.izquierda=null;}
         Aux2.derecha = buscado.derecha;   buscado.derecha=null;
         if(borrado==true){
             Aux2.balance++;
             rotarBorrado(Aux2);
             borrado=(Aux2.balance==0);
         }
     }else{
        if(A.derecha==null){
            Aux2=A;
            borrado=true;
            apuntado2=true;
        }else{ 
            Reemplazar(A.derecha,buscado,estado);
            if(nuevaRaiz!=null && nuevaRaiz.hashCode()!=raiz.hashCode())
            {
                A.derecha=nuevaRaiz;
                nuevaRaiz=null;
            } 
            if(apuntado2==true){
                A.derecha=Aux2.izquierda;
                apuntado2=false;
            }
            if(borrado==true){
                A.balance--;
                rotarBorrado(A);
                borrado=(A.balance==0);
            }
      }
     }
      //if(A.derecha!=null)Aux2=null;
      return Aux2;
     }
    private boolean rotarBorrado(Nodo A){
        if(A.balance<-1)
        {
                      if(A.izquierda.balance>0)
                      {
                          if(raiz.hashCode()!=A.hashCode()){ID(A);borrado=false;return true;}
                          else{raiz=ID(A);borrado=false;return true;}
                          
                      }
                      else
                      {
                          if(raiz.hashCode()!=A.hashCode()){II(A);borrado=false;return true;}
                          else{raiz=II(A);borrado=false;return true;}
                          
                      }
         }
        else{
             if(A.balance>1)
                   {
                       if(A.derecha.balance<0)
                       {
                           if(raiz.hashCode()!=A.hashCode()){DI(A);borrado=false;return true;}
                           else{raiz=DI(A);borrado=false;return true;}
                       }
                       else
                       {
                           if(raiz.hashCode()!=A.hashCode()){DD(A);borrado=false;return true;}
                                else{raiz=DD(A);aumento=false;borrado=false;return true;}
                       }
                   }
        }
        return false;
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
