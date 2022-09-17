package colecciones.lista;

public class Nodo<T> {
    
    // Atributo destinado al elemento a manipular
    private T info;
    // Atributo destinado a referenciar el siguiente elemento de la lista
    private Nodo<T> siguiente;

    /// CONSTRUCTOR ///
    public Nodo(){
    }

    public Nodo (T info, Nodo<T> siguiente){
        this.info = info;
        this.siguiente = siguiente;
    }

    /// GETTERS AND SETTERS ///

    public T getInfo(){
        return info;
    }

    public void setInfo(T info){
        this.info = info;
    }

    public Nodo<T> getSiguiente(){
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente){
        this.siguiente = siguiente;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals (Object otro){
        if(otro == null){
            return false;
        }
        if(otro == this){
            return true;
        }
        if(!(otro instanceof Nodo)){
            return false;
        }

        Nodo<T> nuevoNodo = (Nodo<T>) otro;
        if(nuevoNodo.info == null && info != null){
            return false;
        }
        return nuevoNodo.getInfo().equals(info);
    }
}
