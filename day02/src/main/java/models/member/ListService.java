package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListService {
	@Autowired
	private MemberDao memberDao;

	public ListService(){
	}

	public ListService(MemberDao memberDao){
		this.memberDao = memberDao;
	}

	public void print() {
		List<Member> members = memberDao.gets();
		members.stream().forEach(System.out::println);
	}
}
