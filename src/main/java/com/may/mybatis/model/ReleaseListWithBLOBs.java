package com.may.mybatis.model;

public class ReleaseListWithBLOBs extends ReleaseList {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Release_list.pathList
     *
     * @mbggenerated Wed Jul 06 11:08:22 CST 2016
     */
    private String pathlist;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Release_list.systemName
     *
     * @mbggenerated Wed Jul 06 11:08:22 CST 2016
     */
    private String systemname;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Release_list.pathList
     *
     * @return the value of Release_list.pathList
     *
     * @mbggenerated Wed Jul 06 11:08:22 CST 2016
     */
    public String getPathlist() {
        return pathlist;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Release_list.pathList
     *
     * @param pathlist the value for Release_list.pathList
     *
     * @mbggenerated Wed Jul 06 11:08:22 CST 2016
     */
    public void setPathlist(String pathlist) {
        this.pathlist = pathlist;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Release_list.systemName
     *
     * @return the value of Release_list.systemName
     *
     * @mbggenerated Wed Jul 06 11:08:22 CST 2016
     */
    public String getSystemname() {
        return systemname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Release_list.systemName
     *
     * @param systemname the value for Release_list.systemName
     *
     * @mbggenerated Wed Jul 06 11:08:22 CST 2016
     */
    public void setSystemname(String systemname) {
        this.systemname = systemname;
    }
}