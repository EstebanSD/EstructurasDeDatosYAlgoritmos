package colecciones.pila;

/**
* Esta clase representa una cola de objetos <b>last in first out (LIFO)</b> donde el ultimo elemento insertado es el primero que se accede.
* Las operaciones disponibles para esta estructura son:
* <ul>
*   <li> apilar			: Apila un nuevo elemento y evalua si fue apilado con exito</li>
*   <li> desapilar	: Desapila y retorna el elemento</li>
*   <li> tope				: Retorna el primer elemento sin desapilar</li>
*   <li> esVacia		: Permite consultar si la pila está vacía</li>
*   <li> vaciar			: Remueve todos los elementos de la pila</li>
*   <li> elementos	: Retornar la cantidad de elementos presentes</li>
*   <li> repOK			: Permite validar si una instancia satisface el invariante de representación</li>
*   <li> toString		: Retorna una representación en forma de cadena</li>
*   <li> equals			: Permite evaluar si otra instancia de pila es igual a esta</li>
* </ul>
*/
public interface Pila<T> {
	
	/**
	* Permite evaluar si la pila no tiene elementos.
	* @return {@code true} sii la pila no tiene elementos
	*/
	public boolean esVacia();

	/**
	* Apila un elemento en el tope de la pila.
	* @param elem el elemento a apilar
	* @return {@code true} sii el elemento pudo ser apilado
	*/
	public boolean apilar(T elem);

	/**
	* Desapila el primer elemento de la pila, y retorna el elemento desapilado, si ésta no es vacía.
	* @return el primer elemento de la pila
	* @throws IllegalStateException si la pila está vacía
	* @see #esVacia()
	*/
	public T desapilar();

	/**
	* Retorna el tope de la pila, si ésta no es vacía.
	* @return primer elemento de la pila
	* @throws IllegalStateException si la pila está vacía
	* @see #esVacia()
	*/
	public T tope();

	/**
	* Remueve todos los elementos en la pila.
	*/
	public void vaciar();

	/**
	* @return cantidad de elementos en la pila.
	*/
	public int elementos();

	/**
	* Invariante de clase.
	* @return {@code true} sii la pila satisface su invariante de clase
	*/
	public boolean repOK();

	@Override
	public String toString();

	@Override
	public boolean equals(Object other);

}
