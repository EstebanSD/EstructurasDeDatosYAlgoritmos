package colecciones.main;

import colecciones.pila.PilaCheck;
import colecciones.pila.PilaEnlazada;

public class MainPilaCheck {
    
    public static void main ( String[] args ) {

        PilaEnlazada<Character> pilaChar = new PilaEnlazada<>();
        PilaEnlazada<Character> pilaChar2 = new PilaEnlazada<>();
        PilaEnlazada<Character> pilaChar3 = new PilaEnlazada<>();
        PilaEnlazada<Character> pilaChar4 = new PilaEnlazada<>();
        PilaEnlazada<Character> pilaChar5 = new PilaEnlazada<>();//Pila Vacia
        
        PilaCheck pilaCheck = new PilaCheck();

        pilaChar.apilar('}');
        pilaChar.apilar(')');
        pilaChar.apilar('(');
        pilaChar.apilar('{');
        
        pilaChar2.apilar(')');
        pilaChar2.apilar('}');
        pilaChar2.apilar('(');
        pilaChar2.apilar('{');

        pilaChar3.apilar('}');

        pilaChar4.apilar('{');

        // Pila con una cadena Correcta
        if(pilaCheck.estaBalanceada(pilaChar)){
            System.out.println("La Pila " + pilaChar + " SI esta Balanceada.");
        }
        else{
            System.out.println("La Pila " + pilaChar + " NO esta Balanceada.");
        }
        System.out.println("PilaCheck: " + pilaCheck);
        //pilaCheck.vaciar();

        // Pila con una cadena Incorrecta
        if(pilaCheck.estaBalanceada(pilaChar2)){
            System.out.println("La Pila " + pilaChar2 + " SI esta Balanceada.");
        }
        else{
            System.out.println("La Pila " + pilaChar2 + " NO esta Balanceada.");
        }
        System.out.println("PilaCheck: " + pilaCheck);
        //pilaCheck.vaciar();

        // Pila con un elemento '}'
        if(pilaCheck.estaBalanceada(pilaChar3)){
            System.out.println("La Pila " + pilaChar3 + " SI esta Balanceada.");
        }
        else{
            System.out.println("La Pila " + pilaChar3 + " NO esta Balanceada.");
        }
        System.out.println("PilaCheck: " + pilaCheck);
        //pilaCheck.vaciar();

        // Pila con un elemento '{'
        if(pilaCheck.estaBalanceada(pilaChar4)){
            System.out.println("La Pila " + pilaChar4 + " SI esta Balanceada.");
        }
        else{
            System.out.println("La Pila " + pilaChar4 + " NO esta Balanceada.");
        }
        System.out.println("PilaCheck: " + pilaCheck);
        //pilaCheck.vaciar();

        // Pila Vacia
        if(pilaCheck.estaBalanceada(pilaChar5)){
            System.out.println("La Pila " + pilaChar5 + " SI esta Balanceada.");
        }
        else{
            System.out.println("La Pila " + pilaChar5 + " NO esta Balanceada.");
        }
        System.out.println("PilaCheck: " + pilaCheck);

    }
}
