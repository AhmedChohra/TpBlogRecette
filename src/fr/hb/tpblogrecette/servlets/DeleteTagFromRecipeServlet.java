package fr.hb.tpblogrecette.servlets;

import java.io.IOException;


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
 * Servlet implementation class DeleteTagFromRecipe
 */
@WebServlet("/delete-tag-from-recipe")
public class DeleteTagFromRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteTagFromRecipeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idTag = request.getParameter("tag_id");
		int idT = Integer.parseInt(idTag);
		String idRecette = request.getParameter("recette_id");
		int idR = Integer.parseInt(idRecette);

		RecetteService recetteService = new RecetteService();
		Recette recette = recetteService.getRecetteFromId(idR);
		TagService tagService = new TagService();
		Tag tag = tagService.getTagFromId(idT);

		recetteService.deleteTag(recette, tag);

		response.sendRedirect("/TpBlogRecette/recette?id="+idR);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
