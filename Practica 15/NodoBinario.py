#Clase nodo Binario
class NodoBinario():
	"""
	Nodo Binario
	dato es un entero que contiene un Numero
	cant es a cantidad de altura
	left y right son los nodos hijos
	FB factor de balance
	"""

	#Constructor
	def Node(self, dato):
		self.dato = dato
		self.cant = 1
		self.left = None
		self.right = None
		self.FB = 0

	#Actualiza con las alturas de los subárboles (?)
	def updateFB(self):
		leftHeight = -1
		rightHeight = -1

		if (left != None):
			leftHeight = left.height()
		if (right != None):
			rightHeight = right.height()
		self.FB = rightHeight - leftHeight


	#Actualiza con referencia a los FB de los subárboles y el valor introducido
	def void updateFB(self, inf):
		if (inf < self.dato):
			if ((self.left.getInf() == inf and self.left.getRight() == None and self.left.getLeft() == None) or self.left.getFB() != 0):
				self.FB--
		elif(inf > self.dato):
			if ((self.right.getInf() == inf and self.right.getRight() == None and self.right.getLeft() == None) or self.right.getFB() != 0):
				self.FB++

	#Calcula la altura desde el nivel 0
	private int height() {
		return height(0);
	}

	#Calcula la altura (recursivo)
	private int height(int level) {
		int levelL = level;
		int levelR = level;
		if (left != None) levelL = left.height(level + 1);
		if (right != None) levelR = right.height(level + 1);

		return (levelL > levelR ? levelL : levelR);
	}

	#Muestra en PreOrden
	def StringBuffer listPreOrder() {
		StringBuffer list = new StringBuffer();
		list.append("\n" + inf + " (FB : " + FB + ")");
		if (left != None) list.append(left.listPreOrder());
		if (right != None) list.append(right.listPreOrder());
		return list;
	}

	#Muestra en Orden
	def StringBuffer listInOrder() {
		StringBuffer list = new StringBuffer();
		if (left != None) list.append(left.listInOrder());
		#list.append("\n" + inf + " (FB : " + FB + ")");
		for (int i = 0; i < cant; i++) list.append("\n" + inf);
		if (right != None) list.append(right.listInOrder());
		return list;
	}

	#Muestra en PostOrden
	def StringBuffer listPostOrder() {
		StringBuffer list = new StringBuffer();
		if (left != None) list.append(left.listPostOrder());
		if (right != None) list.append(right.listPostOrder());
		list.append("\n" + inf + " (FB : " + FB + ")");
		return list;
	}

	"""
	Seters y getters
	"""
	def setLeft(self, node):
		self.left = node

	def setRight(self, node):
		self.right = node

	def setFB(self, value):
		self.FB = value

	def addCant(self):
		self.cant = self.cant + 1

	def getInf(self):
		return self.inf

	def getLeft(self):
		return self.left

	def getRight(self):
		return self.right

	def getFB(self):
		return self.FB
