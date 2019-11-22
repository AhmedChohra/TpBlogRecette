/**
 * 
 */
package fr.hb.tpblogrecette.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author HB
 *
 */
@Entity
@Table(name = "categorie")
public class Categorie {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "nom")
	private String nom;
	
	@OneToMany(mappedBy = "categorie")
    private Collection<Recette> recettes;

	/**
	 * @param nomString
	 */
	public Categorie(String nom) {
		super();
		this.nom = nom;
		this.recettes = new ArrayList<Recette>();
	}

	/**
	 * 
	 */
	public Categorie() {
		super();
		this.recettes = new ArrayList<Recette>();
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

	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nom=" + nom + "]";
	}

	
	
	

}
