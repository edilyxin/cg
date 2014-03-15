package com.rc.declare.service;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
import com.rc.declare.vo.UBUnitBudget;
public interface DeclareService {
	/**
	 * 
	 *  @Description    : class 类
	 *  @Method_Name    : noticeFindList
	 *  @param sysDictItemForm
	 *  @return 
	 *  @return         : List
	 */
	public List classFindList();
	
	/**
	 * 
	 *  @Description    : 项目申报通知
	 *  @Method_Name    : noticeFindList
	 *  @param sysDictItemForm
	 *  @return 
	 *  @return         : List
	 */
	public List noticeFindList(NiNoticeInfoForm sysDictItemForm);
	/**
	 * 
	 *  @Description    : 项目申报通知记录数
	 *  @Method_Name    : noticeFindSize
	 *  @param sysDictItemForm
	 *  @return 
	 *  @return         : Integer
	 */
	public Integer noticeFindSize(NiNoticeInfoForm sysDictItemForm);
	/**
	 * 
	 *  @Description    : 新增申报通知
	 *  @Method_Name    : noticeAdd
	 *  @param sysDictItemForm
	 *  @return 
	 *  @return         : boolean
	 */
	public boolean noticeAdd(NiNoticeInfoForm sysDictItemForm);
	/**
	 * 
	 *  @Description    : 修改申报通知
	 *  @Method_Name    : noticeUpdate
	 *  @param sysDictForm
	 *  @return 
	 *  @return         : boolean
	 */
		public boolean noticeUpdate(NiNoticeInfoForm sysDictForm);

