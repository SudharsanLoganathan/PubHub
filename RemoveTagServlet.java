package examples.pubhub.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examples.pubhub.dao.TagDAOImpl;

/**
 * Servlet implementation class RemoveTagServlet
 */
@WebServlet("/RemoveTagServlet")
public class RemoveTagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveTagServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn13=request.getParameter("isbn13");
		String tagName=request.getParameter("tagName");
		TagDAOImpl dao=new TagDAOImpl();
		dao.removeTag(isbn13,tagName);
		response.sendRedirect("listTags.jsp");
	}

}
