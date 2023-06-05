package com.example.demo.vo;

public class CommentVO {
	
	private int bid;
	private int cid;
	private String cwriter;
	private String ccontent;
	private String submit_date;
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCwriter() {
		return cwriter;
	}
	public void setCwriter(String cwriter) {
		this.cwriter = cwriter;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	public String getSubmit_date() {
		return submit_date;
	}
	public void setSubmit_date(String submit_date) {
		this.submit_date = submit_date;
	}
	@Override
	public String toString() {
		return "CommentVO [bid=" + bid + ", cid=" + cid + ", cwriter=" + cwriter + ", ccontent=" + ccontent
				+ ", submit_date=" + submit_date + "]";
	}
	
}
