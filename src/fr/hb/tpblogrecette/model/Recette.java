/**
 * 
 */
package fr.hb.tpblogrecette.model;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;



import javax.persistence.*;



@Entity
@Table(name = "recette")
public class Recette {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;


	@Column(name = "titre")
	private String titre;

	@Column(name = "description")
	private String description;

	@Column(name = "photo")
	private String photo;

	@Temporal(TemporalType.DATE)
	private Date dateCreation;

	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name="idMembre")
	private Membre membre;

	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name="idCategorie")
	private Categorie categorie;

	@OneToMany(mappedBy = "recette")
	private Collection<Commentaire> commentaires;

	@OneToMany(mappedBy = "recette", fetch = FetchType.LAZY)
	private Collection<Ingredient> ingredients;

	@ManyToMany(fetch = FetchType.EAGER)
	
	private Set<Tag> tags = new HashSet<Tag>();
	
	



	/**
	 * @param idMembre
	 * @param idCategorie
	 * @param titre
	 * @param description
	 * @param photo
	 * @param dateCreation
	 */
	public Recette(String titre, String description, String photo, Date dateCreation) {
		super();

		this.titre = titre;
		this.description = description;
		this.photo = photo;
		this.dateCreation = dateCreation;
		this.dateCreation = dateCreation;
		this.ingredients = new ArrayList<Ingredient>();
		this.commentaires = new ArrayList<Commentaire>();
	
	}
	public Recette(String titre, String description, Date dateCreation) {
		super();

		this.titre = titre;
		this.description = description;
		this.dateCreation = dateCreation;
		this.dateCreation = dateCreation;
		this.ingredients = new ArrayList<Ingredient>();
		this.commentaires = new ArrayList<Commentaire>();
	
	}
	/**
	 * 
	 */

	public Recette() {
		super();
		this.ingredients = new ArrayList<Ingredient>();
		this.commentaires = new ArrayList<Commentaire>();
		
	}
	
	
	/**
	 * 
	 */

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
	 * @return the idMembre
	 */

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}
	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}
	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
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
	/**
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}
	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
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

	public Collection<Ingredient> getIngredients(){
		return ingredients;
	}

	public Collection<Ingredient> addIngredient(Ingredient ingredient){
		ingredients.add(ingredient);
		return  ingredients;
	}

	public Collection<Ingredient> deleteIngredient(Ingredient ingredient){
		ingredients.remove(ingredient);
		return ingredients;
	}

	public Collection<Tag> getTags(){
		return tags;
	}

	public void addTag(Tag tag){
		this.tags.add(tag);
		
	}

	public Set<Tag> deleteTag(Tag tag){
		this.tags.remove(tag);
		return tags;
		
		
		
	}
	@Override
	public String toString() {
		return "Recette [id=" + id + ", idMembre=" + ", idCategorie=" + ", titre=" + titre
				+ ", description=" + description + ", photo=" + photo + ", dateCreation=" + dateCreation + "]";
	}
	/**
	 * @param tags the tags to set
	 */
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	/**
	 * @param commentaires the commentaires to set
	 */
	public void setCommentaires(Collection<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
	/**
	 * @param ingredients the ingredients to set
	 */
	public void setIngredients(Collection<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	
	/**
	 * @param arrayList the tags to set
	 */
	





}
