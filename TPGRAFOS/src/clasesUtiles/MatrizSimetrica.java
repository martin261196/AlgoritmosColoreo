package clasesUtiles;

public class MatrizSimetrica {
	
	// Cada posicion es el valor de la arista. Si quisiera que sea true o false lo declaro como boolean
	private int [] vec;
	private int dimension;
	
	public MatrizSimetrica(int dimension) {
		this.dimension = dimension;
		this.vec = new int [this.dimension * (this.dimension - 1) / 2];
	}
	
	public void set(int valor, int fila, int columna) {
		if(fila != columna) {
			if(fila > columna) {
				this.vec[obtenerPosicion(columna, fila)] = valor;
			} else {
				this.vec[obtenerPosicion(fila, columna)] = valor;
			}
		}
	}
	
	public int get(int fila, int columna) {
		if(fila != columna) {
			if(fila > columna) {
				return this.vec[obtenerPosicion(columna, fila)];
			}
			return this.vec[obtenerPosicion(fila, columna)];
		}
		return 0; // si fuera true/false retorno false
	}

	// Funciona con posicion inicial 0,0
	private int obtenerPosicion(int fila, int columna) {
		return fila * this.dimension + columna - 
		                (int)((Math.pow(fila,2) + 3 * fila + 2) / 2);
	}
	
}
