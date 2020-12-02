package examen;

import java.io.Serializable;

public class ticket implements Serializable {
private int codi_ticket;
private String nom_empleat;
private String data_ticket;
private Object producte;
public ticket() {
	super();
}
public int getCodi_ticket() {
	return codi_ticket;
}
public void setCodi_ticket(int codi_ticket) {
	this.codi_ticket = codi_ticket;
}
public String getNom_empleat() {
	return nom_empleat;
}
public void setNom_empleat(String nom_empleat) {
	this.nom_empleat = nom_empleat;
}
public String getData_ticket() {
	return data_ticket;
}
public void setData_ticket(String data_ticket) {
	this.data_ticket = data_ticket;
}
public Object getProducte() {
	return producte;
}
public void setProducte(Object producte) {
	this.producte = producte;
}
@Override
public String toString() {
	return "ticket [codi_ticket=" + codi_ticket + ", nom_empleat=" + nom_empleat + ", data_ticket=" + data_ticket
			+ ", producte=" + producte + "]";
}

	
}
