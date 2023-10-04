package dao;

import org.apache.ibatis.session.SqlSession;

import dto.Member;
import util.MybatisSqlSessionFactory;

public class MemberDaoImpl implements MemberDao {
	SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
	
	@Override
	public Member selectMember(String id) throws Exception {
		// Member형 객체 반환
		return sqlSession.selectOne("mapper.member.selectMember", id);
	}
	
	@Override
	public void insertMember(Member member) throws Exception {
		sqlSession.insert("mapper.member.insertMember", member);
		// 읽기를 제외한 insert, update, delete는 commit 필수
		sqlSession.commit();
	}
}
