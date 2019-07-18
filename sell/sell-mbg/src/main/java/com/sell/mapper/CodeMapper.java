package com.sell.mapper;

import java.util.List;

import com.sell.model.Code;

public interface CodeMapper {

	List<Code> getCodeByCityCode(String code);

	List<Code> getCode();
}