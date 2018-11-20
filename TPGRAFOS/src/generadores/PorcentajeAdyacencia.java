package generadores;

import java.util.ArrayList;
import java.util.Collections;

import clasesUtiles.Arista;

public class PorcentajeAdyacencia extends Generador{
	
	private ArrayList<Arista> aristas;
	
	public PorcentajeAdyacencia(int nodos, double porcAdyacencia) {
		super(nodos);
		this.porcAdyacencia = porcAdyacencia;
		this.aristas = new ArrayList<>();
	}

	@Override
	public void generar() {
		
		int i;
		for( i = 0 ; i <= nodos - 2 ; i++) {
			for(int j = i + 1 ; j <= nodos - 1 ; j++) {
				this.aristas.add(new Arista(i, j));
			}
		}
		
		Collections.shuffle(this.aristas);
		
		for(i = 0 ; i < (this.porcAdyacencia * this.aristas.size()) ; i++) {
			this.mAdyacencia.set(1, this.aristas.get(i).getNodoOrigen(), this.aristas.get(i).getNodoDestino());
		}
		
		calcularGradosPorNodos();
		calcularCantAristas();
	}

}
