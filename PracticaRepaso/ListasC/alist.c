#include "lista_enteros.h"
#include <stdio.h>
#include <stdlib.h>

#define Nmax 200


struct estructura_lista{
    int array[Nmax];
    int cant;
};


tipo_lista crear( void ){
    tipo_lista puntArreglo = (tipo_lista) malloc(sizeof (struct estructura_lista));

    puntArreglo->cant = 0;

    return puntArreglo;
}

int es_vacia( tipo_lista lista ){

    return (lista->cant == 0);
}

int es_valido( tipo_lista lista,int posicion ){

    if((posicion < 0)||(lista->cant < posicion)){
        return 0;//NO es Valido
    }else{
        return 1;//Si es Valido
    }
    
}

tipo_lista agregar( tipo_lista lista, int elemento ){

    lista->array[lista->cant] = elemento;
    lista->cant = (lista->cant) + 1;

    return lista;
}

tipo_lista fin( tipo_lista lista, int elemento ){

    if(lista->cant == Nmax){
        printf("Arreglo lleno.\n");
        return lista;
    }

    lista->array[(lista->cant)] = elemento;
    lista->cant = (lista->cant) + 1;

    return lista;

}

int ins( tipo_lista lista, int elemento, int position){

    if( (position < 0) || (lista->cant < position ) ){
        printf("Posición no válida\n");
        return -1;
    }

    if(position == 0){
        agregar(lista, elemento);
        return 0;
    }

    if(position == (lista->cant) - 1){
        fin(lista, elemento);
        return 0;
    }

    int aux;
    //Inserto a la vez que desplazo un lugar a la derecha
    for(int i = position; i < lista->cant; i++){
        aux = lista->array[i];
        lista->array[i] = elemento;
        elemento = aux; //Actualizo el valor a insertar
    }

    lista->cant = (lista->cant) + 1;
    return 0;
}

int eliminar_comienzo( tipo_lista lista ){

    if(es_vacia(lista)){
        printf("No se puede eliminar, Arreglo vacío\n");
        return -1;
    }

    int aux;
    for(int i=0; i<(lista->cant) - 1; i++){
        lista->array[i] = lista->array[i+1];
    }

    lista->cant = lista->cant - 1;
    return 0; 
}

int eliminar( tipo_lista lista, int posicion){

    if(es_vacia(lista)){
        printf("No se puede eliminar, Arreglo vacio.\n");
        return -1;
    }

    if((posicion < 0) || (lista->cant < posicion)){
        printf("Posicion no valida.\n");
        return -1;
    }

    if(posicion == 0){
        eliminar_comienzo(lista);
        return -1;
    
    }else{
        for(int i=posicion; i < (lista->cant)-1 ; i++){
            lista->array[i] = lista->array[i+1];  
        }
        lista->cant = (lista->cant) - 1;
        return 0;
    }

}

int obtener( tipo_lista lista, int position ){

    if( ! es_valido(lista, position)){
        printf("Posicion no Valida.\n");
        return -1;
    }

    return lista->array[position];


}

tipo_lista reversa( tipo_lista lista ){
    tipo_lista puntReversa = crear();

    for(int i= (lista->cant)-1; i>=0; i--){
        agregar(puntReversa, obtener(lista,i));
    }
    puntReversa->cant = lista->cant;
}

tipo_lista concat( tipo_lista ini, tipo_lista cola ){
    tipo_lista puntConcat = crear(); //Cuidado en caso de que la suma de ini y cola tengan mas elementos que Nmax

    for(int i=0; i < ini->cant; i++){
        fin(puntConcat, obtener(ini,i));
    }
    for(int i=0; i < cola->cant; i++){
        fin(puntConcat, obtener(cola,i)); 
    }

    return puntConcat;
}

tipo_lista sub( tipo_lista lista, int ini, int fin ){
    tipo_lista puntSub = crear();

    if((ini>fin) || es_valido(lista,ini) || es_valido(lista,fin)){
        printf("Posiciones no validas\n");
        return lista;
    }

    for(int i=ini; i <= fin; i++){
        agregar(puntSub, obtener(lista,i));
    }
    puntSub->cant = (fin - ini);

    return puntSub;
}

tipo_lista copia( tipo_lista lista ){
    return sub(lista, 0, (lista->cant)-1);
}

// retorna el primer elemento de una lista no vacia.
int cabeza( tipo_lista lista );

// retorna todos los elementos de la lista menos el primero.
tipo_lista cola( tipo_lista lista );

// muestra el contenido de la lista en la salida estandar 'std'
void mostrar( tipo_lista lista );

// reemplaza el elemento que esta en una posición dada con otro 
// elemento dado y retornar el elemento reemplazado
int reemplazar(tipo_lista lista, int elem, int pos);

// dada una lista y dos posiciones de elementos enteros, la función los intercambia
int intercambiar(tipo_lista lista, int pos1, int pos2);