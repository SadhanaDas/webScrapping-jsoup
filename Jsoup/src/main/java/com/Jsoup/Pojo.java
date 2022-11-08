package com.Jsoup;

public class Pojo {
	
	public String title;
	public String date;
	public Integer metascore;
	public String review;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getMetascore() {
		return metascore;
	}
	public void setMetascore(Integer metascore) {
		this.metascore = metascore;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	@Override
	public String toString() {
		return "Pojo [title=" + title + ", date=" + date + ", metascore=" + metascore + ", review=" + review + "]";
	}
	public Pojo(String title, String date, Integer metascore, String review) {
		super();
		this.title = title;
		this.date = date;
		this.metascore = metascore;
		this.review = review;
	}

}
