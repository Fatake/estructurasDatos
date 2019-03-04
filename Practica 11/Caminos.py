import os


##
#Funciones
##

##Imprime Matriz de Relacion
def printMatriz():
	print matriz
	for i in matriz:
		for j in i:
			print j,
		print

def recorridoAnchura():
	print "Por hacer \n\n"

def recorridoProfundidad():
	print "Por hacer \n\n"

def algoritmoDijkstra():
	print "Por hacer" 

##
#Permite modificar la matriz de relacion
##
def cambiaRelacion():
	for i in range(nodos):
		for j in range(nodos):
			print "Existe relacion entre el nodo "+str(i+1)+" y "+str(j+1)
			print "1) si y 0) no" 
			matriz[i][j] = input("->")
			os.system('clear')
			
#
#Menu Principal
#
def camino():
	while True:
		print "\tPrograma Buscador de Caminos Con Algoritmos\n"
		print ("<-------------------------->")
		print ("Opciones:\n")
		print ("1) Mostrar Relaciones Por Anchura")
		print ("2) Mostrar Relaciones Por Profundidad")
		print ("3) Algoritmo de  Dijkstra")
		print ("4) Imprimir Matriz")
		print ("5) Cambiar Relacion")
		print ("<-------------------------->")
		print ("0) Salir")
		print ("Selecione una opcion:")
		opcion = input("->")
		os.system('clear')
		if opcion == 1:
			##Recorrido de anchura
			recorridoAnchura()
		elif opcion == 2:
			##Recorrido de Profundidad
			recorridoProfundidad()
		elif opcion == 3:
			##Camino de Dijkstra
			algoritmoDijkstra()
		elif opcion == 4:
			##Imprime Matriz
			printMatriz()
		elif opcion == 5:
			##Cambia Relacion
			cambiaRelacion()
		elif opcion == 0:
			break
		else:
			print ("No existe esa opcion")

##
#Main
##
os.system('clear')
while True:
	print "\tPrograma Buscador de Caminos Con Algoritmos\n"
	print "Ingrese la cantidad de Vertices del grafo"
	nodos = input("->")
	os.system('clear')
	if nodos <=0:
		print "No pueden Existir Vertices Negativos"
	else:
		break

#Una matriz en pyton es una lista de listas
matriz = []
#Crea una matriz en 0
for i in range(nodos):
	matriz.append([0]*nodos)

##
#Preguntar por relaciones
##
for i in range(nodos):
	for j in range(nodos):
		print "Existe relacion entre el Vertice "+str(i+1)+" con "+str(j+1)
		print "1) si y 0) no" 
		matriz[i][j] = input("->")
		if matriz[i][j] > 1:
			matriz[i][j] = 1
		os.system('clear')

##
#LLama a funcion camino
##
camino()

