package com.rc.project.dao;

import com.rc.project.vo.EpMail;
import com.rc.project.vo.EpMailExample;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EpMailDAO extends SqlMapClientDaoSupport {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_MAIL
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public EpMailDAO() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_MAIL
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public int countByExample(EpMailExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EP_MAIL_countByExample", example);
        return count.intValue();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_MAIL
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public int deleteByExample(EpMailExample example) {
        int rows = getSqlMapClientTemplate().delete("EP_MAIL_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_MAIL
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public int deleteByPrimaryKey(BigDecimal mlNid) {
        EpMail key = new EpMail();
        key.setMlNid(mlNid);
        int rows = getSqlMapClientTemplate().delete("EP_MAIL_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_MAIL
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public void insert(EpMail record) {
        getSqlMapClientTemplate().insert("EP_MAIL_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_MAIL
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public void insertSelective(EpMail record) {
        getSqlMapClientTemplate().insert("EP_MAIL_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_MAIL
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public List selectByExample(EpMailExample example) {
        List list = getSqlMapClientTemplate().queryForList("EP_MAIL_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_MAIL
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public EpMail selectByPrimaryKey(BigDecimal mlNid) {
        EpMail key = new EpMail();
        key.setMlNid(mlNid);
        EpMail record = (EpMail) getSqlMapClientTemplate().queryForObject("EP_MAIL_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_MAIL
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public int updateByExampleSelective(EpMail record, EpMailExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_MAIL_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_MAIL
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public int updateByExample(EpMail record, EpMailExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_MAIL_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_MAIL
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public int updateByPrimaryKeySelective(EpMail record) {
        int rows = getSqlMapClientTemplate().update("EP_MAIL_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_MAIL
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public int updateByPrimaryKey(EpMail record) {
        int rows = getSqlMapClientTemplate().update("EP_MAIL_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table EP_MAIL
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    private static class UpdateByExampleParms extends EpMailExample {
        private Object record;

        public UpdateByExampleParms(Object record, EpMailExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}