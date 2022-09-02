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
    private Long numerador;
    //Atributo privado para el denominador
    private Long denominador;

    //// Constructores ////

    /**
     * Construye un nuevo {@code NumeroRacional} por defecto, con denominador 1.
     */
    public NumeroRacional (){
        this.numerador = 0L;
        this.denominador = 1L;
    }

    /**
     * Constructor para instanciar una clase {@code NumeroRacional} con valores del tipo primitivo int.
     * @param n valor del tipo int para el numerador.
     * @param d valor del tipo int para el denominador.
     */
    public NumeroRacional (int n, int d){
        long num = n;
        long deno = d;

        this.numerador = num;
        this.denominador = deno;
    }

    /**
     * Construye un nuevo {@code NumeroRacional}.
     * @param numerador valor del numerador.
     * @param denominador valor del denominador. No puede ser cero.
     */
    public NumeroRacional (Long numerador, Long denominador){
        if(denominador == 0L){
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
    public Long getNumerador(){
        return numerador;
    }

    /**
     * Metodo Set para modificar el denominador
     * @param numerador
     */
    public void setNumerador(Long numerador){
        this.numerador = numerador;
    }

    /**
     * Metodo Get para obtener el denominador
     * @return denominador
     */
    public Long getDenominador(){
        return denominador;
    }

    /**
     * Metodo Set para modificar el denominador
     * @param denominador
     */
    public void setDenominador(Long denominador){
        this.denominador = denominador;
    }

    //// METODOS ADICIONALES ////

    /**
     * Metodo para sumar 2 numeros racionales.
     * @param numeroRacional
     */
    public void sumaRacional(NumeroRacional numeroRacional){
        if(denominador == numeroRacional.getDenominador()){
            numerador += numeroRacional.getNumerador();
        }
        else{
            numerador = (numerador*numeroRacional.getDenominador() + denominador*numeroRacional.getNumerador());
            denominador *= numeroRacional.getDenominador();
        }
    }

    /**
     * Metodo para restar 2 numeros racionales.
     * @param numeroRacional
     */
    public void restaRacional(NumeroRacional numeroRacional){
        if(denominador == numeroRacional.getDenominador()){
            numerador -= numeroRacional.getNumerador();
        }
        else{
            numerador = (numerador*numeroRacional.getDenominador() - denominador*numeroRacional.getNumerador());
            denominador *= numeroRacional.getDenominador();
        }
    }

    /**
     * Override del metodo toString() para la clase {@code NumeroRacional}.
     * return string : numero racional transformado en string
     */
    @Override
    public String toString(){
        if(denominador == 1L){
            return " { "+ numerador +" } ";
        }
        return " { " + numerador + "/" + denominador + " } ";
    }

    /**
     * Override del metodo equals() para la clase {@code NumeroRacional}.
     */
    @Override
    public boolean equals(Object objeto){
        if (objeto == null){
			return false;
        }
		if (objeto == this){
			return true;
        }
		if (!(objeto instanceof NumeroRacional)){
			return false;
        }

		NumeroRacional otroNumero = (NumeroRacional) objeto;
		if (otroNumero.numerador == null && numerador != null){
			return false;
        }
		if (otroNumero.denominador == null && denominador != null){
			return false;
        }
		if (!otroNumero.numerador.equals(numerador)){
			return false;
        }
		if (!otroNumero.denominador.equals(denominador)){
			return false;
        }
		return true;
    }
}
