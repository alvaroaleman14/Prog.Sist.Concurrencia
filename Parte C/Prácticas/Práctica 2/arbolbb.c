/*
 * arbolbb.c
 *
 *  Created on: 20/3/2019
 *      Author: Álvaro
 */


#include "arbolbb.h"
#include <stdlib.h>
#include <stdio.h>



// Crea la estructura utilizada para gestionar el árbol.
void crear(T_Arbol* arbol){
	(*arbol) = NULL;
}
// Destruye la estructura utilizada y libera la memoria.
void destruir(T_Arbol* arbol){
	if ((*arbol)){ //Si hay contenido donde apunta árbol.
		destruir(&((*arbol)->izq));
		destruir(&((*arbol)->der));
		free(arbol);
	}
}
// Inserta num en el árbol. Si ya está insertado, no hace nada
void insertar(T_Arbol* arbol,unsigned num){
	if ((*arbol)==NULL){
		T_Arbol arbolbb = (T_Arbol)malloc(sizeof(struct T_Nodo));
		arbolbb->dato = num;
		arbolbb->der = NULL;
		arbolbb->izq = NULL;
		(*arbol)=arbolbb;
	}else if ((*arbol)->dato > num){
		insertar(&(*arbol)->izq,num);
	}else if ((*arbol)->dato < num){
		insertar (&(*arbol)->der,num);
	}
}
// Muestra el contenido del árbol en InOrden
void mostrar(T_Arbol arbol){
	while(arbol != NULL){
		mostrar(arbol->izq);
		printf(" -- %d --  ", arbol->dato);
		mostrar(arbol->der);
	}
}
// Guarda en disco el contenido del fichero
void salvar(T_Arbol arbol, FILE* fichero){
	while(arbol!= NULL){
		salvar(arbol->izq,fichero);
		fwrite(&(arbol->dato),sizeof(int),1,fichero);
		salvar(arbol->der,fichero);
	}

}
