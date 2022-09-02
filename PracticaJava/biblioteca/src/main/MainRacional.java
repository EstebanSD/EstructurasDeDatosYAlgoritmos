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

        NumeroRacional numero = new NumeroRacional(); // 0/1 = 0
        //NumeroRacional numero2 = new NumeroRacional(1,2); //Problemas en la suma/resta
        //NumeroRacional numero3 = new NumeroRacional(-1,2); //Problemas en la suma/resta
        NumeroRacional numero4 = new NumeroRacional(1L,2L);
        NumeroRacional numero5 = new NumeroRacional(-1L,2L);
        //NumeroRacional numero6 = new NumeroRacional(1L,0L); // InvalidParameterException

        /// Mostrar por pantalla distintas construcciones ///
        System.out.println("Numeros Racionales:\n");
        System.out.println(numero);
        //System.out.println(numero2);
        //System.out.println(numero3);
        System.out.println(numero4);
        System.out.println(numero5);

        /// Resta de Racionales ///
        System.out.println("Resta de Racionales:\n");
        //numero.restaRacional(numero2); // 0 - 1/2 = -1/2
        //numero.restaRacional(numero3); // -1/2 - (-1/2) = 0

        numero.restaRacional(numero4); // 0 - 1/2 = -1/2
        System.out.println(numero);
        numero.restaRacional(numero5); // -1/2 - (-1/2) = 0
        System.out.println(numero);

        /// Suma de Racionales ///
        System.out.println("Suma de Racionales:\n");
        //numero3.sumaRacional(numero4); // -1/2 + 1/2 = 0 , pero no es asi
        //numero3.sumaRacional(numero5); // 0 + -1/2 = -1/2  
        
        numero.sumaRacional(numero4); // 0 + 1/2 = 1/2
        System.out.println(numero);
        numero.sumaRacional(numero5); // 1/2 + (-1/2) = 0
        System.out.println(numero);


        /// Equals ///
        NumeroRacional numeroEq = new NumeroRacional(0,2);
        NumeroRacional numeroEq2 = new NumeroRacional(0L,2L);
        
        System.out.println("Equals y == \n");
        System.out.println(numero + " y " + numeroEq + " Son iguales usando equals? " + (numero.equals(numeroEq)));
		System.out.println(numero + " y " + numeroEq + " Son iguales usando ==? " + (numero == numeroEq));
        System.out.println(numero + " y " + numeroEq2 + " Son iguales usando equals? " + (numero.equals(numeroEq2)));
		System.out.println(numero + " y " + numeroEq2 + " Son iguales usando ==? " + (numero == numeroEq2));
        System.out.println(numeroEq + " y " + numeroEq2 + " Son iguales usando equals? " + (numeroEq.equals(numeroEq2)));
		System.out.println(numeroEq + " y " + numeroEq2 + " Son iguales usando ==? " + (numeroEq == numeroEq2));
		
        System.out.println(numero4 + " y " + numero5 + " Son iguales usando equals? " + (numero4.equals(numero5)));
		System.out.println(numero4 + " y " + numero5 + " Son iguales usando ==? " + (numero4 == numero5));
        numero5.sumaRacional(numero4);
        numero5.sumaRacional(numero4);
        System.out.println(numero4 + " y " + numero5 + " Son iguales usando equals? " + (numero4.equals(numero5)));
		System.out.println(numero4 + " y " + numero5 + " Son iguales usando ==? " + (numero4 == numero5));

    }
}
