package fr.hb.tpblogrecette.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import fr.hb.tpblogrecette.model.*;

import fr.hb.tpblogrecette.services.CommentaireService;
import fr.hb.tpblogrecette.services.IngredientService;
import fr.hb.tpblogrecette.services.MembreService;
import fr.hb.tpblogrecette.services.RecetteService;
import fr.hb.tpblogrecette.services.TagService;


/**
 * Servlet implementation class Recette
 */
@WebServlet(name="Recette", urlPatterns= {"/recette"})
public class RecetteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecetteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub



		try {



			int idRecette = Integer.parseInt(request.getParameter("id"));
			RecetteService recetteService = new RecetteService();
			fr.hb.tpblogrecette.model.Recette recette = recetteService.getRecetteFromId(idRecette);
			request.setAttribute("recette", recette);

			IngredientService ingredientService = new IngredientService();
			List<Ingredient> ingredients = ingredientService.getIngredientFromRecette(idRecette);
			request.setAttribute("ingredients", ingredients);

			TagService tagService = new TagService();
			List<Tag> tags = tagService.getTagbyRecette(idRecette);
			request.setAttribute("tags", tags);
			List<Tag> allTags = tagService.getAllTags();
			request.setAttribute("allTags", allTags);



			int idRecet = Integer.parseInt(request.getParameter("id"));
			CommentaireService commentaireService = new CommentaireService();
			List<fr.hb.tpblogrecette.model.Commentaire> commentaires = commentaireService.getCommentaireByRecette(idRecet);
			request.setAttribute("commentaires", commentaires);


			int noteAverage = commentaireService.getNoteAverageFromRecette(idRecette);
			request.setAttribute("noteAverage", noteAverage);

		} catch (Exception e) {
			// TODO: handle exception
		}



		this.getServletContext().getRequestDispatcher("/WEB-INF/recette.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setCharacterEncoding("UTF-8");

		String erreur = "";

		int idRecette = Integer.parseInt(request.getParameter("id"));

		Recette recette = new Recette();
		
		RecetteService recetteService = new RecetteService();
		Recette recet = recetteService.getRecetteFromId(idRecette);
		recette.setId(idRecette);
		
		//ajout tag
		String sTag= null;
		sTag = request.getParameter("tag");

		if (sTag != null) {
			TagService tagService = new TagService();
			Tag tag = tagService.getTagFromNom(sTag);
			recet.addTag(tag);
			
			
			recetteService.updateRecette(recet);
			doGet(request, response);
		}



		String auteur = request.getParameter("auteur");
		if (auteur.isEmpty()) {
			erreur += "Veuillez saisir un nom<br>";
		}

		String contenu = request.getParameter("contenu");
		if (contenu.isEmpty()) {
			erreur += "Veuillez saisir un commentaire<br>";
		}

		int note = Integer.parseInt(request.getParameter("note"));





		Commentaire commentaire = new Commentaire(auteur, contenu, note, new Date() );

		if (erreur.isEmpty()) {


			try {


				HttpSession session = request.getSession();

				Membre membre = (Membre) session.getAttribute("membre");

				CommentaireService commentaireService = new CommentaireService();
				commentaire.setRecette(recette);
				commentaire.setMembre(membre);
				commentaireService.createCommentaire(commentaire);	


				session.setAttribute("commentaire", commentaire);
				this.doGet(request, response);
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}

		else {

			request.setAttribute("erreur", erreur);
			this.doGet(request, response);
		}

	}

}
