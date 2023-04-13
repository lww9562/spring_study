package controllers.members;

import models.member.Member;
import models.member.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Exam01Controller {
	@Autowired
	private MemberDao memberDao;

	@GetMapping("/member2/{id}")	//바뀔 수 있는 부분은 중괄호로 설정
	public String memberInfo(@PathVariable(name="id", required = false) String userId, Model model){	//{userId}와 매칭된다.
		System.out.printf("userId = %s\n", userId);

		Member member = memberDao.get(userId);
		model.addAttribute("member", member);

		return "member/info2";
	}
}
