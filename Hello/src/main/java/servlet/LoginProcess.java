package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginProcess
 */
@WebServlet("/login")
// jsp에서 sevlet을 이용하기 위해 호출하는데
// <form action="login" method="post">와 같이 사용
// post는 SQL로 따지면 Create이며, doPost로 사용해야 함
// 헤더에 가벼운 값, 바디에 무겁거나 보안에 중요한 값을 담아 보냄

// 게시글 작성 등에 사용
// get는 SQL로 따지면 Select이며, doGet로 사용해야 함
// 헤더에 가벼운 값을 담아 보냄
// 주로 데이터를 요청(Select)할 때 사용
public class LoginProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// request.getParameter("") 내의 String 파라미터는
		// 현재 servlet을 사용하려는 jsp 내에서 지정
		// 예를 들어, <input type="text" name="id"/>와 같이 지정된 문자열로 연동하는 느낌
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		System.out.println(id);
		System.out.println(password);
		
		// LoginSuccess.jsp에서 사용할 때만?
		RequestDispatcher dispatcher = request.getRequestDispatcher("LoginSuccess.jsp");
		dispatcher.forward(request, response);
	}

}
