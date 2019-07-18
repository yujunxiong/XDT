package com.sell.portal.service;

import com.sell.portal.dto.OrderDetail;
import com.sell.util.CommonResult;

/** 
* @author  作者 YJX 
* @date 创建时间：2019年7月10日 下午1:53:57 
* @version 1.0  
* @return  
*/
public interface OrderService {

	CommonResult createOrder(OrderDetail orderDetail);

}
