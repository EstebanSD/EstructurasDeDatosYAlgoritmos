package colecciones.pila;

public class NodoPila<T> {
    
    private T info;
    private NodoPila<T> next;

    /// CONSTRUCTOR ///
    public NodoPila (){
    }

    public NodoPila(T info, NodoPila<T> next){
        this.info = info;
        this.next = next;
    }

    /// GETTERS AND SETTERS ///
    public T getInfo(){
        return info;
    }

    public void setInfo(T info){
        this.info = info;
    }

    public NodoPila<T> getNext(){
        return next;
    }

    public void setNext(NodoPila<T> next){
        this.next = next;
    }
    
}
