package com.ListenSys.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ListenSys.Dao.Impl.TeacherDaoImpl;
import com.ListenSys.Entity.Teacher;

@Controller
@RequestMapping("/teacher/{teacherId}/information")
public class TeacherInformationController {
	@Autowired
	TeacherDaoImpl teacherDapImpl;

	@RequestMapping(method = RequestMethod.GET)
	public String showInformation(@PathVariable String teacherId,
			ModelMap modelMap, HttpSession session) {
		return "teacher/tea_userCenter";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String checkInformation(@PathVariable String teacherId, Teacher s,
			String password2, String passwordComfir, RedirectAttributes redirectAttributes,
			HttpSession session) {
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		if (!teacher.getTeacherPwd().equals(s.getTeacherPwd())) {
			redirectAttributes.addFlashAttribute("error", "原始密码错误");
			return "redirect:information";
		}
		if (!password2.equals(passwordComfir)) {
			redirectAttributes.addFlashAttribute("error", "两次更改的密码不一致");
			return "redirect:information";
		}
		if (!password2.equals("")) {// TODO验证密码格式
			if (password2.matches("^[a-zA-Z]\\w{5,17}$")) {
				teacher.setTeacherPwd(password2);
			} else {
				redirectAttributes.addFlashAttribute("error", "新密码格式不正确");
				return "redirect:information";
			}

		}
		teacher.setTeacherEmail(s.getTeacherEmail());
		teacher.setTeacherName(s.getTeacherName());

		if (!teacherDapImpl.updateTeacher(teacher)) {
			redirectAttributes.addFlashAttribute("error", "修改失败");
			return "redirect:information";
		}
		session.removeAttribute("teacher");
		session.setAttribute("teacher", teacher);
		redirectAttributes.addFlashAttribute("success", "修改成功");
		return "redirect:information";
	}
}
