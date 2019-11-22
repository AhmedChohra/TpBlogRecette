package fr.hb.tpblogrecette.servlets;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.hb.tpblogrecette.model.Categorie;
import fr.hb.tpblogrecette.model.Recette;
import fr.hb.tpblogrecette.services.CategorieService;
import fr.hb.tpblogrecette.services.RecetteService;


/**
 * Servlet implementation class Accueil
 */
@WebServlet(name="Index", urlPatterns= {"", "/index"})
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
    /**
     * @param connection 
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
				
		
		
		
		try {
			
			
			
			RecetteService recetteService = new RecetteService();
			List<Recette> recettes = recetteService.getAllRecettes();
			
			request.setAttribute("recettes", recettes);
			
			CategorieService categorieService = new CategorieService();
			List<Categorie> categories = categorieService.getAllCategories();

			request.setAttribute("categories", categories);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
