package model;

public class MemberVO {
	
	// 1. 테이블 컬럼명과 필드명을 일치시킬 것
	// 2. 모든 필드에 대해 Getter / Setter를 만들 것
	
	private String id;
	private String pw;
	private String nick;
	
	public MemberVO(String id, String pw, String nick) {
		super();
		this.id = id;
		this.pw = pw;
		this.nick = nick;
	}
	
	public MemberVO() {
		super();
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	
	
}
