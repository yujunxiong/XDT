package com.sell.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单
 * @author guyefeng
 */
public class Order {

	private Integer id;
	private String orderCode;//订单号
	private Integer companyId;//公司id
	private String userName;//用户姓名
	private String userTel;//用户手机号
	private String userAddress;//用户地址
	private String remark;//订单备注
	private Integer earnestPayment;//定金支付方式(0微信 1 支付宝 2…)	
	private Date createTime;//下单时间
	private int state;//订单状态 0 未付款 1 已付定金款 2 进行中 3 已结尾款 4 完成 5 取消 6 退款
	private int refundState;//退款 0 未发起退款 1 退款中 2 拒绝退 款 3 同意退款
	private BigDecimal earnestPaymoney;//定金
	private BigDecimal realPaymoney;//实付款
	private BigDecimal tailPaymoney;//尾款
	private BigDecimal discountMoney;//优惠券抵用金额
	private String mealName;//套餐名称
	private BigDecimal mealPrice;//套餐价格
	private Integer coldDishNum;//冷菜数量
	private Integer hotDishNum;//热菜数量
	private Integer fruitNum;///水果数量
	private String chefName;//厨师名称
	private String chefTel;//厨师电话
	private BigDecimal chefPrice;//厨师雇佣价格
	private Date startTime;//档期开始时间
	private Date endTime;//档期结束时间
	private Integer workingDay;//工作时长
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getEarnestPayment() {
		return earnestPayment;
	}
	public void setEarnestPayment(Integer earnestPayment) {
		this.earnestPayment = earnestPayment;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getRefundState() {
		return refundState;
	}
	public void setRefundState(int refundState) {
		this.refundState = refundState;
	}
	public BigDecimal getEarnestPaymoney() {
		return earnestPaymoney;
	}
	public void setEarnestPaymoney(BigDecimal earnestPaymoney) {
		this.earnestPaymoney = earnestPaymoney;
	}
	public BigDecimal getRealPaymoney() {
		return realPaymoney;
	}
	public void setRealPaymoney(BigDecimal realPaymoney) {
		this.realPaymoney = realPaymoney;
	}
	public BigDecimal getTailPaymoney() {
		return tailPaymoney;
	}
	public void setTailPaymoney(BigDecimal tailPaymoney) {
		this.tailPaymoney = tailPaymoney;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public BigDecimal getDiscountMoney() {
		return discountMoney;
	}
	public void setDiscountMoney(BigDecimal discountMoney) {
		this.discountMoney = discountMoney;
	}
	public String getMealName() {
		return mealName;
	}
	public void setMealName(String mealName) {
		this.mealName = mealName;
	}
	public BigDecimal getMealPrice() {
		return mealPrice;
	}
	public void setMealPrice(BigDecimal mealPrice) {
		this.mealPrice = mealPrice;
	}
	public Integer getColdDishNum() {
		return coldDishNum;
	}
	public void setColdDishNum(Integer coldDishNum) {
		this.coldDishNum = coldDishNum;
	}
	public Integer getHotDishNum() {
		return hotDishNum;
	}
	public void setHotDishNum(Integer hotDishNum) {
		this.hotDishNum = hotDishNum;
	}
	public Integer getFruitNum() {
		return fruitNum;
	}
	public void setFruitNum(Integer fruitNum) {
		this.fruitNum = fruitNum;
	}
	public String getChefName() {
		return chefName;
	}
	public void setChefName(String chefName) {
		this.chefName = chefName;
	}
	public String getChefTel() {
		return chefTel;
	}
	public void setChefTel(String chefTel) {
		this.chefTel = chefTel;
	}
	public BigDecimal getChefPrice() {
		return chefPrice;
	}
	public void setChefPrice(BigDecimal chefPrice) {
		this.chefPrice = chefPrice;
	}
	public Integer getWorkingDay() {
		return workingDay;
	}
	public void setWorkingDay(Integer workingDay) {
		this.workingDay = workingDay;
	}
	
	
}
