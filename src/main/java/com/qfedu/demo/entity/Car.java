package com.qfedu.demo.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 车辆表(DbCar)实体类
 *
 * @author makejava
 * @since 2021-11-06 09:51:24
 */
public class Car implements Serializable {
    private static final long serialVersionUID = -53440701877036285L;
    /**
     * 车辆ID
     */
    private Integer id;
    /**
     * 车辆照片
     */
    private String picture;
    /**
     * 所属成员（业主）
     */
    private Integer oid;
    /**
     * 车辆颜色
     */
    private String color;
    /**
     * 车牌号
     */
    private String carNumber;
    /**
     * 备注
     */
    private String remark;

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", picture='" + picture + '\'' +
                ", oid=" + oid +
                ", color='" + color + '\'' +
                ", carNumber='" + carNumber + '\'' +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", owner=" + owner +
                '}';
    }

    /**
     * 创建时间
     */
    private Date createTime;
    private Owner owner;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }



    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}

