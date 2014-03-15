package com.rc.sys.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.rc.sys.dao.SequenceDAO;
import com.rc.sys.form.MngSequenceForm;
import com.rc.sys.service.SequenceService;
import com.rc.sys.vo.MngSequence;
import com.rc.sys.vo.MngTable;


public class SequenceServiceImpl implements SequenceService {
  
	private SequenceDAO sequenceDAO;

	public void setSequenceDAO(SequenceDAO sequenceDAO) {
		this.sequenceDAO = sequenceDAO;
	}
	
	/**
	 * 查询结果数
	 */
	public Integer findSize(MngSequenceForm form){
		return sequenceDAO.findSize(form);
	}
	
	/**
	 * 查询结果分页
	 */
	public List findPage(MngSequenceForm form ){
		return sequenceDAO.findPage(form);
	}
	
	
	/**
	 * 新增
	 * seq_nstep
seq_ntype
seq_nyear
seq_nmonth
seq_nday
seq_sdescSEQ_NLENGTH

	 * @param form
	 * @return
	 */
	public boolean save(MngSequenceForm seq){
		//生成新显示值
		String curvalue = "";//显示值
		String prefix = seq.getSeq_sprefix()==null?"":seq.getSeq_sprefix();//前缀
		String suffix = seq.getSeq_ssuffix()==null?"":seq.getSeq_ssuffix() ;//后缀
		String year = seq.getSeq_nyear()==null?"":seq.getSeq_nyear() ;//年
		String month = seq.getSeq_nmonth()==null?"":seq.getSeq_nmonth() ;//月
		String day = seq.getSeq_nday()==null?"":seq.getSeq_nday() ;//日
		Long  length = seq.getSeq_nlength()==null?0:Long.parseLong(seq.getSeq_nlength()) ;	//流水长度
		String newValue = (String) (seq.getSeq_nvalue()==null?0:seq.getSeq_nvalue());//流水号
		//取当前日期
		SimpleDateFormat sfd= new  SimpleDateFormat("yyyy-MM-dd");
		String now = sfd.format(new Date());
		//取出年份
		if(year.equals("0")){
			year = "";
		}else if(year.equals("2")){
			year = now.substring(2, 4);
		}else if(year.equals("4")){
			year = now.substring(0, 4);
		}
		//取出月份
		if(month.equals("0")){
			month = "";
		}else if(month.equals("2")){
			month = now.substring(5, 7);
		}
		//取出日期
		if(day.equals("0")){
			day = "";
		}else{
			day = now.substring(8, 10);
		}
		//新流水号前补0
		String value = newValue.toString();
		int len = value.length();
		for(int i=0;i<length-len;i++){
			value ="0"+value;
		}
		curvalue = prefix+year+month+day+value+suffix;//新显示值
		seq.setSeq_scurvalue(curvalue);//保存新显示值
		return sequenceDAO.save(seq);
	}
	
	/**
	 * 根据ID查询信息
	 * @param form
	 * @return
	 */
	public MngSequence findByID(String id) {
		 
		return sequenceDAO.findByID(id);
	}
	
	/**
	 * 修改
	 * @param form
	 * @return
	 */
	public boolean update(MngSequenceForm form) {
		return sequenceDAO.update(form);
	}

	/**
	 * 批量删除
	 * @param idchecked
	 * @return
	 */
	public boolean delete(String[] idchecked) {
		return sequenceDAO.delete(idchecked);	
	}
	
	/**
	 * 批量更新状态
	 * @param idchecked
	 * @return
	 */
	public boolean changeValid(String[] idchecked) {
		return sequenceDAO.changeValid(idchecked);	
	}
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
	public String getNO(String info_nid , String seq_stype, String seq_sname) {
		//读取显示值
		MngSequenceForm form=new MngSequenceForm();
		form.setSysint_sno(info_nid);
		form.setSeq_stype(seq_stype);
		form.setSeq_sname(seq_sname);
		MngSequence sysSequence = sequenceDAO.findSeq(form);
		String curvalue = sysSequence.getSeq_scurvalue();
		

		//生成新显示值
		String newCurvalue = "";//新显示值
		String prefix = sysSequence.getSeq_sprefix()==null?"": sysSequence.getSeq_sprefix();//前缀
		String suffix = sysSequence.getSeq_ssuffix()==null?"":sysSequence.getSeq_ssuffix();//后缀
		String year = sysSequence.getSeq_nyear()==null?"":sysSequence.getSeq_nyear()+"";//年
		String month = sysSequence.getSeq_nmonth()==null?"":sysSequence.getSeq_nmonth()+"";//月
		String day = sysSequence.getSeq_nday()==null?"":sysSequence.getSeq_nday()+"" ;//日
		Long  length = sysSequence.getSeq_nlength()==null?0:sysSequence.getSeq_nlength();	//流水长度
		Long step = sysSequence.getSeq_nstep()==null?0:sysSequence.getSeq_nstep();	//步长
		//流水号+步长
		Long newValue = sysSequence.getSeq_nvalue()+step;//新流水号   当前值 +步长
		//取当前日期
		SimpleDateFormat sfd= new  SimpleDateFormat("yyyy-MM-dd");
		String now = sfd.format(new Date());
		//取出年份
		if(year.equals("0")){
			year = "";
		}else if(year.equals("2")){
			year = now.substring(2, 4);
		}else if(year.equals("4")){
			year = now.substring(0, 4);
		}
		//取出月份
		if(month.equals("0")){
			month = "";
		}else if(month.equals("2")){
			month = now.substring(5, 7);
		}
		//取出日期
		if(day.equals("0")){
			day = "";
		}else{
			day = now.substring(8, 10);
		}
		//新流水号前补0
		String value = newValue.toString();
		int len = value.length();
		for(int i=0;i<length-len;i++){
			value ="0"+value;
		}
		newCurvalue = prefix+year+month+day+value+suffix;//新显示值
		sysSequence.setSeq_scurvalue(newCurvalue);//保存新显示值
		sysSequence.setSeq_nvalue(newValue);//保存新流水号
		sequenceDAO.updateCurvalue(sysSequence);//修改显示值
		//返回读取的显示值
		return curvalue;
	}

	public List findPage1(MngTable form) {
		return sequenceDAO.findPage1(form);
	}

	public Integer findSize1(MngTable form) {
		return sequenceDAO.findSize1(form);
	}

	public boolean checkOnly(String seq_sname) {
		return sequenceDAO.checkOnly(seq_sname);
	}
}
	
