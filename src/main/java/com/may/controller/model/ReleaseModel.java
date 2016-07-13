package com.may.controller.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by mayxys on 2016/6/30.
 */
public class ReleaseModel  implements Serializable {
    private static final long serialVersionUID = 6235432904070822535L;
    private String id;

    private String releaseMark;

    private String createdate;

    private String createperson;

    private String createpersonName;

    private String updatedate;

    private String updateperson;

    private String isused;

    private String pathlist;


    private String isDelete;

    private String ispublish;
    private String releasepersonid;

    private String releasepersonname;

    private String systemid;

    private String systemname;

    private String isend;

    public String getIsend() {
        return isend;
    }

    public void setIsend(String isend) {
        this.isend = isend;
    }

    public String getReleaseMark() {
        return releaseMark;
    }

    public void setReleaseMark(String releaseMark) {
        this.releaseMark = releaseMark;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getCreateperson() {
        return createperson;
    }

    public void setCreateperson(String createperson) {
        this.createperson = createperson;
    }

    public String getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate;
    }

    public String getUpdateperson() {
        return updateperson;
    }

    public void setUpdateperson(String updateperson) {
        this.updateperson = updateperson;
    }

    public String getIsused() {
        return isused;
    }

    public void setIsused(String isused) {
        this.isused = isused;
    }

    public String getPathlist() {
        return pathlist;
    }

    public void setPathlist(String pathlist) {
        this.pathlist = pathlist;
    }

    public String getSystemname() {
        return systemname;
    }

    public void setSystemname(String systemname) {
        this.systemname = systemname;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getIspublish() {
        return ispublish;
    }

    public void setIspublish(String ispublish) {
        this.ispublish = ispublish;
    }

    public String getCreatepersonName() {
        return createpersonName;
    }

    public void setCreatepersonName(String createpersonName) {
        this.createpersonName = createpersonName;
    }

    public String getReleasepersonid() {
        return releasepersonid;
    }

    public void setReleasepersonid(String releasepersonid) {
        this.releasepersonid = releasepersonid;
    }

    public String getReleasepersonname() {
        return releasepersonname;
    }

    public void setReleasepersonname(String releasepersonname) {
        this.releasepersonname = releasepersonname;
    }

    public String getSystemid() {
        return systemid;
    }

    public void setSystemid(String systemid) {
        this.systemid = systemid;
    }

}
