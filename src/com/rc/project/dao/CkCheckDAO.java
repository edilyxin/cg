package com.rc.project.dao;

import com.rc.project.vo.CkCheck;
import com.rc.project.vo.CkCheckExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class CkCheckDAO extends SqlMapClientDaoSupport {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table CK_CHECK
	 * @ibatorgenerated  Thu Mar 13 14:30:59 CST 2014
	 */
	public CkCheckDAO() {
		super();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table CK_CHECK
	 * @ibatorgenerated  Thu Mar 13 14:30:59 CST 2014
	 */
	public int countByExample(CkCheckExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
				"CK_CHECK_countByExample", example);
		return count.intValue();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table CK_CHECK
	 * @ibatorgenerated  Thu Mar 13 14:30:59 CST 2014
	 */
	public int deleteByExample(CkCheckExample example) {
		int rows = getSqlMapClientTemplate().delete(
				"CK_CHECK_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table CK_CHECK
	 * @ibatorgenerated  Thu Mar 13 14:30:59 CST 2014
	 */
	public int deleteByPrimaryKey(String CK_SID) {
		CkCheck key = new CkCheck();
		key.setCkSid(CK_SID);
		int rows = getSqlMapClientTemplate().delete(
				"CK_CHECK_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table CK_CHECK
	 * @ibatorgenerated  Thu Mar 13 14:30:59 CST 2014
	 */
	public void insert(CkCheck record) {
		getSqlMapClientTemplate().insert("CK_CHECK_insert",	record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table CK_CHECK
	 * @ibatorgenerated  Thu Mar 13 14:30:59 CST 2014
	 */
	public void insertSelective(CkCheck record) {
		getSqlMapClientTemplate().insert(
				"CK_CHECK_insertSelective", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table CK_CHECK
	 * @ibatorgenerated  Thu Mar 13 14:30:59 CST 2014
	 */
	public List selectByExample(CkCheckExample example) {
		List list = getSqlMapClientTemplate().queryForList(
				"CK_CHECK_selectByExample", example);
		return list;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table CK_CHECK
	 * @ibatorgenerated  Thu Mar 13 14:30:59 CST 2014
	 */
	public CkCheck selectByPrimaryKey(String CK_SID) {
		CkCheck key = new CkCheck();
		key.setCkSid(CK_SID);
		CkCheck record = (CkCheck) getSqlMapClientTemplate().queryForObject(
				"CK_CHECK_selectByPrimaryKey", key);
		return record;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table CK_CHECK
	 * @ibatorgenerated  Thu Mar 13 14:30:59 CST 2014
	 */
	public int updateByExampleSelective(CkCheck record, CkCheckExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"CK_CHECK_updateByExampleSelective", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table CK_CHECK
	 * @ibatorgenerated  Thu Mar 13 14:30:59 CST 2014
	 */
	public int updateByExample(CkCheck record, CkCheckExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"CK_CHECK_updateByExample", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table CK_CHECK
	 * @ibatorgenerated  Thu Mar 13 14:30:59 CST 2014
	 */
	public int updateByPrimaryKeySelective(CkCheck record) {
		int rows = getSqlMapClientTemplate().update(
				"CK_CHECK_updateByPrimaryKeySelective", record);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table CK_CHECK
	 * @ibatorgenerated  Thu Mar 13 14:30:59 CST 2014
	 */
	public int updateByPrimaryKey(CkCheck record) {
		int rows = getSqlMapClientTemplate().update(
				"CK_CHECK_updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table CK_CHECK
	 * @ibatorgenerated  Thu Mar 13 14:30:59 CST 2014
	 */
	private static class UpdateByExampleParms extends CkCheckExample {
		private Object record;

		public UpdateByExampleParms(Object record, CkCheckExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}