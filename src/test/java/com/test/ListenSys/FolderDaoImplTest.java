package com.test.ListenSys;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ListenSys.Dao.Impl.FolderDaoImpl;
import com.ListenSys.Entity.Folder;

public class FolderDaoImplTest {
	
	private FolderDaoImpl testFolderDaoImpl;
	private Folder folder;
	
	public FolderDaoImplTest() {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		testFolderDaoImpl=(FolderDaoImpl) applicationContext.getBean("FolderDaoImpl");
		folder=new Folder();
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	@Ignore
	public void testGetFolderById() {
		folder=testFolderDaoImpl.getFolderById(2);
		assertEquals("this is a test", folder.getDescription());
	}

	@Test
	@Ignore
	public void testGetAllFoldersByTeacherId() {
		List<Folder> foldersList=testFolderDaoImpl.getAllFoldersByTeacherId(1);
		assertNotNull(foldersList);
		for(int i=0;i<foldersList.size();i++){
			assertEquals(1, foldersList.get(i).getTeacherId());
		}
	}

	@Test
	@Ignore
	public void testAddFolder() {
		folder.setTeacherId(1);
		folder.setDescription("this is a test");
		folder.setFolderName("Test");
		assertEquals(true, testFolderDaoImpl.addFolder(folder));
	}

	@Test
	@Ignore
	public void testDelFolder() {
		assertEquals(true, testFolderDaoImpl.delFolder(1));
	}

	@Test
	public void testUpdateFolder() {
		folder=testFolderDaoImpl.getFolderById(6);
		folder.setDescription("this is another test");
		assertEquals(true, testFolderDaoImpl.updateFolder(folder));
		assertEquals("this is another test", testFolderDaoImpl.getFolderById(6).getDescription());
	}

}
