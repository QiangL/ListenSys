package com.test.ListenSys;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ListenSys.Dao.Impl.TeacherDaoImpl;
import com.ListenSys.Entity.Teacher;

public class TestTeacherDaoImpl {
	private TeacherDaoImpl testTeacherDaoImpl;
	public TestTeacherDaoImpl() {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		testTeacherDaoImpl=(TeacherDaoImpl) applicationContext.getBean("TeacherDaoImpl");
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetTeahcerById() {
		Teacher t=testTeacherDaoImpl.getTeacherById(1);
		assertEquals(1, t.getId());
	}

	@Test
	public void testGetAllTeacher() {
		List<Teacher> teachersList=testTeacherDaoImpl.getAllTeacher();
		assertEquals(4, teachersList.size());
	}

	@Test
	public void testAddTeacher() {
		Teacher t=new Teacher();
		t.setTeacherEmail("2112121");
		t.setTeacherId("2121");
		t.setTeacherName("li");
		t.setTeacherPwd("asdf");
		assertEquals(true, testTeacherDaoImpl.addTeacher(t));
	}

	@Test
	@Ignore
	public void testDelTeacher() {
		assertEquals(true, testTeacherDaoImpl.delTeacher(3));
	}

	@Test
	public void testUpdateTeacher() {
		Teacher t=testTeacherDaoImpl.getTeacherById(1);
		t.setTeacherName("liqiang");
		assertEquals(true, testTeacherDaoImpl.updateTeacher(t));
	}

}
