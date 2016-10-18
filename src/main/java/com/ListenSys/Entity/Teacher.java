package com.ListenSys.Entity;

public class Teacher {
	private int id;
	private String teacherId;
	private String teacherName;
	private String teacherPwd;
	private String teacherEmail;
	public Teacher(){}
	public Teacher(int id,String teacherId,String teacherName,String teacherPwd,String teacherEmail){
		this.id=id;
		this.teacherId=teacherId;
		this.teacherName=teacherName;
		this.teacherPwd=teacherPwd;
		this.teacherEmail=teacherEmail;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeacherPwd() {
		return teacherPwd;
	}
	public void setTeacherPwd(String teacherPwd) {
		this.teacherPwd = teacherPwd;
	}
	public String getTeacherEmail() {
		return teacherEmail;
	}
	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}

	@Override
	public int hashCode() {
		return this.getId();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Teacher)) {
			return false;
		}
		Teacher other = (Teacher) obj;
		if (teacherId != other.teacherId) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", teacherId=" + teacherId
				+ ", teacherName=" + teacherName + ", teacherPwd=" + teacherPwd
				+ ", teacherEmail=" + teacherEmail + "]";
	}
	
}
