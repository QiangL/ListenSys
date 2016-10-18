package com.ListenSys.Dao;

import java.util.List;

import com.ListenSys.Entity.Teacher;

public interface TeacherDao {
	public Teacher getTeacherById(int teacherId);
	public Teacher getTeacherByTeacherId(String teacherId);
	public List<Teacher> getAllTeacher();
	public boolean addTeacher(Teacher teacher);
	public boolean delTeacher(int teacherId);
	public boolean updateTeacher(Teacher teacher);
}
