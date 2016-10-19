package com.ListenSys.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ListenSys.Dao.Impl.ClassesDaoImpl;
import com.ListenSys.Entity.Classes;

@Controller
@RequestMapping(value="/classes")
public class ClassController {

	@Autowired
	ClassesDaoImpl classesDaoImpl;
	
	@RequestMapping(method=RequestMethod.POST,produces="application/json")
	public String getClassesByYear(String year){
		List<Classes> classesList=classesDaoImpl.getAllClassesByYear(year);
		return null;
	}
	
}
