package catalogo;

import java.security.InvalidParameterException;

import datos.Libro;

/**
* La clase {@code Catalogo} representa un catálogo de libros ({@code Libro}) implementado sobre un arreglo.
* Los métodos principales ofrecidos por esta clase son:
* <ul>
* 	<li>Agregar un nuevo Libro al catálogo.</li>
*	<li>Buscar un Libro por su título</li>
* </ul>
* Esta implementación no realiza ningún tipo de verificación, específicamente:
* <ul>
*	<li>No verifica que un Libro agregado sea no nulo ({@code null}).</li>
*	<li>No verifica que la capacidad para crear un nuevo Catalogo sea mayor o igual a {@code 1}.</li>
* </ul>
* @see Libro
* @version 1.0
*/
public class Catalogo {

	/**
	* La capacidad por defecto de un nuevo Catalogo.
	*/
	public static final int CAPACIDAD_POR_DEFECTO = 50;

	//el arreglo interno de libros.
	private Libro[] libros;
	//cantidad maxima de libros.
	private int maxCant;
	//la cantidad actual de libros almacenados.
	private int nroLibros;
	
	/**
	* Construye un nuevo {@code Catalogo} usando una capacidad de {@value #CAPACIDAD_POR_DEFECTO}.
	*/
	public Catalogo() {
		libros = new Libro[CAPACIDAD_POR_DEFECTO];
		maxCant = CAPACIDAD_POR_DEFECTO;
		nroLibros = 0;
	}
	
	/**
	* Construye un nuevo {@code Catalogo} con una capacidad dada.
	* @param capacidad : la capacidad del nuevo {@code Catalogo}.
	*/
	public Catalogo(int capacidad) {
		libros = new Libro[capacidad];
		maxCant = capacidad;
		nroLibros = 0;
	}
	
	//// GETTERS AND SETTERS ////

	/**
	 * Metodo Get para retornar los libros asociados al catalogo
	 * @return libros
	 */
	public Libro[] getLibros(){
		return libros;
	}

	/**
	 * Metodo Set para modificar un libro en la posicion {@code pos}
	 * @param libro Libro a modificar
	 * @param pos posicion en la que se encuentra el libro a modificar
	 */
	public void setLibros(Libro libro, int pos){
		if(pos < 0 || nroLibros < pos){
			throw new InvalidParameterException("Posicion invalida");
		}
		else{
			this.libros[pos] = libro;
		}	
	}

	//El metodo Set de este atributo no tiene sentido que se emplee
	/**
	 * Metodo Get para obtener el numero maximo de libros del {@code Catalogo}
	 * @return maxCant 
	 */
	public int getMaxCant(){
		return maxCant;
	}

	/**
	 * Metodo Get para obtener el numero de libros del {@code Catalogo}
	 * @return nroLibros 
	 */
	public int getNroLibros(){
		return nroLibros;
	}

	/**
	 * Metodo Set para modificar el numero de libros del {@code Catalogo}
	 * @param nro
	 */
	public void setNroLibros(int nro){
		this.nroLibros = nro;
	}

	//// METODOS ADICIONALES ////

	/**
	* Retorna {@code true} si este {@code Catalogo} no tiene más capacidad para almacenar libros.
	* @return {@code true} sii no hay capacidad disponible.
	*/
	public boolean estaLleno() {
		return (nroLibros == maxCant);
	}
	
	/**
	* Agrega un nuevo {@code Libro} a este {@code Catalogo} si el mismo no se encuentra lleno.
	* @param libro : el nuevo {@code Libro} a agregar.
	* @return {@code true} sii el {@code Libro} pudo ser agregado, es decir, {@code estaLleno()} retornó {@code false} previamente a llamar a este método.
	* @see #estaLleno()
	*/
	public boolean agregarLibro(Libro libro) {
		if(estaLleno()){
			throw new ArrayIndexOutOfBoundsException("Catalogo lleno");
		}
		else{
			libros[nroLibros] = libro;
			nroLibros += 1;

			return true;
		}
	}
	
	/**
	* Busca un {@code Libro} de acuerdo a un título dado.
	* @param titulo : el título del {@code Libro} a buscar.
	* @return un libro {@code l} que pertenece a este {@code Catalogo} sii {@code l.titulo().equals(titulo)}, {@code null} en caso contrario.
	*/
	public Libro buscarPorTitulo(String titulo) {
		if(nroLibros == 0){
			throw new NullPointerException("Catalogo Vacio");
		}
		else{
			
			for (int i=0; i<nroLibros; i++){
				if(titulo.equals(libros[i].getTitulo())){
					return libros[i];
				}
			}

			return null;
		}
	}

	
	@Override
	public String toString() {
		String cadenaLibros = new String();
		
		cadenaLibros = "";
		for (int i=0; i<nroLibros; i++){
			cadenaLibros += libros[i].toString() + "\n";
		}
		
		return "Catalogo [ \n" + cadenaLibros + "\n NumLibros: "+ nroLibros +" ]";

	}
	

}
