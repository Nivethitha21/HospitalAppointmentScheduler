package pack.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pack.entity.docAvail;
@Repository
public class docAvailImpl implements docAvailDAO {
	@Autowired
	SessionFactory sessionfactory;
	@Override
	@Transactional
	public docAvail getDocAvail(int id) {
		Session s = sessionfactory.getCurrentSession();
		Query<docAvail> query1 = s.createQuery("from docAvail where Id=:id",docAvail.class);
		docAvail da = query1.setParameter("id",id).getSingleResult();
		return da;
	}
	@Override
	@Transactional
	public void saveDocAvail(docAvail da) {
		Session s = sessionfactory.getCurrentSession();
		s.saveOrUpdate(da);
	}
	@Override
	@Transactional
	public void clearNull() {
		Session s = sessionfactory.getCurrentSession();
		Query query = s.createQuery("delete from docAvail where doc_id=null");
		query.executeUpdate();
		
	}

}
