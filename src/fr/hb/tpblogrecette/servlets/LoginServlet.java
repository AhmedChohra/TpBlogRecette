package fr.hb.tpblogrecette.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.hb.tpblogrecette.model.Membre;
import fr.hb.tpblogrecette.services.MembreService;


/**
 * Servlet implementation class login
 */
@WebServlet(name="Login", urlPatterns= {"/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		String erreur = "";
		
		
		
		String pseudoEmail = request.getParameter("pseudoEmail");
		if (pseudoEmail.isEmpty()) {
			erreur += "Veuillez saisir un pseudo ou un email<br>";
		}
						
		String mdp = request.getParameter("mdp");
		if (mdp.isEmpty()) {
			erreur += "Veuillez saisir un mot de passe<br>";
		}
		
		
		
		
		
		if (erreur.isEmpty()) {
			

			try {


				
				MembreService membreService = new MembreService();
				Membre membre =membreService.getMembreFromPseudoAndPsw(pseudoEmail, mdp);
				
				
				if (membre != null) {
					session.setAttribute("membre", membre);
					response.sendRedirect("index");
				}
				else {
					erreur += "Veuillez saisir un mot de passe ou pseudo valide<br>";
					request.setAttribute("erreur", erreur);
					doGet(request, response);
				}
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
}
