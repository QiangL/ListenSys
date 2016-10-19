package com.ListenSys.Dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.ListenSys.Dao.StudentDao;
import com.ListenSys.Entity.Student;

public class StudentDaoImpl implements StudentDao {
	private String sql;
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
	@Override
	public Student getStudentById(final int studentId) {
		sql="select * from student where student_id=?";
		final Student student=new Student();
		jdbcTemplate.query(sql, new Object[]{studentId},new int[]{Types.INTEGER},new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				student.setId(studentId);
				student.setClassesId(rs.getInt("classes_id"));
				student.setStudentId(rs.getString("studentId"));
				student.setStudentEmail(rs.getString("email"));
				student.setStudentName(rs.getString("studentName"));
				student.setStudentPwd(rs.getString("pwd"));
			}
		});
		return student;
	}
	
	@Override
	public Student getStudentByStudentId(final String studentId) {
		sql="select * from student where studentId=?";
		final Student student=new Student();
		jdbcTemplate.query(sql, new Object[]{studentId},new int[]{Types.VARCHAR},new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				student.setId(rs.getInt("student_id"));
				student.setClassesId(rs.getInt("classes_id"));
				student.setStudentId(studentId);
				student.setStudentEmail(rs.getString("email"));
				student.setStudentName(rs.getString("studentName"));
				student.setStudentPwd(rs.getString("pwd"));
			}
		});
		return student;
	}
	
	public List<Student> getAllStudentsByTeacherId(final int teacherId) {
		sql="select * from student where teacher_id=?";
		List<Student> studentsList=jdbcTemplate.query(sql,new Object[]{teacherId},new int[]{Types.INTEGER},new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int index) throws SQLException {
				Student student=new Student();
				student.setId(rs.getInt("student_id"));
				student.setClassesId(rs.getInt("classes_id"));
				student.setStudentId(rs.getString("studentId"));
				student.setStudentEmail(rs.getString("email"));
				student.setStudentName(rs.getString("studentName"));
				student.setStudentPwd(rs.getString("pwd"));
				return student;
			}
		});
		return studentsList;
	}

	@Override
	public List<Student> getAllStudentsByClassesId(final int classesId) {
		sql="select * from student where classes_id=?";
		List<Student> studentsList=jdbcTemplate.query(sql,new Object[]{classesId},new int[]{Types.INTEGER},new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int index) throws SQLException {
				Student student=new Student();
				student.setId(rs.getInt("student_id"));
				student.setClassesId(classesId);
				student.setStudentId(rs.getString("studentId"));
				student.setStudentEmail(rs.getString("email"));
				student.setStudentName(rs.getString("studentName"));
				student.setStudentPwd(rs.getString("pwd"));
				return student;
			}
		});
		return studentsList;
	}

	@Override
	public boolean addStudent(Student student) {
		sql="insert into student (classes_id,studentId,email,studentName,pwd) values(?,?,?,?,?)";
		Object[] args=new Object[]{
				student.getClassesId(),
				student.getStudentId(),
				student.getStudentEmail(),
				student.getStudentName(),
				student.getStudentPwd(),
		};
		int[] argTypes=new int[]{
				Types.INTEGER,
				Types.VARCHAR,
				Types.VARCHAR,
				Types.VARCHAR,
				Types.VARCHAR
		};
		return jdbcTemplate.update(sql,args,argTypes)==1?true:false;
	}

	@Override
	public boolean delStudent(int studentId) {
		sql="delete from student where student_id=?";
		return jdbcTemplate.update(sql, new Object[]{studentId}, new int[]{Types.INTEGER})==1?true:false;
	}

	@Override
	public boolean updateStudent(Student student) {
		sql="update student set classes_id=?,studentId=?,email=?,studentName=?,pwd=? where student_id=?";
		Object[] args=new Object[]{
				student.getClassesId(),
				student.getStudentId(),
				student.getStudentEmail(),
				student.getStudentName(),
				student.getStudentPwd(),
				student.getId()
		};
		int[] argTypes=new int[]{
				Types.INTEGER,
				Types.VARCHAR,
				Types.VARCHAR,
				Types.VARCHAR,
				Types.VARCHAR,
				Types.INTEGER,
		};
		return jdbcTemplate.update(sql,args,argTypes)==1?true:false;
	}

}
