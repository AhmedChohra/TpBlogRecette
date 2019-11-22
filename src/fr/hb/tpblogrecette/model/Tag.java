package fr.hb.tpblogrecette.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tag")
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;

	@Column
	protected String nom;

	@ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
	private Collection<Recette> recettes;

	/**
	 * @param nom
	 */
	public Tag(String nom) {
		super();
		this.nom = nom;
		this.recettes = new ArrayList<Recette>();

	}
	public Tag(String nom, Recette recette) {
		super();
		this.nom = nom;
		this.recettes = new ArrayList<Recette>();

	}

	/**
	 * 
	 */
	public Tag() {
		super();
		this.recettes = new ArrayList<Recette>();
	}
	
	
	/**
	 * @param recettes the recettes to set
	 */
	public void setRecettes(Collection<Recette> recettes) {
		this.recettes = recettes;
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
	


}
