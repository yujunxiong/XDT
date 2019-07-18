package com.sell.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class SetMeal implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    private Integer id;

    /**
     * 套餐名称
     */
    private String name;

    /**
     * 厨师ID
     */
    private Integer chefId;

    /**
     * 菜肴ID
     */
    private Integer dishId;

    /**
     * 冷菜数量
     */
    private Integer coldDishNum;

    /**
     * 热菜数量
     */
    private Integer hotDishNum;

    /**
     * 水果数量
     */
    private Integer fruitNum;

    /**
     * 点心数量
     */
    private Integer dessertNum;

    /**
     * 真实价格
     */
    private BigDecimal realPrice;

    /**
     * 预计价格
     */
    private BigDecimal anticipatedPrice;

    /**
     * 公司ID
     */
    private Integer companyId;

    /**
     * 点评数量
     */
    private Integer commentNum;

    /**
     * 订购数量
     */
    private Integer orderNum;

    /**
     * 评分
     */
    private Double score;

    /**
     * 描述
     */
    private String description;

    /**
     * 增量费
     */
    private Long incrementFree;
    
    /**
     * 分类ID
     */
    private Integer categoryId;
    
    /**
     * 用餐人数
     */
    private Integer dinnerNum;
    
    /**
     * 上架 0下架 上架
     */
    private Integer status;
    
    /**
     * 主图
     */
    private String pic;
    
    /**
     * 画册图片
     */
    private String albumPics;
    
    /**
     * 是否删除 0否 1是
     */
    private Integer del;
    
    /**
     * 是否默认
     */
    private Integer setDefault;
    
    /**
     * 创建时间
     */
    private Date createTime;
    
    /**
     * 是否推荐 0否 1是
     */
    private Integer recommend;
    
    /**
     * 菜品ids
     */
    private List<Integer> dishIds;
    
	public Integer getRecommend() {
		return recommend;
	}

	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}

	public List<Integer> getDishIds() {
		return dishIds;
	}

	public void setDishIds(List<Integer> dishIds) {
		this.dishIds = dishIds;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getSetDefault() {
		return setDefault;
	}

	public void setSetDefault(Integer setDefault) {
		this.setDefault = setDefault;
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

	public Integer getDel() {
		return del;
	}

	public void setDel(Integer del) {
		this.del = del;
	}

	public Integer getDinnerNum() {
		return dinnerNum;
	}

	public void setDinnerNum(Integer dinnerNum) {
		this.dinnerNum = dinnerNum;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getChefId() {
        return chefId;
    }

    public void setChefId(Integer chefId) {
        this.chefId = chefId;
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
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

    public Integer getDessertNum() {
        return dessertNum;
    }

    public void setDessertNum(Integer dessertNum) {
        this.dessertNum = dessertNum;
    }

    public BigDecimal getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(BigDecimal realPrice) {
        this.realPrice = realPrice;
    }

    public BigDecimal getAnticipatedPrice() {
        return anticipatedPrice;
    }

    public void setAnticipatedPrice(BigDecimal anticipatedPrice) {
        this.anticipatedPrice = anticipatedPrice;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getIncrementFree() {
        return incrementFree;
    }

    public void setIncrementFree(Long incrementFree) {
        this.incrementFree = incrementFree;
    }

    public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "SetMeal [id=" + id + ", name=" + name + ", chefId=" + chefId + ", dishId=" + dishId + ", coldDishNum="
				+ coldDishNum + ", hotDishNum=" + hotDishNum + ", fruitNum=" + fruitNum + ", dessertNum=" + dessertNum
				+ ", realPrice=" + realPrice + ", anticipatedPrice=" + anticipatedPrice + ", companyId=" + companyId
				+ ", commentNum=" + commentNum + ", orderNum=" + orderNum + ", score=" + score + ", description="
				+ description + ", incrementFree=" + incrementFree + ", categoryId=" + categoryId + "]";
	}

}