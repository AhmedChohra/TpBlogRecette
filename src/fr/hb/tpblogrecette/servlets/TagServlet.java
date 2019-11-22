package fr.hb.tpblogrecette.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.hb.tpblogrecette.model.Membre;
import fr.hb.tpblogrecette.model.Tag;
import fr.hb.tpblogrecette.services.MembreService;
import fr.hb.tpblogrecette.services.TagService;

/**
 * Servlet implementation class Tag
 */
@WebServlet(name="Tag", urlPatterns= {"/tag"})
public class TagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @param nom 
	 * @see HttpServlet#HttpServlet()
	 */
	public TagServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		TagService tagService = new TagService();
		
		List<Tag> allTags = tagService.getAllTags();
		request.setAttribute("allTags", allTags);

		this.getServletContext().getRequestDispatcher("/WEB-INF/tag.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		HttpSession session = request.getSession();

		String erreur = "";
		Date dateInscription = new Date();

		String nom = request.getParameter("nom");
		if (nom.isEmpty()) {
			erreur += "Veuillez saisir un tag<br>";
		}

		Tag tag = new Tag(nom);

		if (erreur.isEmpty()) {


			try {



				TagService tagService = new TagService();
				tagService.createTag(tag);
				session.setAttribute("tag", tag);
				response.sendRedirect("tag");


			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		}



		else {

			request.setAttribute("erreur", erreur);
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/tag.jsp").forward(request, response);
		}
	}
	
}
