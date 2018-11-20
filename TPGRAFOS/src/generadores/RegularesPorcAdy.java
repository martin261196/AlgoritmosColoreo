package generadores;

public class RegularesPorcAdy extends Generador{

	public RegularesPorcAdy(int nodos, double porcentajeAd) {
		super(nodos);
		this.porcAdyacencia = porcentajeAd;
		int grado = (int) this.porcAdyacencia * (this.nodos - 1);
		for(int i = 0; i < this.nodos; i++) {
			this.grados[i] = grado;
		}
	}

	@Override
	public void generar() {
		int grado = this.grados[0];
		int salto, proximoSalto, gradoInicial, limite = this.nodos;
		if(grado % 2 == 0) { // Es par
			salto = 1;
			proximoSalto = 1;
			gradoInicial = 2;
		} else {
			salto = this.nodos / 2;
			proximoSalto = -1;
			gradoInicial = 1;
		}
		
		for(; gradoInicial == grado ; gradoInicial += 2) {
			if(grado == 1) {
				limite /= 2;
			}
			for(int i = 1 ; i == limite ; i++) {
				if(i + salto > this.nodos) {
					this.mAdyacencia.set(1, i, salto);
					
				} else {
					this.mAdyacencia.set(1, i, salto + i);
					
				}
			}
			salto += proximoSalto;
			limite = this.nodos;
		}
		
		calcularGradosPorNodos();
		calcularCantAristas();
	}

}