		/**
		 * 
		 *  @Description    : 申报通知发布
		 *  @Method_Name    : noticeIssue
		 *  @param sysDictForm
		 *  @return 
		 *  @return         : boolean
		 */
		public boolean noticeIssue(String[] str)throws SQLException;
		/**
		 * 
		 *  @Description    : 申报通知删除
		 *  @Method_Name    : noticeDelete
		 *  @param String
		 *  @return 
		 *  @return         : boolean
		 */
		public boolean noticeDelete(String[] str)throws SQLException;
		/**
		 * 
		 *  @Description    : 方法描述
		 *  @Method_Name    : findUd
		 *  @param ud_nnumber 单位层次 单位层次：1学校2学院3系
		 *  @param ud_sdef16 是否归口单位,0否，1归口单位,必须2级单位
		 *  @return 
		 *  @return         : List
		 */
		public List findUd(String ud_nnumber,String ud_sdef16);
		/**
		 * 
		 *  @Description    : 项目申报表
		 *  @Method_Name    : rpFindList
		 *  @param RpReportForm
		 *  @return 
		 *  @return         : List
		 */
		public List rpFindList(RpReportForm sysDictItemForm);
		/**
		 * 
		 *  @Description    : 项目申报记录数
		 *  @Method_Name    : noticeFindSize
		 *  @param RpReportForm
		 *  @return 
		 *  @return         : Integer
		 */
		public Integer rpFindSize(RpReportForm sysDictItemForm);
		/**
		 * 
		 *  @Description    : 新增申报
		 *  @Method_Name    : rpAdd
		 *  @param RpReportForm
		 *  @return 
		 *  @return         : boolean
		 */
		public boolean rpAdd(RpReportForm sysDictItemForm);
		/**
		 * 
		 *  @Description    : 修改申报
		 *  @Method_Name    : rpUpdate
		 *  @param RpReportForm
		 *  @return 
		 *  @return         : boolean
		 */
		public boolean rpUpdate(RpReportForm sysDictForm);
			/**
			 * 
			 *  @Description    : 修改申报初审
			 *  @Method_Name    : rpUpdate
			 *  @param RpReportForm
			 *  @return 
			 *  @return         : boolean
			 */
		public boolean rpUpdate1(RpReportForm sysDictForm);
			/**
			 * 
			 *  @Description    : 修改申报通知状态
			 *  @Method_Name    : rpUpdateState
			 *  @param String
			 *  @return 
			 *  @return         : boolean
			 */
			public boolean rpUpdateState(String[] str,String state)throws SQLException;
			/**
			 * 
			 *  @Description    : 申报通知删除
			 *  @Method_Name    : rpDelete
			 *  @param String
			 *  @return 
			 *  @return         : boolean
			 */
			public boolean rpDelete(String[] str)throws SQLException;
			/**
			 * 
			 *  @Description    : 项目申请阶段性目标表
			 *  @Method_Name    : pgFindList
			 *  @param PgPerformanceGoalForm
			 *  @return 
			 *  @return         : List
			 */
			public List pgFindList(PgPerformanceGoalForm sysDictItemForm);
			/**
			 * 
			 *  @Description    : 项目申请阶段性目标表记录数
			 *  @Method_Name    : pgFindSize
			 *  @param sysDictItemForm
			 *  @return 
			 *  @return         : Integer
			 */
			public Integer pgFindSize(PgPerformanceGoalForm sysDictItemForm);
			/**
			 * 
			 *  @Description    : 新增项目申请阶段性目标表
			 *  @Method_Name    : pgAdd
			 *  @param PgPerformanceGoalForm
			 *  @return 
			 *  @return         : boolean
			 */
			public boolean pgAdd(PgPerformanceGoalForm sysDictItemForm);
			/**
			 * 
			 *  @Description    : 修改项目申请阶段性目标表
			 *  @Method_Name    : pgUpdate
			 *  @param PgPerformanceGoalForm
			 *  @return 
			 *  @return         : boolean
			 */
				public boolean pgUpdate(PgPerformanceGoalForm sysDictForm);
				/**
				 * 
				 *  @Description    : 项目申请阶段性目标表删除
				 *  @Method_Name    : noticeIssue
				 *  @param sysDictForm
				 *  @return 
				 *  @return         : boolean
				 */
				public boolean pgDelete(String[] str)throws SQLException;
				/**
				 * 
				 *  @Description    : 明细预算表
				 *  @Method_Name    : bmxFindList
				 *  @param BMXBudgetMXForm
				 *  @return 
				 *  @return         : List
				 */
				public List bmxFindList(BMXBudgetMXForm sysDictItemForm);
				/**
				 * 
				 *  @Description    : 明细预算表记录数
				 *  @Method_Name    : bmxFindSize
				 *  @param BMXBudgetMXForm
				 *  @return 
				 *  @return         : Integer
				 */
				public Integer bmxFindSize(BMXBudgetMXForm sysDictItemForm);
				/**
				 * 
				 *  @Description    : 新增明细预算表
				 *  @Method_Name    : bmxAdd
				 *  @param BMXBudgetMXForm
				 *  @return 
				 *  @return         : boolean
				 */
				public boolean bmxAdd(BMXBudgetMXForm sysDictItemForm);
				/**
				 * 
				 *  @Description    : 修改明细预算表
				 *  @Method_Name    : bmxUpdate
				 *  @param BMXBudgetMXForm
				 *  @return 
				 *  @return         : boolean
				 */
					public boolean bmxUpdate(BMXBudgetMXForm sysDictForm);
					/**
					 * 
					 *  @Description    : 明细预算表删除
					 *  @Method_Name    : bmxDelete
					 *  @param String
					 *  @return 
					 *  @return         : boolean
					 */
					public boolean bmxDelete(String[] str)throws SQLException;
					/**
					 * 
					 *  @Description    : 联合评审预算表
					 *  @Method_Name    : ubFindList
					 *  @param UBUnitBudgetForm
					 *  @return 
					 *  @return         : List
					 */
					public List ubFindList(UBUnitBudgetForm sysDictItemForm);
					/**
					 * 
					 *  @Description    :联合评审预算表记录数
					 *  @Method_Name    : ubFindSize
					 *  @param UBUnitBudgetForm
					 *  @return 
					 *  @return         : Integer
					 */
					public Integer ubFindSize(UBUnitBudgetForm sysDictItemForm);
					/**
					 * 
					 *  @Description    : 新增联合评审预算表
					 *  @Method_Name    : ubAdd
					 *  @param UBUnitBudgetForm
					 *  @return 
					 *  @return         : boolean
					 */
					public boolean ubAdd(UBUnitBudgetForm sysDictItemForm);
					/**
					 * 
					 *  @Description    : 联合评审预算表通知
					 *  @Method_Name    : ubUpdate
					 *  @param UBUnitBudgetForm
					 *  @return 
					 *  @return         : boolean
					 */
						public boolean ubUpdate(UBUnitBudgetForm sysDictForm);
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
						public boolean immigration(BMXBudgetMXForm bmxForm,String ub_sno,String name)throws Exception;
						/**
						 * 
						 *  @Description    : 移除
						 *  @Method_Name    : cancel
						 *  @param bmx_sid 明细预算表主键
						 *  @return
						 *  @throws Exception 
						 *  @return         : boolean
						 */
						public boolean cancel(String bmx_sid)throws Exception;
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
						public boolean uniteDeal(String bmx_sid,String ub_sid,BigDecimal big)throws Exception;
						/**
						 * 
						 *  @Description    : 联合评审预算表删除
						 *  @Method_Name    : ubDelete
						 *  @param String
						 *  @return 
						 *  @return         : boolean
						 */
						public boolean ubDelete(String[] str)throws SQLException;
						
