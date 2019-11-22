/**
 * 
 */
package fr.hb.tpblogrecette.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ingredient")
public class Ingredient {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "quantite")
	private int quantite;
	
	@Column(name = "unit")
	private String unit;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name="idrecette")
	private Recette recette;


	public Ingredient(String nom, int quantite, String unit) {
		super();
		this.nom = nom;
		this.quantite = quantite;
		this.unit = unit;
	}
	/**
	 * @param idRecette
	 * @param nom
	 * @param quantite
	 * @param unit
	 */
	/**
	 * 
	 */
	public Ingredient() {
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
	 * @return the quantite
	 */
	public int getQuantite() {
		return quantite;
	}
	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
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
	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", nom=" + nom + ", quantite=" + quantite
				+ ", unit=" + unit + "]";
	}





}
