package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Member;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// login.jsp로 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 1. request에서 id, password를 가져옴
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. session에서 member를 가져옴
		// 연습 코드이므로, 회원가입이 우선되어서 session에 가입된 회원 정보를 넣어준 뒤
		// 해당 session에 넣어진 회원 정보를 가져와 비교하는 방식
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		
		RequestDispatcher dispatcher = null;
		// 2-1. member가 null이면 error 페이지로 포워딩 (회원가입 하세요.)
		if(member == null) {
			request.setAttribute("err", "회원가입 하세요.");
			dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		// 3. 가져온 member와 id를 비교
		// 3-1. 같지 않으면 error 페이지로 포워딩 (아이디가 틀립니다.)
		if(member.getId().equals(id) == false) {
			request.setAttribute("err", "아이디가 틀립니다.");
			dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
			return;
		}
		// 4. 가져온 member와 password를 비교
		// 4-1. 같지 않으면 error 페이지로 포워딩 (비밀번호가 틀립니다.)
		if(member.getPassword().equals(password) == false) {
			request.setAttribute("err", "비밀번호가 틀립니다.");
			dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		// 5. id를 session에 넣고 makeaccount.jsp 페이지로 포워딩
		session.setAttribute("id", id);
		dispatcher = request.getRequestDispatcher("makeaccount.jsp");
		dispatcher.forward(request, response);
	}

}
