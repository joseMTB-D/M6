package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the llibre database table.
 * 
 */
@Entity
@NamedQuery(name="Llibre.findAll", query="SELECT l FROM Llibre l")
public class Llibre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String isbn;

	private String autor;

	private String categoria;

	private String editorial;

	private double preu;

	private String titol;

	
	public Llibre(String isbn, String autor, String categoria, String editorial, double preu, String titol) {
		super();
		this.isbn = isbn;
		this.autor = autor;
		this.categoria = categoria;
		this.editorial = editorial;
		this.preu = preu;
		this.titol = titol;
	}

	//bi-directional many-to-one association to Prestec
	@OneToMany(mappedBy="llibre")
	private List<Prestec> prestecs;

	public Llibre() {
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getEditorial() {
		return this.editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public double getPreu() {
		return this.preu;
	}

	public void setPreu(double preu) {
		this.preu = preu;
	}

	public String getTitol() {
		return this.titol;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	public List<Prestec> getPrestecs() {
		return this.prestecs;
	}

	public void setPrestecs(List<Prestec> prestecs) {
		this.prestecs = prestecs;
	}

	public Prestec addPrestec(Prestec prestec) {
		getPrestecs().add(prestec);
		prestec.setLlibre(this);

		return prestec;
	}

	public Prestec removePrestec(Prestec prestec) {
		getPrestecs().remove(prestec);
		prestec.setLlibre(null);

		return prestec;
	}

}