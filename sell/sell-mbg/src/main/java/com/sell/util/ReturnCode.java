package com.sell.util;

public enum ReturnCode {
	SUCCESS(200,"成功！")
	,FAILD(500,"失败！")
	,SYSTEM_ERROR(9999,"系统开小差了，请稍后再试！")
	,LOGIN_SUCCESS(200,"登录成功！")
	,LOGIN_ACCOUNT_DISABLED(10001,"账号已被禁用，请联系客服！")
	,LOGIN_ACCOUNT_ERROR(10002,"用户名或密码错误！")
	,LOGIN_TOKEN_INVALID(10003,"请重新授权登录！")
	,LOGIN_VERIFY_FAILED(10004,"验证失败，请重新登录！")
	,LOGIN_ACCOUNT_OFFLINE(10005,"账号已下线，请重新登录！")
	,LOGIN_WX_ACCREDIT_FAILED(10006,"微信授权失败，请重新授权")
	,LOGIN_FAILED(10007,"登录失败！")
	,ACTIVITY_NOT_STARTED(20001,"活动尚未开始！")
	,HAVE_NO_PRODUCT(20002,"请选择至少一件商品！")
	,HAVE_NO_ORDER(20003,"该订单不存在！")
	,HAVE_NO_REPERTORY(20003,"该商品已售罄，请选购其他商品！")
	,ADDRESS_LOCATION_FAILED(20004,"定位失败，请稍后重试！")
	,HAVE_NO_STATION(20004,"超出配送范围！")
	,ADDRESS_VERIFY_FAILED(20005,"地址校验失败，请稍后重试！")
	,HAVE_NO_ADDRESS(20006,"地址不存在！")
	,HAVE_NO_ORDER_STATE(20007,"未请求到订单状态,请稍后重试！")
	,REFUND_SUBMISSION_FOR_REVIEW(20008,"退款已提交审核！")
	,CAN_NOT_REFUND(20009,"该订单无法退款，请刷新！")
	,FAILED_TO_REFUND(20010,"微信退款失败！")
	,SUCCESS_TO_REFUND(20011,"退款成功！")
	,PRODUCT_NONENTITY(20012,"商品不存在！")
	,PIC_NONENTITY(20013,"图片获取失败,请重新获取！")
	,PRODUCT_RESTRICT(20014,"请将限购商品加入购物车！")
	,PRODUCT_HAVE_NO_STOCK(20015,"库存不足！")
	,PRODUCT_NO_PUBLIC(20016,"商品未上架！")
	,PRODUCT_NO_STARTTIME(20017,"该商品未设置活动开始时间！")
	,ACTIVITY_END(20018,"活动已结束！")
	;
	
	private String msg;
    private int code;
    
    private ReturnCode(int code,String msg)
    {
    	this.code=code;
        this.msg=msg;
    }
    
    public String getMsg()
    {
        return this.msg;
    }
    public int getCode() {
      return this.code;
  }
}
