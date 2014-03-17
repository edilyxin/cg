package com.rc.project.dao;

import com.rc.project.form.EpPackageForm;
import com.rc.project.vo.EpPackage;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EpPackageDAO extends SqlMapClientDaoSupport {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PACKAGE
     *
     * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
     */
    public EpPackageDAO() {
        super();
    }


    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PACKAGE
     *
     * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
     */
    public int deleteByPrimaryKey(String BG_SNO) {
        EpPackageForm key = new EpPackageForm();
        key.setBG_SNO(BG_SNO);
        int rows = getSqlMapClientTemplate().delete("EP_PACKAGE_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PACKAGE
     *
     * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
     */
    public void insert(EpPackageForm record) {
        getSqlMapClientTemplate().insert("EP_PACKAGE_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PACKAGE
     *
     * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
     */
    public void insertSelective(EpPackageForm record) {
        getSqlMapClientTemplate().insert("EP_PACKAGE_insertSelective", record);
    }


    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PACKAGE
     *
     * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
     */
    public EpPackage selectByPrimaryKey(String BG_SNO) {
        EpPackageForm key = new EpPackageForm();
        key.setBG_SNO(BG_SNO);
        EpPackage record = (EpPackage) getSqlMapClientTemplate().queryForObject("EP_PACKAGE_selectByPrimaryKey", key);
        return record;
    }



    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PACKAGE
     *
     * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
     */
    public int updateByPrimaryKeySelective(EpPackageForm record) {
        int rows = getSqlMapClientTemplate().update("EP_PACKAGE_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PACKAGE
     *
     * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
     */
    public int updateByPrimaryKey(EpPackageForm record) {
        int rows = getSqlMapClientTemplate().update("EP_PACKAGE_updateByPrimaryKey", record);
        return rows;
    }

}