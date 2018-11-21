package generadores;

import java.util.ArrayList;

import clasesUtiles.Arista;

public class Probabilistico extends Generador{
	
	private ArrayList<Arista> aristas;
	private double probabilidad;

	public Probabilistico(int nodos, double probabilidad) {
		super(nodos);
		this.probabilidad = probabilidad;
		this.aristas = new ArrayList<>();
	}

	@Override
	public void generar() {
		int i;
		// Calculamos todas las combinaciones de aristas posibles
		for(i = 0 ; i < nodos - 2 ; i++)
			for(int j = i ; j < nodos - 1 ; j++) {
				this.aristas.add(new Arista(i, j));
			}
		// Nos quedamos aleatoriamente con algunas segun probabilidad
		for(Arista arista : this.aristas) {
			double valorRandom = Math.random();
			if(valorRandom < this.probabilidad) {
				this.mAdyacencia.set(1, arista.getNodoOrigen(), arista.getNodoDestino());
			}
		}
		
		calcularGradosPorNodos();
		calcularCantAristas();
		calcularPorcentaje();
	}

}
