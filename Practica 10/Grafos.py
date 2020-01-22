import os
##
#Funciones
##
def printMatriz():
	#imprime la matriz
	print (matriz)
	for i in matriz:
		for j in i:
			print (j),
		print("\n")

def buscaCamino():
	print ("\t Buscador de caminos")
	while True:
		print ("Ingrese el Vertice Inicial")
		nodoInicial = input("->")
		os.system("clear")
		#Comprueba que no se salga del rango de las aristas permitidas
		if nodoInicial > nodos or nodoInicial < 1:
			print ("No existe El Vertice "+str(nodoInicial))
		else:
			break
	while True:
		print ("Ingrese el Vertice Final")
		nodoFinal = input("->")
		os.system("clear")
		#Comprueba que no se salga del rango de las aristas permitidas
		if nodoFinal > nodos or nodoFinal < 1:
			print ("No existe El Vertice "+str(nodoFinal))
		else:
			break

	nodoInicial = nodoInicial - 1
	nodoFinal = nodoFinal -1 
	print ("Aristas a buscar "+str(nodoInicial+1)+" y "+str(nodoFinal+1))
	##Caso 1 si existe camino de 1 arista
	if matriz[nodoInicial][nodoFinal] == 1:
		print ("Si existe un cambino")
		return True;

	##
	##buscando caminos de mas aristas
	aux = matriz
	##Pone 0 en matriz auxiliar
	aux2 = matriz
	aux3 = []
	for i in range(nodos):
		aux3.append([0]*nodos)

	for n in range(nodos-1):#n -1 de caminos
		for i  in range(nodos):#filas
			for k in range(nodos):#Columnas
				temp = 0
				for j in range(nodos):#Multiplica
					temp += aux[i][j] * aux2[j][k]
					if temp > 1:
						temp = 1
					aux3[i][k] = temp
					
		if aux3[nodoInicial][nodoFinal] == 1:
			print ("Si existe un cambino")
			return True;
		aux = aux2
		aux2 = aux3
	print ("No existe un camino")

#Permite modificar la matriz de relacion
#
def cambiaRelacion():
	for i in range(nodos):
		for j in range(nodos):
			print ("Existe relacion entre el nodo "+str(i+1)+" y "+str(j+1))
			print ("1) si y 0) no" )
			matriz[i][j] = input("->")
			os.system('clear')

#
#Menu Principal
#
def camino():
	while True:
		print ("\tPrograma Buscador de Caminos\n")
		print ("Opciones\n")
		print ("1) Existe Camino de a-b?")
		print ("2) Matriz de relacion")
		print ("3) Cambiar Relacion")
		print ("<-------------------------->")
		print ("0) Salir")
		print ("Selecione una opcion:")
		opcion = input("->")
		os.system('clear')
		if opcion == 1:
			buscaCamino()
		elif opcion == 2:
			printMatriz()
		elif opcion == 3:
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
	print ("\tPrograma Buscador de Caminos\n")
	print ("Ingrese la cantidad de Vertices del grafo")
	nodos = input("->")
	os.system('clear')
	if nodos <=0:
		print ("No pueden Existir Vertices Negativos")
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
		print ("Existe relacion entre el Vertice "+str(i+1)+" con "+str(j+1))
		print ("1) si y 0) no" )
		matriz[i][j] = input("->")
		if matriz[i][j] > 1:
			matriz[i][j] = 1
		os.system('clear')

os.system('clear')
##LLama a funcion camino
##os.system("clear")
camino()

