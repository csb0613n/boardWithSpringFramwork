package com.example.demo.vo;

public class BoardVO {
	private int id;
	private String bname;
	private String bwriter;
	private String bcontent;
	private int cntComm;
	
	public int getCntComm() {
		return cntComm;
	}
	public void setCntComm(int cntComm) {
		this.cntComm = cntComm;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBwriter() {
		return bwriter;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	@Override
	public String toString() {
		return "BoardVO [id=" + id + ", bname=" + bname + ", bwriter=" + bwriter + ", bcontent=" + bcontent
				+ ", cntComm=" + cntComm + "]";
	}
	
}
