package com.conversor.codigo;

public class ConversoresTemperatura {
	
	
	public static double CelsiusFahrenheit(double tmpCelsius) {
		return (double) Math.round((tmpCelsius * 9/5 + 32) * 100d) / 100d;
		
	}
	
	public static double CelsiusKelvin(double tmpCelsius) {
		return (double) Math.round((tmpCelsius + 273.15) * 100d) / 100d;
		
	}
	
	public static double FahrenheitCelsius(double tmpFahrenheit) {
		return (double) Math.round(((tmpFahrenheit - 32) * 5/9) * 100d) / 100d;
		
	}
	
	public static double FahrenheitKelvin(double tmpFahrenheit) {
		return (double) Math.round(((tmpFahrenheit + 459.67) * 5/9) * 100d) / 100d;
		
	}
	
	public static double KelvinCelsius(double tmpKelvin) {
		return (double) Math.round((tmpKelvin - 273.15) * 100d) / 100d;
		
	}
	
	public static double KelvinFahrenheit(double tmpKelvin) {
		return (double) Math.round(((tmpKelvin - 273.15)* 9/5 + 32) * 100d) / 100d;
		
	}

}
