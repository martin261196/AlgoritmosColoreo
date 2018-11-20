package tests;


import algoritmoDeColoreo.GrafoNDNP;
import estadisticas.GeneradorTablasTxt;
import estadisticas.Secuencia;
import generadores.*;
import probador.ProgramaProbador;

public class MainTest {

	public static void main(String[] args) {
		
//		Generador generador2 = new PorcentajeAdyacencia(6, 1);
//		generador2.generarArchivo("grafoPrueba");
//		GrafoNDNP grafo = new GrafoNDNP();
//		grafo.colorearSecuenciaAleatoria("grafoPrueba",true,true);
//		ProgramaProbador probador = new ProgramaProbador("grafoPrueba");
//		System.out.println(probador.probar());
//		GeneradorTablasTxt generadorTablas2 = new GeneradorTablasTxt(6);
//		
//		generadorTablas2.generarTabla("grafoPrueba", "grafoPrueba", Secuencia.ALEATORIO);
		
		GeneradorTablasTxt generadorTablas = new GeneradorTablasTxt(600);
		
//		Grafo aleatorio de 40%
		
		Generador generador = new PorcentajeAdyacencia(600, 0.4);
		
		generador.generarArchivo("grafoAleatorio40porc");
		
		generadorTablas.generarTabla("tablaGrafoAleatorio40porcMATULA", "grafoAleatorio40porc", Secuencia.MATULA);
		
//		generadorTablas.generarTabla("tablaGrafoAleatorio40porcWELSHPOWELL", "grafoAleatorio40porc", Secuencia.WELSHPOWELL);
//		
//		generadorTablas.generarTabla("tablaGrafoAleatorio40porcALEATORIO", "grafoAleatorio40porc", Secuencia.ALEATORIO);
//		
////		Grafo aleatorio de 60%	
//		
//		generador = new PorcentajeAdyacencia(600, 0.6);
//		
//		generador.generarArchivo("grafoAleatorio60porc");
//		
//		generadorTablas.generarTabla("tablaGrafoAleatorio40porcMATULA", "grafoAleatorio60porc", Secuencia.MATULA);
//		
//		generadorTablas.generarTabla("tablaGrafoAleatorio40porcWELSHPOWELL", "grafoAleatorio60porc", Secuencia.WELSHPOWELL);
//		
//		generadorTablas.generarTabla("tablaGrafoAleatorio40porcALEATORIO", "grafoAleatorio60porc", Secuencia.ALEATORIO);
//		
////		Grafo aleatorio de 90%
//		
//		generador = new PorcentajeAdyacencia(600, 0.9);
//		
//		generador.generarArchivo("grafoAleatorio90porc");
//		
//		generadorTablas.generarTabla("tablaGrafoAleatorio40porcMATULA", "grafoAleatorio90porc", Secuencia.MATULA);
//		
//		generadorTablas.generarTabla("tablaGrafoAleatorio40porcWELSHPOWELL", "grafoAleatorio90porc", Secuencia.WELSHPOWELL);
//	
//		generadorTablas.generarTabla("tablaGrafoAleatorio40porcALEATORIO", "grafoAleatorio90porc", Secuencia.ALEATORIO);

	}
}
