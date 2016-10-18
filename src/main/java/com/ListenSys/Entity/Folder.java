package com.ListenSys.Entity;


public class Folder{
	private int id;
	private String folderName;
	private String description;
	
	private int teacherId;
	public Folder() {}
	public Folder(int id,String folderName,int teacherId){
		this.id=id;
		this.folderName=folderName;
		this.teacherId=teacherId;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		if (!(obj instanceof Folder)) {
			return false;
		}
		Folder other = (Folder) obj;
		if (id != other.id) {
			return false;
		}
		if (teacherId != other.teacherId) {
			return false;
		}
		return true;
	}
}
