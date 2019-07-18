package com.sell.model;

import java.io.Serializable;
import java.util.Date;

public class Evaluate implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户id(外键)
     */
    private Integer memberId;

    /**
     * 套餐id (外键)
     */
    private Integer setMealId;

    /**
     * 厨师id (外键)
     */
    private Integer chefId;

    /**
     * 评分
     */
    private Integer score;

    /**
     * 评价时间
     */
    private Date creatTime;

    /**
     * 评价分类（0 套餐评价 1 厨师评价）
     */
    private Integer type;

    /**
     * 
     */
    private String comment;

    /**
     * s_evaluate
     */
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberrId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getSetMealId() {
        return setMealId;
    }

    public void setSetMealId(Integer setMealId) {
        this.setMealId = setMealId;
    }

    public Integer getChefId() {
        return chefId;
    }

    public void setChefId(Integer chefId) {
        this.chefId = chefId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", memberId=").append(memberId);
        sb.append(", setMealId=").append(setMealId);
        sb.append(", chefId=").append(chefId);
        sb.append(", score=").append(score);
        sb.append(", creatTime=").append(creatTime);
        sb.append(", type=").append(type);
        sb.append(", comment=").append(comment);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}