						/**
						 * 
						 *  @Description    : 专家（人员）表
						 *  @Method_Name    : ubFindList
						 *  @param UBUnitBudgetForm
						 *  @return 
						 *  @return         : List
						 */
						public List slFindList(SlSpecialistForm sysDictItemForm);
						/**
						 * 
						 *  @Description    :专家（人员）表记录数
						 *  @Method_Name    : ubFindSize
						 *  @param UBUnitBudgetForm
						 *  @return 
						 *  @return         : Integer
						 */
						public Integer slFindSize(SlSpecialistForm sysDictItemForm);
						/**
						 * 
						 *  @Description    : 专家（人员）表表
						 *  @Method_Name    : ubAdd
						 *  @param UBUnitBudgetForm
						 *  @return 
						 *  @return         : boolean
						 */
						public boolean slAdd(SlSpecialistForm sysDictItemForm);
						/**
						 * 
						 *  @Description    : 专家（人员）表通知
						 *  @Method_Name    : ubUpdate
						 *  @param UBUnitBudgetForm
						 *  @return 
						 *  @return         : boolean
						 */
							public boolean slUpdate(SlSpecialistForm sysDictForm);
							/**
							 * 
							 *  @Description    : 专家（人员）表删除
							 *  @Method_Name    : ubDelete
							 *  @param String
							 *  @return 
							 *  @return         : boolean
							 */
							public boolean slDelete(String[] str)throws SQLException;
							/**
							 * 
							 *  @Description    : 项目申请支出预算
							 *  @Method_Name    : abFindList
							 *  @param UBUnitBudgetForm
							 *  @return 
							 *  @return         : List
							 */
							public List abFindList(AbApproBudgetForm sysDictItemForm);
							/**
							 * 
							 *  @Description    :专家（人员）表记录数
							 *  @Method_Name    : ubFindSize
							 *  @param UBUnitBudgetForm
							 *  @return 
							 *  @return         : Integer
							 */
							public Integer abFindSize(AbApproBudgetForm sysDictItemForm);
							/**
							 * 
							 *  @Description    : 项目申请支出预算
							 *  @Method_Name    : ubAdd
							 *  @param UBUnitBudgetForm
							 *  @return 
							 *  @return         : boolean
							 */
							public boolean abAdd(AbApproBudgetForm sysDictItemForm);
							/**
							 * 
							 *  @Description    : 项目申请支出预算
							 *  @Method_Name    : ubUpdate
							 *  @param UBUnitBudgetForm
							 *  @return 
							 *  @return         : boolean
							 */
								public boolean abUpdate(AbApproBudgetForm sysDictForm);
								/**
								 * 
								 *  @Description    : 项目申请支出预算删除
								 *  @Method_Name    : ubDelete
								 *  @param String
								 *  @return 
								 *  @return         : boolean
								 */
								public boolean abDelete(String str)throws SQLException;
								/**
								 * 
								 *  @Description    : 项目可行性附表
								 *  @Method_Name    : ubFindList
								 *  @param UBUnitBudgetForm
								 *  @return 
								 *  @return         : List
								 */
								public List fbFindList(FbFeasibilityForm sysDictItemForm);
								/**
								 * 
								 *  @Description    :项目可行性附表记录数
								 *  @Method_Name    : ubFindSize
								 *  @param UBUnitBudgetForm
								 *  @return 
								 *  @return         : Integer
								 */
								public Integer fbFindSize(FbFeasibilityForm sysDictItemForm);
								/**
								 * 
								 *  @Description    : 项目可行性附表
								 *  @Method_Name    : ubAdd
								 *  @param UBUnitBudgetForm
								 *  @return 
								 *  @return         : boolean
								 */
								public boolean fbAdd(FbFeasibilityForm sysDictItemForm);
								/**
								 * 
								 *  @Description    : 项目可行性附表
								 *  @Method_Name    : ubUpdate
								 *  @param UBUnitBudgetForm
								 *  @return 
								 *  @return         : boolean
								 */
									public boolean fbUpdate(FbFeasibilityForm sysDictForm);
									/**
									 * 
									 *  @Description    : 项目可行性附表删除
									 *  @Method_Name    : ubDelete
									 *  @param String
									 *  @return 
									 *  @return         : boolean
									 */
									public boolean fbDelete(String str)throws SQLException;
									/**
									 * 
									 *  @Description    : 附件表
									 *  @Method_Name    : ubFindList
									 *  @param UBUnitBudgetForm
									 *  @return 
									 *  @return         : List
									 */
									public List asFindList(AsAccessoryForm sysDictItemForm);
									/**
									 * 
									 *  @Description    :附件表
									 *  @Method_Name    : ubFindSize
									 *  @param UBUnitBudgetForm
									 *  @return 
									 *  @return         : Integer
									 */
									public Integer asFindSize(AsAccessoryForm sysDictItemForm);
									/**
									 * 
									 *  @Description    : 附件表
									 *  @Method_Name    : ubAdd
									 *  @param UBUnitBudgetForm
									 *  @return 
									 *  @return         : boolean
									 */
									public boolean asAdd(AsAccessoryForm sysDictItemForm);
									/**
									 * 
									 *  @Description    : 附件表
									 *  @Method_Name    : ubUpdate
									 *  @param UBUnitBudgetForm
									 *  @return 
									 *  @return         : boolean
									 */
										public boolean asUpdate(AsAccessoryForm sysDictForm);
										/**
										 * 
										 *  @Description    : 附件表删除
										 *  @Method_Name    : ubDelete
										 *  @param String
										 *  @return 
										 *  @return         : boolean
										 */
										public boolean asDelete(String str)throws SQLException;
	 /**
	  * 
	  *  @Description    : 申报子表
	  *  @Method_Name    : rpSonFindList
	  *  @param sysDictItemForm
	  *  @return 
	  *  @return         : List
	  */
			public List rpSonFindList(RpReportSonForm sysDictItemForm);
	/**
	 * 
	 *  @Description    : 申报子表
	 *  @Method_Name    : rpSonFindSize
	 *  @param sysDictItemForm
	 *  @return 
	 *  @return         : Integer
	 */
			public Integer rpSonFindSize(RpReportSonForm sysDictItemForm);

