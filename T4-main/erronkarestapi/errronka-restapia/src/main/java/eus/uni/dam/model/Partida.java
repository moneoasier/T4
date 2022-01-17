package eus.uni.dam.model;

import java.util.Date;

public class Partida {

private int partidaId;
private int puntuazioa;
private Date data;
private int employeeid;
private int adina;
private int departamentua;




public Partida() {
	super();
}


public Partida(int partidaId, int puntuazioa, Date data, int employeeid, int adina, int departamentua) {
	super();
	this.partidaId = partidaId;
	this.puntuazioa = puntuazioa;
	this.data = data;
	this.employeeid = employeeid;
	this.adina = adina;
	this.departamentua = departamentua;
}



public int getPartidaId() {
	return partidaId;
}




public void setPartidaId(int partidaId) {
	this.partidaId = partidaId;
}




public int getPuntuazioa() {
	return puntuazioa;
}




public void setPuntuazioa(int puntuazioa) {
	this.puntuazioa = puntuazioa;
}




public Date getData() {
	return data;
}




public void setData(Date data) {
	this.data = data;
}




public int getEmployeeid() {
	return employeeid;
}




public void setEmployeeid(int employeeid) {
	this.employeeid = employeeid;
}




public int getAdina() {
	return adina;
}




public void setAdina(int adina) {
	this.adina = adina;
}




public int getDepartamentua() {
	return departamentua;
}




public void setDepartamentua(int departamentua) {
	this.departamentua = departamentua;
}







	
	
}
