package generadores;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import clasesUtiles.MatrizSimetrica;

public abstract class Generador {
	
	protected MatrizSimetrica mAdyacencia;
	protected int [] grados;
	protected int nodos;
	protected double porcAdyacencia;
	protected int cantAristas;
	
	public Generador(int nodos) {
		this.nodos = nodos;
		this.mAdyacencia = new MatrizSimetrica(nodos);
		this.grados = new int[nodos];
	}
	
	
	public abstract void generar();
	
	
	public int getGradoMax() {
		int max = 0;
		for(int i = 0; i < this.nodos; i++) {
			if(this.grados[i] > max) {
				max = this.grados[i] ;
			}
		}
		return max;
	}
	
	public int getGradoMin() {
		int min = this.grados[0];
		for(int i = 1; i < this.nodos; i++) {
			if(this.grados[i] < min) {
				min = this.grados[i] ;
			}
		}
		return min;
	}
	
	public void generarArchivo(String rutaArchivo) throws FileNotFoundException {
		
		generar();
		
		PrintWriter pw = new PrintWriter(new File(rutaArchivo));
		pw.println(this.nodos + " " + this.cantAristas + " " + this.porcAdyacencia + " " + getGradoMax() + " " + getGradoMin());
		for(int i = 0; i < this.nodos; i++) {
			for(int j = 0; j < this.nodos; j++) {
				if(this.mAdyacencia.get(i, j) == 1) {
					pw.println(i + " " + j);
				}
			}
		}
		pw.close();
	}
	
	public void calcularGradosPorNodos() {
		for(int i = 0; i < this.nodos; i++) {
			for(int j = 0; j < this.nodos; j++) {
				// Suma 1 cuando existe arista y nada cuando no existe, sin preguntar.
				this.grados[i] += this.mAdyacencia.get(i, j);
			}
		}
	}
	
	public void calcularCantAristas() {
		for(int i = 0; i < this.nodos; i++) {
			this.cantAristas += this.grados[i];
		}
		
		this.cantAristas /= 2;
	}

}
