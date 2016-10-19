package com.ListenSys.Dao;

import java.util.List;

import com.ListenSys.Entity.Student;

public interface StudentDao {
	public Student getStudentById(int  studentId);
	public Student getStudentByStudentId(String studentId);
	public List<Student> getAllStudentsByClassesId(int classesId);
	public boolean addStudent(Student student);
	public boolean delStudent(int studentId);
	public boolean updateStudent(Student student);
}
