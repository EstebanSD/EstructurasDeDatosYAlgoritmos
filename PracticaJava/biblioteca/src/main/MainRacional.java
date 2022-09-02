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
        NumeroRacional numero2 = new NumeroRacional(1,2);
        NumeroRacional numero3 = new NumeroRacional(1L,2L);
        //NumeroRacional numero4 = new NumeroRacional(1L,0L); // InvalidParameterException

        /// Mostrar por pantalla distintas construcciones ///
        System.out.println("Numeros Racionales:\n");
        System.out.println(numero);
        System.out.println(numero2);
        System.out.println(numero3);

        /// Resta de Racionales ///
        System.out.println("Resta de Racionales:\n");
        numero.restaRacional(numero2);
        System.out.println(numero);
        System.out.println(numero2);
       
        /// Suma de Racionales ///
        System.out.println("Suma de Racionales:\n");
        numero2.sumaRacional(numero3);
        System.out.println(numero2);
        System.out.println(numero3);
    }
}
