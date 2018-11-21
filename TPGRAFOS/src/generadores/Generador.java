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
	protected int totalCantPosible;
	
	public Generador(int nodos) {
		this.nodos = nodos;
		this.mAdyacencia = new MatrizSimetrica(nodos);
		this.grados = new int[nodos];
		this.totalCantPosible = this.nodos * (this.nodos - 1) / 2;
	}
	
	
	protected abstract void generar();
	
	
	private int getGradoMax() {
		int max = 0;
		for(int i = 0; i < this.nodos; i++) {
			if(this.grados[i] > max) {
				max = this.grados[i] ;
			}
		}
		return max;
	}
	
	private int getGradoMin() {
		int min = this.grados[0];
		for(int i = 1; i < this.nodos; i++) {
			if(this.grados[i] < min) {
				min = this.grados[i] ;
			}
		}
		return min;
	}
	
	public void generarArchivo(String nombreArchivo) {
		
		PrintWriter pw;
		try {
			pw = new PrintWriter(new File("C:\\Users\\Florencia\\Documents\\Programacion Avanzada"
					+ "\\TPGRAFOS\\AlgoritmosColoreo\\TPGRAFOS\\Grafos Entrada\\" + nombreArchivo + ".in"));
			generar();
			pw.println(this.nodos + " " + this.cantAristas + " " + String.format("%.2f", this.porcAdyacencia)  + " " + getGradoMax() + " " + getGradoMin());
			for(int i = 0; i < nodos; i++) {
				for(int j = i + 1; j < nodos; j++) {
					if(this.mAdyacencia.get(i, j) == 1) {
						pw.println(i + " " + j);
					}
				}
			}
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ruta incorrecta");
		}

	}
	
	protected void calcularGradosPorNodos() {
		for(int i = 0; i < this.nodos; i++) {
			for(int j = 0; j < this.nodos; j++) {
				// Suma 1 cuando existe arista y nada cuando no existe, sin preguntar.
				this.grados[i] += this.mAdyacencia.get(i, j);
			}
		}
	}
	
	protected void calcularCantAristas() {
		for(int i = 0; i < this.nodos; i++) {
			this.cantAristas += this.grados[i];
		}
		
		this.cantAristas /= 2;
	}
	
	protected void calcularPorcentaje() {
		this.porcAdyacencia = (double) this.cantAristas / (double) this.totalCantPosible;
	}

}
