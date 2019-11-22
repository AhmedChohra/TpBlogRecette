package fr.hb.tpblogrecette.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.hb.tpblogrecette.model.Tag;
import fr.hb.tpblogrecette.services.TagService;

/**
 * Servlet implementation class DeleteTagServlet
 */
@WebServlet("/delete-tag")
public class DeleteTagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTagServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);

		TagService ts = new TagService();
		Tag tag = null;
		try {
			tag = ts.getTagFromId(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ts.deleteTag(tag);
		// On redirige vers la liste de tag 

		response.sendRedirect("/TpBlogRecette/tag");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
