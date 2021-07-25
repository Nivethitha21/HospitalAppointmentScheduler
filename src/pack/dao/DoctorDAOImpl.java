package pack.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pack.entity.Doctor;
@Repository
public class DoctorDAOImpl implements DoctorDAO {
	@Autowired
	private SessionFactory sessionfactory;
	@Override
	@Transactional
	public Doctor getOneDoctor(int id) {
		Session s = sessionfactory.getCurrentSession();
		Query<Doctor> query1= s.createQuery("from Doctor where id=:id",Doctor.class);
		Doctor d = query1.setParameter("id",id).getSingleResult();
		return d;
	}
	@Override
	@Transactional
	public List<Doctor> getDoctorBySpeciality(String spc) {
		Session s = sessionfactory.getCurrentSession();
		Query<Doctor> query= s.createQuery("from Doctor where speciality=:spc",Doctor.class);
		List<Doctor> availDocs = query.setParameter("spc",spc).list();
		return availDocs;
	}
	@Override
	@Transactional
	public void deleteDoctor(Doctor theDoctor) {
		Session s = sessionfactory.getCurrentSession();
		s.delete(theDoctor);
	}
	@Override
	@Transactional
	public void saveDoctor(Doctor theDoctor) {
		Session s = sessionfactory.getCurrentSession();  
		s.saveOrUpdate(theDoctor);
	}
	@Override
	@Transactional
	public List searchDoctor(String fname, String lname, String spc, String[] Da,int id,String phneNum) {
		Session s = sessionfactory.getCurrentSession();
		
		Criteria criteria = s.createCriteria(Doctor.class);
		criteria.add(Restrictions.like("firstName", "%" + fname + "%"));
		criteria.add(Restrictions.like("lastName", "%" + lname + "%"));
		criteria.add(Restrictions.like("speciality", "%" + spc + "%"));
		criteria.add(Restrictions.like("phneNum", "%" + phneNum + "%"));
		criteria.add(Restrictions.like("id", "%" + id + "%"));
		List list = criteria.list();
		System.out.println(list);
		return list;
		
		/*Query query = s.createQuery("from Doctor where firstName like :fn or lastName like :ln or id like :id or speciality like :spc or phneNum like :phneNum");
		if(fname.equals(""))
			query.setParameter("fn","%%");
		else
			query.setParameter("fn",fname+"%");
		if(lname.equals(""))
			query.setParameter("ln","%%");
		else
			query.setParameter("ln",lname+"%");
		if(spc.equals(""))
			query.setParameter("spc","%%");
		else {
			query.setParameter("spc",spc+"%");
			System.out.println("IN");
		}
		if(id==-1) {
			query.setParameter("id","%%");
			System.out.println("IN");
		}
		else
			query.setParameter("id", id+"%");
		if(phneNum.equals("")) {
			System.out.println("IN");
			query.setParameter("phneNum","%%");
		}
		else
			query.setParameter("phneNum",phneNum+"%");*/
			
//		query.setParameter("Da",Da);
/*		List dc = query.getResultList();
		System.out.println(dc);
		return dc;*/
	}
	@Override
	@Transactional
	public List<Doctor> getAllDoctor() {
		Session s = sessionfactory.getCurrentSession();
		List<Doctor> li = s.createQuery("from Doctor").getResultList();
		return li;
	}
	

}
