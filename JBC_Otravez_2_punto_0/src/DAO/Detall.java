package DAO;

import java.io.Serializable;

public class Detall implements Serializable  {
	
	int COM_NUM;
	int DETALL_NUM;
	int PROD_NUM;
	double PREU_VENDA;
	int QUANTITAT;
	double IMPORT;
	
	
	
	public Detall() {
		super();
	}
	public int getCOM_NUM() {
		return COM_NUM;
	}
	public void setCOM_NUM(int cOM_NUM) {
		COM_NUM = cOM_NUM;
	}
	public int getDETALL_NUM() {
		return DETALL_NUM;
	}
	public void setDETALL_NUM(int dETALL_NUM) {
		DETALL_NUM = dETALL_NUM;
	}
	public int getPROD_NUM() {
		return PROD_NUM;
	}
	public void setPROD_NUM(int pROD_NUM) {
		PROD_NUM = pROD_NUM;
	}
	public double getPREU_VENDA() {
		return PREU_VENDA;
	}
	public void setPREU_VENDA(double pREU_VENDA) {
		PREU_VENDA = pREU_VENDA;
	}
	public int getQUANTITAT() {
		return QUANTITAT;
	}
	public void setQUANTITAT(int qUANTITAT) {
		QUANTITAT = qUANTITAT;
	}
	public double getIMPORT() {
		return IMPORT;
	}
	public void setIMPORT(double iMPORT) {
		IMPORT = iMPORT;
	}
	
	
	
	
}
