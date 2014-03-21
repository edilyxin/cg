package com.rc.base.dao;
import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.base.form.MngSchoolDepartForm;
import com.rc.base.form.MngUnitDepartForm;
import com.rc.base.vo.MngSchoolDepart;
import com.rc.base.vo.MngUnitDepart;

/**
 * 单位部门表数据库操作
 * @author GK
 *
 */
public class UnitDepartDAO extends SqlMapClientDaoSupport {
		
	/**
	 * 查询结果数
	 */
	public Integer findSize(MngUnitDepartForm form){
		return (Integer)getSqlMapClientTemplate().queryForObject("unitDepart_findSize",form);
	}
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngUnitDepartForm form ){
		return getSqlMapClientTemplate().queryForList("unitDepart_findPage", form);
	}
	

	/**
	 * 新增
	 * @param form
	 * @return
	 * @throws SQLException 
	 */
	public boolean save(MngUnitDepartForm form) throws SQLException {
		SqlMapClient sqlMapClient = getSqlMapClient();
		try {
			sqlMapClient.startTransaction();
			sqlMapClient.startBatch();
			MngSchoolDepartForm fm = new MngSchoolDepartForm();
			fm.setUd_sno(form.getUd_stopno());
			List list = sqlMapClient.queryForList("unitDepart_findByUDForObj", fm);
			if (list.size() == 1) {
				MngSchoolDepart msd = (MngSchoolDepart) list.get(0);
				MngSchoolDepartForm frm = new MngSchoolDepartForm();
				frm.setSh_sno(msd.getSh_sno());
				frm.setUd_sno(form.getUd_sno());
				frm.setSud_stype(msd.getSud_stype());
				sqlMapClient.delete("unitDepart_delSD", frm);
				sqlMapClient.insert("unitDepart_saveSchool", frm);
			}
			Object obj = sqlMapClient.insert("unitDepart_add", form);
			sqlMapClient.executeBatch();
			sqlMapClient.commitTransaction();
			return (obj == null) ? false : true;
		} catch (SQLException e) {
			sqlMapClient.getCurrentConnection().rollback();
			e.printStackTrace();
			return false;
		} finally {
			sqlMapClient.endTransaction();
		}
		
	}
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngUnitDepart findByID(String id){
		return (MngUnitDepart)getSqlMapClientTemplate().queryForObject("unitDepart_findByID", id);
	}
	
	/**
	 * 修改
	 * @param form
	 * @return
	 * @throws SQLException 
	 */
	public boolean update(MngUnitDepartForm form) throws SQLException {
		SqlMapClient sqlMapClient = getSqlMapClient();
		try {
			sqlMapClient.startTransaction();
			sqlMapClient.startBatch();
			MngSchoolDepartForm fm = new MngSchoolDepartForm();
			fm.setUd_sno(form.getUd_stopno());
			List list = sqlMapClient.queryForList("unitDepart_findByUDForObj", fm);
			if (list.size() == 1) {
				MngSchoolDepart msd = (MngSchoolDepart) list.get(0);
				MngSchoolDepartForm frm = new MngSchoolDepartForm();
				frm.setSh_sno(msd.getSh_sno());
				frm.setUd_sno(form.getUd_sno());
				frm.setSud_stype(msd.getSud_stype());
				sqlMapClient.delete("unitDepart_delSD", frm);
				sqlMapClient.insert("unitDepart_saveSchool", frm);
			}
			int num = sqlMapClient.update("unitDepart_update", form);
			sqlMapClient.executeBatch();
			sqlMapClient.commitTransaction();
			return (num == 0) ?  true:false;
		} catch (SQLException e) {
			sqlMapClient.getCurrentConnection().rollback();
			e.printStackTrace();
			return false;
		} finally {
			sqlMapClient.endTransaction();
		}
	}
	
	/**
	 * 批量删除
	 * @param idchecked
	 * @return
	 */
	public boolean delete(String[] idchecked){
		boolean bl = false;
		SqlMapClient sqlMapClient = getSqlMapClientTemplate().getSqlMapClient();
		try{
			sqlMapClient.startTransaction(); 
			sqlMapClient.startBatch();
			if(idchecked!=null){
				for(int i=0;i<idchecked.length;i++){
				sqlMapClient.update("unitDepart_delete", idchecked[i]);
				}
			}
			sqlMapClient.executeBatch();
			sqlMapClient.commitTransaction();
			 bl = true;
		}catch(Exception e){
			try {
				sqlMapClient.getCurrentConnection().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
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
	 * @param idchecked
	 * @return
	 */
	public boolean changeValid(String[] idchecked){
		boolean bl = false;
		SqlMapClient sqlMapClient = getSqlMapClientTemplate().getSqlMapClient();
		try{
			sqlMapClient.startTransaction(); 
			sqlMapClient.startBatch();
			if(idchecked!=null){
				for(int i=0;i<idchecked.length;i++){
					sqlMapClient.update("unitDepart_changeValid", idchecked[i]);
				}
			}
			sqlMapClient.executeBatch();
			sqlMapClient.commitTransaction();
			 bl = true;
		}catch(Exception e){
			try {
				sqlMapClient.getCurrentConnection().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
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
	 * 查询单位部门信息
	 * @return
	 */
	public List findAll() {
		return getSqlMapClientTemplate().queryForList("unitDepart_findAll");
	}
	
	/**
	 * 检查同一上级单位下，单位名称是否唯一
	 * @param form
	 * @return
	 */
	public boolean checkUni(MngUnitDepartForm form) {
		int size = (Integer) getSqlMapClientTemplate().queryForObject("unitDepart_findByName", form);
		boolean isOK = true;
		if (size > 0) {
			isOK = false;
		}
		return isOK;
	}
	
	/**
	 * 查询单位部门菜单树列表
	 * @return
	 */
	public List findTreeList() {
		return getSqlMapClientTemplate().queryForList("unitDepart_findTreeList");
	}
	
	/**
	 * 根据单位层次查询可用隶属单位列表
	 * @param ud_nnumber
	 * @return
	 */
	public List findTopList(Long ud_nnumber) {
		return getSqlMapClientTemplate().queryForList("unitDepart_findTopList", ud_nnumber);
	}
	
	/**
	 * 保存单位校区对照信息
	 * @param sdForm 单位编号
	 * @param arrSchoolNO 校区编号集合
	 */
	public void saveSchool(MngSchoolDepartForm sdForm, String[] arrSchoolNO) {
			SqlMapClient sqlMapClient = getSqlMapClient();
			try {
				sqlMapClient.startTransaction();
				sqlMapClient.startBatch();
				if (arrSchoolNO != null) {
					//根据单位编号删除单位校区信息，以防主键冲突
					sqlMapClient.delete("unitDepart_delSD", sdForm);
					for (int i = 0; i < arrSchoolNO.length; i++) {
						String tmp = arrSchoolNO[i];
						String sh_sno = tmp.split(":")[0];
						String sh_stype = tmp.split(":")[1];
						MngSchoolDepartForm frm = new MngSchoolDepartForm();
						frm.setUd_sno(sdForm.getUd_sno());
						frm.setSh_sno(sh_sno);
						frm.setSud_stype(sh_stype);
						sqlMapClient.insert("unitDepart_saveSchool", frm);
					}
				} else {
					//取消已设置的校区
					sqlMapClient.delete("unitDepart_delSD", sdForm);
				}
				sqlMapClient.executeBatch();
				sqlMapClient.commitTransaction();
			} catch (SQLException e) {
				try {
					sqlMapClient.getCurrentConnection().rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
			
	}
	
	/**
	 * 根据单位编号查询所对应校区
	 * @param sdForm
	 * @return
	 */
	public List findByUDNo(MngSchoolDepartForm sdForm) {
		return getSqlMapClientTemplate().queryForList("unitDepart_findByUDNo", sdForm);
	}
	
	/**
	 * 获取指定编码、指定级别的记录条数
	 * @param level
	 * @param no
	 * @return
	 */
	public Integer findByLevel(int level, String no) {
		MngUnitDepartForm form = new MngUnitDepartForm();
		form.setUd_nnumber(Integer.valueOf(level).longValue());
		form.setUd_stopno(no);
		return (Integer) getSqlMapClientTemplate().queryForObject("unitDepart_findByLevel", form);
	}
	
	/**
	 * 查询是否有单位层次为学校的记录
	 * @param ud_nnumber
	 * @return
	 */
	public boolean canAddSchool() {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("unitDepart_canAddSchool");
		boolean bl = false;
		if (count > 0) {
			bl = true;
		}
		return bl;
	}
	
	/**
	 * 根据部门编号判断该部门是否有下级
	 * @param no
	 * @return true有下级，false没下级
	 */
	public boolean hasSub(String no) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("unitDepart_hasSub", no);
		boolean bl = false;
		if (count > 0) {
			bl = true;
		}
		return bl;
	}
	
	/**
	 * 根据部门简称来得到部门信息
	 * @param ssname
	 * @return
	 */
	public List findBySSname(String ssname){
		return  getSqlMapClientTemplate().queryForList("unitDepart_findBySSname", ssname);
	}
}

