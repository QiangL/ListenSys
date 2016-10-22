package com.test.ListenSys;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ListenSys.Dao.Impl.StudentDaoImpl;
import com.ListenSys.Entity.Student;

public class TestStudentDaoImpl {
	private StudentDaoImpl testStudentDaoImpl;
	public TestStudentDaoImpl() {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		testStudentDaoImpl=(StudentDaoImpl) applicationContext.getBean("StudentDaoImpl");
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetStudnetById() {
		Student s=testStudentDaoImpl.getStudentById(2);
		assertEquals(2, s.getId());
	}

	@Test
	public void testGetAllStudentsByTeacherId() {
		List<Student> studentsList=testStudentDaoImpl.getAllStudentsByTeacherId(1);
		/*for(Student s:studentsList){
		}*/
	}

	@Test
	public void testGetAllStudentsByClassesId() {
		List<Student> studentsList=testStudentDaoImpl.getAllStudentsByClassesId(1);
		for(Student s:studentsList){
			assertEquals(1, s.getClassesId());
		}
	}

	@Test
	public void testAddStudent() {
		Student s=new Student();
		s.setClassesId(2);
		s.setStudentEmail("1214098151@qq.com");
		s.setStudentId("12214098151");
		s.setStudentName("liqiang");
		s.setStudentPwd("121");
		assertEquals(true, testStudentDaoImpl.addStudent(s));
		
	}

	@Test
	@Ignore
	public void testDelStudent() {
		assertEquals(true, testStudentDaoImpl.delStudent(3));
	}

	@Test
	public void testUpdateStudent() {
		Student s=testStudentDaoImpl.getStudentById(2);
		s.setStudentEmail("asdfasdf");
		assertEquals(true, testStudentDaoImpl.updateStudent(s));
	}

}
