package com.sell.mapper;

import java.util.List;

import com.sell.model.Order;

public interface OrderMapper {

	List<Order> list(String orderCode, Integer companyId, Integer state, String startTime, String endTime,
			Integer pageSize, Integer pageNum);

}
