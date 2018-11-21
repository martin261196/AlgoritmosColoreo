package estadisticas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import algoritmoDeColoreo.GrafoNDNP;

public class GeneradorTablasTxt {
	
	private int [] cantidadesDeColores;
	private final int CANTIDADCORRIDAS = 1000;
	
	public GeneradorTablasTxt(int nodos) {
		this.cantidadesDeColores = new int [nodos];
	}
	
	public void generarTabla(String nombreArchivotxt, String nombreArchivoGrafo, Secuencia secuencia) {
		
		File rutaArchivo = new File("C:\\Users\\Florencia\\Documents\\Programacion Avanzada\\"
				+ "TPGRAFOS\\AlgoritmosColoreo\\TPGRAFOS\\Tablas\\" + nombreArchivotxt + ".txt");
		
		GrafoNDNP grafo = new GrafoNDNP();
		
		grafo.leerArchivoIn(nombreArchivoGrafo);
		
		switch (secuencia) {
		case MATULA:
			for(int i = 0; i < this.CANTIDADCORRIDAS; i++) {
				this.cantidadesDeColores[grafo.colorearSecuenciaMatula(nombreArchivoGrafo,false,false) - 1] ++ ;
			}
			break;
		case WELSHPOWELL:
			for(int i = 0; i < this.CANTIDADCORRIDAS; i++) {
				this.cantidadesDeColores[grafo.colorearSecuenciaWelshPowell(nombreArchivoGrafo,false,false) - 1] ++ ;
			}
			break;
		case ALEATORIO:
			for(int i = 0; i < this.CANTIDADCORRIDAS; i++) {
				this.cantidadesDeColores[grafo.colorearSecuenciaAleatoria(nombreArchivoGrafo,false,false) - 1] ++ ;
			}
			break;
		default:
			break;
		}
		
		try {
			
			PrintWriter pw = new PrintWriter(rutaArchivo);
			double frRelativa = 0, cantidadDeVeces, corridas = this.CANTIDADCORRIDAS;
			for(int i = 0; i < this.cantidadesDeColores.length; i++) {
				cantidadDeVeces = this.cantidadesDeColores[i];
				frRelativa = cantidadDeVeces / corridas;
				pw.println((i + 1) + ";" + String.format("%.2f", frRelativa));
			}
			
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
