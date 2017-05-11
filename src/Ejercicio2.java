import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2 {
	ArrayList<Libro> libros;

	public static void main(String[] args) {
		Ejercicio2 ej2 = new Ejercicio2();
		int opcion=0;
		
		
		
		do{
			ej2.menu();
			opcion = ej2.eligeOpcion("Elige un opcion",5);
			switch(opcion){
			case 1: ej2.añadirLibro(); break;
			case 2: ej2.buscarLibros(); break;
			case 3: ej2.borrarLibro(); break;
			case 4: break;

			}
		}while(opcion!= 4);
		
	}
	
	public Ejercicio2(){
		libros = new ArrayList<Libro>();
	}

	
	public void menu(){
		System.out.println("****MENU****");
		System.out.println("1-Introducir nuevo Libro");
		System.out.println("2-Buscar libro");
		System.out.println("3-Borrar libro por isbn");
		System.out.println("4-Salir");
	}
	public int eligeOpcion(String msj, int limite){
		Scanner sc = new Scanner(System.in);
		int opcion=0;
		
		System.out.println(msj);
		if(sc.hasNextInt()){
			opcion = sc.nextInt();
			if(opcion>0 && opcion<limite){
				return opcion;
			}else{
				eligeOpcion("Elige un valor del 1 al " +(limite-1),5);
			}
		}else{
			eligeOpcion("Introduce un valor numerico",5);
		}
		return opcion;
	}
	
	public void añadirLibro(){
		Libro l = new Libro();
		libros.add(l);
	}
	
	public void borrarLibro(){
		Scanner sc = new Scanner(System.in);
		int isbn;
		int posLibro;
		
		if(libros.size() != 0){
			isbn = pideIsbn("Introduce ISBN para eliminar el libro");
			posLibro = buscaPosicionLibro(isbn);
					
			if(posLibro !=-1){
				System.out.println("El libro " +libros.get(posLibro).getTitulo() +" ha sido eliminado");
				libros.remove(posLibro);
			}else{
				borrarLibro();
				System.out.print("Ese libro no existe en la biblioteca");
			}	
		}else{
			System.out.println("La biblioteca esta vacia");
		}
	}
	
	public int pideIsbn(String msj){
		Scanner sc = new Scanner(System.in);
		int isbn=0;
		
		System.out.println(msj);
		if(sc.hasNextInt()){
			isbn = sc.nextInt();
			if(isbn>0){
				return isbn;
			}else{
				pideIsbn("Introduce un valor positivo");
			}
		}else{
			pideIsbn("Introduce un valor numerico");
		}
		return isbn;
	}
	
	public int buscaPosicionLibro(int cod){
		int posLibro=-1;
		
		for(int i=0;i<libros.size();i++){
			if(libros.get(i).getIsbn() == cod){
				posLibro = i;
			}
		}
		
		return posLibro;
	}
	
	public void buscarLibros(){
		int opcion=0;
		menu2();
		opcion = eligeOpcion("Elige un opcion",3);
		
		switch(opcion){
			case 1:	buscaPorAutor(); break;
			case 2: buscarPorTitulo(); break;
		}

	}
	
	public void menu2(){
		System.out.println("Elija una opcion:");
		System.out.println("1-Buscar libro por autor");
		System.out.println("2-Buscar libro por titulo");
	}
	
	public void buscaPorAutor(){
		Scanner sc = new Scanner(System.in);
		String nombre;
		int contador=0;

		
		System.out.println("Introduce el nombre del autor");
		nombre = sc.nextLine();
		
		for(int i=0;i<libros.size();i++){
			if(libros.get(i).getAutor().equalsIgnoreCase(nombre)){
				System.out.println("Libro encontrado...");
				System.out.println("ISBN" +"\t" +"Titulo" +"\t" +"Autor" +"\t" +"Cantidad");
				System.out.println(libros.get(i).getIsbn() +"\t" +libros.get(i).getTitulo() 
						+"\t" +libros.get(i).getAutor() +"\t" + libros.get(i).getCantidad());				
			}else if(contador==0){
				System.out.println("No existe ningun libro de ese autor");
			}
		}
	
	}
	
	public void buscarPorTitulo(){
		Scanner sc = new Scanner(System.in);
		String titulo;
		int contador=0;
		
		System.out.println("Introduce el titulo del libro");
		titulo = sc.nextLine();
		
		for(int i=0;i<libros.size();i++){
			if(libros.get(i).getTitulo().equalsIgnoreCase(titulo)){
				contador++;
				System.out.println("Libro encontrado...");
				System.out.println("ISBN" +"\t" +"Titulo" +"\t" +"Autor" +"\t" +"Cantidad");
				System.out.println(libros.get(i).getIsbn() +"\t" +libros.get(i).getTitulo() 
						+"\t" +libros.get(i).getAutor() +"\t" + libros.get(i).getCantidad());				
			}else if(contador==0){
				System.out.println("No existe ningun libro con ese titulo");
			}
		}
	}
	
	
}
