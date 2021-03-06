package com.rc.project.dao;

import com.rc.project.form.EpPayMoneyForm;
import com.rc.project.vo.EpPayMoney;
import com.rc.project.vo.EpPaymoneyExample;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EpPayMoneyDAO extends SqlMapClientDaoSupport {

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PAYMONEY
     *
     * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
     */
    public EpPayMoneyDAO() {
        super();
    }
    
    public List getListByPackage(EpPayMoneyForm form){    	
    	return getSqlMapClientTemplate().queryForList("EP_PAYMONEY_selectByPackage", form);
    }
    
    /*
     * 根据应收应付方式获取应收应付记录
     * payType 0,应收;1应付
     */
    public List getListByPayType(String payType){
    	return getSqlMapClientTemplate().queryForList("EP_PAYMONEY_selectByPayType", payType);
    }



    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PAYMONEY
     *
     * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
     */
    public int deleteByPrimaryKey(BigDecimal PM_NID) {
        EpPayMoneyForm key = new EpPayMoneyForm();
        key.setPM_NID(PM_NID);
        int rows = getSqlMapClientTemplate().delete("EP_PAYMONEY_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PAYMONEY
     *
     * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
     */
    public boolean insert(EpPayMoneyForm record) {
        return getSqlMapClientTemplate().insert("EP_PAYMONEY_insert", record) == null ? false :true;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PAYMONEY
     *
     * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
     */
    public EpPayMoney selectByPrimaryKey(BigDecimal PM_NID) {
        EpPayMoneyForm key = new EpPayMoneyForm();
        key.setPM_NID(PM_NID);
        EpPayMoney record = (EpPayMoney) getSqlMapClientTemplate().queryForObject("EP_PAYMONEY_selectByPrimaryKey", key);
        return record;
    }



    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PAYMONEY
     *
     * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
     */
    public int updateByPrimaryKeySelective(EpPayMoneyForm record) {
        int rows = getSqlMapClientTemplate().update("EP_PAYMONEY_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PAYMONEY
     *
     * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
     */
    public int updateByPrimaryKey(EpPayMoneyForm record) {
        int rows = getSqlMapClientTemplate().update("EP_PAYMONEY_updateByPrimaryKey", record);
        return rows;
    }

}