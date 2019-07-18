package com.sell.model;

import java.io.Serializable;

public class ChefDish implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 厨师ID
     */
    private Integer chefId;

    /**
     * 菜肴ID
     */
    private Integer dishId;

    /**
     * s_chef_dish
     */
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", chefId=").append(chefId);
        sb.append(", dishId=").append(dishId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}