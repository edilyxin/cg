package com.rc.project.service;

import java.util.List;

import com.rc.project.form.RpReportBeginForm;
import com.rc.project.vo.RpReportBegin;

public interface ProjectDeclareService {
    /**
     * 查询初申报表内容
     * @param pForm
     * @return
     */
    public List<RpReportBegin> findAndAuto(RpReportBeginForm pForm) throws Exception;
    
    /**
     * 查询结果数
     * @param pForm
     * @return
     */
    public int findSize(RpReportBeginForm pForm) throws Exception;
    
    /**
     * 通过配置的地址导入excel文件，检查是否是合法的文件
     * 合法检查
     * 1，检查项目名称的重复(同年，同人，同部门不可以有相同的名称)
     * 2，院系与部门表关联
     * 3，项目负责人和员工表关联，注意同名，则按院系和项目负责人进行匹配，该负责人要属于该院系
     * @param pForm 上传的文件名称，上传路径不能为空
     * @return
     */
    public int importData(RpReportBeginForm pForm) throws Exception;
}
