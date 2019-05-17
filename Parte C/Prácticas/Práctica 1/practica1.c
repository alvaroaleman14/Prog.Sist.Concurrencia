/*
 * practica1.c
 *
 *  Created on: 8/3/2019
 *      Author: Álvaro
 */

#include <stdio.h>
#include <stdlib.h>
#include "gestion_memoria.h"

int main (){
	T_Manejador manejador;
	crear(&manejador);
	mostrar(manejador);
	destruir(&manejador);
	mostrar(manejador);
	return 0;
}
