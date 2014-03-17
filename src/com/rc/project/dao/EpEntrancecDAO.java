package com.rc.project.dao;

import com.rc.project.form.EpEntrancecForm;
import com.rc.project.vo.EpEntrancec;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EpEntrancecDAO extends SqlMapClientDaoSupport {
  


    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_ENTRANCEC
     *
     * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
     */
    public int deleteByPrimaryKey(BigDecimal ETC_NID) {
        EpEntrancecForm key = new EpEntrancecForm();
        key.setETC_NID(ETC_NID);
        int rows = getSqlMapClientTemplate().delete("EP_ENTRANCEC_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_ENTRANCEC
     *
     * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
     */
    public void insert(EpEntrancecForm record) {
        getSqlMapClientTemplate().insert("EP_ENTRANCEC_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_ENTRANCEC
     *
     * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
     */
    public void insertSelective(EpEntrancecForm record) {
        getSqlMapClientTemplate().insert("EP_ENTRANCEC_insertSelective", record);
    }


    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_ENTRANCEC
     *
     * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
     */
    public EpEntrancec selectByPrimaryKey(BigDecimal ETC_NID) {
        EpEntrancecForm key = new EpEntrancecForm();
        key.setETC_NID(ETC_NID);
        EpEntrancec record = (EpEntrancec) getSqlMapClientTemplate().queryForObject("EP_ENTRANCEC_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_ENTRANCEC
     *
     * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
     */
    public int updateByPrimaryKeySelective(EpEntrancecForm record) {
        int rows = getSqlMapClientTemplate().update("EP_ENTRANCEC_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_ENTRANCEC
     *
     * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
     */
    public int updateByPrimaryKey(EpEntrancecForm record) {
        int rows = getSqlMapClientTemplate().update("EP_ENTRANCEC_updateByPrimaryKey", record);
        return rows;
    }
}