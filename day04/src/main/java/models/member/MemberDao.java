package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
//@Transactional
public class MemberDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//회원 정보 추가
	@Transactional
	public long insert(Member member){
		String sql = "INSERT INTO MEMBER (USERNO, USERID, USERPW, USERNM) " +
				" VALUES (SEQ_MEMBER.nextval, ?, ?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();

		int cnt = jdbcTemplate.update(c -> {
			PreparedStatement pstmt = c.prepareStatement(sql, new String[]{"USERNO"});
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPw());
			pstmt.setString(3, member.getUserNm());
			return pstmt;
		}, keyHolder);

		Number keyValue = keyHolder.getKey();	// 증감번호 - long, int , ...
												// 상위 클래스인 Number로 받아옴
		long userNo = keyValue.longValue();

		return userNo;
	}
	/*
	public boolean insert(Member member){
		String sql = "INSERT INTO MEMBER (USERNO, USERID, USERPW, USERNM) " +
				" VALUES (SEQ_MEMBER.nextval, ?, ?, ?)";
		
		int cnt = jdbcTemplate.update(sql, member.getUserId(), member.getUserPw(), member.getUserNm());
		//cnt : 반영된 레코드 갯수 → 0개 이상이 나오면, 성공!
		
		return cnt > 0;
	}
	 */

	
	//회원정보를 아이디로 조회
	public Member get(String userId){
		try{
			String sql = "SELECT * FROM MEMBER WHERE USERId = ?";
			Member member = jdbcTemplate.queryForObject(sql, this::memberMapper, userId);

			return member;
		} catch (Exception e){
			return null;
		}
	}

	//회원 목록 조회
	public List<Member> gets(){
		String sql = "SELECT * FROM MEMBER";
		List<Member> members = jdbcTemplate.query(sql, this::memberMapper);

		return members;
	}

	private Member memberMapper(ResultSet rs, int i) throws SQLException{
		Member member = new Member();
		member.setUserNo(rs.getLong("USERNO"));
		member.setUserId(rs.getString("USERID"));
		member.setUserPw(rs.getString("USERPW"));
		member.setUserNm(rs.getString("USERNM"));
		member.setRegDt(rs.getTimestamp("regDt").toLocalDateTime());

		return member;
	}

	public boolean delete(String userId){
		String sql = "DELETE FROM MEMBER WHERE USERID = ?";

		int cnt = jdbcTemplate.update(sql, userId);
		return cnt > 0;
	}

	//전체 회원 수
	public long getTotal(){
		long total = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM MEMBER", Long.class);

		return total;
	}
}
