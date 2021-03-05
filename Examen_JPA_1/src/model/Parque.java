package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the parque database table.
 * 
 */
@Entity
@NamedQuery(name="Parque.findAll", query="SELECT p FROM Parque p")
public class Parque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String categoria;

	private String direccion;

	private String nombre;

	private String poblacion;

	private String telefono;

	//bi-directional many-to-one association to Bombero
	@OneToMany(mappedBy="parque")
	private List<Bombero> bomberos;

	//bi-directional many-to-one association to Coche
	@OneToMany(mappedBy="parque")
	private List<Coche> coches;

	//bi-directional many-to-one association to Servicio
	@OneToMany(mappedBy="parque")
	private List<Servicio> servicios;

	public Parque() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPoblacion() {
		return this.poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Bombero> getBomberos() {
		return this.bomberos;
	}

	public void setBomberos(List<Bombero> bomberos) {
		this.bomberos = bomberos;
	}

	public Bombero addBombero(Bombero bombero) {
		getBomberos().add(bombero);
		bombero.setParque(this);

		return bombero;
	}

	public Bombero removeBombero(Bombero bombero) {
		getBomberos().remove(bombero);
		bombero.setParque(null);

		return bombero;
	}

	public List<Coche> getCoches() {
		return this.coches;
	}

	public void setCoches(List<Coche> coches) {
		this.coches = coches;
	}

	public Coche addCoch(Coche coch) {
		getCoches().add(coch);
		coch.setParque(this);

		return coch;
	}

	public Coche removeCoch(Coche coch) {
		getCoches().remove(coch);
		coch.setParque(null);

		return coch;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public Servicio addServicio(Servicio servicio) {
		getServicios().add(servicio);
		servicio.setParque(this);

		return servicio;
	}

	public Servicio removeServicio(Servicio servicio) {
		getServicios().remove(servicio);
		servicio.setParque(null);

		return servicio;
	}

}