		/**
		 * 
		 *  @Description    : 项目子表修改
		 *  @Method_Name    : rpSonUpdate
		 *  @param sysDictForm
		 *  @return 
		 *  @return         : boolean
		 */
		public boolean rpSonUpdate(RpReportSonForm sysDictForm);
		/**
		 * 
		 *  @Description    : 项目子表删除
		 *  @Method_Name    : rpSonDelete
		 *  @param str
		 *  @return
		 *  @throws SQLException 
		 *  @return         : boolean
		 */
		public boolean rpSonDelete(Integer str)throws SQLException;
		/**
		 * 
		 *  @Description    : 新增子申报
		 *  @Method_Name    : rpSonAddBT
		 *  @param sysDictItemForm
		 *  @return 
		 *  @return         : boolean
		 */
		public boolean rpSonAdd(RpReportSonForm sysDictItemForm);
		/**
		 * 
		 *  @Description    : 新增表头
		 *  @Method_Name    : rpSonAddBT
		 *  @param sysDictItemForm
		 *  @return 
		 *  @return         : boolean
		 */
		public boolean rpSonAddBT(RpReportSonForm sysDictItemForm);
		 /**
		  * 
		  *  @Description    : 查出所有的表头
		  *  @Method_Name    : rpSonFindList
		  *  @param sysDictItemForm
		  *  @return 
		  *  @return         : List
		  */
	public List rpSonFindBT(RpReportSonForm sysDictItemForm);
		/**
		 * 
		 *  @Description    : 修改表头
		 *  @Method_Name    : rpSonAddBT
		 *  @param sysDictItemForm
		 *  @return 
		 *  @return         : boolean
		 */
		public boolean rpSonUpdateBT(RpReportSonForm sysDictItemForm);
		/**
		 * 
		 *  @Description    : 删除表头
		 *  @Method_Name    : rpSonAddBT
		 *  @param sysDictItemForm
		 *  @return 
		 *  @return         : boolean
		 */
		public boolean rpSonDeleteBT(RpReportSonForm sysDictItemForm);/**
		 *  @Description    : 归口单位审核
		 *  @Method_Name    : rpUpdateGkdwsh
		 *  @param form
		 *  @return         : boolean
		 */
		public boolean rpUpdateGkdwsh(RpReportForm form);
		
