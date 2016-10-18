package com.ListenSys.Entity;

public class Sound {
	private int id;
	private String path;
	private int points;
	private String comment;
	private boolean marked;
	
	private int studentId;
	private int folderId;
	public Sound(){}
	public Sound(int id,int studentId,int folderId,String path){
		this.id=id;
		this.path=path;
		this.marked=false;
		this.studentId=studentId;
		this.folderId=folderId;
	}
	public boolean isMarked() {
		return marked;
	}
	public void setMarked(boolean marked) {
		this.marked = marked;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getFolderId() {
		return folderId;
	}
	public void setFolderId(int folderId) {
		this.folderId = folderId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + folderId;
		result = prime * result + id;
		result = prime * result + (marked ? 1231 : 1237);
		result = prime * result + studentId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Sound)) {
			return false;
		}
		Sound other = (Sound) obj;
		if (folderId != other.folderId) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (marked != other.marked) {
			return false;
		}
		if (studentId != other.studentId) {
			return false;
		}
		return true;
	}
	
}
