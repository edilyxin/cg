package com.rc.sys.vo;

public class MngTable {
	 	private String tbl_scode ;//varchar2(50) NOT NULL,
	 	private String sysint_sno ;//varchar2(50) NOT NULL,
	 	private String tbl_sname ;//varchar2(50) NOT NULL,
	 	private String tbl_sisstat ;//varchar2(1) NOT NULL,
	 	private String tbl_sisdel ;//varchar2(1) NOT NULL,
	 	private String tbl_sispkey ;//varchar2(10) NOT NULL,
	 	private String tbl_siscode ;//varchar2(10) NOT NULL,
	 	private String tbl_sisdcode ;//varchar2(10) NOT NULL,
	 	private String tbl_skeyfldCode ;//varchar2(50) NULL,
	 	private String tbl_skeyfldName ;//varchar2(50) NULL,
	 	private String tbl_scodefldCode ;//varchar2(50) NULL,
	 	private String tbl_scodefldName ;//varchar2(50) NULL,
	 	private String tbl_sdcodefldCode ;//varchar2(50) NULL,
	 	private String tbl_sdcodefldName ;//varchar2(50) NULL,
	 	private String tbl_skeyDataType ;//varchar2(1) NULL,
	 	private String tbl_scodeDataType ;//varchar2(1) NULL,
	 	private String tbl_sdcodeDataType ;//varchar2(1) NULL,
	 	private String sysint_sname;
	 	private String tbl_sdef1 ;//varchar2(50) NULL,
	 	private String tbl_sdef2 ;//varchar2(50) NULL,
	 	private String tbl_sdef3 ;//varchar2(50) NULL,
	 	private String tbl_sdef4 ;//varchar2(50) NULL,
	 	private String tbl_sdef5 ;//varchar2(50) NULL
	 	private String pageSQLA;//分页前段
		private String pageSQLB;//分页后段
		private String searchA;//查询条件A
		private String searchB;//查询条件B
		private String searchC;//查询条件C
		private String searchD;//查询条件D
		private String searchE;//查询条件E
		
		
		public String getSysint_sname() {
			return sysint_sname;
		}
		public void setSysint_sname(String sysint_sname) {
			this.sysint_sname = sysint_sname;
		}
		public String getPageSQLA() {
			return pageSQLA;
		}
		public void setPageSQLA(String pageSQLA) {
			this.pageSQLA = pageSQLA;
		}
		public String getPageSQLB() {
			return pageSQLB;
		}
		public void setPageSQLB(String pageSQLB) {
			this.pageSQLB = pageSQLB;
		}
		public String getSearchA() {
			return searchA;
		}
		public void setSearchA(String searchA) {
			this.searchA = searchA;
		}
		public String getSearchB() {
			return searchB;
		}
		public void setSearchB(String searchB) {
			this.searchB = searchB;
		}
		public String getSearchC() {
			return searchC;
		}
		public void setSearchC(String searchC) {
			this.searchC = searchC;
		}
		public String getSearchD() {
			return searchD;
		}
		public void setSearchD(String searchD) {
			this.searchD = searchD;
		}
		public String getSearchE() {
			return searchE;
		}
		public void setSearchE(String searchE) {
			this.searchE = searchE;
		}
		public String getTbl_scode() {
			return tbl_scode;
		}
		public void setTbl_scode(String tbl_scode) {
			this.tbl_scode = tbl_scode;
		}
		public String getSysint_sno() {
			return sysint_sno;
		}
		public void setSysint_sno(String sysint_sno) {
			this.sysint_sno = sysint_sno;
		}
		public String getTbl_sname() {
			return tbl_sname;
		}
		public void setTbl_sname(String tbl_sname) {
			this.tbl_sname = tbl_sname;
		}
		public String getTbl_sisstat() {
			return tbl_sisstat;
		}
		public void setTbl_sisstat(String tbl_sisstat) {
			this.tbl_sisstat = tbl_sisstat;
		}
		public String getTbl_sisdel() {
			return tbl_sisdel;
		}
		public void setTbl_sisdel(String tbl_sisdel) {
			this.tbl_sisdel = tbl_sisdel;
		}
		public String getTbl_sispkey() {
			return tbl_sispkey;
		}
		public void setTbl_sispkey(String tbl_sispkey) {
			this.tbl_sispkey = tbl_sispkey;
		}
		public String getTbl_siscode() {
			return tbl_siscode;
		}
		public void setTbl_siscode(String tbl_siscode) {
			this.tbl_siscode = tbl_siscode;
		}
		public String getTbl_sisdcode() {
			return tbl_sisdcode;
		}
		public void setTbl_sisdcode(String tbl_sisdcode) {
			this.tbl_sisdcode = tbl_sisdcode;
		}
		public String getTbl_skeyfldCode() {
			return tbl_skeyfldCode;
		}
		public void setTbl_skeyfldCode(String tbl_skeyfldCode) {
			this.tbl_skeyfldCode = tbl_skeyfldCode;
		}
		public String getTbl_skeyfldName() {
			return tbl_skeyfldName;
		}
		public void setTbl_skeyfldName(String tbl_skeyfldName) {
			this.tbl_skeyfldName = tbl_skeyfldName;
		}
		public String getTbl_scodefldCode() {
			return tbl_scodefldCode;
		}
		public void setTbl_scodefldCode(String tbl_scodefldCode) {
			this.tbl_scodefldCode = tbl_scodefldCode;
		}
		public String getTbl_scodefldName() {
			return tbl_scodefldName;
		}
		public void setTbl_scodefldName(String tbl_scodefldName) {
			this.tbl_scodefldName = tbl_scodefldName;
		}
		public String getTbl_sdcodefldCode() {
			return tbl_sdcodefldCode;
		}
		public void setTbl_sdcodefldCode(String tbl_sdcodefldCode) {
			this.tbl_sdcodefldCode = tbl_sdcodefldCode;
		}
		public String getTbl_sdcodefldName() {
			return tbl_sdcodefldName;
		}
		public void setTbl_sdcodefldName(String tbl_sdcodefldName) {
			this.tbl_sdcodefldName = tbl_sdcodefldName;
		}
		public String getTbl_skeyDataType() {
			return tbl_skeyDataType;
		}
		public void setTbl_skeyDataType(String tbl_skeyDataType) {
			this.tbl_skeyDataType = tbl_skeyDataType;
		}
		public String getTbl_scodeDataType() {
			return tbl_scodeDataType;
		}
		public void setTbl_scodeDataType(String tbl_scodeDataType) {
			this.tbl_scodeDataType = tbl_scodeDataType;
		}
		public String getTbl_sdcodeDataType() {
			return tbl_sdcodeDataType;
		}
		public void setTbl_sdcodeDataType(String tbl_sdcodeDataType) {
			this.tbl_sdcodeDataType = tbl_sdcodeDataType;
		}
		public String getTbl_sdef1() {
			return tbl_sdef1;
		}
		public void setTbl_sdef1(String tbl_sdef1) {
			this.tbl_sdef1 = tbl_sdef1;
		}
		public String getTbl_sdef2() {
			return tbl_sdef2;
		}
		public void setTbl_sdef2(String tbl_sdef2) {
			this.tbl_sdef2 = tbl_sdef2;
		}
		public String getTbl_sdef3() {
			return tbl_sdef3;
		}
		public void setTbl_sdef3(String tbl_sdef3) {
			this.tbl_sdef3 = tbl_sdef3;
		}
		public String getTbl_sdef4() {
			return tbl_sdef4;
		}
		public void setTbl_sdef4(String tbl_sdef4) {
			this.tbl_sdef4 = tbl_sdef4;
		}
		public String getTbl_sdef5() {
			return tbl_sdef5;
		}
		public void setTbl_sdef5(String tbl_sdef5) {
			this.tbl_sdef5 = tbl_sdef5;
		}
	 	
	 	
	 	
}
