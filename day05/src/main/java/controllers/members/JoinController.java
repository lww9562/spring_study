package controllers.members;

import lombok.RequiredArgsConstructor;
import models.member.JoinService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/member/join")
@RequiredArgsConstructor // fianl, @NonNull이 붙어있는 멤버 변수 초기화 생성자 자동 추가
public class JoinController {
	private final JoinValidator validator;
	private final JoinService service;

	@GetMapping	//RequestMapping의 /member/join 가 앞에 추가된다.
	public String join(Model model){
		Join join = new Join();
		model.addAttribute("join", join);
		return "member/join";
	}

	@PostMapping// /member/join
	public String joinPs(@Valid Join join, Errors errors, Model model){
		validator.validate(join, errors);

		if(errors.hasErrors()){
			//에러가 있으면 처리하지 않고, 양식을 다시 출력
			return "member/join";
		}
		//검증 성공 - 회원 가입 처리
		service.join(join);
		//성공 시에는 회원 로그인 화면으로 redirect
		return "redirect:/member/login";
	}
}
