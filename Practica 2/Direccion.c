#include <stdio.h>
//
//Main
//
int main(int argc, char **argv){
	int dirB,indiceI, indiceS,tamanoE, punto;
	printf("Programa de direcciones\n");
	printf("\n<----------------->\n");
	printf("Ingrese la direccion inicial\n->");
	scanf("%d",&dirB);
	do{
		printf("Ingrese el Indice inferior\n->");
		scanf("%d",&indiceI);
		printf("Ingrese el Indice superior \n->");
		scanf("%d",&indiceS);
		if(indiceI > indiceS){
			printf("El indice inferior no puede ser mas grande que el superior\n");
		}else break;
	}while(1);
	printf("Ingrese el tamaño en byte de cada elemento \n->");
	scanf("%d",&tamanoE);
	do{
		printf("Ingrese el punto a calcular la direccion \n->");
		scanf("%d",&punto);
		if(punto > indiceS || punto < indiceI){
			printf("No existe ese punto\n");
		}else{
			printf("Punto %d con Direccion: %d \n",punto,dirB+(punto-indiceI)*tamanoE);
			break;
		}
	}while(1);
	
	return 0;
}
