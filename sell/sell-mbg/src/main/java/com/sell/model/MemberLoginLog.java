package com.sell.model;

import java.util.Date;

/** 
* @author  作者 YJX 
* @date 创建时间：2019年6月28日 下午8:22:34 
* @version 1.0  
* @return  
*/
public class MemberLoginLog {
	private Long id;

    /**
     * 登录用户id
     */
    private Long memberId;

    /**
     * 登陆时间
     */
    private Date createTime;

    /**
     * 所在地ip
     */
    private String ip;

    /**
     * 登录城市
     */
    private String city;

    /**
     * 登录类型：0->PC；1->android;2->ios;3->小程序
     *
     * @mbggenerated
     */
    private Integer loginType;

    /**
     * 登录省份
     */
    private String province;
    
    /**
     * 设备型号
     */
    private String deviceModel;
    
    /**
     * 账号类型  0 微信  1普通账号
     */
    private int sourceType;
    
    /**
     * 小程序版本号
     */
    private String appVersion;
    
    /**
     * 设备操作系统 android/ios
     */
    private String os;
    
    /**
     * 设备标识
     */
    private String deviceId;
    
    /**
     * 设备版本
     */
    private String deviceVersion;

    private static final long serialVersionUID = 1L;

    
    public String getDeviceVersion() {
		return deviceVersion;
	}

	public void setDeviceVersion(String deviceVersion) {
		this.deviceVersion = deviceVersion;
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

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getLoginType() {
        return loginType;
    }

    public void setLoginType(Integer loginType) {
        this.loginType = loginType;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", memberId=").append(memberId);
        sb.append(", createTime=").append(createTime);
        sb.append(", ip=").append(ip);
        sb.append(", city=").append(city);
        sb.append(", loginType=").append(loginType);
        sb.append(", province=").append(province);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

	public MemberLoginLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberLoginLog(Long memberId, Date createTime, String ip, String city, Integer loginType,
			String province, String deviceModel, int sourceType, String appVersion, String os, String deviceId, String deviceVersion) {
		super();
		this.memberId = memberId;
		this.createTime = createTime;
		this.ip = ip;
		this.city = city;
		this.loginType = loginType;
		this.province = province;
		this.deviceModel = deviceModel;
		this.sourceType = sourceType;
		this.appVersion = appVersion;
		this.os = os;
		this.deviceId = deviceId;
		this.deviceVersion = deviceVersion;
	}
}
