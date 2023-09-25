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
@WebServlet("/makeaccount")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// session에 아이디가 없을 경우
		if(session.getAttribute("id") == null) {
			request.setAttribute("err", "로그인 하세요.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("makeaccount.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 1. request로부터 입력값 가져옴
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		Integer money = Integer.parseInt(request.getParameter("money"));
		String type = request.getParameter("type");
		String grade = request.getParameter("grade");
		
		// 2. Account 객체 생성
		Account acc = new Account(id, name, money, type, grade);
		
		// 3. Session을 얻어옴
		HttpSession session = request.getSession();
		
		// 4. 생성된 Account 객체를 session에 넣음
		session.setAttribute(id, acc);
		
		// 5. 생성된 Account 객체를 request에 넣음
		request.setAttribute("acc", acc);
		
		// 6. accountinfo.jsp로 포워드
		RequestDispatcher dispatcher = request.getRequestDispatcher("accountinfo.jsp");
		dispatcher.forward(request, response);
		
		// sendRedirect
		// 전달할 데이터 없이 특정 URL을 다시 요청할 때 사용 (URL이 바뀜)
		// session은 재요청한 페이지로 넘어갈 수 있음
		// spring에서 별로 사용하지 않음
	}

}
