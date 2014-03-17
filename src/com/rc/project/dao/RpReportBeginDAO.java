package com.rc.project.dao;

import com.rc.project.form.RpReportBeginForm;
import com.rc.project.vo.RpReportBegin;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class RpReportBeginDAO extends SqlMapClientDaoSupport {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.RP_REPORTBEGIN
     *
     * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
     */
    public RpReportBeginDAO() {
        super();
    }


    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.RP_REPORTBEGIN
     *
     * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
     */
    public int deleteByPrimaryKey(String RPB_SNO) {
        RpReportBeginForm key = new RpReportBeginForm();
        key.setRPB_SNO(RPB_SNO);
        int rows = getSqlMapClientTemplate().delete("RP_REPORTBEGIN_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.RP_REPORTBEGIN
     *
     * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
     */
    public void insert(RpReportBeginForm record) {
        getSqlMapClientTemplate().insert("RP_REPORTBEGIN_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.RP_REPORTBEGIN
     *
     * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
     */
    public void insertSelective(RpReportBeginForm record) {
        getSqlMapClientTemplate().insert("RP_REPORTBEGIN_insertSelective", record);
    }


    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.RP_REPORTBEGIN
     *
     * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
     */
    public RpReportBegin selectByPrimaryKey(String RPB_SNO) {
        RpReportBeginForm key = new RpReportBeginForm();
        key.setRPB_SNO(RPB_SNO);
        RpReportBegin record = (RpReportBegin) getSqlMapClientTemplate().queryForObject("RP_REPORTBEGIN_selectByPrimaryKey", key);
        return record;
    }


    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.RP_REPORTBEGIN
     *
     * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
     */
    public int updateByPrimaryKeySelective(RpReportBeginForm record) {
        int rows = getSqlMapClientTemplate().update("RP_REPORTBEGIN_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.RP_REPORTBEGIN
     *
     * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
     */
    public int updateByPrimaryKey(RpReportBeginForm record) {
        int rows = getSqlMapClientTemplate().update("RP_REPORTBEGIN_updateByPrimaryKey", record);
        return rows;
    }
    
    public List<RpReportBegin> selectByPage(RpReportBeginForm form){
    	return getSqlMapClientTemplate().queryForList("RP_REPORTBEGIN_selectByPage", form);
    }
    
    public int selectSize(RpReportBeginForm form){
    	return (Integer)getSqlMapClientTemplate().queryForObject("RP_REPORTBEGIN_findSizeByForm",form);
    }


}