package fr.hb.tpblogrecette.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import fr.hb.tpblogrecette.model.Ingredient;

import fr.hb.tpblogrecette.model.Recette;
import fr.hb.tpblogrecette.services.IngredientService;
import fr.hb.tpblogrecette.services.RecetteService;

/**
 * Servlet implementation class AjoutIngredient
 */
@WebServlet(name="AjoutIngredient", urlPatterns= {"/ajout-ingredient"})
public class AjoutIngredientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjoutIngredientServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//send recette to jsp
			int idRecette = Integer.parseInt(request.getParameter("id"));
			RecetteService recetteService = new RecetteService();
			Recette recette = recetteService.getRecetteFromId(idRecette);
			request.setAttribute("recette", recette);
			
			//send ingredients by recette to jsp
			IngredientService ingredientService = new IngredientService();
			List<Ingredient> ingredients = ingredientService.getIngredientFromRecette(idRecette);
			request.setAttribute("ingredients", ingredients);
		
			
		} catch (Exception e) {
			
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/ajoutIngredient.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		
		String erreur = "";
		
		
		//get all parameters
		String nom = request.getParameter("nom");
		if (nom.isEmpty()) {
			erreur += "Veuillez saisir un nom d'ingredient<br>";
		}
		String quantite = request.getParameter("quantite");
		if (quantite.isEmpty()) {
			erreur += "Veuillez saisir une quantité<br>";
		}
		String unite = request.getParameter("unite");
		if (unite.isEmpty()) {
			erreur += "Veuillez saisir une unité<br>";
		}

		//change quantity in int
		Integer quantit = Integer.parseInt(quantite);
		


		if (erreur.isEmpty()) {

			try {
				//creation of ingredient
				Ingredient ingredient = new Ingredient(nom, quantit, unite);
				IngredientService ingredientService = new IngredientService();
				ingredientService.createIngredient(ingredient);
				
				//get recette object and add ingredient
				int idRecette = Integer.parseInt(request.getParameter("id"));
				RecetteService recetteService = new RecetteService();
				Recette recette = recetteService.getRecetteFromId(idRecette);
				ingredient.setRecette(recette);
				ingredientService.updateIngredient(ingredient);
				
				//redirection
				this.doGet(request, response);
				
			}catch (Exception e) {

				e.printStackTrace();

			}
		}

		else {

			request.setAttribute("erreur", erreur);
			this.doGet(request, response);
		}
	}


}
