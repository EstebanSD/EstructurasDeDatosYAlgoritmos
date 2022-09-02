package main;

import datos.NumeroRacional;
/**
* La clase {@code MainRacional} implementa una aplicación simple para mostrar el uso de {@code NumeroRacional}.
* Esta clase no usa parámetros, el comportamiento está completamente "hardcodeado" requiriendo modificiar y recompilar para hacer pruebas.
* @see datos.NumeroRacional
* @version 1.0
*/
public class MainRacional {
    
    /**
	* Experimenta con racionales.
	* @param args : arguments for this main method, not used in this implementation.
	* @see Object#equals(Object)
	*/
    public static void main ( String[] args) {

        NumeroRacional numero = new NumeroRacional();
        NumeroRacional numero2 = new NumeroRacional(1L,2L);


        System.out.println(numero);
        System.out.println(numero2);
        
        numero.restaRacional(numero2);

        System.out.println(numero);
    }
}
