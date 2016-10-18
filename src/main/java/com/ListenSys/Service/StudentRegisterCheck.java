package com.ListenSys.Service;

import com.ListenSys.Entity.Student;

public class StudentRegisterCheck {
	public boolean Check(Student student){
		boolean checkFlag=true;
/*		if(student.getStudentId().length()!=9) checkFlag=false;
		if(student.getStudentPwd().length()<6||student.getStudentPwd().length()>16) checkFlag=false;
		if(student.getStudentName().length()<2||student.getStudentName().length()>5) checkFlag=false;*/
		return checkFlag;
	}

}
