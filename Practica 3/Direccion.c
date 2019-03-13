#include <stdio.h>
#include <stdlib.h>
//
//Main
//
int main(int argc, char **argv){
	int* indicesI;
	int* indicesS;
	int* rangos;
	int* puntos;
	int dirB,tamanoE, punto, nDimenciones, direccion;
	int aux1,aux2,i, j;
	printf("\t Programa de direcciones\n");
	printf("\n<------------------------>\n");
	//
	do{
		printf("Cuantas dimensiones tiene tu arreglo?\n->");
		scanf("%d",&nDimenciones);
		if(nDimenciones < 2) printf("\nNo existen arreglos de %d dimenciones\n",nDimenciones);
		else break;
	}while(1);
	//
	//Se da memoria a los arreglos que tienen los rangos e indices
	//
	indicesI = (int*) malloc(sizeof(int)*nDimenciones-1);
	indicesS = (int*) malloc(sizeof(int)*nDimenciones-1);
	rangos = (int*) malloc(sizeof(int)*nDimenciones-1);
	puntos = (int*) malloc(sizeof(int)*nDimenciones-1);
	//
	//
	//
	printf("Ingrese la direccion inicial\n->");
	scanf("%d",&dirB);
	//
	printf("Ingrese el tamanio en byte de cada elemento \n->");
	scanf("%d",&tamanoE);
	//
	//Se van a pedir los indices superiores e inferiores
	//
	for(i=1; i<=nDimenciones; i++){
		printf("\n \n");
		//indices
		do{
			printf("Ingrese el Indice inferior : %d \n ->",i);
			scanf("%d",&indicesI[i-1]);
			printf("Ingrese el Indice superior : %d \n->",i);
			scanf("%d",&indicesS[i-1]);
			if(indicesI[i-1] > indicesS[i-1]){
				printf("El indice inferior no puede ser mas grande que el superior\n");
			}else break;
		}while(1);
		//Puntos
		do{
			printf("Ingrese el punto a calcular la direccion(1,2,...,%d) : %d \n->",nDimenciones, i);
			scanf("%d",&puntos[i-1]);
			if(puntos[i-1] > indicesS[i-1] || puntos[i-1] < indicesI[i-1])
			printf("El punto %d no existe en los rangos %d-%d\n\n",puntos[i-1],indicesI[i-1],indicesS[i-1]);
			else break;
		}while(1);
		rangos[i-1] = indicesS[i-1] - indicesI[i-1] +1;
	}
	//Direccion
	aux1 = 0;
	aux2 = 1;
	for(i=0; i<nDimenciones ; i++){
		if( i == 0 )
		aux1 += puntos[i]-indicesI[i];
		//Multiplicar todos los rangos hasta i-1
		for(j=nDimenciones-(i+1); j>=1 ; j--){
			aux2 = rangos[j]*aux2;
		}
		aux2 = aux1*aux2;
		aux1 += aux2;
	}
	direccion = dirB + aux1*tamanoE;
	printf("EL punto (");
	for(i=0; i<nDimenciones ; i++){
		
		printf("%d,",puntos[i]);
	}	
	printf(") tiene la direccion: %d\n",direccion);

	
	return 0;
}
