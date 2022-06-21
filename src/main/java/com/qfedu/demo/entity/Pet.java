package com.qfedu.demo.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 宠物表(DbPet)实体类
 *
 * @author makejava
 * @since 2021-11-06 10:54:19
 */
public class Pet implements Serializable {
    private static final long serialVersionUID = 509035489175213732L;
    /**
     * 宠物ID
     */
    private Integer id;
    /**
     * 宠物照片
     */
    private String picture;
    /**
     * 所属成员（业主）ID
     */
    private Integer oid;
    /**
     * 宠物名称
     */
    private String name;
    /**
     * 宠物颜色
     */
    private String color;
    /**
     * 备注
     */
    private String remark;

    /**
     * 收养时间
     */
    private String adoptTime;
    private Owner owner;

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", picture='" + picture + '\'' +
                ", oid=" + oid +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", remark='" + remark + '\'' +
                ", adoptTime=" + adoptTime +
                ", owner=" + owner +
                '}';
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAdoptTime() {
        return adoptTime;
    }

    public void setAdoptTime(String adoptTime) {
        this.adoptTime = adoptTime;
    }
}

