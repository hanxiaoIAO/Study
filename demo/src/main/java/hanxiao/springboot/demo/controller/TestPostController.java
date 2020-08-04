package hanxiao.springboot.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestPostController {
	
    @RequestMapping(value = "/testpost", method = RequestMethod.POST)
    @ResponseBody
	public String testpost(HttpServletRequest request, HttpServletResponse response) {
		return "index";
	}

}
