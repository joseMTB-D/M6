package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the bombero database table.
 * 
 */
@Entity
@NamedQuery(name="Bombero.findAll", query="SELECT b FROM Bombero b")
public class Bombero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String apellidos;

	private String direccion;

	private String dni;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to Parque
	@ManyToOne
	private Parque parque;

	//bi-directional many-to-one association to Equipo
	@OneToMany(mappedBy="bombero")
	private List<Equipo> equipos;

	public Bombero() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Parque getParque() {
		return this.parque;
	}

	public void setParque(Parque parque) {
		this.parque = parque;
	}

	public List<Equipo> getEquipos() {
		return this.equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public Equipo addEquipo(Equipo equipo) {
		getEquipos().add(equipo);
		equipo.setBombero(this);

		return equipo;
	}

	public Equipo removeEquipo(Equipo equipo) {
		getEquipos().remove(equipo);
		equipo.setBombero(null);

		return equipo;
	}

	@Override
	public String toString() {
		return "Bombero [id=" + id + ", apellidos=" + apellidos + ", direccion=" + direccion + ", dni=" + dni
				+ ", fechaNacimiento=" + fechaNacimiento + ", nombre=" + nombre + ", telefono=" + telefono + ", parque="
				+ parque + ", equipos=" + equipos + "]";
	}
	

}