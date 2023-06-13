package com.conversor.codigo;



public class ConversoresMonedas {

	
	public static double ConvertirAPeso(double cantidadInicial, double tipoDeCambio) {
				
		return (double) Math.round((cantidadInicial * (tipoDeCambio)) * 100d) / 100d;
					
	}
	
	public static double ConvertirOtraMoneda(double cantidadInicial, double tipoDeCambio) {
		
		return (double) Math.round((cantidadInicial / (tipoDeCambio)) * 100d) / 100d;
		
	}
	
}
