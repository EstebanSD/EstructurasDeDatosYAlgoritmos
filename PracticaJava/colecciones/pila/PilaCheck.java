package colecciones.pila;

/**
 * Clase destinada al ejercicio Obligatorio planteado por la materia Estructura de Datos y Algoritmos, 
 * dicha clase debe ser capaz de comprobar si una exprecion hecha de "{} y ()" esta balanceada o no.
 * "{ ( ) }" -> true, pero "{(})" -> false
 * Por tal motivo esta clase solo extiende de {@code PilaEnlazada<Character>}.
 */
public class PilaCheck extends PilaEnlazada<Character>{
    
    /**
     * Unico metodo de la clase {@code PilaCheck}
     * @param pila recibe una {@code PilaEnlazada<Character>}
     * @return {@code true} sii la pila esta balanceada.
     */
    public Boolean estaBalanceada(PilaEnlazada<Character> pila){

        NodoPila<Character> aux = pila.getCabeza();

        for(int i=0; i<pila.getCant(); i++){
            if(aux.getInfo() == '{' || aux.getInfo() == '('){
                this.apilar(aux.getInfo());
                this.setCant(this.getCant()+1);
            }

            if((aux.getInfo() == '}' || aux.getInfo() == ')' ) && this.esVacia()){
                return false;
            }
            else{
                if(aux.getInfo() == '}'){
                    if( this.desapilar() != '{' ){
                        return false;
                    }
                    this.setCant(this.getCant()-1);
                }
                if(aux.getInfo() == ')'){
                    if( this.desapilar() != '(' ){
                        return false;
                    }
                    this.setCant(this.getCant()-1);
                }
            }

            aux = aux.getNext();
        }

        // Para no tener que vaciarla en el main
        if(this.esVacia()){
            return true;
        }
        else{
            this.vaciar();
            return false;
        }
    }
}
