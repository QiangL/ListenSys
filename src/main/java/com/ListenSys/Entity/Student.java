package com.ListenSys.Entity;

public class Student implements Comparable<Student> {
	private int id;
	private String studentId;
	private String  studentName;
	private String studentPwd;
	private String studentEmail;
	
	private int teacherId;
	private int classesId;
	public Student(){}
	public Student(int id,String studentId,String studentName,String studentPwd,String studentEmail,int teacherId,int classesId){
		this.id=id;
		this.studentId=studentId;
		this.studentName=studentName;
		this.studentPwd=studentPwd;
		this.studentEmail=studentEmail;
		this.teacherId=teacherId;
		this.classesId=classesId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentPwd() {
		return studentPwd;
	}
	public void setStudentPwd(String studentPwd) {
		this.studentPwd = studentPwd;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public int getClassesId() {
		return classesId;
	}
	public void setClassesId(int classesId) {
		this.classesId = classesId;
	}
	@Override
	public int compareTo(Student o) {
		if(this.getStudentId().compareTo(o.getStudentId())<0) return -1;
		else if(this.getStudentId().compareTo(o.getStudentId())>0) return 1;
		else return 0;
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
		if (!(obj instanceof Student)) {
			return false;
		}
		Student other = (Student) obj;
		if (studentId != other.studentId) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", studentId=" + studentId
				+ ", studentName=" + studentName + ", studentPwd=" + studentPwd
				+ ", studentEmail=" + studentEmail + ", teacherId=" + teacherId
				+ ", classesId=" + classesId + "]";
	}
	
}
