package dao;

import org.apache.ibatis.session.SqlSession;

import bean.Member;
import util.MybatisSqlSessionFactory;

public class MemberDAOImpl implements MemberDAO {
	SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
	
	@Override
	public void insertMember(Member member) throws Exception {
		sqlSession.insert("mapper.member.insertMember", member);
		sqlSession.commit();
	}
	
	@Override
	public Member selectMember(String id, String password) throws Exception {
		Member member = sqlSession.selectOne("mapper.member.selectMember", id);
		System.out.println(member.getId());
		return member;
	}
}
