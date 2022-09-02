package datos;

import java.security.InvalidParameterException;

/**
* La clase {@code NumeroRacional} representa un numero racional formado por los siguientes datos:
* <ul>
* 	<li>El numerador.</li>
*	<li>El denominador</li>
* </ul>
* 
* La implementación garantiza que los valores sean correctos con respecto a lo esperado de un numero racional:
* <ul>
* 	<li> El numerador siempre va a ser un numero.</li>
*	<li> El denominador no puede ser cero</li>
* </ul>
*
* @version 1.0
*/
public class NumeroRacional {
    
    //Atributo privado para el numerador
    private int numerador;
    //Atributo privado para el denominador
    private int denominador;

    //// Constructores ////

    /**
     * Construye un nuevo {@code NumeroRacional} por defecto, con denominador 1.
     */
    public NumeroRacional (){
        this.numerador = 0;
        this.denominador = 1;
    }

    /**
     * Construye un nuevo {@code NumeroRacional}.
     * @param numerador valor del numerador.
     * @param denominador valor del denominador. No puede ser cero.
     */
    public NumeroRacional (int numerador, int denominador){
        if(denominador == 0){
            throw new InvalidParameterException("Denominador Cero");
        }
        else{
            this.numerador = numerador;
            this.denominador = denominador;
        }
    }

    //// GETTERS AND SETTERS ////
    
    /**
     * Metodo Get para obtener el numerador
     * @return numerador
     */
    public int getNumerador(){
        return numerador;
    }

    /**
     * Metodo Set para modificar el denominador
     * @param numerador
     */
    public void setNumerador(int numerador){
        this.numerador = numerador;
    }

    /**
     * Metodo Get para obtener el denominador
     * @return denominador
     */
    public int getDenominador(){
        return denominador;
    }

    /**
     * Metodo Set para modificar el denominador
     * @param denominador
     */
    public void setDenominador(int denominador){
        this.denominador = denominador;
    }
}
