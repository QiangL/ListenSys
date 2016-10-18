package com.ListenSys.Dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.ListenSys.Dao.TeacherDao;
import com.ListenSys.Entity.Teacher;

public class TeacherDaoImpl implements TeacherDao {
	private String sql;
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public TeacherDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public Teacher getTeacherById(final int teacherId) {
		sql="select * from teacher where teacher_id=?";
		final Teacher teacher=new Teacher();
		jdbcTemplate.query(sql,new Object[]{teacherId},new int[]{Types.INTEGER},new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				teacher.setId(teacherId);
				teacher.setTeacherEmail(rs.getString("email"));
				teacher.setTeacherId(rs.getString("teacherId"));
				teacher.setTeacherName(rs.getString("teacherName"));
				teacher.setTeacherPwd(rs.getString("pwd"));
				
			}
		});
		return teacher;
	}
	
	@Override
	public Teacher getTeacherByTeacherId(final String teacherId) {
		sql="select * from teacher where teacherId=?";
		final Teacher teacher=new Teacher();
		jdbcTemplate.query(sql,new Object[]{teacherId},new int[]{Types.VARCHAR},new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				teacher.setId(rs.getInt("teacherId"));
				teacher.setTeacherEmail(rs.getString("email"));
				teacher.setTeacherId(teacherId);
				teacher.setTeacherName(rs.getString("teacherName"));
				teacher.setTeacherPwd(rs.getString("pwd"));
				
			}
		});
		return teacher;
	}
	
	@Override
	public List<Teacher> getAllTeacher() {
		sql="select * from teacher";
		List<Teacher> teachersList=jdbcTemplate.query(sql, new RowMapper<Teacher>(){

			@Override
			public Teacher mapRow(ResultSet rs, int index) throws SQLException {
				Teacher teacher=new Teacher();
				teacher.setId(rs.getInt("teacher_id"));
				teacher.setTeacherEmail(rs.getString("email"));
				teacher.setTeacherId(rs.getString("teacherId"));
				teacher.setTeacherName(rs.getString("teacherName"));
				teacher.setTeacherPwd(rs.getString("pwd"));
				return teacher;
			}
			
		});
		return teachersList;
	}

	@Override
	public boolean addTeacher(Teacher teacher) {
		sql="insert into teacher (email,teacherId,teacherName,pwd) values(?,?,?,?)";
		Object[] args=new Object[]{
				teacher.getTeacherEmail(),
				teacher.getTeacherId(),
				teacher.getTeacherName(),
				teacher.getTeacherPwd()
		};
		int[] argTypes=new int[]{
				Types.VARCHAR,
				Types.VARCHAR,
				Types.VARCHAR,
				Types.VARCHAR
		};
		
		return jdbcTemplate.update(sql,args,argTypes)==1?true:false;
	}

	@Override
	public boolean delTeacher(int teacherId) {
		sql="delete from teacher where teacher_id=?";
		return jdbcTemplate.update(sql,new Object[]{teacherId},new int[]{Types.INTEGER})==1?true:false;
	}

	@Override
	public boolean updateTeacher(Teacher teacher) {
		sql="update teacher set email=?,teacherId=?,teacherName=?,pwd=? where teacher_id=?";
		Object[] args=new Object[]{
				teacher.getTeacherEmail(),
				teacher.getTeacherId(),
				teacher.getTeacherName(),
				teacher.getTeacherPwd(),
				teacher.getId()
		};
		int[] argTypes=new int[]{
				Types.VARCHAR,
				Types.VARCHAR,
				Types.VARCHAR,
				Types.VARCHAR,
				Types.INTEGER
		};
		return jdbcTemplate.update(sql,args,argTypes)==1?true:false;
	}
}
