#include <stdio.h>
#include <malloc.h> // Biblioteca para el manejo de memoria dinámica

struct dato { // Se define la estructura a trabajr
	char info;
	struct dato *sig; // Se hace uso de apuntadores
};

struct dato *inicio; // Se define el primer elemento

void insertar (char car)
{
	struct dato *temp, *aux;
	
	temp = (struct dato *) malloc (sizeof(struct dato));
	// Se reserva memoria de acuerdo al tamaño de la estructura definida
	if (temp != NULL) // En caso de que no pueda reservarse memoria
	 {
	 	temp -> info = car; // Se guarda el dato en la parte de información
	 	temp -> sig = NULL;
	 	if (inicio == NULL) // La lista esta vacía
	 	 inicio = temp;
	 	else
	 	  {
	 	  	aux = inicio;
	 	  	while (aux->sig != NULL) // Se busca el último elemento en la lista
	 	  	    aux = aux->sig;
	 	  	aux->sig = temp;
		   }
	 }
	else
	  printf("\nMemoria insuficiente!");
}


char eliminar()
{
	struct dato *temp;
	char c;
	
	temp = inicio; // Se elimina el primer elemento de la lista
	inicio = temp->sig;
	c = temp->info;
	free(temp); // Libera la memoria
	
	return c;
}

void mostrar()
{
	struct dato *temp;
	
	temp = inicio;
	if (temp != NULL)
	  while (temp!=NULL)
	       {
			printf("\n Dato: %c", temp->info);
			temp=temp->sig;  // Avanza al siguiente
		   }
	else
	  printf ("\n Lista vacía!");
}

main()
{
	int opc;
	char c;
	
	inicio = NULL; // Inicia la lista con nulo
	do {
		printf ("\n1. Insertar \n2. Eliminar \n3. Mostrar \n");
		printf ("4. Salir\n    Da tu opcion: ");
		scanf ("%d",&opc);
		getchar();
		
		switch (opc)
		{
			case 1: printf ("\n Dame la letra a insertar: ");
					c = getchar();
				    insertar (c);
				    break;
			case 2: if (inicio != NULL)
					  {
					   c = eliminar();
					   printf ("\n Dato eliminado: %c",c);
					  }
					else
					  printf ("\n Lista vacía!");  
					break;
			case 3: mostrar();
					break;
		}
	} while (opc!=4);
}
