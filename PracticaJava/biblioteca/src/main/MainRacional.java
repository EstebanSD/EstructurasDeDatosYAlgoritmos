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

	NumeroRacional resultadoSuma = new NumeroRacional();
	NumeroRacional resultadoResta = new NumeroRacional();
        NumeroRacional numero = new NumeroRacional(); // 0/1 = 0
        NumeroRacional numero2 = new NumeroRacional(1,2);
        NumeroRacional numero3 = new NumeroRacional(-1,2);
        NumeroRacional numero4 = new NumeroRacional(2,2);
        NumeroRacional numero5 = new NumeroRacional(-2,2);
        //NumeroRacional numero6 = new NumeroRacional(1,0); // InvalidParameterException

        /// Mostrar por pantalla distintas construcciones ///
        System.out.println("Numeros Racionales:\n");
        System.out.println(numero);
        //System.out.println(numero2);
        //System.out.println(numero3);
        System.out.println(numero4);
        System.out.println(numero5);

        /// Resta de Racionales ///
        System.out.println("Resta de Racionales:\n");
        //numero.restaRacional(numero2);
        //numero.restaRacional(numero3);

        resultadoResta = numero.restaRacional(numero4); // 0 - 1/2 = -1/2
        System.out.println(resultadoResta);
        resultadoResta = numero.restaRacional(numero5); // 0 - (-1/2) = 1/2
        System.out.println(resultadoResta);

        /// Suma de Racionales ///
        System.out.println("Suma de Racionales:\n");
        //numero3.sumaRacional(numero4);
        //numero3.sumaRacional(numero5);  
        
        resultadoSuma = numero.sumaRacional(numero4); // 0 + 1/2 = 1/2
        System.out.println(resultadoSuma);
        resultadoSuma = numero.sumaRacional(numero5); // 0 + (-1/2) = -1/2
        System.out.println(resultadoSuma);


        /// Equals ///
        NumeroRacional numeroEq = new NumeroRacional(0,2);
        NumeroRacional numeroEq2 = new NumeroRacional(0,1);
        
        System.out.println("Equals y == \n");
        System.out.println(numero + " y " + numeroEq + " Son iguales usando equals? " + (numero.equals(numeroEq)));
	System.out.println(numero + " y " + numeroEq + " Son iguales usando ==? " + (numero == numeroEq));
        System.out.println(numero + " y " + numeroEq2 + " Son iguales usando equals? " + (numero.equals(numeroEq2)));
	System.out.println(numero + " y " + numeroEq2 + " Son iguales usando ==? " + (numero == numeroEq2));
        System.out.println(numeroEq + " y " + numeroEq2 + " Son iguales usando equals? " + (numeroEq.equals(numeroEq2)));
	System.out.println(numeroEq + " y " + numeroEq2 + " Son iguales usando ==? " + (numeroEq == numeroEq2));
		
        System.out.println(numero4 + " y " + numero5 + " Son iguales usando equals? " + (numero4.equals(numero5)));
	System.out.println(numero4 + " y " + numero5 + " Son iguales usando ==? " + (numero4 == numero5));
        
        resultadoSuma = numero5.sumaRacional(numero4);
        resultadoSuma = numero5.sumaRacional(numero4);
        System.out.println(numero4 + " y " + resultadoSuma + " Son iguales usando equals? " + (numero4.equals(resultadoSuma)));
	System.out.println(numero4 + " y " + resultadoSuma + " Son iguales usando ==? " + (numero4 == resultadoSuma));
    	
    }
}
