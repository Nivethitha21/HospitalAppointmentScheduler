package pack.dao;

import pack.entity.Patient;

public interface PatientDAO {
	public void savePatient(Patient thePatient);
	public Patient getOnePatient(int id);

}
