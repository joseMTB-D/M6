package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the comandes database table.
 * 
 */
@Entity
@Table(name="comandes")
@NamedQuery(name="Comande.findAll", query="SELECT c FROM Comande c")
public class Comande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int comandaID;

	private String adreça;

	private String ciutat;

	@Column(name="`Codi Postal`")
	private int codi_Postal;

	@Temporal(TemporalType.DATE)
	@Column(name="`Data comanda`")
	private Date data_comanda;

	@Temporal(TemporalType.DATE)
	@Column(name="`Data enviament`")
	private Date data_enviament;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="ClientID")
	private Client client;

	//bi-directional many-to-one association to DetallComande
	@OneToMany(mappedBy="comande")
	private List<DetallComande> detallComandes;

	public Comande() {
	}

	public int getComandaID() {
		return this.comandaID;
	}

	public void setComandaID(int comandaID) {
		this.comandaID = comandaID;
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

	public Date getData_comanda() {
		return this.data_comanda;
	}

	public void setData_comanda(Date data_comanda) {
		this.data_comanda = data_comanda;
	}

	public Date getData_enviament() {
		return this.data_enviament;
	}

	public void setData_enviament(Date data_enviament) {
		this.data_enviament = data_enviament;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<DetallComande> getDetallComandes() {
		return this.detallComandes;
	}

	public void setDetallComandes(List<DetallComande> detallComandes) {
		this.detallComandes = detallComandes;
	}

	public DetallComande addDetallComande(DetallComande detallComande) {
		getDetallComandes().add(detallComande);
		detallComande.setComande(this);

		return detallComande;
	}

	public DetallComande removeDetallComande(DetallComande detallComande) {
		getDetallComandes().remove(detallComande);
		detallComande.setComande(null);

		return detallComande;
	}

	@Override
	public String toString() {
		return "Comande [comandaID=" + comandaID + ", adreça=" + adreça + ", ciutat=" + ciutat + ", codi_Postal="
				+ codi_Postal + ", data_comanda=" + data_comanda + ", data_enviament=" + data_enviament + ", detallComandes=" + detallComandes + "]";
	}
	

}