package com.ListenSys.Dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.ListenSys.Dao.FolderDao;
import com.ListenSys.Entity.Folder;

public class FolderDaoImpl implements FolderDao {
	private String sql;
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public FolderDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}

	@Override
	public Folder getFolderById(final int folderId) {
		sql = "select * from folder where folder_id=?";
		final Folder folder = new Folder();
		jdbcTemplate.query(sql, new Object[]{folderId}, new int[]{Types.INTEGER}, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				folder.setId(folderId);
				folder.setTeacherId(rs.getInt("teacher_id"));
				folder.setFolderName(rs.getString("folderName"));
				folder.setDescription(rs.getString("description"));
			}
		});
		return folder;
	}

	@Override
	public List<Folder> getAllFoldersByTeacherId(final int teacherId) {
		sql = "select * from folder where teacher_id=? order by folder_id desc";
		List<Folder> foldersList =jdbcTemplate.query(sql,new Object[]{teacherId},new int[]{Types.INTEGER},new RowMapper<Folder>() {

			@Override
			public Folder mapRow(ResultSet rs, int index) throws SQLException {
				Folder folder=new Folder();
				folder.setId(rs.getInt("folder_id"));
				folder.setTeacherId(teacherId);
				folder.setFolderName(rs.getString("folderName"));
				folder.setDescription(rs.getString("description"));
				return folder;
			}
		});
		return foldersList;
	}

	@Override
	public boolean addFolder(Folder folder) {
		sql = "insert into folder (teacher_id,folderName,description) values(?,?,?)";
		Object[] args=new Object[]{
				folder.getTeacherId(),
				folder.getFolderName(),
				folder.getDescription()
		};
		int[] argTypes=new int[]{
				Types.INTEGER,
				Types.VARBINARY,
				Types.VARCHAR
		};
		return jdbcTemplate.update(sql,args,argTypes)==1?true:false;
	}

	@Override
	public boolean delFolder(int folderId) {
		sql = "delete from folder where folder_id=?";
		return jdbcTemplate.update(sql, new Object[]{folderId}, new int[]{Types.INTEGER})==1?true:false;
	}

	@Override
	public boolean updateFolder(Folder folder) {
		sql = "update folder set teacher_id=?,folderName=?,description=? where folder_id=?";
		Object[] args={
				folder.getTeacherId(),
				folder.getFolderName(),
				folder.getDescription(),
				folder.getId()
		};
		int[] argTypes={
				Types.INTEGER,
				Types.VARCHAR,
				Types.VARCHAR,
				Types.INTEGER
		};
		return jdbcTemplate.update(sql, args, argTypes)==1?true:false;
		
	}
}
