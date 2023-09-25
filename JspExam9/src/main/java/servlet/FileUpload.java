package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class FileUpload
 */
@WebServlet("/fileUpload")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUpload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("fileUploadForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 업로드 경로
		// upload 폴더로 지정
		String uploadPath = request.getRealPath("upload");
		
		int size = 10 * 1024 * 1024;
		//  request 객체, 저장될 서버 경로, 파일 최대 크기, 인코딩 방식, 같은 이름의 파일명 방지 처리
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		
		String name = multi.getParameter("name");	// 올린 사람
		String title = multi.getParameter("title");	// 제목
//		File file = multi.getFile("file");
//		
//		FileInputStream fis = new FileInputStream(file);
//		
		String orgFileName1 = multi.getOriginalFileName("file1");
		String orgFileName2 = multi.getOriginalFileName("file2");
//		
//		FileOutputStream dfile = new FileOutputStream(uploadPath + "/" + orgFileName);
//		byte[] buff = new byte[1024];
//		int len = 0;
//		while((len = fis.read(buff)) > 0) {
//			dfile.write(buff, 0, len);
//		}
		
		System.out.println(name);
		System.out.println(title);
		System.out.println(orgFileName1);
		System.out.println(orgFileName2);
		
		request.setAttribute("name", name);
		request.setAttribute("title", title);
		request.setAttribute("file1", orgFileName1);
		request.setAttribute("file2", orgFileName2);
		request.getRequestDispatcher("fileUploadResult.jsp").forward(request, response);
//		dfile.close();
//		fis.close();
	}

}
