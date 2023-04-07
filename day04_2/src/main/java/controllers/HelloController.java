package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	@GetMapping("/hello")	//요청이 들어오면, 경로를 통해 @Bean을 찾는다.
	public String hello(){
		return "hello";	//반환값을 통해 "/WEB-INF/view/hello.jsp" 를 찾는다.
	}
}
