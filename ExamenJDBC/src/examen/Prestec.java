package examen;

public class Prestec {
	private int codi;
	private String isbn;
	private String dni;
	private String data_retorn;
	private int retornat;

	public Prestec() {
		super();
	}
	public Prestec(int codi, String isbn, String dni, String data_retorn, int retornat) {
		super();
		this.codi = codi;
		this.isbn = isbn;
		this.dni = dni;
		this.data_retorn = data_retorn;
		this.retornat = retornat;
	}
	public int getCodi() {
		return codi;
	}
	public void setCodi(int codi) {
		this.codi = codi;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getData_retorn() {
		return data_retorn;
	}
	public void setData_retorn(String data_retorn) {
		this.data_retorn = data_retorn;
	}
	public int getRetornat() {
		return retornat;
	}
	public void setRetornat(int retornat) {
		this.retornat = retornat;
	}
	
	
}
