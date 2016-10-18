package com.ListenSys.Entity;


public class Classes{
	private int id;
	private String classId;
	private String className;
	
	private int teacherId;
	public Classes(){}
	public Classes(int id,String classesId,String classesName,int teacherId){
		this.id=id;
		this.classId=classesId;
		this.className=classesName;
		this.teacherId=teacherId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + teacherId;
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
		if (!(obj instanceof Classes)) {
			return false;
		}
		Classes other = (Classes) obj;
		if (id != other.id) {
			return false;
		}
		if (teacherId != other.teacherId) {
			return false;
		}
		return true;
	}
}
