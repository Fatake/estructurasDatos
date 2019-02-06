#include <stdio.h>
#include <stdlib.h>
//Constantes
#define maximo 5
#define minimo 0
//Variables
int cola[maximo];
int frente, atras, bandera;
//Prototipos
int insertar();
int eliminar();
void mostrar();
/**
 * Main
 */
int main(int argc, char **argv){
	int opcionMenu=0;
	/*
	 * Bandera es una variable que indica que
	 * la ultima acion fue:
	 * 0 Eliminar elemento
	 * 1 Insertar elemento
	 */
	bandera = frente = atras = 0;
	do{
		printf("\t Cola Circular\n");
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
	if(frente == atras && bandera == 1) return 0;
	else{
		printf("\tAgregar elemento\n");
		printf("\n<----------------------->\n");
		printf("Ingrese el dato \n ->");
		scanf("%d",&dato);
		cola[atras]=dato;
		atras = (atras +1)% maximo;
		bandera = 1;
	}
	return 1;
}
//Eliminar
int eliminar(){
	if(frente == atras && bandera == 0) return 0;
	else{
		frente = (frente+1)% maximo;
		bandera = 0;
	}
	return 1;
}
//Mostrar
void mostrar(){
	int f=bandera;
	for(int i=frente;i != atras || f == 1 ;i=(i+1)%maximo){
		f = 0;
		printf("Dato: %d\n",cola[i]);
	}
	//
}
