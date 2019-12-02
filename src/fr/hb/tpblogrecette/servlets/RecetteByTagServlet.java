package fr.hb.tpblogrecette.servlets;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.hb.tpblogrecette.model.Recette;
import fr.hb.tpblogrecette.model.Tag;

import fr.hb.tpblogrecette.services.RecetteService;
import fr.hb.tpblogrecette.services.TagService;

/**
 * Servlet implementation class RecetteByTagServlet
 */
@WebServlet(name="RecetteByTag", urlPatterns= {"/recette-by-tag"})
public class RecetteByTagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecetteByTagServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			
			RecetteService recetteService = new RecetteService();
			int id = Integer.parseInt(request.getParameter("id"));
			
			TagService tagService = new TagService();
			Tag tag =  tagService.getTagFromId(id);

			request.setAttribute("tag", tag);
			
			
			
			
			
			List<Recette> recettes = recetteService.getRecetteByTag(id);
			
			request.setAttribute("recettes", recettes);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		this.getServletContext().getRequestDispatcher("/WEB-INF/recetteByTag.jsp").forward(request, response);
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
}

}
