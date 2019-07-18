package com.sell.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sell.admin.service.ChefService;
import com.sell.admin.service.OrderService;
import com.sell.model.Order;
import com.sell.model.request.Chefparams;
import com.sell.util.CommonResult;

import io.swagger.annotations.ApiOperation;

/**
 * @author guyefeng
 * 订单管理
 */
@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@ApiOperation("订单列表")
	@ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
	//@PreAuthorize("hasAuthority('public')")
    public Object listOrder(String orderCode,Integer companyId,Integer state,String startTime,String endTime,@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
		CommonResult commonResult=new CommonResult();
		List<Order> list=orderService.list(orderCode,companyId,state,startTime,endTime,pageSize,pageNum);
		commonResult.setData(list);
		return commonResult;
    }
}
