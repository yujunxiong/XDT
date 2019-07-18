package com.sell.portal.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.sell.mapper.HomeAdvertiseMapper;
import com.sell.mapper.MealCategoryMapper;
import com.sell.mapper.PriceSecTionMapper;
import com.sell.mapper.SetMealMapper;
import com.sell.mapper.CodeMapper;
import com.sell.model.PriceSection;
import com.sell.model.SetMeal;
import com.sell.model.request.MealParams;
import com.sell.model.response.MealResponse;
import com.sell.portal.dto.ResponseProtocol;
import com.sell.portal.service.HomeService;
import com.sell.util.Api;
import com.sell.util.CommonResult;

import retrofit2.Call;
import retrofit2.Response;

@Service
public class HomeServiceImpl implements HomeService {
	private final Logger LOG = LoggerFactory.getLogger(HomeServiceImpl.class);
	
	@Value("${gaode.key}")
	private String key;
	@Autowired
	private CodeMapper codeMapper;
	@Autowired
	private HomeAdvertiseMapper homeAdvertiseMapper;
	@Autowired
	private PriceSecTionMapper priceSecTionMapper;
	@Autowired
	private MealCategoryMapper mealCategoryMapper;

	@Override
	public CommonResult getAdvertise() {
		return CommonResult.ok(homeAdvertiseMapper.getAdvertise());
	}

	//获取城镇列表
	@Override
	public CommonResult getCodeByCityCode(Double lo, Double la) {
		CommonResult result = new CommonResult();
		/*ResponseProtocol protocol = (ResponseProtocol)Api.getInterfase("https://restapi.amap.com/", ResponseProtocol.class);
		Map<String, Object> params = new HashMap<>();
		StringBuffer buffer = new StringBuffer();
		params.put("location", buffer.append(lo+",").append(la));
		params.put("output", "json");
		params.put("key", key);
		Call<Object> call = protocol.getAdvertise(params);
		Response<Object> response = null;
		try {
			response = call.execute();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("高德逆编码调用失败！"+e.getMessage());
			result.failed("系统开小差");
		}
		Gson gson = new Gson();
		JSONObject json = JSONObject.parseObject(gson.toJson(response.body()));
		String code = JSONObject.parseObject(JSONObject.parseObject(json.get("regeocode").toString()).get("addressComponent").toString()).get("adcode").toString();
		return result.success(codeMapper.getCodeByCityCode(code));*/
		return result.success(codeMapper.getCode());
	}

	//获取价格列表
	@Override
	public CommonResult getPriceSection() {
		 List<PriceSection> list = priceSecTionMapper.select();
		 List<Map<String, Object>> result = new ArrayList<>();
		 for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = new HashMap<>();
			if(i==0){
				map.put("startPrice", 0);
				map.put("endPrice", list.get(i).getEndPrice());
				map.put("section",list.get(i).getEndPrice().setScale(0, BigDecimal.ROUND_UP)+"以下");
			}else if(i==(list.size()-1)){
				map.put("startPrice", list.get(i).getStartPrice());
				map.put("endPrice", list.get(i).getEndPrice());
				map.put("section", list.get(i).getStartPrice()+"以上");
			}else{
				map.put("startPrice", list.get(i).getStartPrice());
				map.put("endPrice", list.get(i).getEndPrice());
				map.put("section", list.get(i).getStartPrice().setScale(0, BigDecimal.ROUND_DOWN)+"-"+list.get(i).getEndPrice().setScale(0, BigDecimal.ROUND_DOWN));
			}
			result.add(map);
		}
		 return CommonResult.ok(result);
	}

	//获取套餐分类
	@Override
	public CommonResult getMealClassify() {
		return CommonResult.ok(mealCategoryMapper.select());
	}

}
