#include <stdio.h>
#include <stdlib.h>
//Estructura
typedef struct baseAlumnos{
	char nombreAlumno[25], direccionAlumno[120], telefonoAlumno[10], sexoAlumno[1];
	struct baseAlumnos* siguiente;
} alumnos;
//
//Prototipo
//
void pause();
int altaAlumnos(alumnos** inicio, alumnos** final);
void consultaAlumnos(alumnos** inicio);
int guardarArchivo(alumnos* inicio, alumnos* final);
int cargarArchivo(alumnos** inicio, alumnos** final);
//
//main
//
int main(int argc, char **argv){
	int opcionMenu=0;
	alumnos* inicio;
	alumnos* final;
	inicio = (alumnos *) NULL;
	final = (alumnos *) NULL;
	do{
		system("clear");
		printf("Programa de estructuras\n");
		printf("\n<----------------->\n");
		printf("1)Altas Alumnos\n");
		printf("2)Consulta Alumnos\n");
		printf("3)Guardad Archivo\n");
		printf("4)Cargar Archivo\n");
		printf("\n<----------------->\n");
		printf("0)Salir\n->");
		scanf("%d",&opcionMenu);
		switch(opcionMenu){
			case 1://Altas
			while(altaAlumnos(&inicio, &final));
			break;
			
			case 2://Consultas
				consultaAlumnos(&inicio);
			break;
			
			case 3://Guardar
				pause();
				guardarArchivo(inicio, final);
			break;
			
			case 4://Cargar
				cargarArchivo(&inicio, &final);
			break;
			
			case 0://Salir
			break;
			default:
				printf("No existe esa opción");
				pause();
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
//Da de alta alumnos
int altaAlumnos(alumnos** inicio, alumnos** final){
	alumnos* nuevo;
	nuevo = (alumnos *) malloc (sizeof(alumnos));
	system("clear");
	printf("Alta de alumnos");
	printf("\n<----------------->\n");
	//
	printf("Ingrese el nombre del alumno\n->");
	scanf("%s",nuevo->nombreAlumno);
	printf("\nIngrese la direccion del alumno\n->");
	scanf("%s",nuevo->direccionAlumno);
	getchar();
	printf("Ingrese el sexo del alumno (m=masculino f=femenino)\n->");
	scanf("%s",nuevo->sexoAlumno);
	getchar();
	printf("Ingrese el teléfono del alumno\n->");
	scanf("%s",nuevo->telefonoAlumno);
	nuevo->siguiente = NULL;
	//
	if ((*inicio) == NULL) {
		printf( "Primer elemento\n");
		(*inicio) = nuevo;
		(*final) = nuevo;
	}else {
		/* el que hasta ahora era el último tiene que apuntar al nuevo */
		(*final)->siguiente = nuevo;
		/* hacemos que el nuevo sea ahora el último */
		(*final) = nuevo;
    }
	pause();
	return 0;
}
//Muestra en pantalla todos los alumnos
void consultaAlumnos(alumnos** inicio){
	alumnos* aux;
	int i=0;
	aux = *inicio;
	system("clear");
	printf("\nConsulta de alumnos:\n");
	printf("\n<-------------->\n");
	while (aux != NULL){
		printf("\t\nNombre: %s",aux->nombreAlumno);
		printf("\nDireccion: %s",aux->direccionAlumno);
		printf("\nTelefono: %s",aux->telefonoAlumno);
		printf("\nSexo: %s",aux->sexoAlumno);
		printf("\n<-------------->\n");
		aux = aux->siguiente;
		i++;
	}
	if (i == 0) printf( "\nUsted no a agredado alumnos\n" );
	getchar();
	pause();
}
/*
 * Funcion que Guarda Informacion
 * Retorna 
 * 1 si logró guardarla correctamente
 * 0 si no se logró guardar correctramente
 */
int guardarArchivo(alumnos* inicio, alumnos* final){
	alumnos* aux;
	FILE *fp;
	system("clear");
	printf("Guardar Archivo\n");
	printf("\n<----------------->\n");
	//Si no hay nada en la lista
	if(inicio == NULL){
		printf("Usted No tiene alumnos\n");
		pause();
		return 0;
	}
	//Cargar Archivo
	fp = fopen ( "baseAlumnos.bd", "w" );
	//Comprueba errores
	if (fp == NULL){
		fputs ("File error",stderr); 
		exit (1);
	}
	//Variable auxiliar que recorre toda la lista
	aux = inicio;
	do{
		fwrite( aux, sizeof(alumnos), 1, fp );
		aux = aux->siguiente;
	}while(aux != NULL);
	pause();
	fclose ( fp );
	return 1;
}
/*
 * Funcion que Carga Archvios
 */
int cargarArchivo(alumnos** inicio, alumnos** final){
	//Variables
	alumnos* aux;
	int pregunta = 0, bandera = 0;
	FILE *fp;
	//inicio funcion
	printf("Guardar Archivo\n");
	printf("\n<----------------->\n");
	//Checa si ya tiene alumnos registrados
	if(*inicio != NULL){
		printf("Usted ya tiene alumnos cargados\n");
		printf("Quiere cargar de todos modos?(1 = si cualquier numero no) Esto borrará los datos actuales\n->");
		scanf("%d",&pregunta);
		if(pregunta != 1)
		return 0;
	}
	//Abre la base de Alumnos
	fp = fopen ( "baseAlumnos.bd", "r" );
	//Inicializa la variable auxiliar
	aux = (alumnos *) malloc (sizeof(alumnos));;
	//Checa si el fichero fué abierto
	if (fp == NULL) {
		fputs ("File error",stderr); 
		exit (1);
	}
	//Proceso de leectura
	do{
		printf("Entra 6\n");
		fread( aux, sizeof(alumnos), 1, fp );
		printf("Entra 7\n");
		if(bandera == 0){
			*inicio = aux;
			*final = aux;
			bandera = 1;
		}else{
			/* el que hasta ahora era el último tiene que apuntar al nuevo */
			(*final)->siguiente = aux;
			/* hacemos que el nuevo sea ahora el último */
			(*final) = aux;
		}
	}while(feof(fp));
	
	
	pause();
	fclose ( fp );
	return 0;
}
