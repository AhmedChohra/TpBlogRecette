/**
 * 
 */
package fr.hb.tpblogrecette.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "commentaire")
public class Commentaire {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
	private int id;
	
		
	@Column(name = "auteur")
	private String auteur;
	
	@Column(name = "contenu")
	private String contenu;
	
	@Column(name = "note")
	private int note;
	
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name="idRecette")
	Recette recette;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name="idMembre")
	Membre membre;
	/**
	 * @param idRecette
	 * @param auteur
	 * @param contenu
	 * @param note
	 * @param dateCreation
	 */
	public Commentaire( String auteur, String contenu, int note, Date dateCreation) {
		super();
		
		this.auteur = auteur;
		this.contenu = contenu;
		this.note = note;
		this.dateCreation = dateCreation;
	}
	/**
	 * 
	 */
	public Commentaire() {
		super();
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
	/**
	 * @return the idRecette
	 */
	
	/**
	 * @return the auteur
	 */
	public String getAuteur() {
		return auteur;
	}
	/**
	 * @param auteur the auteur to set
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	/**
	 * @return the contenu
	 */
	public String getContenu() {
		return contenu;
	}
	/**
	 * @param contenu the contenu to set
	 */
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	/**
	 * @return the note
	 */
	public int getNote() {
		return note;
	}
	/**
	 * @param note the note to set
	 */
	public void setNote(int note) {
		this.note = note;
	}
	/**
	 * @return the dateCreation
	 */
	public Date getDateCreation() {
		return dateCreation;
	}
	/**
	 * @param dateCreation the dateCreation to set
	 */
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	
	
	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", idRecette=" + ", auteur=" + auteur + ", contenu=" + contenu
				+ ", note=" + note + ", dateCreation=" + dateCreation + "]";
	}
	/**
	 * @return the recette
	 */
	public Recette getRecette() {
		return recette;
	}
	/**
	 * @param recette the recette to set
	 */
	public void setRecette(Recette recette) {
		this.recette = recette;
	}
	/**
	 * @return the membre
	 */
	/**
	 * @return the membre
	 */
	public Membre getMembre() {
		return membre;
	}
	/**
	 * @param membre the membre to set
	 */
	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	
	
	


	
}
