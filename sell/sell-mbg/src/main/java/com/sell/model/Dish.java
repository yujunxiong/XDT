package com.sell.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Dish implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 菜肴名称
     */
    private String vendorSpuName;
    
    /**
     * 菜肴主材
     */
    private String material;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 菜肴描述
     */
    private String description;
    
    /**
     * 公司ID
     */
    private Integer companyId;
    
    /**
     * 公司Key
     */
    private Integer companyKey;
    
    /**
     * 菜肴分类
     */
    private Integer categoryId;
    
    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createTime;
    
    /**
     * 主图
     */
    private String pic;
    
    /**
     * 画册
     */
    private String albumPics;
    
    private DishCategory dishCategory;

    /**
     * s_dish
     */
    private static final long serialVersionUID = 1L;

    
    public DishCategory getDishCategory() {
		return dishCategory;
	}

	public void setDishCategory(DishCategory dishCategory) {
		this.dishCategory = dishCategory;
	}

	public Integer getCompanyKey() {
		return companyKey;
	}

	public void setCompanyKey(Integer companyKey) {
		this.companyKey = companyKey;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
    public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVendorSpuName() {
        return vendorSpuName;
    }

    public void setVendorSpuName(String vendorSpuName) {
        this.vendorSpuName = vendorSpuName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", vendorSpuName=").append(vendorSpuName);
        sb.append(", price=").append(price);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}