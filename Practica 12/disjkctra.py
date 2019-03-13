def algoritmoDijkstra():
	v = []
	#Crea una matriz en 0
	for i in range(nodos):
		v.append(i)
	s = []
	d = []
	print "\t Algoritmo de Dijkstra\n\n"
	while (True):
		print "Ingrese el nodo inicial"
		inicio = input("->")
		if inicio <= nodos and inicio > 0:
			break
	while (True):
		print "Ingrese el nodo Final"
		final = input("->")
		if final <= nodos and final > 0:
			break
	inicio = inicio -1
	final = final -1
	
	s.append(inicio)
	for i in range(inicio +1, nodos):
		d.append(matrizCostos[inicio][i])
	w = 50
	##inicio de algoritmo
	for i in range(nodos-1):
		#Busca el minimo de w 
		for j in range(d):
			if d[i] < w :
				w = d[i]
		s.append(w)
		for j in range(v-s):
			if d[w]+matrizCostos[w][j] < d[j]:
				print 
##Para pruebas

def Dijkstra():
	print "\t Algoritmo de Dijkstra\n\n"
	while (True):
		print "Ingrese el nodo inicial"
		inicio = input("->")
		if inicio <= nodos and inicio > 0:
			break
			
	inicio = inicio -1
	nodes = []
	for i in range(nodos):
		nodes.append(i)
	visited = {inicio: 0}
	path = {} #Camino = s

	while nodos: 
		nodoMinimo = None
		#agarra el minimo en d
		for nodo in range(nodos):
			if nodo in visited:
				if nodoMinimo is None:
					nodoMinimo = nodo
				elif visited[nodo] < visited[nodoMinimo]:
					nodoMinimo = nodo
		#Si no lo encuentra
		if nodoMinimo is None:
			break

		nodes.remove(nodoMinimo)
		pesoActual = visited[nodoMinimo]

		for i in range(matriz[nodoMinimo]):
			peso = pesoActual + [(nodoMinimo, i)]
			if i not in visited or peso < visited[i]:
				visited[i] = peso
				path[i] = nodoMinimo

	print visited
	print path
	print 
