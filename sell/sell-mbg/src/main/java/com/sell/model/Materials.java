package com.sell.model;

import java.io.Serializable;

public class Materials implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 材料名称
     */
    private String materialName;

    /**
     * 用量
     */
    private String dosage;

    /**
     * 菜肴ID（外键）
     */
    private Integer dishId;

    /**
     * s_materials
     */
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", materialName=").append(materialName);
        sb.append(", dosage=").append(dosage);
        sb.append(", dishId=").append(dishId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}