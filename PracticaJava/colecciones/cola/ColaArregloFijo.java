package colecciones.cola;

import java.util.Collection;

/**
* Implementación basada en arreglos de tamaño fijo de la interfaz {@code Cola}.
* @see colecciones.cola.Cola
*/
public class ColaArregloFijo<T> implements Cola<T> {

	/**
	* Capacidad máxima por defecto ({@value #CAPACIDAD_POR_DEFECTO})
	*/
	public static final int CAPACIDAD_POR_DEFECTO = 20;
	private Object[] arreglo;
	private int elementos;
	private int maxElem;

	/**
	* Construye una nueva cola vacía con una capacidad máxima de {@value #CAPACIDAD_POR_DEFECTO}.
	*/
	public ColaArregloFijo() {
		arreglo = new Object[CAPACIDAD_POR_DEFECTO];
		elementos = 0;
		maxElem = CAPACIDAD_POR_DEFECTO;
	}

	/**
	* Construye una nueva cola vacía con una capacidad determinada mayor a 0.
	* @param capacidad la capacidad de la cola
	* @throws IllegalArgumentException si {@code capacidad} es menor o igual a 0 
	*/
	public ColaArregloFijo(int capacidad) {
		if (capacidad <= 0 || capacidad >= CAPACIDAD_POR_DEFECTO){
			throw new IllegalArgumentException("la capacidad debe ser un numero positivo y menor a " + CAPACIDAD_POR_DEFECTO + ", y el valor: (" + capacidad + ") no lo es.");
		}
		arreglo = new Object[capacidad];
		elementos = 0;
		maxElem = capacidad;
	}

	/**
	* Construye una cola a partir de elementos en una colección.
	* Los elementos en la colección se encolan de izquierda a derecha.
	* La capacidad de la cola va a ser suficiente para por lo menos contener todos los elementos de la colección.
	* @param elems los elementos a agregar a la cola
	*/
	public ColaArregloFijo(Collection<T> elems) {
		if (elems == null)
			throw new IllegalArgumentException("elems es null");
		arreglo = new Object[Math.max(elems.size(), CAPACIDAD_POR_DEFECTO)];
		for (T e : elems) {
			encolar(e);	
		}
		maxElem = elementos = elems.size();
	}

	//// GETTERS AND SETTERS ////
	/*
	public Object[] getArreglo() {
		return arreglo;
	}

	public void setArreglo(Object objeto, int posicion){
		if(posicion<0 || posicion>=elementos){
			throw new IllegalArgumentException("Posicion no Valida");
		}
		arreglo[posicion] = objeto;
	}
		
	public int getElementos() {
		return elementos;
	}
	
	public void setElementos(int elementos){
		if(elementos<0 || elementos>CAPACIDAD_POR_DEFECTO){
						throw new IllegalArgumentException("Cantidad de elementos no Valido");
		}
		
		this.elementos = elementos;
	}
	*/
	//// IMPLEMENTACION DE COLA ////
	
	
	@Override
	public boolean esVacia() {
		return (elementos == 0);
	}

	@Override
	public boolean encolar(T elem) {
		if(elementos == maxElem){
			throw new IllegalArgumentException("Cola llena");
		}		
		
		arreglo[elementos] = elem;
		elementos += 1;
		
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T desencolar() {
		if(esVacia()){
			throw new IllegalStateException("Cola vacia");
		}
	
		T aux = (T) arreglo[0];
	
		for (int i=0; i<elementos-1; i++) {
			arreglo[i] = arreglo[i+1];
		}
		elementos -= 1;

		return aux;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T primero() {
		if(esVacia()){
			throw new IllegalStateException("Cola vacia");
		}

		return (T) arreglo[0];
	}

	@Override
	public void vaciar() {
		elementos = 0;
	}

	@Override
	public int elementos(){
		return elementos;
	}

	@Override
	public boolean repOK() {
		return true; //No se que hace	
	}

	@Override
	public String toString() {
		if(esVacia()){
			return "{ }";
		}

		String cadena = "{ ";

		for(int i=0; i<elementos-1; i++){
			cadena += arreglo[i] + ", ";
		}
		cadena += arreglo[elementos-1];
		cadena += " }";

		return cadena;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object other) {
		if(other == null && this != null){
			return false;
		}
		if(!(other instanceof ColaArregloFijo)){
			return false;
		}

		ColaArregloFijo<T> nuevaCola = (ColaArregloFijo<T>) other;
		if(elementos != nuevaCola.elementos()){
			return false;
		}
		else{
			for(int i=0; i<elementos-1; i++){
				if(arreglo[i] != nuevaCola.arreglo[i]){
					return false;
				}
			}
		}
		
		return true;
	}

	/**
	* Permite obtener un elemento del arreglo en un indice determinado realizando el casteo necesario.
	* @param index el indice del elemento a obtener
	*/
	@SuppressWarnings("unchecked")
   	public T elemento(int index) {
		if(index<0 || index>=elementos){
			throw new IndexOutOfBoundsException("Posicion no valida");
		}
        return (T) arreglo[index];
    }

}
