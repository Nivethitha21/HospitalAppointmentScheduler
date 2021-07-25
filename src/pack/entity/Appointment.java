package pack.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Appointment")
public class Appointment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="appId")
	private int appId;
	@Column(name="patientID")
	private int patId;
	@Column(name="docId")
	private int docId;
	@Column(name="speciality")
	private String speciality;
	@Column(name="severity")
	private int severity;
	@Column(name="appDay")
	private String appDay;
	@Column(name="isPending")
	private int pending;
	public int getPending() {
		return pending;
	}
	public void setPending(int pending) {
		this.pending = pending;
	}
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public int getPatId() {
		return patId;
	}
	public void setPatId(int patId) {
		this.patId = patId;
	}
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public int getSeverity() {
		return severity;
	}
	public void setSeverity(int severity) {
		this.severity = severity;
	}
	public Appointment(int patId, String speciality, int severity, int pending) {
		this.patId = patId;
		this.speciality = speciality;
		this.severity = severity;
		this.pending = pending;
	}
	public String getAppDay() {
		return appDay;
	}
	public void setAppDay(String appDay) {
		this.appDay = appDay;
	}
	public Appointment() {
	}
	public Appointment(int patId, int docId, String speciality, int severity, String appDay, int pending) {
		this.patId = patId;
		this.docId = docId;
		this.speciality = speciality;
		this.severity = severity;
		this.appDay = appDay;
		this.pending = pending;
	}
	@Override
	public String toString() {
		return "Appointment [appId=" + appId + ", patId=" + patId + ", docId=" + docId + ", speciality=" + speciality
				+ ", severity=" + severity + ", appDay=" + appDay + "]";
	}

}
