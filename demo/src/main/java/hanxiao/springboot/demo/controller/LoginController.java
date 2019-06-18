package hanxiao.springboot.demo.controller;

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
	public String login(String emailAddress,String password) {
		System.out.println(emailAddress);
		System.out.println(password);
		return "index";
	}
	
}
