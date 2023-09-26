package service;

import java.util.List;

import dao.AccountDAO;
import dto.Account;

public class AccountService {
	private AccountDAO dao = new AccountDAO();
	
	public void makeAccount(Account acc) throws Exception {
		Account sacc = dao.selectAccount(acc.getId());
		if(sacc!=null) throw new Exception("계좌번호가 중복됩니다.");
		dao.insertAccount(acc);
	}
	
	public Account selectAccount(String id) throws Exception {
		Account acc = dao.selectAccount(id);
		if(id==null) throw new Exception("해당되는 계좌가 없습니다.");
		
		return acc;
	}
	
	public List<Account> selectAllAccount() throws Exception {
		List<Account> accs = dao.selectAllAccount();
		if(accs==null) throw new Exception("개설된 계좌가 없습니다.");
		
		return accs;
	}
	
	public void deposit(String id, Integer money) throws Exception {
		dao.updateAccount(id, money);
	}
	
	public void withdraw(String id, Integer money) throws Exception {
		dao.updateAccount(id, -money);
	}
}
