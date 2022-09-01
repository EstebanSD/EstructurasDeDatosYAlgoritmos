#include "pilas.h"
#include <stdio.h>
#include <stdlib.h>

//Puntero para poder registrar el input del usuario y guardarlo en un TIPO
typedef struct TIPO *valor;

/*
	Lugar donde voy a estar viendo lo que ingresa el usuario por input,
	en este caso, solo sera algo del tipo 'int' o 'char'.
*/
struct TIPO{
	int entero;
	char caracter;
};


//Muestra por pantalla el menu principal
void menuPrincipal();

//Da la opcion de elegir que tipo de elemento agregar
void elegirTipo(tipo_pila pila, valor type);

//Muestra un mensaje al salir del programa
void cartelSalir();



int main(){

    int valorMenu;

    tipo_pila pila = crear();

	valor type = (valor) malloc (sizeof (struct TIPO));

	do{
		menuPrincipal();
        printf("\nIngrese un valor entre 1 y 6.\n");
		scanf("%d",&valorMenu);
		switch(valorMenu){
			case 1: {
				printf("\nEl elemento tope de la pila es: ");
				tope2(pila);
				break;
			};
			case 2: {
				elegirTipo(pila, type);
				break;
			}
			case 3: {
				pila = desapilar(pila);
				break;
			}
			case 4: {
				vaciar(pila);
				break;
			}
			case 5: {
                printf("\nEl largo de la pila es de: %d elementos.\n", elementos(pila));
				break;
			}
			case 6: {
				cartelSalir();
				break;
			}
		}
	}while(valorMenu != 6);

	

}


void menuPrincipal(){
	printf("\n");
	printf("|-------------------|\n");
	printf("| Pila Polimorfica  |\n");
	printf("| Elige una opcion: |\n");
	printf("|-------------------|\n\n");
	printf("1: (TOPE) Ver el ultimo elemento de la Pila.\n");
	printf("2: (APILAR) Agregar un elemento a la Pila.\n");
	printf("3: (DESAPILAR) Eliminar un elemento de la Pila.\n");
	printf("4: (VACIAR) Borrar todos los elementos de la Pila.\n");
	printf("5: (ELEMENTOS) Mostrar el largo de la Pila.\n");
	printf("6: Salir\n");
}

void elegirTipo(tipo_pila pila, valor type){
    
    int valorTipo;
	//int valorInt;
	//char valorChar;


    printf("\nSi desea apilar un entero ingrese el valor 0, de lo contrario\n");
    printf("si desea apilar un caracter, ingrese el valor 1.\n\n");
    scanf("%d", &valorTipo);

    if(valorTipo == 0){

        printf("\nIngrese el entero que desea apilar: ");
//		scanf("%d", &valorInt);					No funciona...ya que al darle &valorInt si bien
//		apilar(pila, &valorInt, valorTipo);		le doy el elemento, apilar() lo toma como una direccion de memoria
        scanf("%d", &(type->entero));
        apilar(pila, &(type->entero), valorTipo);

    }else{

        printf("\nIngrese el caracter que desea apilar: ");
        scanf("%s", &(type->caracter));//pequeño parche, ya que si usaba %c no era suficiente espacio y me agregaba 2 elementos a la Pila
        apilar(pila, &(type->caracter), valorTipo);
    }
}

void cartelSalir(){
	printf("\n");
	printf("|---------------------------------------------------|\n");
	printf("|  Gracias por utilizar nuestra Pila Polimorfica!   |\n");
	printf("|---------------------------------------------------|\n");
	printf("\n");
}

