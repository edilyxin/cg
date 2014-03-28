package com.rc.project.dao;

import com.rc.project.form.EpPackageForm;
import com.rc.project.form.EpProcessForm;
import com.rc.project.form.EpProjectDetailForm;
import com.rc.project.form.EpSettingForm;
import com.rc.project.vo.EpPackage;
import com.rc.project.vo.EpPackageExample;
import com.rc.project.vo.EpProcess;
import com.rc.project.vo.EpSetting;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EpPackageDAO extends SqlMapClientDaoSupport {
	
	public List findEpsNo(){
		return getSqlMapClientTemplate().queryForList("EP_PACKAGE_findprojectnofrompackage");
	}
	
	public List findProject(List ids){
		String id="";
		if(ids.size() ==0)return null;
		for (int i = 0; i < ids.size(); i++) {
			id += "'" + ids.get(i) +"'" +",";
//			id +=ids.get(i)+",";
		}
		System.out.println(id);
		id = id.substring(0, id.length()-1);
		System.out.println(id);
		List list = getSqlMapClientTemplate().queryForList("EP_PROJECT_findproject",id);
		System.out.println(list.size());
		return list;
	}
	
	public List findPackage(String epsno){
		return getSqlMapClientTemplate().queryForList("EP_PACKAGE_findpackage",epsno);
	}
	
	public EpProcess findProcess(EpProcessForm form){
		return (EpProcess)getSqlMapClientTemplate().queryForObject("EP_PROCESS_findprocess", form);
	}
	
	public EpSetting findSetting(int setId){
		return (EpSetting)getSqlMapClientTemplate().queryForObject("EP_PROCESS_SETTING_findsetting", setId);
	}
   
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PACKAGE
     *
     * @ibatorgenerated Wed Mar 19 11:02:48 CST 2014
     */
    public int countByExample(EpPackageExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("EP_PACKAGE_countByExample", example);
        return count.intValue();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PACKAGE
     *
     * @ibatorgenerated Wed Mar 19 11:02:48 CST 2014
     */
    public int deleteByExample(EpPackageExample example) {
        int rows = getSqlMapClientTemplate().delete("EP_PACKAGE_deleteByExample", example);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PACKAGE
     *
     * @ibatorgenerated Wed Mar 19 11:02:48 CST 2014
     */
    public int deleteByPrimaryKey(String BG_SNO) {
        EpPackage key = new EpPackage();
        key.setBG_SNO(BG_SNO);
        int rows = getSqlMapClientTemplate().delete("EP_PACKAGE_deleteByPrimaryKey", key);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PACKAGE
     *
     * @ibatorgenerated Wed Mar 19 11:02:48 CST 2014
     */
    public void insert(EpPackage record) {
        getSqlMapClientTemplate().insert("EP_PACKAGE_insert", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PACKAGE
     *
     * @ibatorgenerated Wed Mar 19 11:02:48 CST 2014
     */
    public void insertSelective(EpPackage record) {
        getSqlMapClientTemplate().insert("EP_PACKAGE_insertSelective", record);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PACKAGE
     *
     * @ibatorgenerated Wed Mar 19 11:02:48 CST 2014
     */
    public List selectByExample(EpPackageExample example) {
        List list = getSqlMapClientTemplate().queryForList("EP_PACKAGE_selectByExample", example);
        return list;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PACKAGE
     *
     * @ibatorgenerated Wed Mar 19 11:02:48 CST 2014
     */
    public EpPackage selectByPrimaryKey(String BG_SNO) {
        EpPackage key = new EpPackage();
        key.setBG_SNO(BG_SNO);
        EpPackage record = (EpPackage) getSqlMapClientTemplate().queryForObject("EP_PACKAGE_selectByPrimaryKey", key);
        return record;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PACKAGE
     *
     * @ibatorgenerated Wed Mar 19 11:02:48 CST 2014
     */
    public int updateByExampleSelective(EpPackage record, EpPackageExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_PACKAGE_updateByExampleSelective", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PACKAGE
     *
     * @ibatorgenerated Wed Mar 19 11:02:48 CST 2014
     */
    public int updateByExample(EpPackage record, EpPackageExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("EP_PACKAGE_updateByExample", parms);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PACKAGE
     *
     * @ibatorgenerated Wed Mar 19 11:02:48 CST 2014
     */
    public int updateByPrimaryKeySelective(EpPackage record) {
        int rows = getSqlMapClientTemplate().update("EP_PACKAGE_updateByPrimaryKeySelective", record);
        return rows;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table CG.EP_PACKAGE
     *
     * @ibatorgenerated Wed Mar 19 11:02:48 CST 2014
     */
    public int updateByPrimaryKey(EpPackage record) {
        int rows = getSqlMapClientTemplate().update("EP_PACKAGE_updateByPrimaryKey", record);
        return rows;
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table CG.EP_PACKAGE
     *
     * @ibatorgenerated Wed Mar 19 11:02:48 CST 2014
     */
    private static class UpdateByExampleParms extends EpPackageExample {
        private Object record;

        public UpdateByExampleParms(Object record, EpPackageExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}