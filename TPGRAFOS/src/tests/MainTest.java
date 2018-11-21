package tests;


import algoritmoDeColoreo.GrafoNDNP;
import estadisticas.GeneradorTablasTxt;
import estadisticas.Secuencia;
import generadores.*;
import probador.ProgramaProbador;

public class MainTest {

	public static void main(String[] args) {
		
//		PRUEBAS PARA CUALQUIER GRAFO
		
//		Generador generador2 = new NPartitos(10,3);
//		generador2.generarArchivo("grafoPrueba");
//		
//		GrafoNDNP grafo = new GrafoNDNP();
//		grafo.colorearSecuenciaAleatoria("grafoPrueba",true,true);
//		
//		ProgramaProbador probador = new ProgramaProbador("grafoPrueba");
//		System.out.println(probador.probar());
		
		
//		GRAFOS ALEATORIOS
		GeneradorTablasTxt generadorTablas = new GeneradorTablasTxt(600);
		
//		Grafo aleatorio de 40%
		
		Generador generador = new PorcentajeAdyacencia(600, 0.4);
		
		generador.generarArchivo("grafoAleatorio40porc");
		
		GrafoNDNP grafo = new GrafoNDNP();
		 
		grafo.colorearSecuenciaAleatoria("grafoAleatorio40porc",true,true);
		grafo.colorearSecuenciaMatula("grafoMatula40porc",true,true);
		grafo.colorearSecuenciaWelshPowell("grafoWelshPowell40porc",true,true);
		
		generadorTablas.generarTabla("tablaGrafoAleatorio40porcMATULA", "grafoAleatorio40porc", Secuencia.MATULA);
		
		generadorTablas.generarTabla("tablaGrafoAleatorio40porcWELSHPOWELL", "grafoAleatorio40porc", Secuencia.WELSHPOWELL);
		
		generadorTablas.generarTabla("tablaGrafoAleatorio40porcALEATORIO", "grafoAleatorio40porc", Secuencia.ALEATORIO);
		
//		Grafo aleatorio de 60%	
		
		generador = new PorcentajeAdyacencia(600, 0.6);
		
		generador.generarArchivo("grafoAleatorio60porc");
		
		grafo = new GrafoNDNP();
		 
		grafo.colorearSecuenciaAleatoria("grafoAleatorio60porc",true,true);
		grafo.colorearSecuenciaMatula("grafoMatula60porc",true,true);
		grafo.colorearSecuenciaWelshPowell("grafoWelshPowel60porc",true,true);
		
		generadorTablas.generarTabla("tablaGrafoAleatorio60porcMATULA", "grafoAleatorio60porc", Secuencia.MATULA);
		
		generadorTablas.generarTabla("tablaGrafoAleatorio60porcWELSHPOWELL", "grafoAleatorio60porc", Secuencia.WELSHPOWELL);
		
		generadorTablas.generarTabla("tablaGrafoAleatorio60porcALEATORIO", "grafoAleatorio60porc", Secuencia.ALEATORIO);
		
//		Grafo aleatorio de 90%
		
		generador = new PorcentajeAdyacencia(600, 0.9);
		
		generador.generarArchivo("grafoAleatorio90porc");
		
		 grafo = new GrafoNDNP();
		 
		grafo.colorearSecuenciaAleatoria("grafoAleatorio90porc",true,true);
		grafo.colorearSecuenciaMatula("grafoMatula90porc",true,true);
		grafo.colorearSecuenciaWelshPowell("grafoWelshPowel90porc",true,true);
		
		generadorTablas.generarTabla("tablaGrafoAleatorio90porcMATULA", "grafoAleatorio90porc", Secuencia.MATULA);
		
		generadorTablas.generarTabla("tablaGrafoAleatorio90porcWELSHPOWELL", "grafoAleatorio90porc", Secuencia.WELSHPOWELL);
	
		generadorTablas.generarTabla("tablaGrafoAleatorio90porcALEATORIO", "grafoAleatorio90porc", Secuencia.ALEATORIO);
		
		
//		GRAFOS REGULARES
		
		generadorTablas = new GeneradorTablasTxt(1000);
		
//		Grafo aleatorio de 50%
		
		generador = new RegularesPorcAdy(1000,0.5);
		
		generador.generarArchivo("grafoRegular50porc");
		
		 grafo = new GrafoNDNP();
		 
		grafo.colorearSecuenciaAleatoria("grafoRegular50porc",true,true);
		
		generadorTablas.generarTabla("tablaGrafoRegular50porc", "grafoRegular50porc", Secuencia.ALEATORIO);
		
//		Grafo aleatorio de 75%
		
		generador = new RegularesPorcAdy(1000,0.75);
		
		generador.generarArchivo("grafoRegular75porc");
		
		grafo = new GrafoNDNP();
		 
		grafo.colorearSecuenciaAleatoria("grafoRegular75porc",true,true);
		
		generadorTablas.generarTabla("tablaGrafoRegular75porc", "grafoRegular75porc", Secuencia.ALEATORIO);
		

	}
}
