package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detall_comandes database table.
 * 
 */
@Entity
@Table(name="detall_comandes")
@NamedQuery(name="DetallComande.findAll", query="SELECT d FROM DetallComande d")
public class DetallComande implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetallComandePK id;

	private int descompte;

	private int quantitat;

	//bi-directional many-to-one association to Comande
	@ManyToOne
	@JoinColumn(name="ComandaID")
	private Comande comande;

	//bi-directional many-to-one association to Producte
	@ManyToOne
	@JoinColumn(name="ProducteID")
	private Producte producte;

	public DetallComande() {
	}

	public DetallComandePK getId() {
		return this.id;
	}

	public void setId(DetallComandePK id) {
		this.id = id;
	}

	public int getDescompte() {
		return this.descompte;
	}

	public void setDescompte(int descompte) {
		this.descompte = descompte;
	}

	public int getQuantitat() {
		return this.quantitat;
	}

	public void setQuantitat(int quantitat) {
		this.quantitat = quantitat;
	}

	public Comande getComande() {
		return this.comande;
	}

	public void setComande(Comande comande) {
		this.comande = comande;
	}

	public Producte getProducte() {
		return this.producte;
	}

	public void setProducte(Producte producte) {
		this.producte = producte;
	}

	@Override
	public String toString() {
		return "DetallComande [id=" + id + ", descompte=" + descompte + ", quantitat=" + quantitat +  ", producte=" + producte + "]";
	}

}