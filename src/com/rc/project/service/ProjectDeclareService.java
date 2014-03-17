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
    public List<RpReportBegin> findAndAuto(RpReportBeginForm pForm);
    
    /**
     * 查询结果数
     * @param pForm
     * @return
     */
    public int findSize(RpReportBeginForm pForm);
}
