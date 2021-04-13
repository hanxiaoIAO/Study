package com.proinnova.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface WeatherService {

	@WebMethod
    String getWeatherByCityname(HeadEntity head);
	
}
