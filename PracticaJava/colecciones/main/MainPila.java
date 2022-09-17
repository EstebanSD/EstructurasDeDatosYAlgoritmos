package colecciones.main;

import colecciones.pila.PilaEnlazada;

public class MainPila {

    public static void main ( String[] args ) {

        PilaEnlazada<Integer> pilaEnteros = new PilaEnlazada<>();

        System.out.println("La pila esta vacia? " + pilaEnteros.esVacia());
        //System.out.println("Cual es el TOPE? " + pilaEnteros.tope());
        System.out.println(pilaEnteros);
        System.out.println("Cantidad de elementos: " + pilaEnteros.elementos());

        pilaEnteros.apilar(15);
        pilaEnteros.apilar(-1);
        pilaEnteros.apilar(87);
        pilaEnteros.apilar(0);
        System.out.println("La pila esta vacia? " + pilaEnteros.esVacia());
        System.out.println(pilaEnteros);

        System.out.println("Elemento desapilado: " + pilaEnteros.desapilar());
        System.out.println(pilaEnteros);
        System.out.println("Cantidad de elementos: " + pilaEnteros.elementos());
        System.out.println("Cual es el TOPE? " + pilaEnteros.tope());
        System.out.println("Elemento desapilado: " + pilaEnteros.desapilar());
        System.out.println("Cual es el TOPE? " + pilaEnteros.tope());

        System.out.println("pilaEnteros.vaciar();");
        pilaEnteros.vaciar();
        System.out.println("La pila esta vacia? " + pilaEnteros.esVacia());

        System.out.println("\nProbando reversa");
        pilaEnteros.apilar(15);
        pilaEnteros.apilar(-1);
        pilaEnteros.apilar(87);
        pilaEnteros.apilar(0);
        System.out.println(pilaEnteros);
        pilaEnteros.reversa(pilaEnteros.getCabeza());
        System.out.println("La pila sigue intacta? \n" + pilaEnteros);
    }
    
}
