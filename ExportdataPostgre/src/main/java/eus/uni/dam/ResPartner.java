package eus.uni.dam;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	
	private String name;

	
	//bi-directional many-to-one association to PartidakPartidak
//	@OneToMany(mappedBy="resPartner")
	//private List<PartidakPartidak> partidakPartidaks;

	public ResPartner() {
	}	
	
	public ResPartner(Integer id,String name) {
		this.id=id;
		this.name=name;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	@Override
	public String toString() {
		return "ResPartner [id=" + id + ", name=" + name +"]";
	}

}