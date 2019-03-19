import os
from collections import deque

##
#Funciones
##
def Prim():
	vertices = []
	##T
	temporal = []
	##V-U
	verMenosU = []
	##U
	conjU = []
	costoAux = 999
	u = 1
	v = 1
	for i in range(nodos):
		vertices.append(i)
	##Iniciar el 1
	conjU.append(0)
	##Inicio de Algoritmo
	while(conjU != vertices ):
		#V-u
		for i in vertices:
			for j in conjU:
				if(vertices[i] != conjU[j]):
					verMenosU.append(i)
		print conjU
		print vertices
		print verMenosU
		#Arista de costo Minimo
		for i in vertices:
			print i
			for j in verMenosU:
				print j
				u = i
				v = j
				if (matrizCostos[u][v] < costoAux):
					costoAux = matrizCostos[u][v]
					print True
		temporal.append([u,v])
		conjU.append(v)
		print temporal
		a = input()

##Imprime Matriz de Relacion
def printMatriz():
	print matriz
	for i in matriz:
		for j in i:
			print j,
		print
	
	print matrizCostos
	for i in range(nodos):
		for j in range(nodos):
			print str(matrizCostos[i][j]),
		print




##
#Permite modificar la matriz de relacion
##
def cambiaRelacion():
	for i in range(nodos):
		for j in range(nodos):
			print "Existe relacion entre el Vertice "+str(i+1)+" con "+str(j+1)
			print "1) si y 0) no" 
			aux = input("->")
			if(aux > 0):
				matriz[i][j] = 1
				print ("\n Ingrese El costo de la relacion")
				aux = input("->")
				matrizCostos[i][j] = aux
			os.system('clear')
			
#
#Menu Principal
#
def camino():
	while True:
		print "\tPrograma Buscador Arboles recubridores de costo minimo\n"
		print ("<------------------------------>")
		print ("Opciones:\n")
		print ("1) Prim")
		print ("2) Imprimir Matriz")
		print ("3) Cambiar Relacion")
		print ("<------------------------------>")
		print ("0) Salir")
		print ("Selecione una opcion:")
		opcion = input("->")
		os.system('clear')
		if opcion == 1:
			##Recorrido de anchura
			Prim()
		elif opcion == 2:
			##Imprime Matriz
			printMatriz()
		elif opcion == 3:
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
	print ("\tPrograma Buscador Arboles recubridores de costo minimo\n")
	print ("Ingrese la cantidad de Vertices del grafo")
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
	
matrizCostos = []
for i in range(nodos):
	matrizCostos.append([0]*nodos)

##
#Preguntar por relaciones
##
for i in range(0,nodos):
	for j in range(i,nodos):
		if (i != j):
			print "Existe relacion entre el Vertice "+str(i+1)+" con "+str(j+1)
			print "1) si y 0) no" 
			aux = input("->")
			if(aux > 0):
				print ("\n Ingrese El costo de la relacion")
				aux = input("->")
				matrizCostos[i][j] = aux
				matriz[i][j] = 1
				matrizCostos[j][i] = aux
				matriz[j][i] = 1
			else:
				matrizCostos[i][j] = 9999999
				matriz[i][j] = 0
				matrizCostos[j][i] = 9999999
				matriz[j][i] = 0
		else:
			matrizCostos[i][j] = 9999999
			matriz[i][j] = 0
			matrizCostos[j][i] = 9999999
			matriz[j][i] = 0
		os.system('clear')

##
#LLama a funcion camino
##
camino()

