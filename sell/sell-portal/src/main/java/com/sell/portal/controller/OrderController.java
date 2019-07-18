package com.sell.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sell.model.vo.SetMealVo;
import com.sell.portal.dto.OrderDetail;
import com.sell.portal.service.OrderService;

/** 
* @author  作者 YJX 
* @date 创建时间：2019年7月1日 下午5:13:01 
* @version 1.0  
* @return  
*/
@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/create")
	public Object createOrder(@RequestBody OrderDetail orderDetail){
		return orderService.createOrder(orderDetail);
	}
}
