package com.rc.project.dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.project.form.EpSettingForm;
import com.rc.project.vo.EpSetting;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class EpSettingDAO extends SqlMapClientDaoSupport {

	/**
	 * This method was generated by Apache iBATIS ibator. This method
	 * corresponds to the database table CG.EP_SETTING
	 * 
	 * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
	 */
	public EpSettingDAO() {
		super();
	}

	public List findPage(EpSettingForm form) {
		return getSqlMapClientTemplate().queryForList("set_findPage", form);
	}

	public int findSize(EpSettingForm form) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"set_findSize", form);
	}
	
	public EpSetting findNextsetId(EpSettingForm form){
		return (EpSetting)getSqlMapClientTemplate().queryForObject("EP_SETTING_findnextsetid", form);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method
	 * corresponds to the database table CG.EP_SETTING
	 * 
	 * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
	 */
	public int deleteByPrimaryKey(int SET_NID) {
		EpSettingForm key = new EpSettingForm();
		key.setSET_NID(SET_NID);
		int rows = getSqlMapClientTemplate().delete(
				"EP_SETTING_deleteByPrimaryKey", key);
		return rows;
	}
	
	public EpSetting selectFirstStep(String SET_SPURTYPE) {
        EpSettingForm key = new EpSettingForm();
        key.setSET_SPURTYPE(SET_SPURTYPE);
        EpSetting record = (EpSetting) getSqlMapClientTemplate().queryForObject("EP_SETTING_selectFirstStep", key);
        return record;
    }

	/**
	 * This method was generated by Apache iBATIS ibator. This method
	 * corresponds to the database table CG.EP_SETTING
	 * 
	 * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
	 */
	public boolean insert(EpSettingForm record) {
		int maxId = getSqlMapClientTemplate().queryForObject(
				"set_select_maxid") == null ? 0
				: (Integer) getSqlMapClientTemplate().queryForObject(
						"set_select_maxid");
		if (maxId == 0) {
			record.setSET_NID(0);
		} else {
			record.setSET_NID(maxId);
		}
		return getSqlMapClientTemplate().insert("EP_SETTING_insert", record) == null ? false
				: true;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method
	 * corresponds to the database table CG.EP_SETTING
	 * 
	 * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
	 */
	public EpSetting selectByPrimaryKey(String SET_NID) {

		EpSetting record = (EpSetting) getSqlMapClientTemplate()
				.queryForObject("set_findByID", SET_NID);
		return record;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method
	 * corresponds to the database table CG.EP_SETTING
	 * 
	 * @ibatorgenerated Mon Mar 17 15:29:33 CST 2014
	 */
	public boolean updateByPrimaryKey(EpSettingForm record) {
		int rows = getSqlMapClientTemplate().update(
				"EP_SETTING_updateByPrimaryKeySelective", record);
		return rows == 0 ? false : true;
	}

	public boolean delte(String[] idchecked) {
		boolean bl = false;
		SqlMapClient sqlMapClient = getSqlMapClientTemplate().getSqlMapClient();
		try {
			sqlMapClient.startTransaction();
			sqlMapClient.startBatch();
			if (idchecked != null) {
				for (int i = 0; i < idchecked.length; i++) {
					sqlMapClient.update("set_delete", idchecked[i]);
				}
			}
			sqlMapClient.executeBatch();
			sqlMapClient.commitTransaction();
			bl = true;
		} catch (Exception e) {
			try {
				sqlMapClient.getCurrentConnection().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				sqlMapClient.endTransaction();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bl;
	}

	/**
	 * 批量更新状态
	 * 
	 * @param idchecked
	 * @return
	 */
	public boolean changeValid(String[] idchecked) {
		boolean bl = false;
		SqlMapClient sqlMapClient = getSqlMapClientTemplate().getSqlMapClient();
		try {
			sqlMapClient.startTransaction();
			sqlMapClient.startBatch();
			if (idchecked != null) {
				for (int i = 0; i < idchecked.length; i++) {
					sqlMapClient.update("set_changeValid", idchecked[i]);
				}
			}
			sqlMapClient.executeBatch();
			sqlMapClient.commitTransaction();
			bl = true;
		} catch (Exception e) {
			try {
				sqlMapClient.getCurrentConnection().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				sqlMapClient.endTransaction();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bl;
	}

}