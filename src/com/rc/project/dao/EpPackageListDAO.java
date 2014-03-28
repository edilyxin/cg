package com.rc.project.dao;

import com.rc.project.vo.EpPackageList;
import com.rc.project.vo.EpPackageListExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EpPackageListDAO extends SqlMapClientDaoSupport {

   

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PACKAGELIST
     *
     * @ibatorgenerated Wed Mar 19 11:02:48 CST 2014
     */
    public int countByExample(EpPackageListExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EP_PACKAGELIST_countByExample", example);
        return count.intValue();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PACKAGELIST
     *
     * @ibatorgenerated Wed Mar 19 11:02:48 CST 2014
     */
    public int deleteByExample(EpPackageListExample example) {
        int rows = getSqlMapClientTemplate().delete("EP_PACKAGELIST_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PACKAGELIST
     *
     * @ibatorgenerated Wed Mar 19 11:02:48 CST 2014
     */
    public int deleteByPrimaryKey(String EP_SNO) {
        EpPackageList key = new EpPackageList();
        key.setEP_SNO(EP_SNO);
        int rows = getSqlMapClientTemplate().delete("EP_PACKAGELIST_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PACKAGELIST
     *
     * @ibatorgenerated Wed Mar 19 11:02:48 CST 2014
     */
    public void insert(EpPackageList record) {
        getSqlMapClientTemplate().insert("EP_PACKAGELIST_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PACKAGELIST
     *
     * @ibatorgenerated Wed Mar 19 11:02:48 CST 2014
     */
    public void insertSelective(EpPackageList record) {
        getSqlMapClientTemplate().insert("EP_PACKAGELIST_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PACKAGELIST
     *
     * @ibatorgenerated Wed Mar 19 11:02:48 CST 2014
     */
    public List selectByExample(EpPackageListExample example) {
        List list = getSqlMapClientTemplate().queryForList("EP_PACKAGELIST_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PACKAGELIST
     *
     * @ibatorgenerated Wed Mar 19 11:02:48 CST 2014
     */
    public EpPackageList selectByPrimaryKey(String EP_SNO) {
        EpPackageList key = new EpPackageList();
        key.setEP_SNO(EP_SNO);
        EpPackageList record = (EpPackageList) getSqlMapClientTemplate().queryForObject("EP_PACKAGELIST_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PACKAGELIST
     *
     * @ibatorgenerated Wed Mar 19 11:02:48 CST 2014
     */
    public int updateByExampleSelective(EpPackageList record, EpPackageListExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_PACKAGELIST_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PACKAGELIST
     *
     * @ibatorgenerated Wed Mar 19 11:02:48 CST 2014
     */
    public int updateByExample(EpPackageList record, EpPackageListExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_PACKAGELIST_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PACKAGELIST
     *
     * @ibatorgenerated Wed Mar 19 11:02:48 CST 2014
     */
    public int updateByPrimaryKeySelective(EpPackageList record) {
        int rows = getSqlMapClientTemplate().update("EP_PACKAGELIST_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PACKAGELIST
     *
     * @ibatorgenerated Wed Mar 19 11:02:48 CST 2014
     */
    public int updateByPrimaryKey(EpPackageList record) {
        int rows = getSqlMapClientTemplate().update("EP_PACKAGELIST_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table CG.EP_PACKAGELIST
     *
     * @ibatorgenerated Wed Mar 19 11:02:48 CST 2014
     */
    private static class UpdateByExampleParms extends EpPackageListExample {
        private Object record;

        public UpdateByExampleParms(Object record, EpPackageListExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}