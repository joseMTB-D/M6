package DAO;

import java.io.Serializable;


public class Comanda implements Serializable  {

	int COM_NUM;
	String COM_DATE;
	String COM_TIPUS;
	int CLIENT_COD;
	String DATA_TRAMESA;
	double TOTAL;
	
	
	
	public Comanda() {
		super();
	}
	public int getCOM_NUM() {
		return COM_NUM;
	}
	public void setCOM_NUM(int cOM_NUM) {
		COM_NUM = cOM_NUM;
	}
	public String getCOM_DATE() {
		return COM_DATE;
	}
	public void setCOM_DATE(String cOM_DATE) {
		COM_DATE = cOM_DATE;
	}
	public String getCOM_TIPUS() {
		return COM_TIPUS;
	}
	public void setCOM_TIPUS(String cOM_TIPUS) {
		COM_TIPUS = cOM_TIPUS;
	}
	public int getCLIENT_COD() {
		return CLIENT_COD;
	}
	public void setCLIENT_COD(int cLIENT_COD) {
		CLIENT_COD = cLIENT_COD;
	}
	public String getDATA_TRAMESA() {
		return DATA_TRAMESA;
	}
	public void setDATA_TRAMESA(String dATA_TRAMESA) {
		DATA_TRAMESA = dATA_TRAMESA;
	}
	public double getTOTAL() {
		return TOTAL;
	}
	public void setTOTAL(double tOTAL) {
		TOTAL = tOTAL;
	}
	
	
	
	
	
}
