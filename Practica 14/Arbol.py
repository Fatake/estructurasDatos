from NodoBinario import *
class Arbol():
	def __init__(self):
		self.__raiz = None
	
	def imprimirEnOrden(self):
		if self.__raiz != None:
			self.__raiz.mostrarEnOrden()
		else:
			print ("No a Creado un arbol")

	def imprimirPosOrden(self):
		if self.__raiz != None:
			self.__raiz.mostrarPosOrden()
		else:
			print ("No a Creado un arbol")

	def imprimirPreOrden(self):
		if self.__raiz != None:
			self.__raiz.mostrarPreOrden()
		else:
			print ("No a Creado un arbol")

	def __insertarRec(self,dato,raiz):
		##Compara con Sub arboles
		if (raiz == None): #No existe el arbol
			raiz = NodoBinario(dato)
			raiz.mostrarEnOrden()
		##Para Arboles Ordenados
		elif (dato < raiz.getDato()):
			raiz = self.__insertarRec(dato,raiz.getLeft())
		elif (dato > raiz.getDato()):
			raiz = self.__insertarRec(dato,raiz.getRight())
		return raiz

	def insertar(self,dato):
		self.__raiz = self.__insertarRec(dato,self.__raiz)

	def eliminar(self,dato):
		self.__eliminarRec(dato,self.__raiz)

	def __eliminarRec(self,dato,raiz):
		pass
		"""
		Caso 1
			No existe el dato
		Caso 2
			Dato a eliminar no tiene hijos
				eliminar(dato)
				Liberar Memoria
				Padre de ese Hijo apuntara a nulo
			Caso Particular si la raiz no tiene Hijos
				Raiz = Nulo
		Caso 3
			Dato a eliminar tiene un Hijo
				eliminar (Dato)
				Nieto pasa a ser Hijo
				Liberar Memoria
		Caso 4
			Dato a Eliminar tiene 2 Hijos
			eliminar (Dato)
			Buscar el menor de los mayores
			Buscar e mayor de los menore
			Dependiendo de la eleccion el nodo pasa a ser el padre
			Liberar Memoria
		"""