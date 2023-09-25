package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserInfo
 */
@WebServlet("/userInfo")
public class UserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("UserInfoForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		// DB에서 id로 사용자 조회 (임의)
		// User user = new User(id, "홍길동", "서울시 금천구", "hong@kosta.com");
		
		Map<String, String> user = new HashMap<>();
		user.put("id", id);
		user.put("name", "홍길동");
		user.put("address", "서울시 금천구");
		user.put("email", "hong@kosta.con");
		
		// session에 값 담기
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		request.setAttribute("user", user);
		
		request.getRequestDispatcher("userInfo.jsp").forward(request, response);
	}

}
