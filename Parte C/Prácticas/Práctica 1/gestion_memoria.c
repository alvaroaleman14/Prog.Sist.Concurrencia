/*
 * gestion_memoria.c
 *
 *  Created on: 8/3/2019
 *      Author: Álvaro
 */

#include "gestion_memoria.h"
#include <stdlib.h>
#include <stdio.h>

const int MAX = 1000;

void crear (T_Manejador *manejador){
	setvbuf (stdout, NULL, _IONBF ,0);
	*manejador = (T_Manejador)malloc(sizeof(struct T_Nodo));
	(*manejador)->inicio = 0;
	(*manejador)->fin = MAX-1;
	(*manejador)->sig = NULL;
}

void mostrar (T_Manejador manejador){
	T_Manejador aux = manejador;
	while (aux != NULL){
		printf ("Bloque inicio %d fin %d", aux->inicio,aux->fin);
		aux = aux->sig;
	}
}

void destruir (T_Manejador *manejador){
	T_Manejador ptr ;
	while (*manejador != NULL){
		ptr = (*manejador);
		(*manejador) = (*manejador)->sig;
		free(ptr);
	}
}

void obtener (T_Manejador *manejador, unsigned tam, unsigned* dir, unsigned* ok){

}
