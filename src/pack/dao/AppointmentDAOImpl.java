package pack.dao;
import java.util.*;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pack.entity.Appointment;
import pack.entity.Doctor;
import pack.entity.docAvail;
import java.time.*;
@Repository
public class AppointmentDAOImpl implements AppointmentDAO {
	
	@Autowired
	private SessionFactory sessionfactory;
	@Autowired
	private docAvailDAO docAvaildao;
	@Override
	@Transactional
	public List<Appointment> getAppointment() {
		Session s = sessionfactory.getCurrentSession();
		List<Appointment> li = s.createQuery("from Appointment where pending=1",Appointment.class).list();
		return li;
	}
	@Override
	@Transactional
	public void markAsCompleted(List<Integer> li2) {
		Session s = sessionfactory.getCurrentSession();
		Query query = s.createQuery("Update Appointment set pending=0 WHERE appId IN (?1)");
		query.setParameterList(1, li2);
		query.executeUpdate();
		
	}
	@Override
	@Transactional
	public void saveAppointment(Appointment a) {
		Session s = sessionfactory.getCurrentSession();
		s.saveOrUpdate(a);
	}
	
	@Override
	@Transactional
	public Appointment getOneAppointment(int id) {
		Session s = sessionfactory.getCurrentSession();
		Query<Appointment> query2 = s.createQuery("from Appointment where appId=:id",Appointment.class);
		Appointment ap = query2.setParameter("id",id).getSingleResult();
		return ap;
	}
	@Override
	@Transactional
	public void deleteAppointment(int id) {
		Session s = sessionfactory.getCurrentSession();
		Query<Appointment> theQuery = s.createQuery("from Appointment where id=:id");
		Appointment ap = (Appointment) theQuery.setParameter("id",id).getSingleResult();
		s.delete(ap);
	}
	@Override
	@Transactional
	public void autoschedule() {
		Session s = sessionfactory.getCurrentSession();
		List<Appointment> ap = s.createQuery("from Appointment where docId=0 and isPending=1 order by severity").getResultList();
		Dictionary<String,Integer> dayPair = new Hashtable<String,Integer>();
		dayPair.put("Sunday",0);
		dayPair.put("Monday",1);
		dayPair.put("Tuesday",2);
		dayPair.put("Wednesday",3);
		dayPair.put("Thursday",4);
		dayPair.put("Friday",5);
		dayPair.put("Saturday",6); 
		for(Appointment a:ap)
		{
			String sp = a.getSpeciality();
			int docId=0,appId=0,flag = 0,min = 8;
			docAvail davv=null;
			String appointDay="";
			Query query = s.createQuery("from Doctor where speciality = :sp");
			List<Doctor> docLi= query.setParameter("sp",sp).getResultList();
			for(Doctor d:docLi)
			{
				List<docAvail> docavail = d.getAvail();
				for(int i = 0;i<7;i++) {
				for(docAvail dav:docavail)
				{
					LocalDate noww = LocalDate.now();
					DayOfWeek dayof = noww.getDayOfWeek();
					String day = dav.getDays();
					int dayy = dayof.getValue();
					int dif = dayPair.get(day)-dayy;
					if(dif<0)
						dif = 6 - (0-dif);
					if(dif==i) {
						davv = dav;
						docId = d.getId();
						appointDay = day;
						flag = 1;
						break;
					}
				}
					if(flag == 1)
						break;
				}}
			int t = davv.getSlot();
			davv.setSlot(t-1);
			a.setDocId(docId);
			a.setAppDay(appointDay);
			saveAppointment(a);
			docAvaildao.saveDocAvail(davv);
				}
	}

}
