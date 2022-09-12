package colecciones.main;

import colecciones.lista.ListaEncadenada;




public class MainLista {
    
    public static void main ( String[] args) {


        ListaEncadenada<String> listaDeString = new ListaEncadenada<>();

        String string1 = "Hola ";
        String string2 = "Mundo ";
        String string3 = "!!!";

        listaDeString.agregar(string1);
        listaDeString.agregar(string2);
        listaDeString.agregar(string3);

        System.out.println(listaDeString.elementos());
        System.out.println(listaDeString);

        /// Agregar Todos (Con y sin lista vacia) ///
        ListaEncadenada<String> listaDeString2 = new ListaEncadenada<>();
        ListaEncadenada<String> listaDeStringVacia = new ListaEncadenada<>();

        String string4 = "Como ";
        String string5 = "estan ";
        String string6 = "???";

        listaDeString2.agregar(string4);
        listaDeString2.agregar(string5);
        listaDeString2.agregar(string6);

        listaDeString.agregarTodos(listaDeString2);
        listaDeStringVacia.agregarTodos(listaDeString2);

        System.out.println(listaDeString.elementos());
        System.out.println(listaDeString);

        System.out.println(listaDeStringVacia.elementos());
        System.out.println(listaDeStringVacia);

        /// Insertar Pos ///
        ListaEncadenada<Integer> listaDeInteger = new ListaEncadenada<>();

        listaDeInteger.agregar(20);
        listaDeInteger.agregar(5);
        listaDeInteger.agregar(-7);

        System.out.println(listaDeInteger);
        //listaDeInteger.insertar(8, -1);//Indice fuera de rango
        //listaDeInteger.insertar(8, 3);//Indice fuera de rango
        listaDeInteger.insertar(8, 0);//Insertar a la cabeza
        listaDeInteger.insertar(3,2);//Insertar en la pos 2
        System.out.println(listaDeInteger);

        /// Eliminar Pos ///
        //listaDeInteger.eliminar(-1);//Indice fuera de rango
        //listaDeInteger.eliminar(5);//Indice fuera de rango
        System.out.println(listaDeInteger.eliminar(0));;//Elimina a la cabeza y muestra el eliminado
        System.out.println(listaDeInteger);

        System.out.println(listaDeInteger.eliminar(2));;//Elimina en la pos=3 y muestra el eliminado
        System.out.println(listaDeInteger);
        
        /// Obtener ///
        ListaEncadenada<Character> listaDeChar = new ListaEncadenada<>();
        listaDeChar.agregar('E');
        listaDeChar.agregar('s');
        listaDeChar.agregar('t');
        listaDeChar.agregar('a');
        listaDeChar.agregar('E');
        listaDeChar.agregar('s');
        listaDeChar.agregar('U');
        listaDeChar.agregar('n');
        listaDeChar.agregar('a');
        listaDeChar.agregar('L');
        listaDeChar.agregar('i');
        listaDeChar.agregar('s');
        listaDeChar.agregar('t');
        listaDeChar.agregar('a');
        System.out.println(listaDeChar);
        System.out.println(listaDeChar.obtener(0));//Obtiene el primer elemento 'E'
        System.out.println(listaDeChar.obtener(5));//Obtiene el 6to elemento 's'

        /// SubLista ///
        ListaEncadenada<Character> listaDeChar2 = new ListaEncadenada<>();

        //listaDeChar2 = (ListaEncadenada<Character>) listaDeChar.subLista(3, 0);//Indices Fuera de Rango
        //listaDeChar2 = (ListaEncadenada<Character>) listaDeChar.subLista(0, 0);//Lista Vacia
        listaDeChar2 = (ListaEncadenada<Character>) listaDeChar.subLista(4, 9);    
        System.out.println(listaDeChar2);
        //System.out.println(listaDeChar);//La Lista Original queda intacta
    
        
        /// Contiene ///
        listaDeInteger.agregar(4);
        listaDeInteger.agregar(10);
        listaDeInteger.agregar(-98);
    
        System.out.println(listaDeInteger.contiene(-7));//True
        System.out.println(listaDeInteger.contiene(5));//False

        /// Vaciar ///
        System.out.println(listaDeString);
        listaDeString.vaciar();
        System.out.println(listaDeString);

        /// Es Vacia ///
        System.out.println(listaDeChar.esVacia());//False
        System.out.println(listaDeString.esVacia());//True

        /// Equals ///
        System.out.println(listaDeString.equals(listaDeString));
        System.out.println(listaDeString.equals(listaDeChar));
        System.out.println(listaDeChar.equals(listaDeChar2));

        ListaEncadenada<Character> listaDeChar3 = (ListaEncadenada<Character>) listaDeChar.subLista(4, 9);
        System.out.println(listaDeChar3.equals(listaDeChar2));


    } 
}
