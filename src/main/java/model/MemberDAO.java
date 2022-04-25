package model;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// jdbc -->0%
// jdbc -->Conn이 요청 할때마다 생성, 삭제
// Connection pool : 미리 지정된 갯수의 Connection 생성
// MyBatis 프레임워크
public class MemberDAO {

	private static SqlSessionFactory sqlSessionFactory;
	// 초기화 블럭{}
	// 생성자가 실행되기 직전에 실행되는 블럭

	// static 초기화 블럭 static {}
	// static 변수들이 메모리 할당될 때 실행

	static {
		try {
			// Connection pool 설정
			String resource = "mapper/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// =========================================================
	// join method

	public int join(MemberVO vo) {

		// 1. SQL Session 빌려오기
		// 매개변수 == autocommit 사용여부
		SqlSession session = sqlSessionFactory.openSession(true);

		// 2. 실행
		// 사용하고자 하는 SQL문과 같은 메서드
		// selectOne => Select실행 결과가 하나인 경우,
		// 우리가 Mapper에 지정해둔 VO로 결과를 리턴
		// selectList => Select실행 결과가 여러개인 경우,
		// List<VO> 타입 리턴
		// session.insert("id", VO);
		int cnt = session.insert("join", vo);

		// SQLsession 반환
		session.close();

		// 결과 리턴
		return cnt;

	}
	
	public int login(MemberVO vo) {
		SqlSession session = sqlSessionFactory.openSession(true);
		int cnt = session.selectOne("login", vo);
		
		session.close();
		
		return cnt;
		
	}

}
