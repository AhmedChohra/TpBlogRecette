package fr.hb.tpblogrecette.servlets;

import java.io.IOException;
import java.util.List;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.hb.tpblogrecette.services.CategorieService;
import fr.hb.tpblogrecette.services.RecetteService;




/**
 * Servlet implementation class Categorie
 */
@WebServlet(name="Categorie", urlPatterns= {"/categorie"})
public class CategorieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategorieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			

			CategorieService categorieService = new CategorieService();
			List<fr.hb.tpblogrecette.model.Categorie> categories = categorieService.getAllCategories();

			request.setAttribute("categories", categories);
			
			RecetteService recetteService = new RecetteService();
			
			int idCategorie = Integer.parseInt(request.getParameter("idCategorie"));
			List<fr.hb.tpblogrecette.model.Recette> recettes = recetteService.getRecetteByCategorie(idCategorie);
			
			request.setAttribute("recettes", recettes);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		this.getServletContext().getRequestDispatcher("/WEB-INF/categorie.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
