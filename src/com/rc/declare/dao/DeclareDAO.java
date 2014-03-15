package com.rc.declare.dao;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.rc.declare.form.AbApproBudgetForm;
import com.rc.declare.form.AsAccessoryForm;
import com.rc.declare.form.BMXBudgetMXForm;
import com.rc.declare.form.DMFDivMoneyFForm;
import com.rc.declare.form.DMZDivMoneyZForm;
import com.rc.declare.form.FbFeasibilityForm;
import com.rc.declare.form.NiNoticeInfoForm;
import com.rc.declare.form.PgPerformanceGoalForm;
import com.rc.declare.form.RpReportForm;
import com.rc.declare.form.RpReportSonForm;
import com.rc.declare.form.SlSpecialistForm;
import com.rc.declare.form.UBUnitBudgetForm;
import com.rc.declare.vo.BMXBudgetMX;
import com.rc.declare.vo.RpReport;
import com.rc.declare.vo.UBUnitBudget;




/**
 * 
 *  @Project       : CG
 *  @Program Name  : com.rc.declare.dao.DeclareDAO.java
 *  @Class Name    : DeclareDAO
 *  @Description   : 项目申报
 *  @Author        : Administrator
 *  @Creation Date : 2013-10-7下午10:50:17
 */
public class DeclareDAO extends SqlMapClientDaoSupport {
	/**
	 * 
	 *  @Description    : class 类
	 *  @Method_Name    : noticeFindList
	 *  @param sysDictItemForm
	 *  @return 
	 *  @return         : List
	 */
	public List classFindList(){
		return getSqlMapClientTemplate().queryForList("declare_findClass");
	}
	 
