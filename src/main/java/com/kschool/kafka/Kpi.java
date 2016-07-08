package com.kschool.kafka;

public class Kpi {

	 
	 private String idevent; 
	 private String initdate; 
	 private String sys_namet;
	 private String op_namet;
     private String opt_namet;
	 private String sender;
	 private String length;
	 private String username;            
	 private String	tc_namet;            
	 private String	state;     
	 private String functionalerror;   
	 private String mastersystemerror;   
	 private String mdwerror;
	public String getIdevent() {
		return idevent;
	}
	public void setIdevent(String idevent) {
		this.idevent = idevent;
	}
	public String getInitdate() {
		return initdate;
	}
	public void setInitdate(String initdate) {
		this.initdate = initdate;
	}
	public String getSys_namet() {
		return sys_namet;
	}
	public void setSys_namet(String sys_namet) {
		this.sys_namet = sys_namet;
	}
	public String getOp_namet() {
		return op_namet;
	}
	public void setOp_namet(String op_namet) {
		this.op_namet = op_namet;
	}
	public String getOpt_namet() {
		return opt_namet;
	}
	public void setOpt_namet(String opt_namet) {
		this.opt_namet = opt_namet;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTc_namet() {
		return tc_namet;
	}
	public void setTc_namet(String tc_namet) {
		this.tc_namet = tc_namet;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getFunctionalerror() {
		return functionalerror;
	}
	public void setFunctionalerror(String functionalerror) {
		this.functionalerror = functionalerror;
	}
	public String getMastersystemerror() {
		return mastersystemerror;
	}
	public void setMastersystemerror(String mastersystemerror) {
		this.mastersystemerror = mastersystemerror;
	}
	public String getMdwerror() {
		return mdwerror;
	}
	public void setMdwerror(String mdwerror) {
		this.mdwerror = mdwerror;
	}
	@Override
	public String toString() {
		return "kpi [idevent=" + idevent + ", initdate=" + initdate
				+ ", sys_namet=" + sys_namet + ", op_namet=" + op_namet
				+ ", opt_namet=" + opt_namet + ", sender=" + sender
				+ ", length=" + length + ", username=" + username
				+ ", tc_namet=" + tc_namet + ", state=" + state
				+ ", functionalerror=" + functionalerror
				+ ", mastersystemerror=" + mastersystemerror + ", mdwerror="
				+ mdwerror + ", toString()=" + super.toString() + "]";
	}
	
	
	 
	 
	      
}
