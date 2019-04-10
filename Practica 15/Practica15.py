from Arbol import *
import os
##Main
arbol = Arbol()
os.system('clear')
while True:
	print ("\tPrograma Arbles AVL\n")
	print ("<----------------------->\n")
	print ("1) Agregar Datos")
	print ("2) Eliminar Datos\n")
	print ("3) Mostrar por Orden")
	print ("4) Mostrar Pos Orden")
	print ("5) Mostrar Pre Orden")
	print ("\n<----------------------->")
	print ("0) Salir")
	while True:
		try:
			opcion = int(input("->"))
			break;
		except ValueError:
			print("Opcion Incorrecta\n")
		except NameError:
			print("Opcion Incorrecta\n")
		except SyntaxError:
			print("Opcion Incorrecta\n")

	os.system('clear')
	if opcion == 1:
		print ("Ingrese Un Dato")
		while True:
			try:
				dato = int(input("->"))
				break;
			except ValueError:
				print("Solo admitimos Numeros Enteros")
			except NameError:
				print("Solo admitimos Numeros Enteros")
			except SyntaxError:
				print("Solo admitimos Numeros Enteros")

		arbol.insertar(dato)
	elif opcion == 2:
		print ("\t Eliminar Nodos")
		if (arbol.imprimirEnOrden()):
			print ("Ingrese Un Numero a eliminar\n")
			while True:
				try:
					numero = int(input("->"))
					break;
				except ValueError:
					print("No existe ese numero\n")
				except NameError:
					print("No existe ese numero\n")
				except SyntaxError:
					print("No existe ese numero\n")
			arbol.eliminar(numero)
		else:
			print (":(")
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
