from NodoBinario import *
class Arbol():
	def __init__(self):
		self.raiz = None

	def imprimirEnOrden(self):
		if self.raiz != None:
			self.raiz.mostrarEnOrden()
			return True
		else:
			print ("No a Creado un arbol")
		return False

	def imprimirPosOrden(self):
		if self.raiz != None:
			self.raiz.mostrarPosOrden()
			return True
		else:
			print ("No a Creado un arbol")
		return False

	def imprimirPreOrden(self):
		if (self.raiz != None):
			self.raiz.mostrarPreOrden()
			return True
		else:
			print ("No a Creado un arbol")
		return False

	def __insertarRec(self,dato,raiz):
		#Compara con Sub arboles
		if (raiz == None): #No existe el arbol
			raiz = NodoBinario(dato)
		##Para Arboles Ordenados
		elif (dato < raiz.getDato()):
			raiz.setLeft(self.__insertarRec(dato,raiz.getLeft()))
		elif (dato > raiz.getDato()):
			raiz.setRight(self.__insertarRec(dato,raiz.getRight()))
		return raiz

	def insertar(self,dato):
		if (self.raiz == None):
			self.raiz = NodoBinario(dato)
		elif (dato < self.raiz.getDato()):
			self.raiz.setLeft(self.__insertarRec(dato,self.raiz.getLeft()))
		elif (dato > self.raiz.getDato()):
			self.raiz.setRight(self.__insertarRec(dato,self.raiz.getRight()))

	def __buscar(self,numero):
		return  self.__buscarRec(self.raiz,numero)

	def __buscarRec(self,raiz,numero):
		if (raiz.getDato() == numero):
			return raiz
		else:
			if(raiz.getDato() < numero):
				if(raiz.getRight() != None):
					return self.__buscarRec(raiz.getRight(),numero)
			if(raiz.getDato() > numero):
				if(raiz.getLeft() != None):
					return self.__buscarRec(raiz.getLeft(),numero)
		return None

	def __recorrerIzquierda(self,nodo):
		if (nodo.getLeft() != None):
			return recorrerIzquierda(nodo.getLeft())
		return nodo

	def eliminarCaso3(self,nodo):
		# Tomar el hijo derecho del Nodo que queremos eliminar
		nodoMasALaIzquierda = self.__recorrerIzquierda(nodo.getRight())
		if ( nodoMasALaIzquierda != None ):
			#Reemplazamos el valor del nodo
			#que queremos eliminar por el nodo que encontramos 
			nodo.setDato(nodoMasALaIzquierda.getDato())
			#Eliminar este nodo de las formas que conocemos ( caso 1, caso 2 ) 
			self.__eliminarNodo(nodoMasALaIzquierda)
			return True
		#Si no
		return False

	def __eliminarNodo(self,nodo):
		print nodo.getDato()
		tieneNodoIzquierda = False
		tieneNodoDerecha = False
		# saber si tiene hijos en la izquierdo y derecha
		if (nodo.getRight() != None):
			tieneNodoDerecha = True
		if (nodo.getLeft() != None):
			tieneNodoIzquierda = True
		print tieneNodoIzquierda
		print tieneNodoDerecha

		#Caso 1: No tiene hijos 
		if (not tieneNodoDerecha and not tieneNodoIzquierda):
			print "Entra Caso 1"
			nodo = None
			print nodo
 
		#Caso 2: Tiene un hijo y el otro no 
		elif (tieneNodoDerecha and not tieneNodoIzquierda):
			print "Entra Caso 2 Derecha"
			nodo = nodo.getRight()
			print nodo.getDato()

		elif(not tieneNodoDerecha and tieneNodoIzquierda):
			print "Entra Caso 2 Izquierda"
			nodo = nodo.getLeft()
			print nodo.getDato()

		#Caso 3: Tiene ambos hijos
		elif (tieneNodoDerecha and tieneNodoIzquierda):
			print "Entra Caso 3 Recursivo\n"
			return self.eliminarCaso3(nodo)

	def eliminar(self,numero):
		if(self.raiz == None):
			print ("No Existe un Arbol Creado")

		elif(self.raiz.getRight() == None and self.raiz.getLeft() == None ):
			if(self.raiz.getDato() == numero):
				print("Nodo Eliminado\n")
				self.raiz = None
			else:
				print("No existe ese valor -_-\n")

		else:
			if(self.__buscar(numero) != None):
				self.__eliminarNodo(self.__buscar(numero))
			else:
				print("No existe ese valor -_-\n")
