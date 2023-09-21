package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Account;

/**
 * Servlet implementation class MakeAccount
 */
@WebServlet("/makeAccount")
public class MakeAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 계좌 계설 페이지에서 넣은 값에 대해
		// '계좌 개설' 버튼을 제출이 일어날 경우
		// 값 다 넣어줌
		// 특정 "id"의 value를 가져옴
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		Integer money = Integer.parseInt(request.getParameter("money"));
		String type = request.getParameter("type");
		String grade = request.getParameter("grade");
		if(grade == null) grade = "";
		
		// Account 객체로 값 넣어줌
		Account acc = new Account(id, name, money, type, grade);
		// request에서 session 가져옴
		HttpSession session = request.getSession();
		// session에 아이디 변수랑 acc 객체 set
		session.setAttribute(id, acc);
		
		// request에 acc 이름으로 acc 객체 set
		request.setAttribute("acc", acc);
		// request에 page 이름으로
		request.setAttribute("page", "accountinfo");
		
		// main.jsp로 request 데이터와 함께 페이지 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
		dispatcher.forward(request, response);
	}

}
