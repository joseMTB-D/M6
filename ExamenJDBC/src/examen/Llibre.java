package examen;

public class Llibre {

	private String isbn;
	private String titol;
	private double preu;
	private String categoria;
	private String autor;
	private String editorial;
	
	public Llibre() {
		super();
	}
	public Llibre(String isbn, String titol, String categoria, double preu, String editorial,String autor) {
		super();
		this.isbn = isbn;
		this.titol = titol;
		this.preu = preu;
		this.categoria = categoria;
		this.autor = autor;
		this.editorial = editorial;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitol() {
		return titol;
	}
	public void setTitol(String titol) {
		this.titol = titol;
	}
	public double getPreu() {
		return preu;
	}
	public void setPreu(double preu) {
		this.preu = preu;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	
}
