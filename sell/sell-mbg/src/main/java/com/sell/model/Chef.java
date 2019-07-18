package com.sell.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class Chef implements Serializable {
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
     * 评分
     */
    private Double score;

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
     * 公司ID
     */
    private Integer companyId;
    
    /**
     * 套餐
     */
    private List<SetMeal> setMeals;
    
    /**
     * 上下架 0 下架 1上架
     */
    private Integer putaway;
    

    /**
     * s_chef
     */
    private static final long serialVersionUID = 1L;
    
    public List<SetMeal> getSetMeals() {
		return setMeals;
	}

	public void setSetMeals(List<SetMeal> setMeals) {
		this.setMeals = setMeals;
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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
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

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", chefName=").append(chefName);
        sb.append(", tel=").append(tel);
        sb.append(", score=").append(score);
        sb.append(", price=").append(price);
        sb.append(", intro=").append(intro);
        sb.append(", pic=").append(pic);
        sb.append(", albumPics=").append(albumPics);
        sb.append(", signature=").append(signature);
        sb.append(", workingYears=").append(workingYears);
        sb.append(", companyId=").append(companyId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}