package controller.component;

import controller.Controller;
import controller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO.ex.MemberDAO;
import model.vo.ex.MemberEx;

public class SearchController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemberDAO dao = new MemberDAO();
		String id = request.getParameter("id"); 

	
			MemberEx member = dao.search(id);
		
			
			if(member != null) {
				
				request.setAttribute("member", member);
				return new ModelAndView("/views/search_ok.jsp");
			} 
				return new ModelAndView("/views/search_fail.jsp",true);
			

	}

	
	
	
	
	
}
