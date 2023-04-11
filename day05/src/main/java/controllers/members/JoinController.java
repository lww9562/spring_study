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
		Join join = new Join();
		model.addAttribute("join", join);
		return "member/join";
	}

	@PostMapping// /member/join
	public String joinPs(Join join, Model model){
		//model.addAttribute("join", join);
		System.out.println(join);
		return "member/join";
		//return "redirect:/member/login";
	}
}
