package estadisticas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import algoritmoDeColoreo.GrafoNDNP;

public class GeneradorTablasTxt {
	
	private int [] cantidadesDeColores;
	private final int CANTIDADCORRIDAS = 10000;
	
	public GeneradorTablasTxt(int nodos) {
		this.cantidadesDeColores = new int [nodos + 1];
	}
	
	public void generarTabla(String nombreArchivotxt, String nombreArchivoGrafo, Secuencia secuencia) {
		
		File rutaArchivo = new File("C:\\Users\\Florencia\\Documents\\Programacion Avanzada\\"
				+ "TPGRAFOS\\AlgoritmosColoreo\\TPGRAFOS\\Tablas\\" + nombreArchivotxt + ".txt");
		
		GrafoNDNP grafo = new GrafoNDNP();
		
		grafo.leerArchivoIn(nombreArchivoGrafo);
		
		switch (secuencia) {
		case MATULA:
			for(int i = 0; i < this.CANTIDADCORRIDAS; i++) {
				this.cantidadesDeColores[grafo.colorearSecuenciaMatula(nombreArchivoGrafo,false,false)] ++ ;
			}
			break;
		case WELSHPOWELL:
			for(int i = 0; i < this.CANTIDADCORRIDAS; i++) {
				this.cantidadesDeColores[grafo.colorearSecuenciaWelshPowell(nombreArchivoGrafo,false,false)] ++ ;
			}
			break;
		case ALEATORIO:
			for(int i = 0; i < this.CANTIDADCORRIDAS; i++) {
				this.cantidadesDeColores[grafo.colorearSecuenciaAleatoria(nombreArchivoGrafo,false,false)] ++ ;
			}
			break;
		default:
			break;
		}
		
		
		try {
			
			PrintWriter pw = new PrintWriter(rutaArchivo);
			int frRelativa = 0;
			for(int i = 0; i < this.cantidadesDeColores.length; i++) {
				frRelativa = this.cantidadesDeColores[i] / this.CANTIDADCORRIDAS;
				pw.println(i + ";" + frRelativa);
			}
			
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
