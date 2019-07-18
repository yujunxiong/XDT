package com.sell.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sell.admin.service.OrderService;
import com.sell.mapper.OrderMapper;
import com.sell.model.Order;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;
	@Override
	public List<Order> list(String orderCode, Integer companyId, Integer state, String startTime, String endTime,
			Integer pageSize, Integer pageNum) {
		
		return orderMapper.list(orderCode,companyId,state,startTime,endTime,pageSize,pageNum);
	}
   
}
