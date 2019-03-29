from Arbol import *
import os
##Main
arbol = Arbol()
os.system('cls')
while True:
	print ("\tPrograma de Arboles\n")
	print ("-----------------------")
	print ("1) Agregar Datos")
	print ("2) Eliminar Datos")
	print ("3) Mostrar por Orden")
	print ("4) Mostrar Pos Orden")
	print ("5) Mostrar Pre Orden")
	print ("-----------------------")
	print ("0) Salir")
	while True:
		try:
			opcion = int(input("->"))
			break;
		except ValueError:
			print("Opcion Incorrecta\n")

	#os.system('clear')
	os.system('cls')
	if opcion == 1:
		print ("Ingrese Un Dato")
		while True:
			try:
				dato = int(input("->"))
				break;
			except ValueError:
				print("Solo admitimos Numeros Enteros")

		arbol.insertar(dato)
	elif opcion == 2:
		print ("Por hacer...\n")
	elif opcion == 3:
		arbol.imprimirEnOrden()
	elif opcion == 4:
		arbol.imprimirPosOrden()
	elif opcion == 5:
		arbol.imprimirPreOrden()
	elif opcion == 0:
		break;
	else:
		print ("Opcion Incorreta\n Intente de Nuevo")