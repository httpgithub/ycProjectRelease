package com.may.controller.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by mayxys on 2016/6/30.
 */
public class ReleaseModel  implements Serializable {
    private static final long serialVersionUID = 6235432904070822535L;
    private String releaseMark;

    private Date createdate;

    private String createperson;

    private Date updatedate;

    private Date updateperson;

    private String isused;

    private String pathlist;

    private String systemname;

    public String getReleaseMark() {
        return releaseMark;
    }

    public void setReleaseMark(String releaseMark) {
        this.releaseMark = releaseMark;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getCreateperson() {
        return createperson;
    }

    public void setCreateperson(String createperson) {
        this.createperson = createperson;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public Date getUpdateperson() {
        return updateperson;
    }

    public void setUpdateperson(Date updateperson) {
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
}
