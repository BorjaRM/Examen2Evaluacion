import java.util.Scanner;

public class Ejercicio1 {
	private int matriz[][];

	public static void main(String[] args) {
		Ejercicio1 ej = new Ejercicio1();
				
		ej.rellenaMatrizInicial();
		ej.imprimeMatrizInicial();
		ej.realizaCalculos();
		ej.reimprimeMatriz();
		
		//En cas de querer pedir parametros al usuario:
		
		/*Scanner sc = new Scanner(System.in);
		System.out.println("Elige un tamaño de fila");	
		int fila = sc.nextInt();
		sc.nextLine();
		System.out.println("Elige un tamaño de columna");	
		int columna = sc.nextInt();
		Ejercicio1 ej2 = new Ejercicio1(fila,columna);
		
		ej2.rellenaMatrizInicial();
		ej2.imprimeMatrizInicial();
		ej2.realizaCalculos();
		ej2.reimprimeMatriz();*/

		
		
	}
	
	public Ejercicio1(){
		matriz = new int [5][5];
	}
	
	public Ejercicio1(int filas, int columnas){
		matriz = new int [filas][columnas];
	}
	
	public void rellenaMatrizInicial(){
		int numeroAleatorio =0;
		
		for(int i=0;i<matriz.length;i++){ 
			for(int j=0;j<matriz[i].length;j++){ 
				if(i==matriz.length-1 || j==matriz[i].length-1){
					matriz[i][j]=0;
				}else{
				numeroAleatorio = (int) (Math.random()*9+1);
				matriz[i][j]=numeroAleatorio;
				}						
			}			
		}
	}
	
	public void imprimeMatrizInicial(){
		System.out.println("Imprimiendo matriz en su estado inicial:");
		
		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz[i].length;j++){
				if(i==matriz.length-1 || j==matriz[i].length-1){
					System.out.print("-" +"\t");
				}else
				System.out.print(matriz[i][j] +"\t");			
			}
			System.out.println("");
		}
	}
	
	public void realizaCalculos(){
		int ultimaFila=matriz.length-1;
		int ultimaColumna=matriz[0].length-1;
		
		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz[i].length;j++){
				if(j==ultimaColumna){
					matriz[i][j]=sumaFilas(i);
				}else if(i == ultimaFila){
					matriz[i][j] = sumaColumnas(j);
				}				
			}
		}
		System.out.println("");

	
	}
	
	public int sumaFilas(int posFija){
		int totalHorizontal =0;
		
		for(int i=0; i<matriz[posFija].length; i++){
			totalHorizontal = totalHorizontal +matriz[posFija][i];
		}
		return totalHorizontal;
	}
	
	public int sumaColumnas(int posFija){
		int totalVertical =0;
		
		for(int i=0; i<matriz.length;i++){
			totalVertical = totalVertical + matriz[i][posFija];
		}
		return totalVertical;
	}
	
	public void reimprimeMatriz(){
		System.out.println("Imprimiendo matriz con los calculos:");

		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz[i].length;j++){
				System.out.print(matriz[i][j] +"\t");				
			}
			System.out.println("");
		}
	}

}
