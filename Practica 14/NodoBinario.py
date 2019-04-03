class NodoBinario():
	##
	#Constructor
	##
	def __init__(self,dato):
		self.__dato = dato
		self.__left = None
		self.__right = None

	##
	#Gets
	##
	def getDato(self):
		return self.__dato

	def getPadre(sef):
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

	def findPredecessor(self):
		if (self.getRight() == None):
			return self
		else:
			return self.getRight().findPredecessor()


	def findSuccessor(self):
		if (self.getLeft() == None):
			return self
		else:
			return self.getLeft().findSuccessor()

	def delete(self,value):
		response = self;

		if (value < self.__dato):
			self.__left = self.__left.delete(value)

		elif (value > self.__dato):
			self.__right = self.__right.delete(value)
		else:
			if (self.__left != None and self.__right != None):
				temp = self
				maxOfTheLeft = self.__left.findPredecessor();
				self.__dato = maxOfTheLeft.getDato();
				temp.__left = temp.__left.delete(maxOfTheLeft.getDato());

			elif (self.__left != None):
				response = self.__left

			elif (self.__right != None):
				response = self.__right
			else:
				response = None

		return response
