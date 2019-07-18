package com.sell.model;

/** 
* @author  作者 YJX 
* @date 创建时间： 2019年6月30日 下午5:10:06  
* @version 1.0  
* @return  
*/
public class MealCategory {
	/**
     * 主键
     */
    private Integer id;

    /**
     * 菜品分类名称
     */
    private String mealCategoryName;

    /**
     * 菜品分类排名
     */
    private Integer rank;

    /**
     * 是否删除 0否 1是
     */
    private Integer del;

    /**
     * s_dish_category
     */
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getmealCategoryName() {
        return mealCategoryName;
    }

    public void setmealCategoryName(String mealCategoryName) {
        this.mealCategoryName = mealCategoryName;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", dishCategoryName=").append(mealCategoryName);
        sb.append(", rank=").append(rank);
        sb.append(", del=").append(del);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
