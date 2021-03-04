package tema4;
/**
 * @author Jose Maria Moreno Rueda
 * @version 1.0 04/03/2021
 * 
 * Esta clase imprime por consola todos los numeros primos creados mediante la criba de Eratostenes
 * desde 0 hasta la cantidad indicada 
 */
import java.util.Scanner;
public class CrearNumerosPrimos {
	private int contador = 0;
	private final int cantidadIndicada;
	private final int limiteArray;
	private boolean[] arrayAuxiliarBooleano;
	
	/**
	 * Setrata del constructor de la clase principal
	 * <code> Constructor de la clase</code> CrearNumerosPrimos
	 * @param n parametro que indica el limite hasta donde se deben calcular los números primos
	 * 
	 */
	public CrearNumerosPrimos(int n) {
		this.cantidadIndicada = n;
		this.limiteArray = n + 1;
	}
	/**
	 * Este metodo nos devuelve un dato de tipo entero con la cantidad de números primos existentes
	 * @return <code>Contador</code>
	 */
	private int cantidadNumerosPrimos() {
		for (int i = 0; i < this.limiteArray; i++) {
			if (arrayAuxiliarBooleano[i])
				contador++;
		}
		return contador;
	}
	/**
	 * Este metodo crea un array de tipo booleano necesario para la creación del array final
	 */
	private void crearArrayBooleano() {
		arrayAuxiliarBooleano = new boolean[this.limiteArray];
		for (int i = 0; i < this.limiteArray; i++) {
			arrayAuxiliarBooleano[i] = true;
		}
		arrayAuxiliarBooleano[0] = arrayAuxiliarBooleano[1] = false;
		for (int i = 2; i < (Math.sqrt(this.limiteArray) + 1); i++) {
			if (arrayAuxiliarBooleano[i]) {
				for (int j = (2 * i); j < this.limiteArray; j +=i)
					arrayAuxiliarBooleano[j] = false;
			}
		}
	}
	/**
	 * Este metodo devuelve un array de tipo entero con los numeros primos existentes
	 * Para ello necesita del array auxiliar <code>arrayAuxiliarBooleano</code>
	 * @return El array arrayNumerosPrimos que contiene los números primos
	 */
	private int[] devuelveArrayNumerosPrimos() {
		int [] arrayNumerosPrimos = new int[this.cantidadNumerosPrimos()];
		for (int i = 0, j = 0; i < this.limiteArray; i++) {
			if (arrayAuxiliarBooleano[i]) {
				arrayNumerosPrimos[j++] = i;
			}
		}
		return arrayNumerosPrimos;
	}
	/**
	 * Este metodo 
	 * @param max nos indica el limite hasta donde se deben crear los numeros primos
	 * @return un array de datos de tipo entero
	 */
	private int[] generarPrimos (int max) {
		if (max >= 2) {
			this.crearArrayBooleano();
			return this.devuelveArrayNumerosPrimos();
			
		} else { // max < 2
			return new int[0];
		}
	}
	/**
	 * Este metodo sirve para imprimir por consola tanto el array que contiene a todos los 
	 * números, sean primos o no, como el array que contiene exclusivamnete los números primos creados
	 */
	private void muestraResultado() {
		System.out.println("\nVector inicial hasta: "+ this.cantidadIndicada);
		for (int i = 0; i < this.cantidadIndicada; i++) {
			if (i%10==0) System.out.println();
			System.out.print( i + 1 + "\t");
		}
		int[] vector = this.generarPrimos(this.cantidadIndicada);
		System.out.println("\nVector de primos hasta: "+ this.cantidadIndicada);
		for (int i = 0; i < vector.length; i++) {
			if (i%10==0) System.out.println();
			System.out.print(vector[i] + "\t");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce el número para la criba de Erastótenes: ");
		int datoInicial=sc.nextInt();
		sc.close();
		CrearNumerosPrimos miCriba = new CrearNumerosPrimos(datoInicial);
		miCriba.muestraResultado();
	}
}