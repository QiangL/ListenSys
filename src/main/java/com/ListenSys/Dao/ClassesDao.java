package com.ListenSys.Dao;

import java.util.List;

import com.ListenSys.Entity.Classes;

public interface ClassesDao {
	public Classes getClassesById(int classesId);
	public Classes getClassesByClassesId(String classesId);
	public List<Classes> getAllClassesByTeacherId(int teacherId);
	public List<Classes>  getAllClassesByYear(String year);
	public boolean addClasses(Classes classes);
	public boolean delClasses(int classesId);
	public boolean updateClasses(Classes classes);
}
