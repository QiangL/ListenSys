package com.ListenSys.Dao.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.ListenSys.Dao.ClassesDao;
import com.ListenSys.Entity.Classes;

public class ClassesDaoImpl implements ClassesDao {
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate=jdbcTemplate;
	}
	
	private String sql;
	/* below is used for original jdbc*/
	/*
	private BaseDBHelper DBHelper;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	*/
	public ClassesDaoImpl(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate=jdbcTemplate;
	}
	@Override
	public Classes getClassesById(final int classesId) {
		sql="select * from classes where classes_id=?";
		final Classes cls=new Classes();
		jdbcTemplate.query(sql, new Object[]{classesId}, new int[]{Types.INTEGER} , new RowCallbackHandler(){

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				cls.setId(classesId);
				cls.setClassId(rs.getString("classesId"));
				cls.setClassName(rs.getString("classesName"));
				cls.setTeacherId(rs.getInt("teacher_id"));
			}
			
		});
		return cls;
		/*
		sql="select * from classes where classes_id=?";
		Classes cls=null;
		conn=DBHelper.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, classesId);
			rs=pstmt.executeQuery();
			if(rs.next()){
				cls=new Classes();
				cls.setId(classesId);
				cls.setClassId(rs.getString("classesId"));
				cls.setClassName(rs.getString("classesName"));
				cls.setTeacherId(rs.getInt("teacher_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBHelper.CloseAll(rs, pstmt);
		}
		return cls;
		*/
	}

	@Override
	public List<Classes> getAllClassesByTeacherId(final int teacherId) {
		sql="select * from classes where teacher_id=?";
		List<Classes> classesList=jdbcTemplate.query(sql, new Object[]{teacherId},new int[]{Types.INTEGER} , new RowMapper<Classes>(){

			@Override
			public Classes mapRow(ResultSet rs, int index) throws SQLException {
				Classes cls=new Classes();
				cls.setId(rs.getInt("classes_id"));
				cls.setClassId(rs.getString("classesId"));
				cls.setClassName(rs.getString("classesName"));
				cls.setTeacherId(teacherId);
				return cls;
			}
			
		});
		return classesList;
		/*
		List<Classes> classesList=new ArrayList<Classes>();
		sql="select * from classes where teacher_id=?";
		conn=DBHelper.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, teacherId);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Classes cls=new Classes();
				cls.setId(rs.getInt("classes_id"));
				cls.setClassId(rs.getString("classesId"));
				cls.setClassName(rs.getString("classesName"));
				cls.setTeacherId(teacherId);
				classesList.add(cls);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBHelper.CloseAll(rs, pstmt);
		}
		return classesList;
		*/
	}

	@Override
	public boolean addClasses(Classes classes) {
		sql="insert into classes (classesId,teacher_id,classesName) values(?,?,?)";
		Object[] args=new Object[]{
				classes.getClassId(),
				classes.getTeacherId(),
				classes.getClassName()
		};
		int [] argTypes=new int[]{
				Types.INTEGER,
				Types.INTEGER,
				Types.VARCHAR,
		};
		return jdbcTemplate.update(sql, args,argTypes)==1?true:false;
		
		/* 
		 * the code below is writed without spring jdbcTemplate
		*/
		/*
		sql="insert into classes (classesId,teacher_id,classesName) values(?,?,?)";
		conn=DBHelper.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, classes.getClassId());
			pstmt.setInt(2,classes.getTeacherId());
			pstmt.setString(3,classes.getClassName());
			return pstmt.executeUpdate()==1?true:false;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBHelper.CloseAll(rs, pstmt);
		}
		return false;
		*/
	}

	@Override
	public boolean delClasses(final int classesId) {
		sql="delete from classes where classes_id=?";
		return jdbcTemplate.update(sql, new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement arg0) throws SQLException {
				arg0.setInt(1, classesId);
			}
			
		})==1?true:false;
		/*
		sql="delete from classes where classes_id=?";
		conn=DBHelper.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, classesId);
			return pstmt.executeUpdate()==1?true:false;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBHelper.CloseAll(rs, pstmt);
		}
		return false;
		*/
	}

	@Override
	public boolean updateClasses(Classes classes) {
		sql="update classes set classesId=?,teacher_id=?,classesName=? where classes_id=?";
		Object [] args={
				classes.getClassId(),
				classes.getTeacherId(),
				classes.getClassName(),
				classes.getId()
		};
		int[] argTypes={
				Types.VARCHAR,
				Types.INTEGER,
				Types.VARCHAR,
				Types.INTEGER
		};
		return jdbcTemplate.update(sql, args, argTypes)==1?true:false;
		/*
		 * the code below is writed by original jdbc without  jdbcTempalte
		 */
		/*
		sql="update classes set classesId=?,teacher_id=?,classesName=? where classes_id=?";
		conn=DBHelper.getConnection();
		try{
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,classes.getClassId());
			pstmt.setInt(2,classes.getTeacherId());
			pstmt.setString(3,classes.getClassName());
			pstmt.setInt(4, classes.getId());
			return pstmt.executeUpdate()==1?true:false;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBHelper.CloseAll(rs, pstmt);
		}
		return false;
		*/
	}
	@Override
	public List<Classes> getAllClassesByYear(String year) {
		// TODO Auto-generated method stub
		sql="select * from classes where classesId like '?%'";
		List<Classes> classesList=jdbcTemplate.query(sql, new Object[]{year},new int[]{Types.VARCHAR} , new RowMapper<Classes>(){

			@Override
			public Classes mapRow(ResultSet rs, int index) throws SQLException {
				Classes cls=new Classes();
				cls.setId(rs.getInt("classes_id"));
				cls.setClassId(rs.getString("classesId"));
				cls.setClassName(rs.getString("classesName"));
				cls.setTeacherId(rs.getInt("teacher_id"));
				return cls;
			}
			
		});
		return classesList;
	}

}
