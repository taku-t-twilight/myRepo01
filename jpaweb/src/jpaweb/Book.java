package jpaweb;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the BOOK database table.
 * 
 */
@Entity
@NamedQuery(name="Book.findAll", query="SELECT b FROM Book b")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	private String description;

	private String illustrations;

	private String isbn;

	private int nbofpage;

	private double price;

	private String title;

	public Book() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIllustrations() {
		return this.illustrations;
	}

	public void setIllustrations(String illustrations) {
		this.illustrations = illustrations;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getNbofpage() {
		return this.nbofpage;
	}

	public void setNbofpage(int nbofpage) {
		this.nbofpage = nbofpage;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}