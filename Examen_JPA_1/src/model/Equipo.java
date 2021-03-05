package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the equipo database table.
 * 
 */
@Entity
@NamedQuery(name="Equipo.findAll", query="SELECT e FROM Equipo e")
public class Equipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EquipoPK id;

	private String puesto;

	//bi-directional many-to-one association to Bombero
	@ManyToOne
	private Bombero bombero;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	private Servicio servicio;

	
	public Equipo(EquipoPK id, String puesto, Bombero bombero, Servicio servicio) {
		super();
		this.id = id;
		this.puesto = puesto;
		this.bombero = bombero;
		this.servicio = servicio;
	}

	public Equipo() {
	}

	public Equipo(EquipoPK epk, String string, Servicio ser) {
		// TODO Auto-generated constructor stub
	}

	public EquipoPK getId() {
		return this.id;
	}

	public void setId(EquipoPK id) {
		this.id = id;
	}

	public String getPuesto() {
		return this.puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public Bombero getBombero() {
		return this.bombero;
	}

	public void setBombero(Bombero bombero) {
		this.bombero = bombero;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}