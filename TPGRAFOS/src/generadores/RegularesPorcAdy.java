package generadores;

public class RegularesPorcAdy extends Generador{

	private int grado;
	
	public RegularesPorcAdy(int nodos, double porcentajeAd) {
		super(nodos);
		this.grado = (int) (porcentajeAd * (this.nodos - 1));
	}

	@Override
	public void generar() {
		
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
		
		for(; gradoInicial <= grado ; gradoInicial += 2) {
			if(grado == 1) {
				limite /= 2;
			}
			for(int i = 0 ; i < limite ; i++) {
				if(i + salto >= this.nodos || i == this.nodos - 1) {
					this.mAdyacencia.set(1, i, salto - (this.nodos - i));
					
				} else {
					this.mAdyacencia.set(1, i, salto + i);
					
				}
			}
			salto += proximoSalto;
			limite = this.nodos;
		}
		
		calcularGradosPorNodos();
		calcularCantAristas();
		calcularPorcentaje();
	}

}
