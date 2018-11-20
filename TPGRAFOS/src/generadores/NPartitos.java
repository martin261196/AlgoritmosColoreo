package generadores;

import java.util.Random;

public class NPartitos extends Generador{

	private int cantSubConjuntos;
	
	public NPartitos(int nodos, int cantSubConjuntos) {
		super(nodos);
		this.cantSubConjuntos = cantSubConjuntos;
	}

	@Override
	public void generar() {
		int [] part = new int[this.nodos];
		
		for(int i = 0; i < this.nodos; i++)
		{
			part[i] = new Random().nextInt(this.cantSubConjuntos);
		}
		
		for(int i = 0; i < this.nodos; i++ )
		{
			for(int j = 0; j < this.nodos; j++)
			{
				if(part[i]!=part[j] && this.mAdyacencia.get(i, j) == 0) {
					this.mAdyacencia.set(1, i, j);
				}
			}
		}
		
		calcularGradosPorNodos();
		calcularCantAristas();
		
		this.porcAdyacencia = this.cantAristas / (this.nodos * (this.nodos - 1) / 2);
		
	}

}
