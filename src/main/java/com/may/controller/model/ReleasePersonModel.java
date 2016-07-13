package com.may.controller.model;

import java.io.Serializable;

/**
 * Created by mayxys on 2016/7/13.
 */
public class ReleasePersonModel  implements Serializable{

    private static final long serialVersionUID = 1599188986326346583L;
    private String id;

    private String releasename;

    private String createdate;

    private String updatedate;

    private String isused;

    private String systemcode;

    private String remark;

    private String systemName;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReleasename() {
        return releasename;
    }

    public void setReleasename(String releasename) {
        this.releasename = releasename;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate;
    }

    public String getIsused() {
        return isused;
    }

    public void setIsused(String isused) {
        this.isused = isused;
    }

    public String getSystemcode() {
        return systemcode;
    }

    public void setSystemcode(String systemcode) {
        this.systemcode = systemcode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }
}
