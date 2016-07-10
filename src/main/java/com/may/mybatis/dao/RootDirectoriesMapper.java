package com.may.mybatis.dao;

import com.may.mybatis.model.RootDirectories;
import com.may.mybatis.model.RootDirectoriesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RootDirectoriesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table root_directories
     *
     * @mbggenerated Sun Jul 10 22:01:42 CST 2016
     */
    int countByExample(RootDirectoriesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table root_directories
     *
     * @mbggenerated Sun Jul 10 22:01:42 CST 2016
     */
    int deleteByExample(RootDirectoriesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table root_directories
     *
     * @mbggenerated Sun Jul 10 22:01:42 CST 2016
     */
    int insert(RootDirectories record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table root_directories
     *
     * @mbggenerated Sun Jul 10 22:01:42 CST 2016
     */
    int insertSelective(RootDirectories record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table root_directories
     *
     * @mbggenerated Sun Jul 10 22:01:42 CST 2016
     */
    List<RootDirectories> selectByExample(RootDirectoriesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table root_directories
     *
     * @mbggenerated Sun Jul 10 22:01:42 CST 2016
     */
    int updateByExampleSelective(@Param("record") RootDirectories record, @Param("example") RootDirectoriesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table root_directories
     *
     * @mbggenerated Sun Jul 10 22:01:42 CST 2016
     */
    int updateByExample(@Param("record") RootDirectories record, @Param("example") RootDirectoriesExample example);
}