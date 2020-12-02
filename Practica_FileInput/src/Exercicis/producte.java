package Exercicis;

import java.io.Serializable;

public class producte implements Serializable {
private String nom,marca;
private double preu;
private int quantitat;



public String getNom() {
	return nom;
}
public producte(String nom, String marca, double preu, int quantitat) {
	super();
	this.nom = nom;
	this.marca = marca;
	this.preu = preu;
	this.quantitat = quantitat;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getMarca() {
	return marca;
}
public void setMarca(String marca) {
	this.marca = marca;
}
public double getPreu() {
	return preu;
}
public void setPreu(double preu) {
	this.preu = preu;
}
public int getQuantitat() {
	return quantitat;
}
public void setQuantitat(int quantitat) {
	this.quantitat = quantitat;
}
@Override
public String toString() {
	return "producte [nom=" + nom + ", marca=" + marca + ", preu=" + preu + ", quantitat=" + quantitat + "]";
}


	
}
