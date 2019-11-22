/**
 * 
 */
package fr.hb.tpblogrecette.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "membre")
public class Membre {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "pseudo")
	private String pseudo;
	
	@Column(name = "mdp")
	private String mdp;
	
	@Column(name = "email")
	private String email;
	

	
	@Temporal(TemporalType.DATE)
	private Date dateInscription;
	
	@OneToMany(mappedBy = "membre")
    private Collection<Recette> recettes;
	
	@OneToMany(mappedBy = "membre", cascade = CascadeType.ALL)
    private Collection<Commentaire> commentaires;
	
	
	
	
	/**
	 * @return the recette
	 */
	
	/**
	 * @param nom
	 * @param pseudo
	 * @param mdp
	 * @param email
	 * @param dateInscription
	 */
	public Membre(String nom, String pseudo, String mdp, String email, Date dateInscription) {
		super();
		this.nom = nom;
		this.pseudo = pseudo;
		this.mdp = mdp;
		this.email = email;
		this.dateInscription = dateInscription;
		this.recettes = new ArrayList<Recette>();
		this.commentaires = new ArrayList<Commentaire>();
		
	}
	/**
	 * 
	 */
	public Membre() {
		super();
		this.recettes = new ArrayList<Recette>();
		this.commentaires = new ArrayList<Commentaire>();
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}
	/**
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	/**
	 * @return the mdp
	 */
	public String getMdp() {
		return mdp;
	}
	/**
	 * @param mdp the mdp to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the dateInscription
	 */
	public Date getDateInscription() {
		return dateInscription;
	}
	/**
	 * @param dateInscription the dateInscription to set
	 */
	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	public Collection<Recette> getRecettes(){
        return recettes;
    }

    public Collection<Recette> addRecette(Recette recette){
    	recettes.add(recette);
        return  recettes;
    }

    public Collection<Recette> deleteRecette(Recette recette){
    	recettes.remove(recette);
        return recettes;
    }
    
    public Collection<Commentaire> getCommentaires(){
        return commentaires;
    }

    public Collection<Commentaire> addCommentaire(Commentaire commentaire){
    	commentaires.add(commentaire);
        return  commentaires;
    }

    public Collection<Commentaire> deleteCommentaire(Commentaire commentaire){
    	commentaires.remove(commentaire);
        return commentaires;
    }
	
	/**
	 * @return the carteIdentité
	 */
	
	@Override
	public String toString() {
		return "Membre [nom=" + nom + ", pseudo=" + pseudo + ", mdp=" + mdp + ", email=" + email + ", dateInscription="
				+ dateInscription + "]";
	}
	/**
	 * @return the carteIdentite
	 */

	
	
	
	
	
}