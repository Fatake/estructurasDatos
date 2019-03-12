import Grafo 
import os
aux = Grafo
grafo = aux.Grafo()
##
#Main
##
while True:
	print "\tPratica de algoritmos con dijsktra"
	print ("<------------------------------>")
	print ("Opciones:\n")
	print ("1) Agregar Nodos")
	print ("2) Agregar Enlaces")
	print ("3) Algoritmo Dijsktra")
	print ("<------------------------------>")
	print ("0) Salir")
	print ("Selecione una opcion:")
	opcion = input("->")
	os.system('clear')
	if opcion == 1:
		##Agregar Nodos
		print "\t Agregar nodo"
		grafo.add_node( input("->"))
	elif opcion == 2:
		##Agregar Uniones
		print "\t Unir"
		print "\n Ingrese el nodo inicial"
		inicial = input("->")
		print "\n Ingrse el nodo final"
		final = input("->")
		print "\n Ingrese el peso"
		peso = input("->")
		grafo.add_edge(inicial,final,peso)
	elif opcion == 3:
		##Algoritmo Dijstra
		print grafo.dijsktra()
	elif opcion == 0:
		break
	else:
		print ("No existe esa opcion")