		/**
		 *  @Description    : 删除附件信息
		 *  @Method_Name    : rpSonDelete
		 *  @param str
		 *  @return         : boolean
		 */
		public boolean asDeleteByno(String str);
		/**
		 *  @Description    : 项目库归口单位：项目排序
		 *  @Method_Name    : saveGkRank
		 *  @param rp_sid 申报编号
		 *  @param rp_nnd 记录归口排序序号
		 *  @return         : boolean
		 */
		public boolean saveGkRank(String rp_sid,String rp_nnd);
		/**
		 *  @Description    : 项目库归口单位：项目排序
		 *  @Method_Name    : saveSchoolRank
		 *  @param rp_sid 申报编号
		 *  @param rp_nnd 记录归口排序序号
		 *  @return         : boolean
		 */
		public boolean saveSchoolRank(String rp_sid,String rp_nnd);
		/**
		 *  @Description    : 查询金额分配主表
		 *  @Method_Name    : dmzFind
		 *  @param from
		 *  @return         : List
		 */
		public List dmzFind(DMZDivMoneyZForm from);
		/**
		 *  @Description    : 新增金额分配主表
		 *  @Method_Name    : dmzFind
		 *  @param from
		 *  @return         : List
		 */
		public boolean dmzInsert(DMZDivMoneyZForm from);
		/**
		 *  @Description    : 查询金额分配主表
		 *  @Method_Name    : dmzFind
		 *  @param from
		 *  @return         : List
		 */
		public boolean dmzUpdate(DMZDivMoneyZForm from);
		/**
		 *  @Description    : 查询金额分配主表
		 *  @Method_Name    : dmzFind
		 *  @param from
		 *  @return         : List
		 */
		public boolean dmzDelete(DMZDivMoneyZForm from);
		/**
		 *  @Description    : 查询金额分配子表 
		 *  @Method_Name    : dmzFind
		 *  @param from
		 *  @return         : List
		 */
		public List dmfFind(DMFDivMoneyFForm from);
		/**
		 *  @Description    : 新增金额分配子表 
		 *  @Method_Name    : dmzFind
		 *  @param from
		 *  @return         : List
		 */
		public boolean dmfInsert(DMFDivMoneyFForm from);
		/**
		 *  @Description    : 修改金额分配子表 
		 *  @Method_Name    : dmzFind
		 *  @param from
		 *  @return         : List
		 */
		public boolean dmfUpdate(DMFDivMoneyFForm from);
		/**
		 *  @Description    : 删除金额分配子表
		 *  @Method_Name    : dmzFind
		 *  @param from
		 *  @return         : List
		 */
		public boolean dmfDelete(DMFDivMoneyFForm from);
		/**
		 *  @Description    : 查询所有批次
		 *  @Method_Name    : rpFindPC
		 *  @throws Exception 
		 *  @return         : List
		 */
		public List rpFindPC();
		/**
		 *  @Description    : 项目库归口单位：修改申报表中的项目资金来源总计（万元）信息
		 *  @Method_Name    : rpUpdateRpscometotal
		 *  @param 申报表主键
		 *  @param 资金来源总计（万元）
		 *  @return         : boolean
		 */
		public boolean rpUpdateRpscometotal(String rp_sid,String rp_scometotal);
		/**
		 *  @Description    : 金额分配
		 *  @Method_Name    : updateAllotMoney
		 *  @param form
		 *  @return 
		 *  @return         : boolean
		 */
		public boolean updateAllotMoney(RpReportForm form);
}
