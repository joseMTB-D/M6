package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the productes database table.
 * 
 */
@Entity
@Table(name="productes")
@NamedQuery(name="Producte.findAll", query="SELECT p FROM Producte p")
public class Producte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int producteID;

	private String categoria;

	private String nom;

	private int preu;

	private int stock;

	//bi-directional many-to-one association to DetallComande
	@OneToMany(mappedBy="producte")
	private List<DetallComande> detallComandes;

	public Producte() {
	}

	public int getProducteID() {
		return this.producteID;
	}

	public void setProducteID(int producteID) {
		this.producteID = producteID;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPreu() {
		return this.preu;
	}

	public void setPreu(int preu) {
		this.preu = preu;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<DetallComande> getDetallComandes() {
		return this.detallComandes;
	}

	public void setDetallComandes(List<DetallComande> detallComandes) {
		this.detallComandes = detallComandes;
	}

	public DetallComande addDetallComande(DetallComande detallComande) {
		getDetallComandes().add(detallComande);
		detallComande.setProducte(this);

		return detallComande;
	}

	public DetallComande removeDetallComande(DetallComande detallComande) {
		getDetallComandes().remove(detallComande);
		detallComande.setProducte(null);

		return detallComande;
	}

	@Override
	public String toString() {
		return "Producte [nom=" + nom + ", stock=" + stock + "]";
	}
	

}