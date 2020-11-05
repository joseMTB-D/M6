package objetos;

import java.io.Serializable;

public class persona implements Serializable{

	private String nom,DNI;
	private int edat,telefon;
	
	public persona() {}
	
	public persona(String nom, String dNI, int edat, int telefon) {
		super();
		this.nom = nom;
		DNI = dNI;
		this.edat = edat;
		this.telefon = telefon;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public int getEdat() {
		return edat;
	}
	public void setEdat(int edat) {
		this.edat = edat;
	}
	public int getTelefon() {
		return telefon;
	}
	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}

	@Override
	public String toString() {
		return "persona [nom=" + nom + ", DNI=" + DNI + ", edat=" + edat + ", telefon=" + telefon + "]";
	}
	
	
	
}
