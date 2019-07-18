package com.sell.portal.dto;

/** 
* @author  作者 YJX 
* @date 创建时间：2019年6月28日 下午7:41:36 
* @version 1.0  
* @return  
*/
public class LoginParameter {
	/**
	 *ip地址 
	 */
	private String ip;
	/**
	 * 登录类型：0->PC；1->android;2->ios;3->小程序
	 */
	private int loginType;
	/**
	 *小程序的appid
	 */
	//private String appid;
	
	private String code;
	/**
	 * 设备标识
	 */
	private String deviceId;
	/**
	 *小程序版本
	 */
	private String appVersion;
	/**
	 * 设备型号
	 */
	private String deviceModel;
	
	/**
	 * 设备版本
	 */
	private String deviceVersion;
	
	/**
	 * 账号类型 0微信  1普通账号
	 */
	private int sourceType;
	/**
	 * 设备系统类型  Android/ios
	 */
	private String os;
	
	/**
	 * 用户昵称
	 */
	private String nickName;
	
	/**
	 * 用户头像
	 */
	private String headPic;
	
	/**
	 * 用户电话号码
	 */
	private String tel;
	
	/**
	 * 性别
	 */
	private int gender;
	
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getHeadPic() {
		return headPic;
	}
	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getDeviceVersion() {
		return deviceVersion;
	}
	public void setDeviceVersion(String deviceVersion) {
		this.deviceVersion = deviceVersion;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getLoginType() {
		return loginType;
	}
	public void setLoginType(int loginType) {
		this.loginType = loginType;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getAppVersion() {
		return appVersion;
	}
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	public String getDeviceModel() {
		return deviceModel;
	}
	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}
	public int getSourceType() {
		return sourceType;
	}
	public void setSourceType(int sourceType) {
		this.sourceType = sourceType;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	
}
