package controllers.members;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/join")
public class JoinController {
	@GetMapping	//RequestMapping의 /member/join 가 앞에 추가된다.
	public String join(Model model){
		model.addAttribute("title", "회원가입");
		model.addAttribute("content", "회원가입 내용");

		return "member/join";
	}

	@PostMapping// /member/join
	public String joinPs(Join join){
		//model.addAttribute("join", join);
		System.out.println(join);
		return "redirect:/member/login";
	}
}
