package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the equipo database table.
 * 
 */
@Embeddable
public class EquipoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="servicio_id", insertable=false, updatable=false)
	private int servicioId;

	@Column(name="bombero_id", insertable=false, updatable=false)
	private int bomberoId;

	public EquipoPK() {
	}
	public EquipoPK(int ids, int id) {
		// TODO Auto-generated constructor stub
	}
	public int getServicioId() {
		return this.servicioId;
	}
	public void setServicioId(int servicioId) {
		this.servicioId = servicioId;
	}
	public int getBomberoId() {
		return this.bomberoId;
	}
	public void setBomberoId(int bomberoId) {
		this.bomberoId = bomberoId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EquipoPK)) {
			return false;
		}
		EquipoPK castOther = (EquipoPK)other;
		return 
			(this.servicioId == castOther.servicioId)
			&& (this.bomberoId == castOther.bomberoId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.servicioId;
		hash = hash * prime + this.bomberoId;
		
		return hash;
	}
}