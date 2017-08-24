package examples.pubhub.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examples.pubhub.dao.TagDAO;
import examples.pubhub.model.BookTags;
import examples.pubhub.utilities.DAOUtilities;

/**
 * Servlet implementation class ListTagsServlet
 */
@WebServlet("/ListTags")
public class ListTagsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListTagsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		TagDAO dao=DAOUtilities.getAllTags();
		
			
		List<BookTags> list = dao.getAllTags();
		request.setAttribute("listtag", list);
		RequestDispatcher dispatch = request.getRequestDispatcher("addTag.jsp"); 
		dispatch.forward(request, response);			}
		
	}


