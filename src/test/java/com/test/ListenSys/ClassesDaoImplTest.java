package com.test.ListenSys;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ListenSys.Dao.Impl.ClassesDaoImpl;
import com.ListenSys.Entity.Classes;

public class ClassesDaoImplTest {
	private ClassesDaoImpl testClassesDaoImpl;
	
	public ClassesDaoImplTest() {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		testClassesDaoImpl=(ClassesDaoImpl) applicationContext.getBean("ClassesDaoImpl");
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetClassesById() {
		Classes cls=testClassesDaoImpl.getClassesById(3);
		assertEquals("1405", cls.getClassName());
	}

	@Test
	public void testGetAllClassesByTeacherId() {
		List<Classes> classesList=testClassesDaoImpl.getAllClassesByTeacherId(1);
		assertNotNull(classesList);
		//assertEquals(22, classesList.size());
		for(int i=0;i<classesList.size();i++){
			assertEquals(1, classesList.get(i).getTeacherId());
		}
		
	}

	@Test
	@Ignore
	public void testAddClasses() {
		Classes cls=new Classes();
		cls.setClassId("1411405");
		cls.setClassName("�� �Ҷ���һ����");
		cls.setTeacherId(1);
		
		assertEquals(true, testClassesDaoImpl.addClasses(cls));
	}

	@Test
	@Ignore
	public void testDelClasses() {
		assertEquals(true, testClassesDaoImpl.delClasses(1));
	}

	@Test
	public void testUpdateClasses() {
		Classes cls=testClassesDaoImpl.getClassesById(3);
		cls.setClassId("121");
		assertEquals(true, testClassesDaoImpl.updateClasses(cls));
		cls=testClassesDaoImpl.getClassesById(3);
		assertEquals("121", cls.getClassId());
	}

}
