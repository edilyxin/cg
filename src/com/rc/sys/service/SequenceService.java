package com.rc.sys.service;
import java.util.List;

import com.rc.sys.form.MngSequenceForm;
import com.rc.sys.vo.MngSequence;
import com.rc.sys.vo.MngTable;
public interface SequenceService {
	public List findPage1(MngTable form );
	public Integer findSize1(MngTable form);
	/**
	 * 查询结果数
	 */
	public Integer findSize(MngSequenceForm form);
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngSequenceForm form );
	
	
	
	/**
	 * 新增
	 * @param form
	 * @return
	 */
	public boolean save(MngSequenceForm form);
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngSequence findByID(String id);
	
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngSequenceForm form);

	/**
	 * 批量删除
	 * @param idchecked
	 * @return
	 */
	public boolean delete(String[] idchecked);
	
	/**
	 * 批量更新状态
	 * @param idchecked
	 * @return
	 */
	public boolean changeValid(String[] idchecked);
	/**
	 * 
	 *  @Description    : 读取当前编码
	 *  @Method_Name    : getNO
	 *  @param info_nid   系统编码
	 *  @param seq_stype  编码类型   0-主键；1-编码  2-代码  3-条码
	 *  @param seq_sname  编码名
	 *  @return 
	 *  @return         : String
	 *  @Creation Date  : 2013-4-13下午06:31:19 
	 *  @version        : v1.00
	 *  @Author         : 高科
	 */
	public String getNO(String info_nid , String seq_stype, String seq_sname);
	public boolean checkOnly(String seq_sname);
}
