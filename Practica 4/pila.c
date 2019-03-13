#include <stdio.h>
#include <stdlib.h>
//
//Estructura
//
typedef struct pila{
	float dato;
	struct pila* siguiente;
}Pila;
//
//Prototipo
//
int push(Pila** inicio, float dato);
int pop(Pila** inicio);
void consultaPila(Pila* inicio);
//
//main
//
int main(int argc, char **argv){
	Pila* inicio;
	int opcionMenu=0;
	float dato;
	char c;
	inicio = (Pila *) NULL;
	do{
		system("clear");
		printf("Pila\n");
		printf("\n<----------------->\n");
		printf("1)Agregar Elemento\n");
		printf("2)Mostrar Elementos\n");
		printf("3)Eliminar Elemento\n");
		printf("\n<----------------->\n");
		printf("0)Salir\n->");
		scanf("%d",&opcionMenu);
		while ((c = getchar()) != '\n' && c != EOF) { }
		switch(opcionMenu){
			//Agrega elementos a la pila
			case 1:
			system("clear");
			printf("Ingrese un dato\n->");
			scanf("%f",&dato);
			if(push(&inicio,dato))
			printf("Dato agregado!!\n");
			else printf("Pila llena -_-\n");
			getchar();
			break;
			//Mostrar todos los datos
			case 2:
				consultaPila(inicio);
			break;
			//Eliminar Dato
			case 3:
			printf("que pasa\n");
			getchar();
			getchar();
			system("clear");
			if(pop(&inicio))
			printf("Dato Eliminado!!\n");
			else printf("No tienes datos en la pila -_-\n");
			getchar();
			break;
			//Salir
			case 0:
				break;
			//Extra
			default:
				printf("No existe esa opción");
			break;
		}
	}while(opcionMenu!=0);
	return 0;
}
//
//Funciones
//
/**
 * Funcion que agrega elementos a la pila
 * retorna:
 * 1 Sí se logró agregar correctamente
 * 0 Sí no se logró agregar
 */
int push(Pila** inicio, float dato){
	Pila *temp, *aux;
	char c;
	temp = (Pila *) malloc (sizeof(Pila));
	// Se reserva memoria de acuerdo al tamaño de la estructura definida
	if (temp != NULL){ // En caso de que no pueda reservarse memoria
		temp->dato = dato; // Se guarda el dato en la parte de información
		temp->siguiente = NULL;
		// La lista esta vacía
		if ((*inicio) == NULL) (*inicio) = temp;
		//si no
		else{
			aux = (*inicio);
			temp->siguiente = aux;
			(*inicio) = temp;
		}
	}else{
		printf("\nMemoria insuficiente!");
		return 0;
	}
	while ((c = getchar()) != '\n' && c != EOF) { }
	getchar();
	return 1;
}
/**
 * Funcion consulta Pila
 * Esta funcion imprime todos los elementos de na losta
 */
void consultaPila(Pila* inicio){
	Pila* aux;
	int i=0;
	char c;
	aux = inicio;
	system("clear");
	printf("\nConsulta de Pila:\n");
	printf("\n<-------------->\n");
	while (aux != NULL){
		printf("\t\nDato: %f",aux->dato);
		printf("\n<-------------->\n");
		aux = aux->siguiente;
		i++;
	}
	if (i == 0) printf( "\nUsted no a agredado Pila\n" );
	while ((c = getchar()) != '\n' && c != EOF) { }
	getchar();
}
/**
 * Funcion pop
 * retonra:
 * 1 si logró eliminar el ultimo elemento
 * 0 si no se logró eliminar el ultimo elemento
 */
int pop(Pila** inicio){
	Pila *aux;
	if((*inicio) != NULL){
		//Si solo ha un elemento
		if((*inicio)->siguiente == NULL){
			(*inicio) = (Pila *) NULL;
			return 1;
		}else{
			aux = (*inicio)->siguiente;
			free((*inicio));
			(*inicio) = aux;
		}
	}else return 0;
	
	return 1;
}
