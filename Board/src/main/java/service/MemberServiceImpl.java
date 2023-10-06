package service;

import dao.MemberDao;
import dao.MemberDaoImpl;
import dto.Member;

public class MemberServiceImpl implements MemberService {
	private MemberDao memberDao;
	
	public MemberServiceImpl() {
		memberDao = new MemberDaoImpl();
	}
	
	@Override
	public Member login(String id, String password) throws Exception {
		Member member = memberDao.selectMember(id);
		if(member==null) throw new Exception("아이디 오류");
		if(member.getPassword().equals(password) == false) throw new Exception("비밀번호 오류");
		return member;
	}
	
	@Override
	public void join(Member member) throws Exception {
		Member smember = memberDao.selectMember(member.getId());
		if(smember!=null) throw new Exception("아이디 중복 오류"); // 특정 아이디로 조회되는 member가 있을 경우
		memberDao.insertMember(member);
	}
	
	@Override
	public String idCheck(String id) throws Exception {
		Member member = memberDao.selectMember(id);
		if(member==null) return "notexist";
		return "exist";
	}
}
