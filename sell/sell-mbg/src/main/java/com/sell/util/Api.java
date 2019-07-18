package com.sell.util;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/** 
* @author  作者 YJX 
* @date 创建时间： 2019年6月30日 下午2:25:17  
* @version 1.0  
* @return  
*/
public class Api {
	
	public static <E> Object getInterfase(String url,Class<E> cls){
		OkHttpClient okHttpClient = new OkHttpClient();
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(url).client(okHttpClient)
				.addConverterFactory(GsonConverterFactory.create(new Gson()))
				.build();
		Object object = retrofit.create(cls);
		return object;
	}
}
