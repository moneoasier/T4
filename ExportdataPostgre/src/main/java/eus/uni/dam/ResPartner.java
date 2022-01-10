package eus.uni.dam;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="res_partner")
@NamedQuery(name="ResPartner.findAll", query="SELECT r FROM ResPartner r")
public class ResPartner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private String name;

	

	//bi-directional many-to-one association to PartidakPartidak
	@OneToMany(mappedBy="resPartner")
	private List<PartidakPartidak> partidakPartidaks;

	public ResPartner() {
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




	public List<PartidakPartidak> getPartidakPartidaks() {
		return this.partidakPartidaks;
	}

	public void setPartidakPartidaks(List<PartidakPartidak> partidakPartidaks) {
		this.partidakPartidaks = partidakPartidaks;
	}

	public PartidakPartidak addPartidakPartidak(PartidakPartidak partidakPartidak) {
		getPartidakPartidaks().add(partidakPartidak);
		partidakPartidak.setResPartner(this);

		return partidakPartidak;
	}

	public PartidakPartidak removePartidakPartidak(PartidakPartidak partidakPartidak) {
		getPartidakPartidaks().remove(partidakPartidak);
		partidakPartidak.setResPartner(null);

		return partidakPartidak;
	}

}