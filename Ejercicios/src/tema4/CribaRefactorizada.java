package tema4;

import java.util.Scanner;
public class CribaRefactorizada {
	private int contador = 0;
	private final int cantidadIndicada;
	private final int limiteArray;
	private boolean[] arrayAuxiliarBooleano;
	
	public CribaRefactorizada(int n) {
		this.cantidadIndicada = n;
		this.limiteArray = n + 1;
	}
	
	private int cantidadNumerosPrimos() {
		for (int i = 0; i < this.limiteArray; i++) {
			if (arrayAuxiliarBooleano[i])
				contador++;
		}
		return contador;
	}

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

	private int[] devuelveArrayNumerosPrimos() {
		int [] arrayNumerosPrimos = new int[this.cantidadNumerosPrimos()];
		for (int i = 0, j = 0; i < this.limiteArray; i++) {
			if (arrayAuxiliarBooleano[i]) {
				arrayNumerosPrimos[j++] = i;
			}
		}
		return arrayNumerosPrimos;
	}
	
	private int[] generarPrimos (int max) {
		if (max >= 2) {
			this.crearArrayBooleano();
			return this.devuelveArrayNumerosPrimos();
			
		} else { // max < 2
			return new int[0];
		}
	}
	
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
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce el número para la criba de Erastótenes: ");
		int datoInicial=sc.nextInt();
		sc.close();
		CribaRefactorizada miCriba = new CribaRefactorizada(datoInicial);
		miCriba.muestraResultado();
	}
}