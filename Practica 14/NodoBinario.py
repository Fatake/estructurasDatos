Class NodoBinario():
	def __init__(self,elemto):
		self.__dato = elemento
		self.__left = None
		self.__right = None

	def getDato(self):
		return dato

	def mostrarPreOrden(self):
		print self.getDato()
		if (__left != None):
			__left.mostrarPreOrden()
		if(__right != None):
			__right.mostrarPreOrden()

	def mostrarEnOrden(self):
		if(__left != None):
			__left.mostrarEnOrden()
		print self.getDato()
		if(__right != None):
			__right.mostrarEnOrden()

	def mostrarPosOrden(self):
		if(__left != None):
			__left.mostrarPosOrden()
		if(__right != None):
			__right.mostrarPosOrden()
		print self.getDato()
