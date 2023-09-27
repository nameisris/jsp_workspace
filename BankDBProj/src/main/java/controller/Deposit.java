package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Account;
import service.AccountService;

/**
 * Servlet implementation class Deposit
 */
@WebServlet("/deposit")
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deposit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("deposit.jsp").forward(request, response);
	}

	/**
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		Integer money = Integer.parseInt(request.getParameter("money"));
		AccountService accountService = new AccountService();
		Account acc = null;
		
		try {
			acc = accountService.selectAccount(id);
			if(!(acc.deposit(money))) throw new Exception("0원 이상 입금해주세요.");
			accountService.deposit(id, acc.getBalance());
			
			request.setAttribute("acc", acc);
			request.getRequestDispatcher("accountinfo.jsp").forward(request, response);;
		} catch(Exception e) {
			request.setAttribute("err", e.getMessage());;
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}

	}

}
