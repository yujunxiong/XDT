package com.sell.model;

import java.math.BigDecimal;

/**
 * 订单明细表
 * @author guyefeng
 */
public class OrderItem {

	private Integer id;
	private String orderCode;//订单号
	private String vendorSpuName;//菜品名称
	private BigDecimal price;//单价
	private String description;//菜品描述
	private String material;//菜品主材
    private String pic;//菜品主图
    private String albumPics;//菜品连环画册
    private String categoryName;//菜品分类名称
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
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
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
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
    
}
