package eus.uni.dam;

import java.io.Serializable;
import javax.persistence.*;
import java.time.LocalDateTime;


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

	private Integer adina;



	
	private LocalDateTime data;

	private String departamentua;

	private Integer employeeid;

	@Column(name="\"partidaId\"")
	private Integer partidaId;

	private Integer puntuazioa;

	
	public PartidakPartidak() {
	}
	
	

	public PartidakPartidak(Integer id, Integer adina, LocalDateTime data, String departamentua, Integer employeeid,
			Integer partidaId, Integer puntuazioa) {
		super();
		this.id = id;
		this.adina = adina;
		this.data = data;
		this.departamentua = departamentua;
		this.employeeid = employeeid;
		this.partidaId = partidaId;
		this.puntuazioa = puntuazioa;
	}



	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAdina() {
		return this.adina;
	}

	public void setAdina(Integer adina) {
		this.adina = adina;
	}

	

	public LocalDateTime getData() {
		return this.data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getDepartamentua() {
		return this.departamentua;
	}

	public void setDepartamentua(String departamentua) {
		this.departamentua = departamentua;
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
		return "PartidakPartidak [id=" + id + ", adina=" + adina + ", departamentua=" + departamentua + ", employeeid="
				+ employeeid + ", partidaId=" + partidaId + ", puntuazioa=" + puntuazioa + "]";
	}


	
}