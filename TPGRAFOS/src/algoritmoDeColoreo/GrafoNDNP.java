package algoritmoDeColoreo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import clasesUtiles.MatrizSimetrica;

public class GrafoNDNP {
	
	private int [] secuencia;
	private int [] colorPorNodo;
	private MatrizSimetrica matrizAd;
	
	private int nodos, cantidadColores, cantidadAristas, porcAd, grMax, grMin;
	
	public void colorearSecuenciaMatula(String pathGrafo) {
		generarSecuenciaMatula();
		colorear();
	}
	
	public void colorearSecuenciaWelshPowell(String pathGrafo) {
		generarSecuenciaWelshPowell();
		colorear();
	}
	
	public void colorearSecuenciaAleatoria(String pathGrafo) {
		generarSecuenciaAleatoria();
		colorear();
	}
	
	private void colorear() {
		
	}
	
	private void leerArchivoIn(String nombreArchivo) {
		Scanner sc = null;
		try {
			sc = new Scanner(new File("C:\\Users\\Florencia\\Documents\\Programacion Avanzada"
					+ "\\TPGRAFOS\\Grafos Entrada\\" + nombreArchivo + ".in"));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		this.nodos = sc.nextInt();
		this.cantidadAristas = sc.nextInt();
		this.porcAd = sc.nextInt(); 
		this.grMax = sc.nextInt();
		this.grMin = sc.nextInt();
		
		this.secuencia = new int [this.nodos];
		this.colorPorNodo = new int [this.nodos];
		this.matrizAd = new MatrizSimetrica(this.nodos);
		
		for(int i = 0; i < this.cantidadAristas; i++) {
			matrizAd.set(1, sc.nextInt(), sc.nextInt());
		}
		
		sc.close();		
	}
	
	private void escribirArchivoOut(String nombreArchivo) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File("C:\\Users\\Florencia\\Documents\\Programacion Avanzada"
						+ "\\TPGRAFOS\\Resultados Coloreo\\" + nombreArchivo + ".out"));
			pw.println(this.nodos + " " + this.cantidadColores + " " + this.cantidadAristas 
					+ " " + this.porcAd + " " + this.grMax + " " + this.grMin);
			for(int i = 0 ; i < this.nodos ; i++) {
				pw.println(i + " " + this.colorPorNodo[i]);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		pw.close();
	}
	
	private void generarSecuenciaMatula() {
		
		int i, j;
		for(i = 0 ; i < this.nodos ; i++) {
			for(j = 0 ; j < this.nodos ; j++) {
				this.secuencia[i] = this.matrizAd.get(i, j);
			}
		}
		
		for (i = 0; i < this.secuencia.length; i++) {
	        for (j = 0; j < this.secuencia.length-i-1; j++) {
	            if(this.secuencia[i] < this.secuencia[i+1]){
	                int aux = this.secuencia[i+1];
	                this.secuencia[i+1] = this.secuencia[i];
	                this.secuencia[i] = aux;
	            }
	        }
	    }
		
		
		// el vector secuencia llenarlo con los grados de cada nodo recorriendo la matriz de adyacencia.
		// luego ordeno de menor a mayor. 
	}
	
	private void generarSecuenciaWelshPowell() {
		// el vector secuencia llenarlo con los grados de cada nodo recorriendo la matriz de adyacencia.
		// luego ordeno de mayor a menor
	}
	
	private void generarSecuenciaAleatoria() {
		// llenar el vector secuencia con los grados de los nodos y despues generar un random como indice para acceder
		//a la secuencia
	}
}
