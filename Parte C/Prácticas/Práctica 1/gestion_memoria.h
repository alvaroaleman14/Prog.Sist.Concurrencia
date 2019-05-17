
/*
 * gestion_memoria.h
 *
 *  Created on: 8/03/2019
 *  Author: Álvaro Alemán Rando
 */

#ifndef _GESTION_MEMORIA_
#define _GESTION_MEMORIA_

typedef struct T_Nodo* T_Manejador;

struct T_Nodo {
	unsigned inicio;
	unsigned fin;
	T_Manejador sig;
};

/* Crea la estructura utilizada para gestionar la memoria disponible. Inicialmente, solo un nodo desde 0 a MAX */
	void crear(T_Manejador* manejador);

/* Destruye la estructura utilizada (libera todos los nodos de la lista. El par�metro manejador debe terminar apuntando a NULL */
	void destruir(T_Manejador* manejador);

	void obtener(T_Manejador *manejador, unsigned tam, unsigned* dir, unsigned* ok);

/* Muestra el estado actual de la memoria, bloques de memoria libre */
	void mostrar (T_Manejador manejador);

/* Devuelve el trozo de memoria continua de tamaño y que
 * comienza en dir
 * Se puede suponer que se trata de un trozo obtenido previamente.
 */
	void devolver(T_Manejador *manejador,unsigned tam,unsigned dir);

#endif
