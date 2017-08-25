package com.service.database;

public class BasicBoard {
	private String idx;
	private String title;
	private String writer;
	private String create_date;
	private String fix_date;
	private String recommeded;
	private String lookup;
	
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getFix_date() {
		return fix_date;
	}
	public void setFix_date(String fix_date) {
		this.fix_date = fix_date;
	}
	public String getRecommeded() {
		return recommeded;
	}
	public void setRecommeded(String recommeded) {
		this.recommeded = recommeded;
	}
	public String getLookup() {
		return lookup;
	}
	public void setLookup(String lookup) {
		this.lookup = lookup;
	}
	
}
