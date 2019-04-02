from NodoBinario import *
class Arbol():
	def __init__(self):
		self.__raiz = None

	def buscar(self,numero):
		return self.__raiz.buscarNumero(numero)

	def imprimirEnOrden(self):
		if self.__raiz != None:
			self.__raiz.mostrarEnOrden()
			return True
		else:
			print ("No a Creado un arbol")
		return False

	def imprimirPosOrden(self):
		if self.__raiz != None:
			self.__raiz.mostrarPosOrden()
			return True
		else:
			print ("No a Creado un arbol")
		return False

	def imprimirPreOrden(self):
		if (self.__raiz != None):
			self.__raiz.mostrarPreOrden()
			return True
		else:
			print ("No a Creado un arbol")
		return False

	def __insertarRec(self,dato,raiz):
		##Compara con Sub arboles
		if (raiz == None): #No existe el arbol
			raiz = NodoBinario(dato)
		##Para Arboles Ordenados
		elif (dato < raiz.getDato()):
			raiz.setLeft(self.__insertarRec(dato,raiz.getLeft()))
		elif (dato > raiz.getDato()):
			raiz.setRight(self.__insertarRec(dato,raiz.getRight()))
		return raiz

	def insertar(self,dato):
		if (self.__raiz == None):
			self.__raiz = NodoBinario(dato)
		elif (dato < self.__raiz.getDato()):
			self.__raiz.setLeft(self.__insertarRec(dato,self.__raiz.getLeft()))
		elif (dato > self.__raiz.getDato()):
			self.__raiz.setRight(self.__insertarRec(dato,self.__raiz.getRight()))

	def eliminarNodo(self,nodo):
		tieneNodoIzquierda = False
		tieneNodoDerecha = False
		# saber si tiene hijos en la izquierdo y derecha
		if (nodo.getRight() != None):
			tieneNodoDerecha = True
		if (nodo.getLeft() != None):
			tieneNodoIzquierda = True

		#Caso 1: No tiene hijos 
		if (not tieneNodoDerecha and not tieneNodoIzquierda):
			return eliminarCaso1(nodo)
	 
		#Caso 2: Tiene un hijo y el otro no 
		elif (tieneNodoDerecha and not tieneNodoIzquierda):
			return eliminarCaso2(nodo)

		elif(not tieneNodoDerecha and tieneNodoIzquierda):
			return eliminarCaso2(nodo)
	 
		#Caso 3: Tiene ambos hijos
		elif (tieneNodoDerecha and tieneNodoIzquierda):
			return eliminarCaso3(nodo)
		#Si no existe ningun nodo entonces
		return False

	def eliminarCaso1(self,nodo):
		hijoIzquierdo = nodo.getPadre().getLeft()
		hijoDerecho = nodo.getPadre().getRight()

		if ( hijoIzquierdo == nodo ):
			nodo.getPadre().setLeft(None)
			return True

		elif ( hijoDerecho == nodo):
			nodo.getPadre().setRight(None)
			return True
		#si no
		return False
 
	def eliminarCaso2(self,nodo):
		#Cuando tiene subArboles
		hijoIzquierdo = nodo.getPadre().getLeft()
		hijoDerecho = nodo.getPadre().getRight()

		hijoActual = nodo.getLeft()
		if (hijoActual == None):
			hijoActual = nodo.getRight();

		if (hijoIzquierdo == nodo ):
			nodo.getPadre().setLeft(hijoActual)
			#Eliminando todas las referencias hacia el nodo
			hijoActual.setPadre(nodo.getPadre())
			nodo.setRight(None)
			nodo.setLeft(None)
			return True

		if (hijoDerecho == nodo):
			nodo.getPadre().setRight(hijoActual)
			hijoActual.setPadre(nodo.getPadre())
			nodo.setRight(None)
			nodo.setLeft(None)
			return True
		#si no
		return False

	def eliminarCaso3(self,nodo):
		# Tomar el hijo derecho del Nodo que queremos eliminar
		nodoMasALaIzquierda = self.__recorrerIzquierda(nodo.getRight())
		if ( nodoMasALaIzquierda != None ):
			#Reemplazamos el valor del nodo
			#que queremos eliminar por el nodo que encontramos 
			nodo.setDato(nodoMasALaIzquierda.getDato())
			#Eliminar este nodo de las formas que conocemos ( caso 1, caso 2 ) 
			eliminarNodo( nodoMasALaIzquierda)
			return True
		#Si no
		return False

	def __recorrerIzquierda(self,nodo):
		if (nodo.getLeft() != None):
			return recorrerIzquierda(nodo.getLeft())
		return nodo
