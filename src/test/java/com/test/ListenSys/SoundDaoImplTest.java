package com.test.ListenSys;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ListenSys.Dao.Impl.SoundDaoImpl;
import com.ListenSys.Entity.Sound;

public class SoundDaoImplTest {
	private SoundDaoImpl testSoundDaoImpl;
	
	public SoundDaoImplTest() {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		testSoundDaoImpl=(SoundDaoImpl) applicationContext.getBean("SoundDaoImpl");
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetSoundById() {
		Sound sound=testSoundDaoImpl.getSoundById(1);
		assertEquals(1, sound.getId());
	}

	@Test
	public void testGetAllSoundsByStudentId() {
		List<Sound> soundsList=testSoundDaoImpl.getAllSoundsByStudentId(1);
		for(Sound s:soundsList){
			assertEquals(1, s.getStudentId());
		}
	}

	@Test
	public void testGetAllSoundsByFolderId() {
		List<Sound> soundsList=testSoundDaoImpl.getAllSoundsByFolderId(1);
		for(Sound s:soundsList){
			assertEquals(1, s.getFolderId());
		}
	}

	@Test
	public void testAddSound() {
		Sound s=new Sound();
		s.setComment("this is a test");
		s.setFolderId(1);
		s.setMarked(true);
		s.setPoints(60);
		s.setStudentId(2);
		s.setPath("1212121");
		assertEquals(true, testSoundDaoImpl.addSound(s));
	}

	@Test
	@Ignore
	public void testDelSound() {
		assertEquals(true, testSoundDaoImpl.delSound(1));
	}

	@Test
	public void testUpdateSound() {
		Sound s=testSoundDaoImpl.getSoundById(2);
		s.setPoints(0);
		assertEquals(true, testSoundDaoImpl.updateSound(s));
	}

}
