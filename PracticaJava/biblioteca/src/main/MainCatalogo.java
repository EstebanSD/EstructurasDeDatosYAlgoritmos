package main;

import datos.Libro;
import catalogo.Catalogo;

/**
* La clase {@code MainCatalogo} implementa una aplicación simple para mostrar el uso de {@code Catalogo} junto con {@code Libro}.
* Esta clase no usa parámetros, el comportamiento está completamente "hardcodeado" requiriendo modificiar y recompilar para hacer pruebas.
* @see catalogo.Catalogo
* @see datos.Libro
* @version 1.0
*/
public class MainCatalogo {

	/**
	* Experimenta con {@code Catalogo}, agregar libros, buscar, y mostrar el {@code Catalogo}.
	* @param args : arguments for this main method, not used in this implementation.
	*/
	public static void main(String[] args) {
		Libro libro1 = new Libro("Isaac Asimov", "The Caves of Steel", 42);
		Libro libro2 = new Libro("Isaac Asimov", "The Naked Sun", 47);
		Libro libro3 = new Libro("Jhon Katzenbach","Retrato en Sangre", 629);
		Libro libro4 = new Libro("Nicolas Maquiavelo", "El Principe", 158);
		Libro libro5 = new Libro("Edgar Allan Poe", "Narraciones Extraordinarias", 206);
		//Libro libro6 = new Libro("Federico Garcia Lorca", "La Casa de Bernarda Alba", 93);
		
		//Instancia de Catalogo
		Catalogo catalogo = new Catalogo(5); // capacidad se redujo a 5 para tirar la excepcion



		catalogo.agregarLibro(libro1);
		catalogo.agregarLibro(libro2);
		catalogo.agregarLibro(libro3);
		catalogo.agregarLibro(libro4);
		catalogo.agregarLibro(libro5);
		//catalogo.agregarLibro(libro6); // ArrayIndexOutOfBoundsException

		
		System.out.println(catalogo);

		Libro libro7, libro8;
		libro7 = catalogo.buscarPorTitulo( "La Vuelta al Mundo en 80 dias"); //null
		libro8 = catalogo.buscarPorTitulo( "The Caves of Steel");
		System.out.println(libro7);
		System.out.println(libro8);
	} 

}
