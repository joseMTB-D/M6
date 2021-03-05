package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the detall_comandes database table.
 * 
 */
@Embeddable
public class DetallComandePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int comandaID;

	@Column(insertable=false, updatable=false)
	private int producteID;

	
	public DetallComandePK(int comandaID, int producteID) {
		super();
		this.comandaID = comandaID;
		this.producteID = producteID;
	}
	public DetallComandePK() {
	}
	public int getComandaID() {
		return this.comandaID;
	}
	public void setComandaID(int comandaID) {
		this.comandaID = comandaID;
	}
	public int getProducteID() {
		return this.producteID;
	}
	public void setProducteID(int producteID) {
		this.producteID = producteID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetallComandePK)) {
			return false;
		}
		DetallComandePK castOther = (DetallComandePK)other;
		return 
			(this.comandaID == castOther.comandaID)
			&& (this.producteID == castOther.producteID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.comandaID;
		hash = hash * prime + this.producteID;
		
		return hash;
	}
}