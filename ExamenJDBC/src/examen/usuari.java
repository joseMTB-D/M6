package examen;

public class usuari {
	private String dni;
	private String nom;
	private String correu;
	private int telefon;
	
	
	public usuari() {
		super();
	}


	public usuari(String dni, String nom,int telefon,String correu) {
		super();
		this.dni = dni;
		this.nom = nom;
		this.correu = correu;
		this.telefon = telefon;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getCorreu() {
		return correu;
	}


	public void setCorreu(String correu) {
		this.correu = correu;
	}


	public int getTelefon() {
		return telefon;
	}


	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}
	
	

}
