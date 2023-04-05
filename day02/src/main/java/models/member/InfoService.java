package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class InfoService {
	private MemberDao memberDao;
	public InfoService(MemberDao memberDao){
		this.memberDao = memberDao;
	}
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

	public void print(String userId) {
		Member member = memberDao.get(userId);

		if(formatter != null) {
			String dateStr = formatter.format(member.getRegDt());
			member.setRegDtStr(dateStr);
		}
		System.out.println(member);
	}

	@Autowired
	public void setFormatter(@Nullable DateTimeFormatter formatter){
		this.formatter = formatter;
	}
}
