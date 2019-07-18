package com.sell.portal.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sell.model.Dish;
import com.sell.model.vo.SetMealVo;
import com.sell.portal.dto.OrderDetail;
import com.sell.portal.service.OrderService;
import com.sell.util.CommonResult;

/** 
* @author  作者 YJX 
* @date 创建时间：2019年7月10日 下午2:37:44 
* @version 1.0  
* @return  
*/
@Service
public class OrderServiceImpl implements OrderService {

	@Override
	public CommonResult createOrder(OrderDetail orderDetail) {
		SetMealVo setMeal = orderDetail.getSetMeal();
		List<Dish> dish = orderDetail.getSetMeal().getDish();
		for (Dish dish2 : dish) {
			System.err.println(dish2.getPrice());
		}
		
		return null;
	}

}
