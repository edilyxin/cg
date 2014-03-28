package com.rc.project.action;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.rc.demo.form.DemoForm;
import com.rc.project.form.EpEntrancecForm;
import com.rc.project.service.ProjectService;
import com.rc.project.vo.EpEntrancec;
import com.rc.util.BaseAction;
import com.rc.util.page.PageBean;

public class EntranceCAction extends BaseAction {

	private EpEntrancecForm entrancecForm;
	private EpEntrancec entrancec;
	private ProjectService projectService = (ProjectService) getBean("projectService");
	
	
	private String toMain() throws IOException {
		String EP_SNO = request.getParameter("EP_SNO");
		String path = request.getContextPath();
		String url = path + "/declarep!toAdd?EP_SNO=" + EP_SNO;
		this.response.sendRedirect(url);
		return null;
	}
	
	public String save() throws IOException {
		projectService.saveEntranceC(entrancecForm);
		return this.toMain();
	}
	
	public String toAdd() {
		long EPD_NID = Long.valueOf(request.getParameter("EPD_NID"));
		entrancec=projectService.findEntranceC(BigDecimal.valueOf(EPD_NID));
		return "add";
	}

	public EpEntrancec getEntrancec() {
		return entrancec;
	}

	public void setEntrancec(EpEntrancec entrancec) {
		this.entrancec = entrancec;
	}

	public EpEntrancecForm getEntrancecForm() {
		return entrancecForm;
	}

	public void setEntrancecForm(EpEntrancecForm entrancecForm) {
		this.entrancecForm = entrancecForm;
	}


}
