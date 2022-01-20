package eus.uni.dam;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the hr_employee database table.
 * 
 */
@Entity
@Table(name="hr_employee")
@NamedQuery(name="HrEmployee.findAll", query="SELECT h FROM HrEmployee h")
public class HrEmployee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	
	@Column(name="department_id")
	private Integer departmentId;

	

	private String gender;


	private String name;

	
	public HrEmployee() {
	}

	
	public HrEmployee(Integer id, Integer departmentId, String name) {
		super();
		this.id = id;
		this.departmentId = departmentId;
		this.name = name;
	}


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}


	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "HrEmployee [id=" + id + ", departmentId=" + departmentId + ", name=" + name + "]";
	}

	
}