package com.rc.project.dao;

import com.rc.project.vo.EpFormwork;
import com.rc.project.vo.EpFormworkExample;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EpFormworkDAO extends SqlMapClientDaoSupport {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_FORMWORK
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public EpFormworkDAO() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_FORMWORK
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public int countByExample(EpFormworkExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EP_FORMWORK_countByExample", example);
        return count.intValue();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_FORMWORK
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public int deleteByExample(EpFormworkExample example) {
        int rows = getSqlMapClientTemplate().delete("EP_FORMWORK_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_FORMWORK
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public int deleteByPrimaryKey(BigDecimal formNid) {
        EpFormwork key = new EpFormwork();
        key.setFormNid(formNid);
        int rows = getSqlMapClientTemplate().delete("EP_FORMWORK_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_FORMWORK
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public void insert(EpFormwork record) {
        getSqlMapClientTemplate().insert("EP_FORMWORK_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_FORMWORK
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public void insertSelective(EpFormwork record) {
        getSqlMapClientTemplate().insert("EP_FORMWORK_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_FORMWORK
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public List selectByExample(EpFormworkExample example) {
        List list = getSqlMapClientTemplate().queryForList("EP_FORMWORK_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_FORMWORK
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public EpFormwork selectByPrimaryKey(BigDecimal formNid) {
        EpFormwork key = new EpFormwork();
        key.setFormNid(formNid);
        EpFormwork record = (EpFormwork) getSqlMapClientTemplate().queryForObject("EP_FORMWORK_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_FORMWORK
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public int updateByExampleSelective(EpFormwork record, EpFormworkExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_FORMWORK_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_FORMWORK
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public int updateByExample(EpFormwork record, EpFormworkExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_FORMWORK_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_FORMWORK
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public int updateByPrimaryKeySelective(EpFormwork record) {
        int rows = getSqlMapClientTemplate().update("EP_FORMWORK_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_FORMWORK
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public int updateByPrimaryKey(EpFormwork record) {
        int rows = getSqlMapClientTemplate().update("EP_FORMWORK_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table EP_FORMWORK
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    private static class UpdateByExampleParms extends EpFormworkExample {
        private Object record;

        public UpdateByExampleParms(Object record, EpFormworkExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}