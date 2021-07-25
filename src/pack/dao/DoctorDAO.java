package pack.dao;

import java.util.List;

import pack.entity.Doctor;

public interface DoctorDAO {
	public Doctor getOneDoctor(int id);
	public List<Doctor> getDoctorBySpeciality(String spc);
	public void deleteDoctor(Doctor theDoctor);
	public void saveDoctor(Doctor theDoctor);
	public List<Doctor> getAllDoctor();
	public List searchDoctor(String fname,String lname, String spc, String[] Da,int id,String phneNum);
}
