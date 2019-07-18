package com.sell.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class TurnkeyCompany implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 名称
     */
    private String companyName;

    /**
     * 纬度
     */
    private Double lo;

    /**
     * 经纬
     */
    private Double la;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 城市
     */
    private String city;

    /**
     * 县、区
     */
    private String county;

    /**
     * 省
     */
    private String province;

    /**
     * 乡镇
     */
    private String town;

    /**
     * 商家姓名
     */
    private String name;

    /**
     * 商家电话号码
     */
    private String tel;

    /**
     * 身份证正面
     */
    private String cardPositivePic;

    /**
     * 身份证反面
     */
    private String cardBackPic;

    /**
     * 营业执照
     */
    private String licensePic;

    /**
     * 是否禁用 0 启用 1 禁用
     */
    private Integer onoff;

    /**
     * 是否删除 0 未删除 1 删除
     */
    private Integer del;

    /**
     * 审核是否通过 0 审核中 1 通过 2 不通过
     */
    private Integer check;
    
    /**
     * 乡镇码
     */
    private String townCode;
    
    /**
     * 区/县码
     */
    private String countyCode;
    
    /**
     * 其它服务费
     */
    private BigDecimal serviceCharge;
    
    /**
     * 其它服务费
     */
    private Integer userId;

    /**
     * s_turnkey_company
     */
    private static final long serialVersionUID = 1L;

    
    public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public BigDecimal getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(BigDecimal serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getLo() {
        return lo;
    }

    public void setLo(Double lo) {
        this.lo = lo;
    }

    public Double getLa() {
        return la;
    }

    public void setLa(Double la) {
        this.la = la;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }

    public String getTownCode() {
        return townCode;
    }

    public void setTownCode(String townCode) {
        this.townCode = townCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCardPositivePic() {
        return cardPositivePic;
    }

    public void setCardPositivePic(String cardPositivePic) {
        this.cardPositivePic = cardPositivePic;
    }

    public String getCardBackPic() {
        return cardBackPic;
    }

    public void setCardBackPic(String cardBackPic) {
        this.cardBackPic = cardBackPic;
    }

    public String getLicensePic() {
        return licensePic;
    }

    public void setLicensePic(String licensePic) {
        this.licensePic = licensePic;
    }

    public Integer getOnoff() {
        return onoff;
    }

    public void setOnoff(Integer onoff) {
        this.onoff = onoff;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    public Integer getCheck() {
        return check;
    }

    public void setCheck(Integer check) {
        this.check = check;
    }

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	@Override
	public String toString() {
		return "TurnkeyCompany [id=" + id + ", companyName=" + companyName + ", lo=" + lo + ", la=" + la + ", address="
				+ address + ", city=" + city + ", county=" + county + ", province=" + province + ", town=" + town
				+ ", name=" + name + ", tel=" + tel + ", cardPositivePic=" + cardPositivePic + ", cardBackPic="
				+ cardBackPic + ", licensePic=" + licensePic + ", onoff=" + onoff + ", del=" + del + ", check=" + check
				+ ", townCode=" + townCode + ", countyCode=" + countyCode + "]";
	}

}