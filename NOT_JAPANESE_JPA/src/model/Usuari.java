package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuari database table.
 * 
 */
@Entity
@NamedQuery(name="Usuari.findAll", query="SELECT u FROM Usuari u")
public class Usuari implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String dni;

	private String correu;

	private String nom;

	private int telefon;

	//bi-directional many-to-one association to Prestec
	@OneToMany(mappedBy="usuari")
	private List<Prestec> prestecs;

	public Usuari(String dni, String correu, String nom, int telefon) {
		super();
		this.dni = dni;
		this.correu = correu;
		this.nom = nom;
		this.telefon = telefon;
	}
	public Usuari() {
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCorreu() {
		return this.correu;
	}

	public void setCorreu(String correu) {
		this.correu = correu;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getTelefon() {
		return this.telefon;
	}

	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}

	public List<Prestec> getPrestecs() {
		return this.prestecs;
	}

	public void setPrestecs(List<Prestec> prestecs) {
		this.prestecs = prestecs;
	}

	public Prestec addPrestec(Prestec prestec) {
		getPrestecs().add(prestec);
		prestec.setUsuari(this);

		return prestec;
	}

	public Prestec removePrestec(Prestec prestec) {
		getPrestecs().remove(prestec);
		prestec.setUsuari(null);

		return prestec;
	}

}