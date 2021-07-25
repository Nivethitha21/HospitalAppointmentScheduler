package pack.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pack.entity.Patient;
@Repository
public class PatientDAOImpl implements PatientDAO{

	@Autowired
	private SessionFactory sessionfactory;
	@Override
	@Transactional
	public void savePatient(Patient thePatient) {
		Session s = sessionfactory.getCurrentSession();
		s.save(thePatient);
		
	}
	@Override
	@Transactional
	public Patient getOnePatient(int id) {
		Session s = sessionfactory.getCurrentSession();
		Query query = s.createQuery("from Patient where hospId=:idnum",Patient.class);
		Patient p = (Patient)query.setParameter("idnum",id).getSingleResult();
		return p;
	}

}
