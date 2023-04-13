package controllers.members;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member/logout")
public class LogoutController {
	@GetMapping
	public String logout(HttpSession session){
		session.invalidate();	// 세션 비우기

		return "redirect:/member/login";
	}
}
