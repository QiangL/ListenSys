package com.ListenSys.Dao;

import java.util.List;

import com.ListenSys.Entity.Folder;

public interface FolderDao {
	public Folder getFolderById(int folderId);
	public List<Folder> getAllFoldersByTeacherId(int teacherId);
	public boolean addFolder(Folder folder);
	public boolean delFolder(int folderId);
	public boolean updateFolder(Folder folder);
	public List<Folder> getFoldersByStudentId(int studentId);
}
