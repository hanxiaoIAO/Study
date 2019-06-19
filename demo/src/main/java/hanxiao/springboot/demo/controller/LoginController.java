package hanxiao.springboot.demo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
    @GetMapping("/login")
    public String login()
    {
        return "login";
    }
	
	@PostMapping("/login")
	public String login(String name,String password) {
		Subject subject = SecurityUtils.getSubject(); 
        UsernamePasswordToken token = new UsernamePasswordToken(name, password); 
        try { 
            subject.login(token);
            return "redirect:/index";
        } catch (AuthenticationException e) { 
            return "login";
        } 
	}
	
}
