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
    private long numerador;
    //Atributo privado para el denominador
    private long denominador;

    //// Constructores ////

    /**
     * Construye un nuevo {@code NumeroRacional} por defecto, con denominador 1.
     */
    public NumeroRacional (){
        this.denominador = 1;
    }

    /**
     * Construye un nuevo {@code NumeroRacional}.
     * @param numerador valor del numerador.
     * @param denominador valor del denominador. No puede ser cero.
     */
    public NumeroRacional (long numerador, long denominador){
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
    public long getNumerador(){
        return numerador;
    }

    /**
     * Metodo Set para modificar el denominador
     * @param numerador
     */
    public void setNumerador(long numerador){
        this.numerador = numerador;
    }

    /**
     * Metodo Get para obtener el denominador
     * @return denominador
     */
    public long getDenominador(){
        return denominador;
    }

    /**
     * Metodo Set para modificar el denominador
     * @param denominador
     */
    public void setDenominador(long denominador){
        this.denominador = denominador;
    }

    //// METODOS ADICIONALES ////

    /**
     * Metodo para sumar 2 numeros racionales.
     * @param numeroRacional
     */
    public NumeroRacional sumaRacional(NumeroRacional numeroRacional){
        NumeroRacional auxiliar = new NumeroRacional(this.numerador, this.denominador);
        
        if(auxiliar.denominador == numeroRacional.denominador){
            auxiliar.numerador += numeroRacional.numerador;
        }
        else{
            auxiliar.numerador = (auxiliar.numerador*numeroRacional.denominador + auxiliar.denominador*numeroRacional.numerador);
            auxiliar.denominador *= numeroRacional.denominador;
        }
        
        return auxiliar;
    }

    /**
     * Metodo para restar 2 numeros racionales.
     * @param numeroRacional
     */
    public NumeroRacional restaRacional(NumeroRacional numeroRacional){
	NumeroRacional auxiliar = new NumeroRacional(this.numerador, this.denominador);
        
        if(auxiliar.denominador == numeroRacional.denominador){
            auxiliar.numerador -= numeroRacional.numerador;
        }
        else{
            auxiliar.numerador = (auxiliar.numerador*numeroRacional.denominador - auxiliar.denominador*numeroRacional.numerador);
            auxiliar.denominador *= numeroRacional.denominador;
        }
        
        return auxiliar;
    }

    /**
     * Override del metodo toString() para la clase {@code NumeroRacional}.
     * return string : numero racional transformado en string
     */
    @Override
    public String toString(){
        if(denominador == 1 || numerador == 0){
            return " { "+ numerador +" } ";
        }
        return " { " + numerador + "/" + denominador + " } ";
    }

    /**
     * Override del metodo equals() para la clase {@code NumeroRacional}.
     */
    @Override
    public boolean equals(Object objeto){
	
		if (!(objeto instanceof NumeroRacional)){
			return false;
        }
		else{
			NumeroRacional otroNumero = (NumeroRacional) objeto;
	
			return (otroNumero.numerador * denominador == numerador * otroNumero.denominador);
	
        }
	
	
    }

}
