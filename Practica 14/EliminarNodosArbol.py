	def eliminarCaso1(self,nodo):
		hijoIzquierdo = nodo.getPadre().getLeft()
		hijoDerecho = nodo.getPadre().getRight()

		if(hijoIzquierdo == nodo):
			nodo.getPadre().setLeft(None)
			return True

		elif(hijoDerecho == nodo):
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
			self.eliminarNodo(nodoMasALaIzquierda)
			return True
		#Si no
		return False

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
			return self.eliminarCaso1(nodo)
	 
		#Caso 2: Tiene un hijo y el otro no 
		elif (tieneNodoDerecha and not tieneNodoIzquierda):
			return self.eliminarCaso2(nodo)

		elif(not tieneNodoDerecha and tieneNodoIzquierda):
			return self.eliminarCaso2(nodo)
	 
		#Caso 3: Tiene ambos hijos
		elif (tieneNodoDerecha and tieneNodoIzquierda):
			return self.eliminarCaso3(nodo)
		#Si no existe ningun nodo entonces
		return False
