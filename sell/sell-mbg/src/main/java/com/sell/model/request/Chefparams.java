package com.sell.model.request;

import java.math.BigDecimal;

public class Chefparams {

	 /**
     * 主键
     */
    private Integer id;

    /**
     * 姓名
     */
    private String chefName;

    /**
     * 联系方式
     */
    private String tel;


    /**
     * 雇佣价格
     */
    private BigDecimal price;

    /**
     * 个人介绍
     */
    private String intro;

    /**
     * 主图
     */
    private String pic;

    /**
     * 画册图片
     */
    private String albumPics;

    /**
     * 个性签名
     */
    private String signature;

    /**
     * 工作年限
     */
    private Integer workingYears;

    /**
     * 公司key
     */
    private String companyKey;
    
    /**
     * 公司id
     */
    private Integer companyId;
    
    /**
     * 上下架
     */
    private Integer putaway;
    
    private String token; 

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getPutaway() {
		return putaway;
	}

	public void setPutaway(Integer putaway) {
		this.putaway = putaway;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChefName() {
		return chefName;
	}

	public void setChefName(String chefName) {
		this.chefName = chefName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getAlbumPics() {
		return albumPics;
	}

	public void setAlbumPics(String albumPics) {
		this.albumPics = albumPics;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public Integer getWorkingYears() {
		return workingYears;
	}

	public void setWorkingYears(Integer workingYears) {
		this.workingYears = workingYears;
	}

	public String getCompanyKey() {
		return companyKey;
	}

	public void setCompanyKey(String companyKey) {
		this.companyKey = companyKey;
	}
    
}
