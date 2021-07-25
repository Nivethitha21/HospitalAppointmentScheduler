package pack.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Patient")
public class Patient {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="hosp_id")
	private int hospId;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="phneNum")
	private String phneNum;
	@Column(name="age")
	private int Age;
	public int getHospId() {
		return hospId;
	}
	public void setHospId(int hospId) {
		this.hospId = hospId;
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
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public Patient() {
	}
	public Patient(String firstName, String lastName, String phneNum, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phneNum = phneNum;
		Age = age;
	}
	@Override
	public String toString() {
		return "Patient [hospId=" + hospId + ", firstName=" + firstName + ", lastName=" + lastName + ", phneNum="
				+ phneNum + ", Age=" + Age + "]";
	}
	
}
