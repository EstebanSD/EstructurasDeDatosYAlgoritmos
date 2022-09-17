package colecciones.main;


import colecciones.cola.ColaArregloFijo;

public class MainCola {
    
    public static void main ( String[] args ){

        //Contructor por Defecto
        ColaArregloFijo<Integer> colaEnteros = new ColaArregloFijo<>();
        System.out.println("esVacia(): " + colaEnteros.esVacia());
        colaEnteros.encolar(2);
        colaEnteros.encolar(-8);
        colaEnteros.encolar(4);
        colaEnteros.encolar(9);
        colaEnteros.encolar(-1);
        System.out.println("esVacia(): " + colaEnteros.esVacia());
        
        System.out.println(colaEnteros.elementos() + " elementos");
        System.out.println(colaEnteros);
        System.out.println("Primer elemento: " + colaEnteros.primero());

        //Constructor segun la capacidad
        //ColaArregloFijo<Character> colaChar = new ColaArregloFijo<>(21);
        ColaArregloFijo<Character> colaChar2 = new ColaArregloFijo<>(10);
        colaChar2.encolar('o');        
        colaChar2.encolar('H');
        colaChar2.encolar('o');
        colaChar2.encolar('l');
        colaChar2.encolar('a');
        colaChar2.encolar('M');
        colaChar2.encolar('u');
        colaChar2.encolar('n');
        colaChar2.encolar('d');
        colaChar2.encolar('o');
        //colaChar2.encolar('o');

        System.out.println(colaChar2.elementos() + " elementos");
        System.out.println(colaChar2);
        System.out.println("elemento desencolado: " + colaChar2.desencolar());
        System.out.println(colaChar2.elementos() + " elementos");
        System.out.println(colaChar2);
        colaChar2.vaciar();
        System.out.println(colaChar2.elementos() + " elementos");
        System.out.println(colaChar2);
        
        // Equals //
        ColaArregloFijo<Integer> colaEnteros2 = new ColaArregloFijo<>();
        System.out.println("colaEnteros.equals(colaEnteros2)?? " + colaEnteros.equals(colaEnteros2));
        colaEnteros2.encolar(2);
        System.out.println("colaEnteros.equals(colaEnteros2)?? " + colaEnteros.equals(colaEnteros2));
        colaEnteros2.encolar(-8);
        colaEnteros2.encolar(4);
        colaEnteros2.encolar(9);
        colaEnteros2.encolar(-1);
        System.out.println("colaEnteros.equals(colaEnteros2)?? " + colaEnteros.equals(colaEnteros2));

        System.out.println("colaEnteros.equals(colaChar2)?? " + colaEnteros.equals(colaChar2));
        
        colaEnteros2.vaciar();
        System.out.println("colaEnteros2.equals(colaChar2)?? " + colaEnteros2.equals(colaChar2));
        //Si bien son Null, son de <T> distintos.....como hacer para chequear eso?
    }
}
