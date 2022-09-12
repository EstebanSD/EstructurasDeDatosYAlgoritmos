package colecciones.lista; //SOLO LA CARPETA NO HACE FALTA INCLUIR LA CLASE

/** 
* Implementacion de Interface {@code Lista} con listas encadenadas, ayudandoce de otra clase {@code Nodo} para manipular los nodos.
*/

public class ListaEncadenada<T> implements Lista<T>{

	// Atributo que referencia a la lista que queremos manipular
	private Nodo<T> puntero;
	// Atributo destinado para contar la cantidad de elementos
	private int cant; 

	//// CONSTRUCTOR ////
	
	public ListaEncadenada(){
	}
	
	/**
	 * Constructor de la clase {@code ListaEncadenada}
	 * @param puntero : puntero de tipo Nodo<T>
	 * @param cant : cantidad
	 */
	public ListaEncadenada(Nodo<T> puntero){
		this.puntero = new Nodo<T>(puntero.getInfo(),null);
	}
	
	//// GETTERS AND SETTERS ////


	public Nodo<T> getPuntero(){
		return puntero;
	}

	//Metodo SET de la clase, pero que para esta implementacion, funciona como un insertar a la cabeza
	private void setPuntero(Nodo<T> puntero){
		this.puntero = puntero;
	}
	
	public int getCant(){
		return cant;
	}

	public void setCant(int cant){
		this.cant = cant;
	}

	//// Implementacion de Metodos de Lista ////

	/**
	* Agrega un elemento al final de la lista.
	* @param elem el elemento a agregar
	* @return {@code true} sii el elemento pudo ser agregado
	*/
	public boolean agregar(T elem){
		Nodo<T> nodo = new Nodo<T>(elem,null);

		if(this.puntero == null){
			this.puntero = nodo;
			this.cant += 1;

			return true;
		}
		else{
			Nodo<T> actual = this.puntero;
			
			while(actual.getSiguiente() != null){
				actual = actual.getSiguiente();
			}
			actual.setSiguiente(nodo);
			this.cant += 1;

			return true;
		}
	}
	
	/**
	* Agrega todos los elementos de otra lista, al final de esta lista.
	* @param otraLista lista conteniendo todos los elementos a agregar al final de esta lista
	* @return {@code true} sii todos los elementos en {@code otraLista} fueron agregados
	*/
	public boolean agregarTodos(Lista<T> otraLista){
		ListaEncadenada<T> SegundaLista = (ListaEncadenada<T>) otraLista;
		Nodo<T> aux = SegundaLista.getPuntero();

		//Si la primer lista esta vacia, inserto la lista directamente y la recorro para saber su cantidad
		if(this.puntero == null){
			this.puntero = aux;
			this.cant +=1;

			while (aux.getSiguiente() != null){
				aux = aux.getSiguiente();
				this.cant +=1;
			}
			
			return true;
		}
		//De lo contrario recorro hasta llegar al final de la primer lista y le inserto la segunda,
		//recorro esta ultima para saber cuantos elementos tiene
		else{
			Nodo<T> actual = this.puntero;
			
			while(actual.getSiguiente() != null){
				actual = actual.getSiguiente();
			}
			
			actual.setSiguiente(aux);
			this.cant += 1;

			while (aux.getSiguiente() != null){
				aux = aux.getSiguiente();
				this.cant +=1;
			}

			return true;
		}
	}

	/**
	* Agrega un elemento en una posicion particular de la lista.
	* @param elem el elemento a agregar
	* @param indice el indice donde se agrega el elemento
	* @return {@code true} sii el elemento pudo ser agregado
	* @throws IndexOutOfBoundsException si {@code indice} &lt; {@code 0}
	*/
	public boolean insertar(T elem, int indice){
		if(indice < 0 || cant<= indice){
			throw new IndexOutOfBoundsException("Indice fuera de rango");
		}
		if(indice == 0){
			Nodo<T> nuevo = new Nodo<>(elem,puntero);

			setPuntero(nuevo);
			this.cant += 1;
		
			return true;
		}	

		Nodo<T> nuevo = new Nodo<>(elem,null);
		Nodo<T> aux = new Nodo<>();

		aux = puntero;
		
		for(int i=0; i<indice-1; i++){
			aux = aux.getSiguiente();
		}

		nuevo.setSiguiente(aux.getSiguiente());
		aux.setSiguiente(nuevo);
		cant += 1;

		return true;
	}

	/**
	* Elimina un elemento de esta lista en una posición particular.
	* @param indice el indice el elemento a eliminar
	* @return el elemento eliminado
	* @throws IndexOutOfBoundsException si ({@code indice} &lt; {@code 0} || {@code indice} &ge; {@code #elementos()})
	* @see #elementos() 
	*/
	public T eliminar(int indice){
		if(indice < 0 || cant<= indice){
			throw new IndexOutOfBoundsException("Indice fuera de Rango");
		}

		Nodo<T> eliminado = new Nodo<>();
		
		if(indice == 0){
			eliminado = puntero;
			setPuntero(puntero.getSiguiente());
			cant -= 1;
			return eliminado.getInfo();
		}

		Nodo<T> aux = new Nodo<>();

		aux = puntero;
		for(int i=0; i<indice-1; i++){
			aux = aux.getSiguiente();
		}

		eliminado = aux.getSiguiente();
		aux.setSiguiente(eliminado.getSiguiente());
		cant -= 1;

		return eliminado.getInfo();
	}
	
