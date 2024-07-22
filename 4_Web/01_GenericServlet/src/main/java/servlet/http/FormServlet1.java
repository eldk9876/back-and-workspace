package servlet.http;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/form")
public class FormServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		//System.out.println("form으로 요청 받음!");
		
		String Id = request.getParameter("userId");
		
		String Pwd = request.getParameter("userPwd");
		
		String gender = request.getParameter("gender");
		
		String[] menuList = request.getParameterValues("menu");
	
		
		
		
		
		// 응답!
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>정보를 출력합니다..</h1>");
		out.println("<h4>당신의 아이디는 : " + Id + "</h4>");

		out.println("<h4>당신의 비밀번호는 : " + Pwd + "</h4>");

		String genderResult = gender.equals("M") ? "남자" : "여자";
		out.println("<p>당신의 성별은 : " + genderResult + "</p>");
		
		if(menuList != null)
			out.println("<ul>");
		for(String menu : menuList) {
			out.println("<li>" + menu + "</li>" );
		}
		
		out.println("<ul>");
		out.println("</body></html>");
		
		
	}

}
