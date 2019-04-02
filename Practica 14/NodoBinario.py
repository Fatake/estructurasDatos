class NodoBinario():
	##
	#Constructor
	##
	def __init__(self,dato):
		self.__dato = dato
		self.__padre = None
		self.__left = None
		self.__right = None

	##
	#Gets
	##
	def getDato(self):
		return self.__dato

	def getPadre(self):
		return self.__padre

	def getLeft(self):
		return self.__left

	def getRight(self):
		return self.__right

	##
	#Sets
	##
	def setDato(self,where):
		self.__dato = where

	def setPadre(self,where):
		self.__padre = where

	def setLeft(self,where):
		self.__left = where

	def setRight(self,where):
		self.__right = where

	##
	#Funciones
	##
	def mostrarPreOrden(self):
		print (self.getDato())
		if (self.__left != None):
			self.__left.mostrarPreOrden()
		if(self.__right != None):
			self.__right.mostrarPreOrden()

	def mostrarEnOrden(self):
		if(self.__left != None):
			self.__left.mostrarEnOrden()
		print (self.getDato())
		if(self.__right != None):
			self.__right.mostrarEnOrden()

	def mostrarPosOrden(self):
		if(self.__left != None):
			self.__left.mostrarPosOrden()
		if(self.__right != None):
			self.__right.mostrarPosOrden()
		print (self.getDato())

	def buscarNumero(self,numero):
		return self.__RecBuscarNumero(numero)

	def __RecBuscarNumero(self,numero):
		guardar = None
		if(self.__left != None):
			if(self.__left.getDato() != numero):
				guardar = self.__left.buscarNumero(numero)
			else:
				return self.__left
		if(self.__right != None):
			if(self.__right.getDato() != numero):
				guardar = self.__right.buscarNumero(numero)
			else:
				return self.__right
		return guardar
