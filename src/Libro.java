import java.util.Scanner;

public class Libro {
	private String titulo;
	private String autor;
	private int isbn;
	private static int contador=0;
	private int cantidad;
	
	public Libro(){
		titulo = pideCadena("Introduce titulo del libro");
		autor = pideCadena("Introduce autor del libro");
		contador++;
		isbn = contador;
		cantidad = pideCantidad("¿Cuantos ejemplares hay?");
	}
	

	
	public String getTitulo() {
		return titulo;
	}



	public String getAutor() {
		return autor;
	}



	public int getIsbn() {
		return isbn;
	}

	public int getCantidad() {
		return cantidad;
	}



	public String pideCadena(String msj){
		Scanner sc = new Scanner(System.in);
		String dato;
		
		System.out.println(msj);
		dato = sc.nextLine();
		
		return dato;
	}
	
	public int pideCantidad(String msj){
		Scanner sc = new Scanner(System.in);
		int cantidad=0;
		
		System.out.println(msj);
		if(sc.hasNextInt()){
			cantidad = sc.nextInt();
			if(cantidad>0){
				return cantidad;
			}else{
				pideCantidad("Introduce un valor positivo");
			}
		}else{
			pideCantidad("Introduce un valor numerico");
		}
		return cantidad;
	}



	public static int getContador() {
		return contador;
	}
}
