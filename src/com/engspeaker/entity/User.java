package com.engspeaker.entity;

/**
 * 
 * @author shine
 *
 */
public class User {

	//使用公司框架是要long，到时候这里改回成 int类型
	private long fid;
	
	private String username;
	
	private String password;
	
	private String nickname;
	
	private String portrait_path;
	
	private int lastUnlock;

	public long getFid() {
		return fid;
	}

	public void setFid(long fid) {
		this.fid = fid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPortrait_path() {
		return portrait_path;
	}

	public void setPortrait_path(String portrait_path) {
		this.portrait_path = portrait_path;
	}

	public int getLastUnlock() {
		return lastUnlock;
	}

	public void setLastUnlock(int lastUnlock) {
		this.lastUnlock = lastUnlock;
	}
	
	
	
}
