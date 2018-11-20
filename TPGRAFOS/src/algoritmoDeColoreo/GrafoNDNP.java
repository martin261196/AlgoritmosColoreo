package algoritmoDeColoreo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

import clasesUtiles.MatrizSimetrica;
import clasesUtiles.Nodo;

public class GrafoNDNP {
	
	private ArrayList<Nodo> nodos;
	private int [] colorPorNodo;
	private MatrizSimetrica matrizAd;
	
	private int cantidadNodos, cantidadColores, cantidadAristas, grMax, grMin;
	private double porcAd;
	
	public int colorearSecuenciaMatula(String pathGrafo, boolean generarArchivo, boolean leerArchivo) {
		if(leerArchivo)
			leerArchivoIn(pathGrafo);
		generarSecuenciaMatula();
		colorear();
		if(generarArchivo)
			escribirArchivoOut(pathGrafo);
		return this.cantidadColores;
	}
	
	public int colorearSecuenciaWelshPowell(String pathGrafo, boolean generarArchivo, boolean leerArchivo) {
		if(leerArchivo)
			leerArchivoIn(pathGrafo);
		generarSecuenciaWelshPowell();
		colorear();
		if(generarArchivo)
			escribirArchivoOut(pathGrafo);
		return this.cantidadColores;
	}
	
	public int colorearSecuenciaAleatoria(String pathGrafo, boolean generarArchivo, boolean leerArchivo) {
		if(leerArchivo)
			leerArchivoIn(pathGrafo);
		generarSecuenciaAleatoria();
		colorear();
		if(generarArchivo)
			escribirArchivoOut(pathGrafo);
		return this.cantidadColores;
	}
	
	private void colorear() {
		
		int primeroSinPintar = 0, nodosPintados = 0, nroNodo, i = 0;
		boolean hayPrimeroSinPintar = true, sePuedePintar = true, terminoIteracion = true;

		this.cantidadColores = 1;
		
		while(nodosPintados < this.cantidadNodos) {
			nroNodo = this.nodos.get(i).getNumeroNodo();
			
			if(terminoIteracion) {
				this.colorPorNodo[nroNodo] = cantidadColores;
				nodosPintados++;
				hayPrimeroSinPintar = false;
				
			} else if(this.colorPorNodo[nroNodo] == 0) { // Esta sin pintar ese nodo?
				
				// busco que no sea adyacente a los nodos pintados del color actual
				for(int j = 0; j < this.cantidadNodos; j++) {
					
					// me fijo si tiene el mismo color actual
					if(this.colorPorNodo[j] == cantidadColores) {
						
						//me fijo si es adyacente a ese nodo
						if(matrizAd.get(j, nroNodo) != 0) {
							sePuedePintar = false;
							if(!hayPrimeroSinPintar) {
								hayPrimeroSinPintar = true;
								// guardo la posicion de este nodo en la lista de nodos
								primeroSinPintar = i;
							}
							break;
						} else {
							sePuedePintar = true;
						}
					} else {
						sePuedePintar = true;
					}
				}
				
				if(sePuedePintar) {
					this.colorPorNodo[nroNodo] = cantidadColores;
					nodosPintados++;
				}
			}
			
			i++; // Paso al siguiente nodo siempre, haya pintado o no
			if(i == cantidadNodos && nodosPintados < this.cantidadNodos) {
				terminoIteracion = true;
				i = primeroSinPintar;
				cantidadColores++;
			} else {
				terminoIteracion = false;
			}

		}
	}
	
	public void leerArchivoIn(String nombreArchivo) {
		Scanner sc = null;
		try {
			sc = new Scanner(new File("C:\\Users\\Florencia\\Documents\\Programacion Avanzada"
					+ "\\TPGRAFOS\\AlgoritmosColoreo\\TPGRAFOS\\Grafos Entrada\\" + nombreArchivo + ".in"));
			sc.useLocale(Locale.ENGLISH);
			this.cantidadNodos = sc.nextInt();
			this.cantidadAristas = sc.nextInt();
			this.porcAd = sc.nextDouble(); 
			this.grMax = sc.nextInt();
			this.grMin = sc.nextInt();
			
			this.nodos = new ArrayList<>();
			
			this.colorPorNodo = new int [this.cantidadNodos];
			this.matrizAd = new MatrizSimetrica(this.cantidadNodos);
			
			for(int i = 0; i < this.cantidadAristas; i++) {
				matrizAd.set(1, sc.nextInt(), sc.nextInt());
			}
			
			sc.close();	
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	
	}
	
	public void escribirArchivoOut(String nombreArchivo) {
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
