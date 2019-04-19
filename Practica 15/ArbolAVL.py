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
				self.raiz.delete(numero)
			else:
				print("No existe ese valor -_-\n")


