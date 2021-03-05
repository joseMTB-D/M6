package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the prestec database table.
 * 
 */
@Entity
@NamedQuery(name="Prestec.findAll", query="SELECT p FROM Prestec p")
public class Prestec implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int codi;

	@Temporal(TemporalType.DATE)
	@Column(name="data_prestec")
	private Date dataPrestec;

	@Temporal(TemporalType.DATE)
	@Column(name="data_retorn")
	private Date dataRetorn;

	private String retornat;

	//bi-directional many-to-one association to Usuari
	@ManyToOne
	@JoinColumn(name="DNI")
	private Usuari usuari;

	//bi-directional many-to-one association to Llibre
	@ManyToOne
	@JoinColumn(name="ISBN")
	private Llibre llibre;

	
	public Prestec(int codi, Date dataPrestec, Date dataRetorn, String retornat, Usuari usuari, Llibre llibre) {
		super();
		this.codi = codi;
		this.dataPrestec = dataPrestec;
		this.dataRetorn = dataRetorn;
		this.retornat = retornat;
		this.usuari = usuari;
		this.llibre = llibre;
	}

	public Prestec() {
	}

	public int getCodi() {
		return this.codi;
	}

	public void setCodi(int codi) {
		this.codi = codi;
	}

	public Date getDataPrestec() {
		return this.dataPrestec;
	}

	public void setDataPrestec(Date dataPrestec) {
		this.dataPrestec = dataPrestec;
	}

	public Date getDataRetorn() {
		return this.dataRetorn;
	}

	public void setDataRetorn(Date dataRetorn) {
		this.dataRetorn = dataRetorn;
	}

	public String getRetornat() {
		return this.retornat;
	}

	public void setRetornat(String retornat) {
		this.retornat = retornat;
	}

	public Usuari getUsuari() {
		return this.usuari;
	}

	public void setUsuari(Usuari usuari) {
		this.usuari = usuari;
	}

	public Llibre getLlibre() {
		return this.llibre;
	}

	public void setLlibre(Llibre llibre) {
		this.llibre = llibre;
	}

	@Override
	public String toString() {
		return "Prestec [codi=" + codi + ", dataPrestec=" + dataPrestec + ", dataRetorn=" + dataRetorn + ", retornat="
				+ retornat + ", llibre=" + llibre + "]";
	}
	

}