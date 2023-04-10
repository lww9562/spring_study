package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	/*
	@GetMapping("/hello")	//Get 방식으로 해당 URL 접속 시 메서드 호출
	public String hello(@RequestParam(name="name", required = false) String nm, boolean agree, Model model){
		//@RequestParam 애너테이션은 요청 key값과 변수가 일치하지 않는 경우
		//알아서 매핑해준다.(실제 key값과 변수를 바인딩)
		System.out.printf("name = %s, agree = %s\n", nm, agree);
		model.addAttribute("message", "안녕하세요!");
		
		return "hello"; //String, ModelAndView 로 반환
	}
	 */
	@GetMapping("/hello")
	public ModelAndView hello(String name, boolean agree) {
		ModelAndView mv = new ModelAndView();	//데이터와 뷰 네임이 들어간다.
		mv.addObject("message", "안녕하세요.");
		mv.addObject("name", name); // 데이터 입력
		
		mv.setViewName("hello");	// 뷰 네임 입력(템플릿)
		return mv;
	}
}
