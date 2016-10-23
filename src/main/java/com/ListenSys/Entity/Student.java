package com.ListenSys.Entity;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Student implements Comparable<Student> {
	private int id;
	@Size(min=9,message="用户名应为9位数字")//这里及以下全部为验证用，但是并没有真正使用
	@Pattern(regexp="[0-9]{9}",message="用户名应为9位数字")
	private String studentId;
	@Size(min=1,message="名字至少长度为1")
	private String  studentName;
	@Size(min=6,max=18,message="密码最短6位，最长18位")
	@Pattern(regexp="^[a-zA-Z]\\w{5,17}$",message="密码应以字母开头，长度在6~18之间，只能包含字符、数字和下划线")
	private String studentPwd;
	@Pattern(regexp="^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w{2,3}){1,3})$",message="需填写有效邮箱")
	private String studentEmail;
	
	private int classesId;
	public Student(){}
	public Student(int id,String studentId,String studentName,String studentPwd,String studentEmail,int classesId){
		this.id=id;
		this.studentId=studentId;
		this.studentName=studentName;
		this.studentPwd=studentPwd;
		this.studentEmail=studentEmail;
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
				+ ", studentEmail=" + studentEmail
				+ ", classesId=" + classesId + "]";
	}
	
}
