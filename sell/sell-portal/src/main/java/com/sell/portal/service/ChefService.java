package com.sell.portal.service;

import com.sell.util.CommonResult;

/** 
* @author  作者 YJX 
* @date 创建时间：2019年7月6日 下午5:28:16 
* @version 1.0  
* @return  
*/
public interface ChefService {

	CommonResult getChefList(String code, String date, Integer rank, String keyWord, Integer pageNum, Integer pageSize);

	CommonResult selectDetails(Integer chefId);

	CommonResult selectCalendar(Integer chefId);

}
