package com.sell.admin.service;

import com.sell.model.request.Chefparams;
import com.sell.util.CommonResult;

public interface ChefService {

	int add(Chefparams chefparams);

	int update(Chefparams chefparams);

	CommonResult del(Integer id);

	CommonResult list(String token, String chefNameOrTel, Integer puyaway, int pageNum, int pageSize);

}
