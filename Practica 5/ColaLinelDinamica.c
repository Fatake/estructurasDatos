#include <stdio.h>
#include <stdlib.h>
//Estructura
typedef struct cola{
	char dato[30];
	struct cola* siguiente;
}ColaDinamica;
//
//Prototipo
//
void pause();
char *gets(char *str);
int altaColaDinamica(ColaDinamica** inicio, ColaDinamica** final);
int eliminarColaDinamica(ColaDinamica** inicio);
void consultaColaDinamica(ColaDinamica* inicio);
//
//main
//
int main(int argc, char **argv){
	int opcionMenu=0;
	ColaDinamica* inicio;
	ColaDinamica* final;
	inicio = (ColaDinamica *) NULL;
	final = (ColaDinamica *) NULL;
	do{
		printf("Cola Lineal Dinámica\n");
		printf("\n<----------------->\n");
		printf("1)Agregar Elemento\n");
		printf("2)Eliminar elemento\n");
		printf("3)Mostrar Elementos\n");
		printf("\n<----------------->\n");
		printf("0)Salir\n->");
		scanf("%d",&opcionMenu);
		system("clear");
		switch(opcionMenu){
			case 1:
				//Agrega Elemento
				if(altaColaDinamica(&inicio, &final))
				printf("Elemento agregado ^.^\n");
			break;
			
			case 2:
				//Elimina Elemento
				if(eliminarColaDinamica(&inicio))
				printf("Elemento eliminado (_ _;)\n");
				else printf("Cola vacia ¬.¬\n");
			break;
			
			case 3:
				//Mostrar elemento
				consultaColaDinamica(inicio);
			break;
			
			case 0:
				system("clear");
				printf("Saliendo ¬.¬\n");
			break;
			
			default:
				printf("No existe esa opción ¬.¬\n");
			break;
		}
	}while(opcionMenu!=0);
	return 0;
}
//
//Funciones
//
//Pausa
void pause(){
	char d;
	scanf("%c",&d);
}
//Da de alta ColaDinamica
int altaColaDinamica(ColaDinamica** inicio, ColaDinamica** final){
	ColaDinamica* nuevo;
	nuevo = (ColaDinamica *) malloc (sizeof(ColaDinamica));
	system("clear");
	printf("Agregar Datos");
	printf("\n<----------------->\n");
	//
	printf("Ingrese un dato\n->");
	//scanf("%s",nuevo->dato);
	gets(nuevo->dato);
	gets(nuevo->dato);
	nuevo->siguiente = NULL;
	//
	if ((*inicio) == NULL) {
		(*inicio) = nuevo;
		(*final) = nuevo;
	}else{
		/* el que hasta ahora era el último tiene que apuntar al nuevo */
		(*final)->siguiente = nuevo;
		/* hacemos que el nuevo sea ahora el último */
		(*final) = nuevo;
    }
	return 1;
}
//Da de alta ColaDinamica
int eliminarColaDinamica(ColaDinamica** inicio){
	if((*inicio) == NULL) return 0;
	(*inicio)=(*inicio)->siguiente;
	return 1;
}
//Muestra en pantalla todos los ColaDinamica
void consultaColaDinamica(ColaDinamica* inicio){
	ColaDinamica* aux;
	int i=0;
	aux = inicio;
	system("clear");
	printf("\nConsulta de ColaDinamica:\n");
	printf("\n<-------------->\n");
	while (aux != NULL){
		printf("\t\nDato: %s",aux->dato);
		printf("\n<-------------->\n");
		aux = aux->siguiente;
		i++;
	}
	if (i == 0) printf( "\nCola vacia ¬.¬\n" );
	getchar();
	pause();
}
