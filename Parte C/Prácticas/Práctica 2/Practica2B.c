/*
 * Practica2B.c
 *
 *  Created on: 24/4/2019
 *      Author: Álvaro
 */


#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "arbolbb.h"
#include "time.h"

/**
 * Pide un número "tam" al usuario, y
 * crea un fichero binario para escritura con el nombre "nfichero"
 * en que escribe "tam" numeros (unsigned int) aleatorios
 * Se utiliza srand(time(NULL)) para establecer la semilla (de la libreria time.h)
 * y rand()%100 para crear un número aleatorio entre 0 y 99.
 */
void creafichero(char* nfichero){
	unsigned int tam;
	unsigned int num;
	FILE* f1;
	f1 = fopen(nfichero,"wb"); //Crea fichero de escritura binario.
	printf("Inserte un número: \n");
	fflush(stdout);

	scanf("%d",&tam);
	fflush(stdin);

	printf("Inicializando fichero...\n");
	fflush(stdout);

	srand(time(NULL));
	for (int i = 0; i< tam; i++){
		num = rand()%100;
		fwrite(&num,sizeof(unsigned int),1,f1);
	}
	fclose(f1);
}

/**
 * Muestra por pantalla la lista de números (unsigned int) almacenada
 * en el fichero binario "nfichero"
 */
void muestrafichero(char* nfichero){
	FILE* f2;

	if((f2 = fopen(nfichero,"rb") )== NULL ){
		perror("Error al abrir el fichero...\n");
		//exit(-1);
	}else{
		int i;
		while((fread(&i,sizeof(int),1,f2)) == 1){
			printf("%d",i);
		}
		printf("\n");

	}
fclose(f2);
}

/**
 * Guarda en el arbol "*miarbol" los números almacenados en el fichero binario "nfichero"
 */

void cargaFichero(char* nfichero, T_Arbol* miarbol){
	FILE* f2;

	if ((f2 = fopen(nfichero,"rb")) == NULL){
		perror("Error al abrir el fichero");
		//exit(-1);
	}else{
		int res;
		while( (fread(&res,sizeof(int),1,f2)) == 1){
			insertar(miarbol,res);
		}

	}
	fclose(f2);
}

int main(void) {
	char nfichero[50];
	printf ("Introduce el nombre del fichero binario:\n");
	fflush(stdout);
	scanf ("%s",nfichero);
	fflush(stdin);

	creafichero(nfichero);
	printf("\n Ahora lo leemos y mostramos\n");
	muestrafichero(nfichero);
	fflush(stdout);

	printf ("\n Ahora lo cargamos en el arbol\n");
	T_Arbol miarbol;
	crear (&miarbol);
	cargaFichero(nfichero,&miarbol);
	printf ("\n Y lo mostramos ordenado\n");
	mostrar(miarbol);
	fflush(stdout);

	printf("\n Ahora lo guardamos ordenado\n");
	FILE * fich;
	fich = fopen (nfichero, "wb");
	salvar (miarbol, fich);
	fclose (fich);
	printf("\n Y lo mostramos ordenado\n");
	muestrafichero(nfichero);
	destruir (&miarbol);

	return EXIT_SUCCESS;
}
