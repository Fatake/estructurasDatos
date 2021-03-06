#include <stdio.h>
#include <stdlib.h>
//Constantes
#define maximo 5
#define minimo 0
//Variables
int cola[maximo];
int frente, atras;
//Prototipos
int insertar();
int eliminar();
void mostrar();
/**
 * Main
 */
int main(int argc, char **argv){
	int opcionMenu=0;
	frente = atras = 0;
	do{
		printf("\t Cola Lineal Estatica\n");
		printf("\n<----------------------->\n");
		printf("1)Agregar Elemento\n");
		printf("2)Eliminar Elemento\n");
		printf("3)Mostrar Elementos\n");
		printf("\n<----------------------->\n");
		printf("0)Salir\n->");
		scanf("%d",&opcionMenu);
		system("clear");
		switch(opcionMenu){
			case 1:
				//Agrega Elemento
				if(insertar())
				printf("Dato agregado n.n\n");
				else printf("Cola llena ¬.¬ \n");
			break;
			
			case 2:
				//Elimina Elemento
				if(eliminar())
				printf("Dato Eliminado (_ _;)\n");
				else printf("Cola vacia ¬.¬ \n");
			break;
			
			case 3:
				//Mostrar elemento
				mostrar();
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
int insertar(){
	int dato = 0;
	system("clear");
	if(atras == maximo) return 0;
	else{
		printf("\tAgregar elemento\n");
		printf("\n<----------------------->\n");
		printf("Ingrese el dato \n ->");
		scanf("%d",&dato);
		cola[atras++]=dato;
	}
	return 1;
}
int eliminar(){
	if(frente == atras) return 0;
	else frente++;
	return 1;
}
void mostrar(){
	system("clear");
	if(frente == atras) printf("Cola vacia ¬.¬ \n");
	else
	for(int i = frente;i<atras;i++)
		printf("Num: %d Dato: %d \n",i,cola[i]);
}
