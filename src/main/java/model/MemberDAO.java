package model;

import java.io.InputStream;

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

}
