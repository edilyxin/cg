package com.rc.project.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.rc.project.dao.RpReportBeginDAO;
import com.rc.project.form.PojectDeclareForm;
import com.rc.project.form.RpReportBeginForm;
import com.rc.project.service.ProjectDeclareService;
import com.rc.project.vo.RpReportBegin;
import com.rc.project.vo.RpReportBeginExample;

public class ProjectDeclareServiceImpl implements ProjectDeclareService {

	private RpReportBeginDAO rpReportBeginDAO;
	private RpReportBeginExample example;
	private String filepath;    //文档路径
	private String filename;    //文档名称
	

	public void setRpReportBeginDAO(RpReportBeginDAO rpReportBeginDAO) {
		this.rpReportBeginDAO = rpReportBeginDAO;
	}

	@Override
	public List<RpReportBegin> findAndAuto(RpReportBeginForm pForm) {
		return this.rpReportBeginDAO.selectByPage(pForm);
	}

	@Override
	public int findSize(RpReportBeginForm pForm) {
		return this.rpReportBeginDAO.selectSize(pForm);
	}

	@Override
	public int importData(RpReportBeginForm pForm) {
		importExcl("sdfdfd");
		return 0;
	}
	
	private int importExcl(String filename){
		//获取excel文件
		final String path = "import/20140318000001/初申报项目汇总表.xls";
		try {
			Workbook book = Workbook.getWorkbook(new File(path));
			
			Sheet sheet = book.getSheet(0);
			
			int rows = sheet.getRows();
			int cols = sheet.getColumns();
			
			System.out.println("rows : " +rows + " cols:" + cols);
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//按照模板匹配文件
		
		return 0;
	}
	
	public static void main(String[] args){
		ProjectDeclareServiceImpl p = new ProjectDeclareServiceImpl();
		p.importData(null);
	}
}
