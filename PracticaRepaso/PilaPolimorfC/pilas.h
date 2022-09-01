//Perfiles de las funciones para la manipulacion de pilas

//Obj de un tipo incompleto
typedef struct pila* nodo;
typedef struct estructura_pila* tipo_pila;


//determina si una pila esta vacia
int es_vacia(tipo_pila pila);

//retorna una pila vacia
tipo_pila crear( void );

//retorna un puntero al elemento en la primera posicion
//si la pila esta vacia, retorna NULL
void * tope (tipo_pila pila);

//agrega un elemento en el tope de la lista.
//retorna 0 si la operacion se realiza correctamente
int apilar (tipo_pila pila, void *elem, int tipo);

// Desapila y devuelve el elemento en el tope de una pila no vacía
tipo_pila desapilar(tipo_pila pila);

// Elimina todos los elementos de la pila dejándola vacía
void vaciar(tipo_pila pila);

// Retorna la cantidad de elementos presentes en la pila
int elementos(tipo_pila pila);

//Accede al tope de una pila no vacía sin modificar a la misma
void tope2(tipo_pila pila);

