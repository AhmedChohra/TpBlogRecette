package fr.hb.tpblogrecette.servlets;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import fr.hb.tpblogrecette.model.Categorie;
import fr.hb.tpblogrecette.model.Image;
import fr.hb.tpblogrecette.model.Membre;
import fr.hb.tpblogrecette.model.Recette;
import fr.hb.tpblogrecette.services.CategorieService;
import fr.hb.tpblogrecette.services.ImageService;
import fr.hb.tpblogrecette.services.RecetteService;

/**
 * Servlet implementation class AjoutRecette
 */
@WebServlet(name="AjoutRecette", urlPatterns= {"/ajout-recette"})
@MultipartConfig
public class AjoutRecetteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutRecetteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CategorieService categorieService = new CategorieService();
		List<Categorie> categories = categorieService.getAllCategories();
		request.setAttribute("categories", categories);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajoutRecette.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		String erreur = "";
		
		//ajout categorie
		CategorieService categorieService = new CategorieService();
		int idCategorie = Integer.parseInt(request.getParameter("categorie"));
		Categorie categorie = categorieService.getCategorieFromId(idCategorie);
		
		String titre = request.getParameter("titre");
		if (titre.isEmpty()) {
			erreur += "Veuillez saisir un titre<br>";
		}
		
		String description = request.getParameter("description");
		if (description.isEmpty()) {
			erreur += "Veuillez saisir un description<br>";
		}
		
		/*String nomFichier = request.getParameter("nomFichier");
		if (description.isEmpty()) {
			erreur += "Veuillez saisir un nom de fichier image<br>";
		}*/
		//ajout image
				String savePath = "D:\\doc_hb\\eclipse-workspace\\TpBlogRecette\\WebContent\\img" + File.separator /*+ SAVE_DIR*/; //specify your path here
				File fileSaveDir=new File(savePath);
				if(!fileSaveDir.exists()){
					fileSaveDir.mkdir();
				}
				Part part=request.getPart("file");
				String fileName=getNomFichier(part);
				part.write(savePath + File.separator + fileName);
				String filePath= savePath + File.separator + fileName;
				ImageService imageService = new ImageService();
				Image image = new Image(filePath,fileName);
		
		Recette recette = new Recette(titre, description, fileName, new Date());
		
		
		
		
		
if (erreur.isEmpty()) {
			
			try {

				RecetteService recetteService = new RecetteService();
				recetteService.createRecette(recette);	
				Membre membre = (Membre) session.getAttribute("membre");
				recette.setMembre(membre);
				recette.setCategorie(categorie);
				
				recetteService.updateRecette(recette);
				imageService.createImage(image);
				image.setRecette(recette);
				imageService.updateImage(image);
				response.sendRedirect("recette?id="+ recette.getId());
				
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}

		else {

			request.setAttribute("erreur", erreur);
			doGet(request, response);
		}
		
	}
	
	private String getNomFichier(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length()-1);
			}
		}
		return "";
	}

}
