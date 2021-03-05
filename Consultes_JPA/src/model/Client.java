package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the clients database table.
 * 
 */
@Entity
@Table(name="clients")
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int clientID;

	private String adreça;

	private String ciutat;

	@Column(name="`Codi Postal`")
	private int codi_Postal;

	private String dni;

	private String nom;

	private int telefon;

	//bi-directional many-to-one association to Comande
	@OneToMany(mappedBy="client")
	private List<Comande> comandes;

	public Client() {
	}

	public int getClientID() {
		return this.clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public String getAdreça() {
		return this.adreça;
	}

	public void setAdreça(String adreça) {
		this.adreça = adreça;
	}

	public String getCiutat() {
		return this.ciutat;
	}

	public void setCiutat(String ciutat) {
		this.ciutat = ciutat;
	}

	public int getCodi_Postal() {
		return this.codi_Postal;
	}

	public void setCodi_Postal(int codi_Postal) {
		this.codi_Postal = codi_Postal;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public List<Comande> getComandes() {
		return this.comandes;
	}

	public void setComandes(List<Comande> comandes) {
		this.comandes = comandes;
	}

	public Comande addComande(Comande comande) {
		getComandes().add(comande);
		comande.setClient(this);

		return comande;
	}

	public Comande removeComande(Comande comande) {
		getComandes().remove(comande);
		comande.setClient(null);

		return comande;
	}

	@Override
	public String toString() {
		return "Client [clientID=" + clientID + ", adreça=" + adreça + ", ciutat=" + ciutat + ", codi_Postal="
				+ codi_Postal + ", dni=" + dni + ", nom=" + nom + ", telefon=" + telefon  ;
	}
	

}