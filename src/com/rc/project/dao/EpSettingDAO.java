package com.rc.project.dao;

import com.rc.project.vo.EpSetting;
import com.rc.project.vo.EpSettingExample;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EpSettingDAO extends SqlMapClientDaoSupport  {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_SETTING
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public EpSettingDAO() {
        super();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_SETTING
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public int countByExample(EpSettingExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EP_SETTING_countByExample", example);
        return count.intValue();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_SETTING
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public int deleteByExample(EpSettingExample example) {
        int rows = getSqlMapClientTemplate().delete("EP_SETTING_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_SETTING
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public int deleteByPrimaryKey(BigDecimal setNid) {
        EpSetting key = new EpSetting();
        key.setSetNid(setNid);
        int rows = getSqlMapClientTemplate().delete("EP_SETTING_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_SETTING
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public void insert(EpSetting record) {
        getSqlMapClientTemplate().insert("EP_SETTING_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_SETTING
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public void insertSelective(EpSetting record) {
        getSqlMapClientTemplate().insert("EP_SETTING_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_SETTING
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public List selectByExample(EpSettingExample example) {
        List list = getSqlMapClientTemplate().queryForList("EP_SETTING_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_SETTING
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public EpSetting selectByPrimaryKey(BigDecimal setNid) {
        EpSetting key = new EpSetting();
        key.setSetNid(setNid);
        EpSetting record = (EpSetting) getSqlMapClientTemplate().queryForObject("EP_SETTING_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_SETTING
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public int updateByExampleSelective(EpSetting record, EpSettingExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_SETTING_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_SETTING
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public int updateByExample(EpSetting record, EpSettingExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_SETTING_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_SETTING
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public int updateByPrimaryKeySelective(EpSetting record) {
        int rows = getSqlMapClientTemplate().update("EP_SETTING_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table EP_SETTING
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public int updateByPrimaryKey(EpSetting record) {
        int rows = getSqlMapClientTemplate().update("EP_SETTING_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table EP_SETTING
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    private static class UpdateByExampleParms extends EpSettingExample {
        private Object record;

        public UpdateByExampleParms(Object record, EpSettingExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}