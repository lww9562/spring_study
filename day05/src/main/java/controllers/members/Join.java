package controllers.members;

import lombok.Data;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class Join {
	@NotBlank
	@Size(min=6, max=16)
	private String userId;

	@NotBlank
	@Size(min=8)
	private String userPw;

	@NotBlank
	@Size(min=8)
	private String userPwRe;

	@NotBlank
	private String userNm;

	@Email
	private String email;

	@AssertTrue
	private boolean agree;
}
