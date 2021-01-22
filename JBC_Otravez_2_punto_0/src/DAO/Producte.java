package DAO;

import java.io.Serializable;

public class Producte implements Serializable  {
	
	int PROD_NUM;
	String DESCRIPCIO;
	
	
	
	public Producte() {
		super();
	}
	public int getPROD_NUM() {
		return PROD_NUM;
	}
	public void setPROD_NUM(int pROD_NUM) {
		PROD_NUM = pROD_NUM;
	}
	public String getDESCRIPCIO() {
		return DESCRIPCIO;
	}
	public void setDESCRIPCIO(String descripcio) {
		DESCRIPCIO = descripcio;
	}
	
	

}
