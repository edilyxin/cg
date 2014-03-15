package com.rc.project.action;

import java.util.List;

import com.rc.util.BaseAction;
import com.rc.util.page.PageBean;

/**
 * 项目定义管理
 * @author edilyxin
 *
 */
public class PojectDeclare extends BaseAction {
	
	private List list;
	private String msg;//操作信息1
	private PageBean bean;//分页标签类
	
    /**
     * 初申请管理查询
     * @return
     * @throws Exception
     */
    public String findAndAuto() throws Exception{ 
		return "findAndAuto";
    	
    }

}
