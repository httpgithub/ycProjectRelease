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

    private String updatedate;

    private String updateperson;

    private String isused;

    private String pathlist;

    private String systemname;

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
}
