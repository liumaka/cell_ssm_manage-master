package com.qfedu.demo.entity;

import java.util.Date;

/**
 * (DbBuilding)实体类
 *
 * @author makejava
 * @since 2021-10-26 20:40:17
 */
public class Building {
    private Community community;
    private Integer id;
    private String buildingNum;
    private String bname;
    private Integer roomNum;
    private String buildingDesc;
    private Date buildHiredate;
    private Integer cid;

    @Override
    public String toString() {
        return "Building{" +
                "community=" + community +
                ", id=" + id +
                ", buildingNum='" + buildingNum + '\'' +
                ", bname='" + bname + '\'' +
                ", roomNum=" + roomNum +
                ", buildingDesc='" + buildingDesc + '\'' +
                ", buildHiredate=" + buildHiredate +
                ", cid=" + cid +
                '}';
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuildingNum() {
        return buildingNum;
    }

    public void setBuildingNum(String buildingNum) {
        this.buildingNum = buildingNum;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public Integer getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }

    public String getBuildingDesc() {
        return buildingDesc;
    }

    public void setBuildingDesc(String buildingDesc) {
        this.buildingDesc = buildingDesc;
    }

    public Date getBuildHiredate() {
        return buildHiredate;
    }

    public void setBuildHiredate(Date buildHiredate) {
        this.buildHiredate = buildHiredate;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}

