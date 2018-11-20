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
		
	}
	
	public void colorearSecuenciaWelshPowell(String pathGrafo) {
		
	}
	
	public void colorearSecuenciaAleatoria(String pathGrafo) {
		
	}
	
	private void colorear() {
		
	}
	
	private void leerArchivoIn(String nombreArchivo) {
		Scanner sc = null;
		try {
			sc = new Scanner(new File("C:\\Users\\Florencia\\Documents\\Programacion Avanzada"
					+ "\\TPGRAFOS\\AlgoritmosColoreo\\TPGRAFOS\\Grafos Entrada\\" + nombreArchivo + ".in"));
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
					+ "\\TPGRAFOS\\AlgoritmosColoreo\\TPGRAFOS\\Resultados Coloreo\\" + nombreArchivo + ".out"));
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
