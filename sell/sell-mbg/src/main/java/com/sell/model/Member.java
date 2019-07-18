package com.sell.model;

import java.util.Date;

/** 
* @author  作者 YJX 
* @date 创建时间：2019年6月28日 下午8:03:39 
* @version 1.0  
* @return  
*/
public class Member {
	 	private Integer id;

	    /**
	     * 用户名
	     */
	    private String username;

	    /**
	     * 密码
	     */
	    private String password;

	    /**
	     * 昵称
	     */
	    private String nickname;

	    /**
	     * 手机号码
	     */
	    private String phone;

	    /**
	     * 帐号启用状态:0->禁用；1->启用
	     */
	    private Integer status;

	    /**
	     * 注册时间
	     */
	    private Date createTime;

	    /**
	     * 头像
	     */
	    private String icon;

	    /**
	     * 性别：0->未知；1->男；2->女
	     */
	    private Integer gender;


	    /**
	     * 所在城市
	     */
	    private String city;

	    /**
	     * 个性签名
	     */
	    private String signature;

	    /**
	     * 账号类型  0微信 1普通账号
	     */
	    private Integer sourceType;

	    /**
	     * 积分
	     */
	    private Integer integration;

	    /**
	     * 成长值
	     */
	    private Integer growth;

	    /**
	     * 剩余抽奖次数
	     */
	    private Integer luckeyCount;

	    /**
	     * 历史积分数量
	     */
	    private Integer historyIntegration;
	    
	    /**
	     * 微信用户ID
	     */
	    private String openId;
	    
	    /**
	     * 设备标识
	     */
	    private String deviceId;

	    private static final long serialVersionUID = 1L;

	    public String getOpenId() {
			return openId;
		}

		public void setOpenId(String openId) {
			this.openId = openId;
		}

		public String getDeviceId() {
			return deviceId;
		}

		public void setDeviceId(String deviceId) {
			this.deviceId = deviceId;
		}

	    public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getNickname() {
	        return nickname;
	    }

	    public void setNickname(String nickname) {
	        this.nickname = nickname;
	    }

	    public String getPhone() {
	        return phone;
	    }

	    public void setPhone(String phone) {
	        this.phone = phone;
	    }

	    public Integer getStatus() {
	        return status;
	    }

	    public void setStatus(Integer status) {
	        this.status = status;
	    }

	    public Date getCreateTime() {
	        return createTime;
	    }

	    public void setCreateTime(Date createTime) {
	        this.createTime = createTime;
	    }

	    public String getIcon() {
	        return icon;
	    }

	    public void setIcon(String icon) {
	        this.icon = icon;
	    }

	    public Integer getGender() {
	        return gender;
	    }

	    public void setGender(Integer gender) {
	        this.gender = gender;
	    }

	    public String getCity() {
	        return city;
	    }

	    public void setCity(String city) {
	        this.city = city;
	    }

	    public Integer getSourceType() {
	        return sourceType;
	    }

	    public void setSourceType(Integer sourceType) {
	        this.sourceType = sourceType;
	    }

	    public Integer getIntegration() {
	        return integration;
	    }

	    public void setIntegration(Integer integration) {
	        this.integration = integration;
	    }

	    public Integer getGrowth() {
	        return growth;
	    }

	    public void setGrowth(Integer growth) {
	        this.growth = growth;
	    }

	    public Integer getLuckeyCount() {
	        return luckeyCount;
	    }

	    public void setLuckeyCount(Integer luckeyCount) {
	        this.luckeyCount = luckeyCount;
	    }

	    public Integer getHistoryIntegration() {
	        return historyIntegration;
	    }

	    public void setHistoryIntegration(Integer historyIntegration) {
	        this.historyIntegration = historyIntegration;
	    }

	    public String getSignature() {
			return signature;
		}

		public void setSignature(String signature) {
			this.signature = signature;
		}

		@Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        sb.append(getClass().getSimpleName());
	        sb.append(" [");
	        sb.append("Hash = ").append(hashCode());
	        sb.append(", id=").append(id);
	        sb.append(", username=").append(username);
	        sb.append(", password=").append(password);
	        sb.append(", nickname=").append(nickname);
	        sb.append(", phone=").append(phone);
	        sb.append(", status=").append(status);
	        sb.append(", createTime=").append(createTime);
	        sb.append(", icon=").append(icon);
	        sb.append(", gender=").append(gender);
	        sb.append(", city=").append(city);
	        sb.append(", sourceType=").append(sourceType);
	        sb.append(", integration=").append(integration);
	        sb.append(", growth=").append(growth);
	        sb.append(", luckeyCount=").append(luckeyCount);
	        sb.append(", historyIntegration=").append(historyIntegration);
	        sb.append(", serialVersionUID=").append(serialVersionUID);
	        sb.append("]");
	        return sb.toString();
	    }
}
