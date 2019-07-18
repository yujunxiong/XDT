package com.sell.admin.service;

import java.util.List;

import com.sell.model.Order;
import com.sell.model.request.Chefparams;

public interface OrderService {

	List<Order> list(String orderCode, Integer companyId, Integer state, String startTime, String endTime,
			Integer pageSize, Integer pageNum);
}
