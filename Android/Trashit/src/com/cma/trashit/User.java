package com.cma.trashit;

public class User {
	int rank;
	String user;
	int bounty;
	int imageid;
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public User(int rank, String user, int bounty, int imageid) {
		super();
		this.rank = rank;
		this.user = user;
		this.bounty = bounty;
		this.imageid = imageid;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public int getBounty() {
		return bounty;
	}
	public void setBounty(int bounty) {
		this.bounty = bounty;
	}
	public int getImageid() {
		return imageid;
	}
	public void setImageid(int imageid) {
		this.imageid = imageid;
	}	
}
