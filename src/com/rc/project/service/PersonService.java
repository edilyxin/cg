package com.rc.project.service;

import java.util.List;

import com.rc.project.form.EpPersonForm;
import com.rc.project.vo.EpPerson;

public interface PersonService {
	/*
	 * 
	 */
	public int findSize(EpPersonForm form);
	
	/*
	 * 
	 */
	public List findPage(EpPersonForm form);
	
	/*
	 * 
	 */
	public boolean save(EpPersonForm form);
	
	/*
	 * 
	 */
	public EpPerson findById(int id);
	
	/*
	 * 
	 */
	public boolean delete(String[] checkedIds);
	
	/*
	 * 
	 */
	public boolean changeValid(String[] checkedIds);
	
	public boolean update(EpPersonForm form);
}
