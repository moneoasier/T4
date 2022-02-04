package eus.uni.dam;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the res_partner database table.
 * 
 */
@Entity
@Table(name="res_partner")
@NamedQuery(name="ResPartner.findAll", query="SELECT r FROM ResPartner r")
public class ResPartner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Date date;

	private String name;

	public ResPartner() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}