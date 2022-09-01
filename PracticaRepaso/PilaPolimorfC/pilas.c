#include <stdio.h>
#include <stdlib.h>
#include "pilas.h"

//TODO: IMPLEMENTACION MOSTRAR P/ CHAR Y ENTEROS.

enum{ENTERO,CARACTER}; //Polimorfismo para int y char

struct pila {
	void * valor;
    int tipo_valor; //Para especificar el tipo que tendra de "enum"
	struct pila * sgte;
};

struct estructura_pila {
    nodo cabeza;
    int elementos;
};


int es_vacia(tipo_pila pila){
    // consulta si la pila est� vacia (0 = False, n>0 = True)
    return ( pila->elementos == 0 );
}

tipo_pila crear( void ){
	tipo_pila pila = ( tipo_pila ) malloc ( sizeof( struct estructura_pila ) );

	pila->cabeza = NULL;
	pila->elementos = 0;

	return pila;
}

void * tope (tipo_pila pila) {
    //retorna el tope de la pila
    if (es_vacia(pila)){
        printf("Error: lista vacia. \n");
        return NULL;
    } else {
        return (pila->cabeza)->valor;
    }
}

nodo crear_nodo(void* elemento ,int tipo){
	nodo linkable = ( nodo ) malloc ( sizeof( struct pila ) );

	linkable->valor = elemento;
    linkable->tipo_valor = tipo;
	linkable->sgte    = NULL;

	return linkable;
}


int apilar (tipo_pila pila, void *elem, int tipo){
    nodo linkable = crear_nodo(elem, tipo);
    
    linkable->sgte = pila->cabeza;
	pila->cabeza = linkable;
	pila->elementos = (pila->elementos) + 1;

	return 0;
}

void tope2(tipo_pila pila){

    if(es_vacia(pila)){
     
        printf("Pila Vacia, no hay TOPE.\n");
    }else{
           
        if((pila->cabeza)->tipo_valor == ENTERO){

            printf("%d\n", *(int*)(pila->cabeza)->valor);
        
        }else{
            printf("%c\n", *(char *)(pila->cabeza)->valor);
        }
    }
}

tipo_pila desapilar(tipo_pila pila){

    if(es_vacia(pila)){
        printf("Pila ya vacia, imposible desapilar.\n");
        return pila;
    }

    nodo puntero = pila->cabeza;
    pila->cabeza = (pila->cabeza)->sgte;

    free(puntero);
    pila->elementos = (pila->elementos) - 1;

    return pila;
     
}

void vaciar(tipo_pila pila){
    nodo aux = pila->cabeza;
    while (aux != NULL)
    {
        pila->cabeza = (pila->cabeza)->sgte;
        free(aux);
        aux = pila->cabeza;
        pila->elementos = (pila->elementos) - 1;
    }  
}

// Retorna la cantidad de elementos presentes en la pila
int elementos(tipo_pila pila){
    return pila->elementos;
}