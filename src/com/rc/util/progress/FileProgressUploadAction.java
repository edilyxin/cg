package com.rc.util.progress;

import java.io.*;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileProgressUploadAction extends ActionSupport{
    private File file;
    private String fileFileName;
    private String fileContentType;
	public File getFile() {
		return file;
	}
	
	public void setFile(File file) {
		this.file = file;
	}
    

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
    
	@Override
	public String execute(){
	   
	   try {
		   System.out.println("file:"+file);
		   InputStream is=new FileInputStream(file);
		   String root=ServletActionContext.getRequest().getRealPath("/LabZdinfoFile1");
		   //System.out.println("root:"+root);
		   
		   System.out.println("name:"+this.fileFileName);
		   System.out.println("type:"+this.fileContentType);
		   File destFile=new File(root,this.fileFileName);
		   
		   OutputStream os=new FileOutputStream(destFile);	
		   
		   byte [] b=new byte[1024*1024*10];
		   int length=0;		  		   
		   while(true){
			     length=is.read(b);
			     if(length<0)
			    	 break;
		    	 os.write(b,0,length);			    	 
		   }		    

		   is.close();
		   os.close();
	   }catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	   }
	  return "success";
   }
}