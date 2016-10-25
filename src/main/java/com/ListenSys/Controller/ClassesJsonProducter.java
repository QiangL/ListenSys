package com.ListenSys.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ListenSys.Dao.Impl.ClassesDaoImpl;
import com.ListenSys.Entity.Classes;

@Controller
@RequestMapping(value="/classes")
public class ClassesJsonProducter {

	@Autowired
	ClassesDaoImpl classesDaoImpl;
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,produces={"application/json"})
	public String getClassesByYear(String year){
		List<Classes> classesList=classesDaoImpl.getAllClassesByYear(year);
		StringBuilder sb=new StringBuilder();
		sb.append("[");
		for(Classes classes:classesList){
			sb.append("{\"classesId\":");
			sb.append(classes.getId());
			sb.append(",\"classesName\":\"");
			sb.append(classes.getClassName());
			sb.append("\"},");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append("]");
		return sb.toString();
	}
	
}
