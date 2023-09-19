package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemRegProcess
 */
@WebServlet("/memReg")
public class MemRegProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemRegProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("memRegSuccess.jsp");
		dispatcher.forward(request, response);
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request를 통해서
		// RequestDispatcher형 dispatcher를 얻어옴
		// dispatcher에 request를 담아서 같이 보냄
		// 단순히 백엔드에서 실행시켜달라고 요청
//		RequestDispatcher dispatcher = request.getRequestDispatcher("memReg.html");
//		dispatcher.forward(request, response);
		
		
		// 주소창에 찍는건 무조건 GET 방식 요청
		// memReg로 요청하지만,
		// memReg로 redirect
		// sendRedirect는 url이 바뀜 (memReg를 주소창에 찍으면 memReg.html로)
		// sendRedirect 안의 링크로 다시 요청하는 방식이기에 url이 바뀜
		response.sendRedirect("memReg.html");
		
		// 즉, 데이터를 JSP로 넘겨주고 싶을 때는 forward를 통해 request를 보냄
		// sendRedirect는 비어있는 페이지를 요청할 때 사용
	}

}
