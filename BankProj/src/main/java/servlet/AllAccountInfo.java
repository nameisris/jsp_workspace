package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Account;

/**
 * Servlet implementation class AllAccountInfo
 */
@WebServlet("/allaccountinfo")
public class AllAccountInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllAccountInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Account> accs = new ArrayList<>();
		// session 가져오기
		HttpSession session = request.getSession();
		
		// 모든 Attribute의 Key값 가져오기
		Enumeration<String> e = session.getAttributeNames();
		
		while(e.hasMoreElements()) {
			String name = e.nextElement();
			
			// 멤버 여부
			if(name.equals("member") || name.equals("id")) continue;
			
			Account acc = (Account) session.getAttribute(name);
			accs.add(acc);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		if(accs.size() > 0) {
			request.setAttribute("accs", accs);
			request.setAttribute("page", "allaccountinfo");
		} else {
			request.setAttribute("err", "개설된 계좌가 없습니다.");
			request.setAttribute("page", "error");
		}
		
		dispatcher.forward(request, response);
	}

}
