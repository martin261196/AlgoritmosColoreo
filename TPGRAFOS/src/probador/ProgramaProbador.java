package probador;

import java.io.*;
import java.util.*;

import clasesUtiles.MatrizSimetrica;

// Probar que los adyacentes esten pintados distintos y que el color de cada uno no sea mayor a la cantidad minima

public class ProgramaProbador {
	
	private String nombreArchivoGrafo;
	private int cantidadNodos;
	private int cantidadAristas;
	private int cantidadColores;
	private int[] colorPorNodo;
	private MatrizSimetrica matrizAd;

	public ProgramaProbador(String nombreArchivoGrafo) {
		
		this.nombreArchivoGrafo = nombreArchivoGrafo;
		
	}

	
	public boolean probar() {
		
		procesarArchivoIn();
		if(!procesarArchivoOut()) {
			return false;
		}
		
		for(int i = 0 ; i <= this.cantidadNodos - 2 ; i++) {
			for(int j = i + 1 ; j <= this.cantidadNodos - 1 ; j++) {
				if(matrizAd.get(i, j) != 0 && this.colorPorNodo[i] == this.colorPorNodo[j]) {
					return false;
				}
			}
		}
		
		return true;
	}


	private void procesarArchivoIn() {
		Scanner sc = null;
		try {
			sc = new Scanner(new File("C:\\Users\\Florencia\\Documents\\Programacion Avanzada"
					+ "\\TPGRAFOS\\AlgoritmosColoreo\\TPGRAFOS\\Grafos Entrada\\" + this.nombreArchivoGrafo + ".in"));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		this.cantidadNodos = sc.nextInt();
		this.cantidadAristas = sc.nextInt();
		sc.nextInt(); 
		sc.nextInt();
		sc.nextInt();
		
		this.colorPorNodo = new int [this.cantidadNodos];
		this.matrizAd = new MatrizSimetrica(this.cantidadNodos);
		
		for(int i = 0; i < this.cantidadAristas; i++) {
			matrizAd.set(1, sc.nextInt(), sc.nextInt());
		}
		
		sc.close();	
	}
	
	

	private boolean procesarArchivoOut() {
		boolean respuesta = true;
		int nodo, color, colorMayor = 1;
		Scanner sc = null;
		try {
			sc = new Scanner(new File("C:\\Users\\Florencia\\Documents\\Programacion Avanzada"
					+ "\\TPGRAFOS\\AlgoritmosColoreo\\TPGRAFOS\\Resultados Coloreo\\" + this.nombreArchivoGrafo + ".out"));
			if(sc.nextInt() != this.cantidadNodos) {
				sc.close();
				respuesta = false;
			}
			this.cantidadColores = sc.nextInt();
			sc.nextInt();
			sc.nextInt();
			sc.nextInt();
			sc.nextInt();
			for(int i = 0; i < this.cantidadNodos; i++) {
				nodo = sc.nextInt();
				color = sc.nextInt();
				this.colorPorNodo[nodo] = color;
				if(color > colorMayor) {
					colorMayor = color;
				}
			}
			if(colorMayor > this.cantidadColores) {
				respuesta = false;
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
		return respuesta;
	}
}
