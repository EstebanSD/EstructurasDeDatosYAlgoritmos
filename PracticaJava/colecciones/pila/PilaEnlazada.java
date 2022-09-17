package colecciones.pila;

public class PilaEnlazada<T> implements Pila<T> {

    private NodoPila<T> cabeza; //Elemento ficticio
    private int cant;

    /// CONSTRUCTOR ///
    /**
     * Constructor por defecto, que asigna al siguiente nodo del elemento ficticio @{@code cabeza}, 
     * el objeto vacio {@code Null}
     */
    public PilaEnlazada(){
        NodoPila<T> nodo = new NodoPila<>();
        cabeza = nodo;
    }

    /**
     * Constructor que recive como parametro un {@code NodoPila} y se lo asigna al siguiente nodo
     * del elemento ficticio {@code cabeza} el resto de nodos que pueda traer este parametro
     * @param nodo
     */
    public PilaEnlazada(NodoPila<T> nodo){
        if(nodo == null){
            cabeza.setNext(null);
            cant = 0;
        }
        else{
            NodoPila<T> aux = nodo;

            cabeza.setNext(aux);
            cant = 1;
            while( aux != null ){
                aux = aux.getNext();
                cant += 1;
            }
        }
    }

    /// GETTERS AND SETTERS ///
    public NodoPila<T> getCabeza(){
        return cabeza.getNext();
    }

    public void setCabeza(NodoPila<T> nodo){
        NodoPila<T> aux = cabeza.getNext();
        
        nodo.setNext(aux.getNext());
        cabeza.setNext(nodo);
    }

    public int getCant(){
        return cant;
    }
    
    public void setCant(int cant){
        this.cant = cant;
    }

    /// IMPLEMENTACION DE LOS METODOS DE PILA<T> ///
    
    @Override
    public boolean esVacia() {
        return (cant == 0); //Aunque con (cabeza.getNext == null) se obtiene el mismo resultado
    }

    @Override
    public boolean apilar(T elem) {
        NodoPila<T> nuevo = new NodoPila<>(elem, cabeza.getNext());
        cabeza.setNext(nuevo);
        cant += 1;

        return true;
    }

    @Override
    public T desapilar() {
        if(esVacia()){
            throw new IllegalStateException("Pila vacia");
        }

        NodoPila<T> aux = cabeza.getNext();
        cabeza.setNext(aux.getNext());
        cant -= 1;

        return aux.getInfo();
    }

    @Override
    public T tope() {
        if(esVacia()){
            throw new IllegalStateException("Pila vacia");
        }

        return cabeza.getNext().getInfo();
    }

    @Override
    public void vaciar() {
        cabeza.setNext(null);
        cant = 0;
    }

    @Override
    public int elementos() {
        return cant;
    }

    @Override
    public boolean repOK() {
        // Todavia no se que hace
        return false;
    }
    
    @Override
    public String toString(){
        NodoPila<T> aux = cabeza.getNext();
        String cadena = "Cabeza -> ";

        if(aux == null){
            return cadena + "Null";
        }
        else{
            while(aux != null){
                cadena += aux.getInfo() + " -> ";
                aux = aux.getNext();
            }
            return cadena + "Null";
        }

    }

    /// IMPLEMENTACION PARTICULAR PARA EL EJERCICIO ///
    /**
     * Metodo que dado un {@code NodoPila<T>} imprime todos los elementos en orden inverso.
     * @param nodo
     */
    public void reversa(NodoPila<T> nodo){
        if(nodo == null){
        }
        else{
            reversa(nodo.getNext());
            System.out.println(nodo.getInfo());
        }
    }


}
