package algoritmoDeColoreo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

import clasesUtiles.MatrizSimetrica;
import clasesUtiles.Nodo;

public class GrafoNDNP {
	
	private ArrayList<Nodo> nodos;
	private int [] colorPorNodo;
	private MatrizSimetrica matrizAd;
	
	private int cantidadNodos, cantidadColores, cantidadAristas, porcAd, grMax, grMin;
	
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
					+ "\\TPGRAFOS\\AlgoritmosColoreo\\TPGRAFOS\\Grafos Entrada\\" + nombreArchivo + ".in"));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		this.cantidadNodos = sc.nextInt();
		this.cantidadAristas = sc.nextInt();
		this.porcAd = sc.nextInt(); 
		this.grMax = sc.nextInt();
		this.grMin = sc.nextInt();
		
		this.nodos = new ArrayList<>();
		
		this.colorPorNodo = new int [this.cantidadNodos];
		this.matrizAd = new MatrizSimetrica(this.cantidadNodos);
		
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
			pw.println(this.cantidadNodos + " " + this.cantidadColores + " " + this.cantidadAristas 
					+ " " + this.porcAd + " " + this.grMax + " " + this.grMin);
			for(int i = 0 ; i < this.cantidadNodos ; i++) {
				pw.println(i + " " + this.colorPorNodo[i]);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		pw.close();
	}
	
	private void obtenerNodos() {
		int contador;
		
		for(int i = 0; i < this.cantidadNodos; i++) {
			contador = 0;
			for(int j = 0; j < this.cantidadNodos; j++) {
				// Suma 1 cuando existe arista y nada cuando no existe, sin preguntar.
				contador += this.matrizAd.get(i, j);
			}
			
			this.nodos.add(new Nodo(i, contador));
		}
	}
	
	private void generarSecuenciaMatula() {

		obtenerNodos();
		
		Collections.sort(this.nodos, null);
		
		// el vector secuencia llenarlo con los grados de cada nodo recorriendo la matriz de adyacencia.
		// luego ordeno de menor a mayor. 
	}
	
	private void generarSecuenciaWelshPowell() {
		
		obtenerNodos();
		
		Collections.sort(this.nodos, Collections.reverseOrder());
		// el vector secuencia llenarlo con los grados de cada nodo recorriendo la matriz de adyacencia.
		// luego ordeno de mayor a menor
	}
	
	private void generarSecuenciaAleatoria() {
		
		obtenerNodos();
		
		Collections.shuffle(this.nodos);
		// llenar el vector secuencia con los grados de los nodos y despues generar un random como indice para acceder
		//a la secuencia
	}
}
