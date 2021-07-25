package pack.dao;


import java.util.List;

import pack.entity.Appointment;

public interface AppointmentDAO {
	public List<Appointment> getAppointment();
	public Appointment getOneAppointment(int id);
	public void markAsCompleted(List<Integer> li);
	public void saveAppointment(Appointment ap);
	public void deleteAppointment(int id);
	public void autoschedule();
}
