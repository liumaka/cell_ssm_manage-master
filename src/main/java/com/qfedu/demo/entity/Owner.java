package com.qfedu.demo.entity;

import com.qfedu.demo.entity.Community;
import com.qfedu.demo.entity.House;

import java.util.Date;
import java.io.Serializable;

/**
 * 业主表(DbOwner)实体类
 *
 * @author makejava
 * @since 2021-11-05 16:25:00
 */
public class Owner implements Serializable {
    private static final long serialVersionUID = -71204308734547858L;
    /**
     * 业主ID
     */
    private Integer id;
    /**
     * 所属小区
     */
    private Integer cid;
    /**
     * 所属房产
     */
    private Integer hid;
    /**
     * 成员名称
     */
    private String oname;
    /**
     * 成员照片
     */
    private String picture;
    /**
     * 身份证号
     */
    private String idcard;
    /**
     * 联系方式
     */
    private String telephone;
    /**
     * 职业
     */
    private String profession;
    /**
     * 性别:0-男（默认），1-女
     */
    private String sex;
    /**
     * 类型:0-房主（默认），1-租客
     */
    private String type;
    /**
     * 备注（默认无）
     */
    private String remark;

    /**
     * 更新时间
     */
    private Date createTime;
    /**
     * 出生日期
     */
    private String birthday;
    private Community community;
    private House house;

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", cid=" + cid +
                ", hid=" + hid +
                ", oname='" + oname + '\'' +
                ", picture='" + picture + '\'' +
                ", idcard='" + idcard + '\'' +
                ", telephone=" + telephone +
                ", profession='" + profession + '\'' +
                ", sex='" + sex + '\'' +
                ", type='" + type + '\'' +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                ", birthday=" + birthday +
                ", community=" + community +
                ", house=" + house +
                '}';
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

}

