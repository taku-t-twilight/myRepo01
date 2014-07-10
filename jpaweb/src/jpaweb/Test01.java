package jpaweb;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test01 {
	private int id;
	private String description;
	private String illustration;
	private String isbn;
	private String title;
	private int noOfPage;
	private int price;
	
	public Test01(String id, String description, String illustrations, String isbn, String noobpage, String price, String title) {
		this.id = Integer.parseInt(id);
		this.description = description;
		this.illustration = illustrations;
		this.title = title;
		this.isbn = isbn;
		this.noOfPage = Integer.parseInt(noobpage);
		this.price = Integer.parseInt(price);
	}

	public void entry(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaweb");
		EntityManager em = emf.createEntityManager();
		
		Book book = new Book();
		book.setId(this.id);
		book.setDescription(this.description);
		book.setIllustrations(this.illustration);
		book.setIsbn(this.isbn);
		book.setNbofpage(this.noOfPage);
		book.setPrice(this.price);
		book.setTitle(this.title);

		// Persists the book to the database
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(book);
        tx.commit();

        em.close();
        emf.close();
	}

	public static void main(String args[]){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaweb");
		EntityManager em = emf.createEntityManager();
		
		Book book = new Book();
//		book.setId(10);
//		book.setDescription("JPA Guide");
//		book.setIllustrations("1");
//		book.setIsbn("1234-5678-90");
//		book.setNbofpage(10);
//		book.setPrice(10);
//		book.setTitle("JPA Introduction");
		
		
        // Persists the book to the database
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(book);
        tx.commit();

        em.close();
        emf.close();
	}
}
