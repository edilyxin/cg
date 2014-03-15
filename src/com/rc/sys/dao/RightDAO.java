package com.rc.sys.dao;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.sys.form.MngRightForm;
import com.rc.sys.vo.MngRight;

/**
 * 功能权限表数据库操作
 * @author GK
 *
 */
public class RightDAO extends SqlMapClientDaoSupport {
		
	/**
	 * 查询结果数
	 */
	public Integer findSize(MngRightForm form){
		return (Integer)getSqlMapClientTemplate().queryForObject("right_findSize",form);
	}
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngRightForm form ){
		return getSqlMapClientTemplate().queryForList("right_findPage", form);
	}
	

	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngRightForm form) {
		return getSqlMapClientTemplate().insert("right_add", form)==null?false:true;
		
	}
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngRight findByID(MngRightForm form){
		return (MngRight)getSqlMapClientTemplate().queryForObject("right_findByID", form);
	}
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngRightForm form) {
		int result = getSqlMapClientTemplate().update("right_update", form);
		return result == 0 ? false : true;
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 * @throws SQLException 
	 */
	public boolean delete(List<String> ids)  {
		boolean bl = false;
		SqlMapClient sqlMapClient = getSqlMapClientTemplate().getSqlMapClient();
		try{
			sqlMapClient.startTransaction(); 
			sqlMapClient.startBatch();
			if(ids!=null){
				for(int i=0;i<ids.size();i++){
					String str = ids.get(i);
					String[] arr = str.split(":");
					MngRightForm form = new MngRightForm();
					if (arr!=null) {
						form.setSysint_sno(arr[0]);
						form.setRight_sno(arr[1]);
					}
					sqlMapClient.update("right_delete", form);
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
	 * @param ids
	 * @return
	 */
	public boolean changeValid(List<String> ids){
		boolean bl = false;
		SqlMapClient sqlMapClient = getSqlMapClientTemplate().getSqlMapClient();
		try{
			sqlMapClient.startTransaction(); 
			sqlMapClient.startBatch();
			if(ids!=null){
				for(int i=0;i<ids.size();i++){
					String str = ids.get(i);
					String[] arr = str.split(":");
					MngRightForm form = new MngRightForm();
					if (arr!=null) {
						form.setSysint_sno(arr[0]);
						form.setRight_sno(arr[1]);
					}
					sqlMapClient.update("right_changeValid", form);
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
	 * 查询系统信息
	 * @return
	 */
	public List findSysIntList() {
		return getSqlMapClientTemplate().queryForList("right_findSysIntList");
	}
	
	/**
	 * 查询功能级别
	 * @return
	 */
	public List findRightNumList(String sysint_sno) {
		return getSqlMapClientTemplate().queryForList("right_findRightNumList", sysint_sno);
	}
	
	/**
	 * 根据功能级别，查询上级功能列表
	 * @param form
	 * @return
	 */
	public List findSparentList(MngRightForm form) {
		return getSqlMapClientTemplate().queryForList("right_findSparentList", form);
	}
	
	/**
	 * 根据上级功能编号查询子功能数
	 * @param right_sparentno
	 * @return
	 */
	public int findSubSize(MngRightForm form) {
		return (Integer) getSqlMapClientTemplate().queryForObject("right_findSubSize", form);
	}
	
	/**
	 * 查询子功能数最大的排序值
	 * @param form
	 * @return
	 */
	public Integer findMaxOrdval(MngRightForm form) {
		return (Integer) getSqlMapClientTemplate().queryForObject("right_findMaxOrdval", form);
	}
	
	/**
	 * 根据功能编号作物理删除
	 * @param right_sno
	 */
	public void delByRightNO(String right_sno) {
		getSqlMapClientTemplate().delete("right_delByRightNO", right_sno);
	}
	
	/**
	 * 查询某个系统功能级别为1级的菜单
	 * @param sysint_sno
	 * @return 
	 */
	public List findMenu(String sysint_sno) {
		return getSqlMapClientTemplate().queryForList("right_findMenu", sysint_sno);
	}
	
	/**
	 * 查询1级菜单最大的排序值
	 * @return
	 */
	public Integer findMaxMenuOrdval(MngRightForm form) {
		return (Integer) getSqlMapClientTemplate().queryForObject("right_findMaxMenuOrdval", form);
	}
	
	/**
	 * 查询功能排序列表
	 * @param form
	 * @return
	 */
	public List findSubList(MngRightForm form) {
		return getSqlMapClientTemplate().queryForList("right_findSubList", form);
	}
	
	/**
	 * 保存排序值
	 * @param orderVals
	 * @param alertBy 
	 * @return
	 * @throws SQLException 
	 */
	public boolean saveOrderValue(String[] orderVals, String alertBy) throws SQLException {
		SqlMapClient sqlMapClient = getSqlMapClient();
		try {
			sqlMapClient.startTransaction();
			sqlMapClient.startBatch();
			int count = 0;
			for (int i = 0; i < orderVals.length; i++) {
				if ("".equals(orderVals[i])) {
					continue;
				}
				String[] tmp = orderVals[i].split(":");
				System.out.println(Arrays.toString(tmp));
				MngRightForm form = new MngRightForm();
				form.setRight_sno(tmp[0]);
				form.setRight_norder(Long.parseLong(tmp[1]));
				form.setRight_salterby(alertBy);
				sqlMapClient.update("right_saveOrderValue", form);
				count++;
				if (count == 250) {
					sqlMapClient.executeBatch();
					sqlMapClient.startBatch();
					count = 0;
				}
			}
			sqlMapClient.commitTransaction();
			return true;
		} catch (SQLException e) {
			sqlMapClient.getCurrentConnection().rollback();
			e.printStackTrace();
			return false;
		} finally {
			sqlMapClient.endTransaction();
		}
	}
	
	/**
	 * 判断某个功能是否有子功能
	 * @param form
	 * @return
	 */
	public boolean hasSub(MngRightForm form) {
		Integer n = (Integer) getSqlMapClientTemplate().queryForObject("right_hasSub", form);
		boolean b = true;
		if (n <= 0) {
			b = false;
		}
		return b;
	}
	
	/**
	 * 判断该功能是否有有效的操作
	 * @param form
	 * @return
	 */
	public boolean hasOper(MngRightForm form) {
		Integer n = (Integer) getSqlMapClientTemplate().queryForObject("right_hasOper", form);
		boolean b = true;
		if (n <= 0) {
			b = false;
		}
		return b;
	}
	
	/**
	 * 查询该功能对应的角色是否有效
	 * @param form
	 * @return
	 */
	public boolean isRoleRightValid(MngRightForm form) {
		Integer count = (Integer) getSqlMapClientTemplate().queryForObject("right_isRoleRightValid", form);
		boolean b = true;
		if (count == 0) {
			b = false;
		}
		return b;
	}
	
	/**
	 * 检查同一系统同一上级下功能名称是否唯一
	 * @param form
	 * @return
	 */
	public boolean isRightnameValid(MngRightForm form) {
		Integer size = (Integer) getSqlMapClientTemplate().queryForObject("right_isRightnameValid", form);
		boolean isOK = true;
		if (size > 0) {
			isOK = false;
		}
		return isOK;
	}

	public MngRight findByID2(MngRightForm form) {
		return (MngRight) getSqlMapClientTemplate().queryForObject("right_findByID2", form);
	}
}

