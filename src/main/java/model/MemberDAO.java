package model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// jdbc -->0%
// jdbc -->Conn�� ��û �Ҷ����� ����, ����
// Connection pool : �̸� ������ ������ Connection ����
// MyBatis �����ӿ�ũ
public class MemberDAO {

	private static SqlSessionFactory sqlSessionFactory;
	// �ʱ�ȭ ��{}
	// �����ڰ� ����Ǳ� ������ ����Ǵ� ��

	// static �ʱ�ȭ �� static {}
	// static �������� �޸� �Ҵ�� �� ����

	static {
		try {
			// Connection pool ����
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

		// 1. SQL Session ��������
		// �Ű����� == autocommit ��뿩��
		SqlSession session = sqlSessionFactory.openSession(true);

		// 2. ����
		// ����ϰ��� �ϴ� SQL���� ���� �޼���
		// selectOne => Select���� ����� �ϳ��� ���,
		// �츮�� Mapper�� �����ص� VO�� ����� ����
		// selectList => Select���� ����� �������� ���,
		// List<VO> Ÿ�� ����
		// session.insert("id", VO);
		int cnt = session.insert("join", vo);

		// SQLsession ��ȯ
		session.close();

		// ��� ����
		return cnt;

	}
	
	public MemberVO login(MemberVO vo) {
		
		// 1. SqlSession ��������
		SqlSession session = sqlSessionFactory.openSession(true);
		
		// 2. SQL ���� ����
		MemberVO mvo = session.selectOne("login", vo);
		
		// 3. SqlSession ��ȯ
		session.close();
		
		return mvo;
	}
	
	public List<MemberVO> select() {
		// 1. SqlSession ��������
		SqlSession session = sqlSessionFactory.openSession(true);
		
		// 2. SQL ���� ����
		// List -> ArrayList�� �θ� Ŭ���� 
		// Ȱ�뼺�� ���� List ��� ( ArrayList���� ���� Ŭ�����̹Ƿ� ���� �� �ִ°� ������ )
		// resultType�� VO�� ���൵, List<VO>���� ������
		List<MemberVO> list = session.selectList("select");
		
		// 3. SqlSession ��ȯ
		session.close();
		
		// 4. ��� ����
		return list;
		
	}
	

}
