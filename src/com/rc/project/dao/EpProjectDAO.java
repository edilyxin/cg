package com.rc.project.dao;

import com.rc.project.form.EpProjectForm;
import com.rc.project.vo.EpProject;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EpProjectDAO extends SqlMapClientDaoSupport {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PROJECT
     *
     * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
     */
    public EpProjectDAO() {
        super();
    }


    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PROJECT
     *
     * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
     */
    public int deleteByPrimaryKey(EpProjectForm key) {
        int rows = getSqlMapClientTemplate().delete("EP_PROJECT_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PROJECT
     *
     * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
     */
    public void insert(EpProjectForm record) {
        getSqlMapClientTemplate().insert("EP_PROJECT_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PROJECT
     *
     * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
     */
    public void insertSelective(EpProjectForm record) {
        getSqlMapClientTemplate().insert("EP_PROJECT_insertSelective", record);
    }


    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PROJECT
     *
     * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
     */
    public EpProject selectByPrimaryKey(EpProjectForm key) {
    	EpProject record = (EpProject) getSqlMapClientTemplate().queryForObject("EP_PROJECT_selectByPrimaryKey", key);
        return record;
    }


    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PROJECT
     *
     * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
     */
    public int updateByPrimaryKeySelective(EpProjectForm record) {
        int rows = getSqlMapClientTemplate().update("EP_PROJECT_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PROJECT
     *
     * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
     */
    public int updateByPrimaryKey(EpProjectForm record) {
        int rows = getSqlMapClientTemplate().update("EP_PROJECT_updateByPrimaryKey", record);
        return rows;
    }

}