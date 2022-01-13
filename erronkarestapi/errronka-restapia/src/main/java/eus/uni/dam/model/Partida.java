package eus.uni.dam.model;

public class Partida {

private String partidaId;
private String puntuazioa;
private String data;
private String employeeId;


public Partida(String partidaId, String puntuazioa, String data, String employeeId) {
	super();
	this.partidaId = partidaId;
	this.puntuazioa = puntuazioa;
	this.data = data;
	this.employeeId = employeeId;
}
public Partida() {
	super();
}


public String getPartidaId() {
	return partidaId;
}


public void setPartidaId(String partidaId) {
	this.partidaId = partidaId;
}


public String getPuntuazioa() {
	return puntuazioa;
}


public void setPuntuazioa(String puntuazioa) {
	this.puntuazioa = puntuazioa;
}


public String getData() {
	return data;
}


public void setData(String data) {
	this.data = data;
}


public String getEmployeeId() {
	return employeeId;
}


public void setEmployeeId(String employeeId) {
	this.employeeId = employeeId;
}


@Override
public String toString() {
	return "Partida [partidaId=" + partidaId + ", puntuazioa=" + puntuazioa + ", data=" + data + ", employeeId="
			+ employeeId + "]";
}



	
	
}