	/**
	* Obtiene un elemento de esta lista en una posición particular.
	* @param indice el indice el elemento a obtener
	* @return el elemento en la posición {@code indice}
	* @throws IndexOutOfBoundsException si ({@code indice} &lt; {@code 0} || {@code indice} &ge; {@code #elementos()})
	* @see #elementos() 
	*/
	public T obtener(int indice){
		if(indice < 0 || cant<=indice){
			throw new IndexOutOfBoundsException("Indice fuera de Rango");
		}
		if(indice == 0){
			return puntero.getInfo();
		}

		Nodo<T> aux = puntero;
		
		for(int i=0; i<indice;i++){
			aux = aux.getSiguiente();
		}
		return aux.getInfo();
	}
	
	/**
	* Retorna la porción de esta lista entre los índice especificados {@code desdeInd}, inclusivo, y {@code hastaInd}, exclusivo, en una nueva lista.
	* Si {@code fromInd} es igual a {@code hastaInd} se retorna un a lista vacía.
	* @param desdeInd el índice inferior, inclusivo
	* @param hastaInd el índice superior, exclusivo
	* @return una nueva lista formada con los elementos entre {@code desdeInd} hasta {@code hastaInd - 1} de esta lista
	* @throws IndexOutOfBoundsException si ({@code fromInd} &lt; {@code 0} || {@code hastaInd} &gt; {@code #elementos()} || {@code desdeInd} &gt; {@code hastaInd})
	* @see #elementos() 
	*/
	public Lista<T> subLista(int desdeInd, int hastaInd){
		if(desdeInd<0 || cant<=hastaInd || desdeInd>hastaInd){
			throw new IndexOutOfBoundsException("Indices fuera de Rango");
		}

		ListaEncadenada<T> nuevaLista = new ListaEncadenada<>();
		
		if( desdeInd == hastaInd ){
			return nuevaLista; //Retorno la lista vacia
		}

		Nodo<T> aux = puntero;
		for(int i=0; i<desdeInd; i++){ //Me paro en el elemento 'desdeInd'
			aux = aux.getSiguiente();
		}

		nuevaLista.agregar(aux.getInfo());

		for(int i=desdeInd; i<hastaInd-1; i++){
			aux = aux.getSiguiente();
			nuevaLista.agregar(aux.getInfo());
		}

		return nuevaLista;
	}

	/**
	* Evalua si esta lista contiene un elemento particular, utilizando el método {@code equals(Object)}.
	* @param elem el elemento a buscar
	* @return {@code true} sii, existe un elemento {@code e} en la lista, tal que {@code e == null && elem == null || e.equals(elem)}
	*/
	public boolean contiene(T elem){
		
		Nodo<T> aux = puntero;

		while(aux != null){
			if(aux.getInfo()==null && elem==null){
				return true;
			}
			if(aux.getInfo().equals(elem)){
				return true;
			}

			aux = aux.getSiguiente();
		}
		return false;
	}

	/**
	* Remueve todos los elementos en la lista.
	*/
	public void vaciar(){
		puntero = null;
		cant = 0;
	}
	
	/**
	* Retorna la cantidad de elementos agregados a la lista.
	* @return cantidad de elementos en la lista
	*/
	public int elementos(){
		return cant;
	}

	/**
	* Permite evaluar si la lista no tiene elementos.
	* Este método es equivalente a:
	* <pre>lista.elementos() == 0</pre>
	* @return {@code true} sii la pila no tiene elementos
	*/
	public boolean esVacia(){
		return (elementos() == 0);
	}

	/**
	* Invariante de clase.
	* @return {@code true} sii la lista satisface su invariante de clase
	*/
	public boolean repOK(){
		return true;
	}

	/**
	* Retorna una representación como {@code String} de esta lista. La representación como {@code String} consiste de los elementos en esta lista, en el orden correspondiente a la implementación de la misma, encerrados entre corchetes ("[]"). 
	* Elementos adyacentes están separados mediante los caractéres ", " (coma y espacio). Los elementos son convertidos mediante {@code String.valueOf(Object)}.
	* @return una representación como {@code String} de esta lista
	*/
	@Override
	public String toString(){
		Nodo<T> nodo = puntero;
		String nodos = "";

		while(nodo != null){
			nodos += nodo.getInfo() + " -> ";
			nodo = nodo.getSiguiente();
		}

		return "Cabeza -> " + nodos + " null \n Cantidad: " + cant + "\n";
	}
	
	/**
	* Evalúa igualdad entre esta y otra lista. La igualdad considera que el tamaño de ambas listas es el mismo, y que los elementos de ambas listas son iguales considerando el orden de los mismos de acuerdo a la implementación de cada lista.
	* La igualdad entre elementos se realiza considerando si ambos son {@code null} o, en caso contrario, mediante el método {@code equals(Object)}.
	* @return {@code true} sii ambas listas tienen los mismos elementos.
	*/
	@Override
	public boolean equals(Object otro){
		if(!(otro instanceof ListaEncadenada)){
			return false;
		}
		
		ListaEncadenada<T> nuevoOtro = (ListaEncadenada<T>) otro;
		if(this.cant != nuevoOtro.cant){
			return false;
		}
		
		Nodo<T> aux1 = puntero;
		Nodo<T> aux2 = nuevoOtro.getPuntero();
		while(aux1 != null){
			if(!(aux2.equals(aux1))){
				return false;
			}
			aux1 = aux1.getSiguiente();
			aux2 = aux2.getSiguiente();
		}

		return true;
	}

}
