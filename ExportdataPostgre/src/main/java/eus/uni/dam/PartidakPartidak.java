package eus.uni.dam;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.time.LocalDate;


/**
 * The persistent class for the partidak_partidak database table.
 * 
 */
@Entity
@Table(name="partidak_partidak")
@NamedQuery(name="PartidakPartidak.findAll", query="SELECT p FROM PartidakPartidak p")
public class PartidakPartidak implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	
	private LocalDate data;

	private Integer employeeid;

	@Column(name="\"partidaId\"")
	private Integer partidaId;

	private Integer puntuazioa;

	
	public PartidakPartidak() {
	}
	
	
 	public PartidakPartidak(Integer partidaId,Integer id,Integer puntuazioa,Integer employeeid,LocalDate data ) {
	this.partidaId=partidaId;
	this.id=id;
	this.puntuazioa=puntuazioa;
	this.employeeid=employeeid;
	this.data=data;
	
	
}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public LocalDate getData() {
		return this.data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Integer getEmployeeid() {
		return this.employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public Integer getPartidaId() {
		return this.partidaId;
	}

	public void setPartidaId(Integer partidaId) {
		this.partidaId = partidaId;
	}

	public Integer getPuntuazioa() {
		return this.puntuazioa;
	}

	public void setPuntuazioa(Integer puntuazioa) {
		this.puntuazioa = puntuazioa;
	}


	@Override
	public String toString() {
		return "PartidakPartidak [id=" + id + ", data=" + data + ", employeeid=" + employeeid + ", partidaId="
				+ partidaId + ", puntuazioa=" + puntuazioa + "]";
	}

	
}