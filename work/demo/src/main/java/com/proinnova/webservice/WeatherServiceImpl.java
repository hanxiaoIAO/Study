package com.proinnova.webservice;

import java.util.List;

import javax.jws.WebService;

@WebService
public class WeatherServiceImpl implements WeatherService{

	@Override
	public String getWeatherByCityname(HeadEntity head) {
		List<DtlEntity> dtlList = head.getDtls();
		StringBuilder sb = new StringBuilder();
		sb.append(head.getCode()+":");
		for(DtlEntity dtl:dtlList) {
			sb.append("\t"+dtl.getCode() + "天气晴朗！");
		}
		return sb.toString();
	}

}
