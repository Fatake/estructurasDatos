#include <stdlib.h>
#include <stdio.h>

struct dato {
	float info;
	struct dato *sig;
	};
	
	struct dato *primero, *ultimo;
	
void menu();
void insertar();
void mostrar();
void eliminar(float dats);

int main(int argc, char **argv)
{
	int opc;
	float dd;
	
	primero = (struct dato *) NULL;
	ultimo = (struct dato *) NULL;
	
	do{
		menu();
		scanf ("%d", &opc);	
		
		switch (opc) {
			case 1: insertar(); break;
			case 2: 
			printf (" \n Ingrese el dato a eliminar:");
			scanf ("%f", &dd);
			eliminar(dd); break;
			case 3: mostrar(); break;			
		}		
	} while (opc != 4);	
	
	
	return 0;
}

void menu() {
	
	printf ("\n 	~~~~~ MENU ~~~~~\n");
	printf ("	Seleccione una opción:\n");
	printf ("	1 <- Insertar dato\n");
	printf ("	2 <- Eliminar dato\n");
	printf ("	3 <- Mostrar lista\n");
	printf ("	4 <- Salir\n");
	printf ("\n Opción: ");
}
	
	//FUNCION AÑADIR ELEMENTO
void insertar() {
	struct dato *nuevo, *aux, *aux1;
	
	nuevo = (struct dato*) malloc (sizeof(struct dato));
	
	if (nuevo == NULL)
		printf ("\n X - No hay memoria disponible\n");
	
	system("clear");	
	printf (" ~~ Nuevo elemento ~~");
	printf (" Inserte elemento > ");
	scanf ("%f",&nuevo->info);
	
	nuevo->sig = NULL;
	
	if (primero == NULL){
		primero = nuevo;		
	}
	else {
		if (primero->info > nuevo->info){
			nuevo->sig = primero;
			primero = nuevo;
		}
		else {
			aux = primero;
			aux1 = primero->sig;
			
			while (aux1 != NULL && aux1->info < nuevo->info){
				aux = aux1;
				aux1 = aux1->sig;
			}
			aux->sig = nuevo;
			nuevo->sig = aux1;
		}
	}
}

// funcion mostrar
void mostrar() {
	struct dato *aux;
	aux = primero;
	
	system("clear");
	printf ("\n	~~~ Mostrando lista ~~~\n");
	
	if (primero == NULL){
		system("clear");
		printf("\nLista vacia\n");
		return;
	}
	
	while (aux != NULL) {
		printf ("\n > %f", aux->info);
		aux = aux->sig;	
	}
		
}

void eliminar(float dats) {
	struct dato *aux1, *aux2;
	if (primero == NULL) printf ("\n X - ¡Lista vacía!");
	else {
		if (primero->info == dats) {
			aux1 = primero;
			primero = aux1->sig;
			free(aux1);
		}
		else {
			aux1 = primero;
			aux2 = primero->sig;
			
			while (aux2 != NULL && aux2->info != dats) {
				aux1 = aux2;
				aux2 = aux2->sig;
			}
			
			if (aux2 != NULL){
				aux1->sig = aux2->sig;
				free(aux2);
			}
			else {
				printf ("\n	~~~ Ese dato no existe .-. ~~~");
			}
		}
	}
}
	

