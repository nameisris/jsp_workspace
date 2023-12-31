package servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CurrentTime
 */
@WebServlet("/CurrentTime")
public class CurrentTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CurrentTime() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		
//		PrintWriter out = response.getWriter();
//		out.write("<html><head><title>현재시간</title></head>");
//		out.write("<body><h1>현재시간은 ");
//		out.write(hour + "");
//		out.write("시 ");
//		out.write(minute + "");
//		out.write("분 ");
//		out.write(second + "");
//		out.write("초 입니다.</h1></body></html>");
//		out.close();
		
		// request에 map 형식으로 데이터 삽입
		request.setAttribute("hour", hour);
		request.setAttribute("minute", minute);
		request.setAttribute("second", second);
		
		// CurrentTime.jsp와 연결
		RequestDispatcher dispatcher = request.getRequestDispatcher("CurrentTime.jsp");
		
		// 위임할 페이지인 dispatcher에 request를 보냄
		dispatcher.forward(request, response);
		
	}

}
