package fr.hb.tpblogrecette.model;

import javax.persistence.*;


@Entity
@Table(name="image")
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idImage;
	@Column(name="chemin")
	private String chemin;
	@Column(name="nameImage")
	private String nameImage;
	@OneToOne
	private Recette recette;
	
	public Image() {
	}
	public Image(Integer id, String chemin) {
		this.idImage = id;
		this.chemin = chemin;
	}
	public Image( String chemin,String nom) {
		this.chemin = chemin;
		this.nameImage=nom;
	}
	public int getId() {
		return this.idImage;
	}
	public void setId(int id) {
		this.idImage = id;
	}
	public String getNameImage() {
		return this.nameImage;
	}
	public void setNameimage(String nom) {
		this.nameImage = nom;
	}
	public String getChemin() {
		return chemin;
	}
	public void setChemin(String name) {
		this.chemin = name;
	}
	public void setRecette(Recette recette) {
		this.recette = recette;
	}
	public Recette getRecette() {
		return this.recette;
	}
}
