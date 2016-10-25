package com.ListenSys.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ListenSys.Dao.Impl.ClassesDaoImpl;
import com.ListenSys.Dao.Impl.FolderDaoImpl;
import com.ListenSys.Dao.Impl.SoundDaoImpl;
import com.ListenSys.Dao.Impl.StudentDaoImpl;
import com.ListenSys.Dao.Impl.TeacherDaoImpl;
import com.ListenSys.Entity.Classes;
import com.ListenSys.Entity.Folder;
import com.ListenSys.Entity.Sound;
import com.ListenSys.Entity.Student;
import com.ListenSys.Entity.Teacher;

@Controller
@RequestMapping("/teacher/{teacherId}")
public class TeacherFolderListController {
	@Autowired
	TeacherDaoImpl teacherDapImpl;
	@Autowired
	FolderDaoImpl folderDaoImpl;
	@Autowired
	ClassesDaoImpl classesDaoImpl;
	@Autowired
	StudentDaoImpl studentDaoImpl;
	@Autowired
	SoundDaoImpl soundDaoImpl;
	
	
	@RequestMapping(value="/folderList",method=RequestMethod.GET)
	public String home(@PathVariable String teacherId, ModelMap modelMap,
			HttpSession session) {
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		List<Folder> folderList=folderDaoImpl.getAllFoldersByTeacherId(teacher.getId());
		List<Classes> classesList=classesDaoImpl.getAllClassesByTeacherId(teacher.getId());
		session.setAttribute("folderList", folderList);
		session.setAttribute("classesList",classesList);
		return "teacher/tea_folderList";
	}
	
	@RequestMapping(value = "/folderList/{folderId}/classes/{classesId}", method = RequestMethod.GET)
	public String homeDetial(@PathVariable String teacherId,@PathVariable String folderId,
			@PathVariable String classesId,ModelMap modelMap,
			HttpSession session) {
		Classes classes=classesDaoImpl.getClassesByClassesId(classesId);
		modelMap.put("folderMap", getFolderMap(classes.getId()));
		return "teacher/tea_folderList";
	}
	
	private  Map<Student,List<Sound>> getFolderMap(int classesId){
		Map<Student,List<Sound>> folderMap=new HashMap<Student, List<Sound>>();
		List<Student> studentList=studentDaoImpl.getAllStudentsByClassesId(classesId);
		List<Sound> soundList=null;
		for(Student s:studentList){
			soundList=soundDaoImpl.getAllSoundsByStudentId(s.getId());
			folderMap.put(s,soundList);
		}
		return folderMap;
	}
	
}
