package com.ListenSys.Controller;


import java.security.GeneralSecurityException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ListenSys.Dao.Impl.StudentDaoImpl;
import com.ListenSys.Entity.Student;
import com.ListenSys.util.Email;

@Controller
@RequestMapping("/regsiter")
public class RegisterController {
	@Autowired
	StudentDaoImpl studentDaoImpl;
	
	@RequestMapping(method=RequestMethod.GET)
	public String registerInit(){
		return "student/stu_regsiter";
	}
	@RequestMapping(value="/checkCode",method=RequestMethod.POST)
	public Double sendCheckCode(String emailTo){
		Double checkCode=Math.random()*899999+10000;
		Email email=new Email(emailTo, "[日语口语练习]验证您的邮箱", "您好，您的验证码是"+checkCode);
		try {
			email.SendMail();
		} catch (GeneralSecurityException | MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return checkCode;
	}
	@RequestMapping(method=RequestMethod.POST)
	public String registerCheck(Student s,String passwordComfir,ModelMap modelMap,RedirectAttributes redirectAttributes){
		//TODO 数据验证 Model里放入错误信息w
		//do something
		String idRegex="[0-9]{9}";
		String emailRegex="^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w{2,3}){1,3})$";
		String passwordRegex="^[a-zA-Z]\\w{5,17}$";//以字母开头，长度在6~18之间，只能包含字符、数字和下划线
		boolean checkFlag=true;
		if(s==null||passwordComfir==null){
			checkFlag=false;
			redirectAttributes.addFlashAttribute("error","请填写信息");
		}else if(s.getStudentId().equals("")||!s.getStudentId().matches(idRegex)){//TODO 更精确地匹配ID
			checkFlag=false;
			redirectAttributes.addFlashAttribute("error","用户名不符合要求");
		}else if(s.getStudentName().equals("")){
			checkFlag=false;
			redirectAttributes.addFlashAttribute("error","请填写姓名");
		}else if(s.getStudentEmail().equals("")||!s.getStudentEmail().matches(emailRegex)){
			checkFlag=false;
			redirectAttributes.addFlashAttribute("error","邮箱格式不正确");
		}else if(s.getStudentPwd().equals("")||!s.getStudentPwd().matches(passwordRegex)){
			checkFlag=false;
			redirectAttributes.addFlashAttribute("error","密码不符合格式不正确");
		}else if(!s.getStudentPwd().equals(passwordComfir)){
			checkFlag=false;
			redirectAttributes.addFlashAttribute("error","两次密码输入不一致");
		}/*
		else if(s.getClassesId()==0){
			checkFlag=false;
			modelMap.put("error","没有选择班级");
		}
		*/
		
		if(checkFlag){
			if(studentDaoImpl.addStudent(s)){
				return "redirect:login";
			}else {
				modelMap.put("error","注册失败");
				return "redirect:regsiter";
			}
		}else{
			return "redirect:regsiter";
		}
	}
}
