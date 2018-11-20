package clasesUtiles;

public class Nodo implements Comparable<Nodo>{

	private int numeroNodo;
	private int grado;
	
	public Nodo(int nodo, int grado) {
		this.numeroNodo = nodo;
		this.grado = grado;
	}
	
	public int compareTo(Nodo otroNodo) {
		
		return this.grado - otroNodo.grado;
		
	}
	
	public int getNumeroNodo() {
		return this.numeroNodo;
	}
	
}
