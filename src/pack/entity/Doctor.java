package pack.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="doctor")
public class Doctor{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="num")
	private String phneNum;
	@Column(name="speciality")
	private String speciality;

	@OneToMany(mappedBy="doctor",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	//@JoinColumn(name="doc_id")
	private List<docAvail> avail;
	public Doctor() {
	}
	
	public Doctor(String firstName, String lastName, String phneNum, String speciality) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phneNum = phneNum;
		this.speciality = speciality;
	}
	public List<docAvail> getAvail() {
		return avail;
	}
	public void setAvail(List<docAvail> avail) {
		this.avail = avail;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhneNum() {
		return phneNum;
	}
	public void setPhneNum(String phneNum) {
		this.phneNum = phneNum;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phneNum=" + phneNum
				+ ", speciality=" + speciality + "]";
	}
	public void addAvail(docAvail avail)
	{
		if(this.avail==null)
		{
			this.avail=new ArrayList<docAvail>();
		}
		this.avail.add(avail);
		avail.setDoctor(this);
	}

}