	/**
	 * 
	 *  @Description    : 项目申报通知
	 *  @Method_Name    : noticeFindList
	 *  @param sysDictItemForm
	 *  @return 
	 *  @return         : List
	 */
	public List noticeFindList(NiNoticeInfoForm sysDictItemForm){
		return getSqlMapClientTemplate().queryForList("notice_findList",sysDictItemForm);
	}
	/**
	 * 
	 *  @Description    : 项目申报通知记录数
	 *  @Method_Name    : noticeFindSize
	 *  @param sysDictItemForm
	 *  @return 
	 *  @return         : Integer
	 */
	public Integer noticeFindSize(NiNoticeInfoForm sysDictItemForm){
		return (Integer)getSqlMapClientTemplate().queryForObject("notice_findSize",sysDictItemForm);
	}
	/**
	 * 
	 *  @Description    : 新增申报通知
	 *  @Method_Name    : noticeAdd
	 *  @param sysDictItemForm
	 *  @return 
	 *  @return         : boolean
	 */
	public boolean noticeAdd(NiNoticeInfoForm sysDictItemForm){
		String count = (String) getSqlMapClientTemplate().insert("notice_add", sysDictItemForm);
		if(count != null && !"".equals(count)){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 
	 *  @Description    : 修改申报通知
	 *  @Method_Name    : noticeUpdate
	 *  @param sysDictForm
	 *  @return 
	 *  @return         : boolean
	 */
		public boolean noticeUpdate(NiNoticeInfoForm sysDictForm){
			return ((Integer)getSqlMapClientTemplate().update("notice_update",sysDictForm)).equals(0)?false:true;
		}

		/**
		 * 
		 *  @Description    : 申报通知发布
		 *  @Method_Name    : noticeIssue
		 *  @param sysDictForm
		 *  @return 
		 *  @return         : boolean
		 */
		public boolean noticeIssue(String[] str)throws SQLException{
			boolean bl = false;
			SqlMapClient sqlMapClient = getSqlMapClient();
			try {
				//开启一个事务
				sqlMapClient.startTransaction();
				for(int i = 0 ; i<str.length ; i++){
					sqlMapClient.update("notice_issue",str[i]);
				}
				
				sqlMapClient.commitTransaction();
				bl = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//事务回滚
				sqlMapClient.getCurrentConnection().rollback();
				bl = false;
			}
			finally{
				sqlMapClient.endTransaction();
			}
			return bl;
		}
		/**
		 * 
		 *  @Description    : 申报通知删除
		 *  @Method_Name    : noticeDelete
		 *  @param String
		 *  @return 
		 *  @return         : boolean
		 */
		public boolean noticeDelete(String[] str)throws SQLException{
			boolean bl = false;
			SqlMapClient sqlMapClient = getSqlMapClient();
			try {
				//开启一个事务
				sqlMapClient.startTransaction();
				for(int i = 0 ; i<str.length ; i++){
					sqlMapClient.update("notice_delete",str[i]);
				}
				
				sqlMapClient.commitTransaction();
				bl = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//事务回滚
				sqlMapClient.getCurrentConnection().rollback();
				bl = false;
			}
			finally{
				sqlMapClient.endTransaction();
			}
			return bl;
		}

		/**
		 * 
		 *  @Description    : 方法描述
		 *  @Method_Name    : findUd
		 *  @param ud_nnumber 单位层次 单位层次：1学校2学院3系
		 *  @param ud_sdef16 是否归口单位,0否，1归口单位,必须2级单位
		 *  @return 
		 *  @return         : List
		 */
		public List findUd(String ud_nnumber,String ud_sdef16){
			java.util.HashMap<String, String> map = new HashMap<String, String>();
			map.put("ud_nnumber", ud_nnumber);
			map.put("ud_sdef16", ud_sdef16);
			return getSqlMapClientTemplate().queryForList("declare_findUd",map);
		}
		/**
		 * 
		 *  @Description    : 项目申报表
		 *  @Method_Name    : rpFindList
		 *  @param RpReportForm
		 *  @return 
		 *  @return         : List
		 */
		public List rpFindList(RpReportForm sysDictItemForm){
			return getSqlMapClientTemplate().queryForList("rp_findList",sysDictItemForm);
		}
		/**
		 * 
		 *  @Description    : 项目申报记录数
		 *  @Method_Name    : noticeFindSize
		 *  @param RpReportForm
		 *  @return 
		 *  @return         : Integer
		 */
		public Integer rpFindSize(RpReportForm sysDictItemForm){
			return (Integer)getSqlMapClientTemplate().queryForObject("rp_findSize",sysDictItemForm);
		}
		/**
		 * 
		 *  @Description    : 新增申报
		 *  @Method_Name    : rpAdd
		 *  @param RpReportForm
		 *  @return 
		 *  @return         : boolean
		 */
		public boolean rpAdd(RpReportForm form){
			//申报新增成功后-》将对应的明细预算表，联合评审预算表，项目申请支出预算，项目可行性附表，专家（人员）表
			boolean bl = false;
			SqlMapClient sqlMapClient = getSqlMapClient();
			try {
				
				//开启一个事务
				sqlMapClient.startTransaction();
				sqlMapClient.insert("rp_add", form);
				//先将以前的数据删除
				/*sqlMapClient.delete("pg_delete1", form.getRp_sprojectno());
				sqlMapClient.delete("bmx_delete1", form.getRp_sprojectno());
				sqlMapClient.delete("ub_delete1", form.getRp_sprojectno());
				sqlMapClient.delete("ab_delete1", form.getRp_sprojectno());
				sqlMapClient.delete("sl_delete1", form.getRp_sprojectno());
				sqlMapClient.delete("as_delete1", form.getRp_sprojectno());
				sqlMapClient.delete("pg_delete1", form.getRp_sprojectno());*/
				String rpson_nid = form.getRpson_nid();
				if(rpson_nid != "" && rpson_nid != null){//修改项目子表
					String[] str = rpson_nid.split(",");
					for(int i = 0 ; i<str.length ; i++){
						RpReportSonForm sonform = new RpReportSonForm();
						sonform.setRpson_nid(Integer.parseInt(str[i].trim()));//rpson_nid	主键
						sonform.setRp_sid(form.getRp_sid());//rp_sid	对应申报主表表主键
						sonform.setRpson_nfinance(form.getRp_sfa1());// rpson_nFinance	财政拨款
						sonform.setRpson_nfithisyear(form.getRp_applybudget1());//rpson_nFithisYear	其中申请当年财政预算
						sonform.setRpson_nout(form.getRp_extrabudgetary1());//rpson_nOut	预算外资金
						sonform.setRpson_nother(form.getRp_others1());//rpson_nOther	其他资金
						sonform.setRpson_ntotal(form.getRp_total1());//rpson_nTotal	合计
						sonform.setRpson_sexplain(form.getRp_explain1());//rpson_sExplain	测算依据及说明
						sqlMapClient.update("rpSon_update1",sonform);
					}
				}
				String pg_sid = form.getPg_sid();
				if(pg_sid != null && pg_sid != ""){//修改项目申请阶段性目标表.indexOf(",") != -1 
					String[] str1 = pg_sid.split(",");
					String[] pg_sphase = form.getPg_sphase().split(",");
					String[] pg_starget = form.getPg_starget().split(",");
					String[] pg_ttime = form.getPg_ttime().split(",");
					for(int i = 0 ; i<str1.length ; i++){
						PgPerformanceGoalForm pgform = new PgPerformanceGoalForm();
						pgform.setPg_sid(str1[i].trim());
						pgform.setOrg_sno(form.getOrg_sno());//所属单位
						pgform.setRp_sprojectno(form.getRp_sprojectno());//项目编码
						pgform.setPg_sphase(pg_sphase[i].trim());//pg_sphase	实施阶段	varchar
						pgform.setPg_starget(pg_starget[i].trim());//pg_starget	目标内容	text
						pgform.setPg_ttime(pg_ttime[i].trim());//pg_ttime	时间(月)	varchar20
						pgform.setPg_sreplyby(form.getRp_sreplyby());
						sqlMapClient.update("pg_add",pgform);
					}
				}
				String bmx_sid = form.getBmx_sid();
				if(bmx_sid != null && bmx_sid != ""){//修改明细预算表.indexOf(",") != -1 
					String[] str2 = bmx_sid.split(",");
					String[] bmx_ssort = form.getBmx_ssort().split(",");
					String[] bmx_splanname = form.getBmx_splanname().split(",");
					String[] bmx_sisxieyi = form.getBmx_sisxieyi().split(",");
					String[] bmx_sisimport = form.getBmx_sisimport().split(",");
					String[] bmx_unitprice = form.getBmx_unitprice().split(",");
					String[] bmx_ncount = form.getBmx_ncount().split(",");
					String[] bmx_sunit = form.getBmx_sunit().split(",");
					String[] bmx_smodel = form.getBmx_smodel().split(",");
					String[] bmx_srec = form.getBmx_srec().split(",");
					String[] bmx_sexetime = form.getBmx_sexetime().split(",");
					String[] bmx_ntotal = form.getBmx_ntotal().split(",");
					String[] bmx_sdef2 = form.getBmx_sdef2().split(",");//联合表中
					String[] bmx_sdef1 = form.getBmx_sdef1().split(",");//联合表中
					for(int i = 0 ; i<str2.length ; i++){
						BMXBudgetMXForm bmxform = new BMXBudgetMXForm();
						bmxform.setBmx_sid(str2[i].trim());//主键
						bmxform.setRp_sid(form.getRp_sid());//申报ID
						bmxform.setRp_sprojectno(form.getRp_sprojectno());//项目编码
						bmxform.setUd_sno(form.getOrg_sno());//所属单位
						bmxform.setBmx_syear(form.getRp_syear());//年度
						bmxform.setBmx_ssort(bmx_ssort[i].trim());//bmx_ssort	项目分类
						bmxform.setBmx_splanname(bmx_splanname[i].trim());//bmx_splanname	明细预算内容
						bmxform.setBmx_syear(bmx_sisxieyi[i].trim());//bmx_sisxieyi	是否协议采购
						bmxform.setBmx_sisimport(bmx_sisimport[i].trim());//bmx_sisimport	是否进口
						bmxform.setBmx_unitprice(BigDecimal.valueOf(Double.parseDouble(bmx_unitprice[i].trim())));//bmx_unitprice	单价
						bmxform.setBmx_ncount(BigDecimal.valueOf(Double.parseDouble(bmx_ncount[i].trim())));//bmx_ncount	数量
						bmxform.setBmx_sunit(bmx_sunit[i].trim());//bmx_sunit	单位
						bmxform.setBmx_smodel(bmx_smodel[i].trim());//bmx_smodel	规格型号
						bmxform.setBmx_srec(bmx_srec[i].trim());//bmx_srec	推荐供应商
						bmxform.setBmx_sexetime(bmx_sexetime[i].trim());//bmx_sexetime	执行时间
						bmxform.setBmx_ntotal(BigDecimal.valueOf(Double.parseDouble(bmx_ntotal[i].trim())));//bmx_total	总额
						bmxform.setBmx_sreplyby(form.getRp_sreplyby());
						bmxform.setBmx_sdef1(bmx_sdef1[i].trim());
						bmxform.setBmx_sdef2(bmx_sdef2[i].trim());
						if(form.getUb_sid() != null && form.getUb_sid() != ""){
							String[] ud_sid = form.getUb_sid().split(",");
							String[] ub_sdef1 = form.getUb_sdef1().split(",");//明细表中
							for(int j = 0 ; j < ud_sid.length ; j++){
								if(ub_sdef1[j].equals(bmx_sdef2[i]) ){
									bmxform.setUb_sid(ud_sid[j].trim());
								}
							}
						}
						sqlMapClient.update("bmx_add",bmxform);
					}
				}
				String ub_sid = form.getUb_sid();
				if(ub_sid != null && ub_sid != ""){//修改联合评审预算表
					String[] str3 = ub_sid.split(",");
					String[] nplanname = form.getUb_nplanname().split(",");
					String[] nunitprice = form.getUb_nunitprice().split(",");
					String[] ncount = form.getUb_ncount().split(",");
					String[] ntotal = form.getUb_ntotal().split(",");
					String[] ub_sdef1 = form.getUb_sdef1().split(",");//明细表中
					for(int i = 0 ; i<str3.length ; i++){
						UBUnitBudgetForm ubform = new UBUnitBudgetForm();
						ubform.setUb_sid(str3[i].trim());//主键
						ubform.setRp_sid(form.getRp_sid());//申报ID
						ubform.setRp_sprojectno(form.getRp_sprojectno());//项目编码
						ubform.setUd_sno(form.getOrg_sno());//所属单位
						ubform.setUb_syear(form.getRp_syear());//年度
						ubform.setUb_sreplyby(form.getRp_sreplyby());
						ubform.setUb_nplanname(nplanname[i].trim());//ub_nplanname	明细项目名称
						ubform.setUb_nunitprice(BigDecimal.valueOf(Double.parseDouble(nunitprice[i].trim())));//ub_nunitprice	单价
						ubform.setUb_ncount(BigDecimal.valueOf(Double.parseDouble(ncount[i].trim())));//ub_ncount	数量
						ubform.setUb_ntotal(BigDecimal.valueOf(Double.parseDouble(ntotal[i].trim())));//ub_ntotal	总额
						ubform.setUb_sdef1(ub_sdef1[i].trim());
						sqlMapClient.update("ub_add",ubform);
					}
				}
				String ab_sid = form.getAb_sid();
				if(ab_sid != null && ab_sid != ""){//修改项目申请支出预算
					String[] str3 = ab_sid.split(",");
					String[] sitems = form.getAb_sitems().split(",");
					String[] smoney = form.getAb_smoney().split(",");
					String[] ab_ssort = form.getAb_ssort().split(",");
					for(int i = 0 ; i<str3.length ; i++){
						AbApproBudgetForm abform = new AbApproBudgetForm();
						abform.setRp_sprojectno(form.getRp_sprojectno());//项目编码
						abform.setOrg_sno(form.getOrg_sno());//所属单位
						abform.setAb_sreplyby(form.getRp_sreplyby());
						abform.setAb_sitems(sitems[i].trim());//ab_sitems	预算项
						abform.setAb_smoney(BigDecimal.valueOf(Double.parseDouble(smoney[i].trim())));//ab_smoney	金额
						abform.setAb_sid(str3[i].trim());
						abform.setAb_ssort(ab_ssort[i].trim());
						sqlMapClient.update("ab_add",abform);
					}
				}
				/*String fb_sid = form.getFb_sid();
				if(fb_sid.indexOf(",") != -1 ){//修改项目可行性附表
					String[] str3 = fb_sid.split(",");
					for(int i = 0 ; i<str3.length ; i++){
						FbFeasibilityForm fbform = new FbFeasibilityForm();
						fbform.setRp_sprojectno(form.getRp_sprojectno());//项目编码
						fbform.setOrg_sno(form.getOrg_sno());//所属单位
						sqlMapClient.update("fb_update1",fbform);
					}
				}*/
				String sl_sid = form.getSl_sid();
				if(sl_sid != "" && sl_sid !=null){//修改专家（人员）表
					String[] str3 = sl_sid.split(",");
					String[] snumber = form.getSl_snumber().split(",");
					String[] sname = form.getSl_sname().split(",");
					String[] sjob = form.getSl_sjob().split(",");
					String[] sjobtitle = form.getSl_sjobtitle().split(",");
					String[] smajor = form.getSl_smajor().split(",");
					String[] slevel = form.getSl_slevel().split(",");
				//	String[] sl_stype = form.getSl_stype().split(",");
					for(int i = 0 ; i<str3.length ; i++){
						SlSpecialistForm slform = new SlSpecialistForm();
						slform.setRp_sprojectno(form.getRp_sprojectno());//项目编码
						slform.setOrg_sno(form.getOrg_sno());//所属单位
						slform.setSl_sreplyby(form.getRp_sreplyby());
						slform.setSl_sid(str3[i].trim());//主键
						slform.setSl_snumber(snumber[i].trim());//sl_snumber	序号
						slform.setSl_sname(sname[i].trim());//sl_sname	姓名
						slform.setSl_sjob(sjob[i].trim());//sl_sjob	职务
						slform.setSl_sjobtitle(sjobtitle[i].trim());//sl_sjobtitle	职称
						slform.setSl_smajor(smajor[i].trim());//sl_smajor	专业
						slform.setSl_slevel(slevel[i].trim());//sl_slevel	对专业熟炼程度
						slform.setSl_stype("0");
						sqlMapClient.update("sl_add",slform);
					}
				}
				String as_sid = form.getAs_sid();
				if(as_sid != null && as_sid != "" ){//修改附件表
					String[] str3 = as_sid.split(",");
					String[] ntype = form.getAs_ntype().split(",");
					String[] sname = form.getAs_sname().split(",");
					String[] surl = form.getAs_surl().split(",");
					String[] dtime = form.getAs_dtime().split(",");
					String[] as_sperson = form.getAs_sperson().split(",");
					for(int i = 0 ; i<str3.length ; i++){
						AsAccessoryForm asfrom = new AsAccessoryForm();
						asfrom.setEp_sid(form.getRp_sprojectno());//项目编码
						asfrom.setOrg_sno(form.getOrg_sno());//所属单位
						asfrom.setAs_sreplyby(form.getRp_sreplyby());//
						asfrom.setAs_sid(str3[i].trim());//as_sid	编号
						asfrom.setAs_ntype(ntype[i].trim());//as_ntype	类型
						asfrom.setAs_sname(sname[i].trim());//as_sname	名称
						asfrom.setAs_surl(surl[i].trim());//as_surl	路径
						asfrom.setAs_sperson(as_sperson[i].trim());//上传人
						asfrom.setAs_sreplyby(form.getRp_sreplyby());//创建人
						asfrom.setAs_dtime(dtime[i].trim());//as_dtime	上传时间
						sqlMapClient.update("as_add",asfrom);
					}
				}
				sqlMapClient.commitTransaction();
				bl = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//事务回滚
				try {
					sqlMapClient.getCurrentConnection().rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				bl = false;
			}
			finally{
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
		 * 
		 *  @Description    : 修改申报
		 *  @Method_Name    : rpUpdate
		 *  @param RpReportForm
		 *  @return 
		 *  @return         : boolean
		 */
			public boolean rpUpdate(RpReportForm form){
				boolean bl = false;
				SqlMapClient sqlMapClient = getSqlMapClient();
				try {
					
					//开启一个事务
					sqlMapClient.startTransaction();
					sqlMapClient.update("rp_update", form);
					String pg_sid = form.getPg_sid();
					if(pg_sid != null && pg_sid != ""){//修改项目申请阶段性目标表.indexOf(",") != -1 
						sqlMapClient.delete("pg_delete1", form.getRp_sprojectno());
						String[] str1 = pg_sid.split(",");
						String[] pg_sphase = form.getPg_sphase().split(",");
						String[] pg_starget = form.getPg_starget().split(",");
						String[] pg_ttime = form.getPg_ttime().split(",");
						for(int i = 0 ; i<str1.length ; i++){
							PgPerformanceGoalForm pgform = new PgPerformanceGoalForm();
							pgform.setPg_sid(str1[i].trim());
							pgform.setOrg_sno(form.getOrg_sno());//所属单位
							pgform.setRp_sprojectno(form.getRp_sprojectno());//项目编码
							pgform.setPg_sphase(pg_sphase[i].trim());//pg_sphase	实施阶段	varchar
							pgform.setPg_starget(pg_starget[i].trim());//pg_starget	目标内容	text
							pgform.setPg_ttime(pg_ttime[i].trim());//pg_ttime	时间(月)	varchar20
							pgform.setPg_sreplyby(form.getRp_sreplyby());
							sqlMapClient.update("pg_add",pgform);
						}
					}
					String bmx_sid = form.getBmx_sid();
					if(bmx_sid != null && bmx_sid != ""){//修改明细预算表.indexOf(",") != -1 
						sqlMapClient.delete("bmx_delete1", form.getRp_sprojectno());
						String[] str2 = bmx_sid.split(",");
						String[] bmx_ssort = form.getBmx_ssort().split(",");
						String[] bmx_splanname = form.getBmx_splanname().split(",");
						String[] bmx_sisxieyi = form.getBmx_sisxieyi().split(",");
						String[] bmx_sisimport = form.getBmx_sisimport().split(",");
						String[] bmx_unitprice = form.getBmx_unitprice().split(",");
						String[] bmx_ncount = form.getBmx_ncount().split(",");
						String[] bmx_sunit = form.getBmx_sunit().split(",");
						String[] bmx_smodel = form.getBmx_smodel().split(",");
						String[] bmx_srec = form.getBmx_srec().split(",");
						String[] bmx_sexetime = form.getBmx_sexetime().split(",");
						String[] bmx_ntotal = form.getBmx_ntotal().split(",");
						String[] bmx_sdef2 = form.getBmx_sdef2().split(",");//联合表中
						String[] bmx_sdef1 = form.getBmx_sdef1().split(",");//联合表中
						for(int i = 0 ; i<str2.length ; i++){
							BMXBudgetMXForm bmxform = new BMXBudgetMXForm();
							bmxform.setBmx_sid(str2[i].trim());//主键
							bmxform.setRp_sid(form.getRp_sid());//申报ID
							bmxform.setRp_sprojectno(form.getRp_sprojectno());//项目编码
							bmxform.setUd_sno(form.getOrg_sno());//所属单位
							bmxform.setBmx_syear(form.getRp_syear());//年度
							bmxform.setBmx_ssort(bmx_ssort[i].trim());//bmx_ssort	项目分类
							bmxform.setBmx_splanname(bmx_splanname[i].trim());//bmx_splanname	明细预算内容
							bmxform.setBmx_syear(bmx_sisxieyi[i].trim());//bmx_sisxieyi	是否协议采购
							bmxform.setBmx_sisimport(bmx_sisimport[i].trim());//bmx_sisimport	是否进口
							bmxform.setBmx_unitprice(BigDecimal.valueOf(Double.parseDouble(bmx_unitprice[i].trim())));//bmx_unitprice	单价
							bmxform.setBmx_ncount(BigDecimal.valueOf(Double.parseDouble(bmx_ncount[i].trim())));//bmx_ncount	数量
							bmxform.setBmx_sunit(bmx_sunit[i].trim());//bmx_sunit	单位
							bmxform.setBmx_smodel(bmx_smodel[i].trim());//bmx_smodel	规格型号
							bmxform.setBmx_srec(bmx_srec[i].trim());//bmx_srec	推荐供应商
							bmxform.setBmx_sexetime(bmx_sexetime[i].trim());//bmx_sexetime	执行时间
							bmxform.setBmx_ntotal(BigDecimal.valueOf(Double.parseDouble(bmx_ntotal[i].trim())));//bmx_total	总额
							bmxform.setBmx_sreplyby(form.getRp_sreplyby());
							bmxform.setBmx_sdef1(bmx_sdef1[i].trim());
							bmxform.setBmx_sdef2(bmx_sdef2[i].trim());
							if(form.getUb_sid() != null && form.getUb_sid() != ""){
								String[] ud_sid = form.getUb_sid().split(",");
								String[] ub_sdef1 = form.getUb_sdef1().split(",");//明细表中
								for(int j = 0 ; j < ud_sid.length ; j++){
									if(ub_sdef1[j].trim().equals(bmx_sdef2[i].trim()) ){
										bmxform.setUb_sid(ud_sid[j].trim());
									}
								}
							}
							sqlMapClient.update("bmx_add",bmxform);
						}
					}
					String ub_sid = form.getUb_sid();
					System.out.println();
					if(ub_sid != null && ub_sid != ""){//修改联合评审预算表
						sqlMapClient.delete("ub_delete1", form.getRp_sprojectno());
						String[] str3 = ub_sid.split(",");
						String[] nplanname = form.getUb_nplanname().split(",");
						String[] nunitprice = form.getUb_nunitprice().split(",");
						String[] ncount = form.getUb_ncount().split(",");
						String[] ntotal = form.getUb_ntotal().split(",");
						String[] ub_sdef1 = form.getUb_sdef1().split(",");//明细表中
						for(int i = 0 ; i<str3.length ; i++){
							UBUnitBudgetForm ubform = new UBUnitBudgetForm();
							ubform.setUb_sid(str3[i].trim());//主键
							ubform.setRp_sid(form.getRp_sid());//申报ID
							ubform.setRp_sprojectno(form.getRp_sprojectno());//项目编码
							ubform.setUd_sno(form.getOrg_sno());//所属单位
							ubform.setUb_syear(form.getRp_syear());//年度
							ubform.setUb_sreplyby(form.getRp_sreplyby());
							ubform.setUb_nplanname(nplanname[i].trim());//ub_nplanname	明细项目名称
							ubform.setUb_nunitprice(BigDecimal.valueOf(Double.parseDouble(nunitprice[i].trim())));//ub_nunitprice	单价
							ubform.setUb_ncount(BigDecimal.valueOf(Double.parseDouble(ncount[i].trim())));//ub_ncount	数量
							ubform.setUb_ntotal(BigDecimal.valueOf(Double.parseDouble(ntotal[i].trim())));//ub_ntotal	总额
							ubform.setUb_sdef1(ub_sdef1[i].trim());
							sqlMapClient.update("ub_add",ubform);
						}
					}
					String ab_sid = form.getAb_sid();
					if(ab_sid != null && ab_sid != ""){//修改项目申请支出预算
						
						String[] str3 = ab_sid.split(",");
						String[] sitems = form.getAb_sitems().split(",");
						String[] smoney = form.getAb_smoney().split(",");
						String[] ab_ssort = form.getAb_ssort().split(",");
						System.out.println(ab_ssort+"==ab_ssort");
						System.out.println(sitems+"==sitems");
						for(int j = 0 ; j<ab_ssort.length ; j++){
							if("0".equals(ab_ssort[j].trim()) ){
								java.util.HashMap<String, String> map = new HashMap<String, String>();
								map.put("ab_ssort", "0");
								map.put("rp_sprojectno", form.getRp_sprojectno());
								sqlMapClient.delete("ab_delete1", map);
							}
							if("1".equals(ab_ssort[j].trim()) ){
								java.util.HashMap<String, String> map = new HashMap<String, String>();
								map.put("ab_ssort", "1");
								map.put("rp_sprojectno", form.getRp_sprojectno());
								sqlMapClient.delete("ab_delete1", map);
							}
						}
						for(int i = 0 ; i<str3.length ; i++){
							AbApproBudgetForm abform = new AbApproBudgetForm();
							abform.setRp_sprojectno(form.getRp_sprojectno());//项目编码
							abform.setOrg_sno(form.getOrg_sno());//所属单位
							abform.setAb_sreplyby(form.getRp_sreplyby());
							abform.setAb_sitems(sitems[i].trim());//ab_sitems	预算项
							abform.setAb_smoney(BigDecimal.valueOf(Double.parseDouble(smoney[i].trim())));//ab_smoney	金额
							abform.setAb_sid(str3[i].trim());
							abform.setAb_ssort(ab_ssort[i].trim());
							sqlMapClient.update("ab_add",abform);
						}
					}
					/*String fb_sid = form.getFb_sid();
					if(fb_sid.indexOf(",") != -1 ){//修改项目可行性附表
						String[] str3 = fb_sid.split(",");
						for(int i = 0 ; i<str3.length ; i++){
							FbFeasibilityForm fbform = new FbFeasibilityForm();
							fbform.setRp_sprojectno(form.getRp_sprojectno());//项目编码
							fbform.setOrg_sno(form.getOrg_sno());//所属单位
							sqlMapClient.update("fb_update1",fbform);
						}
					}*/
					String sl_sid = form.getSl_sid();
					if(sl_sid != "" && sl_sid !=null){//修改专家（人员）表
						sqlMapClient.delete("sl_delete1", form.getRp_sprojectno());
						String[] str3 = sl_sid.split(",");
						String[] snumber = form.getSl_snumber().split(",");
						String[] sname = form.getSl_sname().split(",");
						String[] sjob = form.getSl_sjob().split(",");
						String[] sjobtitle = form.getSl_sjobtitle().split(",");
						String[] smajor = form.getSl_smajor().split(",");
						String[] slevel = form.getSl_slevel().split(",");
						for(int i = 0 ; i<str3.length ; i++){
							SlSpecialistForm slform = new SlSpecialistForm();
							slform.setRp_sprojectno(form.getRp_sprojectno());//项目编码
							slform.setOrg_sno(form.getOrg_sno());//所属单位
							slform.setSl_sreplyby(form.getRp_sreplyby());
							slform.setSl_sid(str3[i].trim());//主键
							slform.setSl_snumber(snumber[i].trim());//sl_snumber	序号
							slform.setSl_sname(sname[i].trim());//sl_sname	姓名
							slform.setSl_sjob(sjob[i].trim());//sl_sjob	职务
							slform.setSl_sjobtitle(sjobtitle[i].trim());//sl_sjobtitle	职称
							slform.setSl_smajor(smajor[i].trim());//sl_smajor	专业
							slform.setSl_slevel(slevel[i].trim());//sl_slevel	对专业熟炼程度
							slform.setSl_sdef10(form.getRp_sid().trim());//申请单编号
							slform.setSl_stype("0");
							sqlMapClient.update("sl_add",slform);
						}
					}
					String as_sid = form.getAs_sid();
					if(as_sid != null && as_sid != "" ){//修改附件表
						//sqlMapClient.delete("as_delete1", form.getRp_sprojectno());
						String[] str3 = as_sid.split(",");
						String[] ntype = form.getAs_ntype().split(",");
						String[] sname = form.getAs_sname().split(",");
						String[] surl = form.getAs_surl().split(",");
						String[] dtime = form.getAs_dtime().split(",");
						String[] as_sperson = form.getAs_sperson().split(",");
						for(int i = 0 ; i<str3.length ; i++){
							AsAccessoryForm asfrom = new AsAccessoryForm();
							asfrom.setEp_sid(form.getRp_sprojectno());//项目编码
							asfrom.setOrg_sno(form.getOrg_sno());//所属单位
							asfrom.setAs_sreplyby(form.getRp_sreplyby());//
							asfrom.setAs_sid(str3[i].trim());//as_sid	编号
							asfrom.setAs_ntype(ntype[i].trim());//as_ntype	类型
							asfrom.setAs_sname(sname[i].trim());//as_sname	名称
							asfrom.setAs_surl(surl[i].trim());//as_surl	路径
							asfrom.setAs_sperson(as_sperson[i].trim());//上传人
							asfrom.setAs_sreplyby(form.getRp_sreplyby());//	创建人
							asfrom.setAs_dtime(dtime[i].trim());//as_dtime	上传时间
							sqlMapClient.update("as_add",asfrom);
						}
					}
					sqlMapClient.commitTransaction();
					bl = true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//事务回滚
					try {
						sqlMapClient.getCurrentConnection().rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					bl = false;
				}
				finally{
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
			 * 
			 *  @Description    : 修改申报
			 *  @Method_Name    : rpUpdate
			 *  @param RpReportForm
			 *  @return 
			 *  @return         : boolean
			 */
				public boolean rpUpdate1(RpReportForm form){
					boolean bl = false;
					SqlMapClient sqlMapClient = getSqlMapClient();
					try {
						
						//开启一个事务
						sqlMapClient.startTransaction();
						sqlMapClient.update("rp_update", form);
						String pg_sid = form.getPg_sid();
						if(pg_sid != null && pg_sid != ""){//修改项目申请阶段性目标表.indexOf(",") != -1 
							sqlMapClient.delete("pg_delete1", form.getRp_sprojectno());
							String[] str1 = pg_sid.split(",");
							String[] pg_sphase = form.getPg_sphase().split(",");
							String[] pg_starget = form.getPg_starget().split(",");
							String[] pg_ttime = form.getPg_ttime().split(",");
							for(int i = 0 ; i<str1.length ; i++){
								PgPerformanceGoalForm pgform = new PgPerformanceGoalForm();
								pgform.setPg_sid(str1[i].trim());
								pgform.setOrg_sno(form.getOrg_sno());//所属单位
								pgform.setRp_sprojectno(form.getRp_sprojectno());//项目编码
								pgform.setPg_sphase(pg_sphase[i].trim());//pg_sphase	实施阶段	varchar
								pgform.setPg_starget(pg_starget[i].trim());//pg_starget	目标内容	text
								pgform.setPg_ttime(pg_ttime[i].trim());//pg_ttime	时间(月)	varchar20
								pgform.setPg_sreplyby(form.getRp_sreplyby());
								sqlMapClient.update("pg_add",pgform);
							}
						}
						String bmx_sid = form.getBmx_sid();
						if(bmx_sid != null && bmx_sid != ""){//修改明细预算表.indexOf(",") != -1 
							sqlMapClient.delete("bmx_delete1", form.getRp_sprojectno());
							String[] str2 = bmx_sid.split(",");
							String[] bmx_ssort = form.getBmx_ssort().split(",");
							String[] bmx_splanname = form.getBmx_splanname().split(",");
							String[] bmx_sisxieyi = form.getBmx_sisxieyi().split(",");
							String[] bmx_sisimport = form.getBmx_sisimport().split(",");
							String[] bmx_unitprice = form.getBmx_unitprice().split(",");
							String[] bmx_ncount = form.getBmx_ncount().split(",");
							String[] bmx_sunit = form.getBmx_sunit().split(",");
							String[] bmx_smodel = form.getBmx_smodel().split(",");
							String[] bmx_srec = form.getBmx_srec().split(",");
							String[] bmx_sexetime = form.getBmx_sexetime().split(",");
							String[] bmx_ntotal = form.getBmx_ntotal().split(",");
							String[] bmx_sdef2 = form.getBmx_sdef2().split(",");//联合表中
							String[] bmx_sdef1 = form.getBmx_sdef1().split(",");//联合表中
							for(int i = 0 ; i<str2.length ; i++){
								BMXBudgetMXForm bmxform = new BMXBudgetMXForm();
								bmxform.setBmx_sid(str2[i].trim());//主键
								bmxform.setRp_sid(form.getRp_sid());//申报ID
								bmxform.setRp_sprojectno(form.getRp_sprojectno());//项目编码
								bmxform.setUd_sno(form.getOrg_sno());//所属单位
								bmxform.setBmx_syear(form.getRp_syear());//年度
								bmxform.setBmx_ssort(bmx_ssort[i].trim());//bmx_ssort	项目分类
								bmxform.setBmx_splanname(bmx_splanname[i].trim());//bmx_splanname	明细预算内容
								bmxform.setBmx_syear(bmx_sisxieyi[i].trim());//bmx_sisxieyi	是否协议采购
								bmxform.setBmx_sisimport(bmx_sisimport[i].trim());//bmx_sisimport	是否进口
								bmxform.setBmx_unitprice(BigDecimal.valueOf(Double.parseDouble(bmx_unitprice[i].trim())));//bmx_unitprice	单价
								bmxform.setBmx_ncount(BigDecimal.valueOf(Double.parseDouble(bmx_ncount[i].trim())));//bmx_ncount	数量
								bmxform.setBmx_sunit(bmx_sunit[i].trim());//bmx_sunit	单位
								bmxform.setBmx_smodel(bmx_smodel[i].trim());//bmx_smodel	规格型号
								bmxform.setBmx_srec(bmx_srec[i].trim());//bmx_srec	推荐供应商
								bmxform.setBmx_sexetime(bmx_sexetime[i].trim());//bmx_sexetime	执行时间
								bmxform.setBmx_ntotal(BigDecimal.valueOf(Double.parseDouble(bmx_ntotal[i].trim())));//bmx_total	总额
								bmxform.setBmx_sreplyby(form.getRp_sreplyby());
								bmxform.setBmx_sdef1(bmx_sdef1[i].trim());
								bmxform.setBmx_sdef2(bmx_sdef2[i].trim());
								if(form.getUb_sid() != null && form.getUb_sid() != ""){
									String[] ud_sid = form.getUb_sid().split(",");
									String[] ub_sdef1 = form.getUb_sdef1().split(",");//明细表中
									for(int j = 0 ; j < ud_sid.length ; j++){
										if(ub_sdef1[j].equals(bmx_sdef2[i]) ){
											bmxform.setUb_sid(ud_sid[j].trim());
										}
									}
								}
								sqlMapClient.update("bmx_add",bmxform);
							}
						}
						String ub_sid = form.getUb_sid();
						if(ub_sid != null && ub_sid != ""){//修改联合评审预算表
							sqlMapClient.delete("ub_delete1", form.getRp_sprojectno());
							String[] str3 = ub_sid.split(",");
							String[] nplanname = form.getUb_nplanname().split(",");
							String[] nunitprice = form.getUb_nunitprice().split(",");
							String[] ncount = form.getUb_ncount().split(",");
							String[] ntotal = form.getUb_ntotal().split(",");
							String[] ub_sdef1 = form.getUb_sdef1().split(",");//明细表中
							for(int i = 0 ; i<str3.length ; i++){
								UBUnitBudgetForm ubform = new UBUnitBudgetForm();
								ubform.setUb_sid(str3[i].trim());//主键
								ubform.setRp_sid(form.getRp_sid());//申报ID
								ubform.setRp_sprojectno(form.getRp_sprojectno());//项目编码
								ubform.setUd_sno(form.getOrg_sno());//所属单位
								ubform.setUb_syear(form.getRp_syear());//年度
								ubform.setUb_sreplyby(form.getRp_sreplyby());
								ubform.setUb_nplanname(nplanname[i].trim());//ub_nplanname	明细项目名称
								ubform.setUb_nunitprice(BigDecimal.valueOf(Double.parseDouble(nunitprice[i].trim())));//ub_nunitprice	单价
								ubform.setUb_ncount(BigDecimal.valueOf(Double.parseDouble(ncount[i].trim())));//ub_ncount	数量
								ubform.setUb_ntotal(BigDecimal.valueOf(Double.parseDouble(ntotal[i].trim())));//ub_ntotal	总额
								ubform.setUb_sdef1(ub_sdef1[i].trim());
								sqlMapClient.update("ub_add",ubform);
							}
						}
						String ab_sid = form.getAb_sid();
						if(ab_sid != null && ab_sid != ""){//修改项目申请支出预算
							sqlMapClient.delete("ab_delete", form.getRp_sprojectno());
							String[] str3 = ab_sid.split(",");
							String[] sitems = form.getAb_sitems().split(",");
							String[] smoney = form.getAb_smoney().split(",");
							for(int i = 0 ; i<str3.length ; i++){
								AbApproBudgetForm abform = new AbApproBudgetForm();
								abform.setRp_sprojectno(form.getRp_sprojectno());//项目编码
								abform.setOrg_sno(form.getOrg_sno());//所属单位
								abform.setAb_sreplyby(form.getRp_sreplyby());
								abform.setAb_sitems(sitems[i].trim());//ab_sitems	预算项
								abform.setAb_smoney(BigDecimal.valueOf(Double.parseDouble(smoney[i].trim())));//ab_smoney	金额
								abform.setAb_sid(str3[i].trim());
								sqlMapClient.update("ab_add",abform);
							}
						}
						/*String fb_sid = form.getFb_sid();
						if(fb_sid.indexOf(",") != -1 ){//修改项目可行性附表
							String[] str3 = fb_sid.split(",");
							for(int i = 0 ; i<str3.length ; i++){
								FbFeasibilityForm fbform = new FbFeasibilityForm();
								fbform.setRp_sprojectno(form.getRp_sprojectno());//项目编码
								fbform.setOrg_sno(form.getOrg_sno());//所属单位
								sqlMapClient.update("fb_update1",fbform);
							}
						}*/
						String sl_sid = form.getSl_sid();
						if(sl_sid != "" && sl_sid !=null){//修改主要参加人员列表
								java.util.HashMap<String, String> map = new HashMap<String, String>();
								map.put("rp_sprojectno", form.getRp_sprojectno());
								map.put("sl_stype", "0");
								sqlMapClient.delete("sl_deleteBytype", map);
								String[] str3 = sl_sid.split(",");
								String[] snumber = form.getSl_snumber().split(",");
								String[] sname = form.getSl_sname().split(",");
								String[] sjob = form.getSl_sjob().split(",");
								String[] sjobtitle = form.getSl_sjobtitle().split(",");
								String[] smajor = form.getSl_smajor().split(",");
								String[] slevel = form.getSl_slevel().split(",");
								for(int i = 0 ; i<str3.length ; i++){
									SlSpecialistForm slform = new SlSpecialistForm();
									slform.setRp_sprojectno(form.getRp_sprojectno());//项目编码
									slform.setOrg_sno(form.getOrg_sno());//所属单位
									slform.setSl_sreplyby(form.getRp_sreplyby());
									slform.setSl_sid(str3[i].trim());//主键
									slform.setSl_snumber(snumber[i].trim());//sl_snumber	序号
									slform.setSl_sname(sname[i].trim());//sl_sname	姓名
									slform.setSl_sjob(sjob[i].trim());//sl_sjob	职务
									slform.setSl_sjobtitle(sjobtitle[i].trim());//sl_sjobtitle	职称
									slform.setSl_smajor(smajor[i].trim());//sl_smajor	专业
									slform.setSl_slevel(slevel[i].trim());//sl_slevel	对专业熟炼程度
									slform.setSl_sdef10(form.getRp_sid().trim());//申请单编号
									slform.setSl_stype("0");//类别
									sqlMapClient.update("sl_add",slform);
								}
						}
						String sl_sid1 = form.getSl_sid1();
						//修改专家信息列表
						if(sl_sid1 != "" && sl_sid1 !=null){
							java.util.HashMap<String, String> map = new HashMap<String, String>();
							map.put("rp_sprojectno", form.getRp_sprojectno());
							map.put("sl_stype", "1");//
							sqlMapClient.delete("sl_deleteBytype", map);
							String[] str3 = sl_sid1.split(",");
							String[] sl_sclass1 = form.getSl_sclass1().split(",");
							String[] sl_stele1 = form.getSl_stele1().split(",");
							String[] sl_spin1 = form.getSl_spin1().split(",");
							String[] sl_snumber1 = form.getSl_snumber1().split(",");
							String[] sl_smajor1 = form.getSl_smajor1().split(",");
							String[] sl_sname1 = form.getSl_sname1().split(",");
							String[] sl_sjobtitleno1 = form.getSl_sjobtitleno1().split(",");
							String[] sl_sdef9 = form.getSl_sdef9().split(",");
							String[] sl_sgetjobaddr1 = form.getSl_sgetjobaddr1().split(",");
							//String[] sl_stype1 = form.getSl_stype1().split(",");
							for(int i = 0 ; i<str3.length ; i++){
								SlSpecialistForm slform = new SlSpecialistForm();
								slform.setRp_sprojectno(form.getRp_sprojectno());//项目编码
								slform.setOrg_sno(form.getOrg_sno());//所属单位
								slform.setSl_sreplyby(form.getRp_sreplyby());
								slform.setSl_sid(str3[i].trim());//主键
								slform.setSl_sclass(sl_sclass1[i].trim());//类型,0校内专家1校外专家2律师
								slform.setSl_stele(sl_stele1[i]);//联系电话
								slform.setSl_spin(sl_spin1[i].trim());//身份证号
								slform.setSl_snumber(sl_snumber1[i].trim());//sl_snumber	序号
								slform.setSl_smajor(sl_smajor1[i].trim());//当类型为1.项目申请评审专家时：为职务职称
								slform.setSl_sname(sl_sname1[i].trim());//sl_sname	姓名
								slform.setSl_sjobtitleno(sl_sjobtitleno1[i].trim());//职称证书编号
								slform.setSl_sdef9(sl_sdef9[i].trim());//专家单位
								slform.setSl_sgetjobaddr(sl_sgetjobaddr1[i].trim());
								slform.setSl_stype("1");//类别:0项目申请参与人，1项目申请评审专家，2项目立项论证专家，3进口申请专家
								slform.setSl_sdef10(form.getRp_sid().trim());//申请单编号
								sqlMapClient.update("sl_add",slform);
							}
						}
						String as_sid = form.getAs_sid();
						if(as_sid != null && as_sid != "" ){//修改附件表
							//sqlMapClient.delete("as_delete1", form.getRp_sprojectno());
							String[] str3 = as_sid.split(",");
							String[] ntype = form.getAs_ntype().split(",");
							String[] sname = form.getAs_sname().split(",");
							String[] surl = form.getAs_surl().split(",");
							String[] as_sperson = form.getAs_sperson().split(",");
							String[] dtime = form.getAs_dtime().split(",");
							for(int i = 0 ; i<str3.length ; i++){
								AsAccessoryForm asfrom = new AsAccessoryForm();
								asfrom.setEp_sid(form.getRp_sprojectno());//项目编码
								asfrom.setOrg_sno(form.getOrg_sno());//所属单位
								asfrom.setAs_sreplyby(form.getRp_sreplyby());//
								asfrom.setAs_sid(str3[i].trim());//as_sid	编号
								asfrom.setAs_ntype(ntype[i].trim());//as_ntype	类型
								asfrom.setAs_sname(sname[i].trim());//as_sname	名称
								asfrom.setAs_surl(surl[i].trim());//as_surl	路径
								asfrom.setAs_sperson(as_sperson[i].trim());//as_sperson	上传人
								asfrom.setAs_sreplyby(form.getRp_sreplyby());//创建人
								asfrom.setAs_dtime(dtime[i].trim());//as_dtime	上传时间
								sqlMapClient.update("as_add",asfrom);
							}
						}
						sqlMapClient.commitTransaction();
						bl = true;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						//事务回滚
						try {
							sqlMapClient.getCurrentConnection().rollback();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						bl = false;
					}
					finally{
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
			 * 
			 *  @Description    : 修改申报通知状态
			 *  @Method_Name    : rpUpdateState
			 *  @param String
			 *  @return 
			 *  @return         : boolean
			 */
			public boolean rpUpdateState(String[] str,String state)throws SQLException{
				boolean bl = false;
				SqlMapClient sqlMapClient = getSqlMapClient();
				try {
					//开启一个事务
					sqlMapClient.startTransaction();
					for(int i = 0 ; i<str.length ; i++){
						HashMap< String, String> hashMap = new HashMap<String, String>();
						hashMap.put("rp_sId", str[i]);
						hashMap.put("rp_sStatus", state);
						sqlMapClient.update("rp_updateState",hashMap);
					}
					
					sqlMapClient.commitTransaction();
					bl = true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//事务回滚
					sqlMapClient.getCurrentConnection().rollback();
					bl = false;
				}
				finally{
					sqlMapClient.endTransaction();
				}
				return bl;
			}
			/**
			 * 
			 *  @Description    : 申报通知删除
			 *  @Method_Name    : rpDelete
			 *  @param String
			 *  @return 
			 *  @return         : boolean
			 */
			public boolean rpDelete(String[] str)throws SQLException{
				boolean bl = false;
				SqlMapClient sqlMapClient = getSqlMapClient();
				try {
					//开启一个事务
					sqlMapClient.startTransaction();
					for(int i = 0 ; i<str.length ; i++){
						RpReportForm form = new RpReportForm();
						form.setRp_sid(str[i]);
						RpReport rp = (RpReport) sqlMapClient.queryForList("rp_findList",form).get(0);
						sqlMapClient.update("rp_delete",str[i]);
						sqlMapClient.delete("pg_delete", rp.getRp_sprojectno());
						sqlMapClient.delete("bmx_delete", rp.getRp_sprojectno());
						sqlMapClient.delete("ub_delete", rp.getRp_sprojectno());
						sqlMapClient.delete("ab_delete", rp.getRp_sprojectno());
						sqlMapClient.delete("sl_delete", rp.getRp_sprojectno());
						sqlMapClient.delete("as_delete",rp.getRp_sprojectno());
					}
					
					sqlMapClient.commitTransaction();
					bl = true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//事务回滚
					sqlMapClient.getCurrentConnection().rollback();
					bl = false;
				}
				finally{
					sqlMapClient.endTransaction();
				}
				return bl;
			}
			/**
			 * 
			 *  @Description    : 项目申请阶段性目标表
			 *  @Method_Name    : pgFindList
			 *  @param PgPerformanceGoalForm
			 *  @return 
			 *  @return         : List
			 */
			public List pgFindList(PgPerformanceGoalForm sysDictItemForm){
				return getSqlMapClientTemplate().queryForList("pg_findList",sysDictItemForm);
			}
			/**
			 * 
			 *  @Description    : 项目申请阶段性目标表记录数
			 *  @Method_Name    : pgFindSize
			 *  @param sysDictItemForm
			 *  @return 
			 *  @return         : Integer
			 */
			public Integer pgFindSize(PgPerformanceGoalForm sysDictItemForm){
				return (Integer)getSqlMapClientTemplate().queryForObject("pg_findSize",sysDictItemForm);
			}
			/**
			 * 
			 *  @Description    : 新增项目申请阶段性目标表
			 *  @Method_Name    : pgAdd
			 *  @param PgPerformanceGoalForm
			 *  @return 
			 *  @return         : boolean
			 */
			public boolean pgAdd(PgPerformanceGoalForm sysDictItemForm){
				String count = (String) getSqlMapClientTemplate().insert("pg_add", sysDictItemForm);
				if(count != null && !"".equals(count)){
					return true;
				}else{
					return false;
				}
			}
			/**
			 * 
			 *  @Description    : 修改项目申请阶段性目标表
			 *  @Method_Name    : pgUpdate
			 *  @param PgPerformanceGoalForm
			 *  @return 
			 *  @return         : boolean
			 */
				public boolean pgUpdate(PgPerformanceGoalForm sysDictForm){
					return ((Integer)getSqlMapClientTemplate().update("pg_update",sysDictForm)).equals(0)?false:true;
				}
				/**
				 * 
				 *  @Description    : 项目申请阶段性目标表删除
				 *  @Method_Name    : noticeIssue
				 *  @param sysDictForm
				 *  @return 
				 *  @return         : boolean
				 */
				public boolean pgDelete(String[] str)throws SQLException{
					boolean bl = false;
					SqlMapClient sqlMapClient = getSqlMapClient();
					try {
						//开启一个事务
						sqlMapClient.startTransaction();
						for(int i = 0 ; i<str.length ; i++){
							sqlMapClient.update("pg_delete",str[i]);
						}
						sqlMapClient.commitTransaction();
						bl = true;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						//事务回滚
						sqlMapClient.getCurrentConnection().rollback();
						bl = false;
					}
					finally{
						sqlMapClient.endTransaction();
					}
					return bl;
				}
				/**
				 * 
				 *  @Description    : 明细预算表
				 *  @Method_Name    : bmxFindList
				 *  @param BMXBudgetMXForm
				 *  @return 
				 *  @return         : List
				 */
				public List bmxFindList(BMXBudgetMXForm sysDictItemForm){
					return getSqlMapClientTemplate().queryForList("bmx_findList",sysDictItemForm);
				}
				/**
				 * 
				 *  @Description    : 明细预算表记录数
				 *  @Method_Name    : bmxFindSize
				 *  @param BMXBudgetMXForm
				 *  @return 
				 *  @return         : Integer
				 */
				public Integer bmxFindSize(BMXBudgetMXForm sysDictItemForm){
					return (Integer)getSqlMapClientTemplate().queryForObject("bmx_findSize",sysDictItemForm);
				}
				/**
				 * 
				 *  @Description    : 新增明细预算表
				 *  @Method_Name    : bmxAdd
				 *  @param BMXBudgetMXForm
				 *  @return 
				 *  @return         : boolean
				 */
				public boolean bmxAdd(BMXBudgetMXForm sysDictItemForm){
					String count = (String) getSqlMapClientTemplate().insert("bmx_add", sysDictItemForm);
					if(count != null && !"".equals(count)){
						return true;
					}else{
						return false;
					}
				}
				
				/**
				 * 
				 *  @Description    : 移除
				 *  @Method_Name    : immigration
				 *  @param bmxForm 明细预算表
				 *  @param ub_sno 联合表主键主键
				 *  @param name 修改人
				 *  @return
				 *  @throws Exception 
				 *  @return         : boolean
				 */
				public boolean immigration(BMXBudgetMXForm bmxForm,String ub_sno,String name)throws Exception{
					UBUnitBudgetForm ubForm = new UBUnitBudgetForm();
					boolean bl = false;
					SqlMapClient sqlMapClient = getSqlMapClient();
					try {
						//开启一个事务
						sqlMapClient.startTransaction();
						ubForm.setUb_sid(ub_sno.trim());
						ubForm.setUb_sreplyby(name);
						ubForm.setUb_nplanname(bmxForm.getBmx_splanname().trim());
						ubForm.setUb_nunitprice(bmxForm.getBmx_unitprice());
						ubForm.setUb_ncount(bmxForm.getBmx_ncount());
						ubForm.setUb_ntotal(bmxForm.getBmx_ntotal());
						sqlMapClient.insert("ub_add",ubForm);
						bmxForm.setUb_sid(ub_sno.trim());
						sqlMapClient.update("bmx_updateFK",bmxForm);
						sqlMapClient.commitTransaction();
						bl = true;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						//事务回滚
						sqlMapClient.getCurrentConnection().rollback();
						bl = false;
					}
					finally{
						sqlMapClient.endTransaction();
					}
					return bl;
				}
				/**
				 * 
				 *  @Description    : 移除
				 *  @Method_Name    : cancel
				 *  @param bmx_sid 明细预算表主键
				 *  @return
				 *  @throws Exception 
				 *  @return         : boolean
				 */
				public boolean cancel(String bmx_sid)throws Exception{
					BMXBudgetMXForm bmxForm = new BMXBudgetMXForm();
					bmxForm.setBmx_sid(bmx_sid.trim());
					bmxForm.setUb_sid("");
					return ((Integer)getSqlMapClientTemplate().update("bmx_updateFK",bmxForm)).equals(0)?false:true;
				}
				/**
				 * 
				 *  @Description    : 联合
				 *  @Method_Name    : uniteDeal
				 *  @param bmx_sid 明细预算表主键
				 *  @param ub_sid  联合表主键主键
				 *  @param big 明细预算表总金额
				 *  @return
				 *  @throws Exception 
				 *  @return         : boolean
				 */
				public boolean uniteDeal(String bmx_sid,String ub_sid,BigDecimal big)throws Exception{
					UBUnitBudgetForm ubForm = new UBUnitBudgetForm();
					UBUnitBudget ub = new UBUnitBudget();
					if(bmx_sid.indexOf(",") != -1){
						String[] bmx_sids = bmx_sid.split(",");
						for(int i = 0 ; i < bmx_sids.length ;i++){
							if(bmx_sids[i] != null && !"".equals(bmx_sids[i])){
								BMXBudgetMXForm form = new BMXBudgetMXForm();
								form.setBmx_sid(bmx_sids[i].trim());
								form.setUb_sid(ub_sid.trim());
								getSqlMapClientTemplate().update("bmx_updateFK",form);
							}
						}
					}else{
						BMXBudgetMXForm form = new BMXBudgetMXForm();
						form.setBmx_sid(bmx_sid.trim());
						form.setUb_sid(ub_sid.trim());
						getSqlMapClientTemplate().update("bmx_updateFK",form);
					}
					ub = (UBUnitBudget) getSqlMapClientTemplate().queryForList("ub_findList",ubForm).get(0);
					BigDecimal ub_nunitprice = big.divide(ub.getUb_ncount());
					UBUnitBudgetForm ubForm1 = new UBUnitBudgetForm();
					ubForm1.setUb_sid(ub_sid.trim());
					ubForm1.setUb_nunitprice(ub_nunitprice);
					ubForm1.setUb_ntotal(big);
					return ((Integer)getSqlMapClientTemplate().update("ub_updateFK",ubForm1)).equals(0)?false:true;
				}
				/**
				 * 
				 *  @Description    : 修改明细预算表
				 *  @Method_Name    : bmxUpdate
				 *  @param BMXBudgetMXForm
				 *  @return 
				 *  @return         : boolean
				 */
					public boolean bmxUpdate(BMXBudgetMXForm sysDictForm){
						return ((Integer)getSqlMapClientTemplate().update("bmx_update",sysDictForm)).equals(0)?false:true;
					}
					/**
					 * 
					 *  @Description    : 明细预算表删除
					 *  @Method_Name    : bmxDelete
					 *  @param String
					 *  @return 
					 *  @return         : boolean
					 */
					public boolean bmxDelete(String[] str)throws SQLException{
						boolean bl = false;
						SqlMapClient sqlMapClient = getSqlMapClient();
						try {
							//开启一个事务
							sqlMapClient.startTransaction();
							for(int i = 0 ; i<str.length ; i++){
								sqlMapClient.update("bmx_delete",str[i]);
							}
							sqlMapClient.commitTransaction();
							bl = true;
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							//事务回滚
							sqlMapClient.getCurrentConnection().rollback();
							bl = false;
						}
						finally{
							sqlMapClient.endTransaction();
						}
						return bl;
					}
					/**
					 * 
					 *  @Description    : 联合评审预算表
					 *  @Method_Name    : ubFindList
					 *  @param UBUnitBudgetForm
					 *  @return 
					 *  @return         : List
					 */
					public List ubFindList(UBUnitBudgetForm sysDictItemForm){
						return getSqlMapClientTemplate().queryForList("ub_findList",sysDictItemForm);
					}
					/**
					 * 
					 *  @Description    :联合评审预算表记录数
					 *  @Method_Name    : ubFindSize
					 *  @param UBUnitBudgetForm
					 *  @return 
					 *  @return         : Integer
					 */
					public Integer ubFindSize(UBUnitBudgetForm sysDictItemForm){
						return (Integer)getSqlMapClientTemplate().queryForObject("ub_findSize",sysDictItemForm);
					}
					/**
					 * 
					 *  @Description    : 新增联合评审预算表
					 *  @Method_Name    : ubAdd
					 *  @param UBUnitBudgetForm
					 *  @return 
					 *  @return         : boolean
					 */
					public boolean ubAdd(UBUnitBudgetForm sysDictItemForm){
						String count = (String) getSqlMapClientTemplate().insert("ub_add", sysDictItemForm);
						if(count != null && !"".equals(count)){
							return true;
						}else{
							return false;
						}
					}
					/**
					 * 
					 *  @Description    : 联合评审预算表通知
					 *  @Method_Name    : ubUpdate
					 *  @param UBUnitBudgetForm
					 *  @return 
					 *  @return         : boolean
					 */
						public boolean ubUpdate(UBUnitBudgetForm sysDictForm){
							return ((Integer)getSqlMapClientTemplate().update("ub_update",sysDictForm)).equals(0)?false:true;
						}
						/**
						 * 
						 *  @Description    : 联合评审预算表删除
						 *  @Method_Name    : ubDelete
						 *  @param String
						 *  @return 
						 *  @return         : boolean
						 */
						public boolean ubDelete(String[] str)throws SQLException{
							boolean bl = false;
							SqlMapClient sqlMapClient = getSqlMapClient();
							try {
								//开启一个事务
								sqlMapClient.startTransaction();
								for(int i = 0 ; i<str.length ; i++){
									sqlMapClient.update("ub_delete",str[i]);
								}
								
								sqlMapClient.commitTransaction();
								bl = true;
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								//事务回滚
								sqlMapClient.getCurrentConnection().rollback();
								bl = false;
							}
							finally{
								sqlMapClient.endTransaction();
							}
							return bl;
						}
						
						/**
						 * 
						 *  @Description    : 专家（人员）表
						 *  @Method_Name    : ubFindList
						 *  @param UBUnitBudgetForm
						 *  @return 
						 *  @return         : List
						 */
						public List slFindList(SlSpecialistForm sysDictItemForm){
							return getSqlMapClientTemplate().queryForList("sl_findList",sysDictItemForm);
						}
						/**
						 * 
						 *  @Description    :专家（人员）表记录数
						 *  @Method_Name    : ubFindSize
						 *  @param UBUnitBudgetForm
						 *  @return 
						 *  @return         : Integer
						 */
						public Integer slFindSize(SlSpecialistForm sysDictItemForm){
							return (Integer)getSqlMapClientTemplate().queryForObject("sl_findSize",sysDictItemForm);
						}
						/**
						 * 
						 *  @Description    : 专家（人员）表表
						 *  @Method_Name    : ubAdd
						 *  @param UBUnitBudgetForm
						 *  @return 
						 *  @return         : boolean
						 */
						public boolean slAdd(SlSpecialistForm sysDictItemForm){
							String count = (String) getSqlMapClientTemplate().insert("sl_add", sysDictItemForm);
							if(count != null && !"".equals(count)){
								return true;
							}else{
								return false;
							}
						}
						/**
						 * 
						 *  @Description    : 专家（人员）表通知
						 *  @Method_Name    : ubUpdate
						 *  @param UBUnitBudgetForm
						 *  @return 
						 *  @return         : boolean
						 */
							public boolean slUpdate(SlSpecialistForm sysDictForm){
								return ((Integer)getSqlMapClientTemplate().update("sl_update",sysDictForm)).equals(0)?false:true;
							}
							/**
							 * 
							 *  @Description    : 专家（人员）表删除
							 *  @Method_Name    : ubDelete
							 *  @param String
							 *  @return 
							 *  @return         : boolean
							 */
							public boolean slDelete(String[] str)throws SQLException{
								boolean bl = false;
								SqlMapClient sqlMapClient = getSqlMapClient();
								try {
									//开启一个事务
									sqlMapClient.startTransaction();
									for(int i = 0 ; i<str.length ; i++){
										sqlMapClient.update("sl_delete",str[i]);
									}
									
									sqlMapClient.commitTransaction();
									bl = true;
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									//事务回滚
									sqlMapClient.getCurrentConnection().rollback();
									bl = false;
								}
								finally{
									sqlMapClient.endTransaction();
								}
								return bl;
							}
							/**
							 * 
							 *  @Description    : 项目申请支出预算
							 *  @Method_Name    : abFindList
							 *  @param UBUnitBudgetForm
							 *  @return 
							 *  @return         : List
							 */
							public List abFindList(AbApproBudgetForm sysDictItemForm){
								return getSqlMapClientTemplate().queryForList("ab_findList",sysDictItemForm);
							}
							/**
							 * 
							 *  @Description    :专家（人员）表记录数
							 *  @Method_Name    : ubFindSize
							 *  @param UBUnitBudgetForm
							 *  @return 
							 *  @return         : Integer
							 */
							public Integer abFindSize(AbApproBudgetForm sysDictItemForm){
								return (Integer)getSqlMapClientTemplate().queryForObject("ab_findSize",sysDictItemForm);
							}
							/**
							 * 
							 *  @Description    : 项目申请支出预算
							 *  @Method_Name    : ubAdd
							 *  @param UBUnitBudgetForm
							 *  @return 
							 *  @return         : boolean
							 */
							public boolean abAdd(AbApproBudgetForm sysDictItemForm){
								String count = (String) getSqlMapClientTemplate().insert("ab_add", sysDictItemForm);
								if(count != null && !"".equals(count)){
									return true;
								}else{
									return false;
								}
							}
							/**
							 * 
							 *  @Description    : 项目申请支出预算
							 *  @Method_Name    : ubUpdate
							 *  @param UBUnitBudgetForm
							 *  @return 
							 *  @return         : boolean
							 */
								public boolean abUpdate(AbApproBudgetForm sysDictForm){
									return ((Integer)getSqlMapClientTemplate().update("ab_update",sysDictForm)).equals(0)?false:true;
								}
								/**
								 * 
								 *  @Description    : 项目申请支出预算删除
								 *  @Method_Name    : ubDelete
								 *  @param String
								 *  @return 
								 *  @return         : boolean
								 */
								public boolean abDelete(String str)throws SQLException{
									return ((Integer)getSqlMapClientTemplate().update("ab_delete",str)).equals(0)?false:true;
									
								}
								/**
								 * 
								 *  @Description    : 项目可行性附表
								 *  @Method_Name    : ubFindList
								 *  @param UBUnitBudgetForm
								 *  @return 
								 *  @return         : List
								 */
								public List fbFindList(FbFeasibilityForm sysDictItemForm){
									return getSqlMapClientTemplate().queryForList("fb_findList",sysDictItemForm);
								}
								/**
								 * 
								 *  @Description    :项目可行性附表记录数
								 *  @Method_Name    : ubFindSize
								 *  @param UBUnitBudgetForm
								 *  @return 
								 *  @return         : Integer
								 */
								public Integer fbFindSize(FbFeasibilityForm sysDictItemForm){
									return (Integer)getSqlMapClientTemplate().queryForObject("fb_findSize",sysDictItemForm);
								}
								/**
								 * 
								 *  @Description    : 项目可行性附表
								 *  @Method_Name    : ubAdd
								 *  @param UBUnitBudgetForm
								 *  @return 
								 *  @return         : boolean
								 */
								public boolean fbAdd(FbFeasibilityForm sysDictItemForm){
									String count = (String) getSqlMapClientTemplate().insert("fb_add", sysDictItemForm);
									if(count != null && !"".equals(count)){
										return true;
									}else{
										return false;
									}
								}
								/**
								 * 
								 *  @Description    : 项目可行性附表
								 *  @Method_Name    : ubUpdate
								 *  @param UBUnitBudgetForm
								 *  @return 
								 *  @return         : boolean
								 */
									public boolean fbUpdate(FbFeasibilityForm sysDictForm){
										return ((Integer)getSqlMapClientTemplate().update("fb_update",sysDictForm)).equals(0)?false:true;
									}
									/**
									 * 
									 *  @Description    : 项目可行性附表删除
									 *  @Method_Name    : ubDelete
									 *  @param String
									 *  @return 
									 *  @return         : boolean
									 */
									public boolean fbDelete(String str)throws SQLException{
										return ((Integer)getSqlMapClientTemplate().update("fb_delete",str)).equals(0)?false:true;
										
									}
									/**
									 * 
									 *  @Description    : 附件表
									 *  @Method_Name    : ubFindList
									 *  @param UBUnitBudgetForm
									 *  @return 
									 *  @return         : List
									 */
									public List asFindList(AsAccessoryForm sysDictItemForm){
										return getSqlMapClientTemplate().queryForList("as_findList",sysDictItemForm);
									}
									/**
									 * 
									 *  @Description    :附件表
									 *  @Method_Name    : ubFindSize
									 *  @param UBUnitBudgetForm
									 *  @return 
									 *  @return         : Integer
									 */
									public Integer asFindSize(AsAccessoryForm sysDictItemForm){
										return (Integer)getSqlMapClientTemplate().queryForObject("as_findSize",sysDictItemForm);
									}
									/**
									 * 
									 *  @Description    : 附件表
									 *  @Method_Name    : ubAdd
									 *  @param UBUnitBudgetForm
									 *  @return 
									 *  @return         : boolean
									 */
									public boolean asAdd(AsAccessoryForm form){
										boolean bl = true;
										SqlMapClient sqlMapClient = getSqlMapClient();
										try {
											//开启一个事务
											sqlMapClient.startTransaction();
											String as_sid = form.getAs_sid();
											if(as_sid != null && as_sid != "" ){//修改附件表
												//sqlMapClient.delete("as_delete1", form.getRp_sprojectno());
												String[] str3 = as_sid.split(",");
												String[] sname = form.getAs_sname().split(",");
												String[] surl = form.getAs_surl().split(",");
												String[] dtime = form.getAs_dtime().split(",");
												String[] as_sperson = form.getAs_sperson().split(",");
												for(int i = 0 ; i<str3.length ; i++){
													AsAccessoryForm asfrom = new AsAccessoryForm();
													asfrom.setEp_sid(form.getEp_sid().trim());//项目编码
													asfrom.setOrg_sno(form.getOrg_sno().trim());//所属单位
													asfrom.setAs_sreplyby(form.getAs_sreplyby().trim());//
													asfrom.setAs_sid(str3[i].trim().trim());//as_sid	编号
													asfrom.setAs_ntype(form.getAs_ntype().trim());//as_ntype	类型
													asfrom.setAs_sname(sname[i].trim().trim());//as_sname	名称
													asfrom.setAs_surl(surl[i].trim().trim());//as_surl	路径
													asfrom.setAs_sperson(as_sperson[i].trim());//上传人
													//asfrom.setAs_sreplyby(form.getAs_sreplyby());//	创建人
													asfrom.setAs_dtime(dtime[i].trim());//as_dtime	上传时间
													sqlMapClient.insert("as_add",asfrom);
												}
											}
											sqlMapClient.commitTransaction();
											return true;
										} catch (SQLException e) {
											e.printStackTrace();
											//事务回滚
											try {
												sqlMapClient.getCurrentConnection().rollback();
											} catch (SQLException e1) {
												e1.printStackTrace();
											}
											return false;
										}
										finally{
											try {
												sqlMapClient.endTransaction();
											} catch (SQLException e) {
												e.printStackTrace();
											}
										}
									}
									/**
									 * 
									 *  @Description    : 附件表
									 *  @Method_Name    : ubUpdate
									 *  @param UBUnitBudgetForm
									 *  @return 
									 *  @return         : boolean
									 */
										public boolean asUpdate(AsAccessoryForm sysDictForm){
											return ((Integer)getSqlMapClientTemplate().update("as_update",sysDictForm)).equals(0)?false:true;
										}
										/**
										 * 
										 *  @Description    : 附件表删除
										 *  @Method_Name    : ubDelete
										 *  @param String
										 *  @return 
										 *  @return         : boolean
										 */
										public boolean asDelete(String str)throws SQLException{
											return ((Integer)getSqlMapClientTemplate().update("as_delete",str)).equals(0)?false:true;
											
										}
	 /**
	  * 
	  *  @Description    : 申报子表
	  *  @Method_Name    : rpSonFindList
	  *  @param sysDictItemForm
	  *  @return 
	  *  @return         : List
	  */
			public List rpSonFindList(RpReportSonForm sysDictItemForm){
				return getSqlMapClientTemplate().queryForList("rpSon_findList",sysDictItemForm);
			}
			 /**
			  * 
			  *  @Description    : 查出所有的表头
			  *  @Method_Name    : rpSonFindList
			  *  @param sysDictItemForm
			  *  @return 
			  *  @return         : List
			  */
		public List rpSonFindBT(RpReportSonForm sysDictItemForm){
				return getSqlMapClientTemplate().queryForList("rpSon_findBT",sysDictItemForm);
		}
	/**
	 * 
	 *  @Description    : 计算其他附表的个数
	 *  @Method_Name    : rpSonFindSize
	 *  @param sysDictItemForm
	 *  @return 
	 *  @return         : Integer
	 */
			public Integer rpSonFindSize(RpReportSonForm sysDictItemForm){
				return (Integer)getSqlMapClientTemplate().queryForObject("rpSon_findSize",sysDictItemForm);
			}
		/**
		 * 
		 *  @Description    : 新增表头
		 *  @Method_Name    : rpSonAddBT
		 *  @param sysDictItemForm
		 *  @return 
		 *  @return         : boolean
		 */
		public boolean rpSonAddBT(RpReportSonForm sysDictItemForm){
			return ((Integer) getSqlMapClientTemplate().insert("rpSon_addBT", sysDictItemForm)).equals(0)?false:true;
		}
		/**
		 * 
		 *  @Description    : 新增子申报
		 *  @Method_Name    : rpSonAddBT
		 *  @param sysDictItemForm
		 *  @return 
		 *  @return         : boolean
		 */
		public boolean rpSonAdd(RpReportSonForm sysDictItemForm){
			return ((Integer) getSqlMapClientTemplate().insert("rpSon_add", sysDictItemForm)).equals(0)?false:true;
		}
		/**
		 * 
		 *  @Description    : 修改表头
		 *  @Method_Name    : rpSonAddBT
		 *  @param sysDictItemForm
		 *  @return 
		 *  @return         : boolean
		 */
		public boolean rpSonUpdateBT(RpReportSonForm form){
			boolean bl = false;
			SqlMapClient sqlMapClient = getSqlMapClient();
			try {
				//开启一个事务
				sqlMapClient.startTransaction();
				String[] rpson_nid = form.getRpson_nids().split(",");
				for(int i = 0 ; i < rpson_nid.length ; i++){
					RpReportSonForm form1 = new RpReportSonForm();
					form1.setRpson_nid(Integer.parseInt(rpson_nid[i]));
					form1.setRpson_sdef1(form.getRpson_sdef1());
					form1.setRpson_salterby(form.getRpson_salterby());
					sqlMapClient.update("rpSon_updateBT", form1);
				}
				sqlMapClient.commitTransaction();
				bl = true;
			} catch (SQLException e) {
				e.printStackTrace();
				//事务回滚
				bl = false;
				try {
					sqlMapClient.getCurrentConnection().rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			finally{
				try {
					sqlMapClient.endTransaction();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return bl;
		}
		/**
		 * 
		 *  @Description    : 删除表头
		 *  @Method_Name    : rpSonAddBT
		 *  @param sysDictItemForm
		 *  @return 
		 *  @return         : boolean
		 */
		public boolean rpSonDeleteBT(RpReportSonForm form){
			boolean bl = false;
			SqlMapClient sqlMapClient = getSqlMapClient();
			try {
				//开启一个事务
				sqlMapClient.startTransaction();
				String[] rpson_nid = form.getRpson_nids().split(",");
				for(int i = 0 ; i < rpson_nid.length ; i++){
					sqlMapClient.delete("rpSon_deleteBT", Integer.parseInt(rpson_nid[i]));
				}
				sqlMapClient.commitTransaction();
				bl = true;
			} catch (SQLException e) {
				e.printStackTrace();
				//事务回滚
				bl = false;
				try {
					sqlMapClient.getCurrentConnection().rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			finally{
				try {
					sqlMapClient.endTransaction();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return bl;
		}
		/**
		 *  @Description    : 归口单位审核
		 *  @Method_Name    : rpUpdateGkdwsh
		 *  @param form
		 *  @return         : boolean
		 */
		public boolean rpUpdateGkdwsh(RpReportForm form){
			return ((Integer)getSqlMapClientTemplate().update("rp_updateGKDW", form)).equals(0)?false:true;
		}
		/**
		 * 
		 *  @Description    : 项目子表修改
		 *  @Method_Name    : rpSonUpdate
		 *  @param sysDictForm
		 *  @return 
		 *  @return         : boolean
		 */
		public boolean rpSonUpdate(RpReportSonForm sysDictForm){
			return ((Integer)getSqlMapClientTemplate().update("rpSon_update",sysDictForm)).equals(0)?false:true;
		}
		/**
		 * 
		 *  @Description    : 项目子表删除
		 *  @Method_Name    : rpSonDelete
		 *  @param str
		 *  @return
		 *  @throws SQLException 
		 *  @return         : boolean
		 */
		public boolean rpSonDelete(Integer str)throws SQLException{
			return ((Integer)getSqlMapClientTemplate().update("rpSon_delete",str)).equals(0)?false:true;
		}
		/**
		 *  @Description    : 删除附件信息
		 *  @Method_Name    : rpSonDelete
		 *  @param str
		 *  @return         : boolean
		 */
		public boolean asDeleteByno(String str){
			return ((Integer)getSqlMapClientTemplate().update("as_deleteByno",str)).equals(0)?false:true;
		}
		/**
		 *  @Description    : 项目库归口单位：项目排序
		 *  @Method_Name    : saveGkRank
		 *  @param rp_sid 申报编号
		 *  @param rp_nnd 记录归口排序序号
		 *  @return         : boolean
		 */
		public boolean saveGkRank(String rp_sid,String rp_nnd){
			boolean bl = false;
			SqlMapClient sqlMapClient = getSqlMapClient();
			try {
				//开启一个事务
				sqlMapClient.startTransaction();
				String[] rp_sids = rp_sid.split(",");
				String[] rp_nnds = rp_nnd.split(","); 
				for(int i = 0 ; i < rp_sids.length ; i++){
					java.util.HashMap<String, String> map = new HashMap<String, String>();
					map.put("rp_sid", rp_sids[i].trim());
					map.put("rp_ndef1", rp_nnds[i].trim());
					sqlMapClient.update("rp_saveGkRank", map);
				}
				sqlMapClient.commitTransaction();
				bl = true;
			} catch (SQLException e) {
				e.printStackTrace();
				//事务回滚
				bl = false;
				try {
					sqlMapClient.getCurrentConnection().rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			finally{
				try {
					sqlMapClient.endTransaction();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return bl;
		}
		/**
		 *  @Description    : 项目库归口单位：项目排序
		 *  @Method_Name    : saveGkRank
		 *  @param rp_sid 申报编号
		 *  @param rp_nnd 记录归口排序序号
		 *  @return         : boolean
		 */
		public boolean saveSchoolRank(String rp_sid,String rp_nnd){
			boolean bl = false;
			SqlMapClient sqlMapClient = getSqlMapClient();
			try {
				//开启一个事务
				sqlMapClient.startTransaction();
				String[] rp_sids = rp_sid.split(",");
				String[] rp_nnds = rp_nnd.split(","); 
				for(int i = 0 ; i < rp_sids.length ; i++){
					java.util.HashMap<String, String> map = new HashMap<String, String>();
					map.put("rp_sid", rp_sids[i].trim());
					map.put("rp_sdef15", rp_nnds[i].trim());
					sqlMapClient.update("rp_saveSchoolRank", map);
				}
				sqlMapClient.commitTransaction();
				bl = true;
			} catch (SQLException e) {
				e.printStackTrace();
				//事务回滚
				bl = false;
				try {
					sqlMapClient.getCurrentConnection().rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			finally{
				try {
					sqlMapClient.endTransaction();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return bl;
		}
		/**
		 *  @Description    : 查询金额分配主表
		 *  @Method_Name    : dmzFind
		 *  @param from
		 *  @return         : List
		 */
		public List dmzFind(DMZDivMoneyZForm from){
			return getSqlMapClientTemplate().queryForList("dmz_find",from );
		}
		/**
		 *  @Description    : 新增金额分配主表
		 *  @Method_Name    : dmzFind
		 *  @param from
		 *  @return         : List
		 */
		public boolean dmzInsert(DMZDivMoneyZForm from){
			 String count = (String) getSqlMapClientTemplate().insert("dmz_insert",from);
			 if(count != null && !"".equals(count)){
					return true;
				}else{
					return false;
				}
		}
		/**
		 *  @Description    : 查询金额分配主表
		 *  @Method_Name    : dmzFind
		 *  @param from
		 *  @return         : List
		 */
		public boolean dmzUpdate(DMZDivMoneyZForm from){
			return ((Integer)getSqlMapClientTemplate().update("dmz_update",from )).equals(0)?false:true;
		}
		/**
		 *  @Description    : 查询金额分配主表
		 *  @Method_Name    : dmzFind
		 *  @param from
		 *  @return         : List
		 */
		public boolean dmzDelete(DMZDivMoneyZForm from){
			return ((Integer)getSqlMapClientTemplate().delete("dmz_delete",from )).equals(0)?false:true;
		}
		/**
		 *  @Description    : 查询金额分配子表 
		 *  @Method_Name    : dmzFind
		 *  @param from
		 *  @return         : List
		 */
		public List dmfFind(DMFDivMoneyFForm from){
			return getSqlMapClientTemplate().queryForList("dmf_find",from );
		}
		/**
		 *  @Description    : 新增金额分配子表 
		 *  @Method_Name    : dmzFind
		 *  @param from
		 *  @return         : List
		 */
		public boolean dmfInsert(DMFDivMoneyFForm from){
			return getSqlMapClientTemplate().insert("dmf_insert",from )==null?false:true;
		}
		/**
		 *  @Description    : 修改金额分配子表 
		 *  @Method_Name    : dmzFind
		 *  @param from
		 *  @return         : List
		 */
		public boolean dmfUpdate(DMFDivMoneyFForm from){
			return ((Integer)getSqlMapClientTemplate().update("dmf_update",from )).equals(0)?false:true;
		}
		/**
		 *  @Description    : 删除金额分配子表
		 *  @Method_Name    : dmzFind
		 *  @param from
		 *  @return         : List
		 */
		public boolean dmfDelete(DMFDivMoneyFForm from){
			return ((Integer)getSqlMapClientTemplate().delete("dmf_delete",from )).equals(0)?false:true;
		}
		/**
		 *  @Description    : 查询所有批次
		 *  @Method_Name    : rpFindPC
		 *  @throws Exception 
		 *  @return         : List
		 */
		public List rpFindPC(){
			return getSqlMapClientTemplate().queryForList("rp_findPC");
		}
		/**
		 *  @Description    : 项目库归口单位：修改申报表中的项目资金来源总计（万元）信息
		 *  @Method_Name    : rpUpdateRpscometotal
		 *  @param 申报表主键
		 *  @param 资金来源总计（万元）
		 *  @return         : boolean
		 */
		public boolean rpUpdateRpscometotal(String rp_sid,String rp_scometotal){
			java.util.HashMap<String, String> map = new HashMap<String, String>();
			map.put("rp_sid", rp_sid);
			map.put("rp_scometotal", rp_scometotal);
			return ((Integer)getSqlMapClientTemplate().update("rp_updateRpscometotal", map)).equals(0)?false:true;
		}
		/**
		 *  @Description    : 金额分配
		 *  @Method_Name    : updateAllotMoney
		 *  @param form
		 *  @return 
		 *  @return         : boolean
		 */
		public boolean updateAllotMoney(RpReportForm form){
			//return ((Integer)getSqlMapClientTemplate().update("rp_updateAllotMoney", form)).equals(0)?false:true;
			boolean bl = false;
			SqlMapClient sqlMapClient = getSqlMapClient();
			try {
				//开启一个事务
				sqlMapClient.startTransaction();
				sqlMapClient.update("rp_updateAllotMoney", form);
				String bmx_sid = form.getBmx_sid();
				if(bmx_sid != null && bmx_sid != ""){//修改明细预算表.indexOf(",") != -1 
					sqlMapClient.delete("bmx_delete1", form.getRp_sprojectno());
					String[] str2 = bmx_sid.split(",");
					String[] bmx_ssort = form.getBmx_ssort().split(",");
					String[] bmx_splanname = form.getBmx_splanname().split(",");
					String[] bmx_sisxieyi = form.getBmx_sisxieyi().split(",");
					String[] bmx_sisimport = form.getBmx_sisimport().split(",");
					String[] bmx_unitprice = form.getBmx_unitprice().split(",");
					String[] bmx_ncount = form.getBmx_ncount().split(",");
					String[] bmx_sunit = form.getBmx_sunit().split(",");
					String[] bmx_smodel = form.getBmx_smodel().split(",");
					String[] bmx_srec = form.getBmx_srec().split(",");
					String[] bmx_sexetime = form.getBmx_sexetime().split(",");
					String[] bmx_ntotal = form.getBmx_ntotal().split(",");
					String[] bmx_sdef2 = form.getBmx_sdef2().split(",");//联合表中
					String[] bmx_sdef1 = form.getBmx_sdef1().split(",");//联合表中
					for(int i = 0 ; i<str2.length ; i++){
						BMXBudgetMXForm bmxform = new BMXBudgetMXForm();
						bmxform.setBmx_sid(str2[i].trim());//主键
						bmxform.setRp_sid(form.getRp_sid());//申报ID
						bmxform.setRp_sprojectno(form.getRp_sprojectno());//项目编码
						bmxform.setUd_sno(form.getOrg_sno());//所属单位
						bmxform.setBmx_syear(form.getRp_syear());//年度
						bmxform.setBmx_ssort(bmx_ssort[i].trim());//bmx_ssort	项目分类
						bmxform.setBmx_splanname(bmx_splanname[i].trim());//bmx_splanname	明细预算内容
						bmxform.setBmx_syear(bmx_sisxieyi[i].trim());//bmx_sisxieyi	是否协议采购
						bmxform.setBmx_sisimport(bmx_sisimport[i].trim());//bmx_sisimport	是否进口
						bmxform.setBmx_unitprice(BigDecimal.valueOf(Double.parseDouble(bmx_unitprice[i].trim())));//bmx_unitprice	单价
						bmxform.setBmx_ncount(BigDecimal.valueOf(Double.parseDouble(bmx_ncount[i].trim())));//bmx_ncount	数量
						bmxform.setBmx_sunit(bmx_sunit[i].trim());//bmx_sunit	单位
						bmxform.setBmx_smodel(bmx_smodel[i].trim());//bmx_smodel	规格型号
						bmxform.setBmx_srec(bmx_srec[i].trim());//bmx_srec	推荐供应商
						bmxform.setBmx_sexetime(bmx_sexetime[i].trim());//bmx_sexetime	执行时间
						bmxform.setBmx_ntotal(BigDecimal.valueOf(Double.parseDouble(bmx_ntotal[i].trim())));//bmx_total	总额
						bmxform.setBmx_sreplyby(form.getRp_sreplyby());
						bmxform.setBmx_sdef1(bmx_sdef1[i].trim());
						bmxform.setBmx_sdef2(bmx_sdef2[i].trim());
						if(form.getUb_sid() != null && form.getUb_sid() != ""){
							String[] ud_sid = form.getUb_sid().split(",");
							String[] ub_sdef1 = form.getUb_sdef1().split(",");//明细表中
							for(int j = 0 ; j < ud_sid.length ; j++){
								if(ub_sdef1[j].equals(bmx_sdef2[i]) ){
									bmxform.setUb_sid(ud_sid[j].trim());
								}
							}
						}
						sqlMapClient.update("bmx_add",bmxform);
					}
				}
				String ub_sid = form.getUb_sid();
				if(ub_sid != null && ub_sid != ""){//修改联合评审预算表
					sqlMapClient.delete("ub_delete1", form.getRp_sprojectno());
					String[] str3 = ub_sid.split(",");
					String[] nplanname = form.getUb_nplanname().split(",");
					String[] nunitprice = form.getUb_nunitprice().split(",");
					String[] ncount = form.getUb_ncount().split(",");
					String[] ntotal = form.getUb_ntotal().split(",");
					String[] ub_sdef1 = form.getUb_sdef1().split(",");//明细表中
					for(int i = 0 ; i<str3.length ; i++){
						UBUnitBudgetForm ubform = new UBUnitBudgetForm();
						ubform.setUb_sid(str3[i].trim());//主键
						ubform.setRp_sid(form.getRp_sid());//申报ID
						ubform.setRp_sprojectno(form.getRp_sprojectno());//项目编码
						ubform.setUd_sno(form.getOrg_sno());//所属单位
						ubform.setUb_syear(form.getRp_syear());//年度
						ubform.setUb_sreplyby(form.getRp_sreplyby());
						ubform.setUb_nplanname(nplanname[i].trim());//ub_nplanname	明细项目名称
						ubform.setUb_nunitprice(BigDecimal.valueOf(Double.parseDouble(nunitprice[i].trim())));//ub_nunitprice	单价
						ubform.setUb_ncount(BigDecimal.valueOf(Double.parseDouble(ncount[i].trim())));//ub_ncount	数量
						ubform.setUb_ntotal(BigDecimal.valueOf(Double.parseDouble(ntotal[i].trim())));//ub_ntotal	总额
						ubform.setUb_sdef1(ub_sdef1[i].trim());
						sqlMapClient.update("ub_add",ubform);
					}
				}
				String ab_sid = form.getAb_sid();
				if(ab_sid != null && ab_sid != ""){//修改项目申请支出预算
					sqlMapClient.delete("ab_delete1", form.getRp_sprojectno());
					String[] str3 = ab_sid.split(",");
					String[] sitems = form.getAb_sitems().split(",");
					String[] smoney = form.getAb_smoney().split(",");
					String[] ab_ssort = form.getAb_ssort().split(",");
					for(int j = 0 ; j<ab_ssort.length ; j++){
						if("0".equals(ab_ssort[j]) ){
							java.util.HashMap<String, String> map = new HashMap<String, String>();
							map.put("ab_ssort", "0");
							map.put("rp_sprojectno", form.getRp_sprojectno());
							sqlMapClient.delete("ab_delete1", map);
						}
						if("1".equals(ab_ssort[j]) ){
							java.util.HashMap<String, String> map = new HashMap<String, String>();
							map.put("ab_ssort", "1");
							map.put("rp_sprojectno", form.getRp_sprojectno());
							sqlMapClient.delete("ab_delete1", map);
						}
					}
					for(int i = 0 ; i<str3.length ; i++){
						AbApproBudgetForm abform = new AbApproBudgetForm();
						abform.setRp_sprojectno(form.getRp_sprojectno());//项目编码
						abform.setOrg_sno(form.getOrg_sno());//所属单位
						abform.setAb_sreplyby(form.getRp_sreplyby());
						abform.setAb_sitems(sitems[i].trim());//ab_sitems	预算项
						abform.setAb_smoney(BigDecimal.valueOf(Double.parseDouble(smoney[i].trim())));//ab_smoney	金额
						abform.setAb_sid(str3[i].trim());
						abform.setAb_ssort(ab_ssort[i].trim());
						sqlMapClient.update("ab_add",abform);
					}
				}
				sqlMapClient.commitTransaction();
				bl = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//事务回滚
				try {
					sqlMapClient.getCurrentConnection().rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				bl = false;
			}
			finally{
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
