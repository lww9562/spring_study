package controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("controllers")	//controllers 포함 하위패키지 모든 클래스에 적용
public class CommonController {
	@ExceptionHandler(Exception.class)
	public String errorHandler(Exception e, Model model) {
		//해당 예외가 발생하면, 아래 주소로 이동
		e.printStackTrace();
		model.addAttribute("message", e.getMessage());
		return "errors/common";
	}
}