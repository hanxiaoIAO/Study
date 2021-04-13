package com.proinnova.webservice.client;

public class Main {
    public static void main(String[] args) {
    	WeatherServiceImplService factory = new WeatherServiceImplService();
        WeatherServiceImpl servicePort = factory.getWeatherServiceImplPort();
        String weather = servicePort.getWeatherByCityname("深圳");
        System.out.println(weather);
    }
} 
