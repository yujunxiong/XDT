package com.sell.portal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sell.model.MemberReceiveAddress;
import com.sell.portal.service.MemberReceiveAddressService;
import com.sell.util.CommonResult;

import io.swagger.annotations.ApiOperation;

/** 
* @author  作者 YJX 
* @date 创建时间：2019年7月10日 下午8:17:27 
* @version 1.0  
* @return  
*/
@RestController()
@RequestMapping("/address")
public class MemberReceiveAddressController {
	@Autowired
    private MemberReceiveAddressService memberReceiveAddressService;
	
    @ApiOperation("添加收货地址")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Object add(HttpServletRequest request,MemberReceiveAddress address) {
        int count = memberReceiveAddressService.add(request,address);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }
    
    @ApiOperation("删除收货地址")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Object delete(HttpServletRequest request, Integer addressId) {
        int count = memberReceiveAddressService.delete(request,addressId);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }
    
    @ApiOperation("修改收货地址")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Object update(HttpServletRequest request, MemberReceiveAddress address) {
        int count = memberReceiveAddressService.update(request, address);
        if(count>0){
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }

    @ApiOperation("显示所有收货地址")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public Object list(HttpServletRequest request) {
        List<MemberReceiveAddress> addressList = memberReceiveAddressService.list(request);
        return new CommonResult().success(addressList);
    }
    
    @ApiOperation("选择收货地址（设置为默认地址）")
    @RequestMapping(value = "/choose", method = RequestMethod.POST)
    @ResponseBody
    public Object choose(HttpServletRequest request, Integer addressId) {
        int num =  memberReceiveAddressService.choose(request,addressId);
        return new CommonResult().success(num);
    }
}
