package com.sell.portal.service;

import com.sell.util.CommonResult;

public interface HomeService {
	CommonResult getAdvertise();

	CommonResult getCodeByCityCode(Double lo, Double la);

	CommonResult getPriceSection();

	CommonResult getMealClassify();

}
