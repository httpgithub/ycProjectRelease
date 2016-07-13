package com.may.controller.model;

import java.io.Serializable;
import java.util.Date;

public class RootDirectoriesModel implements Serializable{
    private static final long serialVersionUID = 1520990411583438354L;
    private String id;

    private String directorieyName;

    private String isused;

    private String  createDate;

    private String createPersion;

    private String updateDate;

    private String updatePersion;

    private String sysId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDirectorieyName() {
        return directorieyName;
    }

    public void setDirectorieyName(String directorieyName) {
        this.directorieyName = directorieyName;
    }

    public String getIsused() {
        return isused;
    }

    public void setIsused(String isused) {
        this.isused = isused;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreatePersion() {
        return createPersion;
    }

    public void setCreatePersion(String createPersion) {
        this.createPersion = createPersion;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdatePersion() {
        return updatePersion;
    }

    public void setUpdatePersion(String updatePersion) {
        this.updatePersion = updatePersion;
    }

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }
}