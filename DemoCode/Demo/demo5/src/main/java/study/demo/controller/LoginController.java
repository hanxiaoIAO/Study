package study.demo.controller;

import java.io.IOException;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import study.demo.dao.UserEntity;
import study.demo.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@GetMapping(value= {"/","/index"})
	public String index() throws IOException {
		return "index.html";
	}
	
	@GetMapping("/vip")
	public String vip() throws IOException {
		return "/vip.html";
	}
	
	@GetMapping("/login")
	public String login() throws IOException {
		return "/login.html";
	}

//	@GetMapping("/logout")
//	public String logout() throws IOException {
//		return "logout.html";
//	}

	@GetMapping("/logout")
	public String logout() throws IOException {
		Subject subject = SecurityUtils.getSubject();
		boolean authen = subject.isAuthenticated();
		if(authen) {
			subject.logout();
		}
		
		return "redirect:/login";
	}

	@GetMapping("/notRole")
	public String notRole() throws IOException {
		return "notRole.html";
	}
	
	@PostMapping("/login")
	@ResponseBody
	public String login(@RequestBody UserEntity user) throws IOException {
		Subject subject = SecurityUtils.getSubject();
		boolean authen = subject.isAuthenticated();
		if(!authen) {
			UsernamePasswordToken token  = new UsernamePasswordToken(user.getCode(), "");
			subject.login(token);
		}
		return "success";
	}
	
	@PostMapping("/regist")
	@ResponseBody
	public String regist(@RequestBody UserEntity user) throws IOException {
		loginService.regist(user);
		return "success";
	}
	
	@PostMapping("/deRegist")
	@ResponseBody
	public String deRegist(@RequestBody UserEntity user) throws IOException {
		loginService.deRegist(user.getCode());
		return "注销成功";
	}

}
