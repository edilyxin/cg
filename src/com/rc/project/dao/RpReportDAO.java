package com.rc.project.dao;

import com.rc.project.vo.RpReport;
import com.rc.project.vo.RpReportExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class RpReportDAO extends SqlMapClientDaoSupport {

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table RP_REPORT
	 * @ibatorgenerated  Wed Mar 12 15:11:45 CST 2014
	 */
	public RpReportDAO() {
		super();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table RP_REPORT
	 * @ibatorgenerated  Wed Mar 12 15:11:45 CST 2014
	 */
	public int countByExample(RpReportExample example) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject(
				"RP_REPORT_countByExample", example);
		return count.intValue();
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table RP_REPORT
	 * @ibatorgenerated  Wed Mar 12 15:11:45 CST 2014
	 */
	public int deleteByExample(RpReportExample example) {
		int rows = getSqlMapClientTemplate().delete(
				"RP_REPORT_deleteByExample", example);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table RP_REPORT
	 * @ibatorgenerated  Wed Mar 12 15:11:45 CST 2014
	 */
	public int deleteByPrimaryKey(String rpSno) {
		RpReport key = new RpReport();
		key.setRpSno(rpSno);
		int rows = getSqlMapClientTemplate().delete(
				"RP_REPORT_deleteByPrimaryKey", key);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table RP_REPORT
	 * @ibatorgenerated  Wed Mar 12 15:11:45 CST 2014
	 */
	public void insert(RpReport record) {
		getSqlMapClientTemplate().insert("RP_REPORT_insert",
				record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table RP_REPORT
	 * @ibatorgenerated  Wed Mar 12 15:11:45 CST 2014
	 */
	public void insertSelective(RpReport record) {
		getSqlMapClientTemplate().insert(
				"RP_REPORT_insertSelective", record);
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table RP_REPORT
	 * @ibatorgenerated  Wed Mar 12 15:11:45 CST 2014
	 */
	public List selectByExample(RpReportExample example) {
		List list = getSqlMapClientTemplate().queryForList(
				"RP_REPORT_selectByExample", example);
		return list;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table RP_REPORT
	 * @ibatorgenerated  Wed Mar 12 15:11:45 CST 2014
	 */
	public RpReport selectByPrimaryKey(String rpSno) {
		RpReport key = new RpReport();
		key.setRpSno(rpSno);
		RpReport record = (RpReport) getSqlMapClientTemplate().queryForObject(
				"RP_REPORT_selectByPrimaryKey", key);
		return record;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table RP_REPORT
	 * @ibatorgenerated  Wed Mar 12 15:11:45 CST 2014
	 */
	public int updateByExampleSelective(RpReport record, RpReportExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"RP_REPORT_updateByExampleSelective", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table RP_REPORT
	 * @ibatorgenerated  Wed Mar 12 15:11:45 CST 2014
	 */
	public int updateByExample(RpReport record, RpReportExample example) {
		UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
		int rows = getSqlMapClientTemplate().update(
				"RP_REPORT_updateByExample", parms);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table RP_REPORT
	 * @ibatorgenerated  Wed Mar 12 15:11:45 CST 2014
	 */
	public int updateByPrimaryKeySelective(RpReport record) {
		int rows = getSqlMapClientTemplate()
				.update("RP_REPORT_updateByPrimaryKeySelective",
						record);
		return rows;
	}

	/**
	 * This method was generated by Apache iBATIS ibator. This method corresponds to the database table RP_REPORT
	 * @ibatorgenerated  Wed Mar 12 15:11:45 CST 2014
	 */
	public int updateByPrimaryKey(RpReport record) {
		int rows = getSqlMapClientTemplate().update(
				"RP_REPORT_updateByPrimaryKey", record);
		return rows;
	}

	/**
	 * This class was generated by Apache iBATIS ibator. This class corresponds to the database table RP_REPORT
	 * @ibatorgenerated  Wed Mar 12 15:11:45 CST 2014
	 */
	private static class UpdateByExampleParms extends RpReportExample {
		private Object record;

		public UpdateByExampleParms(Object record, RpReportExample example) {
			super(example);
			this.record = record;
		}

		public Object getRecord() {
			return record;
		}
	}
}