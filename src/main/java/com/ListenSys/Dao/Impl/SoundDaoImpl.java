package com.ListenSys.Dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.ListenSys.Dao.SoundDao;
import com.ListenSys.Entity.Sound;

public class SoundDaoImpl implements SoundDao {
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public SoundDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	@Override
	public Sound getSoundById(final int soundId) {
		String sql="select * from sound where sound_id=?";
		final Sound sound = new Sound();
		jdbcTemplate.query(sql,new Object[]{soundId},new int[]{Types.INTEGER},new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				sound.setId(soundId);
				sound.setFolderId(rs.getInt("folder_id"));
				sound.setStudentId(rs.getInt("student_id"));
				sound.setPoints(rs.getInt("points"));
				sound.setMarked(rs.getInt("marked")==1?true:false);
				sound.setPath(rs.getString("path"));
				sound.setComment(rs.getString("comment"));
			}
		});
		return sound;
	}

	@Override
	public List<Sound> getAllSoundsByStudentId(final int studentId) {
		String sql="select * from sound where student_id=?";
		List<Sound> soundsList=jdbcTemplate.query(sql,new Object[]{studentId},new int[]{Types.INTEGER},new RowMapper<Sound>() {

			@Override
			public Sound mapRow(ResultSet rs, int index) throws SQLException {
				Sound sound=new Sound();
				sound.setId(studentId);
				sound.setFolderId(rs.getInt("folder_id"));
				sound.setStudentId(rs.getInt("student_id"));
				sound.setPoints(rs.getInt("points"));
				sound.setMarked(rs.getInt("marked")==1?true:false);
				sound.setPath(rs.getString("path"));
				sound.setComment(rs.getString("comment"));
				return sound;
			}
		});
		return soundsList;
	}

	@Override
	public List<Sound> getAllSoundsByFolderId(final int folderId) {
		String sql="select * from sound where folder_id=?";
		List<Sound> soundsList=jdbcTemplate.query(sql,new Object[]{folderId},new int[]{Types.INTEGER},new RowMapper<Sound>() {

			@Override
			public Sound mapRow(ResultSet rs, int index) throws SQLException {
				Sound sound=new Sound();
				sound.setId(rs.getInt("sound_id"));
				sound.setFolderId(folderId);
				sound.setStudentId(rs.getInt("student_id"));
				sound.setPoints(rs.getInt("points"));
				sound.setMarked(rs.getInt("marked")==1?true:false);
				sound.setPath(rs.getString("path"));
				sound.setComment(rs.getString("comment"));
				return sound;
			}
		});
		return soundsList;
	}

	@Override
	public boolean addSound(Sound sound) {
		String sql="insert into sound (student_id,folder_id,points,comment,marked,path) values(?,?,?,?,0,?,)";
		Object[] args=new Object[]{
				sound.getStudentId(),
				sound.getFolderId(),
				sound.getPoints(),
				sound.getComment(),
				sound.getPath()
		};
		int[] argTypes=new int[]{
				Types.INTEGER,
				Types.INTEGER,
				Types.INTEGER,
				Types.VARCHAR,
				Types.VARCHAR
		};
		return jdbcTemplate.update(sql,args,argTypes)==1?true:false;
	}

	@Override
	public boolean delSound(int soundId) {
		String sql="delete from sound where sound_id=?";
		return jdbcTemplate.update(sql,new Object[]{soundId},new int[]{Types.INTEGER})==1?true:false;
	}

	@Override
	public boolean updateSound(Sound sound) {
		String sql="update sound set student_id=?,folder_id=?,marked=?,comment=?,path=?,points=?  where sound_id=?";
		Object[] args=new Object[]{
				sound.getStudentId(),
				sound.getFolderId(),
				sound.isMarked()==true?1:0,
				sound.getComment(),
				sound.getPath(),
				sound.getPoints(),
				sound.getId()
		};
		int[] argTypes=new int[]{
				Types.INTEGER,
				Types.INTEGER,
				Types.INTEGER,
				Types.VARCHAR,
				Types.VARCHAR,
				Types.INTEGER,
				Types.INTEGER
		};
		return jdbcTemplate.update(sql,args,argTypes)==1?true:false;
		
		
	}
	@Override
	public List<Sound> getSoundsByFolderAndStudent(int folderId, int studentId) {
		// TODO Auto-generated method stub
		String sql="select * from sound where folder_id=? and student_id=?";
		List<Sound> soundsList=jdbcTemplate.query(sql,new Object[]{folderId,studentId},
				new int[]{Types.INTEGER,Types.INTEGER},new RowMapper<Sound>() {

			@Override
			public Sound mapRow(ResultSet rs, int index) throws SQLException {
				Sound sound=new Sound();
				sound.setId(rs.getInt("sound_id"));
				sound.setFolderId(folderId);
				sound.setStudentId(studentId);
				sound.setPoints(rs.getInt("points"));
				sound.setMarked(rs.getInt("marked")==1?true:false);
				sound.setPath(rs.getString("path"));
				sound.setComment(rs.getString("comment"));
				return sound;
			}
		});
		return soundsList;
	}

}
