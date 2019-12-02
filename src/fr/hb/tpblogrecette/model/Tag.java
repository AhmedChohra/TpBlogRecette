package fr.hb.tpblogrecette.model;



import java.util.Collection;
import java.util.HashSet;

import java.util.Set;


import javax.persistence.*;


@Entity
@Table(name = "tag")
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;

	@Column
	protected String nom;

	@ManyToMany(mappedBy = "tags", fetch = FetchType.EAGER)
	private Set<Recette> recettes = new HashSet<Recette>();

	/**
	 * @param nom
	 */
	public Tag(String nom) {
		super();
		this.nom = nom;
		

	}
	public Tag(String nom, Recette recette) {
		super();
		this.nom = nom;
		

	}

	/**
	 * 
	 */
	public Tag() {
		super();
		
	}
	
	
	/**
	 * @param recettes the recettes to set
	 */
	

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

	public void addRecette(Recette recette){
		this.recettes.add(recette);
		recette.getTags().remove(this);
		
	}

	public void deleteRecette(Recette recette){
		this.recettes.remove(recette);
		recette.getTags().remove(this);
	}
	
	

}
