package com.sell.portal.dto;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ResponseProtocol {
	
	/**
	 * 调用高得逆地理编码API
	 * @return
	 */
	@GET("v3/geocode/regeo")
	Call<Object> getAdvertise(@QueryMap Map<String ,Object> params);
}
